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
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.*;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;


/**
 * This is just a sample algorithm class that provides a static solution.
 *
 * @author nextworks
 *
 */
public class NxwDynamicAlgorithm extends AbstractNsResourceAllocationAlgorithm {
	
	private VnfPackageManagementService vnfPackageManagementService;
	private Map<String, String> properties;

    public NxwDynamicAlgorithm(VnfPackageManagementService vnfPackageManagement, Map<String, String> properties) {
        super(AlgorithmType.NXW_DYNAMIC_ALGORITHM);
        this.vnfPackageManagementService= vnfPackageManagement;
        this.properties = properties;
    }

    @Override
    public NsResourceSchedulingSolution computeNsResourceAllocationSolution(InstantiateNsRequest request, Nsd nsd, Map<Vnfd, Map<String, String>> vnfds,
                                                                            VimPlugin vimPlugin, SdnControllerPlugin sdnPlugin) throws NotExistingEntityException, ResourceAllocationSolutionNotFound {

    	List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
    	Map<String, Map<String, String>> vnfdProperties = nsd.getVnfdDataFromFlavour(request.getFlavourId(), request.getNsInstantiationLevelId());
    	String defaultVim = properties.get("default_vim");
    	String defaultZone = properties.get("default_zone");
    	String defaultCompute = properties.get("default_compute");
    	for(String vnfdId : vnfdProperties.keySet()) {
    		OnboardedVnfPkgInfo pkg =vnfPackageManagementService.getOnboardedVnfPkgInfoFromVnfd(vnfdId); 
    		Vnfd currentVnfd = pkg.getVnfd();
    		Vdu currentVdu = currentVnfd.getVdu().get(0);
    		
    		VnfResourceAllocation currentVRA = new VnfResourceAllocation(null, vnfdId, 0, currentVdu.getVduId(), 0, defaultVim, defaultZone, defaultCompute);
    		vnfResourceAllocation.add(currentVRA);
    	}
    	
        List<NetworkPath> networkPaths = new ArrayList<>();
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

        List<String> networkNodesToBeActivated = new ArrayList<>();

        Map<String,String> computeNodesToBeActivated = new HashMap<>();
        computeNodesToBeActivated.put("netdev5","OpenStack_local");
        

        return new NsResourceSchedulingSolution(
                request.getNsInstanceId(),
                vnfResourceAllocation,
                pnfs,
                networkPaths,
                true,
                networkNodesToBeActivated,
                computeNodesToBeActivated
        );
    }

}