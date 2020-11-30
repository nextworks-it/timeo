import com.fasterxml.jackson.databind.ObjectMapper;
import it.nextworks.nfvmano.bluespace.algorithm.BluespaceAlgorithmService;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestBluespaceSampleAlgorithm {

    @Test
    public  void testBluespaceSampleAlgorithm(){

        InputStream requestStream = TestBluespaceSampleAlgorithm.class.getResourceAsStream("/example-request.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            BluespaceAlgorithmAllocationRequest request = mapper.readValue(new InputStreamReader(requestStream), BluespaceAlgorithmAllocationRequest.class);
            BluespaceAlgorithmAllocationResponse response = BluespaceAlgorithmService.buildSampleResponse(request);
            String responseStr = mapper.writeValueAsString(response);
            System.out.println(responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
