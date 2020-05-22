package it.nextworks.nfvmano.timeo.rc.algorithms;

import io.swagger.client.api.TopologycontextApi;
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

    private VnfPackageManagementService vnfPackageManagementService;
    private Map<String, String> properties;
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


    public BluespaceObfnAlgorithm(String aitAlgorithmUrl,
                                  VnfPackageManagementService vnfPackageManagementService,
                                  Map<String, String> properties,
                                  PnfManagementService pnfManagementService,
                                  TaskExecutor taskExecutor

    ) {
        super(AlgorithmType.BLUESPACE_AIT);
        this.vnfPackageManagementService = vnfPackageManagementService;
        this.pnfManagementService = pnfManagementService;
        this.properties = properties;
        this.restClient = new AitAlgorithmRestClient(aitAlgorithmUrl, restTemplate);
        geographicalAreas = StaticGeographicalAreas.getGeographicalAreas();
        this.taskExecutor=taskExecutor;
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

        Map<String,String> vmAllocation = sr.getVmAllocation();
        List<VnfResourceAllocation> vnfResourceAllocation = new ArrayList<>();

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
        }

        log.debug("Processing PNF allocation response");
        //key: ID of the geographical area; value: resource allocation in RRHs
        List<PnfAllocation> pnfAllocation = new ArrayList<>();
        /*Map<String, SubcarrierResourceAllocation> rrhResourceAllocation = sr.getRrhResourceAllocation();
        if (rrhResourceAllocation != null) {
            for (Map.Entry<String, SubcarrierResourceAllocation> e : rrhResourceAllocation.entrySet()) {
                SubcarrierResourceAllocation sra = e.getValue();
                //key: rrh ID, key: beam ID, key: subchannel ID, value: list of subcarrierIds
                Map<String, Map<String , Map<String, List<String>>>> subcarrierResourceAllocation = sra.getSubcarrierResourceAllocation();

                int index = 0;
                for (Map.Entry<String, Map<String , Map<String, List<String>>>> e1 : subcarrierResourceAllocation.entrySet()) {
                    String rrhId = e1.getKey();
                    Map<String, String> rrhConfigurationParameters = this.getRrhConfigurationParameters(rrhId);
                    PnfInstance pnfInstance = pnfManagementService.getPnfInstance(rrhId);
                    PnfAllocation pa = new PnfAllocation(
                            null,																//nsRss
                            pnfInstance.getPnfdId(), 			//pnfdId
                            pnfInstance.getPnfdVersion(),     	//pnfdVersion
                            index,
                            rrhId,																//pnfInstanceId
                            null,																//pnfProfileId
                            rrhConfigurationParameters                            //parameters

                    );
                    index++;
                    pnfAllocation.add(pa);
                }
            }
        }
        //Note: for the moment BBUs are ignored since no need to configure them

        log.debug("Processing network path response");
        //Note: this is not needed for AROF
        List<InterDcNetworkPath> interDcNetworkPaths = new ArrayList<>();
        List<LightPath> lightpaths = sr.getLightpaths();
        int pathIndex = 0;
        for (LightPath lp : lightpaths) {
            String bbuId = lp.getBbuId();
            String rrhId = lp.getRrhId();

            List<LightpathHop> origHops = lp.getHops();
            int hopsNumber =0;
            List<NetworkPathHop> hops = new ArrayList<>();
            if(origHops!=null && !origHops.isEmpty()){
                hopsNumber = origHops.size();

                int hopNumber = 0;
                String ingressServiceInterfacePoint = null;
                String egressServiceInterfacePoint = null;
                boolean first = false;
                boolean last = false;
                String ingressPortId = null;
                String lastNodeId = null;
                String lastPortId = null;

                for (LightpathHop origHop : origHops) {
                    if (hopNumber == 0) {
                        ingressServiceInterfacePoint = pnfManagementService.getPnfInstance(rrhId).getPorts().get(0).getServiceInterfacePointId();
                        first = true;
                        //it is the first hop, so the ingress port ID can be determined from the SIP
                        ingressPortId = findNetworkNodePortAssociatedToSip(origHop.getNodeId(), ingressServiceInterfacePoint);
                    } else {
                        //need to find the ingress Port ID as neighbour of the egress port of the previous hop
                        KeyValuePair ingress = getNeighbour(lastNodeId, lastPortId);
                        ingressPortId = ingress.getValue();
                    }
                    if (hopNumber == (hopsNumber - 1)) {
                        egressServiceInterfacePoint = pnfManagementService.getPnfInstance(bbuId).getPorts().get(0).getServiceInterfacePointId();
                        last = true;
                    }
                    NetworkPathHop nph = new NetworkPathHop(
                            hopNumber,
                            origHop.getNodeId(),                 //nodeId
                            ingressPortId,
                            origHop.getPortId(),                //egressPortId
                            null,                                //incomingLinkId - not used here
                            null,                                //outgoingLinkId - not used here
                            0,                                    //hopQueue - not used here
                            first,
                            last,
                            ingressServiceInterfacePoint,
                            egressServiceInterfacePoint
                    );
                    hops.add(nph);
                    hopNumber++;
                    ingressServiceInterfacePoint = null;
                    egressServiceInterfacePoint = null;
                    first = false;
                    last = false;
                    ingressPortId = null;
                    lastNodeId = origHop.getNodeId();
                    lastPortId = origHop.getPortId();
                }
            }else{


                NetworkPathHop nph = computeFreeArofNetworkPathHop(pnfManagementService.getPnfInstance(bbuId), pnfManagementService.getPnfInstance(rrhId));
                hops.add(nph);
            }

            //TODO: Fixed to AROF for demo purposes
            //String npId="np" + pathIndex;
            String npId = UUID.randomUUID().toString();

            InterDcNetworkPath idnp = new InterDcNetworkPath(npId,
                    hops,
                    SbNetworkPathType.AROF);
            pathIndex++;
            interDcNetworkPaths.add(idnp);
        }

        NsResourceSchedulingSolution solution = new NsResourceSchedulingSolution(
                sr.getServiceId(),				//nsInstanceId
                vnfResourceAllocation,
                pnfAllocation,
                null,							//networkPaths
                interDcNetworkPaths,
                true, 							//solutionFound
                null,							//networkNodesToBeActivated
                null 							//computeNodesToBeActivated
        );
*/
        return null;
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


    private String findFirstPnfInstanceServiceInterfacePointId(PnfInstance pnfInstance){
        Optional<PhysicalEquipmentPort> optPort = pnfInstance.getPorts().stream()
                .filter(p -> p.getServiceInterfacePointId()!=null)
                .findFirst();
        if(optPort.isPresent()){
            return optPort.get().getServiceInterfacePointId();
        }else return null;
    }

   private boolean isNetworkPathAvailable(NetworkPathHop nph, List<SbNetworkPath>  activePaths){

        for(SbNetworkPath sbNetworkPath: activePaths){
            for(NetworkPathHop activeNph : sbNetworkPath.getHops()){
                String activeIngress = activeNph.getIngressServiceInterfacePoint();
                String activeEgress = activeNph.getEgressServiceInterfacePoint();
                String currentIngress = nph.getIngressServiceInterfacePoint();
                String currentEgress = nph.getEgressServiceInterfacePoint();
                if(currentIngress.equals(activeIngress)&&currentEgress.equals(activeEgress))
                    return false;
            }
        }
        return true;
   }


    private NetworkPathHop computeFreeArofNetworkPathHop(PnfInstance bbuInstance, PnfInstance rrhInstance) throws NotExistingEntityException, NoNetworkPathAvailableException {
        String bbuInstanceId = bbuInstance.getPnfInstanceId();
        String rrhInstanceId = rrhInstance.getPnfInstanceId();
        log.debug("Computing ingress and egress SIPs for bbu:"+bbuInstanceId+" and rrh:"+rrhInstanceId);

        try {
            List <SbNetworkPath> activePaths = sdnPlugin.getActivePaths();
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
                    String ingressServiceInterfacePoint = rrhSip;
                    String egressServiceInterfacePoint = bbuSip;
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
                    if(isNetworkPathAvailable(nph, activePaths)){
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
}

