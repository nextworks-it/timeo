package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import it.nextworks.nfvmano.libs.common.elements.KeyValuePair;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements.VnfConfiguration;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Marco Capitani on 09/07/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class VnfRestClientTest {

    private VnfRestClient client;

    private RestTemplate restTemplate;

    private ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();

    @Before
    public void setUp() {
        restTemplate = mock(RestTemplate.class);
        client = new VnfRestClient(restTemplate, "42.42.42.42");
    }

    @Test
    public void testConfig() throws Exception {
        VnfConfiguration config = new VnfConfiguration(
                Collections.emptyList(),
                "10.0.1.51",
                new KeyValuePair("param1", "val1"),
                new KeyValuePair("param2", "val2"),
                new KeyValuePair("param3", "val3")

        );
        SetConfigurationRequest request = new SetConfigurationRequest(
                "vnfi_id",
                config,
                Collections.emptyList()
        );
        when(restTemplate.exchange(
                any(),
                any(),
                any(),
                eq(SetConfigurationResponse.class),
                Matchers.<Object>anyVararg()
        )).thenAnswer(
                invocationOnMock -> {
                    String s = writer.writeValueAsString(((HttpEntity<SetConfigurationRequest>) invocationOnMock.getArguments()[2]).getBody());
                    System.out.println(s);
                    return new ResponseEntity<>(
                            new SetConfigurationResponse(
                                    config,
                                    Collections.emptyList()
                            ),
                            HttpStatus.OK
                    );
                }
        );
        client.setConfiguration(request);
        verify(restTemplate).exchange(
                any(),
                any(),
                any(),
                eq(SetConfigurationResponse.class),
                Matchers.<Object>anyVararg()
        );
        assertTrue(true);
    }

    @Test
    public void testIndicator() throws Exception {
        VnfConfiguration config = new VnfConfiguration(
                Collections.emptyList(),
                "10.0.1.51",
                new KeyValuePair("param1", "val1"),
                new KeyValuePair("param2", "val2"),
                new KeyValuePair("param3", "val3")
        );
        GeneralizedQueryRequest request = new GeneralizedQueryRequest(
                null,
                Collections.emptyList()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        when(restTemplate.exchange(
                any(),
                any(),
                any(),
                eq(GetIndicatorValueResponse.class),
                Matchers.<Object>anyVararg()
        )).thenAnswer(
                invocationOnMock -> {
                    String s = writer.writeValueAsString(((HttpEntity<GeneralizedQueryRequest>) invocationOnMock.getArguments()[2]).getBody());
                    System.out.println(s);
                    return new ResponseEntity<>(
                            new GetIndicatorValueResponse(
                                    Collections.emptyList()
                            ),
                            HttpStatus.OK);
                }
        );
        client.getIndicatorValue(request);
        verify(restTemplate).exchange(
                any(),
                any(),
                any(),
                eq(GetIndicatorValueResponse.class),
                Matchers.<Object>anyVararg()
        );
        assertTrue(true);
    }
}