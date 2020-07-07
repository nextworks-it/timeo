package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import static org.mockito.Mockito.mock;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.BluespaceNode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.BluespaceNodePort;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.GeographicalArea;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.PhysicalServer;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.Rrh;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.RrhBeam;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.Subchannel;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.VmRequirements;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceNodeType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceSwitchingType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.PortType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfInstanceMetadataTest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class BlueSpaceAitAlgorithmTest {

	private AitAlgorithmRestClient client;
	private List<PnfInstance> pnfInstances;
	private ThreadPoolExecutor executorService;
	private RestTemplate restTemplate = new RestTemplate();
	private BluespaceAlgorithmAllocationRequest request;

	@Autowired
	private TaskExecutor taskExecutor;
	
	
	@Before
	public void setup() {
		
            
		createExecutorService();
		String algoUrl = "http://localhost:8088/bluespace/algorithm";
		client = new AitAlgorithmRestClient(algoUrl, restTemplate);
		ObjectMapper mapper = new ObjectMapper();
		InputStream rrhDataStream;
		InputStream bbuDataStream;
		try {
			rrhDataStream = PnfInstanceMetadataTest.class.getClassLoader()
						.getResource("bluespace_rrh.json")
				        .openStream();
			bbuDataStream = PnfInstanceMetadataTest.class.getClassLoader()
					.getResource("bluespace_bbu.json")
			        .openStream();
			InputStream  raRequestStream = BlueSpaceAitAlgorithmTest.class.getClassLoader()
					.getResource("example-bluespace-ra-request.json")
					.openStream();
			ArrayList<PnfInstance> pnfs = new ArrayList<PnfInstance>();
			pnfs.add(mapper.readValue(rrhDataStream, new TypeReference<PnfInstance>() {}));
			pnfs.add(mapper.readValue(bbuDataStream, new TypeReference<PnfInstance>() {}));
			pnfInstances = pnfs;
			request =mapper.readValue(raRequestStream, new TypeReference<BluespaceAlgorithmAllocationRequest>(){});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void  createExecutorService() {
		 executorService = new ThreadPoolExecutor  ( 2,
	                2,
	                1,
	                TimeUnit.SECONDS,
	                new ArrayBlockingQueue<>(5)
	                );
	}
	
	@Test
	public void testAlgorithm() {
		System.out.println("*************************************** Test bluespace external algorithm ********************************************");

		
		try {
			BluespaceAlgorithmAllocationResponse response = client.computeAllocation(request);
			Gson gson = new Gson();
			System.out.println(gson.toJson(response));
		} catch (Exception e) {
			System.out.println("Received exception when interacting with the algorithm: " + e.getMessage());
		}
	}
	
	private BluespaceAlgorithmAllocationRequest prepareRequestFromScratch() {
		List<ServiceRequest> serviceRequests = new ArrayList<ServiceRequest>();
		List<String> serviceAreaId = new ArrayList<>();
		serviceAreaId.add("1");
		Map<String, VmRequirements> vmRequirements = new HashMap<>();
		VmRequirements vmr = new VmRequirements(2, 
				1024, 
				3, 
				0, 
				0, 
				null, 
				null);
		vmRequirements.put("vm01", vmr);
		ServiceRequest sr = new ServiceRequest("serviceID", 
				serviceAreaId, 
				TransmissionMode.M1, 
				vmRequirements);
		serviceRequests.add(sr);
		
		List<GeographicalArea> geographicalAreas = new ArrayList<>();
		for (int i = 1; i<6; i++) {
			GeographicalArea a = new GeographicalArea(String.valueOf(i));
			geographicalAreas.add(a);
		}
		
		Map<TransmissionMode, Double> datarate = buildDatarate();
		
		List<Rrh> rrhs = new ArrayList<Rrh>();
		List<BluespaceNode> nodes = new ArrayList<BluespaceNode>();
		for(PnfInstance pnfInstance : pnfInstances) {
			if(pnfInstance.getPnfType().equals(PnfType.RRH)) {
				List<RrhBeam> beams = new ArrayList<RrhBeam>();
				List<Subchannel> subchannels = new ArrayList<Subchannel>();
				Subchannel subchannel1 = new Subchannel("Subchannel-01", 2, 240, true, TransmissionMode.M2, null);
				subchannels.add(subchannel1);
				Subchannel subchannel2 = new Subchannel("Subchannel-02", 2, 240, false, TransmissionMode.M2, null);
				subchannels.add(subchannel2);
				GeographicalArea geographicalArea = new GeographicalArea("1");
				RrhBeam beam = new RrhBeam("BEAM-1", 760.32f, subchannels, geographicalArea, null, false);
				beams.add(beam);
				Rrh rrh = new Rrh(pnfInstance.getPnfInstanceId(), beams);
				List<IndicatorInformation> rrhInfo = getPnfInstanceIndicators(pnfInstance);
				
				rrhs.add(rrh);
			}else if(pnfInstance.getPnfType().equals(PnfType.BBU)) {
				List<IndicatorInformation> bbuInfo = getPnfInstanceIndicators(pnfInstance);
			}
		}
		
		
		List<BluespaceNodePort> portsRrh = new ArrayList<BluespaceNodePort>();
		BluespaceNodePort portRrh = new BluespaceNodePort("rrh1-P1", PortType.EGRESS, "bbu1", "bbu1-P1", null, null);
		portsRrh.add(portRrh);
		BluespaceNode bn1 = new BluespaceNode("RRH-1", BluespaceNodeType.RRH, BluespaceSwitchingType.NO_SWITCHING, portsRrh);
		nodes.add(bn1);
		List<BluespaceNodePort> portsBbu = new ArrayList<BluespaceNodePort>();
		BluespaceNodePort portBbu = new BluespaceNodePort("bbu1-P1", PortType.INGRESS, "RRH-1", "rrh1-P1", null, null);
		portsBbu.add(portBbu);
		BluespaceNode bn2 = new BluespaceNode("BBU-1", BluespaceNodeType.BBU, BluespaceSwitchingType.NO_SWITCHING, portsBbu, "RRH-1", "BEAM-1");
		nodes.add(bn2);
		
		List<PhysicalServer> servers = new ArrayList<PhysicalServer>();
		PhysicalServer server = new PhysicalServer("S1", 
				20, 
				8096, 
				100, 
				1000, 
				0, 
				null, 
				null, 
				2, 
				2048, 
				40, 
				400, 
				0);
		servers.add(server);
		
		BluespaceAlgorithmAllocationRequest request = new BluespaceAlgorithmAllocationRequest(
				serviceRequests, 
				geographicalAreas, 
				datarate, 
				rrhs, 
				nodes, 
				servers, null);
		
		return request;
	}
	
	private Map<TransmissionMode, Double> buildDatarate() {
		Map<TransmissionMode, Double> datarate = new HashMap<>();
		//from D4.6 - to be double checked
		datarate.put(TransmissionMode.M1, 1216D);
		datarate.put(TransmissionMode.M2, 1419D);
		datarate.put(TransmissionMode.M3, 2838D);
		datarate.put(TransmissionMode.M4, 5677D);
		return datarate;
	}
	
	private List<IndicatorInformation> getPnfInstanceIndicators(PnfInstance pnfInstance){
		
		
		System.out.println("Retrieving Indicators for:"+pnfInstance.getPnfInstanceId()+"@"+pnfInstance.getManagementIpAddress());
		RestVnfDriver restClient = new RestVnfDriver(pnfInstance.getPnfInstanceId(), pnfInstance.getManagementIpAddress(),restTemplate, taskExecutor);
		
		List<IndicatorInformation> result;
		try {
			result = restClient.getIndicatorValue(new GeneralizedQueryRequest(null, null)).getIndicatorInformation();
			return result;
		} catch (FailedOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<IndicatorInformation>();
		}
		
		
	}

}
