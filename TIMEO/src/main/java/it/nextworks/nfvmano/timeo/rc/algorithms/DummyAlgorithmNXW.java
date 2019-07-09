/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.rc.algorithms;


import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
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
public class DummyAlgorithmNXW extends AbstractNsResourceAllocationAlgorithm {


	public DummyAlgorithmNXW() {
		super(AlgorithmType.DUMMY_NXW);
	}

	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
			InstantiateNsRequest request,
			Nsd nsd,
			Map<Vnfd, Map<String, String>> vnfds,
			VimPlugin vimPlugin,
			SdnControllerPlugin sdnPlugin
	) {

		List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
		List<NetworkPath> networkPaths = new ArrayList<>();

		VnfResourceAllocation vra1 = new VnfResourceAllocation(null, "hss", 0, "hss_vdu", 0, "OpenStack_local", "zoneOne", "compute1");
		VnfResourceAllocation vra2 = new VnfResourceAllocation(null, "oaisim", 0, "oaisim_vdu", 0, "OpenStack_local", "zoneOne", "compute1");
		VnfResourceAllocation vra3 = new VnfResourceAllocation(null, "mme", 0, "mme_vdu", 0, "OpenStack_local", "zoneTwo", "compute2");
		VnfResourceAllocation vra4 = new VnfResourceAllocation(null, "spgw", 0, "spgw_vdu", 0, "OpenStack_local", "zoneTwo", "compute2");

		vnfResourceAllocation.add(vra1);
		vnfResourceAllocation.add(vra2);
		vnfResourceAllocation.add(vra3);
		vnfResourceAllocation.add(vra4);

		String incomingLinkId = null;
		String outgoingLinkId = null;

		//S6a HSS->MME
		NetworkPathEndPoint npe1Src = new NetworkPathEndPoint("hss", 0, "hss_vdu", 0, "hssS6aInt");
		NetworkPathEndPoint npe1Dst = new NetworkPathEndPoint("mme", 0, "mme_vdu", 0, "mmeS6aInt");
		List<NetworkPathEndPoint> npe1 = new ArrayList<>();
		npe1.add(npe1Src);
		npe1.add(npe1Dst);
		List<NetworkPathHop> nph1 = new ArrayList<>();
		nph1.add(new NetworkPathHop(0, "openflow:1", "openflow:1:3", "openflow:1:5", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph1.add(new NetworkPathHop(1, "openflow:3", "openflow:3:4", "openflow:3:5", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np1 = new NetworkPath(null, "NP_01_S6a_HSS-MME", npe1, nph1, "S6a", false);
		networkPaths.add(np1);

		//S1c OAISIM->MME
		NetworkPathEndPoint npe2Src = new NetworkPathEndPoint("oaisim", 0, "oaisim_vdu", 0, "oaisimS1cInt");
		NetworkPathEndPoint npe2Dst = new NetworkPathEndPoint("mme", 0, "mme_vdu", 0, "mmeS1cInt");
		List<NetworkPathEndPoint> npe2 = new ArrayList<>();
		npe2.add(npe2Src);
		npe2.add(npe2Dst);
		List<NetworkPathHop> nph2 = new ArrayList<>();
		nph2.add(new NetworkPathHop(0, "openflow:1", "openflow:1:3", "openflow:1:5", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph2.add(new NetworkPathHop(1, "openflow:3", "openflow:3:4", "openflow:3:5", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np2 = new NetworkPath(null, "NP_02_S1c_OAISIM-MME", npe2, nph2, "S1c", false);
		networkPaths.add(np2);

		//S1u OAISIM->SPGW
		NetworkPathEndPoint npe3Src = new NetworkPathEndPoint("oaisim", 0, "oaisim_vdu", 0, "oaisimS1uInt");
		NetworkPathEndPoint npe3Dst = new NetworkPathEndPoint("spgw", 0, "spgw_vdu", 0, "spgwS1uInt");
		List<NetworkPathEndPoint> npe3 = new ArrayList<>();
		npe3.add(npe3Src);
		npe3.add(npe3Dst);
		List<NetworkPathHop> nph3 = new ArrayList<>();
		nph3.add(new NetworkPathHop(0, "openflow:1", "openflow:1:3", "openflow:1:5", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph3.add(new NetworkPathHop(1, "openflow:3", "openflow:3:4", "openflow:3:5", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np3 = new NetworkPath(null, "NP_03_S1u_OAISIM-SPGW", npe3, nph3, "S1u", false);
		networkPaths.add(np3);

		//Mgt OAISIM->Router(MgtSap)
		NetworkPathEndPoint npe4Src = new NetworkPathEndPoint("oaisim", 0, "oaisim_vdu", 0, "oaisimMgtInt");
		NetworkPathEndPoint npe4Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe4 = new ArrayList<>();
		npe4.add(npe4Src);
		npe4.add(npe4Dst);
		List<NetworkPathHop> nph4 = new ArrayList<>();
		nph4.add(new NetworkPathHop(0, "openflow:1", "openflow:1:3", "openflow:1:4", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph4.add(new NetworkPathHop(1, "openflow:2", "openflow:2:4", "openflow:2:9", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np4 = new NetworkPath(null, "NP_04_Mgt_OAISIM-MgtSAP", npe4, nph4, "mgt", false);
		networkPaths.add(np4);

		//Mgt HSS->Router(MgtSap)
		NetworkPathEndPoint npe5Src = new NetworkPathEndPoint("hss", 0, "hss_vdu", 0, "hssMgtInt");
		NetworkPathEndPoint npe5Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe5 = new ArrayList<>();
		npe5.add(npe5Src);
		npe5.add(npe5Dst);
		List<NetworkPathHop> nph5 = new ArrayList<>();
		nph5.add(new NetworkPathHop(0, "openflow:1", "openflow:1:3", "openflow:1:4", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph5.add(new NetworkPathHop(1, "openflow:2", "openflow:2:4", "openflow:2:9", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np5 = new NetworkPath(null, "NP_05_Mgt_HSS-MgtSAP", npe5, nph5, "mgt", false);
		networkPaths.add(np5);

		//Mgt MME->Router(MgtSap)
		NetworkPathEndPoint npe6Src = new NetworkPathEndPoint("mme", 0, "mme_vdu", 0, "mmeMgtInt");
		NetworkPathEndPoint npe6Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe6 = new ArrayList<>();
		npe6.add(npe6Src);
		npe6.add(npe6Dst);
		List<NetworkPathHop> nph6 = new ArrayList<>();
		nph6.add(new NetworkPathHop(0, "openflow:3", "openflow:3:5", "openflow:3:3", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph6.add(new NetworkPathHop(1, "openflow:2", "openflow:2:3", "openflow:2:9", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np6 = new NetworkPath(null, "NP_06_Mgt_MME-MgtSAP", npe6, nph6, "mgt", false);
		networkPaths.add(np6);

		//Mgt SPGW->Router(MgtSap)
		NetworkPathEndPoint npe7Src = new NetworkPathEndPoint("spgw", 0, "spgw_vdu", 0, "spgwMgtInt");
		NetworkPathEndPoint npe7Dst = new NetworkPathEndPoint("mgtSap", "mgt");
		List<NetworkPathEndPoint> npe7 = new ArrayList<>();
		npe7.add(npe7Src);
		npe7.add(npe7Dst);
		List<NetworkPathHop> nph7 = new ArrayList<>();
		nph7.add(new NetworkPathHop(0, "openflow:3", "openflow:3:5", "openflow:3:3", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph7.add(new NetworkPathHop(1, "openflow:2", "openflow:2:3", "openflow:2:9", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np7 = new NetworkPath(null, "NP_07_Mgt_SPGW-MgtSAP", npe7, nph7, "mgt", false);
		networkPaths.add(np7);

		//SGI SPGW->Router(SgiSap)
		NetworkPathEndPoint npe8Src = new NetworkPathEndPoint("spgw", 0, "spgw_vdu", 0, "spgwSgiInt");
		NetworkPathEndPoint npe8Dst = new NetworkPathEndPoint("sgiSap", "Sgi");
		List<NetworkPathEndPoint> npe8 = new ArrayList<>();
		npe8.add(npe8Src);
		npe8.add(npe8Dst);
		List<NetworkPathHop> nph8 = new ArrayList<>();
		nph8.add(new NetworkPathHop(0, "openflow:3", "openflow:3:5", "openflow:3:3", incomingLinkId, outgoingLinkId, 0, true, false, null, null));
		nph8.add(new NetworkPathHop(1, "openflow:2", "openflow:2:3", "openflow:2:9", incomingLinkId, outgoingLinkId, 0, false, true, null, null));
		NetworkPath np8 = new NetworkPath(null, "NP_07_Sgi_SPGW-SgiSAP", npe8, nph8, "Sgi", false);
		networkPaths.add(np8);

		List<String> networkNodesToBeActivated = new ArrayList<>();
		networkNodesToBeActivated.add("openflow:3");
		networkNodesToBeActivated.add("openflow:2");
		networkNodesToBeActivated.add("openflow:1");

		Map<String, String> computeNodesToBeActivated = new HashMap<>();
		computeNodesToBeActivated.put("compute1", "OpenStack_local");
		computeNodesToBeActivated.put("compute2", "OpenStack_local");

		NsResourceSchedulingSolution solution = new NsResourceSchedulingSolution(request.getNsInstanceId(), vnfResourceAllocation, networkPaths, true,
				networkNodesToBeActivated, computeNodesToBeActivated);
		return solution;
	}
}
