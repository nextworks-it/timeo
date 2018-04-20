package it.nextworks.nfvmano.timeo.vnfm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.elements.Filter;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.VnfLcmConsumerInterface;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ChangeExternalVnfConnectivityRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ChangeVnfFlavourRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.CreateVnfIdentifierRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.HealVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.InstantiateVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ModifyVnfInformationRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.OperateVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.QueryVnfResponse;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ScaleVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ScaleVnfToLevelRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.TerminateVnfRequest;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationConsumerInterface;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.NfvoConstants;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.ro.VimResourcePollingManager;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriversManager;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfmInternalOperation;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.VnfLifecycleManager;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.ConfigureVnfRequestMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.InstantiateVnfRequestMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.TerminateVnfRequestMessage;


public class SdkVnfm extends Vnfm {

	private static final Logger log = LoggerFactory.getLogger(SdkVnfm.class);
	
	private VnfDbWrapper vnfDbWrapper;
	
	private VnfPackageManagementService vnfPackageManagementService;
	
	private VimResourcePollingManager vimResourcePollingManager;
	
	private SbDriversManager sbDriversManager;
	
	private String rabbitHost;
	
	private RabbitTemplate rabbitTemplate;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private TaskExecutor taskExecutor;
	
	TopicExchange messageExchange;
	
	//Key: vnf instance ID; Value: VNFD
	private Map<String, Vnfd> vnfds = new HashMap<>();
	
	//Key: VNF instance ID; Value: VNF lifecycle manager
	private Map<String, VnfLifecycleManager> vnfLifecycleManagers = new HashMap<>();
	
	public SdkVnfm(VnfmInfo vnfmInfo, 
			VnfDbWrapper vnfDbWrapper, 
			VnfPackageManagementService vnfPackageManagementService, 
			VimResourcePollingManager vimResourcePollingManager,
			SbDriversManager sbDriversManager,
			String rabbitHost,
			RabbitTemplate rabbitTemplate,
			TopicExchange messageExchange, 
			TaskExecutor taskExecutor) {
		super(VnfmType.SDK, vnfmInfo);
		this.vnfDbWrapper = vnfDbWrapper;
		this.vnfPackageManagementService = vnfPackageManagementService;
		this.vimResourcePollingManager = vimResourcePollingManager;
		this.sbDriversManager = sbDriversManager;
		this.rabbitHost = rabbitHost;
		this.rabbitTemplate = rabbitTemplate;
		this.messageExchange = messageExchange;
		this.taskExecutor = taskExecutor;
	}
	
	@Override
	public String createVnfIdentifier(CreateVnfIdentifierRequest request) 
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		String vnfdId = request.getVnfdId();
		String vnfInstanceName = request.getVnfInstanceName();
		String vnfInstanceDescription = request.getVnfInstanceDescription();
		log.debug("Received request to create a new VNF identifier for VNF " + vnfInstanceName + " with VNFD " + vnfdId);
		OnboardedVnfPkgInfo pkg = vnfPackageManagementService.getOnboardedVnfPkgInfoFromVnfd(vnfdId);
		log.debug("Found VNF package.");
		String vnfInstanceId = vnfDbWrapper.createVnfInfo(vnfInstanceName, vnfInstanceDescription, vnfdId, pkg.getVnfProvider(),
				pkg.getVnfProductName(), pkg.getVnfSoftwareVersion(), pkg.getVnfdVersion(), pkg.getOnboardedVnfPkgInfoId(), null, null);
		log.debug("VNF info created");
		Vnfd vnfd = pkg.getVnfd();
		vnfds.put(vnfInstanceId, vnfd);
		VnfLifecycleManager vnfLifecycleManager = new VnfLifecycleManager(vnfInstanceId, 
				vnfd, 
				rabbitTemplate, 
				messageExchange, 
				vnfDbWrapper, 
				vimResourcePollingManager,
				sbDriversManager, 
				restTemplate,
				taskExecutor);
		createQueue(vnfInstanceId, vnfLifecycleManager);
		vnfLifecycleManagers.put(vnfInstanceId, vnfLifecycleManager);
		return vnfInstanceId;
	}
	
	@Override
	public String instantiateVnf(InstantiateVnfRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		String vnfInstanceId = request.getVnfInstanceId();
		log.debug("Received VNF instantiation request for VNF instance " + vnfInstanceId);
		if (!(vnfLifecycleManagers.containsKey(vnfInstanceId))) throw new NotExistingEntityException("VNF lifecycle manager not found for VNF instance " + vnfInstanceId);
		
		String operationId = generateNewOperation(vnfInstanceId, "VNF instantiation");
		
		String topic = "vnflifecycle.instantiate." + vnfInstanceId;
		InstantiateVnfRequestMessage msg = new InstantiateVnfRequestMessage(vnfInstanceId, operationId, request);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(msg);
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with request to instantiate VNF " + vnfInstanceId);
			return operationId;
		} catch (JsonProcessingException e) {
			log.error("Error while translating internal instantiation message in Json format.");
			vnfDbWrapper.updateVnfmInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal instantiation message in Json format.");
			return operationId;
		}
	}
	
	@Override
	public String scaleVnf(ScaleVnfRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String scaleVnfToLevel(ScaleVnfToLevelRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String changeVnfFlavour(ChangeVnfFlavourRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String terminateVnf(TerminateVnfRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		String vnfInstanceId = request.getVnfInstanceId();
		log.debug("Received VNF termination request for VNF instance " + vnfInstanceId);
		if (!(vnfLifecycleManagers.containsKey(vnfInstanceId))) throw new NotExistingEntityException("VNF lifecycle manager not found for VNF instance " + vnfInstanceId);
		
		String operationId = generateNewOperation(vnfInstanceId, "VNF termination");
		
		String topic = "vnflifecycle.terminate." + vnfInstanceId;
		TerminateVnfRequestMessage msg = new TerminateVnfRequestMessage(vnfInstanceId, operationId, request);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(msg);
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with request to terminate VNF " + vnfInstanceId);
			return operationId;
		} catch (JsonProcessingException e) {
			log.error("Error while translating internal termination message in Json format.");
			vnfDbWrapper.updateVnfmInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal termination message in Json format.");
			return operationId;
		}
	}
	
	@Override
	public void deleteVnfIdentifier(String vnfInstanceId) 
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		log.debug("Received request to delete VNF ID " + vnfInstanceId);
		VnfInfo vnfInfo = vnfDbWrapper.getVnfInfo(vnfInstanceId);
		if (vnfInfo.getInstantiationState() == InstantiationState.NOT_INSTANTIATED) {
			log.debug("VNF " + vnfInstanceId + " is in not instantiated state and it can be removed.");
			vnfDbWrapper.deleteVnfInfo(vnfInstanceId);
		} else {
			log.debug("VNF " + vnfInstanceId + " is in instantiated state and it cannot be removed.");
			throw new FailedOperationException("VNF " + vnfInstanceId + " is in instantiated state and it cannot be removed.");
		}
	}
	
	@Override
	public QueryVnfResponse queryVnf(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		log.debug("Received query for a VNF.");
		
		//At the moment the only filter accepted is:
		//1. VNF Instance ID
		//No attribute selector is supported at the moment
		
		Filter filter = request.getFilter();
		List<String> attributeSelector = request.getAttributeSelector();
		
		if ((attributeSelector == null) || (attributeSelector.isEmpty())) {
			Map<String,String> fp = filter.getParameters();
			if ((fp == null) || (fp.isEmpty())) {
				log.debug("Query with empty filter. Returning all the elements");
				List<VnfInfo> vnfInfos = vnfDbWrapper.getAllVnfInfo();
				return new QueryVnfResponse(vnfInfos);
			} else if (fp.size()==1 && fp.containsKey("VNF_INSTANCE_ID")) {
				String vnfInstanceId = fp.get("VNF_INSTANCE_ID");
				log.debug("Received query for VNF instance " + vnfInstanceId);
				VnfInfo vnfInfo = vnfDbWrapper.getVnfInfo(vnfInstanceId);
				List<VnfInfo> vnfInfos = new ArrayList<>();
				vnfInfos.add(vnfInfo);
				return new QueryVnfResponse(vnfInfos);
			}
		} else {
			log.error("Received query VNF info with attribute selector. Not supported at the moment.");
			throw new FailedOperationException("Received query VNF info with attribute selector. Not supported at the moment.");
		}
		throw new MethodNotImplementedException();
	}
	
	@Override
	public String healVnf(HealVnfRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String operateVnf(OperateVnfRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String modifyVnfInformation(ModifyVnfInformationRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		String vnfInstanceId = request.getVnfInstanceId();
		log.debug("Received VNF modification request for VNF instance " + vnfInstanceId);
		if (!(vnfLifecycleManagers.containsKey(vnfInstanceId))) throw new NotExistingEntityException("VNF lifecycle manager not found for VNF instance " + vnfInstanceId);
		
		String operationId = generateNewOperation(vnfInstanceId, "VNF configuration");
		
		String topic = "vnflifecycle.configure." + vnfInstanceId;
		ConfigureVnfRequestMessage msg = new ConfigureVnfRequestMessage(vnfInstanceId, operationId, request);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(msg);
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with request to configure VNF " + vnfInstanceId);
			return operationId;
		} catch (JsonProcessingException e) {
			log.error("Error while translating internal configuration message in Json format.");
			vnfDbWrapper.updateVnfmInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal configuration message in Json format.");
			return operationId;
		}
	}
	
	@Override
	public OperationStatus getOperationStatus(String operationId)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		log.debug("Getting operation status for operation " + operationId);
		VnfmInternalOperation operation = vnfDbWrapper.readVnfmInternalOperation(operationId);
		return operation.getStatus();
	}
	
	@Override
	public String subscribe(SubscribeRequest request, VnfLcmConsumerInterface consumer) 
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public void unsubscribe(String subscriptionId) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public void queryNsSubscription(GeneralizedQueryRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
	@Override
	public String changeExternalVnfConnectivity(ChangeExternalVnfConnectivityRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}

	
	private String generateNewOperation(String vnfInstanceId, String description) {
		String operationId = null;
		boolean operationIdFound = false;
		while (!operationIdFound) {
			try {
				operationId = UUID.randomUUID().toString();
				vnfDbWrapper.createNewVnfmInternalOperation(operationId, vnfInstanceId, description);
				operationIdFound = true;
			} catch (AlreadyExistingEntityException e) {
				log.debug("Already existing operation ID. Trying with a new one.");
			}
		}
		return operationId;
	}
	
	private void createQueue(String vnfInstanceId, VnfLifecycleManager vnfLifecycleManager) {
		String queueName = NfvoConstants.vnfmQueueNamePrefix + vnfInstanceId;
		log.debug("Creating new Queue " + queueName + " in rabbit host " + rabbitHost);
		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses(rabbitHost);
		cf.setConnectionTimeout(5);
		RabbitAdmin rabbitAdmin = new RabbitAdmin(cf);
		Queue queue = new Queue(queueName, false, false, true);
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(messageExchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(messageExchange).with("vnflifecycle.*." + vnfInstanceId));
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
		MessageListenerAdapter adapter = new MessageListenerAdapter(vnfLifecycleManager, "receiveMessage");
		container.setMessageListener(adapter);
	    container.setQueueNames(queueName);
	    container.start();
	    log.debug("Queue created");
	}
	
	/**
	 * Registers a new NFVO for the asynchronous interactions 
	 * needed for a given VNF instance
	 * 
	 * @param vnfId ID of the VNF instance
	 * @param nfvo NFVO to be contacted for the given VNF instance
	 */
	@Override
	public void registerNfvo(String vnfId, OrVnfmNfvoAccess nfvo) {
		nfvos.put(vnfId, nfvo);
		vnfLifecycleManagers.get(vnfId).setOrVnfmNfvoAccess(nfvo);
		log.debug("Registered NFVO for VNF " + vnfId);
	}
	
	
	
	/***************VnfConfigurationManagementProviderInterface methods************/
	
	@Override
	public void setConfiguration(SetConfigurationRequest request, VnfConfigurationConsumerInterface consumer)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		throw new MethodNotImplementedException();
		//TODO:
	}
	
}
