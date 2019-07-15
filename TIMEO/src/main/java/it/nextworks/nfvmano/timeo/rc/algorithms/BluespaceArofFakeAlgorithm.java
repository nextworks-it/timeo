package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import it.nextworks.nfvmano.timeo.rc.elements.InterDcNetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.NsScaleSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.ScaleNsResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.ScaleVnfResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

/**
 * Static algorithm for TAPI testing
 * 
 * @author nextworks
 *
 */
public class BluespaceArofFakeAlgorithm extends AbstractNsResourceAllocationAlgorithm {

	private VnfPackageManagementService vnfPackageManagementService;
	private Map<String, String> properties;
	private PnfManagementService pnfManagementService;
	
	public BluespaceArofFakeAlgorithm(VnfPackageManagementService vnfPackageManagement, PnfManagementService pnfManagement, Map<String, String> properties) {
		super(AlgorithmType.BLUESPACE_AROF_FAKE);
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
        
        List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<InterDcNetworkPath>();
        
        String networkPathId = "NP-1";
		List<NetworkPathHop> hops = new ArrayList<>();
		//For AROF there is a single hop within a single node
		
		NetworkPathHop hop1 = new NetworkPathHop(0, 
				"987eed57-65ce-59ff-82ca-c4b1939d4213", 					//node ID
				"919efb60-4036-5247-8335-0a1b3a9f1c90", 					//port associated to src SIP
				"b4b19675-6a83-5f4b-95e6-885b8ea26bd3", 					//port associated to dst SIP
				null, 
				null, 
				0, 
				true, 
				true, 
				"47620324-de3b-5b86-b3c3-d8657970ed1b", 
				"bd240ba2-cfc5-5dc8-b21b-14e2ce67dce0");
		hops.add(hop1);
		InterDcNetworkPath idnp = new InterDcNetworkPath(networkPathId, hops, SbNetworkPathType.AROF);
		interDcNetworkPaths.add(idnp);
        
        
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
