package it.nextworks.nfvmano.timeo.monitoring;

import it.nextworks.nfvmano.libs.common.elements.MonitoringParameter;
import it.nextworks.nfvmano.libs.common.enums.RelationalOperation;
import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.common.enums.ThresholdType;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.descriptors.nsd.AutoscalingAction;
import it.nextworks.nfvmano.libs.descriptors.nsd.AutoscalingRuleCriteria;
import it.nextworks.nfvmano.libs.descriptors.nsd.MonitoredData;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsAutoscalingRule;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.PerformanceInformationAvailableNotification;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.ThresholdCrossedNotification;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.ScaleNsData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusTDetails;
import it.nextworks.nfvmano.timeo.monitoring.elements.AutoScalingRulesWrapper;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Marco Capitani on 19/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class NsAlertManager implements PerformanceManagementConsumerInterface {

    private static Logger log = LoggerFactory.getLogger(NsAlertManager.class);

    private NsManagementEngine engine;

    private String nsiId;

    private AutoScalingRulesWrapper wrapper;

    private Map<String, String> thresholdId2criterionId = new HashMap<>();

    private MonitoringDriversManager driver;

    private List<MonitoredData> monitoredData;

    MonitoringAlertDispatcher dispatcher;

    public NsAlertManager(
            NsManagementEngine engine,
            String nsiId,
            List<MonitoredData> monitoredData,
            List<NsAutoscalingRule> rules,
            MonitoringDriversManager driver,
            MonitoringAlertDispatcher dispatcher
    ) {
        if (null == rules) {
            throw new NullPointerException("rules must not be null.");
        }
        this.engine = engine;
        this.nsiId = nsiId;
        this.wrapper = new AutoScalingRulesWrapper(rules);
        this.driver = driver;
        this.monitoredData = monitoredData;
        this.dispatcher = dispatcher;
    }

    @Override
    public void notify(PerformanceInformationAvailableNotification notification) {
        log.error("PerformanceInformationAvailableNotification not supported.");
    }

    @Override
    public void notify(ThresholdCrossedNotification notification) {
        ScaleNsRequest request;
        try {
            Optional<ScaleNsRequest> optRequest = makeRequest(notification);
            if (!optRequest.isPresent()) {
                log.debug("No action triggered");
                return;
            } else {
                request = optRequest.get();
            }
        } catch (Exception e) {
            log.error("Could not build scaling request, aborting");
            log.debug("Details: ", e);
            return;
        }
        try {
            engine.scaleNetworkService(request);
        } catch (Exception e) {
            log.error("Could not request scaling, aborting");
            log.debug("Details: ", e);
        }
    }

    public Optional<ScaleNsRequest> makeRequest(ThresholdCrossedNotification notification) {
        String thresholdId = notification.getThresholdId();
        String criterionId = thresholdId2criterionId.get(thresholdId);
        if (criterionId == null) {
            throw new IllegalArgumentException(String.format(
                    "No threshold with id %s registered at this manager",
                    thresholdId
            ));
        }
        if (notification.getCrossingDirection().equals(ThresholdCrossingDirection.DOWN)) {
            // "Resolved" alert
            wrapper.stopFiring(criterionId);
            return Optional.empty();
        }
        // else: "firing" alert
        List<AutoscalingAction> actions = wrapper.fireCriterion(criterionId);
        if (actions.isEmpty()) {
            return Optional.empty();
        }
        if (actions.size() > 1) {
            throw new IllegalArgumentException("More than one auto-scaling action not supported.");
        }
        AutoscalingAction action = actions.get(0);
        return Optional.of(new ScaleNsRequest(
                nsiId,
                action.getScaleType(),
                new ScaleNsData(
                        null,
                        null,
                        null,
                        action.getScaleNsToLevelData(),
                        null,
                        null,
                        null
                ),
                null,
                null
        ));
    }

    @Override
    public String toString() {
        return String.format("Alert listener for NSI ID %s", nsiId);
    }

    private PrometheusTDetails makeDetails(Map.Entry<AutoscalingRuleCriteria, Integer> entry, String pmJobId) {
        AutoscalingRuleCriteria criterion = entry.getKey();
        Integer thresholdTime = entry.getValue();
        RelationalOperation rel;
        int value;
        if (criterion.getScaleOutRelationalOperation() != null) {
            if (criterion.getScaleOutThreshold() == null || criterion.getScaleInRelationalOperation() != null) {
                throw new IllegalArgumentException(String.format("Malformed criterion %s", criterion.getName()));
            }
            rel = criterion.getScaleOutRelationalOperation();
            value = criterion.getScaleOutThreshold();
        } else {
            if (criterion.getScaleInThreshold() == null) {
                throw new IllegalArgumentException(String.format("Malformed criterion %s", criterion.getName()));
            }
            rel = criterion.getScaleInRelationalOperation();
            value = criterion.getScaleInThreshold();
        }
        return new PrometheusTDetails(
                value,
                rel,
                thresholdTime,
                pmJobId
        );
    }

    void createThresholds(Map<String, String> mp2job)
            throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
        log.info("Creating thresholds for NSI {}", nsiId);
        for (Map.Entry<AutoscalingRuleCriteria, Integer> entry : wrapper.getCriteriaAndThresholdTimes().entrySet()) {
            AutoscalingRuleCriteria criterion = entry.getKey();
            log.debug("Creating threshold for criterion {}", criterion.getName());
            String mpId = criterion.getNsMonitoringParamRef();
            Optional<String> optMetric = monitoredData.stream()
                    .filter(mi -> mi.getMonitoringParameter() != null)
                    .map(MonitoredData::getMonitoringParameter)
                    .filter(mp -> mp.getMonitoringParameterId().equals(mpId))
                    .map(MonitoringParameter::getPerformanceMetric)
                    .findAny();
            if (!optMetric.isPresent()) {
                log.warn(
                        "Monitoring parameter {} not available for nsi {}, aborting threshold",
                        mpId,
                        nsiId
                );
                continue;
            }
            String metric = optMetric.get().split("\\.")[0];
            CreateThresholdRequest request = new CreateThresholdRequest(
                    null,
                    null,
                    null,
                    metric,
                    ThresholdType.SINGLE_VALUE,
                    makeDetails(entry, mp2job.get(mpId))
            );
            String thresholdId = driver.createThreshold(request);
            log.debug("Criterion {} is assigned threshold {}", criterion.getName(), thresholdId);
            thresholdId2criterionId.put(thresholdId, criterion.getName());
            dispatcher.register(thresholdId, this);
        }
        log.info("Threshold creation successful");
    }

    void deleteThresholds() {
        log.info("Stopping thresholds for NSI {}", nsiId);
        DeleteThresholdsRequest request = new DeleteThresholdsRequest(
                new ArrayList<>(thresholdId2criterionId.keySet())
        );
        DeleteThresholdsResponse response;
        try {
            response = driver.deleteThreshold(request);
        } catch (Exception exc) {
            log.error("Could not delete thresholds");
            log.debug("Details:", exc);
            return;
        }
        log.info("Deleted the following thresholds: {}", response.getDeletedThresholdId());
        response.getDeletedThresholdId().forEach(thresholdId2criterionId::remove);
    }
}
