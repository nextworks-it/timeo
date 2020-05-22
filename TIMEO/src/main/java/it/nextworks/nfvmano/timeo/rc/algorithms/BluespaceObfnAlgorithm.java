package it.nextworks.nfvmano.timeo.rc.algorithms;


import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.*;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceNodeType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.BluespaceSwitchingType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.PortType;
import it.nextworks.nfvmano.libs.bluespace.algorithm.enums.TransmissionMode;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.elements.KeyValuePair;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualComputeDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.LocationInfo;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.SapData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.elements.IndicatorInformation;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PhysicalEquipmentPort;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfType;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.AitAlgorithmRestClient;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.RrhInfoRestClient;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.StaticGeographicalAreas;
import it.nextworks.nfvmano.timeo.rc.elements.*;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.Topology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiCpDirection;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiSupportedWavelength;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiTopologyCp;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiTopologyObfnCp;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class BluespaceObfnAlgorithm extends AbstractNsResourceAllocationAlgorithm {

    private static final Logger log = LoggerFactory.getLogger(BluespaceObfnAlgorithm.class);
    private Map<String, String> raProperties;

    private VnfPackageManagementService vnfPackageManagementService;
    private PnfManagementService pnfManagementService;

    private RestTemplate restTemplate = new RestTemplate();

    private Map<String, LocationInfo> geographicalAreas = new HashMap<>();

    //Key: host ID; Value: zone ID
    private Map<String, String> hosts = new HashMap<>();

    //Key: SIP ID; Value: Network node ID; Port ID
    private Map<String, KeyValuePair> sipMappingToNetworkNodes = new HashMap<>();

    private AitAlgorithmRestClient restClient;

    private VimPlugin vimPlugin;
    private SdnControllerPlugin sdnPlugin;
    private TaskExecutor taskExecutor;
    private NetworkTopology networkTopology;
    private Nsd nsd;
    private Map<Vnfd, Map<String,String>> vnfdMap;

    /**
     *
     * @param aitAlgorithmUrl url of the server
     * @param vnfPackageManagementService
     * @param pnfManagementService
     * @param taskExecutor
     * @param raProperties additional properties required by the RA algorithm
     *
     */
    public BluespaceObfnAlgorithm(String aitAlgorithmUrl,
                                  VnfPackageManagementService vnfPackageManagementService,

                                  PnfManagementService pnfManagementService,
                                  TaskExecutor taskExecutor,
                                  Map<String, String> raProperties

    ) {
        super(AlgorithmType.BLUESPACE_AIT);
        this.vnfPackageManagementService = vnfPackageManagementService;
        this.pnfManagementService = pnfManagementService;

        this.restClient = new AitAlgorithmRestClient(aitAlgorithmUrl, restTemplate);
        geographicalAreas = StaticGeographicalAreas.getGeographicalAreas();
        this.taskExecutor=taskExecutor;
        this.raProperties = raProperties;
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

        this.vimPlugin = vimPlugin;
        this.sdnPlugin = sdnPlugin;
        try {
            List<PnfInstance> pnfs = pnfManagementService.getAllPnfInstances();

            List<PhysicalServer> computeNodes =getAvailableComputeNodes();
            NetworkTopology networkTopology =  sdnPlugin.getNetworkTopology();
            BluespaceAlgorithmAllocationRequest localRequest = buildBluespaceRcRequest(request,
                    vnfds,
                    pnfs,
                    computeNodes, networkTopology);
            BluespaceAlgorithmAllocationResponse remoteResponse = restClient.computeAllocation(localRequest);
            if ((remoteResponse == null) || (!(remoteResponse.hasSuccessfulResponse()))) throw new ResourceAllocationSolutionNotFound("Null response from the remote algorithm.");
            log.debug("Received response from remote algorithm");
            NsResourceSchedulingSolution localResponse = translateBluespaceRcSolution(remoteResponse);
            log.debug("Successfully translated bluespace algorithm response into local response format");
            return localResponse;
        } catch (FailedOperationException e) {
            log.error("Failed resource computation for NS instance " + request.getNsInstanceId() + ": " + e.getMessage());
            throw new ResourceAllocationSolutionNotFound("Failed resource computation for NS instance " + request.getNsInstanceId() + ": " + e.getMessage());
        } catch (Exception e) {
            log.error("Generic error: " + e.getMessage());
            throw new ResourceAllocationSolutionNotFound("Generic error: " + e.getMessage());
        }
    }

    public static BluespaceAlgorithmAllocationRequest buildBluespaceRcRequest(InstantiateNsRequest request,
                                                                              Map<Vnfd, Map<String, String>> vnfds,
                                                                              List<PnfInstance> pnfInstances,
                                                                              List<PhysicalServer> computeNodes,
                                                                              NetworkTopology topology) throws NotExistingEntityException, FailedOperationException {
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



        List<PnfInstance> rrhPnfs = pnfInstances.stream()
                .filter(pnfI -> pnfI.getPnfType().equals(PnfType.RRH))
                .collect(Collectors.toList());

        List<PnfInstance> bbuPnfs = pnfInstances.stream()
                .filter(pnfI -> pnfI.getPnfType().equals(PnfType.BBU))
                .collect(Collectors.toList());

        log.debug("Retrieving RRHs.");
        List<Rrh> rrhs =  translateRrhInfo(rrhPnfs);
        List<Bbu> bbus = translateBbuInfo(bbuPnfs);

        log.debug("Retrieving nodes in network topology from SDN controller.");
        List<BluespaceNode> nodes = translateBluespaceTopologyNodes(topology, pnfInstances);

        log.debug("Retrieving managed servers from VIM.");


        BluespaceAlgorithmAllocationRequest outputRequest =
                new BluespaceAlgorithmAllocationRequest(serviceRequests,
                        geoAreas,
                        datarate,
                        rrhs,
                        nodes,
                        computeNodes, bbus);
        log.debug("Request built");
        return outputRequest;
    }


    private static List<Rrh> translateRrhInfo(List<PnfInstance> rrhPnfs) throws FailedOperationException {
        List<Rrh> rrhs = new ArrayList<>();
        for (PnfInstance rrhPnf : rrhPnfs) {
            String rrhId = rrhPnf.getPnfInstanceId();

            //RrhInfoRestClient rrhInfoRestClient = new RrhInfoRestClient(new RestTemplate(), rrhPnf.getManagementIpAddress() );

            //List<RrhBeam> beams = rrhInfoRestClient.getRrhInfoValue(new GeneralizedQueryRequest()).getRrhBeams();


            //TODO: retrieve information about the PNF instance status. It may be based on a PNF Instance REST Client that adopts the same interface of the PNF. At the moment ignored
            Rrh rrh = new Rrh(rrhId, null);
            //TODO: model info in PNF instance + read info from metadata to fill beams element
            rrhs.add(rrh);
        }
        return rrhs;
    }


    private static List<Bbu> translateBbuInfo(List<PnfInstance> bbuPnfs){
        List<Bbu> bbus = new ArrayList<>();
        for (PnfInstance bbu : bbuPnfs) {
            String bbuId = bbu.getPnfInstanceId();

            //RrhInfoRestClient rrhInfoRestClient = new RrhInfoRestClient(new RestTemplate(), rrhPnf.getManagementIpAddress() );

            //List<RrhBeam> beams = rrhInfoRestClient.getRrhInfoValue(new GeneralizedQueryRequest()).getRrhBeams();


            //TODO: retrieve information about the PNF instance status. It may be based on a PNF Instance REST Client that adopts the same interface of the PNF. At the moment ignored
            Bbu bbuD = new Bbu(bbuId);
            //TODO: model info in PNF instance + read info from metadata to fill beams element
            bbus.add(bbuD);
        }
        return bbus;

    }
    /**
     * This method returns the pair <PNF ID; port ID> of the PNF attached to the network topology through the given SIP
     *
     * @param sipId ID of the SIP the searched PNF is connected through
     * @return the pair <PNF ID; port ID> of the PNF attached to the network topology through the given SIP or null if such PNF is not configured in the system
     */
    private static  KeyValuePair getPnfInstanceIdFromSip(String sipId, List<PnfInstance> pnfs) {
        log.debug("Searching for a configured PNF instance attached to the network topology through SIP " + sipId);

        for (PnfInstance pnf : pnfs) {
            List<PhysicalEquipmentPort> ports = pnf.getPorts();
            if(ports!=null){
                for (PhysicalEquipmentPort port : ports) {
                    if (sipId.equals(port.getServiceInterfacePointId())) {
                        log.debug("Found PNF attached to the network topology through SIP " + sipId + ": PNF ID " + pnf.getPnfInstanceId() + ", PNF port ID " + port.getPortId());
                        return new KeyValuePair(pnf.getPnfInstanceId(), port.getPortId());
                    }
                }
            }

        }
        log.debug("PNF not found in the system configuration.");
        return null;
    }


    public List<PhysicalServer> getAvailableComputeNodes(){

        //VimWrapperPlugin wrapper = new VimWrapperPlugin(vimPlugin.getVim().getWrapperIp(), vimPlugin.getVim().getWrapperPort());
        log.warn("Adding fake compute server.");
        List<PhysicalServer> computeNodes = new ArrayList<>();
        PhysicalServer cn = new PhysicalServer("server-id", 16, 16, 200000, 0, 0, "CPU_LEVEL", "GPU_LEVEL",0,0,0,0,0);

        computeNodes.add(cn);
        return computeNodes;

    }


    public static List<BluespaceNode> translateBluespaceTopologyNodes(NetworkTopology networkTopology, List<PnfInstance> pnfInstances) throws FailedOperationException {




        List<BluespaceNode> bpNodes = new ArrayList<>();
        List<TopologyNode> netNodes = networkTopology.nodes;
        if(netNodes.size()>1) throw new FailedOperationException("Wrong number of nodes in the OBFN topology");
        String mainNodeId = netNodes.get(0).nodeId;
        //id pnfInstanceId, value list of BluespaceNodePort

        Map<String, List<BluespaceNodePort>> pnfInstancePorts = new HashMap<>();
        List<BluespaceNodePort> mainPorts = new ArrayList<>();
        for (TopologyCp tCp : netNodes.get(0).cps) {
            KeyValuePair pnfIPort = getPnfInstanceIdFromSip(tCp.getCpId(), pnfInstances);
            String pnfPortId =null;
            String pnfIId = null;
            if(pnfIPort!=null){
                List<BluespaceNodePort> ports = pnfInstancePorts.get(pnfIPort.getKey());
                if(ports==null)
                    ports= new ArrayList<>();
                pnfPortId =  pnfIPort.getValue();
                pnfIId = pnfIPort.getKey();
                BluespaceNodePort pnfPort = new BluespaceNodePort(pnfPortId, PortType.UNSPECIFIED, mainNodeId, tCp.getCpId(), null, null);
                ports.add(pnfPort);
                pnfInstancePorts.put(pnfIPort.getKey(), ports);

            }else log.debug("No PnfInstance attached to:"+tCp.getCpId()+", IGNORING");
            PortType mainPortType = getPortType(((TapiTopologyObfnCp)tCp).getDirection());
            BluespaceObfnCpSpec obfnCpSpec = getBluespaceObfnCpSpec((TapiTopologyObfnCp) tCp);
            mainPorts.add(new BluespaceNodePort(tCp.cpId, mainPortType, pnfIId, pnfPortId, null, obfnCpSpec  ));
        }
        for(String pnfInstanceId : pnfInstancePorts.keySet()) {
            bpNodes.add(new BluespaceNode(pnfInstanceId, getPnfInstaceNodeType(pnfInstances, pnfInstanceId), BluespaceSwitchingType.NO_SWITCHING, pnfInstancePorts.get(pnfInstanceId) ));
        }
        BluespaceNode bnMain = new BluespaceNode(mainNodeId, BluespaceNodeType.SWITCH, BluespaceSwitchingType.SPATIAL_SPECTRAL_SWITCHING, mainPorts);
        bpNodes.add(bnMain);
        return bpNodes;
    }

    private static BluespaceObfnCpSpec getBluespaceObfnCpSpec(TapiTopologyObfnCp cp){
        TapiSupportedWavelength tswl = cp.getTapiObfnCpSpec().getTapiSupportedWavelength();
        BluespaceFrequencyConstraint fc = new BluespaceFrequencyConstraint(tswl.getTapiFrequencyConstraint().getAdjustmentGranularity(), tswl.getTapiFrequencyConstraint().getAdjustmentGranularity());
        BluespaceSupportedWavelength sw = new BluespaceSupportedWavelength(tswl.getUpperFrequency(), tswl.getLowerFrequency(), fc);
        return new BluespaceObfnCpSpec(cp.getTapiObfnCpSpec().getSupportedLowerAngle(), cp.getTapiObfnCpSpec().getSupportedUpperAngle(), cp.getTapiObfnCpSpec().getSupportedMinWidth(),
                cp.getTapiObfnCpSpec().getSupportedMaxwidth(), cp.getTapiObfnCpSpec().getSupportedBeams(), sw);

    }
    private static PortType getPortType(TapiCpDirection direction){
        if(direction.equals(TapiCpDirection.INPUT))
            return PortType.INGRESS;
        else if(direction.equals(TapiCpDirection.OUTPUT))
            return PortType.EGRESS;
        else return PortType.UNSPECIFIED;

    }

    private static  List<String> translateServiceAreaId(List<SapData> sapData) throws FailedOperationException {
        List<String> serviceAreaIds = new ArrayList<>();
        Map<String, LocationInfo> geographicalAreas = StaticGeographicalAreas.getGeographicalAreas();
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
    private static String getAreaIdFromGeoCoordinates(double latitude, double longitude, float range) {

        Map<String, LocationInfo> geographicalAreas =  StaticGeographicalAreas.getGeographicalAreas();
        for (Map.Entry<String, LocationInfo> e : geographicalAreas.entrySet()) {
            LocationInfo li = e.getValue();
            if (isAreaIncluded(latitude, longitude, range, li.getLatitude(), li.getLongitude(), li.getRange())) {
                log.debug("Found geographical area to cover (" + latitude + ", " + longitude + ", " + range + "): area ID " + e.getKey());
                return e.getKey();
            }
        }
        log.warn("Found geographical area to cover (" + latitude + ", " + longitude + ", " + range + "): Not found, using default: " + StaticGeographicalAreas.getDefaultAreaId());
        return StaticGeographicalAreas.getDefaultAreaId();
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
    private static boolean isAreaIncluded(double latitude1, double longitude1, float range1, double latitude, double longitude, float range) {
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
    private static TransmissionMode translateServiceTypeToTransmissionMode(String serviceType) {
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
    private static Map<String, VmRequirements> translateVmRequirements(Map<Vnfd, Map<String, String>> vnfds) throws NotExistingEntityException {
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

    private static List<GeographicalArea> readGeographicalAreas() {
        Map<String, LocationInfo> geographicalAreas = StaticGeographicalAreas.getGeographicalAreas();
        List<GeographicalArea> gas = new ArrayList<>();
        for (Map.Entry<String, LocationInfo> e : geographicalAreas.entrySet()) {
            gas.add(new GeographicalArea(e.getKey()));
        }
        return gas;
    }

    private static Map<TransmissionMode, Double> buildDatarate() {
        Map<TransmissionMode, Double> datarate = new HashMap<>();
        //from D4.6 - to be double checked
        datarate.put(TransmissionMode.M1, 1216D);
        datarate.put(TransmissionMode.M2, 1419D);
        datarate.put(TransmissionMode.M3, 2838D);
        datarate.put(TransmissionMode.M4, 5677D);
        return datarate;
    }


    private NsResourceSchedulingSolution translateBluespaceRcSolution(BluespaceAlgorithmAllocationResponse response)
            throws MalformattedElementException, NotExistingEntityException, Exception {
        log.debug("Processing response from blueSPACE algorithm and translating it into TIMEO resource allocation format.");
        ServiceResponse sr = response.getServiceResponses().get(0);

        if (sr == null) throw new MalformattedElementException("Null service response");


        log.debug("Processing VNF allocation response");
        //Format of vmAllocation - key: ID of the VM in service; value: ID of the server where the VM must be allocated
        //Format of VM ID : vmId = vnfdId + "-" + i + "-" + vduId;

        List<VnfResourceAllocation> vnfResourceAllocations = translateRCVnfAllocation(response);
        List<PnfAllocation> pnfAllocations = translateRCPnfAllocation(response);
        List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<>();


        NsResourceSchedulingSolution solution = new NsResourceSchedulingSolution(
                sr.getServiceId(),				//nsInstanceId
                vnfResourceAllocations,
                pnfAllocations,
                null,							//networkPaths
                interDcNetworkPaths,
                true, 							//solutionFound
                null,							//networkNodesToBeActivated
                null 							//computeNodesToBeActivated
        );

        return null;
    }



    private List<VnfResourceAllocation> translateRCVnfAllocation(BluespaceAlgorithmAllocationResponse response) throws MalformattedElementException {
        log.debug("Translating RC VNF allocation");
        List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();
        Map<String, String> vmAllocation = response.getServiceResponses().get(0).getVmAllocation();
        if (vmAllocation != null) {
            for (Map.Entry<String, String> e : vmAllocation.entrySet()) {
                String fullVmId = e.getKey();
                String hostId = e.getValue();
                String zoneId = hosts.get(hostId);
                String[] vmInfo = fullVmId.split("-");
                if (vmInfo.length != 3) throw new MalformattedElementException("Wrong VM ID format.");
                String vnfdId = vmInfo[0];
                String vnfIndex = vmInfo[1];
                String vduId = vmInfo[2];
                VnfResourceAllocation vnfRes = new VnfResourceAllocation(
                        null, 							//nsRss,
                        vnfdId,
                        Integer.parseInt(vnfIndex),
                        vduId,
                        0,								//vduIndex,
                        vimPlugin.getVim().getVimId(),	//vimId
                        zoneId,
                        hostId);
                vnfResourceAllocation.add(vnfRes);
            }
        }else{
            log.debug("Empty vm allocation response, using default one");
            for(Vnfd vnfd : vnfdMap.keySet()){
                String vduId = vnfd.getVdu().get(0).getVduId();
                String vnfdId = vnfd.getVnfdId();
                String vim = raProperties.get("default_vim");
                String zoneId = raProperties.get("default_zone");
                String hostId = raProperties.get("default_compute");
                VnfResourceAllocation vnfRes = new VnfResourceAllocation(
                        null, 							//nsRss,
                        vnfdId,
                        0,
                        vduId,
                        0,								//vduIndex,
                        vim,	//vimId
                        zoneId,
                        hostId);
                vnfResourceAllocation.add(vnfRes);
            }

        }
        return vnfResourceAllocation;


    }


    private List<PnfAllocation> translateRCPnfAllocation(BluespaceAlgorithmAllocationResponse response) throws NotExistingEntityException {
        log.debug("Translating PNF resource allocations");
        List<PnfAllocation> pnfAllocation = new ArrayList<>();

        List<ObfnRrhResourceAllocation>  rrhResourceAllocations = response.getServiceResponses().get(0).getRrhResourceAllocation();
        int index = 0;
        if (rrhResourceAllocations != null) {

            for (ObfnRrhResourceAllocation rrhResourceAllocation : rrhResourceAllocations) {
                String rrhId = rrhResourceAllocation.getRrhId();
                PnfInstance pnfInstance = pnfManagementService.getPnfInstance(rrhId);
                Map<String, String> rrhConfigurationParameters = translateRCRRHConfigurationParameters(rrhResourceAllocation);
                log.debug("RRH resource allocation: "+rrhId);
                log.debug(rrhConfigurationParameters.toString());
                PnfAllocation pa = new PnfAllocation(
                        null,																//nsRss
                        pnfInstance.getPnfdId(), 			//pnfdId
                        pnfInstance.getPnfdVersion(),     	//pnfdVersion
                        index,
                        rrhId,																//pnfInstanceId
                        null,																//pnfProfileId
                        rrhConfigurationParameters                            //parameters

                );
                pnfAllocation.add(pa);
                index++;

            }
        }
        List<ObfnBbuResourceAllocation>  bbuResourceAllocations = response.getServiceResponses().get(0).getBbuResourceAllocation();
        if(bbuResourceAllocations!=null){
            for(ObfnBbuResourceAllocation bbuResourceAllocation : bbuResourceAllocations){
                String bbuId = bbuResourceAllocation.getBbuId();
                PnfInstance pnfInstance = pnfManagementService.getPnfInstance(bbuId);
                Map<String, String> bbuConfigurationParameters = translateRCBBUConfigurationParameters(bbuResourceAllocation);log.debug("BBU resource allocation: "+bbuId);
                log.debug(bbuConfigurationParameters.toString());
                PnfAllocation pa = new PnfAllocation(
                        null,																//nsRss
                        pnfInstance.getPnfdId(), 			//pnfdId
                        pnfInstance.getPnfdVersion(),     	//pnfdVersion
                        index,
                        bbuId,																//pnfInstanceId
                        null,																//pnfProfileId
                        bbuConfigurationParameters                            //parameters

                );
                pnfAllocation.add(pa);
                index++;

            }

        }
        return pnfAllocation;

    }


    private Map<String, String> translateRCRRHConfigurationParameters(ObfnRrhResourceAllocation obfnRrhResourceAllocation){

        Map<String, String> rrhConfigParams = new HashMap<>();
        rrhConfigParams.put("rxGain", Integer.toString(obfnRrhResourceAllocation.getRxGain()));
        rrhConfigParams.put("txGain",  Integer.toString(obfnRrhResourceAllocation.getTxGain()));
        rrhConfigParams.put("powerUp",  Boolean.toString(obfnRrhResourceAllocation.isPowerUp()));
        rrhConfigParams.put("sleepMode",  Boolean.toString(obfnRrhResourceAllocation.isSleepMode()));

        return rrhConfigParams;
    }

    private Map<String, String> translateRCBBUConfigurationParameters(ObfnBbuResourceAllocation obfnBbuResourceAllocation){


        /*
         *  int operationMode;
         *  int subcarriersNumber;
         *  int pilotSpacing;
            int modulationScheme;
            long intermediateFrequency;
         */
        Map<String, String> bbuConfigParams = new HashMap<>();
        bbuConfigParams.put("operationMode", Integer.toString(obfnBbuResourceAllocation.getOperationMode()));
        bbuConfigParams.put("subcarriersNumber",  Integer.toString(obfnBbuResourceAllocation.getSubcarriersNumber()));
        bbuConfigParams.put("pilotSpacing",  Integer.toString(obfnBbuResourceAllocation.getPilotSpacing()));
        bbuConfigParams.put("intermediateFrequency",  Long.toString(obfnBbuResourceAllocation.getIntermediateFrequency()));
        bbuConfigParams.put("modulationScheme",  Long.toString(obfnBbuResourceAllocation.getModulationScheme()));

        return bbuConfigParams;
    }


    private static BluespaceNodeType getPnfInstaceNodeType(List<PnfInstance> pnfInstances, String pnfInstanceId) {

        Optional<PnfInstance> optPnf = pnfInstances.stream()
                .filter(p ->p.getPnfInstanceId().equals(pnfInstanceId))
                .findFirst();
        if(optPnf.isPresent()){
            PnfType type = optPnf.get().getPnfType();
            if (type.equals(PnfType.BBU)) return BluespaceNodeType.BBU;
            else if (type.equals(PnfType.RRH)) return BluespaceNodeType.RRH;
            else return BluespaceNodeType.SWITCH;
        }else return BluespaceNodeType.SWITCH;

    }


    private List<IndicatorInformation> getPnfInstanceIndicatorInformation(PnfInstance pnfInstance) throws FailedOperationException{
        log.debug("Retrieving IndicatorInformation for pnfInstance:"+pnfInstance.getPnfInstanceId());
        RestVnfDriver restClient = new RestVnfDriver(pnfInstance.getPnfInstanceId(), pnfInstance.getManagementIpAddress(),restTemplate, taskExecutor);
        List<IndicatorInformation> result = restClient.getIndicatorValue(new GeneralizedQueryRequest(null, null)).getIndicatorInformation();
        return result;

    }


    private List<InterDcNetworkPath> translateRCInterDcNetworkPaths(BluespaceAlgorithmAllocationResponse response){

        log.debug("Translating InterDC network paths");
        List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<>();
        List<LightPath> lightPaths = response.getServiceResponses().get(0).getLightpaths();
        for(LightPath lightPath: lightPaths){
            List<NetworkPathHop> pathHops = new ArrayList<>();
            for (LightpathHop lightpathHop : lightPath.getHops()){
                String nodeId = lightpathHop.getNodeId();
                String ingressSip = lightpathHop.getInputPortId();
                String egressSip = lightpathHop.getOutputPortId();
                Map<String, String> obfnPathProps = getObfnLightPathProps(response, lightpathHop.getObfnId());
                log.debug("obfn path parameters:"+obfnPathProps.toString());
                NetworkPathHop nph = new NetworkPathHop(
                        0,
                        nodeId,                 //nodeId
                        null,
                        null,                //egressPortId
                        null,                                //incomingLinkId - not used here
                        null,                                //outgoingLinkId - not used here
                        0,                                    //hopQueue - not used here
                        true,
                        true,
                        ingressSip,
                        egressSip,
                        obfnPathProps
                );
                pathHops.add(nph);

            }

            InterDcNetworkPath idcPath = new InterDcNetworkPath(UUID.randomUUID().toString(),pathHops, SbNetworkPathType.OBFN );
            interDcNetworkPaths.add(idcPath);
        }
        return interDcNetworkPaths;

    }

    private Map<String, String> getObfnLightPathProps(BluespaceAlgorithmAllocationResponse response, String obfnId){
        log.debug("Translating obfn path parameters:"+obfnId);
        /*
         private String obfnId;
        private int beamId;
        private int beamOffsetX;
        private int beamOffsetY;
        private int beamWidth;
        private int beamAngle;
         */
        Map<String,String> obfnProps = new HashMap<>();
        List<ObfnResourceAllocation> obfnResourceAllocations = response.getServiceResponses().get(0).getObfnResourceAllocation();
        for(ObfnResourceAllocation ra : obfnResourceAllocations){
            if(ra.getObfnId().equals(obfnId)){
                obfnProps.put("beamId", Integer.toString(ra.getBeamId()));
                obfnProps.put("beamOffsetX", Integer.toString(ra.getBeamOffsetX()));
                obfnProps.put("beamOffsetY", Integer.toString(ra.getBeamOffsetY()));
                obfnProps.put("beamWidth", Integer.toString(ra.getBeamWidth()));
                obfnProps.put("beamAngle", Integer.toString(ra.getBeamAngle()));
                break;
            }
        }
        return obfnProps;


    }


    private Map<String,String> getRrhConfigurationParameters(String pnfInstanceId){

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
    }







}

