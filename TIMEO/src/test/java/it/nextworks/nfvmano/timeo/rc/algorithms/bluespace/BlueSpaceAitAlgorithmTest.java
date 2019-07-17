package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

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

public class BlueSpaceAitAlgorithmTest {

	AitAlgorithmRestClient client;
	
	@Before
	public void setup() {
		RestTemplate restTemplate = new RestTemplate();
		String algoUrl = "http://localhost:8088/bluespace/algorithm";
		client = new AitAlgorithmRestClient(algoUrl, restTemplate);
	}
	
	@Test
	public void testAlgorithm() {
		System.out.println("*************************************** Test bluespace external algorithm ********************************************");
		BluespaceAlgorithmAllocationRequest request = prepareRequest();
		
		try {
			BluespaceAlgorithmAllocationResponse response = client.computeAllocation(request);
			Gson gson = new Gson();
			System.out.println(gson.toJson(response));
		} catch (Exception e) {
			System.out.println("Received exception when interacting with the algorithm: " + e.getMessage());
		}
	}
	
	private BluespaceAlgorithmAllocationRequest prepareRequest() {
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
		List<RrhBeam> beams = new ArrayList<RrhBeam>();
		List<Subchannel> subchannels = new ArrayList<Subchannel>();
		Subchannel subchannel1 = new Subchannel("Subchannel-01", 2, 240, true, TransmissionMode.M2, null);
		subchannels.add(subchannel1);
		Subchannel subchannel2 = new Subchannel("Subchannel-02", 2, 240, false, TransmissionMode.M2, null);
		subchannels.add(subchannel2);
		GeographicalArea geographicalArea = new GeographicalArea("1");
		RrhBeam beam = new RrhBeam("BEAM-1", 760.32f, subchannels, geographicalArea, null, false);
		beams.add(beam);
		Rrh rrh = new Rrh("RRH-1", beams);
		rrhs.add(rrh);
		
		List<BluespaceNode> nodes = new ArrayList<BluespaceNode>();
		List<BluespaceNodePort> portsRrh = new ArrayList<BluespaceNodePort>();
		BluespaceNodePort portRrh = new BluespaceNodePort("rrh1-P1", PortType.EGRESS, "bbu1", "bbu1-P1", null);
		portsRrh.add(portRrh);
		BluespaceNode bn1 = new BluespaceNode("RRH-1", BluespaceNodeType.RRH, BluespaceSwitchingType.NO_SWITCHING, portsRrh);
		nodes.add(bn1);
		List<BluespaceNodePort> portsBbu = new ArrayList<BluespaceNodePort>();
		BluespaceNodePort portBbu = new BluespaceNodePort("bbu1-P1", PortType.INGRESS, "RRH-1", "rrh1-P1", null);
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
				servers);
		
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

}
