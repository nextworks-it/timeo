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



import java.util.*;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.common.exception.ScaleAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.*;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import org.springframework.util.CollectionUtils;

/**
 * This is just a sample algorithm class that provides a static solution.
 *
 * @author nextworks
 *
 */
public class CdnStaticAlgorithmBluespaceNXW extends AbstractNsResourceAllocationAlgorithm {


    public CdnStaticAlgorithmBluespaceNXW() {
        super(AlgorithmType.CDN_STATIC_BLUESPACE_NXW);
    }

    @Override
    public NsResourceSchedulingSolution computeNsResourceAllocationSolution(InstantiateNsRequest request, Nsd nsd, Map<Vnfd, Map<String, String>> vnfds,
                                                                            VimPlugin vimPlugin, SdnControllerPlugin sdnPlugin) throws NotExistingEntityException, ResourceAllocationSolutionNotFound {

        List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
        List<NetworkPath> networkPaths = new ArrayList<>();

        VnfResourceAllocation vra1 = new VnfResourceAllocation(null, "vFW_01", 0, "vFW_vdu", 0, "OpenStack_local", "netdev5", "compute1");
        VnfResourceAllocation vra2 = new VnfResourceAllocation(null, "vDNS_01", 0, "vDNS_vdu", 0, "OpenStack_local", "netdev5", "compute1");
        VnfResourceAllocation vra3 = new VnfResourceAllocation(null, "vCacheMid_01", 0, "vCacheMid_vdu", 0, "OpenStack_local", "netdev5", "compute1");
        VnfResourceAllocation vra4 = new VnfResourceAllocation(null, "vCacheEdge_1_01", 0, "vCacheEdge_1_vdu", 0, "OpenStack_local", "netdev5", "compute1");
        VnfResourceAllocation vra5 = new VnfResourceAllocation(null, "vCacheEdge_2_01", 0, "vCacheEdge_2_vdu", 0, "OpenStack_local", "netdev5", "compute1");

        vnfResourceAllocation.add(vra1);
        vnfResourceAllocation.add(vra2);
        vnfResourceAllocation.add(vra3);
        vnfResourceAllocation.add(vra4);
        List<PnfAllocation> pnfs = new ArrayList<>();
        pnfs.add(new PnfAllocation(
                null,
                "pDNS_v01",
                "0.1",
                0,
                "pDNS_INSTANCE_001",
                "pDNS_profile",
                Collections.emptyMap()
        ));

        if (request.getNsInstantiationLevelId().equals("il_vCDN_big")) vnfResourceAllocation.add(vra5);

        List<String> networkNodesToBeActivated = new ArrayList<>();

        Map<String,String> computeNodesToBeActivated = new HashMap<>();
        computeNodesToBeActivated.put("netdev5","OpenStack_local");
        computeNodesToBeActivated.put("netdev5","OpenStack_local");
        
        List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<>();

        return new NsResourceSchedulingSolution(
                request.getNsInstanceId(),
                vnfResourceAllocation,
                pnfs,
                networkPaths,
                interDcNetworkPaths,
                true,
                networkNodesToBeActivated,
                computeNodesToBeActivated
        );
    }
    
    @Override
    public NsScaleSchedulingSolution computeNsScaleAllocationSolution(ScaleNsRequest request, NsInfo nsi,
			Nsd nsd, Map<Vnfd, Map<String, String>> vnfds, VimPlugin vimPlugin,  SdnControllerPlugin sdnPlugin, 
			VnfPackageManagementService vnfService
			) throws NotExistingEntityException, ScaleAllocationSolutionNotFound

    {
    	//Look for the missing vnfdIds
    	List<ScaleVnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
    	String instantiationLevel = request.getScaleNsData().getScaleNsToLevelData().getNsInstantiationLevel();
    	if( instantiationLevel.equals("il_vCDN_big")) {
    		ScaleVnfResourceAllocation vra = new ScaleVnfResourceAllocation(null, "vCacheEdge_2_01", 0, "vCacheEdge_2_vdu", 0, "OpenStack_local", "netdev5", "compute1");
    		vnfResourceAllocation.add(vra);
    		ScaleNsResourceAllocation sNRA = new ScaleNsResourceAllocation(vnfResourceAllocation, null, null, true, null, null);
    		return new NsScaleSchedulingSolution(request.getNsInstanceId(), null, null, null, null, null,sNRA, true);
    	}else
    		throw new ScaleAllocationSolutionNotFound("Method not implemented");
    	
    	
    	
    	
    }

}