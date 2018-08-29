package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.InterDcNetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

/**
 * Static algorithm for TAPI testing
 * 
 * @author nextworks
 *
 */
public class BluespaceStaticAlgorithm extends AbstractNsResourceAllocationAlgorithm {

	public BluespaceStaticAlgorithm() {
		super(AlgorithmType.BLUESPACE_STATIC_NXW);
	}

	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(InstantiateNsRequest request, Nsd nsd,
			Map<Vnfd, Map<String, String>> vnfds, VimPlugin vimPlugin, SdnControllerPlugin sdnPlugin)
			throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
		
		List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
		List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<>();
		
		for (Map.Entry<Vnfd, Map<String, String>> entry : vnfds.entrySet()) {
			Vnfd vnfd = entry.getKey();
			String vnfdId = vnfd.getVnfdId();
			int vnfIndex = 0;
			String vduId = vnfd.getVdu().get(0).getVduId();
			int vduIndex = 0;
			String vimId = "OpenStack_local";
			String zoneId = "netdev5";
			String hostId = "compute1";
			
			VnfResourceAllocation vra = new VnfResourceAllocation(null, vnfdId, vnfIndex, vduId, vduIndex, vimId, zoneId, hostId);
			vnfResourceAllocation.add(vra);
		}
		
		String networkPathId = "NP-1";
		List<NetworkPathHop> hops = new ArrayList<>();
		NetworkPathHop hop1 = new NetworkPathHop(0, 
				"00:00:34:97:f6:5c:6d:e0", 					//node ID
				"8", 										//should be an ETH port
				"196608", 									//should be an SDM port
				null, 
				null, 
				0, 
				true, 
				false, 
				"sip-pe1-uni1", 
				null);
		NetworkPathHop hop2 = new NetworkPathHop(1, 
				"00:00:34:97:f6:5c:6d:e1", 					//node ID
				"196608", 									//should be an SDM port
				"9", 										//should be an ETH port
				null, 
				null, 
				0, 
				false, 
				true, 
				null, 
				"sip-pe2-uni1");
		hops.add(hop1);
		hops.add(hop2);
		InterDcNetworkPath idnp = new InterDcNetworkPath(networkPathId, hops);
		interDcNetworkPaths.add(idnp);
		
		NsResourceSchedulingSolution solution = new NsResourceSchedulingSolution(request.getNsInstanceId(), 
				vnfResourceAllocation, 
				null, 									//pnfAllocation 
				null, 									//networkPaths 
				interDcNetworkPaths, 
				true, 									//solutionFound
				null, 									//networkNodesToBeActivated 
				null);									//computeNodesToBeActivated
		
		return solution;
		
		
	}

}
