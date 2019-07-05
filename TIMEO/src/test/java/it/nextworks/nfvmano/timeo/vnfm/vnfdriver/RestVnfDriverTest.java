package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.core.task.TaskExecutor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Marco Capitani on 05/07/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class RestVnfDriverTest {

    private RestVnfDriver driver;

    private TaskExecutor executor;

    private VnfRestClient restClient;

    private ThreadPoolExecutor queue;

    private GeneralizedQueryRequest getRequest() {
        return new GeneralizedQueryRequest(null, null);
    }

    private void assertEq(GetIndicatorValueResponse one, GetIndicatorValueResponse other) {
        assertEquals(one.getIndicatorInformation().size(), other.getIndicatorInformation().size());
        for (int i = 0; i < one.getIndicatorInformation().size(); i++) {
            IndicatorInformation oneInd = one.getIndicatorInformation().get(i);
            IndicatorInformation othInd = other.getIndicatorInformation().get(i);
            assertEquals(oneInd.getIndicatorId(), othInd.getIndicatorId());
            assertEquals(oneInd.getIndicatorName(), othInd.getIndicatorName());
            assertEquals(oneInd.getIndicatorValue(), othInd.getIndicatorValue());
            assertEquals(oneInd.getVnfInstanceId(), othInd.getVnfInstanceId());
        }
    }

    @Before
    public void setUp() {
        executor = mock(TaskExecutor.class);
        restClient = mock(VnfRestClient.class);
        driver = new RestVnfDriver("vnfi", executor, restClient);
        queue = new ThreadPoolExecutor(
                2,
                2,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );
    }

    @After
    public void tearDown() {
        queue.shutdownNow();
        queue = null;
    }

    @Test
    public void testSync() throws Exception {
        List<IndicatorInformation> inds = new ArrayList<>();
        int n = new Random().nextInt() % 50;
        for (int i = 0; i < n; i++) {
            inds.add(new IndicatorInformation(
                    "vnfi",
                    "indicator" + i,
                    String.valueOf(new Random().nextFloat()),
                    "indicator" + i
            ));
        }
        GetIndicatorValueResponse response = new GetIndicatorValueResponse(inds);
        Answer<Void> ans = invocation -> {
            VnfGetIndicatorTask task = invocation.getArgumentAt(0, VnfGetIndicatorTask.class);
            task.result = response;
            driver.accept(task);
            return null;
        };
        doAnswer(ans).when(executor).execute(any(Runnable.class));
        Instant start = Instant.now();
        GetIndicatorValueResponse indicatorValue = driver.getIndicatorValue(getRequest());
        Instant end = Instant.now();
        assertTrue(end.isBefore(start.plusMillis(1500)));
        assertEq(response, indicatorValue);
    }


    @Test
    public void testDelaySync() throws Exception {
        List<IndicatorInformation> inds = new ArrayList<>();
        int n = new Random().nextInt() % 50;
        for (int i = 0; i < n; i++) {
            inds.add(new IndicatorInformation(
                    "vnfi",
                    "indicator" + i,
                    String.valueOf(new Random().nextFloat()),
                    "indicator" + i
            ));
        }
        GetIndicatorValueResponse response = new GetIndicatorValueResponse(inds);
        Answer<Void> ans = invocation -> {
            VnfGetIndicatorTask task = invocation.getArgumentAt(0, VnfGetIndicatorTask.class);
            queue.execute(() -> {
                try {
                    Thread.sleep(550);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                task.result = response;
                driver.accept(task);
            });
            return null;
        };
        doAnswer(ans).when(executor).execute(any(Runnable.class));
        Instant start = Instant.now();
        GetIndicatorValueResponse indicatorValue = driver.getIndicatorValue(getRequest());
        Instant end = Instant.now();
        assertTrue(end.isAfter(start.plusMillis(549)));
        assertTrue(end.isBefore(start.plusMillis(1500)));
        assertEq(response, indicatorValue);
    }

    @Test
    public void testAsync() throws Exception {
        List<IndicatorInformation> inds = new ArrayList<>();
        int n = new Random().nextInt() % 50;
        for (int i = 0; i < n; i++) {
            inds.add(new IndicatorInformation(
                    "vnfi",
                    "indicator" + i,
                    String.valueOf(new Random().nextFloat()),
                    "indicator" + i
            ));
        }
        GetIndicatorValueResponse response = new GetIndicatorValueResponse(inds);
        Answer<Void> ans = invocation -> {
            VnfGetIndicatorTask task = invocation.getArgumentAt(0, VnfGetIndicatorTask.class);
            task.result = response;
            driver.accept(task);
            return null;
        };
        doAnswer(ans).when(executor).execute(any(Runnable.class));
        Instant start = Instant.now();
        @SuppressWarnings("unchecked")
        Consumer<GetIndicatorValueResponse> listener = mock(Consumer.class);
        driver.getIndicatorValueAsync(getRequest(), listener);
        verify(listener).accept(response);
    }
}