package it.nextworks.nfvmano.timeo.monitoring.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.TimeoApplication;
import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.ThresholdCrossedNotification;
import it.nextworks.nfvmano.timeo.monitoring.MonitoringAlertDispatcher;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusAlert;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusAlertMessage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Marco Capitani on 21/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class PromAlertRestControllerTest {

    private PromAlertRestController ctrl;

    private MonitoringAlertDispatcher dispatcher;

    private ObjectMapper mapper;

    {
        mapper = new TimeoApplication().objectMapper();
    }

    @Before
    public void setup() {
        // Reset the controller before each test
        dispatcher = mock(MonitoringAlertDispatcher.class);
        ctrl = new PromAlertRestController(dispatcher, mapper);
    }

    @Test
    public void testNotifyBase() throws Exception {
        String alert = "{\"alerts\":[{\"labels\":{\"alertname\":\"0e921992-fc70-4dd6-8675-a92c365e62d3\"," +
                "\"severity\":\"error\",\"user_label\":\"ar1\"},\"startsAt\":\"2019-01-10T13:16:06.658232+02:00\"," +
                "\"status\":\"firing\"}],\"receiver\":\"web-notf\",\"version\":\"4\"}";
        ctrl.notify(mapper.readValue(alert, PrometheusAlertMessage.class));
        ArgumentCaptor<ThresholdCrossedNotification> captor =
                ArgumentCaptor.forClass(ThresholdCrossedNotification.class);
        verify(dispatcher).notify(captor.capture());
        ThresholdCrossedNotification output = captor.getValue();
        assertEquals("0e921992-fc70-4dd6-8675-a92c365e62d3", output.getThresholdId());
        assertEquals(ThresholdCrossingDirection.UP, output.getCrossingDirection());
    }

    @Test
    public void testNotify2() throws Exception {
        String alert = "{\"alerts\":[{\"labels\":{\"alertname\":\"0e921992-fc70-4dd6-8675-a92c365e62d3\"," +
                "\"severity\":\"error\",\"user_label\":\"ar1\"},\"startsAt\":\"2019-06-24T15:27:48.949435+02:00\"," +
                "\"status\":\"firing\"}],\"receiver\":\"web-notf\",\"version\":\"4\"}";
        ctrl.notify(mapper.readValue(alert, PrometheusAlertMessage.class));
        ArgumentCaptor<ThresholdCrossedNotification> captor =
                ArgumentCaptor.forClass(ThresholdCrossedNotification.class);
        verify(dispatcher).notify(captor.capture());
        ThresholdCrossedNotification output = captor.getValue();
        assertEquals("0e921992-fc70-4dd6-8675-a92c365e62d3", output.getThresholdId());
        assertEquals(ThresholdCrossingDirection.UP, output.getCrossingDirection());
    }

    @Test
    public void testNotify3() throws Exception {
        String alert = "{\"receiver\":\"532d3b1c-cd73-4c5a-9e8d-b1dadf53d0d4\",\"status\":\"firing\",\"alerts\":[{\"status\":\"firing\",\"labels\":{\"alertName\":\"42635c2b-c910-4530-b7c4-feb7e0234f74\",\"alertname\":\"1ca6da27-5dda-42b9-9d02-afc0b46c4433\",\"host\":\"vcacheedge-1478\",\"instance\":\"10.20.6.162:9273\",\"job\":\"8beeaa7b-6351-445e-aad8-84654cff09f1\",\"nsId\":\"452\",\"severity\":\"warning\",\"vnfdId\":\"vCacheEdge_1_01\"},\"annotations\":{},\"startsAt\":\"2019-06-25T09:54:08.949435+02:00\",\"endsAt\":\"0001-01-01T00:00:00Z\",\"generatorURL\":\"http://manostack-bluesspace:9090/graph?g0.expr=trafficserver_stats_http_current_client_connections%7Bjob%3D%228beeaa7b-6351-445e-aad8-84654cff09f1%22%7D+%3E+3\\u0026g0.tab=1\"}],\"groupLabels\":{\"alertname\":\"1ca6da27-5dda-42b9-9d02-afc0b46c4433\"},\"commonLabels\":{\"alertName\":\"42635c2b-c910-4530-b7c4-feb7e0234f74\",\"alertname\":\"1ca6da27-5dda-42b9-9d02-afc0b46c4433\",\"host\":\"vcacheedge-1478\",\"instance\":\"10.20.6.162:9273\",\"job\":\"8beeaa7b-6351-445e-aad8-84654cff09f1\",\"nsId\":\"452\",\"severity\":\"warning\",\"vnfdId\":\"vCacheEdge_1_01\"},\"commonAnnotations\":{},\"externalURL\":\"http://manostack-bluesspace:9093\",\"version\":\"4\",\"groupKey\":\"{}/{alertname=\\\"1ca6da27-5dda-42b9-9d02-afc0b46c4433\\\"}:{alertname=\\\"1ca6da27-5dda-42b9-9d02-afc0b46c4433\\\"}\"}\n";
        ctrl.notify(mapper.readValue(alert, PrometheusAlertMessage.class));
        ArgumentCaptor<ThresholdCrossedNotification> captor =
                ArgumentCaptor.forClass(ThresholdCrossedNotification.class);
        verify(dispatcher).notify(captor.capture());
        ThresholdCrossedNotification output = captor.getValue();
        assertEquals("1ca6da27-5dda-42b9-9d02-afc0b46c4433", output.getThresholdId());
        assertEquals(ThresholdCrossingDirection.UP, output.getCrossingDirection());
    }

    @Test
    public void testNotifyResolved() throws Exception {
        String alert = "{\"alerts\":[{\"labels\":{\"alertname\":\"0e921992-fc70-4dd6-8675-a92c365e62d3\"}," +
                "\"status\":\"resolved\"}]}";
        ctrl.notify(mapper.readValue(alert, PrometheusAlertMessage.class));
        ArgumentCaptor<ThresholdCrossedNotification> captor =
                ArgumentCaptor.forClass(ThresholdCrossedNotification.class);
        verify(dispatcher).notify(captor.capture());
        ThresholdCrossedNotification output = captor.getValue();
        assertEquals("0e921992-fc70-4dd6-8675-a92c365e62d3", output.getThresholdId());
        assertEquals(ThresholdCrossingDirection.DOWN, output.getCrossingDirection());
    }

    @Test
    public void testMultiAlert() throws Exception {
        String alert = "{\"alerts\":[" +
                "{\"labels\":{\"alertname\":\"123123\"},\"status\":\"firing\"}," +
                "{\"labels\":{\"alertname\":\"asdasd\"},\"status\":\"resolved\"}" +
                "]}";
        ctrl.notify(mapper.readValue(alert, PrometheusAlertMessage.class));
        ArgumentCaptor<ThresholdCrossedNotification> captor =
                ArgumentCaptor.forClass(ThresholdCrossedNotification.class);
        verify(dispatcher, times(2)).notify(captor.capture());
        List<ThresholdCrossedNotification> outputs = captor.getAllValues();
        ThresholdCrossedNotification out1 = outputs.get(0);
        assertEquals("123123", out1.getThresholdId());
        assertEquals(ThresholdCrossingDirection.UP, out1.getCrossingDirection());
        ThresholdCrossedNotification out2 = outputs.get(1);
        assertEquals("asdasd", out2.getThresholdId());
        assertEquals(ThresholdCrossingDirection.DOWN, out2.getCrossingDirection());
    }
}