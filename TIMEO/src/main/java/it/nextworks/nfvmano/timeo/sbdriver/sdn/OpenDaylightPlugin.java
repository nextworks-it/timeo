package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyLink;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.Link;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.NodeConnector;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.OdlInvNode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.OdlNetworkTopology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.OdlTopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.OpendaylightInventory;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.TerminationPoint;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.Topology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.TopologyWrapper;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Nextworks S.r.l. on 19/04/17.
 *
 * @author Nextworks S.r.l.
 */
public class OpenDaylightPlugin extends SdnControllerPlugin {

    private static final double IDLE_XPFE_CONSUMPTION = 80;
    private static final double IDLE_XPU_CONSUMPTION = 100;
    private static final double LINK_POWER = 6E-6;
    private static final int LINK_BW = 100000000; // 100 Gb/s

    private static final Logger log = LoggerFactory.getLogger(OpenDaylightPlugin.class);

    private ThreadPoolTaskExecutor taskExecutor;

    private TaskExecutorSetupPath taskExecutorSetupPath;

    private TaskExecutorRemovePath taskExecutorRemovePath;

    private TaskExecutorSetPowerStates taskExecutorSetPowerStates;

    private String setupPathUri;
    private String deletePathUri;
    private String encodedString;

    private NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient;

    public OpenDaylightPlugin(SdnController controller,
                              ThreadPoolTaskExecutor taskExecutor,
                              TaskExecutorSetupPath taskExecutorSetupPath,
                              TaskExecutorRemovePath taskExecutorRemovePath,
                              TaskExecutorSetPowerStates taskExecutorSetPowerStates,
                              RestTemplate restTemplate) {
        super(SdnControllerType.SDN_CONTROLLER_OPENDAYLIGHT, controller);

        this.setupPathUri = (controller.getUrl()).concat("restconf/config/provisioning-manager:connections");
        this.deletePathUri = (controller.getUrl()).concat("restconf/config/provisioning-manager:connections/connection/");
        this.taskExecutor = taskExecutor;
        this.taskExecutorSetupPath = taskExecutorSetupPath;
        this.taskExecutorRemovePath = taskExecutorRemovePath;
        this.taskExecutorSetPowerStates = taskExecutorSetPowerStates;
        this.authenticate(controller.getUsername(), controller.getPassword());
        this.nfvoOpenDaylightRestClient = new NfvoOpenDaylightRestClient(
                controller.getUrl(),
                setupPathUri, deletePathUri, encodedString,
                restTemplate);
        taskExecutorRemovePath.setNfvoOpenDaylightRestClient(nfvoOpenDaylightRestClient);
        taskExecutorSetupPath.setNfvoOpenDaylightRestClient(nfvoOpenDaylightRestClient);
        taskExecutorSetPowerStates.setNfvoOpenDaylightRestClient(nfvoOpenDaylightRestClient);
    }

    public void setNfvoOpenDaylightRestClient(NfvoOpenDaylightRestClient nfvoOpenDaylightRestClient) {
        this.nfvoOpenDaylightRestClient = nfvoOpenDaylightRestClient;
    }

    private void putDataInto(TopologyWrapper wrapper, 
    						 OpendaylightInventory inventory,
                             NetworkTopology destination) {
        OdlNetworkTopology source = wrapper.odlNetworkTopology;
        if (source.topology.size() != 1)
            throw new IllegalStateException(
                    String.format("Expected exactly one topology in response, found %s.", source.topology.size())
            );
        Topology topology = source.topology.get(0);
        Map<String, NodeConnector> tpId2nodeConnector = new HashMap<>();
        for (OdlInvNode node : inventory.nodes.node) {
            for (NodeConnector port : node.nodeConnector) {
                tpId2nodeConnector.put(port.id, port);
            }
        }
        for (OdlTopologyNode node : topology.node) {
            TopologyNode newNode;
            if (node.nodeId.startsWith("host:")) {
                if (!node.nodeId.startsWith("host:fa:16:3e:")) { // Skipping VMs
                    newNode = new TopologyNode(
                            node.nodeId,
                            new HashSet<>(),
                            0,
                            0,
                            0,
                            IDLE_XPU_CONSUMPTION,
                            0D,
                            PowerState.withName(node.operState),
                            null,
                            null
                    );
                    if (null == newNode.powerState) {
                        newNode.powerState = PowerState.HIGH_POWER;
                    }
                } else newNode = null;
            } else {
                newNode = new TopologyNode(
                        node.nodeId,
                        new HashSet<>(),
                        IDLE_XPFE_CONSUMPTION,
                        PowerState.withName(node.operState)
                );
            }
            if (null != newNode) { // Again, skipping VMs
                destination.addNode(newNode);
                if (!node.nodeId.startsWith("host:")) {
                    for (TerminationPoint port : node.terminationPoint) {
                        String tpId = port.tpId;
                        NodeConnector nodeConnector = tpId2nodeConnector.get(tpId);
                        if (null == nodeConnector) {
                            log.error("Cannot find node connector {} in inventory.", tpId);
                            continue;
                        }
                        String mac = nodeConnector.hardwareAddress;
                        TopologyCp topologyCp = new TopologyCp(
                                newNode,
                                null,
                                null,
                                mac,
                                tpId,
                                null
                        );
                        destination.addCp(newNode, topologyCp);
                    }
                } else {
                    TopologyCp topologyCp = new TopologyCp(
                            newNode,
                            null,
                            null,
                            node.nodeId.substring("host:".length()),
                            node.nodeId,
                            null
                    );
                    destination.addCp(newNode, topologyCp);
                }
            }
        }
        for (Link link : topology.link) {
            if (!link.source.sourceNode.startsWith("host:fa:16:3e:")
                    && !link.destination.destNode.startsWith("host:fa:16:3e")) { // Skip VM links...
                TopologyLink newLink = new TopologyLink(
                        link.linkId,
                        destination.fetchNodeById(link.source.sourceNode),
                        destination.fetchNodeById(link.destination.destNode),
                        destination.getCpById(link.source.sourceTp),
                        destination.getCpById(link.destination.destTp),
                        LINK_POWER,
                        LINK_BW
                );
                destination.addLink(newLink);
                destination.getCpById(link.source.sourceTp).outgoingLink = newLink;
                destination.getCpById(link.destination.destTp).incomingLink = newLink;
            }
        }
    }

    @Override
    public NetworkTopology getNetworkTopology() throws NotExistingEntityException, MethodNotImplementedException {
        NetworkTopology output = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
        try {
            TopologyWrapper topologyWrapper = nfvoOpenDaylightRestClient.sendTopologyRequest();
            OpendaylightInventory inventory = nfvoOpenDaylightRestClient.sendInventoryRequest();
            putDataInto(topologyWrapper, inventory, output);
        } catch (RemoteEntityFailureException e) {
            log.warn("Topology get failed.");
            log.debug("With exception: ", e);
            throw new NotExistingEntityException("Could not retrieve topology from SDN.");
        }
        return output;
    }

    @Override
    public String setPowerState(String deviceId, PowerState powerState, SdnControllerConsumerInterface consumer)
            throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
        // TODO
        throw new MethodNotImplementedException();
    }

    @Override
    public void setPowerState(Map<String, PowerState> devicesPowerState) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
        // Note: this is blocking!
        log.debug("Setting power states.");
        try {
            taskExecutorSetPowerStates.internalRun(devicesPowerState);
        } catch (RemoteEntityFailureException e) {
            log.warn("Power state set failed.");
            log.debug("With exception: ", e);
        }
    }

    @Override
    public String setupPaths(List<SbNetworkPath> networkPaths, SdnControllerConsumerInterface consumer)
            throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {

        log.debug("Setting up path.");

        String operationId = UUID.randomUUID().toString();
        log.debug("OperationID: " + operationId);

        if (taskExecutorSetupPath.isEmpty()) {
        	log.debug("Reactivating setupPath");
            taskExecutorSetupPath.putToMap(operationId, networkPaths, consumer);
            taskExecutor.execute(taskExecutorSetupPath);
        } else {
            taskExecutorSetupPath.putToMap(operationId, networkPaths, consumer);
        }

        return operationId;
    }

    @Override
    public String removePaths(List<String> networkPathIds, SdnControllerConsumerInterface consumer)
            throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {

        String operationId = UUID.randomUUID().toString();

        if (taskExecutorRemovePath.isEmpty()) {
        	log.debug("Reactivating removePath");
            taskExecutorRemovePath.putToMap(operationId, networkPathIds, consumer);
            taskExecutor.execute(taskExecutorRemovePath);
        } else {
            taskExecutorRemovePath.putToMap(operationId, networkPathIds, consumer);
        }

        return operationId;
    }

    private void authenticate(String username, String password) {
        String authStr = username + ":" + password;
        encodedString = Base64.encodeBase64String(authStr.getBytes());
    }

    public String getSetupPathUri() {
        return setupPathUri;
    }

    public String getDeletePathUri() {
        return deletePathUri;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public NfvoOpenDaylightRestClient getNfvoOpenDaylightRestClient() {
        return nfvoOpenDaylightRestClient;
    }
}
