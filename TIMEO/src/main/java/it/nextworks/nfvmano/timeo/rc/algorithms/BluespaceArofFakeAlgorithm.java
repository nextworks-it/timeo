package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.*;
import java.util.stream.Collectors;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.LocationInfo;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.SapData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PhysicalEquipmentPort;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
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
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;

import javax.xml.stream.Location;

/**
 * Static algorithm for TAPI testing
 * 
 * @author nextworks
 *
 */
public class BluespaceArofFakeAlgorithm extends AbstractNsResourceAllocationAlgorithm {

	private static final Logger log = LoggerFactory.getLogger(BluespaceArofFakeAlgorithm.class);
	private VnfPackageManagementService vnfPackageManagementService;
	private Map<String, String> properties;
	private PnfManagementService pnfManagementService;

	//Key: RRH location id, value: range covered
	private Map<String, List<LocationInfo>> geographicalAreas = new HashMap<>();
	
	public BluespaceArofFakeAlgorithm(VnfPackageManagementService vnfPackageManagement, PnfManagementService pnfManagement, Map<String, String> properties) {
		super(AlgorithmType.BLUESPACE_AROF_FAKE);
		this.vnfPackageManagementService= vnfPackageManagement;
        this.properties = properties;
        this.pnfManagementService = pnfManagement;
        this.setupGeographicalAreas();
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
		try {
			List<SbNetworkPath> activePaths =  sdnPlugin.getActivePaths();
			List<NetworkPathHop> activeNetworkHops = new ArrayList<>();
			for(SbNetworkPath sbNetworkPath : activePaths){
				activeNetworkHops.addAll(sbNetworkPath.getHops());
			}
			getAvaialbleNetworkPathHopSip(activeNetworkHops, request.getSapData());

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
		} catch (FailedOperationException e) {
			e.printStackTrace();
		} catch (MethodNotImplementedException e) {
			e.printStackTrace();
		}

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


    private NetworkPathHop getAvaialbleNetworkPathHop(List<NetworkPathHop> activePathHops, List<SapData> sapData) throws FailedOperationException {
		if(sapData.size()==1){
			List<PnfInstance> rrhs = this.getRrhInstancesForSapLocation(sapData.get(0));
			if(!rrhs.isEmpty()){
				List<PnfInstance> bbus = pnfManagementService.getPnfInstancedFromType(PnfType.BBU);
				for (PnfInstance rrh : rrhs){
					List<String> rrhSips = rrh.getPorts().stream()
							.filter(port -> port.getServiceInterfacePointId()!=null)
							.map(port -> port.getServiceInterfacePointId())
							.collect(Collectors.toList());
					for(String rrhSip : rrhSips){

						for (PnfInstance bbu: bbus){
							List<String> bbuSips = bbu.getPorts().stream()
									.filter(port -> port.getServiceInterfacePointId()!=null)
									.map(port -> port.getServiceInterfacePointId())
									.collect(Collectors.toList());
							for(String bbuSip : bbuSips){
								Optional<NetworkPathHop> nph = activePathHops.stream()
										.filter(hop -> hop.getIngressServiceInterfacePoint().equals(rrhSip) && hop.getEgressServiceInterfacePoint().equals(bbuSip))
										.findFirst();
								if(!nph.isPresent()){
									return new NetworkPathHop()
								}
							}
						}

					}


				}
				throw new FailedOperationException("Could not find available NetworkHop");
			}else throw new FailedOperationException("Could not find RRH instance with the specified location");


		}else throw new FailedOperationException("Only one sap location constraint is supported");



	}


	private List<PnfInstance> getRrhInstancesForSapLocation(SapData sapData){
		List<PnfInstance> rrhs = pnfManagementService.getPnfInstancedFromType(PnfType.RRH);
		String locationId = this.getLocationAreaId(sapData.getLocationInfo());
		log.debug("Searching pnf instances in location:"+locationId);
		return rrhs.stream().filter(rrh -> rrh.getLocation().equals(locationId))
				.collect(Collectors.toList());
	}

	private String getLocationAreaId(LocationInfo locationInfo){
		for(Map.Entry<String, List<LocationInfo>> entry : geographicalAreas.entrySet()){
			for(LocationInfo rrhLocationInfo : entry.getValue()){
				if (isAreaIncluded(locationInfo.getLatitude(),
						locationInfo.getLongitude(),
						locationInfo.getRange(),
						rrhLocationInfo.getLatitude(),
						rrhLocationInfo.getLongitude(),
						rrhLocationInfo.getRange())) {
					log.debug("Found geographical area to cover (" + locationInfo.getLatitude() + ", " + locationInfo.getLongitude() + ", " + locationInfo.getRange() + "): area ID " + entry.getKey());
					return entry.getKey();
				}
			}
		}
		log.error("COULD NOT Found geographical area to cover (" + locationInfo.getLatitude() + ", " + locationInfo.getLongitude() + ", " + locationInfo.getRange() + ")");
		return null;


	}


	private void setupGeographicalAreas(){

			List<LocationInfo> infoArea1 = new ArrayList<>();
			infoArea1.add(new LocationInfo(10D, 10D, 0, 1000));
			infoArea1.add(new LocationInfo(20D, 20D, 0, 1000));
			infoArea1.add(new LocationInfo(30D, 30D, 0, 1000));

			geographicalAreas.put("1", infoArea1);

			List<LocationInfo> infoArea2 = new ArrayList<>();
			infoArea2.add(new LocationInfo(40D, 40D, 0, 1000));
			infoArea2.add(new LocationInfo(50D, 50D, 0, 1000));
			infoArea2.add(new LocationInfo(60D, 60D, 0, 1000));
			geographicalAreas.put("2", infoArea2);



	}

	private boolean isAreaIncluded(double latitude1, double longitude1, float range1, double latitude, double longitude, float range) {
		if (range1 > range) return false;
		double distance = Math.pow((latitude1 - latitude) * (latitude1 - latitude) + (longitude1 + longitude) * (longitude1 + longitude), 0.5);
		if (distance <= (range - range1)) return true;
		else return false;
	}

}
