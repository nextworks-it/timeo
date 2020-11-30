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
import it.nextworks.nfvmano.timeo.rc.elements.*;
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
	private SdnControllerPlugin sdnPlugin;
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
    	this.sdnPlugin = sdnPlugin;
    	for(String vnfdId : vnfdProperties.keySet()) {
    		OnboardedVnfPkgInfo pkg =vnfPackageManagementService.getOnboardedVnfPkgInfoFromVnfd(vnfdId); 
    		Vnfd currentVnfd = pkg.getVnfd();
    		Vdu currentVdu = currentVnfd.getVdu().get(0);
    		
    		VnfResourceAllocation currentVRA = new VnfResourceAllocation(null, vnfdId, 0, currentVdu.getVduId(), 0, defaultVim, defaultZone, defaultCompute);
    		vnfResourceAllocation.add(currentVRA);
    	}
    	
        List<NetworkPath> networkPaths = new ArrayList<>();
        List<PnfAllocation> pnfs = new ArrayList<>();
        int index = 0;
        for(String pnfdId : nsd.getPnfdId()) {
        	PnfInstance pnfInstance= pnfManagementService.getPnfInstancesFromPnfd(pnfdId).get(0);


        	PnfAllocation pa;
        	if(pnfInstance.getPnfType()==PnfType.RRH){
				 pa = new PnfAllocation(
						null,																//nsRss
						pnfInstance.getPnfdId(), 			//pnfdId
						pnfInstance.getPnfdVersion(),     	//pnfdVersion
						index,
						pnfInstance.getPnfInstanceId(),																//pnfInstanceId
						null,																//pnfProfileId
						this.getRrhConfigurationParameters()                            //parameters

				);
			}else if(pnfInstance.getPnfType()==PnfType.BBU){
        		pa = new PnfAllocation(
						null,
						pnfdId,
						pnfInstance.getPnfdVersion(),
						0,
						pnfInstance.getPnfInstanceId(),
						"",
						this.getBBUConfigurationParameters()
				);
			}else{
				pa = new PnfAllocation(
						null,
						pnfdId,
						pnfInstance.getPnfdVersion(),
						0,
						pnfInstance.getPnfInstanceId(),
						"",
						new HashMap<>()
				);
			}

        	pnfs.add(pa);
           

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
			List<SbNetworkPath> availablePaths = sdnPlugin.getAvailablePaths();

			PnfInstance rrhInstance = getRrhInstancesForSapLocation(request.getSapData().get(0)).get(0);
			List<PnfInstance> bbuInstances = pnfManagementService.getPnfInstancedFromType(PnfType.BBU);
			NetworkPathHop hop1 = null;
			for(PnfInstance bbuInstance : bbuInstances){
				try{
					hop1 = computeFreeArofNetworkPathHop(bbuInstance, rrhInstance, activePaths, availablePaths);

					break;
				} catch (NoNetworkPathAvailableException e) {
					log.debug("No NetworkPathHop available, trying next BBU");
				}
			}


			if(hop1!= null){
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
			}else{
				return null;
			}


		} catch (MethodNotImplementedException e) {
			log.error(e.getMessage());
			log.error(e.getStackTrace().toString());
			return null;
		} catch (FailedOperationException e) {
			log.error(e.getMessage());
			log.error(e.getStackTrace().toString());
			return null;
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
									return new NetworkPathHop();
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

	private String findFirstPnfInstanceServiceInterfacePointId(PnfInstance pnfInstance){
		Optional<PhysicalEquipmentPort> optPort = pnfInstance.getPorts().stream()
				.filter(p -> p.getServiceInterfacePointId()!=null)
				.findFirst();
		if(optPort.isPresent()){
			return optPort.get().getServiceInterfacePointId();
		}else return null;
	}


	private boolean checkNetworkPathExists(String ingressSip, String egressSip, List<SbNetworkPath>  availablePaths ){


		for(SbNetworkPath availablePath : availablePaths){
			Optional<NetworkPathHop> availableNph = availablePath.getHops().stream()
					.filter(aux-> aux.getIngressServiceInterfacePoint().equals(ingressSip)&& aux.getEgressServiceInterfacePoint().equals(egressSip))
					.findFirst();
			if(availableNph.isPresent()){
				return true;
			}
		}
		return false;
	}

	private boolean checkNetworkPathNotUsed(String ingresSip, String egressSip, List<SbNetworkPath>  activePaths){
		for(SbNetworkPath sbNetworkPath: activePaths){
			for(NetworkPathHop activeNph : sbNetworkPath.getHops()){
				String activeIngress = activeNph.getIngressServiceInterfacePoint();
				String activeEgress = activeNph.getEgressServiceInterfacePoint();

				if(ingresSip.equals(activeIngress)&&egressSip.equals(activeEgress))
					return false;
			}
		}
		return true;

	}
	private boolean isNetworkPathAvailable(String ingressSip, String egressSip, List<SbNetworkPath>  activePaths, List<SbNetworkPath>  availablePaths, NetworkTopology networkTopology){

			if (checkNetworkPathExists(ingressSip, egressSip, availablePaths)|| checkNetworkPathExists(egressSip, ingressSip, availablePaths)){
				return checkNetworkPathNotUsed(ingressSip, egressSip,activePaths) && checkNetworkPathNotUsed(egressSip, ingressSip, activePaths);
			}else return false;



	}


	private NetworkPathHop computeFreeArofNetworkPathHop(PnfInstance bbuInstance, PnfInstance rrhInstance, List<SbNetworkPath> activePaths, List<SbNetworkPath> availablePaths) throws NotExistingEntityException, NoNetworkPathAvailableException {
		String bbuInstanceId = bbuInstance.getPnfInstanceId();
		String rrhInstanceId = rrhInstance.getPnfInstanceId();
		log.debug("Computing ingress and egress SIPs for bbu:"+bbuInstanceId+" and rrh:"+rrhInstanceId);

		try {

			NetworkTopology networkTopology= sdnPlugin.getNetworkTopology();
			List<String> bbuSips = bbuInstance.getPorts().stream()
					.filter(p -> p.getServiceInterfacePointId()!=null)
					.map(p -> p.getServiceInterfacePointId())
					.collect(Collectors.toList());

			List<String> rrhSips = rrhInstance.getPorts().stream()
					.filter(p -> p.getServiceInterfacePointId()!=null)
					.map(p -> p.getServiceInterfacePointId())
					.collect(Collectors.toList());


			for(String bbuSip: bbuSips){
				for(String rrhSip: rrhSips){



					if(isNetworkPathAvailable(bbuSip, rrhSip, activePaths, availablePaths, networkTopology)){
						NetworkPathHop nph = new NetworkPathHop(
								0,
								null,                 //nodeId
								null,
								null,                //egressPortId
								null,                                //incomingLinkId - not used here
								null,                                //outgoingLinkId - not used here
								0,                                    //hopQueue - not used here
								true,
								true,
								bbuSip,
								rrhSip
						);
						return nph;
					}
				}
			}
			throw new NoNetworkPathAvailableException("Couldnot find an available path between bbu:"+bbuInstanceId+" and rrh:"+rrhInstanceId);

		} catch (Exception e) {
			log.error("Error retrieving active paths");
			log.error(e.getStackTrace().toString());
			log.error(e.getMessage());
			log.error("using first SIP");
			String ingressServiceInterfacePoint = this.findFirstPnfInstanceServiceInterfacePointId(pnfManagementService.getPnfInstance(rrhInstanceId));
			String egressServiceInterfacePoint = this.findFirstPnfInstanceServiceInterfacePointId(pnfManagementService.getPnfInstance(bbuInstanceId));

			NetworkPathHop nph = new NetworkPathHop(
					0,
					null,                 //nodeId
					null,
					null,                //egressPortId
					null,                                //incomingLinkId - not used here
					null,                                //outgoingLinkId - not used here
					0,                                    //hopQueue - not used here
					true,
					true,
					ingressServiceInterfacePoint,
					egressServiceInterfacePoint
			);
			return nph;
		}

	}

	private class NoNetworkPathAvailableException extends Exception {

		public NoNetworkPathAvailableException(String message){
			super(message);
		}
	}



	private Map<String, String> getBBUConfigurationParameters(){


        /*
         *  int operationMode;
         *  int subcarriersNumber;
         *  int pilotSpacing;
            int modulationScheme;
            long intermediateFrequency;
         */
		Map<String, String> bbuConfigParams = new HashMap<>();



		Long intermediateFrequency =  new Long(5000000);

		bbuConfigParams.put("rcoutput.intermediateFrequency",  intermediateFrequency.toString());
		int modulationScheme = 1;
		bbuConfigParams.put("rcoutput.modulationScheme",  Integer.toString(modulationScheme));
		int subcarriersNumber = 3168;

		bbuConfigParams.put("rcoutput.subcarriersNumber",  Integer.toString(subcarriersNumber));

		int operationMode = 4;

		bbuConfigParams.put("rcoutput.operationMode", Integer.toString(operationMode));

		int pilotSpacing = 14;

		bbuConfigParams.put("rcoutput.pilotSpacing",  Integer.toString(pilotSpacing));

		return bbuConfigParams;
	}
	private Map<String,String> getRrhConfigurationParameters(){
		/*
		Map<String, String> configParameters = new HashMap<>();

		configParameters.put("rcoutput.powerUp","1");
		configParameters.put("rcoutput.sleepMode","0");
		configParameters.put( "rcoutput.batteryChargeEnable","0");
		configParameters.put("rcoutput.outputVoltage1Enable", "true");
		configParameters.put("rcoutput.outputVoltage2Enable", "true");
		configParameters.put("rcoutput.outputVoltage1Level", "1");
		configParameters.put("rcoutput.outputVoltage2Level", "1");
		for(int i=0; i<=15; i++){
			configParameters.put(String.format("rcoutput.paGain%02d", i), "0");
		}

		return configParameters;

		 */

		Map<String, String> rrhConfigParams = new HashMap<>();
		//rrhConfigParams.put("rcoutput.rxGain", Integer.toString(obfnRrhResourceAllocation.getRxGain()));
		//rrhConfigParams.put("rcoutput.txGain",  Integer.toString(obfnRrhResourceAllocation.getTxGain()));
		//TODO: the Pa gains should be calcuated, for the moment just copying the txGain
		int txGain = 100;


		int rxGain =100;


		for(int i=0;i<16; i++){
			String paGainKey = String.format("rcoutput.paGain%02d", i);
			rrhConfigParams.put(paGainKey, Integer.toString(txGain));
		}

		rrhConfigParams.put("rcoutput.powerUp",  Boolean.toString(true));
		rrhConfigParams.put("rcoutput.sleepMode",  Boolean.toString(false));
		rrhConfigParams.put("rcoutput.batteryChargeEnable", "0");
		rrhConfigParams.put("rcoutput.outputVoltage1Enable","0");
		rrhConfigParams.put("rcoutput.outputVoltage1Level","0");
		rrhConfigParams.put("rcoutput.outputVoltage2Enable", "0");
		return rrhConfigParams;
	}

}
