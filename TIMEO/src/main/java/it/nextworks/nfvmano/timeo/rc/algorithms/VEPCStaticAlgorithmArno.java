package it.nextworks.nfvmano.timeo.rc.algorithms;


import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathEndPoint;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This is just a sample algorithm class that provides a static solution.
 * 
 * @author nextworks
 *
 */
public class VEPCStaticAlgorithmArno extends AbstractNsResourceAllocationAlgorithm {

	public VEPCStaticAlgorithmArno() {
		super(AlgorithmType.VEPC_STATIC_ARNO);
	}

	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(InstantiateNsRequest request, Nsd nsd, Map<Vnfd, Map<String, String>> vnfds, 
			VimPlugin vimPlugin, SdnControllerPlugin sdnPlugin) throws NotExistingEntityException, ResourceAllocationSolutionNotFound {

		List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
		List<NetworkPath> networkPaths = new ArrayList<>();
		
		VnfResourceAllocation vra1 = new VnfResourceAllocation(null, "vEPC_VNF", 0, "vEPC_vdu", 0, "OpenStack_local", "nova", "ONOSSONA");
		
		vnfResourceAllocation.add(vra1);

		List<String> networkNodesToBeActivated = new ArrayList<>();

		Map<String,String> computeNodesToBeActivated = new HashMap<>();
//		computeNodesToBeActivated.put("hulk","OpenStack_local");
//		computeNodesToBeActivated.put("wasp","OpenStack_local");

		return new NsResourceSchedulingSolution(request.getNsInstanceId(), vnfResourceAllocation, networkPaths, true,
				networkNodesToBeActivated, computeNodesToBeActivated);
	}

}
