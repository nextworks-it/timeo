package it.nextworks.nfvmano.timeo.rc.algorithms;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualComputeDesc;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualStorageDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsDf;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsLevel;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Sapd;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfProfile;
import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfDf;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperFlavors;
import it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper.VimWrapperPlugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marco Capitani on 17/05/17.
 *
 * @author Marco Capitani (m.capitani AT nextworks.it)
 */
public class RequestParser {

    private static Logger log = LoggerFactory.getLogger(RequestParser.class);

    private InstantiateNsRequest request;

    private SdnControllerPlugin sdnPlugin;

    private VimPlugin vimPlugin;

    private VimWrapperPlugin wrapper;

    private Nsd nsd;

    private Map<Vnfd, Map<String, String>> vnfds;

    // Built data
    public NetworkTopology networkTopology;
    public Map<String, TopologyNode> vmPlacement = new HashMap<>();
    public Map<String, VMSize> sizes;
    public Map<LogicalLinkParameters, Double> logLinks;
    public Map<TrafficCoefficientParameters, Double> coefficients;
    private Map<String, VirtualMachine> vms;
    private Map<String, String> sap2vldId = new HashMap<>();

    public RequestParser(InstantiateNsRequest request,
                         SdnControllerPlugin sdnPlugin,
                         VimPlugin vimPlugin,
                         Nsd nsd,
                         Map<Vnfd, Map<String, String>> vnfds) {
        this(request, sdnPlugin, vimPlugin, nsd, vnfds,
                new VimWrapperPlugin(
                        vimPlugin.getVim().getWrapperIp(),
                        vimPlugin.getVim().getWrapperPort()
                )
        );
    }

    public RequestParser(InstantiateNsRequest request,
                         SdnControllerPlugin sdnPlugin,
                         VimPlugin vimPlugin,
                         Nsd nsd,
                         Map<Vnfd, Map<String, String>> vnfds,
                         VimWrapperPlugin wrapper) {
          this.request = request;
          this.sdnPlugin = sdnPlugin;
          this.vimPlugin = vimPlugin;
          this.nsd = nsd;
          this.vnfds = vnfds;
          this.wrapper = wrapper;
    }

    public Formatter makeFormatter(Formatter.FormatterSupplier factory)
            throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
        // Recover Nsdf
        NsDf nsdf = nsd.getNsDeploymentFlavour(request.getFlavourId());

        // Build Vm size map
        sizes = new HashMap<>();
        for (Map.Entry<Vnfd, Map<String, String>> e : vnfds.entrySet()) {
            buildSizes(
                    e.getKey(),
                    e.getValue().get("VNF_DF_ID"),
                    e.getValue().get("VNF_INSTANTIATION_LEVEL"),
                    Integer.parseInt(e.getValue().get("VNF_INSTANCES"))
            );
        }

        //Build the topology
        buildNetworkTopology();

        // And entry point
        TopologyNode fep = addEntryPoint();

        // Build the entry node list, while we're at it.
        List<TopologyNode> entryNodes = new ArrayList<>();
        entryNodes.add(fep);

        // Recover the vnf profiles, for VLINK info
        List<VnfProfile> vnfProfiles = nsdf.getVnfProfile();

        LogLinkBuilder linkBuilder = new LogLinkBuilder(
                vnfds,
                vnfProfiles,
                nsd.getVirtualLinkDesc(),
                nsdf.getVirtualLinkProfile(),
                nsd.getSapd(),
                fep,
                readNsLevel()
        );

        linkBuilder.buildLinks();

        logLinks = linkBuilder.getLogLinks();

        coefficients = linkBuilder.getCoefficients();

        vms = linkBuilder.vms;

        // Ok, we have everything we need.
        return factory.makeFormatter(
                networkTopology,
                new ArrayList<>(sizes.keySet()),
                sizes,
                logLinks,
                coefficients,
                entryNodes,
                vmPlacement,
                request.getNsInstanceId()
        );
    }
    
    private NsLevel readNsLevel() throws NotExistingEntityException {
    	String nsLevelId = request.getNsInstantiationLevelId();
    	NsDf nsdf = nsd.getNsDeploymentFlavour(request.getFlavourId());
    	if (nsLevelId == null) {
    		nsLevelId = nsdf.getDefaultNsInstantiationLevelId();
    	}
    	return nsdf.getNsLevel(nsLevelId);
    }

    private TopologyNode addEntryPoint() {
        TopologyNode fep = new TopologyNode("FakeEntryPoint", new HashSet<>());
        networkTopology.addNode(fep);
        for (TopologyNode node : networkTopology.nodes) {
            TopologyLink newLink = new TopologyLink(
                    "fep->" + node.nodeId,
                    fep,
                    node,
                    null,
                    null,
                    0,
                    10000000
            );
            TopologyCp fepCp = new TopologyCp(fep, newLink, null,
                    "entrysrc:" + node.nodeId, "entrysrc:" + node.nodeId, null);
            TopologyCp nodeCp = new TopologyCp(node, null, newLink,
                    "entrydest:" + node.nodeId, "entrydest:" + node.nodeId, null);
            newLink.sourceCp = fepCp;
            newLink.destinationCp = nodeCp;
            node.cps.add(nodeCp);
            fep.cps.add(fepCp);
            networkTopology.addLink(newLink);
        }
        return fep;
    }

    private void buildSizes(Vnfd vnfd, String flavourId, String instantiationLevel, int instances)
            throws NotExistingEntityException {
        VnfDf vnfDf = vnfd.getVnfDf(flavourId);
        InstantiationLevel il = vnfDf.getInstantiationLevel(instantiationLevel);
        // <instances vnfs> ...
        for (int i = 0; i < instances; i++) {
            // each containing each vdu
            for (VduLevel vduLevel : il.getVduLevel()) {
                String vduId = vduLevel.getVduId();
                Vdu vdu = vnfd.getVduFromId(vduId);
                for (int j = 0; j < vduLevel.getNumberOfInstances(); j++) {
                    String vmId = String.format("%s:%s_%s:%s", vnfd.getVnfdId(), i, vduId, j);
                    sizes.put(vmId, getSizeFromVduAndVnfd(vdu, vnfd));
                }
            }
        }
    }

    private VMSize getSizeFromVduAndVnfd(Vdu vdu, Vnfd vnfd)
            throws NotExistingEntityException {
        String virtualComputeDesc = vdu.getVirtualComputeDesc();
        VirtualComputeDesc vcd = vnfd.getVirtualComputeDescriptorFromId(virtualComputeDesc);
        int vCPUs = vcd.getVirtualCpu().getNumVirtualCpu();
        int memory = vcd.getVirtualMemory().getVirtualMemSize();
        List<String> virtualStorageDesc = vdu.getVirtualStorageDesc();
        List<VirtualStorageDesc> vsds = new ArrayList<>();
        for (String id : virtualStorageDesc) {
            vsds.add(vnfd.getVirtualStorageDescriptorFromId(id));
        }
        int hddSize = vsds.stream().mapToInt(VirtualStorageDesc::getSizeOfStorage).sum();
        return new VMSize(vCPUs, memory, hddSize);
    }

    private void addSapsToTopology(List<Sapd> sapdList) throws NotExistingEntityException {
        for (Sapd sapd : sapdList) {
            String address = getSapAddress();
            TopologyCp cp = networkTopology.getCpByAddress(address);
            if (null == cp) {
                throw new NotExistingEntityException(String.format(
                        "Cannot find interface with mac %s in topology. Should belong to %s",
                        address, sapd.getCpdId()
                ));
            }
            TopologyNode node = cp.node;
            node.vCPUs = node.vCPUs + 1;
            node.memory = node.memory + 1;
            node.hddSize = node.hddSize + 1;
            vmPlacement.put(sapd.getCpdId(), node);
            sizes.put(sapd.getCpdId(), new VMSize(1, 1, 1));
            sap2vldId.put(sapd.getCpdId(), sapd.getNsVirtualLinkDescId());
        }
    }

    private String getSapAddress() {
        return vimPlugin.getVim().getNetworkNodeMacAddress();
    }

    private void buildNetworkTopology() throws ResourceAllocationSolutionNotFound {
        try {
            NetworkTopology tempNetTopology = sdnPlugin.getNetworkTopology();
            List<WrapperComputeNode> computeData = wrapper.getComputeDataForAlgorithm();
            for (WrapperComputeNode compute : computeData) {
                TopologyCp cp = tempNetTopology.getCpByAddress(compute.getMac());
                if (null == cp) {
                    throw new NotExistingEntityException(String.format(
                            "Cannot find interface with mac %s in topology. Should belong to %s",
                            compute.getMac(), compute.getHostId()
                    ));
                }
                TopologyNode node = cp.node;
                node.idle = compute.getIdlePc();
                node.hddSize = compute.getvDisk();
                node.memory = compute.getvRam() / 1024;
                node.vCPUs = compute.getvCpu();
                node.powerState = compute.getPowerState();
                node.zoneId = compute.getZoneId();
                if (null == compute.getHostId()) {
                    throw new ResourceAllocationSolutionNotFound(new IllegalArgumentException(
                            String.format("Node %s has no vim name.", node.nodeId)
                    ));
                }
                node.vimName = compute.getHostId();
                node.setProcessing(compute.getFlavors().stream().collect(Collectors.toMap(
                        WrapperFlavors::getId,
                        WrapperFlavors::getTrafficPc
                )));
                node.setIdleVM(compute.getFlavors().stream().collect(Collectors.toMap(
                        WrapperFlavors::getId,
                        WrapperFlavors::getIdlePc
                )));
            }

            networkTopology = tempNetTopology;

            // Augment topology with SAPs
            addSapsToTopology(nsd.getSapd());

        } catch (MethodNotImplementedException
                | NotExistingEntityException
                | RemoteEntityFailureException
                | FailedOperationException e) {
            log.error("Error while recovering topology. {}: {}.", e.getClass(), e.getMessage());
            throw new ResourceAllocationSolutionNotFound(e);
        }
    }

    public Map<String, VirtualMachine> getVms() {
        return vms;
    }

    public Map<String, String> getSap2vldId() {
        return sap2vldId;
    }
}
