package it.nextworks.nfvmano.timeo.monitoring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.libs.common.enums.NsScaleType;
import it.nextworks.nfvmano.libs.common.enums.RelationalOperation;
import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.descriptors.nsd.MonitoredData;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsAutoscalingRule;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.ThresholdCrossedNotification;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.ScaleNsData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusTDetails;
import it.nextworks.nfvmano.timeo.monitoring.elements.AutoScalingRulesWrapperTest;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Marco Capitani on 21/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class NsAlertManagerTest {

    private NsManagementEngine engine;

    private MonitoringDriversManager driver;

    private NsAlertManager alertManager;

    @Before
    public void setup() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream rulesStream = AutoScalingRulesWrapperTest.class.getClassLoader()
                .getResource("amrulestest.json")
                .openStream();
        InputStream monDataStream = AutoScalingRulesWrapperTest.class.getClassLoader()
                .getResource("ammondatatest.json")
                .openStream();
        List<NsAutoscalingRule> rules = mapper.readValue(rulesStream, new TypeReference<List<NsAutoscalingRule>>() {});
        List<MonitoredData> monData = mapper.readValue(monDataStream, new TypeReference<List<MonitoredData>>() {});
        engine = mock(NsManagementEngine.class);
        driver = mock(MonitoringDriversManager.class);
        alertManager = new NsAlertManager(
                engine,
                "test-nsiId",
                monData,
                rules,
                driver
        );
    }

    @Test
    public void testEarlyNotify() throws Exception {
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "not-found",
                ThresholdCrossingDirection.UP,
                null,
                null,
                0
        );
        alertManager.notify(notf);
        verify(engine, never()).scaleNetworkService(any());
    }

    @Test
    public void testCreateThreshold() throws Exception {
        Map<String, String> mp2job = new HashMap<>();
        mp2job.put("mp1", "mp1-job");
        mp2job.put("mp2", "mp2-job");
        alertManager.createThresholds(mp2job);

        verify(engine, never()).scaleNetworkService(any());

        ArgumentCaptor<CreateThresholdRequest> captor = ArgumentCaptor.forClass(CreateThresholdRequest.class);
        verify(driver).createThreshold(captor.capture());
        CreateThresholdRequest request = captor.getValue();

        assertEquals("VcpuUsageMean.spr2", request.getPerformanceMetric());
        assertTrue(request.getThresholdDetails() instanceof PrometheusTDetails);
        PrometheusTDetails promDet = (PrometheusTDetails) request.getThresholdDetails();

        assertEquals(75, promDet.getValue(), 0.0000001);
        assertEquals(RelationalOperation.GT, promDet.getRelationalOperation());
        assertEquals(2, promDet.getThresholdTime());
        assertEquals("mp1-job", promDet.getPmJobId());
    }


    @Test
    public void testNotify() throws Exception {
        Map<String, String> mp2job = new HashMap<>();
        mp2job.put("mp1", "mp1-job");
        mp2job.put("mp2", "mp2-job");
        when(driver.createThreshold(any())).thenReturn("threshold1", "threshold2");
        alertManager.createThresholds(mp2job);
        ThresholdCrossedNotification not = new ThresholdCrossedNotification(
                "threshold1",
                ThresholdCrossingDirection.UP,
                null,
                null,
                0
        );
        alertManager.notify(not);

        ArgumentCaptor<ScaleNsRequest> captor = ArgumentCaptor.forClass(ScaleNsRequest.class);
        verify(engine).scaleNetworkService(captor.capture());
        ScaleNsRequest request = captor.getValue();
        assertEquals("test-nsiId", request.getNsInstanceId());
        assertEquals(NsScaleType.SCALE_NS, request.getScaleType());

        String target = request.getScaleNsData().getScaleNsToLevelData().getNsInstantiationLevel();
        assertEquals("il_vCDN_big", target);
    }
}