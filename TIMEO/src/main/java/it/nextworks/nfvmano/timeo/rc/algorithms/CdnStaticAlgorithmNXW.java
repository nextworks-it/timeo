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
public class CdnStaticAlgorithmNXW extends AbstractNsResourceAllocationAlgorithm {


	public CdnStaticAlgorithmNXW() {
		super(AlgorithmType.CDN_STATIC_NXW);
	}

	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
            InstantiateNsRequest request,
            Nsd nsd, Map<Vnfd,
            Map<String, String>> vnfds,
            VimPlugin vimPlugin,
            SdnControllerPlugin sdnPlugin
    ) {

		List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
		List<NetworkPath> networkPaths = new ArrayList<>();
		
		VnfResourceAllocation vra1 = new VnfResourceAllocation(null, "webserver", 0, "webserver_vdu", 0, "OpenStack_local", "netdev5", "compute1");
		VnfResourceAllocation vra2 = new VnfResourceAllocation(null, "spr1", 0, "spr1_vdu", 0, "OpenStack_local", "netdev5", "compute1");
		VnfResourceAllocation vra3 = new VnfResourceAllocation(null, "spr21", 0, "spr21_vdu", 0, "OpenStack_local", "netdev4", "compute2");
		VnfResourceAllocation vra4 = new VnfResourceAllocation(null, "spr22", 0, "spr22_vdu", 0, "OpenStack_local", "netdev4", "compute2");
		
		vnfResourceAllocation.add(vra1);
		vnfResourceAllocation.add(vra2);
		vnfResourceAllocation.add(vra3);
		if (request.getNsInstantiationLevelId().equals("il_vCDN_big")) vnfResourceAllocation.add(vra4);

		List<String> networkNodesToBeActivated = new ArrayList<>();

		Map<String,String> computeNodesToBeActivated = new HashMap<>();
		computeNodesToBeActivated.put("netdev5","OpenStack_local");
		computeNodesToBeActivated.put("netdev4","OpenStack_local");

		return new NsResourceSchedulingSolution(
				request.getNsInstanceId(),
				vnfResourceAllocation,
				networkPaths,
				true,
				networkNodesToBeActivated,
				computeNodesToBeActivated
		);
	}

}
