package it.nextworks.nfvmano.timeo.rc;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.nextworks.nfvmano.timeo.rc.algorithms.AlgorithmType;
import it.nextworks.nfvmano.timeo.rc.algorithms.CdnStaticAlgorithm5tonic;
import it.nextworks.nfvmano.timeo.rc.algorithms.VEPCStaticAlgorithmArno;
import it.nextworks.nfvmano.timeo.rc.algorithms.dijkstra.DijkstraAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.NfvoConstants;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.AlgorithmNotAvailableException;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import it.nextworks.nfvmano.timeo.nso.messages.InstantiateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.messages.TerminateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.rc.algorithms.CdnStaticAlgorithmNXW;
import it.nextworks.nfvmano.timeo.rc.algorithms.DummyAlgorithm;
import it.nextworks.nfvmano.timeo.rc.algorithms.DummyAlgorithmNXW;
import it.nextworks.nfvmano.timeo.rc.algorithms.NsResourceAllocationAlgorithmInterface;
import it.nextworks.nfvmano.timeo.rc.algorithms.emma.EmmaNetCompAlgorithm;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.repositories.ResourceComputationDbWrapper;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriverType;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriversManager;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

/**
 * Entity in charge of computing the resources to be allocated 
 * for the NSs
 * 
 * @author nextworks
 *
 */
@Service
public class ResourceSchedulingManager {
	
	private static final Logger log = LoggerFactory.getLogger(ResourceSchedulingManager.class);

	@Value("${spring.rabbitmq.host}")
	private String rabbitHost;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	NsDbWrapper nsDbWrapper;
	
	@Autowired
	ResourceComputationDbWrapper resourceComputationDbWrapper;
	
	@Autowired
	@Qualifier(NfvoConstants.computationQueueExchange)
	TopicExchange computationMessageExchange;

	private Queue queue;
	
	@Value("${timeo.algorithm}")
	private String algorithmType;
	
	@Value("${timeo.poweradaptation.computing}")
	private boolean computingPowerAdaptation;
	
	@Value("${timeo.poweradaptation.network}")
	private boolean networkPowerAdaptation;
	
	@Autowired
	NsManagementEngine nsManagementEngine;
	
	@Autowired
	private VnfPackageManagementService vnfPackageManagement;
	
	@Autowired
	private SbDriversManager sbDriversManager;
	
	private SdnControllerPlugin defaultSdnControllerPlugin;
	
	private VimPlugin defaultVimPlugin;
	
	public ResourceSchedulingManager() {
		this.queue = null;
	}
	
	public void notifySbDriverChange(SbDriverType type) {
		log.debug("Received notification for a change in the southbound drivers. SB driver type: " + type.toString());
		switch (type) {
		case SB_SDN_CONTROLLER:
			setDefaultSdnController();
			break;

		case SB_VIM:
			setDefaultVimPlugin();
			break;
			
		default:
			break;
		}
	}
	
	private void setDefaultSdnController() {
		try {
			defaultSdnControllerPlugin = sbDriversManager.getDefaultSdnController();
			log.debug("Default SDN controller driver set: " + defaultSdnControllerPlugin.getSbDriverId());
		} catch (NotExistingEntityException e) {
			log.warn("Default SDN controller driver not found! Be sure to configure a new one before creating new services!");
		}
	}
	
	private void setDefaultVimPlugin() {
		try {
			defaultVimPlugin = sbDriversManager.getDefaultVim();
			log.debug("Default VIM plugin set: " + defaultVimPlugin.getSbDriverId());
		} catch (NotExistingEntityException e) {
			log.warn("Default VIM plugin not found! Be sure to configure a new one before creating new services!");
		}
	}
	
	/**
	 * Method to be invoked to request the computation of the resources to be instantiated for a NS
	 * 
	 * @param instantiateMsg instantiate NS message
	 * @throws NotExistingEntityException if the operation ID is not found in DB
	 */
	public void reserveResources(InstantiateNsRequestMessage instantiateMsg) throws NotExistingEntityException {
		log.debug("Invoked reserve resource method");
		if (queue == null) createQueue();
		ComputationReserveMessage internalMessage = new ComputationReserveMessage(instantiateMsg.getOperationId(), instantiateMsg.getRequest());
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(internalMessage);
			rabbitTemplate.convertAndSend(computationMessageExchange.getName(), "resourceSched", json);
			log.debug("Sent internal message with request for computation of NS resources");
		} catch (JsonProcessingException e) {
			log.error("Error while translating internal computation reserve message in Json format.");
			nsDbWrapper.updateInternalOperation(instantiateMsg.getOperationId(), OperationStatus.FAILED, "Error while translating internal computation reserve message in Json format.");
		}
	}
	
	/**
	 * Method to be invoked to request the release of resources previously reserved for a NS instance
	 * 
	 * @param terminateMsg	terminate NS message
	 * @throws NotExistingEntityException if the operation ID is not found in DB
	 */
	public void releaseResources(TerminateNsRequestMessage terminateMsg) throws NotExistingEntityException {
		if (queue == null) createQueue();
		ComputationReleaseMessage internalMessage = new ComputationReleaseMessage(terminateMsg.getOperationId(), terminateMsg.getRequest());
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(internalMessage);
			rabbitTemplate.convertAndSend(computationMessageExchange.getName(), "resourceSched", json);
			log.debug("Sent internal message with request for releasing computed NS resources");
		} catch (JsonProcessingException e) {
			log.error("Error while translating internal computation release message in Json format.");
			nsDbWrapper.updateInternalOperation(terminateMsg.getOperationId(), OperationStatus.FAILED, "Error while translating internal computation release message in Json format.");
		}
	}
	
	public void receiveMessage(String message) {
		log.debug("Received message from queue \n" + message);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			ComputationMessage compMessage = (ComputationMessage) mapper.readValue(message, ComputationMessage.class);
			ComputationMessageType type = compMessage.getType();
			String operationId = compMessage.getOperationId();
			
			switch (type) {
			case RESERVE: {
				log.debug("Received computation reserve message for operation " + operationId);
				ComputationReserveMessage reserveMsg = (ComputationReserveMessage)compMessage;
				computeResources(reserveMsg);
				break;
			}
			
			case RELEASE: {
				log.debug("Received computation release message for operation " + operationId);
				ComputationReleaseMessage releaseMsg = (ComputationReleaseMessage)compMessage;
				releaseResources(releaseMsg);
				break;
			}

			default: {
				log.error("Received message with not supported type");
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Computation message with not supported type");
				break;
			}
			}
		} catch(JsonParseException e) {
			log.error("Error while parsing message: " + e.getMessage());
		} catch(JsonMappingException e) {
			log.error("Error in Json mapping: " + e.getMessage());
		} catch(IOException e) {
			log.error("IO error when receiving json message: " + e.getMessage());
		} catch(NotExistingEntityException e) {
			log.error("Error while updating operation status");
		}
	}
	
	private void computeResources(ComputationReserveMessage msg) throws NotExistingEntityException {
		log.debug("Computing resources to be allocated");
		try {
			NsResourceAllocationAlgorithmInterface algorithm = loadAlgorithm();
			log.debug("Found algorithm of type " + algorithmType);

			String nsInstanceId = msg.getRequest().getNsInstanceId();
			String nsFlavourId = msg.getRequest().getFlavourId(); 
			String nsInstantiationLevel = msg.getRequest().getNsInstantiationLevelId();
			
			try {
				Nsd nsd = nsManagementEngine.retrieveNsd(nsInstanceId);
				Map<Vnfd,Map<String, String>> vnfdsTarget = new HashMap<>();
				Map<String,Map<String, String>> vnfds = nsd.getVnfdDataFromFlavour(nsFlavourId, nsInstantiationLevel);
				
				for (Map.Entry<String, Map<String, String>> entry : vnfds.entrySet()) {
					String vnfdId = entry.getKey();
					log.debug("Found VNFD " + vnfdId);
					OnboardedVnfPkgInfo pkg = vnfPackageManagement.getOnboardedVnfPkgInfoFromVnfd(vnfdId);
					log.debug("Found VNF package.");
					Vnfd vnfd = pkg.getVnfd();
					vnfdsTarget.put(vnfd, entry.getValue());
				}
				
				NsResourceSchedulingSolution solution = algorithm.computeNsResourceAllocationSolution(
						msg.getRequest(),
						nsd,
						vnfdsTarget,
						defaultVimPlugin,
						defaultSdnControllerPlugin
				);
				//store in DB if successful
				if (solution.isSolutionFound()) {
					log.debug("Solution found");
					try {
						resourceComputationDbWrapper.addNewNsResourceSchedulingSolution(solution);
					} catch (AlreadyExistingEntityException e) {
						log.error("Scheduling solution already found for the given NS. Update not supported at the moment!");
						//TODO: This condition needs further analysis...
					}
					if ((computingPowerAdaptation) || (networkPowerAdaptation)) {
						adjustPowerState(msg.getRequest().getNsInstanceId(), msg.getOperationId(), solution, true);
						//TODO: at the moment this is blocking. It should implement an asynchronous mechanism to enable multiple computations in parallel 
						//while the system is waiting for the change of power state at the other component
					}
					nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), solution);
				} else {
					log.error("Resource computation failed due to not available resources");
					nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Resource computation failed due to not available resources");
					nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), 
							new NsResourceSchedulingSolution(msg.getRequest().getNsInstanceId(), false));
				}
			}  catch (ResourceAllocationSolutionNotFound e) {
				log.error("Resource computation failed due to not available resources");
				nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Resource computation failed due to not available resources");
				nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), 
						new NsResourceSchedulingSolution(msg.getRequest().getNsInstanceId(), false));
			} catch (NotExistingEntityException e) {
				log.error("Resource computation failed due to missing entities in DB");
				nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Resource computation failed due to missing entities in DB");
				nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), 
						new NsResourceSchedulingSolution(msg.getRequest().getNsInstanceId(), false));
			} catch (FailedOperationException e) {
				log.error("Resource computation failed because of error while setting power state");
				//TODO: to be better analyzed 
				nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Resource computation failed because of error while setting power state");
				nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), 
						new NsResourceSchedulingSolution(msg.getRequest().getNsInstanceId(), false));
			}

		} catch (AlgorithmNotAvailableException e) {
			nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Unable to find a suitable algorithm");
			nsManagementEngine.notifyResourceComputationResult(msg.getRequest().getNsInstanceId(), msg.getOperationId(), 
					new NsResourceSchedulingSolution(msg.getRequest().getNsInstanceId(), false));
		}
	}
	
	private void adjustPowerState(String nsInstance, String operationId, NsResourceSchedulingSolution solution, boolean switchOn) throws FailedOperationException {
		log.debug("Triggering power state adjustment for NS instance " + nsInstance);
		if (switchOn) {
			log.debug("Nodes are to be activated");
			if (computingPowerAdaptation) switchOnComputeNodes(solution);
			if (networkPowerAdaptation) switchOnNetworkNodes(solution);
		} else {
			log.debug("Nodes are to be de-activated");
			if (computingPowerAdaptation) switchOffComputeNodes(solution);
			if (networkPowerAdaptation) switchOffNetworkNodes(solution);
		}
		log.debug("Adjustment of power state is terminated");
	}
	
	private void switchOnComputeNodes(NsResourceSchedulingSolution solution) throws FailedOperationException {
		log.debug("Starting procedure to switch on compute nodes");
		Map<String,String> computeNodesToBeActivated = solution.getComputeNodesToBeActivated();
		log.debug("Found " + computeNodesToBeActivated.size() + " compute nodes to be activated");
		Map<String, PowerState> powerStates = new HashMap<>();
		for (Map.Entry<String, String> e : computeNodesToBeActivated.entrySet()) {
			log.debug("Compute node to be activated: "+ e.getKey());
			powerStates.put(e.getKey(), PowerState.POWER_ON);
		}
		try {
			defaultVimPlugin.setPowerState(powerStates);
			log.debug("Compute nodes have been switched on.");
		} catch (Exception e) {
			log.error("Error while switching on compute nodes: " + e.getMessage());
			throw new FailedOperationException("Error while switching on compute nodes: " + e.getMessage());
		}
	}
	
	private void switchOnNetworkNodes(NsResourceSchedulingSolution solution) throws FailedOperationException {
		log.debug("Starting procedure to switch on network nodes");
		List<String> networkNodesToBeActivated = solution.getNetworkNodesToBeActivated();
		log.debug("Found " + networkNodesToBeActivated.size() + " network nodes to be activated");
		Map<String, PowerState> devicesPowerState = new HashMap<>();
		for (String n : networkNodesToBeActivated) {
			devicesPowerState.put(n, PowerState.HIGH_POWER);
		}
		try {
			defaultSdnControllerPlugin.setPowerState(devicesPowerState);
			log.debug("Network nodes have been switched on.");
		} catch (Exception e) {
			log.error("Error while switching on network nodes: " + e.getMessage());
			throw new FailedOperationException("Error while switching on network nodes: " + e.getMessage());
		}
	}
	
	private void switchOffComputeNodes(NsResourceSchedulingSolution solution) throws FailedOperationException {
		log.debug("Starting procedure to switch off compute nodes");
		Map<String,String> computeNodes = solution.getAllComputeNodes();
		Map<String, PowerState> powerStates = new HashMap<>();
		for (Map.Entry<String, String> e : computeNodes.entrySet()) {
			String vimId = e.getValue();
			String hostId = e.getKey();
			List<VnfResourceAllocation> vnfSol = resourceComputationDbWrapper.getRemainingVnfAllocationsOnHost(solution.getNsInstanceId(), vimId, hostId);
			if (vnfSol.isEmpty()) {
				log.debug("Compute node " + hostId + " needs to be switched off");
				powerStates.put(hostId, PowerState.POWER_OFF);
			} else {
				log.debug("Compute node " + hostId + " is still in use and it cannot be switched off");
			}
		}
		try {
			defaultVimPlugin.setPowerState(powerStates);
			log.debug("Compute nodes have been switched off.");
		} catch (Exception e) {
			log.error("Error while switching off compute nodes: " + e.getMessage());
			throw new FailedOperationException("Error while switching off compute nodes: " + e.getMessage());
		}
	}
	
	private void switchOffNetworkNodes(NsResourceSchedulingSolution solution) throws FailedOperationException {
		log.debug("Starting procedure to switch off compute nodes");
		Set<String> networkNodes = solution.getAllNetworkNodes();
		Map<String, PowerState> devicesPowerState = new HashMap<>();
		for (String n : networkNodes) {
			List<NetworkPathHop> usedHops = resourceComputationDbWrapper.getRemainingPathHopInUse(solution.getNsInstanceId(), n);
			if (usedHops.isEmpty()) {
				log.debug("Network node " + n + " can be put in sleeping mode.");
				devicesPowerState.put(n, PowerState.SLEEPING);
			} else {
				log.debug("Network node " + n + " is still in use and it cannot be put in sleeping mode");
			}
		}
		try {
			defaultSdnControllerPlugin.setPowerState(devicesPowerState);
			log.debug("Network nodes have been put in sleeping mode.");
		} catch (Exception e) {
			log.error("Error while changing power state for network nodes: " + e.getMessage());
			throw new FailedOperationException("Error while changing power state for network nodes: " + e.getMessage());
		}
	}
	
	private void releaseResources(ComputationReleaseMessage msg) throws NotExistingEntityException {
		String nsInstanceId = msg.getRequest().getNsInstanceId();
		String operationId = msg.getOperationId();
		log.debug("Releasing resources in internal computation DB for NS instance " + nsInstanceId);
		try {
			NsResourceSchedulingSolution schedulingSolution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsInstanceId);
			if ((computingPowerAdaptation) || (networkPowerAdaptation)) {
				adjustPowerState(nsInstanceId, operationId, schedulingSolution, false);
			}
			resourceComputationDbWrapper.removeNsResourceSchedulingSolution(nsInstanceId);
			log.debug("Resources correctly released. Notifying the NS management engine");
			nsManagementEngine.notifyResourceComputationRelease(nsInstanceId, operationId, true);
		} catch (Exception e) {
			log.error("Release of computed resources failed: " + e.getMessage());
			nsDbWrapper.updateInternalOperation(msg.getOperationId(), OperationStatus.FAILED, "Release of computed resources failed: " + e.getMessage());
			nsManagementEngine.notifyResourceComputationRelease(nsInstanceId, operationId, false);
		}
	}

	private void createQueue() {
		log.debug("Creating internal queue for resource scheduling manager");
		String queueName = NfvoConstants.computationQueueName;
		log.debug("Creating new Queue " + queueName + " in rabbit host " + rabbitHost);
		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses(rabbitHost);
		cf.setConnectionTimeout(5);
		RabbitAdmin rabbitAdmin = new RabbitAdmin(cf);
		this.queue = new Queue(queueName, false, false, true);
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(computationMessageExchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(computationMessageExchange).with("resourceSched"));
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
		MessageListenerAdapter adapter = new MessageListenerAdapter(this, "receiveMessage");
		container.setMessageListener(adapter);
	    container.setQueueNames(queueName);
	    container.start();
	    log.debug("Queue created");
	}
	
	private NsResourceAllocationAlgorithmInterface loadAlgorithm() throws AlgorithmNotAvailableException {
		//TODO: at the moment in configuration. Maybe it should be managed with some policies...
		AlgorithmType type;
		try {
			type = AlgorithmType.valueOf(this.algorithmType);
		} catch (IllegalArgumentException e) {
			log.error("Unknown algorithm type {}.", this.algorithmType);
			throw new AlgorithmNotAvailableException();
		}
		switch (type) {
			case DUMMY:
				return new DummyAlgorithm();
			case EMMA_NET_COMP:
				return new EmmaNetCompAlgorithm();
			case DUMMY_NXW:
				return new DummyAlgorithmNXW();
			case CDN_STATIC_NXW:
				return new CdnStaticAlgorithmNXW();
			case CDN_STATIC_5TONIC:
				return new CdnStaticAlgorithm5tonic();
			case DIJKSTRA:
				return new DijkstraAlgorithm();
			case VEPC_STATIC_ARNO:
				return new VEPCStaticAlgorithmArno();
			default:
				log.error("Algorithm type {} not yet implemented.", type);
				throw new AlgorithmNotAvailableException();
		}
	}

}
