package it.nextworks.nfvmano.bluespace.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import it.nextworks.nfvmano.libs.bluespace.algorithm.BluespaceAlgorithmInterface;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.BluespaceNode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.LightPath;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.Rrh;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.RrhBeam;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceResponse;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.SubcarrierResourceAllocation;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceNodeType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

/**
 * This class implements an example of blueSPACE algorithm
 * 
 * 
 * @author nextworks
 *
 */
@Service
public class BluespaceAlgorithmService implements BluespaceAlgorithmInterface {

	private static final Logger log = LoggerFactory.getLogger(BluespaceAlgorithmService.class);
	
	public BluespaceAlgorithmService() { }

	@Override
	public BluespaceAlgorithmAllocationResponse computeAllocation(BluespaceAlgorithmAllocationRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		log.debug("Processing request.");
		Gson gson = new Gson();
		System.out.println(gson.toJson(request));
		// TODO: write here the code to compute the solution and build the response. The following is just a dummy example.
		return buildSampleResponse(request);
	}
	
	private BluespaceAlgorithmAllocationResponse buildSampleResponse(BluespaceAlgorithmAllocationRequest request) {
		ServiceRequest origReq = request.getServiceRequests().get(0);
		//key: ID of the geographical area; value: resource allocation in RRHs
		Map<String, SubcarrierResourceAllocation> rrhResourceAllocation = new HashMap<String, SubcarrierResourceAllocation>();
		String areaId = origReq.getServiceAreaId().get(0);
		
		//key: rrh ID, key: beam ID, key: subchannel ID, value: list of subcarrierIds
		Map<String, Map<String , Map<String, List<String>>>> subcarrierResourceAllocation = new HashMap<String, Map<String,Map<String,List<String>>>>();
		Rrh rrh = request.getRrhs().get(0);
		String rrhId = rrh.getRrhId();
		RrhBeam b = rrh.getBeams().get(0);
		String rrhBeamId = b.getBeamId();
		String subchannelId = b.getSubchannels().get(0).getSubchannelId();
		List<String> subCarrierIds = new ArrayList<String>();
		subCarrierIds.add("1");
		Map<String, List<String>> subchannels = new HashMap<String, List<String>>();
		subchannels.put(subchannelId, subCarrierIds);
		Map<String, Map<String, List<String>>> beams = new HashMap<String, Map<String,List<String>>>();
		beams.put(rrhBeamId, subchannels);
		subcarrierResourceAllocation.put(rrhId, beams);
		SubcarrierResourceAllocation sra = new SubcarrierResourceAllocation(subcarrierResourceAllocation);
		rrhResourceAllocation.put(areaId, sra);
		
		List<LightPath> lightpaths = new ArrayList<LightPath>();
		String bbuId = findFirstBbuId(request);
		LightPath lp = new LightPath(rrhId, rrhBeamId, bbuId, null);
		lightpaths.add(lp);
		
		//key: ID of the VM in service; value: ID of the server where the VM must be allocated
		Map<String, String> vmAllocation = new HashMap<String, String>();
		String serverId = request.getServers().get(0).getServerId();
		Set<String> vmIds = origReq.getVmRequirements().keySet();
		for (String s : vmIds) vmAllocation.put(s, serverId);
		
		//key: ID of the server; Value: List of ID of the BBUs corresponding to the MEC server
		Map<String, List<String>> mecToBbuMapping = new HashMap<String, List<String>>();
		List<String> bbuIds = new ArrayList<String>();
		bbuIds.add(bbuId);
		mecToBbuMapping.put(serverId, bbuIds);
		
		ServiceResponse sr = new ServiceResponse(origReq.getServiceId(), rrhResourceAllocation, lightpaths, vmAllocation, mecToBbuMapping);
		List<ServiceResponse> serviceResponses = new ArrayList<ServiceResponse>();
		serviceResponses.add(sr);
		
		return new BluespaceAlgorithmAllocationResponse(serviceResponses);
	}
	
	private String findFirstBbuId(BluespaceAlgorithmAllocationRequest request) {
		List<BluespaceNode> bns = request.getNodes();
		for (BluespaceNode bn : bns) {
			if (bn.getNodeType().equals(BluespaceNodeType.BBU)) return bn.getNodeId();
		}
		return null;
	}

}
