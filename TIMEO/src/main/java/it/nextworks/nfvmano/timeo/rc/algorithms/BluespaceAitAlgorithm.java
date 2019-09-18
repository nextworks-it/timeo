package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.*;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.RrhInfoRestClient;
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
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.StaticGeographicalAreas;
import it.nextworks.nfvmano.timeo.rc.elements.InterDcNetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi.TapiTopologyCp;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.VnfRestClient;

public class BluespaceAitAlgorithm extends AbstractNsResourceAllocationAlgorithm {

    private static final Logger log = LoggerFactory.getLogger(BluespaceAitAlgorithm.class);

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


    public BluespaceAitAlgorithm(String aitAlgorithmUrl,
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
            BluespaceAlgorithmAllocationRequest localRequest = buildBluespaceRcRequest(request,
                    nsd,
                    vnfds);
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

            RrhInfoRestClient rrhInfoRestClient = new RrhInfoRestClient(new RestTemplate(), rrhPnf.getManagementIpAddress() );

            List<RrhBeam> beams = rrhInfoRestClient.getRrhInfoValue(new GeneralizedQueryRequest()).getRrhBeams();
            //this.getRrhBeams(rrhId);

            //TODO: retrieve information about the PNF instance status. It may be based on a PNF Instance REST Client that adopts the same interface of the PNF. At the moment ignored
            Rrh rrh = new Rrh(rrhId, beams);
            //TODO: model info in PNF instance + read info from metadata to fill beams element
            rrhs.add(rrh);
        }

        log.debug("Retrieving nodes in network topology from SDN controller.");
        List<BluespaceNode> nodes = new ArrayList<>();

        try {
            if(networkTopology==null){
                networkTopology = sdnPlugin.getNetworkTopology();
            }

            List<TopologyNode> netNodes = networkTopology.nodes;
            for (TopologyNode nn : netNodes) {


                String nodeId = nn.nodeId;
                Set<TopologyCp> cps = nn.cps;
                List<BluespaceNodePort> ports = new ArrayList<>();
                for (TopologyCp cp: cps) {
                    TapiTopologyCp tcp = (TapiTopologyCp)cp;
                    String cpId = tcp.getCpId();

                    String neighbourNodeId = null;
                    String neighbourPortId = null;
                    KeyValuePair neighbourNetworkNode = getNeighbour(nodeId, cpId);
                    if (neighbourNetworkNode != null) {
                        neighbourNodeId = neighbourNetworkNode.getKey();
                        neighbourPortId = neighbourNetworkNode.getValue();
                    } else {
                        //this means a neighbour is not found on the network topology. Checking about BBU and RRH that may be connected through SIPs
                        List<String> mappedSips = tcp.getMappedServiceInterfacePoint();
                        for (String sipId : mappedSips) {
                            KeyValuePair neighbourPnf = getPnfInstanceIdFromSip(sipId);
                            if (neighbourPnf != null) {
                                neighbourNodeId = neighbourPnf.getKey();
                                neighbourPortId = neighbourPnf.getValue();

                                //Key: SIP ID; Value: Network node ID; Port ID
                                sipMappingToNetworkNodes.put(sipId, new KeyValuePair(nodeId, cpId));
                            }
                        }
                    }

                    BluespaceNodePort bnp = new BluespaceNodePort(cpId, PortType.UNSPECIFIED, neighbourNodeId, neighbourPortId, null);
                    ports.add(bnp);
                }
                BluespaceNode bn = new BluespaceNode(nodeId, BluespaceNodeType.SWITCH, BluespaceSwitchingType.SPATIAL_SPECTRAL_SWITCHING, ports);
                nodes.add(bn);
            }
        } catch (Exception e) {
            log.warn("Error while reading network topology. Computing a solution without considering network resources.");
        }

        List<PnfInstance> pnfs = pnfManagementService.getAllPnfInstances();
        for (PnfInstance pnf : pnfs) {
            PnfType type = pnf.getPnfType();
            if ( (type.equals(PnfType.BBU)) || (type.equals(PnfType.RRH))) {
                String pnfId = pnf.getPnfInstanceId();
                List<BluespaceNodePort> bnPorts = new ArrayList<>();
                List<PhysicalEquipmentPort> ports = pnf.getPorts();
                for (PhysicalEquipmentPort p : ports) {
                    String sipId = p.getServiceInterfacePointId();
                    if (sipId != null) {
                        KeyValuePair attachedNetworkNode = sipMappingToNetworkNodes.get(sipId);
                        BluespaceNodePort bnPort = new BluespaceNodePort(p.getPortId(), PortType.INGRESS, attachedNetworkNode.getKey(), attachedNetworkNode.getValue(), null);
                        bnPorts.add(bnPort);
                    }
                }
                BluespaceNodeType nodeType = BluespaceNodeType.SWITCH;
                if (type.equals(PnfType.BBU)) nodeType = BluespaceNodeType.BBU;
                else if (type.equals(PnfType.RRH)) nodeType = BluespaceNodeType.RRH;
                BluespaceNode bn = new BluespaceNode(pnfId, nodeType, BluespaceSwitchingType.NO_SWITCHING, bnPorts);
                nodes.add(bn);
            }
        }

        log.debug("Retrieving managed servers from VIM.");
        List<PhysicalServer> servers = new ArrayList<>();
        //Builds the wrapper to get info about hosts capabilities from the extended OpenStack

        try {
            VimWrapperPlugin wrapper = new VimWrapperPlugin(vimPlugin.getVim().getWrapperIp(), vimPlugin.getVim().getWrapperPort());
            List<WrapperComputeNode> computeNodes = new ArrayList<>();
            computeNodes = wrapper.getComputeDataForAlgorithm();
            for (WrapperComputeNode cn : computeNodes) {
                //the wrapper compute node includes info only about the available resources, not the total and the used one.
                //so we assume total = available and used = 0
                PhysicalServer ps = new PhysicalServer(cn.getHostId(),	//server ID
                        //Multiplied the CPU by the virtualization factor of openstack
                        cn.getvCpu()*16, 									//total CPU
                        cn.getvRam(), 									//total memory
                        cn.getvDisk(), 									//total storage
                        10000, 											//total network - static - we assume 10 Gbps
                        0,		 										//total GPU
                        null, 											//CPU level
                        null,		 									//GPU level
                        0, 												//used CPU
                        0, 												//used memory
                        0, 												//used storage
                        0,	 											//used network
                        0												//used GPU
                );
                hosts.put(cn.getHostId(), cn.getZoneId());
                servers.add(ps);
            }

        } catch (Exception e) {
            log.warn("Failure when collecting info about available servers from VIM. Computing a solution without considering computing resources.");

        }

        //TODO REMOVE THIS!, ADDED JUST FOR DEBUGGING PURPOSES
        if(servers.isEmpty()){
            log.warn("Adding fake compute server.");
            PhysicalServer server = new PhysicalServer("S1",
                    20,
                    8096,
                    100,
                    1000,
                    0,
                    null,
                    null,
                    2,
                    2048,
                    40,
                    400,
                    0);
            servers.add(server);
        }

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

    /**
     * This method returns the pair <PNF ID; port ID> of the PNF attached to the network topology through the given SIP
     *
     * @param sipId ID of the SIP the searched PNF is connected through
     * @return the pair <PNF ID; port ID> of the PNF attached to the network topology through the given SIP or null if such PNF is not configured in the system
     */
    private KeyValuePair getPnfInstanceIdFromSip(String sipId) {
        log.debug("Searching for a configured PNF instance attached to the network topology through SIP " + sipId);
        List<PnfInstance> pnfs = pnfManagementService.getAllPnfInstances();
        for (PnfInstance pnf : pnfs) {
            List<PhysicalEquipmentPort> ports = pnf.getPorts();
            for (PhysicalEquipmentPort port : ports) {
                if (sipId.equals(port.getServiceInterfacePointId())) {
                    log.debug("Found PNF attached to the network topology through SIP " + sipId + ": PNF ID " + pnf.getPnfInstanceId() + ", PNF port ID " + port.getPortId());
                    return new KeyValuePair(pnf.getPnfInstanceId(), port.getPortId());
                }
            }
        }
        log.debug("PNF not found in the system configuration.");
        return null;
    }

    /**
     * This method returns the pair <node ID; port ID> of the network neighbour node to the given network node
     *
     * @param origNodeId ID of the network node the searched neighbour should be connected to
     * @param origPortId ID of the port of the network node the searched neighbour should be connected to
     * @return the pair <node ID; port ID> of the network neighbour node to the given network node or null if such neighbour does not exist in the topology
     */
    private KeyValuePair getNeighbour (String origNodeId, String origPortId) throws Exception {
        log.debug("Searching for a neighbour node of node " + origNodeId + " and port " + origPortId + "  in network topology.");

        if(networkTopology==null)
            networkTopology = sdnPlugin.getNetworkTopology();

        List<TopologyLink> links = networkTopology.links;

        for (TopologyLink l : links) {
            if ( (origNodeId.equals(l.destination.nodeId)) && (origPortId.equals(l.destinationCp.cpId)) ) {
                log.debug("Found neighbour in network topology with node ID " + l.source.nodeId + " and port ID " + l.sourceCp.cpId);
                return new KeyValuePair(l.source.nodeId, l.sourceCp.cpId);
            }
            if ( (origNodeId.equals(l.source.nodeId)) && (origPortId.equals(l.sourceCp.cpId)) ) {
                log.debug("Found neighbour in network topology with node ID " + l.destination.nodeId + " and port ID " + l.destinationCp.cpId);
                return new KeyValuePair(l.destination.nodeId, l.destinationCp.cpId);
            }
        }
        log.debug("Neighbour node not found in the network topology");
        return null;
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

    private String findNetworkNodePortAssociatedToSip(String nodeId, String sipId) throws Exception {
        if(networkTopology==null)
            networkTopology = sdnPlugin.getNetworkTopology();
        List<TopologyNode> netNodes = networkTopology.nodes;
        for (TopologyNode nn : netNodes) {
            if (nodeId.equals(nn.nodeId)) {
                Set<TopologyCp> cps = nn.cps;
                for (TopologyCp cp: cps) {
                    TapiTopologyCp tcp = (TapiTopologyCp)cp;
                    List<String> mappedSips = tcp.getMappedServiceInterfacePoint();
                    for (String sId : mappedSips) {
                        if (sipId.equals(sId)) return tcp.getCpId();
                    }
                }
            }
        }
        return null;
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
        Map<String, SubcarrierResourceAllocation> rrhResourceAllocation = sr.getRrhResourceAllocation();
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
                String ingressServiceInterfacePoint = this.findFirstPnfInstanceServiceInterfacePointId(pnfManagementService.getPnfInstance(rrhId));
                String egressServiceInterfacePoint = this.findFirstPnfInstanceServiceInterfacePointId(pnfManagementService.getPnfInstance(bbuId));
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

        return solution;
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




}
