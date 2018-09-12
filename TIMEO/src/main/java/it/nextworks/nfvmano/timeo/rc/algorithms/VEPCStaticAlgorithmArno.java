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


import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.InterDcNetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathEndPoint;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

import java.util.ArrayList;
import java.util.Collections;
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

		List<PnfAllocation> pnfs = new ArrayList<>();

		pnfs.add(new PnfAllocation(
				null,
				"CU_v01",
				"0.1",
				0,
				"CU_INSTANCE_001",
				"CU_profile",
				Collections.emptyMap()
		));

		List<InterDcNetworkPath> interNP = new ArrayList<>();

//		computeNodesToBeActivated.put("hulk","OpenStack_local");
//		computeNodesToBeActivated.put("wasp","OpenStack_local");

		return new NsResourceSchedulingSolution(
				request.getNsInstanceId(),
				vnfResourceAllocation,
				pnfs,
				networkPaths,
				interNP,
				true,
				networkNodesToBeActivated,
				computeNodesToBeActivated
		);
	}

}
