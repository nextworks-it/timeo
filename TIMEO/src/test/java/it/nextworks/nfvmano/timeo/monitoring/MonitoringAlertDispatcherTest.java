package it.nextworks.nfvmano.timeo.monitoring;

import it.nextworks.nfvmano.libs.common.enums.ThresholdCrossingDirection;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.ThresholdCrossedNotification;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Marco Capitani on 19/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class MonitoringAlertDispatcherTest {

    private MonitoringAlertDispatcher dispatcher;

    @Before
    public void setup() {
        dispatcher = new MonitoringAlertDispatcher();
    }

    @Test
    public void notify_correct() {
        PerformanceManagementConsumerInterface listener = mock(PerformanceManagementConsumerInterface.class);
        dispatcher.register("id", listener);
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "id",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        dispatcher.notify(notf);
        verify(listener, times(1)).notify(notf);
    }

    @Test
    public void notify_different_listeners() {
        PerformanceManagementConsumerInterface listener = mock(PerformanceManagementConsumerInterface.class);
        PerformanceManagementConsumerInterface listener2 = mock(PerformanceManagementConsumerInterface.class);
        dispatcher.register("id", listener);
        dispatcher.register("id2", listener2);
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "id",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        ThresholdCrossedNotification notf2 = new ThresholdCrossedNotification(
                "id2",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        dispatcher.notify(notf);
        dispatcher.notify(notf2);
        verify(listener, times(1)).notify(notf);
        verify(listener2, times(1)).notify(notf2);
    }

    @Test
    public void notify_wrong_id() {
        PerformanceManagementConsumerInterface listener = mock(PerformanceManagementConsumerInterface.class);
        dispatcher.register("id", listener);
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "differentId",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        dispatcher.notify(notf);
        verify(listener, times(0)).notify(any(ThresholdCrossedNotification.class));
    }

    @Test
    public void notify_multiple() {
        PerformanceManagementConsumerInterface listener = mock(PerformanceManagementConsumerInterface.class);
        dispatcher.register("id", listener);
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "id",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        dispatcher.notify(notf);
        dispatcher.notify(notf);
        verify(listener, times(2)).notify(notf);
        dispatcher.deregister("id");
    }

    @Test()
    public void register_deregister() {
        PerformanceManagementConsumerInterface listener = mock(PerformanceManagementConsumerInterface.class);
        dispatcher.register("id", listener);
        ThresholdCrossedNotification notf = new ThresholdCrossedNotification(
                "id",
                ThresholdCrossingDirection.UP,
                "object",
                "metric",
                12
        );
        dispatcher.notify(notf);
        verify(listener, times(1)).notify(notf);
        dispatcher.deregister("id");
        dispatcher.notify(notf);
        verify(listener, times(1)).notify(any(ThresholdCrossedNotification.class));
        // I.e. it has not been called again, since the listener has been de-registered
    }
}