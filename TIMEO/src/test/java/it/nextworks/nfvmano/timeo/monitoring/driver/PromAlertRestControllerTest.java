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