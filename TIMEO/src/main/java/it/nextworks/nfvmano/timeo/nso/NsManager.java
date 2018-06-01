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
package it.nextworks.nfvmano.timeo.nso;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.common.exception.WrongInternalStatusException;
import it.nextworks.nfvmano.timeo.nso.messages.EngineMessage;
import it.nextworks.nfvmano.timeo.nso.messages.EngineMessageType;
import it.nextworks.nfvmano.timeo.nso.messages.InstantiateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.messages.NotifyAllocationResultMessage;
import it.nextworks.nfvmano.timeo.nso.messages.NotifyComputationResultMessage;
import it.nextworks.nfvmano.timeo.nso.messages.TerminateNsRequestMessage;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.rc.ResourceSchedulingManager;
import it.nextworks.nfvmano.timeo.ro.ResourceAllocationManager;
import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;


/**
 * Entity in charge of managing the computation and allocation of resources
 * for a single network service
 * 
 * @author nextworks
 *
 */
public class NsManager {

	private static final Logger log = LoggerFactory.getLogger(NsManager.class);
	private String nsInstanceId;
	private InternalNsStatus internalStatus;
	private InstantiateNsRequestMessage instantiateMessage;
	private TerminateNsRequestMessage terminateMessage;
	
	NsDbWrapper nsDbWrapper;
	ResourceSchedulingManager resourceSchedulingManager;
	ResourceAllocationManager resourceAllocationManager;
	
	public NsManager(String nsInstanceId,
			ResourceSchedulingManager resourceSchedulingManager,
			NsDbWrapper nsDbWrapper,
			ResourceAllocationManager resourceAllocationManager) {
		this.nsInstanceId = nsInstanceId;
		this.internalStatus = InternalNsStatus.TO_BE_INSTANTIATED;
		this.resourceSchedulingManager = resourceSchedulingManager;
		this.nsDbWrapper = nsDbWrapper;
		this.resourceAllocationManager = resourceAllocationManager;
	}

	/**
	 * Method used to receive messages from the Rabbit MQ
	 * 
	 * @param message received message
	 */
	public void receiveMessage(String message) {
		log.debug("Received message for NS instance " + nsInstanceId + "\n" + message);
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			EngineMessage em = (EngineMessage) mapper.readValue(message, EngineMessage.class);
			EngineMessageType type = em.getType();
			String operationId = em.getOperationId();
			
			switch (type) {
			case INSTANTIATE_NS_REQUEST: {
				log.trace("START INSTANTIATE NS FOR NS " + nsInstanceId);
				log.debug("Received instantiate NS message with operation ID " + operationId);
				InstantiateNsRequestMessage instantiateMsg = (InstantiateNsRequestMessage)em;
				//TODO: message to be moved in DB for persistency issues
				this.instantiateMessage = instantiateMsg;
				try {
					nsDbWrapper.setNsInfoDeploymentFlavour(nsInstanceId, instantiateMsg.getRequest().getFlavourId());
					Map<String, String> configurationParameters = instantiateMsg.getRequest().getConfigurationParameterList();
					nsDbWrapper.setNsInfoConfigurationParameters(nsInstanceId, configurationParameters);
					instantiateNs(instantiateMsg);
				} catch (WrongInternalStatusException e) {
					log.error("Received instantiate NS request in wrong status");
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received instantiate NS request in wrong status");
					internalStatus = InternalNsStatus.FAILED;
				} catch (NotExistingEntityException e) {
					log.error("NS instance not found");
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "NS instance not found in DB.");
					internalStatus = InternalNsStatus.FAILED;
				}
				break;
			}
			
			case NOTIFY_COMPUTATION_RESULT: {
				log.debug("Received resource allocation computation result message with operation ID " + operationId);
				NotifyComputationResultMessage notifyMsg = (NotifyComputationResultMessage)em;
				if (notifyMsg.getSolution().isSolutionFound()) {
					try {
						allocateNsVlsResources(operationId);
					} catch (WrongInternalStatusException e) {
						log.error("Received notify computation result message in wrong status");
						nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify computation result message in wrong status");
						this.internalStatus = InternalNsStatus.FAILED;
					}
				} else {
					log.error("Resource computation failed. Setting internal status to failed.");
					this.internalStatus=InternalNsStatus.FAILED;
					//TODO: should we somehow remove this NS Manager instance?
				}
				break;
			}
			
			case NOTIFY_ALLOCATION_RESULT: {
				log.debug("Received resource allocation result message with operation ID " + operationId);
				NotifyAllocationResultMessage notifyMsg = (NotifyAllocationResultMessage)em;
				AllocationMessageType allocationType = notifyMsg.getAllocationType();

				switch (allocationType) {
				case ALLOCATE_NS_VLS: {
					if (notifyMsg.isSuccessful()) {
						log.trace("END CREATE VIRTUAL_LINKS");
						log.debug("NS VLs successfully allocated");
						try {
							allocateVnfs(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify NS VLs allocation result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify NS VLs allocation result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						} 
					} else {
						log.error("NS virtual links allocation failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation
					}
					break;
				}

				case ALLOCATE_VNF: {
					if (notifyMsg.isSuccessful()) {
						log.trace("END CREATE VNFS");
						log.debug("VNFs successfully allocated");
						try {
							setupUnderlyingConnectivity(operationId);
							//configureVnfs(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify VNFs allocation result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify VNFs allocation result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("VNFs allocation failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation, release NS links
					}
					break;
				}
				
				case CONFIGURE_VNF: {
					if (notifyMsg.isSuccessful()) {
						log.trace("END CONFIGURE VNFS FOR NS " + nsInstanceId);
						log.trace("END INSTANTIATE NS FOR NS " + nsInstanceId);
						log.debug("VNFs successfully configured");
						try {
							confirmUnderlyingConnectivity(operationId);
							//setupUnderlyingConnectivity(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify VNFs configuration result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify VNFs configuration result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("VNFs configuration failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation, release VNFs and NS links
					}
					break;
				}
				
				case SETUP_UNDERLYING_CONNECTIVITY: {
					if (notifyMsg.isSuccessful()) {
						log.debug("Underlying network connectivity established");
						try {
							configureVnfs(operationId);
							//confirmUnderlyingConnectivity(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify result message for underlying connections in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify result message for underlying connections in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("Network underlying connections failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation, release VNFs and NS links
					}
					break;
				}
				
				case REMOVE_VNF: {
					if (notifyMsg.isSuccessful()) {
						log.debug("VNFs successfully removed");
						try {
							destroyUnderlyingConnectivity(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify VNFs termination result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify VNFs termination result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("VNFs termination failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation, release NS links
					}
					break;
				}
				
				case REMOVE_UNDERLYING_CONNECTIVITY: {
					if (notifyMsg.isSuccessful()) {
						log.debug("Underlying network connectivity successfully destroyed");
						try {
							releaseNsVlsResources(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify underlying connection termination result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify underlying connection termination result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("Removal of underlying connection failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;
						//TODO: release computed resources in path computation, release NS links
					}
					break;
				}
				
				case REMOVE_NS_VLS: {
					if (notifyMsg.isSuccessful()) {
						log.debug("NS virtual links successfully destroyed");
						try {
							releaseResourceAllocationSolution(operationId);
						} catch (WrongInternalStatusException e) {
							log.error("Received notify NS VLs termination result message in wrong status");
							nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notify NS VLs termination result message in wrong status");
							this.internalStatus = InternalNsStatus.FAILED;
						}
					} else {
						log.error("Removal of underlying connection failed. Setting internal status to failed.");
						this.internalStatus=InternalNsStatus.FAILED;						
					}
					break;
				}

				default:
					break;
				}

				break;
			}
			
			case TERMINATE_NS_REQUEST: {
				log.debug("Received terminate NS message with operation ID " + operationId);
				TerminateNsRequestMessage terminateMsg = (TerminateNsRequestMessage)em;
				this.terminateMessage = terminateMsg;
				try {
					terminateNs(terminateMsg);
				} catch (WrongInternalStatusException e) {
					log.error("Received terminate NS request in wrong status");
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received terminate NS request in wrong status");
					internalStatus = InternalNsStatus.FAILED;
				} 
				break;
			}

			case NOTIFY_COMPUTATION_RELEASE: {
				log.debug("Received notification about release of computed resources in internal stateful algorithm DB for operation " + operationId);
				try {
					confirmComputedResourceRelease(operationId);
				} catch (WrongInternalStatusException e) {
					log.error("Received notification of resource release in wrong status");
					nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Received notification of resource release in wrong status");
					internalStatus = InternalNsStatus.FAILED;
				}
				break;
			}
			
			default: {
				log.error("Received message with not supported type");
				nsDbWrapper.updateInternalOperation(operationId, OperationStatus.FAILED, "Engine message with not supported type");
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
			log.error("Error: " + e.getMessage());
		}
	}
	
	private void releaseResourceAllocationSolution(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.REMOVING_NS_VLS) throw new WrongInternalStatusException();
		log.debug("Starting procedure to release resource allocation solution");
		internalStatus = InternalNsStatus.RELEASING_COMPUTED_RESOURCES;
		try {
			resourceSchedulingManager.releaseResources(terminateMessage);
		} catch (Exception e) {
			log.error("Error while sending internal request for release of computed resources " + e.getMessage());
		}
	}

	private void destroyUnderlyingConnectivity(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.TERMINATING_VNFS) throw new WrongInternalStatusException();
		log.debug("Starting procedure to destroy underlying connectivity.");
		internalStatus = InternalNsStatus.TERMINATING_CONNECTIVITY;
		resourceAllocationManager.destroyUnderlyingConnectivity(nsInstanceId, operationId);
	}
	
	private void releaseNsVlsResources(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.TERMINATING_CONNECTIVITY) throw new WrongInternalStatusException();
		log.debug("Starting procedure to release NS Virtual Links.");
		internalStatus = InternalNsStatus.REMOVING_NS_VLS;
		resourceAllocationManager.terminateNsVls(nsInstanceId, operationId);
	}
	
	private void terminateNs(TerminateNsRequestMessage message) throws WrongInternalStatusException {
		if (!((internalStatus == InternalNsStatus.ALLOCATED) || (internalStatus == InternalNsStatus.FAILED))) throw new WrongInternalStatusException();
		log.debug("Starting procedure to terminate a new Network Service.");
		internalStatus = InternalNsStatus.TERMINATING_VNFS;
		resourceAllocationManager.terminateVnfs(nsInstanceId, message.getOperationId(), message);	
	}
	
	private void instantiateNs(InstantiateNsRequestMessage message) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.TO_BE_INSTANTIATED) throw new WrongInternalStatusException();
		log.debug("Starting procedure to instantiate a new Network Service.");
		//TODO: Here it should check if the VNFs and PNFs defined in the instantiate NS request are available
		//At the moment we are assuming no PNFs are supported and all the VNFs should be created from scratch.
		internalStatus = InternalNsStatus.COMPUTING_RESOURCES;
		try {
			resourceSchedulingManager.reserveResources(message);
		} catch (Exception e) {
			log.error("Error while sending internal request for resource computation " + e.getMessage());
		}
	}
	
	private void allocateNsVlsResources(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.COMPUTING_RESOURCES) throw new WrongInternalStatusException();
		log.debug("Starting procedure to allocate the resources for a new Network Service.");
		internalStatus = InternalNsStatus.ALLOCATING_NS_VLS;
		resourceAllocationManager.allocateNsVls(nsInstanceId, operationId, instantiateMessage);
	}
	
	private void allocateVnfs(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.ALLOCATING_NS_VLS) throw new WrongInternalStatusException();
		log.debug("Starting procedure to instantiate VNFs");
		internalStatus = InternalNsStatus.CREATING_VNFS;
		resourceAllocationManager.allocateVnf(nsInstanceId, operationId, instantiateMessage);
	}
	
	private void configureVnfs(String operationId) throws WrongInternalStatusException {
		//if (internalStatus != InternalNsStatus.CREATING_VNFS) throw new WrongInternalStatusException();
		log.trace("START CONFIGURE VNFS FOR NS " + nsInstanceId);
		if (internalStatus != InternalNsStatus.CREATING_CONNECTIVITY) throw new WrongInternalStatusException();
		log.debug("Starting procedures to configure VNFs");
		internalStatus = InternalNsStatus.CONFIGURING_VNFS;
		resourceAllocationManager.configureVnfs(nsInstanceId, operationId, instantiateMessage);
	}
	
	private void setupUnderlyingConnectivity(String operationId) throws WrongInternalStatusException {
		//if (internalStatus != InternalNsStatus.CONFIGURING_VNFS) throw new WrongInternalStatusException();
		if (internalStatus != InternalNsStatus.CREATING_VNFS) throw new WrongInternalStatusException();
		log.debug("Starting procedures to setup underlying connectivity");
		//TODO: check if this is needed from configuration
		internalStatus = InternalNsStatus.CREATING_CONNECTIVITY;
		resourceAllocationManager.setupUnderlyingConnectivity(nsInstanceId, operationId, instantiateMessage);
	}
	
	private void confirmUnderlyingConnectivity(String operationId) throws WrongInternalStatusException {
		//if (internalStatus != InternalNsStatus.CREATING_CONNECTIVITY) throw new WrongInternalStatusException();
		if (internalStatus != InternalNsStatus.CONFIGURING_VNFS) throw new WrongInternalStatusException();
		internalStatus = InternalNsStatus.ALLOCATED;
		try {
			nsDbWrapper.setNsInfoInstantiationState(nsInstanceId, InstantiationState.INSTANTIATED);
			log.debug("NS service " + nsInstanceId + " successfully instantiated. DB updated");
		} catch (Exception e) {
			log.error("Impossible to update NS info instantiation status");
		}
		try {
			nsDbWrapper.updateInternalOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, null);
		} catch (Exception e) {
			log.error("Impossible to update internal operation status");
		}
	}
	
	private void confirmComputedResourceRelease(String operationId) throws WrongInternalStatusException {
		if (internalStatus != InternalNsStatus.RELEASING_COMPUTED_RESOURCES) throw new WrongInternalStatusException();
		internalStatus = InternalNsStatus.TERMINATED;
		try {
			nsDbWrapper.setNsInfoInstantiationState(nsInstanceId, InstantiationState.NOT_INSTANTIATED);
			log.debug("NS service " + nsInstanceId + " successfully terminated. DB updated");
			nsDbWrapper.updateInternalOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, null);
		} catch (Exception e) {
			log.error("Impossible to update internal operation status");
		}
	}
	
	
}
