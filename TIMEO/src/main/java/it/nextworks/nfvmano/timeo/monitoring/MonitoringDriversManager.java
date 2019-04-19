package it.nextworks.nfvmano.timeo.monitoring;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementProviderInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreatePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryPmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryThresholdResponse;
import it.nextworks.nfvmano.timeo.monitoring.driver.DummyMonitoringDriver;
import it.nextworks.nfvmano.timeo.monitoring.driver.MonitoringAbstractDriver;
import it.nextworks.nfvmano.timeo.monitoring.driver.PrometheusMonitoringDriver;
import it.nextworks.nfvmano.timeo.monitoring.elements.MonitoringGui;
import it.nextworks.nfvmano.timeo.monitoring.interfaces.MonitoringElaborationInterface;
import it.nextworks.nfvmano.timeo.monitoring.interfaces.MonitoringGuiManagementInterface;
import it.nextworks.nfvmano.timeo.tenant.Tenant;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;

/**
 * Service that wraps the access to a specific monitoring platform. 
 * At the moment a single monitoring driver is supported. 
 * 
 * @author nextworks
 *
 */
@Service
public class MonitoringDriversManager implements PerformanceManagementProviderInterface,
MonitoringElaborationInterface, MonitoringGuiManagementInterface {

	private static final Logger log = LoggerFactory.getLogger(MonitoringDriversManager.class);
	
	@Value("${timeo.monitoring.type}")
	private String monitoringType;
	
	@Value("${timeo.monitoring.url}")
	private String monitoringUrl;
	
	@Autowired
	private VnfDbWrapper vnfDbWrapper;
	
	private MonitoringAbstractDriver monitoringDriver;
	
	public MonitoringDriversManager() {	}
	
	@PostConstruct
	public void initMonitoringDriver() {
		log.debug("Initializing monitoring driver");
		if (monitoringType.equals("DUMMY")) {
			log.debug("TIMEO is configured to operate with a DUMMY monitoring platform.");
			monitoringDriver = new DummyMonitoringDriver(monitoringUrl);
			log.debug("Dummy monitoring driver initialized");
		} else if (monitoringType.equals("PROMETHEUS")) {
			log.debug("TIMEO is configured to operate with a PROMETHEUS monitoring platform.");
			monitoringDriver = new PrometheusMonitoringDriver(monitoringUrl, vnfDbWrapper);
			log.debug("Prometheus monitoring driver initialized");
		} else {
			log.warn("Monitoring driver not configured");
		}
	}
	
	@Override
	public MonitoringGui buildMonitoringGui(List<String> pmJobIds, Tenant tenant, Map<String, String> metadata) throws MethodNotImplementedException,
			NotExistingEntityException, FailedOperationException, MalformattedElementException {
		return monitoringDriver.buildMonitoringGui(pmJobIds, tenant, metadata);
	}

	@Override
	public void removeMonitoringGui(String guiId) throws MethodNotImplementedException, NotExistingEntityException,
			FailedOperationException, MalformattedElementException {
		monitoringDriver.removeMonitoringGui(guiId);
	}

	@Override
	public String createPmJobForAggregationRule(String rule, Map<String, String> inputParameters, int collectionPeriod,
			int reportingPeriod) throws MethodNotImplementedException, FailedOperationException,
			MalformattedElementException, NotExistingEntityException {
		return monitoringDriver.createPmJobForAggregationRule(rule, inputParameters, collectionPeriod, reportingPeriod);
	}

	@Override
	public void deletePmJobForAggregationRule(List<String> pmJobIds) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		monitoringDriver.deletePmJobForAggregationRule(pmJobIds);
	}

	@Override
	public String createPmJob(CreatePmJobRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		return monitoringDriver.createPmJob(request);
	}

	@Override
	public DeletePmJobResponse deletePmJob(DeletePmJobRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		return monitoringDriver.deletePmJob(request);
	}

	@Override
	public String subscribe(SubscribeRequest request, PerformanceManagementConsumerInterface consumer)
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		return monitoringDriver.subscribe(request, consumer);
	}

	@Override
	public void unsubscribe(String subscriptionId) throws MethodNotImplementedException, MalformattedElementException,
			NotExistingEntityException, FailedOperationException {
		monitoringDriver.unsubscribe(subscriptionId);
	}

	@Override
	public QueryPmJobResponse queryPmJob(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		return monitoringDriver.queryPmJob(request);
	}

	@Override
	public String createThreshold(CreateThresholdRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		return monitoringDriver.createThreshold(request);
	}

	@Override
	public DeleteThresholdsResponse deleteThreshold(DeleteThresholdsRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		return monitoringDriver.deleteThreshold(request);
	}

	@Override
	public QueryThresholdResponse queryThreshold(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			NotExistingEntityException, MalformattedElementException, FailedOperationException {
		return monitoringDriver.queryThreshold(request);
	}

	@Override
	public void queryPerformanceMonitoringSubscription(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		monitoringDriver.queryPerformanceMonitoringSubscription(request);
	}


}
