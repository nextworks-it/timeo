package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Link;
import io.swagger.client.model.Node;
import io.swagger.client.model.NodeEdgePoint;
import io.swagger.client.model.OwnedNodeEdgePointSchema;
import io.swagger.client.model.SdmPoolPac;
import io.swagger.client.model.ServiceInterfacePointRef;
import io.swagger.client.model.Topology;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnController;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerType;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;

/**
 * SDN controller plugin to interact with an SDN controller that exposes a TAPI 
 * with SDM extensions at its northbound interface.
 * 
 * Note from the TAPI libs documentation:
 * It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
 * 
 * Since this plugin will be invoked by multiple threads, a new API client instance is created in each method.
 * 
 * @author nextworks
 *
 */
public class TapiSdnControllerPlugin extends SdnControllerPlugin {
	
	private static final Logger log = LoggerFactory.getLogger(TapiSdnControllerPlugin.class);
	
	private ThreadPoolTaskExecutor taskExecutor;
	
	private String basePath;	//should be something like "http://localhost:8182/restconf"

	public TapiSdnControllerPlugin(SdnController controller,
			ThreadPoolTaskExecutor taskExecutor) {
		super(SdnControllerType.SDN_CONTROLLER_TAPI, controller);
		this.basePath = controller.getUrl();
		this.taskExecutor = taskExecutor;
	}
	
	@Override
	public NetworkTopology getNetworkTopology() throws NotExistingEntityException, MethodNotImplementedException {
		log.debug("Retrieving network topology via TAPI");
		DefaultApi api = buildApiClient();
		try {
			List<String> topologyIds = api.retrieveContextTopologyTopology();
			if (topologyIds == null) {
				log.error("Null topology!");
				throw new NotExistingEntityException("Impossible to read topology, null returned.");
			}
			System.out.println("Found " + topologyIds.size() + " topologies");
			
			if (topologyIds.size() == 0) {
				log.error("Empty topology list!");
				throw new NotExistingEntityException("Impossible to read topology, empty list returned.");
			} else if (topologyIds.size() > 1) {
				log.error("More that one topology returned! Not yet supported");
				throw new MethodNotImplementedException("Handling of multiple topologies is not yet supported");
			} else {
				//a single topology is present
				String topologyPath = topologyIds.get(0);
				log.debug("Found topology with path: " + topologyPath);
				String uuid = getIdFromUrl(topologyPath);
				log.debug("Topology ID: " + uuid);
				
				Topology topology = api.retrieveContextTopologyTopologyById(uuid);
				log.debug("Retrieved topology with ID: " + uuid);
				
				NetworkTopology result = translateTapiTopology(topology, api);
				log.debug("Topology successfully translated");
				return result;
			}
		} catch (ApiException e) {
			log.error("Got API exception while getting topology");
			throw new NotExistingEntityException("Impossible to read topology: got API exception");
		}
	}
	
	@Override
	public String setPowerState(String deviceId, PowerState powerState, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//This method is not supported by this kind of SDN controller
		throw new MethodNotImplementedException();
	}
	
	@Override
	public void setPowerState(Map<String,PowerState> devicesPowerState) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//This method is not supported by this kind of SDN controller
		throw new MethodNotImplementedException();
	}
	
	
	@Override
	public String setupPaths(List<SbNetworkPath> networkPath, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		log.debug("Creating network path through TAPI connectivity service");
		String operationId = UUID.randomUUID().toString();
		DefaultApi api = buildApiClient();
		log.debug("Starting thread to create network paths through TAPI connectivity service");
		taskExecutor.execute(new TapiSetupPathTask(operationId, api, consumer, networkPath));
		return operationId;
	}
	
	@Override
	public String removePaths(List<String> networkPathIds, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		log.debug("Removing network path through TAPI connectivity service");
		String operationId = UUID.randomUUID().toString();
		DefaultApi api = buildApiClient();
		log.debug("Starting thread to remove network paths through TAPI connectivity service");
		taskExecutor.execute(new TapiRemovePathTask(operationId, api, consumer, networkPathIds));
		return operationId;
	}

	/**
	 * This method creates the handler to interact with the SDN controller via TAPI REST client
	 * 
	 * @return TAPI consumer handler
	 */
	private DefaultApi buildApiClient() {
		DefaultApi api = new DefaultApi();
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(basePath);
		api.setApiClient(apiClient);
		return api;
	}
	
	
	
	/**
	 * This method translates a topology in the TAPI format into a network topology in TIMEO format.
	 * 
	 * @param source topology in TAPI format
	 * @param api TAPI client handler
	 * @return topology in TIMEO internal format
	 * @throws NotExistingEntityException
	 * @throws ApiException if the interaction with the SDN controller fails
	 */
	private NetworkTopology translateTapiTopology(Topology source, DefaultApi api) throws NotExistingEntityException, ApiException {
		log.debug("Translating TAPI topology into TIMEO topology format.");
		log.debug("Source TAPI topology: " + source.toString());
		NetworkTopology target = new NetworkTopology(new ArrayList<>(), new ArrayList<>());
		
		List<Link> links = source.getLink();
		List<Node> nodes = source.getNode();
		if (links == null) throw new NotExistingEntityException("Topology without links");
		if (nodes == null) throw new NotExistingEntityException("Topology without nodes");
		log.debug("The TAPI topology has " + nodes.size() + " nodes and " + links.size() + " links.");
		
		Map<String, String> tmpPortToNodeMap = new HashMap<>();
		
		log.debug("Adding nodes to topology");
		for (Node n : nodes) {
			String nodeId = n.getUuid();
			List<Node.LayerProtocolNameEnum> origProtocolLayers = n.getLayerProtocolName();
			
			Set<LayerProtocol> supportedProtocolLayers = new HashSet<>();
			for (Node.LayerProtocolNameEnum lp : origProtocolLayers) {
				supportedProtocolLayers.add(convertLayerProtocol(lp));
			}
			TopologyNode targetNode = new TopologyNode(nodeId, new HashSet<>(), supportedProtocolLayers);
			target.addNode(targetNode);
			log.debug("Added node " + nodeId + " in target topology");
			
			List<NodeEdgePoint> ports = n.getOwnedNodeEdgePoint();
			for (NodeEdgePoint p : ports) {
				NodeEdgePoint.LayerProtocolNameEnum proto = p.getLayerProtocolName();
				String portId = p.getUuid();
				tmpPortToNodeMap.put(portId, nodeId);
				TapiTopologyCp tapiCp;
				if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.ETH)) {
					tapiCp = new TapiTopologyCp(targetNode, null, null, null, portId);
					log.debug("Created ETH port with ID " + portId);
				}
				else if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.SDM)) {
					tapiCp = new TapiTopologySdmCp(targetNode, null, null, null, portId);
					log.debug("Created SDM port with ID " + portId);
					OwnedNodeEdgePointSchema nodeSchema = api.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(source.getUuid(), n.getUuid(), p.getUuid());
					if (nodeSchema != null) {
						SdmPoolPac sdmPool = nodeSchema.getSdmPool();
						if (sdmPool != null) {
							((TapiTopologySdmCp)tapiCp).setSdmPoolPac(sdmPool);
							log.debug("Set SDM pool in SDM port");
						}
					}
				} else {
					tapiCp = new TapiTopologyCp(targetNode, null, null, null, portId);
					log.debug("Created generalized port with ID " + portId);
				}
				List<ServiceInterfacePointRef> sips = p.getMappedServiceInterfacePoint();
				if (sips != null) {
					for (ServiceInterfacePointRef sip : sips) {
						tapiCp.addSip(sip.getServiceInterfacePointId());
						log.debug("Added mapped Service Interface Point " + sip.getServiceInterfacePointId() + " to port.");
					}
				}
				target.addCp(targetNode, tapiCp);
				log.debug("Added port to topology");
			}
		}
		log.debug("All nodes and ports have been added to the topology");
		
		log.debug("Adding links to topology");
		for (Link l : links) {
			String linkId = l.getUuid();
			List<String> neps = l.getNodeEdgePoint();
			String srcPortId = getIdFromUrl(neps.get(0));
			String srcNodeId = tmpPortToNodeMap.get(srcPortId);
			String dstPortId = getIdFromUrl(neps.get(1));
			String dstNodeId = tmpPortToNodeMap.get(dstPortId);
			if ((srcNodeId != null) && (dstNodeId != null)) {
				TapiTopologyLink targetLink = new TapiTopologyLink(linkId, 
						target.fetchNodeById(srcNodeId),
						target.fetchNodeById(dstNodeId),
						target.getCpById(srcPortId),
						target.getCpById(dstPortId));
				log.debug("Created link with ID " + linkId + " between port " + srcPortId + " and port " + dstPortId);
				targetLink.setDirection(l.getDirection());
				if (l.getAvailableCapacity() != null) {
					targetLink.setAvailableCapacity(l.getAvailableCapacity());
					log.debug("Set available capacity");
				}
				if (l.getTotalPotentialCapacity() != null) {
					targetLink.setTotalPotentialCapacity(l.getTotalPotentialCapacity());
					log.debug("Set total potential capacity");
				}
				if (l.getLatencyCharacteristic() != null) {
					targetLink.setLatencyCharacteristic(l.getLatencyCharacteristic());
					log.debug("Set latency");
				}
				if (l.getLayerProtocolName() != null) {
					List<LayerProtocol> supportedProtocolLayers = new ArrayList<>();
					for (Link.LayerProtocolNameEnum lp : l.getLayerProtocolName()) {
						supportedProtocolLayers.add(convertLayerProtocol(lp));
					}
					targetLink.setLayerProtocol(supportedProtocolLayers);
					log.debug("Set protocol layers");
				}
				target.addLink(targetLink);
				target.getCpById(srcPortId).setOutgoingLink(targetLink);
				target.getCpById(dstPortId).setIncomingLink(targetLink);
			} else {
				log.error("Source or destination node not found for link " + linkId + ". Skipping it.");
			}
		}
		log.debug("All links have been added to the topology");
		
		return target;
	}
	
	private String getIdFromUrl(String url) {
		String[] parts = url.split("/");
		String uuid = parts[parts.length - 1];
		return uuid;
	}
	
	private LayerProtocol convertLayerProtocol(Node.LayerProtocolNameEnum source) {
		if (source.equals(Node.LayerProtocolNameEnum.ETH)) return LayerProtocol.ETHERNET;
		else if (source.equals(Node.LayerProtocolNameEnum.SDM)) return LayerProtocol.SDM;
		else {
			log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
			return LayerProtocol.NOT_SPECIFIED;
		}
	}
	
	private LayerProtocol convertLayerProtocol(Link.LayerProtocolNameEnum source) {
		if (source.equals(Link.LayerProtocolNameEnum.ETH)) return LayerProtocol.ETHERNET;
		else if (source.equals(Link.LayerProtocolNameEnum.SDM)) return LayerProtocol.SDM;
		else {
			log.warn("Unsopported layer protocol. Setting to NOT_SPECIFIED.");
			return LayerProtocol.NOT_SPECIFIED;
		}
	}
}