package it.nextworks.nfvmano.timeo.vnfm.sdkimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.elements.KeyValuePair;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ModifyVnfInformationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements.VnfConfiguration;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.IndicatorValueChangeNotification;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.vnfm.VeVnfmVnfmAccess;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.ConfigureVnfAckMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.ConfigureVnfRequestMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.VnfmMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.VnfmMessageType;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.VnfDriver;

/**
 * This entity handles the LCM of a PNF.
 * The PNF LCM is a reduced version of the VNF LCM. 
 * So far it supports only configuration.
 * 
 * @author nextworks
 *
 */
public class PnfLifecycleManager extends VeVnfmVnfmAccess {
	
	private static final Logger log = LoggerFactory.getLogger(PnfLifecycleManager.class);
	
	private String pnfId;
	private VnfInternalStatus internalStatus;
	private String currentOperation;
	private Pnfd pnfd;
	private RabbitTemplate rabbitTemplate;
	private TopicExchange messageExchange;
	private VnfDbWrapper vnfDbWrapper; //this is for VNFM operations
	private NsDbWrapper nsDbWrapper;   //this is for updating PNF info. To be checked if needed
	//private RestTemplate restTemplate;
	//private TaskExecutor taskExecutor;
	//private String managementIp;
	private Map<String, String> currentConfiguParameters;
	private VnfDriver pnfDriver;

	/**
	 * Constructor
	 * 
	 * @param pnfId ID of the PNF to be managed
	 * @param pnfd ID of the PNFD describing the PNF
	 * @param rabbitTemplate RABBIT MQ template
	 * @param messageExchange RABBIT MQ message template
	 * @param vnfDbWrapper DB wrapper for VNF operations
	 * @param nsDbWrapper DB wrapper for PNF info
	 * @param restTemplate REST template for REST API interaction with the PNF
	 * @param taskExecutor Task executor to handle asynchronously the interaction with the PNF for configuration issues
	 * @param managementIp IP address to be used for configuring the PNF
	 */
	public PnfLifecycleManager(String pnfId,
			Pnfd pnfd,
			RabbitTemplate rabbitTemplate,
			TopicExchange messageExchange,
			VnfDbWrapper vnfDbWrapper,
			NsDbWrapper nsDbWrapper,
			RestTemplate restTemplate,
			TaskExecutor taskExecutor,
			String managementIp) {
		this.pnfId = pnfId;
		this.internalStatus = VnfInternalStatus.ALLOCATED;
		this.pnfd = pnfd;
		this.rabbitTemplate = rabbitTemplate;
		this.messageExchange = messageExchange;
		this.vnfDbWrapper = vnfDbWrapper;
		this.nsDbWrapper = nsDbWrapper;
		//this.restTemplate = restTemplate;
		//this.taskExecutor = taskExecutor;
		//this.managementIp = managementIp;
		this.pnfDriver = new RestVnfDriver(pnfId, managementIp, restTemplate, taskExecutor);
		log.debug("Created REST-based PNF driver for PNF " + pnfId + " with IP " + managementIp);
		this.currentConfiguParameters= new HashMap<String, String>();
	}
	
	/**
	 * Method used to receive messages from the Rabbit MQ
	 * 
	 * @param message received message
	 */
	public void receiveMessage(String message) {
		log.debug("Received message for PNF " + pnfId + "\n" + message);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			VnfmMessage pnfmMsg = (VnfmMessage) mapper.readValue(message, VnfmMessage.class);
			VnfmMessageType type = pnfmMsg.getType();
			String operationId = pnfmMsg.getOperationId();
			
			switch (type) {
			
			case CONFIGURE_VNF: {
				log.debug("Received configure PNF message with operation ID " + operationId);
				log.trace("START CONFIGURE PNF " + operationId);
				//TODO: j.brenes verify the second condition. Added for the scaling procedure. 
				if (!(internalStatus.equals(VnfInternalStatus.ALLOCATED) || internalStatus.equals(VnfInternalStatus.CONFIGURED))) {
					signalError(operationId, "Received configure PNF message in wrong status.");
					return;
				}
				ConfigureVnfRequestMessage configureMsg = (ConfigureVnfRequestMessage)pnfmMsg;
				this.currentOperation = operationId;
				configurePnf(configureMsg.getRequest());
				break;
			}
			
			case CONFIGURE_VNF_ACK: {
				log.debug("Received PNF configuration ACK message");
				if (!(internalStatus.equals(VnfInternalStatus.CONFIGURING_VNF))) {
					signalError(operationId, "Received PNF configuration ACK in wrong status.");
					return;
				}
				ConfigureVnfAckMessage configAck = (ConfigureVnfAckMessage)pnfmMsg;
				processVnfConfigurationAck(configAck.getResult());
				log.trace("END CONFIGURE PNF " + configAck.getOperationId());
				break;
			}
			
			case ALLOCATE_VNF: 
			case TERMINATE_VNF: 
			case INSTANTIATE_VIM_NETWORK_RESOURCE_ACK:
			case INSTANTIATE_VIM_COMPUTING_RESOURCE_ACK: 
			case TERMINATE_VIM_COMPUTING_RESOURCE_ACK: {
				log.error("Received not acceptable message for LCM management of PNF " + pnfId + ". Skipping message.");
				break;
			}
			
			default:
				log.error("Received not acceptable message for LCM management of PNF " + pnfId + ". Skipping message.");
				break;
			}
			
		} catch(JsonParseException e) {
			log.error("Error while parsing message: " + e.getMessage());
		} catch(JsonMappingException e) {
			log.error("Error in Json mapping: " + e.getMessage());
		} catch(IOException e) {
			log.error("IO error when receiving json message: " + e.getMessage());
		}
	}
	
	private void configurePnf(ModifyVnfInformationRequest request) {
		log.debug("Starting procedure to configure PNF " + pnfId);
		internalStatus = VnfInternalStatus.CONFIGURING_VNF;
		try {
			Map<String, String> configParameters = request.getNewValues();
			if(!currentConfiguParameters.equals(configParameters)) {
				Set<KeyValuePair> pnfSpecificData = new HashSet<>();
				for (Map.Entry<String, String> p : configParameters.entrySet()) {
					pnfSpecificData.add(new KeyValuePair(p.getKey(), p.getValue()));
					//vnfDbWrapper.addGenericConfigParameterToVnfInfo(vnfInstanceId, p.getKey(), p.getValue());
				}
				VnfConfiguration pnfConfigurationData = new VnfConfiguration(null, null, pnfSpecificData);
				SetConfigurationRequest configRequest = new SetConfigurationRequest(pnfId, pnfConfigurationData, null);
				log.debug("Configuration request sent to PNF.");
				this.currentConfiguParameters=configParameters;
				pnfDriver.setConfiguration(configRequest, this);
			}else {
				log.debug("PNF configuration parameters unchanged. Skipping");
				this.processVnfConfigurationAck(OperationStatus.SUCCESSFULLY_DONE);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			signalError(currentOperation, e.getMessage());
		} 
	}
	
	private void processVnfConfigurationAck(OperationStatus operationStatus) {
		log.debug("Processing PNF configuration ACK");
		try {
			switch (operationStatus) {
			case FAILED: {
				log.error("PNF configuration has failed.");
				signalError(currentOperation, "PNF configuration failed for PNF " + pnfId);
				break;
			}

			case SUCCESSFULLY_DONE: {
				log.debug("PNF configuration has been correctly performed.");
				internalStatus = VnfInternalStatus.CONFIGURED;
				vnfDbWrapper.updateVnfmInternalOperation(currentOperation, OperationStatus.SUCCESSFULLY_DONE, "PNF configured.");
				log.debug("PNF " + pnfId + " configured.");
				break;
			}

			default:
				log.warn("Unexpected status in PNF config ACK. Skipping message.");
				break;
			}
		} catch (Exception e) {

		}
	}
	
	//****************** Methods to handle asynchronous notifications from a PNF
	@Override
	public void notify(IndicatorValueChangeNotification notification) 
			throws MethodNotImplementedException {
		throw new MethodNotImplementedException();
		// TODO Auto-generated method stub

	}

	@Override
	public void notifySetConfigurationResult(ResponseCode respondeCode, 
			SetConfigurationResponse responseMessage)
					throws MethodNotImplementedException {
		log.debug("Received notification about PNF configuration from PNF");
		OperationStatus operationStatus = OperationStatus.SUCCESSFULLY_DONE;
		if (respondeCode != ResponseCode.OK) operationStatus = OperationStatus.FAILED;
		ConfigureVnfAckMessage ackMessage = new ConfigureVnfAckMessage(pnfId, currentOperation, responseMessage, operationStatus);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			String topic = "pnflifecycle.notifyVnfConfigResult." + pnfId;
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with ACK for PNF configuration");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post PNF config ack to internal queue");
		}
	}

	//************************* End of methods to handle asynchronous notifications from a VNF

	
	private void signalError(String operationId, String errorMsg) {
		try {
			log.error(errorMsg);
			vnfDbWrapper.updateVnfmInternalOperation(operationId, OperationStatus.FAILED, errorMsg);
		} catch (NotExistingEntityException e) {
			log.error("VNFM operation ID not found in DB: impossible to save error.");
		}
	}

}
