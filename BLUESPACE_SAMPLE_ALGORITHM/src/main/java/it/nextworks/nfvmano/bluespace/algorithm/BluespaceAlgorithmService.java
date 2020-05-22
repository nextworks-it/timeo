package it.nextworks.nfvmano.bluespace.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import it.nextworks.nfvmano.libs.bluespace.algorithm.BluespaceAlgorithmInterface;
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
	
	public static BluespaceAlgorithmAllocationResponse buildSampleResponse(BluespaceAlgorithmAllocationRequest request) {
		ServiceRequest origReq = request.getServiceRequests().get(0);
		//key: ID of the geographical area; value: resource allocation in RRHs
		Map<String, SubcarrierResourceAllocation> rrhResourceAllocation = new HashMap<String, SubcarrierResourceAllocation>();
		String areaId = origReq.getServiceAreaId().get(0);


		Rrh rrh = request.getRrhs().get(0);


		String rrhId = rrh.getRrhId();



		List<LightPath> lightpaths = new ArrayList<LightPath>();

		String bbuId = findFirstBbuId(request);
		ObfnResourceAllocation ul1 = new ObfnResourceAllocation("ul-1", 0, 0, 0, 0, 0);
		ObfnResourceAllocation dl1 = new ObfnResourceAllocation("dl-1", 0, 0, 0, 0, 0 );
		ObfnResourceAllocation ul2 = new ObfnResourceAllocation("ul-2", 0, 0, 0, 0, 0 );
		ObfnResourceAllocation dl2 = new ObfnResourceAllocation("dl-2", 0, 0, 0, 0, 0 );
		LightpathHop uLHop = new LightpathHop("test","1d2c5cd7-91eb-488f-a0bc-913908130bd4", "e967dff5-c899-4324-9382-ae518d505448", ul1.getObfnId() );
		LightpathHop dLHop = new LightpathHop("test","1506716d-dc3e-4645-86e1-4cb8ba6a116b", "21506245-7504-44c8-8e3a-ff2504779bab", dl1.getObfnId() );





		List<LightpathHop> hops = new ArrayList<>();
		hops.add(uLHop);
		hops.add(dLHop);
		LightPath lp = new LightPath(request.getRrhs().get(0).getRrhId(), request.getBbus().get(0).getBbuId(), hops);
		lightpaths.add(lp);

		//key: ID of the VM in service; value: ID of the server where the VM must be allocated
		Map<String, String> vmAllocation = new HashMap<String, String>();
		String serverId = request.getServers().get(0).getServerId();
		Set<String> vmIds = origReq.getVmRequirements().keySet();
		for (String s : vmIds) vmAllocation.put(s, serverId);


		//key: ID of the server; Value: List of ID of the BBUs corresponding to the MEC server
		//Map<String, List<String>> mecToBbuMapping = new HashMap<String, List<String>>();

		//mecToBbuMapping.put(serverId, bbuIds);

		List<ObfnRrhResourceAllocation> rrhResourceAllocations = new ArrayList<>();
		rrhResourceAllocations.add(new ObfnRrhResourceAllocation(rrhId, true, true, 100, 100));

		List<ObfnBbuResourceAllocation> bbuResourceAllocations = new ArrayList<>();
		bbuResourceAllocations.add(new ObfnBbuResourceAllocation(bbuId, 4,  3168, 0, 0, 5000000));
		List<ObfnResourceAllocation> resourceAllocations = new ArrayList<>();
		resourceAllocations.add(ul1);
		resourceAllocations.add(dl1);
		ServiceResponse sr = new ServiceResponse(origReq.getServiceId(), lightpaths, vmAllocation, null, resourceAllocations, rrhResourceAllocations, bbuResourceAllocations  );
		List<ServiceResponse> serviceResponses = new ArrayList<ServiceResponse>();
		serviceResponses.add(sr);
		return new BluespaceAlgorithmAllocationResponse(serviceResponses);



	}
	
	private static String findFirstBbuId(BluespaceAlgorithmAllocationRequest request) {
		List<BluespaceNode> bns = request.getNodes();
		for (BluespaceNode bn : bns) {
			if (bn.getNodeType().equals(BluespaceNodeType.BBU)) return bn.getNodeId();
		}
		return null;
	}

}
