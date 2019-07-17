package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.BluespaceNode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.GeographicalArea;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.PhysicalServer;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.Rrh;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.RrhBeam;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.ServiceRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.VmRequirements;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualComputeDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.VnfIdentifierDeletionNotification;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.LocationInfo;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.SapData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.AitAlgorithmRestClient;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.StaticGeographicalAreas;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;

public class BluespaceAitAlgorithm extends AbstractNsResourceAllocationAlgorithm {
	
	private static final Logger log = LoggerFactory.getLogger(BluespaceAitAlgorithm.class);

	private String aitAlgorithmUrl;
	private VnfPackageManagementService vnfPackageManagementService;
	private Map<String, String> properties;
	private PnfManagementService pnfManagementService;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	Map<String, LocationInfo> geographicalAreas = new HashMap<>();
	
	private AitAlgorithmRestClient restClient;
	
	public BluespaceAitAlgorithm(String aitAlgorithmUrl,
			VnfPackageManagementService vnfPackageManagementService,
			Map<String, String> properties,
			PnfManagementService pnfManagementService) {
		super(AlgorithmType.BLUESPACE_AIT);
		this.aitAlgorithmUrl = aitAlgorithmUrl;
		this.vnfPackageManagementService = vnfPackageManagementService;
		this.pnfManagementService = pnfManagementService;
		this.properties = properties;
		this.restClient = new AitAlgorithmRestClient(aitAlgorithmUrl, restTemplate);
		geographicalAreas = StaticGeographicalAreas.getGeographicalAreas();
	}
	
	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
			InstantiateNsRequest request,
			Nsd nsd,
			Map<Vnfd, Map<String, String>> vnfds,
			VimPlugin vimPlugin,
			SdnControllerPlugin sdnPlugin,
			VnfmHandler vnfmHandler,
			Map<String, Pnfd> pnfds,
			Map<String, List<PnfInstance>> pnfInstances
	)
			throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
		log.debug("Computing resource allocation solution through BlueSPACE algorithm.");
		
		//TODO:
		throw new ResourceAllocationSolutionNotFound();
	}
	
	private BluespaceAlgorithmAllocationRequest buildBluespaceRcRequest(InstantiateNsRequest request,
			Nsd nsd,
			Map<Vnfd, Map<String, String>> vnfds) throws NotExistingEntityException, FailedOperationException {
		log.debug("Building request for blueSPACE resource allocation");
		
		log.debug("Building service requests.");
		List<ServiceRequest> serviceRequests = new ArrayList<ServiceRequest>();
		List<String> serviceAreaId = translateServiceAreaId(request.getSapData());
		TransmissionMode transmissionMode = translateServiceTypeToTransmissionMode(request.getServiceType());
		Map<String, VmRequirements> vmRequirements = translateVmRequirements(vnfds);
		ServiceRequest serviceRequest = new ServiceRequest(request.getNsInstanceId(),	//service ID 
				serviceAreaId,
				transmissionMode, 
				vmRequirements);			//VM ID: VNFD_ID-INDEX-VDU_ID
		serviceRequests.add(serviceRequest);
		
		log.debug("Setting geographical areas.");
		List<GeographicalArea> geoAreas = readGeographicalAreas();
		
		log.debug("Setting datarate.");
		Map<TransmissionMode, Double> datarate = buildDatarate();
		
		log.debug("Retrieving RRHs.");
		List<Rrh> rrhs = new ArrayList<>();
		List<PnfInstance> rrhPnfs = pnfManagementService.getPnfInstancedFromType(PnfType.RRH);
		for (PnfInstance rrhPnf : rrhPnfs) {
			String rrhId = rrhPnf.getPnfInstanceId();
			List<RrhBeam> beams = new ArrayList<RrhBeam>();
			//TODO: retrieve information about the PNF instance status. It may be based on a PNF Instance REST Client that adopts the same interface of the PNF
			Rrh rrh = new Rrh(rrhId, beams);
		}
		
		//TODO:
		
		log.debug("Retrieving nodes in network topology from SDN controller.");
		List<BluespaceNode> nodes = new ArrayList<>();
		//TODO:
		
		log.debug("Retrieving managed servers from VIM.");
		List<PhysicalServer> servers = new ArrayList<>();
		//TODO:
		
		BluespaceAlgorithmAllocationRequest outputRequest = 
				new BluespaceAlgorithmAllocationRequest(serviceRequests, 
						geoAreas, 
						datarate, 
						rrhs, 
						nodes, 
						servers);
		log.debug("Request built");
		return outputRequest;
	}
	
	private List<String> translateServiceAreaId(List<SapData> sapData) throws FailedOperationException {
		List<String> serviceAreaIds = new ArrayList<>();
		
		boolean found = false;
		boolean foundSolution = false;
		for (SapData sd : sapData) {
			LocationInfo location = sd.getLocationInfo();
			if (location != null) {
				found = true;
				String areaId = getAreaIdFromGeoCoordinates(location.getLatitude(), location.getLongitude(), location.getRange());
				if (areaId != null) {
					foundSolution = true;
					if (!(serviceAreaIds.contains(areaId))) serviceAreaIds.add(areaId);
				}
			}
		}
		
		if (!found) {
			log.debug("Location not specified in service request. Using the first as default one.");
			serviceAreaIds.add(geographicalAreas.keySet().iterator().next());
		}
		
		if (!foundSolution) {
			log.error("Unable to find an area to cover the service");
			throw new FailedOperationException("Unable to find an area to cover the service");
		}
		
		return serviceAreaIds;
	}
	
	/**
	 * Get the ID of the geographical area (from the configured ones) that covers the input area
	 * 
	 * @param latitude lat of the centre of the target area
	 * @param longitude lat of the centre of the target area
	 * @param range radius of the target area
	 * @return ID of the area covering the given space or null if not existing
	 */
	private String getAreaIdFromGeoCoordinates(double latitude, double longitude, float range) {
		for (Map.Entry<String, LocationInfo> e : geographicalAreas.entrySet()) {
			LocationInfo li = e.getValue();
			if (isAreaIncluded(latitude, longitude, range, li.getLatitude(), li.getLongitude(), li.getRange())) {
				log.debug("Found geographical area to cover (" + latitude + ", " + longitude + ", " + range + "): area ID " + e.getKey());
				return e.getKey();
			}
		}
		return null;
	}
	
	/**
	 * Checks if a circular area is included in another circular area
	 * 
	 * @param latitude1 lat of the smaller area
	 * @param longitude1 long of the smaller area
	 * @param range1 radius of the smaller area
	 * @param latitude lat of the bigger area
	 * @param longitude long of the bigger area
	 * @param range radius of the bigger area
	 * @return true if the smaller area is included in the bigger one
	 */
	private boolean isAreaIncluded(double latitude1, double longitude1, float range1, double latitude, double longitude, float range) {
		if (range1 > range) return false;
		double distance = Math.pow((latitude1 - latitude) * (latitude1 - latitude) + (longitude1 + longitude) * (longitude1 + longitude), 0.5);
		if (distance <= (range - range1)) return true;
		else return false;
	}
	
	/**
	 * Translate between service type and transmission mode used in blueSPACE
	 * 
	 * @param serviceType service type defined in the request. Acceptable values are EMBB, MTC and URLLC.
	 * @return the transmission mode
	 */
	private TransmissionMode translateServiceTypeToTransmissionMode(String serviceType) {
		if (serviceType == null) return TransmissionMode.M1;
		if (serviceType.equals("EMBB")) return TransmissionMode.M2;
		else if (serviceType.equals("MTC")) return TransmissionMode.M3;
		else if (serviceType.equals("URLLC")) return TransmissionMode.M4;
		else return TransmissionMode.M1;
	}
	
	/**
	 * Read the VMs requirements from the VNFDs.
	 * 
	 * @param vnfds information about the VNFs included in the NS to be established
	 * @return the VM requirements
	 * @throws NotExistingEntityException if some entity is not found within the VFN
	 */
	private Map<String, VmRequirements> translateVmRequirements(Map<Vnfd, Map<String, String>> vnfds) throws NotExistingEntityException {
		log.debug("Translating VM requirements for VNF instances included in the Network Service");
		Map<String, VmRequirements> vmReqs = new HashMap<>();
		
		for (Map.Entry<Vnfd, Map<String,String>> e : vnfds.entrySet()) {
			Vnfd vnfd = e.getKey();
			Map<String,String> vnfInfo = e.getValue();
			String vnfdId = vnfInfo.get("VNFD_ID");
			String vnfFlavourId = vnfInfo.get("VNF_DF_ID");
			int vnfInstances = Integer.parseInt(vnfInfo.get("VNF_INSTANCES"));
			String vnfInstantiationLevel = vnfInfo.get("VNF_INSTANTIATION_LEVEL");
			
			for (int i=0; i<vnfInstances; i++) {
				//here we are assuming VNF with single VDU
				InstantiationLevel il = vnfd.getVnfDf(vnfFlavourId).getInstantiationLevel(vnfInstantiationLevel);
				VduLevel vduLevel = il.getVduLevel().get(0);
				String vduId = vduLevel.getVduId();
				
				Vdu vdu = vnfd.getVduFromId(vduId);
				String vcdId = vdu.getVirtualComputeDesc();
				String vsdId = vdu.getVirtualStorageDesc().get(0);
				
				VirtualComputeDesc vcd = vnfd.getVirtualComputeDescriptorFromId(vcdId);
				int vCpuNumber = vcd.getVirtualCpu().getNumVirtualCpu();
				int memory = vcd.getVirtualMemory().getVirtualMemSize();
				int storage = vnfd.getVirtualStorageDescriptorFromId(vsdId).getSizeOfStorage();
				
				String vmId = vnfdId + "-" + i + "-" + vduId;
				
				VmRequirements vmr = new VmRequirements(vCpuNumber, 
						memory, 
						storage, 
						0, 		//network
						0, 		//GPU
						null, 	//CPU level 
						null);	//GPU level
				
				vmReqs.put(vmId, vmr);
				log.debug("Added VM requirements for VM " + vmId);
			}
		}
		
		return vmReqs;
	}
	
	private List<GeographicalArea> readGeographicalAreas() {
		List<GeographicalArea> gas = new ArrayList<>();
		for (Map.Entry<String, LocationInfo> e : geographicalAreas.entrySet()) {
			gas.add(new GeographicalArea(e.getKey()));
		}
		return gas;
	}
	
	private Map<TransmissionMode, Double> buildDatarate() {
		Map<TransmissionMode, Double> datarate = new HashMap<>();
		//from D4.6 - to be double checked
		datarate.put(TransmissionMode.M1, 1216D);
		datarate.put(TransmissionMode.M2, 1419D);
		datarate.put(TransmissionMode.M3, 2838D);
		datarate.put(TransmissionMode.M4, 5677D);
		return datarate;
	}
	
	private NsResourceSchedulingSolution translateBluespaceRcSolution(BluespaceAlgorithmAllocationResponse response) {
		//TODO: 
		return null;
	}

}
