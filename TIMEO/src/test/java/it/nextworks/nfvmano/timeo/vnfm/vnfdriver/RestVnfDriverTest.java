package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

/**
 * Created by Marco Capitani on 05/07/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class RestVnfDriverTest {

    private RestVnfDriver driver;

    private TaskExecutor executor;

    private VnfRestClient restClient;

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
            return null;
        };
        doAnswer(ans).when(executor).execute(any(Runnable.class));
        GetIndicatorValueResponse indicatorValue = driver.getIndicatorValue(getRequest());
        assertEq(response, indicatorValue);
    }
}