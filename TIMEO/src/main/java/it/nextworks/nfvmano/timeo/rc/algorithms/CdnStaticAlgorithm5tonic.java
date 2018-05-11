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
public class CdnStaticAlgorithm5tonic extends AbstractNsResourceAllocationAlgorithm {

	public CdnStaticAlgorithm5tonic() {
		super(AlgorithmType.CDN_STATIC_5TONIC);
	}

	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(InstantiateNsRequest request, Nsd nsd, Map<Vnfd, Map<String, String>> vnfds, 
			VimPlugin vimPlugin, SdnControllerPlugin sdnPlugin) throws NotExistingEntityException, ResourceAllocationSolutionNotFound {

		List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
		List<NetworkPath> networkPaths = new ArrayList<>();
		
		VnfResourceAllocation vra1 = new VnfResourceAllocation(null, "webserver", 0, "webserver_vdu", 0, "OpenStack_local", "nova", "wasp");
		VnfResourceAllocation vra2 = new VnfResourceAllocation(null, "spr1", 0, "spr1_vdu", 0, "OpenStack_local", "nova", "hulk");
		VnfResourceAllocation vra3 = new VnfResourceAllocation(null, "spr21", 0, "spr21_vdu", 0, "OpenStack_local", "nova", "wasp");
		VnfResourceAllocation vra4 = new VnfResourceAllocation(null, "spr22", 0, "spr22_vdu", 0, "OpenStack_local", "nova", "hulk");
		
		vnfResourceAllocation.add(vra1);
		vnfResourceAllocation.add(vra2);
		vnfResourceAllocation.add(vra3);
		if (request.getNsInstantiationLevelId().equals("il_vCDN_big")) vnfResourceAllocation.add(vra4);
		
		String incomingLinkId = null;
		String outgoingLinkId = null;

		//ORIGIN -> CACHE 1
		NetworkPathEndPoint npe1Src = new NetworkPathEndPoint("spr1", 0, "spr1_vdu", 0, "spr1DataInt");
		NetworkPathEndPoint npe1Dst = new NetworkPathEndPoint("spr21", 0, "spr21_vdu", 0, "spr21DataInt");
		List<NetworkPathEndPoint> npe1 = new ArrayList<>();
		npe1.add(npe1Src);
		npe1.add(npe1Dst);
		List<NetworkPathHop> nph1 = new ArrayList<>();
		nph1.add(new NetworkPathHop(null, 0, "openflow:2", "openflow:2:1", "openflow:2:2", incomingLinkId, outgoingLinkId, 0, true, false));
		nph1.add(new NetworkPathHop(null, 1, "openflow:9", "openflow:9:3", "openflow:9:4", incomingLinkId, outgoingLinkId, 0, false, false));
		nph1.add(new NetworkPathHop(null, 2, "openflow:1", "openflow:1:3", "openflow:1:1", incomingLinkId, outgoingLinkId, 0, false, true));
		NetworkPath np1 = new NetworkPath(null, "NP_01_Data_Cache1", npe1, nph1, "VideoData", false);
		networkPaths.add(np1);
		
		if (request.getNsInstantiationLevelId().equals("il_vCDN_big")) {
			//WS -> CACHE 2
			NetworkPathEndPoint npe2Src = new NetworkPathEndPoint("webserver", 0, "webserver_vdu", 0, "webDistInt");
			NetworkPathEndPoint npe2Dst = new NetworkPathEndPoint("spr22", 0, "spr22_vdu", 0, "spr22DistInt");
			List<NetworkPathEndPoint> npe2 = new ArrayList<>();
			npe2.add(npe2Src);
			npe2.add(npe2Dst);
			List<NetworkPathHop> nph2 = new ArrayList<>();
			nph2.add(new NetworkPathHop(null, 0, "openflow:1", "openflow:1:1", "openflow:1:3", incomingLinkId, outgoingLinkId, 0, true, false));
			nph2.add(new NetworkPathHop(null, 1, "openflow:9", "openflow:9:4", "openflow:9:3", incomingLinkId, outgoingLinkId, 0, false, false));
			nph2.add(new NetworkPathHop(null, 2, "openflow:2", "openflow:2:2", "openflow:2:1", incomingLinkId, outgoingLinkId, 0, false, true));
			NetworkPath np2 = new NetworkPath(null, "NP_02_Distribution_Cache2", npe2, nph2, "VideoDistribution", false);
			networkPaths.add(np2);	
		}
		
		//Mgt Origin->Router(MgtSap)
		NetworkPathEndPoint npe3Src = new NetworkPathEndPoint("spr1", 0, "spr1_vdu", 0, "spr1MgtInt");
		NetworkPathEndPoint npe3Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe3 = new ArrayList<>();
		npe3.add(npe3Src);
		npe3.add(npe3Dst);
		List<NetworkPathHop> nph3 = new ArrayList<>();
		nph3.add(new NetworkPathHop(null, 0, "openflow:2", "openflow:2:1", "openflow:2:2", incomingLinkId, outgoingLinkId, 0, true, false));
		nph3.add(new NetworkPathHop(null, 1, "openflow:8", "openflow:8:3", "openflow:8:2", incomingLinkId, outgoingLinkId, 0, false, false));
		nph3.add(new NetworkPathHop(null, 2, "openflow:3", "openflow:3:4", "openflow:3:1", incomingLinkId, outgoingLinkId, 0, false, true));
		NetworkPath np3 = new NetworkPath(null, "NP_03_Mgt_Origin-MgtSAP", npe3, nph3, "mgt", false);
		networkPaths.add(np3);

		//Mgt Cache1->Router(MgtSap)
		NetworkPathEndPoint npe4Src = new NetworkPathEndPoint("spr21", 0, "spr21_vdu", 0, "spr21MgtInt");
		NetworkPathEndPoint npe4Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe4 = new ArrayList<>();
		npe4.add(npe4Src);
		npe4.add(npe4Dst);
		List<NetworkPathHop> nph4 = new ArrayList<>();
		nph4.add(new NetworkPathHop(null, 0, "openflow:1", "openflow:1:1", "openflow:1:2", incomingLinkId, outgoingLinkId, 0, true, false));
		nph4.add(new NetworkPathHop(null, 1, "openflow:7", "openflow:7:2", "openflow:7:3", incomingLinkId, outgoingLinkId, 0, false, false));
		nph4.add(new NetworkPathHop(null, 2, "openflow:3", "openflow:3:2", "openflow:3:1", incomingLinkId, outgoingLinkId, 0, false, true));
		NetworkPath np4 = new NetworkPath(null, "NP_04_Mgt_Cache1-MgtSAP", npe4, nph4, "mgt", false);
		networkPaths.add(np4);
		
		if (request.getNsInstantiationLevelId().equals("il_vCDN_big")) {
			//Mgt Cache2->Router(MgtSap)
			NetworkPathEndPoint npe5Src = new NetworkPathEndPoint("spr22", 0, "spr22_vdu", 0, "spr22MgtInt");
			NetworkPathEndPoint npe5Dst = new NetworkPathEndPoint("mgtSap", "mgt");
			List<NetworkPathEndPoint> npe5 = new ArrayList<>();
			npe5.add(npe5Src);
			npe5.add(npe5Dst);
			List<NetworkPathHop> nph5 = new ArrayList<>();
			nph5.add(new NetworkPathHop(null, 0, "openflow:2", "openflow:2:1", "openflow:2:2", incomingLinkId, outgoingLinkId, 0, true, false));
			nph5.add(new NetworkPathHop(null, 1, "openflow:8", "openflow:8:3", "openflow:8:2", incomingLinkId, outgoingLinkId, 0, false, false));
			nph5.add(new NetworkPathHop(null, 2, "openflow:3", "openflow:3:4", "openflow:3:1", incomingLinkId, outgoingLinkId, 0, false, true));
			NetworkPath np5 = new NetworkPath(null, "NP_05_Mgt_Cache2-MgtSAP", npe5, nph5, "mgt", false);
			networkPaths.add(np5);
		}

		//Mgt WS->Router(MgtSap)
		NetworkPathEndPoint npe6Src = new NetworkPathEndPoint("webserver", 0, "webserver_vdu", 0, "webMgtInt");
		NetworkPathEndPoint npe6Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe6 = new ArrayList<>();
		npe6.add(npe6Src);
		npe6.add(npe6Dst);
		List<NetworkPathHop> nph6 = new ArrayList<>();
		nph6.add(new NetworkPathHop(null, 0, "openflow:1", "openflow:1:1", "openflow:1:2", incomingLinkId, outgoingLinkId, 0, true, false));
		nph6.add(new NetworkPathHop(null, 1, "openflow:7", "openflow:7:2", "openflow:7:3", incomingLinkId, outgoingLinkId, 0, false, false));
		nph6.add(new NetworkPathHop(null, 2, "openflow:3", "openflow:3:2", "openflow:3:1", incomingLinkId, outgoingLinkId, 0, false, true));
		NetworkPath np6 = new NetworkPath(null, "NP_06_Mgt_WS-MgtSAP", npe6, nph6, "mgt", false);
		networkPaths.add(np6);

		//Mgt WS->Router(VideoSap)
		NetworkPathEndPoint npe7Src = new NetworkPathEndPoint("webserver", 0, "webserver_vdu", 0, "webDistInt");
		NetworkPathEndPoint npe7Dst = new NetworkPathEndPoint("videoSap", "VideoDistribution");
		List<NetworkPathEndPoint> npe7 = new ArrayList<>();
		npe7.add(npe7Src);
		npe7.add(npe7Dst);
		List<NetworkPathHop> nph7 = new ArrayList<>();
		nph7.add(new NetworkPathHop(null, 0, "openflow:1", "openflow:1:1", "openflow:1:2", incomingLinkId, outgoingLinkId, 0, true, false));
		nph7.add(new NetworkPathHop(null, 1, "openflow:7", "openflow:7:2", "openflow:7:3", incomingLinkId, outgoingLinkId, 0, false, false));
		nph7.add(new NetworkPathHop(null, 2, "openflow:3", "openflow:3:2", "openflow:3:1", incomingLinkId, outgoingLinkId, 0, false, true));
		NetworkPath np7 = new NetworkPath(null, "NP_07_Mgt_SPGW-MgtSAP", npe7, nph7, "mgt", false);
		networkPaths.add(np7);

		List<String> networkNodesToBeActivated = new ArrayList<>();
		networkNodesToBeActivated.add("openflow:3");
		networkNodesToBeActivated.add("openflow:2");
		networkNodesToBeActivated.add("openflow:1");
		networkNodesToBeActivated.add("openflow:7");
		networkNodesToBeActivated.add("openflow:8");
		networkNodesToBeActivated.add("openflow:9");
		
		Map<String,String> computeNodesToBeActivated = new HashMap<>();
//		computeNodesToBeActivated.put("hulk","OpenStack_local");
//		computeNodesToBeActivated.put("wasp","OpenStack_local");

		return new NsResourceSchedulingSolution(request.getNsInstanceId(), vnfResourceAllocation, networkPaths, true,
				networkNodesToBeActivated, computeNodesToBeActivated);
	}

}
