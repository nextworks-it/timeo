package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.client.model.ContextSchema;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.*;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceNodeType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceSwitchingType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.PortType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfInstanceMetadataTest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
import it.nextworks.nfvmano.timeo.rc.algorithms.BluespaceObfnAlgorithm;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.Topology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiTopologyUtilities;
import it.nextworks.nfvmano.timeo.tapi.ValidatorAdapterFactory;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BlueSpaceObfnAlgorithmTest {


	private List<PnfInstance> pnfInstances;
	private InstantiateNsRequest instantiateNsRequest;
	private ContextSchema contextSchema;
	private List<PhysicalServer> physicalServers;
	
	@Before
	public void setup() {
		
            

		ObjectMapper mapper = new ObjectMapper();
		InputStream rrhDataStream;
		InputStream bbuDataStream;
		InputStream instantiateDataStream;
		InputStream contextStream = BlueSpaceObfnAlgorithmTest.class.getResourceAsStream("/retrieved-obfn-context.json");
		try {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.setPrettyPrinting();
			gsonBuilder.registerTypeAdapterFactory(new ValidatorAdapterFactory());

			PhysicalServer cn = new PhysicalServer("server-id", 16, 16, 200000, 0, 0, "CPU_LEVEL", "GPU_LEVEL",0,0,0,0,0);


			physicalServers= new ArrayList<>();
			physicalServers.add(cn);

			contextSchema = gsonBuilder.create().fromJson(new InputStreamReader(contextStream), ContextSchema.class);
			rrhDataStream = PnfInstanceMetadataTest.class.getClassLoader()
						.getResource("bluespace_rrh.json")
				        .openStream();
			bbuDataStream = PnfInstanceMetadataTest.class.getClassLoader()
					.getResource("bluespace_bbu.json")
			        .openStream();

			instantiateDataStream = BlueSpaceObfnAlgorithmTest.class.getClassLoader()
					.getResource("instantiate_ns_obfn.json")
					.openStream();
			instantiateNsRequest = mapper.readValue(instantiateDataStream, InstantiateNsRequest.class);
			ArrayList<PnfInstance> pnfs = new ArrayList<PnfInstance>();
			pnfs.add(mapper.readValue(rrhDataStream, new TypeReference<PnfInstance>() {}));
			pnfs.add(mapper.readValue(bbuDataStream, new TypeReference<PnfInstance>() {}));
			pnfInstances = pnfs;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	
	@Test
	public void testBluespaceObfnAlgorithm() {
		System.out.println("*************************************** Test bluespace external algorithm ********************************************");
		try {
			NetworkTopology networkTopology = TapiTopologyUtilities.translateTapiTopology(contextSchema.getTopologyContext().getTopology().get(0), contextSchema);
			Map<Vnfd, Map<String, String>> vnfds = new HashMap<>();
			BluespaceAlgorithmAllocationRequest request = BluespaceObfnAlgorithm.buildBluespaceRcRequest(instantiateNsRequest, vnfds, pnfInstances, physicalServers, networkTopology );
			ObjectMapper mapper = new ObjectMapper();
			String requestStr = mapper.writeValueAsString(request);
			System.out.println(requestStr);
		} catch (NotExistingEntityException e) {
			e.printStackTrace();
		} catch (FailedOperationException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


	}
	


}
