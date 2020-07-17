package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.*;

import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.TopologyCp;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.*;
import io.swagger.client.model.Link;
import io.swagger.client.model.Node;
import io.swagger.client.model.NodeEdgePointRef;
import io.swagger.client.model.OwnedNodeEdgePointSchema;
//import io.swagger.client.model.SdmPoolCapabilityPac;
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

	private Map<String, SbNetworkPath> configuredPaths;


	public TapiSdnControllerPlugin(SdnController controller,
			ThreadPoolTaskExecutor taskExecutor,
								   ObfnCSRecordRepository obfnCSRecordRepository) {
		super(SdnControllerType.SDN_CONTROLLER_TAPI, controller);
		this.basePath = controller.getUrl();
		this.taskExecutor = taskExecutor;

	}
	
	@Override
	public NetworkTopology getNetworkTopology() throws NotExistingEntityException, MethodNotImplementedException {
		log.debug("Retrieving network topology via TAPI");
		DefaultApi api = buildApiClient();
		try {
			ContextSchema response = api.retrieveContext();
			TopologyContext topologyList = response.getTopologyContext();
			
			//List<String> topologyIds = api.retrieveContextTopologyContextTopologyTopology();
			if (topologyList == null) {
				log.error("Null topology!");
				throw new NotExistingEntityException("Impossible to read topology, null returned.");
			}
			System.out.println("Found " + topologyList.getTopology().size() + " topologies");
			
			if (topologyList.getTopology().size() == 0) {
				log.error("Empty topology list!");
				throw new NotExistingEntityException("Impossible to read topology, empty list returned.");
			}
			if (topologyList.getTopology().size() > 1)
				log.debug("More that one topology returned!, using the first one");


			Topology topologyOut = topologyList.getTopology().get(0);
			NetworkTopology result = translateTapiTopology(topologyOut, api, response);
			log.debug("Topology successfully translated");
			return result;

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
		for(SbNetworkPath sbNetworkPath: networkPath){
			configuredPaths.put(sbNetworkPath.getNetworkPathId(), sbNetworkPath);
		}
		return operationId;
	}
	
	@Override
	public String removePaths(List<String> networkPathIds, SdnControllerConsumerInterface consumer ) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		log.debug("Removing network path through TAPI connectivity service");
		String operationId = UUID.randomUUID().toString();
		DefaultApi api = buildApiClient();
		log.debug("Starting thread to remove network paths through TAPI connectivity service");
		List<SbNetworkPath> networkPaths = new ArrayList<>();
		for(String networkPathId: networkPathIds){
			networkPaths.add(configuredPaths.get(networkPathId));
		}
		taskExecutor.execute(new TapiRemovePathTask(operationId, api, consumer, networkPaths));
		return operationId;
	}

	/**
	 * This method creates the handler to interact with the SDN controller via TAPI REST client
	 * 
	 * @return TAPI consumer handler
	 */
	private DefaultApi buildApiClient() {
		DefaultApi api = new DefaultApi();
		ApiClient apiClient = new ApiClient()
				.setBasePath(basePath)
				.setDebugging(true)
				.setConnectTimeout(0)
                .setReadTimeout(30000)
                .setWriteTimeout(30000);


		api.setApiClient(apiClient);
		return api;
	}
	


	public List<SbNetworkPath> getActivePaths() throws FailedOperationException{
        log.debug("Retrieving TAPI active connections");
        DefaultApi api = buildApiClient();
        List<SbNetworkPath> sbNetworkPaths = new ArrayList<>();
        try {
            ContextSchema response = api.retrieveContext();
            ConnectivityContext connectivityContext = response.getConnectivityContext();
            List<ConnectivityService> connectivityServices = connectivityContext.getConnectivityService();
            for(ConnectivityService connectivityService : connectivityServices){
                SbNetworkPath currentPath = this.translateConnectivityService(connectivityService);
                sbNetworkPaths.add(currentPath);
            }
            return sbNetworkPaths;

        } catch (ApiException e) {
            log.error("Failed to retrieve TAPI active connections");
            log.error(e.getMessage());
            log.error(e.getStackTrace().toString());
            throw new FailedOperationException(e.getMessage());
        }
    }

	public List<SbNetworkPath> getAvailablePaths() throws FailedOperationException{
		log.debug("Retrieving TAPI active connections");
		DefaultApi api = buildApiClient();
		List<SbNetworkPath> sbNetworkPaths = new ArrayList<>();
		try {
			ContextSchema response = api.retrieveContext();

			TopologyContext topologyContext = response.getTopologyContext();
			List<Topology> topologies = topologyContext.getTopology();

			for(Topology topology: topologies){
				List<Node> nodes = topology.getNode();
				for(Node node: nodes ){
					List<SbNetworkPath> currentPaths = this.translateNode(node);
					sbNetworkPaths.addAll(currentPaths);
				}


			}
			return sbNetworkPaths;

		} catch (ApiException e) {
			log.error("Failed to retrieve TAPI active connections");
			log.error(e.getMessage());
			log.error(e.getStackTrace().toString());
			throw new FailedOperationException(e.getMessage());
		}
	}


    private SbNetworkPath translateConnectivityService(ConnectivityService connectivityService) throws FailedOperationException{
	    String npId = connectivityService.getUuid();
        List<NetworkPathHop> hops = new ArrayList<>();
        if(connectivityService.getEndPoint()!=null && connectivityService.getEndPoint().size()==2){
            String ingressServiceInterfacePoint = connectivityService.getEndPoint().get(0).getServiceInterfacePoint().getServiceInterfacePointUuid();
            String egressServiceInterfacePoint = connectivityService.getEndPoint().get(1).getServiceInterfacePoint().getServiceInterfacePointUuid();
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
                    egressServiceInterfacePoint,
					null
            );
            hops.add(nph);

            return new SbNetworkPath(npId,
                    null, //tenantId: not important for the moment
                    hops,
                    null,
                    SbNetworkPathType.AROF);
        }else throw new FailedOperationException("A ConnectivityService should have exactly two endpoints");

    }

    private List<SbNetworkPath> translateNode(Node node){
		List<SbNetworkPath> sbNetworkPaths = new ArrayList<>();
		for(OwnedNodeEdgePointSchema ownedNodeEdgePointSchema: node.getOwnedNodeEdgePoint()){
			String egressServiceInterfacePoint = ownedNodeEdgePointSchema.getMappedServiceInterfacePoint().get(0).getServiceInterfacePointUuid();
			String ingressServiceInterfacePoint = ownedNodeEdgePointSchema.getMappedServiceInterfacePoint().get(1).getServiceInterfacePointUuid();
			List<NetworkPathHop> hops = new ArrayList<>();
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
					egressServiceInterfacePoint, null
			);
			hops.add(nph);
			sbNetworkPaths.add(new SbNetworkPath(ownedNodeEdgePointSchema.getUuid(),
					null, //tenantId: not important for the moment
					hops,
					null,
					SbNetworkPathType.AROF));
		}
		return sbNetworkPaths;


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
	private NetworkTopology translateTapiTopology(Topology source, DefaultApi api, ContextSchema contextSchema) throws NotExistingEntityException, ApiException {
		return TapiTopologyUtilities.translateTapiTopology(source, contextSchema);

	}





}
