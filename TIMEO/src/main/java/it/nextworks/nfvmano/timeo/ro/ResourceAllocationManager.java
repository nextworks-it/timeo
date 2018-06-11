/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.ro;



import java.util.HashMap;
import java.util.Map;

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

import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.NsdManagementService;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.NfvoConstants;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import it.nextworks.nfvmano.timeo.nso.messages.InstantiateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.messages.TerminateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.rc.repositories.ResourceComputationDbWrapper;
import it.nextworks.nfvmano.timeo.ro.messages.AllocateNsVlsMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocateVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;
import it.nextworks.nfvmano.timeo.ro.messages.ConfigureVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.DestroyUnderlyingConnectivityMessage;
import it.nextworks.nfvmano.timeo.ro.messages.SetupUnderlyingConnectivityMessage;
import it.nextworks.nfvmano.timeo.ro.messages.TerminateNsVlsMessage;
import it.nextworks.nfvmano.timeo.ro.messages.TerminateVnfMessage;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriversManager;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.Vnfm;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;

/**
 * Entity in charge of allocating the resources for the NS instances
 * making use of the south-bound drivers
 * 
 * @author nextworks
 *
 */
@Service
public class ResourceAllocationManager {

	private static final Logger log = LoggerFactory.getLogger(ResourceAllocationManager.class);
	
	@Autowired
	private ResourceComputationDbWrapper resourceComputationDbWrapper;
	
	@Autowired
	private NsManagementEngine nsManagementEngine;
	
	@Autowired
	private NsDbWrapper nsDbWrapper;
	
	@Autowired
	private NsdManagementService nsdManagement;
	
	@Autowired
	private VnfmHandler vnfmHandler;
	
	@Autowired
	private VnfPackageManagementService vnfPackageManagement;
	
	@Value("${spring.rabbitmq.host}")
	private String rabbitHost;
	
	@Autowired
	private VimResourcePollingManager vimResourcePollingManager;
	
	@Autowired
	private VnfmOperationPollingManager vnfmOperationPollingManager;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	@Qualifier(NfvoConstants.allocationQueueExchange)
	TopicExchange allocationMessageExchange;

	private Map<String, NsResourceAllocationManager> nsResourceManagers = new HashMap<>();

	@Autowired
	private SbDriversManager sbDriversManager;
	
	public ResourceAllocationManager() { }
	
	/**
	 * Method used to request the allocation of NS Virtual Links
	 * 
	 * @param nsInstanceId ID of the network service instance
	 * @param operationId  ID of the operation
	 * @param instantiateMessage original instantiation message
	 */
	public void allocateNsVls(String nsInstanceId, String operationId, InstantiateNsRequestMessage instantiateMessage) {
		log.debug("Invoked allocate NS VLs method");
		//This should be the first message received for  a new NS instantiation. 
		//So it creates a new NS resource manager and puts it in the map
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			log.error("Trying to allocate VLs for an already existing NS. Not supported");
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Trying to allocate VLs for an NS already existing in Allocation Manager.");
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.ALLOCATE_NS_VLS, false);
			}
		} else {
			VimPlugin defaultVimPlugin = null;
			SdnControllerPlugin defaultSdnController = null;
			try {
				defaultVimPlugin = sbDriversManager.getDefaultVim();
				if (resourceComputationDbWrapper
						.getNsResourceSchedulingSolution(nsInstanceId)
						.getNetworkPaths()
						.size()
						!= 0) {
					defaultSdnController = sbDriversManager.getDefaultSdnController();
				}
			} catch (NotExistingEntityException e) {
				log.error("Unable to retrieve a default VIM or SDN controller.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Unable to retrieve a default VIM or SDN controller.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.ALLOCATE_NS_VLS, false);
				}
			}
			NsResourceAllocationManager nsResourceAllocationManager = new NsResourceAllocationManager(nsInstanceId, nsDbWrapper, vnfPackageManagement,
					rabbitTemplate, resourceComputationDbWrapper, nsManagementEngine, nsdManagement, defaultVimPlugin, allocationMessageExchange, 
					vimResourcePollingManager, vnfmHandler, vnfmOperationPollingManager, defaultSdnController);
			Queue queue = createQueue(nsInstanceId, nsResourceAllocationManager);
			nsResourceAllocationManager.setQueue(queue);
			nsResourceManagers.put(nsInstanceId, nsResourceAllocationManager);
			AllocateNsVlsMessage internalMessage = new AllocateNsVlsMessage(nsInstanceId, operationId, instantiateMessage.getRequest());
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for NS VLs allocation");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal allocate NS VLs message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal allocate NS VLs message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.ALLOCATE_NS_VLS, false);
			}
		}
	}
	
	/**
	 * Method used to request the allocation of the VNFs associated to a Network Service
	 * 
	 * @param nsInstanceId ID of the NS instance
	 * @param operationId ID of the current operation
	 * @param instantiateMessage Instantiation message with the details of the instantiation request
	 */
	public void allocateVnf(String nsInstanceId, String operationId, InstantiateNsRequestMessage instantiateMessage) {
		log.debug("Invoked allocate VNFs method for NS instance " + nsInstanceId);
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			AllocateVnfMessage internalMessage = new AllocateVnfMessage(nsInstanceId, operationId, instantiateMessage.getRequest());
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for VNF allocation");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal allocate VNF message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal allocate VNF message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.ALLOCATE_VNF, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.ALLOCATE_VNF, false);
		}
	}
	
	/**
	 * Method used to request the configuration of the VNFs associated to a Network Service
	 * 
	 * @param nsInstanceId ID of the NS instance
	 * @param operationId ID of the current operation
	 * @param instantiateMessage Instantiation message with the details of the instantiation request
	 */
	public void configureVnfs(String nsInstanceId, String operationId, InstantiateNsRequestMessage instantiateMessage) {
		log.debug("Invoked configure VNFs method for NS instance " + nsInstanceId);
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			ConfigureVnfMessage internalMessage = new ConfigureVnfMessage(nsInstanceId, operationId, instantiateMessage.getRequest());
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for VNF configuration");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal configure VNF message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal configure VNF message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.CONFIGURE_VNF, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.CONFIGURE_VNF, false);
		}
	}
	
	/**
	 * Method used to request the setup of the network connectivity
	 * 
	 * @param nsInstanceId ID of the NS instance
	 * @param operationId ID of the current operation
	 * @param instantiateMessage Instantiation message with the details of the instantiation request
	 */
	public void setupUnderlyingConnectivity(String nsInstanceId, String operationId, InstantiateNsRequestMessage instantiateMessage) {
		log.debug("Invoked setup underlying connectivity method for NS instance " + nsInstanceId);
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			SetupUnderlyingConnectivityMessage internalMessage = new SetupUnderlyingConnectivityMessage(nsInstanceId, operationId, instantiateMessage.getRequest());
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for underlying connectivity setup");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal setup underlying connectivity in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal setup underlying connectivity message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY, false);
		}
	}
	
	public void terminateVnfs(String nsInstanceId, String operationId, TerminateNsRequestMessage terminateMessage) {
		log.debug("Invoked terminate VNFs method for NS instance " + nsInstanceId);
		
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			TerminateVnfMessage internalMessage = new TerminateVnfMessage(nsInstanceId, operationId, terminateMessage.getRequest());
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for VNF termination");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal terminate VNF message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal terminate VNF message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_VNF, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_VNF, false);
		}
	}

	public void terminateNsVls(String nsInstanceId, String operationId) {
		log.debug("Invoked terminate NS VLs method for NS instance " + nsInstanceId);
		
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			TerminateNsVlsMessage internalMessage = new TerminateNsVlsMessage(nsInstanceId, operationId);
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for NS VLs termination");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal terminate NS VLs message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal terminate NS VLs message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_NS_VLS, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_NS_VLS, false);
		}
	}

	public void destroyUnderlyingConnectivity(String nsInstanceId, String operationId) {
		log.debug("Invoked destroy underlying connectivity method for NS instance " + nsInstanceId);
		
		if (nsResourceManagers.containsKey(nsInstanceId)) {
			DestroyUnderlyingConnectivityMessage internalMessage = new DestroyUnderlyingConnectivityMessage(nsInstanceId, operationId);
			ObjectMapper mapper = Utilities.buildObjectMapper();
			try {
				String json = mapper.writeValueAsString(internalMessage);
				rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
				log.debug("Sent internal message with request for removal of underlying connectivity");
			} catch (JsonProcessingException e) {
				log.error("Error while translating internal destroy underlying connections message in Json format.");
				try {
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal destroy underlying connections message in Json format.");
				} catch (NotExistingEntityException e1) {
					log.error("Error while updating internal operation status");
				}
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY, false);
			}
		} else {
			log.error("NS resource manager not found for NS instance " + nsInstanceId);
			try {
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS resource manager not found for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e1) {
				log.error("Error while updating internal operation status");
			}
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, operationId, AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY, false);
		}
	}
	
	public Vnfm getVnfmForVnfInstance(String nsInstanceId, String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving VNFM for VNF " + vnfInstanceId + " in NS " + nsInstanceId);
		if (nsResourceManagers.containsKey(nsInstanceId)) return nsResourceManagers.get(nsInstanceId).getVnfmForVnfInstance(vnfInstanceId);
		else throw new NotExistingEntityException("NS instance " + nsInstanceId + " not found in resource allocation manager. Impossible to retrieve the VNFM for its VNFs.");
	}
	
	private Queue createQueue(String nsInstanceId, NsResourceAllocationManager nsResourceAllocationManager) {
		log.debug("Creating internal queue for resource allocation manager");
		String queueName = NfvoConstants.allocationQueueNamePrefix + nsInstanceId;
		log.debug("Creating new Queue " + queueName + " in rabbit host " + rabbitHost);
		CachingConnectionFactory cf = new CachingConnectionFactory();
		cf.setAddresses(rabbitHost);
		cf.setConnectionTimeout(5);
		RabbitAdmin rabbitAdmin = new RabbitAdmin(cf);
		Queue queue = new Queue(queueName, false, false, true);
		rabbitAdmin.declareQueue(queue);
		rabbitAdmin.declareExchange(allocationMessageExchange);
		rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(allocationMessageExchange).with("resourceAllocate." + nsInstanceId));
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
		MessageListenerAdapter adapter = new MessageListenerAdapter(nsResourceAllocationManager, "receiveMessage");
		container.setMessageListener(adapter);
	    container.setQueueNames(queueName);
	    container.start();
	    log.debug("Queue created");
	    return queue;
	}
	
	
}
