package it.nextworks.nfvmano.timeo.nso;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.NsdInfo;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.QueryNsdResponse;
import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.TerminateNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.NsdManagementService;
import it.nextworks.nfvmano.timeo.common.NfvoConstants;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.nso.messages.InstantiateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.messages.NotifyAllocationResultMessage;
import it.nextworks.nfvmano.timeo.nso.messages.NotifyComputationReleaseMessage;
import it.nextworks.nfvmano.timeo.nso.messages.NotifyComputationResultMessage;
import it.nextworks.nfvmano.timeo.nso.messages.TerminateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.rc.ResourceSchedulingManager;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.ro.ResourceAllocationManager;
import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;

/**
 * Internal components which handles all the managers of the single NS and 
 * exposed APIs used by other components (e.g. the NS Lifecycle Service) to 
 * send messages to the queues of each NS manager.
 * 
 * @author nextworks
 *
 */
@Service
public class NsManagementEngine {

	private static final Logger log = LoggerFactory.getLogger(NsManagementEngine.class);
	
	@Autowired
	NsDbWrapper nsDbWrapper;
	
	@Autowired
	NsdManagementService nsdManagement;
	
	@Autowired
	ResourceSchedulingManager resourceSchedulingManager;
	
	@Value("${spring.rabbitmq.host}")
	private String rabbitHost;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	@Qualifier(NfvoConstants.engineQueueExchange)
	TopicExchange messageExchange;
	
	@Autowired
	ResourceAllocationManager resourceAllocationManager;
	
	//internal map of NS Managers
	//each NS Manager is created when a new NS istance ID is created and removed when the NS instance ID is removed
	private Map<String, NsManager> nsManagers = new HashMap<>();
	
	
	//TODO: 
	//For persistency
	//The constructor should read the current NS instances from the DB and re-create the nsManagers map
	public NsManagementEngine() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Initializes a new NS Manager
	 * 
	 * @param nsInstanceId ID of the NS instance to be managed by the new NS manager
	 */
	public void initNewNsManager(String nsInstanceId) {
		log.debug("Initializing new NS manager for NS instance " + nsInstanceId);
		NsManager nsManager = new NsManager(nsInstanceId, resourceSchedulingManager, nsDbWrapper, resourceAllocationManager);
		createQueue(nsInstanceId, nsManager);
		this.nsManagers.put(nsInstanceId, nsManager);
	}
	
	/**
	 * Instantiates a network service
	 * 
	 * @param request
	 * @throws NotExistingEntityException
	 */
	public String instantiateNetworkService(InstantiateNsRequest request) throws NotExistingEntityException {
		String nsInstanceId = request.getNsInstanceId();
		log.debug("Received request to instantiate network service " + nsInstanceId);
		if (this.nsManagers.containsKey(nsInstanceId)) {
			String operationId = generateNewOperation(nsInstanceId, "NS instantiation");
			String topic = "lifecycle.instantiate." + nsInstanceId;
			InstantiateNsRequestMessage internalMessage = new InstantiateNsRequestMessage(nsInstanceId, operationId, request);
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
				log.debug("Sent internal message with request to instantiate network service " + nsInstanceId);
				return operationId;
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal instantiation message in Json format.");
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal instantiation message in Json format.");
				return operationId;
			}
		} else {
			throw new NotExistingEntityException("Network Service ID not found");
		}
	}
	
	public String terminateNetworkService(TerminateNsRequest request) throws NotExistingEntityException {
		String nsInstanceId = request.getNsInstanceId();
		Date terminateTime = request.getTerminateTime();
		log.debug("Received terminate NS instance request: NS instance ID - " + nsInstanceId);
		if (terminateTime != null) {
			log.error("Termination date not null. Delayed termination not supported at the moment: terminating the NS immediately");
		}
		if (this.nsManagers.containsKey(nsInstanceId)) {
			String operationId = generateNewOperation(nsInstanceId, "NS termination");
			String topic = "lifecycle.terminate." + nsInstanceId;
			TerminateNsRequestMessage internalMessage = new TerminateNsRequestMessage(nsInstanceId, operationId, request);
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
				log.debug("Sent internal message with request to terminate network service " + nsInstanceId);
				return operationId;
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal termination message in Json format.");
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal termination message in Json format.");
				return operationId;
			}
		} else {
			throw new NotExistingEntityException("Network Service ID not found");
		}
	}
	
	/**
	 * Process a message about the computation result for a resource allocation solution
	 * 
	 * @param nsInstanceId
	 * @param operationId
	 * @param solution
	 */
	public void notifyResourceComputationResult(String nsInstanceId, String operationId, NsResourceSchedulingSolution solution) {
		log.debug("Received notification about resource allocation computation result for network service " + nsInstanceId);
		if (this.nsManagers.containsKey(nsInstanceId)) {
			NotifyComputationResultMessage internalMessage = new NotifyComputationResultMessage(nsInstanceId, operationId, solution);
			String topic = "lifecycle.notifyAllocationSolution." + nsInstanceId;
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
				log.debug("Sent internal message with notification of resource allocation solution for network service " + nsInstanceId);
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal notify computation result message in Json format.");
			}
		} else {
			log.error("Network service " + nsInstanceId + " not existing. Nothing to do.");
		}
	}
	
	public void notifyResourceComputationRelease(String nsInstanceId, String operationId, boolean successful) {
		log.debug("Received notification about release of computed resources for network service " + nsInstanceId + ". Successful: " + successful);
		if (this.nsManagers.containsKey(nsInstanceId)) {
			NotifyComputationReleaseMessage internalMessage = new NotifyComputationReleaseMessage(nsInstanceId, operationId);
			String topic = "lifecycle.notifyAllocationSolutionRelease." + nsInstanceId;
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
				log.debug("Sent internal message with notification of the release of the resource allocation solution for network service " + nsInstanceId);
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal notify resource release message in Json format.");
			}
		} else {
			log.error("Network service " + nsInstanceId + " not existing. Nothing to do.");
		}
	}
	
	public void notifyResourceAllocationResult(String nsInstanceId, String operationId, AllocationMessageType allocationType, boolean isSuccessful) {
		log.debug("Received notification about resource allocation result for network service " + nsInstanceId);
		if (this.nsManagers.containsKey(nsInstanceId)) {
			NotifyAllocationResultMessage internalMessage = new NotifyAllocationResultMessage(nsInstanceId, operationId, isSuccessful, allocationType);
			String topic = "lifecycle.notifyAllocationResult." + nsInstanceId;
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
				log.debug("Sent internal message with notification of resource allocation result for network service " + nsInstanceId);
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal notify allocation result message in Json format.");
			}
		} else {
			log.error("Network service " + nsInstanceId + " not existing. Nothing to do.");
		}
	}
	
	public Nsd retrieveNsd(String nsInstanceId) throws NotExistingEntityException {
		log.debug("Searching NSD for NS Instance " + nsInstanceId);
		NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
		String nsdInstanceId = nsInfo.getNsdId();
		log.debug("NSD Instance ID: " + nsdInstanceId);
		Map<String, String> parameters = new HashMap<>();
		parameters.put("NSD_INFO_ID", nsdInstanceId);
		Filter filter = new Filter(parameters);
		GeneralizedQueryRequest request = new GeneralizedQueryRequest(filter, null);
		try {
			QueryNsdResponse nsdResponse = nsdManagement.queryNsd(request);
			NsdInfo nsdInfo = nsdResponse.getQueryResult().get(0);
			if (nsdInfo == null) {
				throw new NotExistingEntityException("Unable to retrieve NSD info in internal DB");
			}
			Nsd nsd = nsdInfo.getNsd();
			if (nsd == null) {
				throw new NotExistingEntityException("Unable to retrieve NSD from NSD info in internal DB");
			}
			return nsd;

		} catch (Exception e) {
			log.error("Failed response from NSD management");
			throw new NotExistingEntityException("Unable to retrieve NSD in internal DB");
		}
	}
	
	private String generateNewOperation(String nsInstanceId, String description) {
		String operationId = null;
		boolean operationIdFound = false;
		while (!operationIdFound) {
			try {
				operationId = UUID.randomUUID().toString();
				nsDbWrapper.createNewInternalOperation(operationId, nsInstanceId, description);
				operationIdFound = true;
			} catch (AlreadyExistingEntityException e) {
				log.debug("Already existing operation ID. Trying with a new one.");
			}
		}
		return operationId;
	}
	
	private void createQueue(String nsInstanceId, NsManager nsManager) {
		String queueName = NfvoConstants.engineQueueNamePrefix + nsInstanceId;
		log.debug("Creating new Queue " + queueName + " in rabbit host " + rabbitHost);
		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses(rabbitHost);
		cf.setConnectionTimeout(5);
		RabbitAdmin rabbitAdmin = new RabbitAdmin(cf);
		Queue queue = new Queue(queueName, false, false, true);
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(messageExchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(messageExchange).with("lifecycle.*." + nsInstanceId));
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
		MessageListenerAdapter adapter = new MessageListenerAdapter(nsManager, "receiveMessage");
		container.setMessageListener(adapter);
	    container.setQueueNames(queueName);
	    container.start();
	    log.debug("Queue created");
	}
	
}
