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
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.common.exception.ScaleAllocationSolutionNotFound;
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
	private PnfManagementService pnfManagementService;

    public NxwDynamicAlgorithm(VnfPackageManagementService vnfPackageManagement, PnfManagementService pnfManagement, Map<String, String> properties) {
        super(AlgorithmType.NXW_DYNAMIC_ALGORITHM);
        this.vnfPackageManagementService= vnfPackageManagement;
        this.properties = properties;
        this.pnfManagementService = pnfManagement;
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
        for(String pnfdId : nsd.getPnfdId()) {
        	PnfInstance pnfInstance= pnfManagementService.getPnfInstancesFromPnfd(pnfdId).get(0);
        	
        	pnfs.add(new PnfAllocation(
                    null,
                    pnfdId,
                    pnfInstance.getPnfdVersion(),
                    0,
                    pnfInstance.getPnfInstanceId(),
                    "",
                    Collections.emptyMap()
            ));
           

        }
        
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
    
    @Override
    public NsScaleSchedulingSolution computeNsScaleAllocationSolution(ScaleNsRequest request, NsInfo nsi,
			Nsd nsd, Map<Vnfd, Map<String, String>> vnfds, VimPlugin vimPlugin,  SdnControllerPlugin sdnPlugin, 
			VnfPackageManagementService vnfService
			) throws NotExistingEntityException, ScaleAllocationSolutionNotFound

    {
    	
    	List<ScaleVnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
    	String defaultVim = properties.get("default_vim");
    	String defaultZone = properties.get("default_zone");
    	String defaultCompute = properties.get("default_compute");
    	String newInstantiationLevel = request.getScaleNsData().getScaleNsToLevelData().getNsInstantiationLevel();
    	String currentInstantiationLevel = nsi.getNsScaleStatus().get(0).getNsScaleLevelId();
    	Map<String, Map<String, String>> currentVnfds = nsd.getVnfdDataFromFlavour(nsi.getFlavourId(), currentInstantiationLevel);
    	Map<String, Map<String, String>> newVnfds = nsd.getVnfdDataFromFlavour(nsi.getFlavourId(), newInstantiationLevel);
    	Set<String> currentVnfdIds = currentVnfds.keySet();
    	Set<String> newVnfdIds = newVnfds.keySet();
    	
    	//Look for the vnfdIds to instantiate
    	for(String vnfdId : newVnfds.keySet()) {
    		if(!currentVnfdIds.contains(vnfdId)) {
    			
    			OnboardedVnfPkgInfo pkg =vnfPackageManagementService.getOnboardedVnfPkgInfoFromVnfd(vnfdId); 
        		Vnfd currentVnfd = pkg.getVnfd();
        		Vdu currentVdu = currentVnfd.getVdu().get(0);
        		ScaleVnfResourceAllocation vra = new ScaleVnfResourceAllocation(null, vnfdId, 0, currentVdu.getVduId(), 0, defaultVim, defaultZone, defaultCompute );
        		vnfResourceAllocation.add(vra);
    		}
    		
    	
    	}
    	//Look for the vnfdIds to terminate
    	List<String> vnfInstancesToTerminate = new ArrayList<String>();
    	for(String vnfdId : currentVnfds.keySet()) {
    		if(!newVnfdIds.contains(vnfdId)) {
    			vnfInstancesToTerminate.addAll(nsi.getVnfInfoIdFromVnfdId(vnfdId));
    			
    		}
    		    	
    	} 	
    	
    	
		ScaleNsResourceAllocation sNRA = new ScaleNsResourceAllocation(vnfResourceAllocation, null, null, true, null, null);
		return new NsScaleSchedulingSolution(request.getNsInstanceId(), vnfInstancesToTerminate, null, null, null, null,sNRA, true);
	
    	
    	
    	
    }

}