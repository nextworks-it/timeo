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
package it.nextworks.nfvmano.timeo.vnfm.sdkimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

import it.nextworks.nfvmano.libs.common.elements.ExtVirtualLinkData;
import it.nextworks.nfvmano.libs.common.elements.KeyValuePair;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.elements.VirtualCpuData;
import it.nextworks.nfvmano.libs.common.elements.VirtualMemoryData;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.LcmEventType;
import it.nextworks.nfvmano.libs.common.enums.NetworkResourceType;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.OperationalState;
import it.nextworks.nfvmano.libs.common.enums.OperativeState;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.enums.VnfLcmOperation;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.common.elements.AddressData;
import it.nextworks.nfvmano.libs.descriptors.common.elements.LifeCycleManagementScript;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualComputeDesc;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualStorageDesc;
import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduCpd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VduLevel;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfDf;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfExtCpd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements.ResourceDefinition;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.messages.GrantVnfLifecycleOperationRequest;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.messages.GrantVnfLifecycleOperationResponse;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.InstantiateVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ModifyVnfInformationRequest;
import it.nextworks.nfvmano.libs.records.vnfinfo.ExtVirtualLinkInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.InstantiatedVnfInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfExtCpInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfcResourceInfo;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.elements.VnfConfiguration;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.IndicatorValueChangeNotification;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualCompute;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualNetworkInterfaceData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPortData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vstorage.VirtualStorageData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.CreateComputeFlavourRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.QueryNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkResponse;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.ro.AsynchronousVimNotificationInterface;
import it.nextworks.nfvmano.timeo.ro.VimResourcePollingManager;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriversManager;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.OrVnfmNfvoAccess;
import it.nextworks.nfvmano.timeo.vnfm.VeVnfmVnfmAccess;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.ConfigureVnfAckMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.ConfigureVnfRequestMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.InstantiateVimComputeResourceAckMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.InstantiateVimNetworkResourceAckMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.InstantiateVnfRequestMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.TerminateVimComputeResourceAckMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.VnfmMessage;
import it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages.VnfmMessageType;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.RestVnfDriver;
import it.nextworks.nfvmano.timeo.vnfm.vnfdriver.VnfDriver;

public class VnfLifecycleManager extends VeVnfmVnfmAccess implements AsynchronousVimNotificationInterface {
	
	private static final Logger log = LoggerFactory.getLogger(VnfLifecycleManager.class);

	private String vnfInstanceId;
	private VnfInternalStatus internalStatus;
	private String currentOperation;
	private Vnfd vnfd;
	private RabbitTemplate rabbitTemplate;
	private TopicExchange messageExchange;
	private VnfDbWrapper vnfDbWrapper;
	private InstantiateVnfRequest instantiateMessage;
	private OrVnfmNfvoAccess orVnfmNfvoAccess;
	private VimResourcePollingManager vimResourcePollingManager;
	private GrantVnfLifecycleOperationResponse instantiateGrant;
	private SbDriversManager sbDriversManager;
	private VimPlugin vimPlugin;
	private RestTemplate restTemplate;
	private TaskExecutor taskExecutor;
	
	private VnfDriver vnfDriver;
	
	//TODO: this is to be fixed - it could be related to NS? to be passed as parameter in VNF request?
	private static final String domainName = "vEPC.net";
	
	public VnfLifecycleManager(String vnfInstanceId,
			Vnfd vnfd,
			RabbitTemplate rabbitTemplate,
			TopicExchange messageExchange,
			VnfDbWrapper vnfDbWrapper,
			VimResourcePollingManager vimResourcePollingManager,
			SbDriversManager sbDriversManager,
			RestTemplate restTemplate,
			TaskExecutor taskExecutor) {
		this.vnfInstanceId = vnfInstanceId;
		this.vnfd = vnfd;
		this.taskExecutor = taskExecutor;
		this.rabbitTemplate = rabbitTemplate;
		this.restTemplate = restTemplate;
		this.messageExchange = messageExchange;
		this.vnfDbWrapper = vnfDbWrapper;
		this.internalStatus = VnfInternalStatus.INIT;
		this.vimResourcePollingManager = vimResourcePollingManager;
		this.sbDriversManager = sbDriversManager;
	}
	
	
	
	/**
	 * @param orVnfmNfvoAccess the orVnfmNfvoAccess to set
	 */
	public void setOrVnfmNfvoAccess(OrVnfmNfvoAccess orVnfmNfvoAccess) {
		this.orVnfmNfvoAccess = orVnfmNfvoAccess;
		log.debug("Registered NFVO access point");
	}



	/**
	 * Method used to receive messages from the Rabbit MQ
	 * 
	 * @param message received message
	 */
	public void receiveMessage(String message) {
		log.debug("Received message for VNF instance " + vnfInstanceId + "\n" + message);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			VnfmMessage vnfmMsg = (VnfmMessage) mapper.readValue(message, VnfmMessage.class);
			VnfmMessageType type = vnfmMsg.getType();
			String operationId = vnfmMsg.getOperationId();
			
			switch (type) {
			case ALLOCATE_VNF: {
				log.debug("Received instantiate VNF message with operation ID " + operationId);
				log.trace("START CREATE VNF " + operationId);
				if (!(internalStatus.equals(VnfInternalStatus.INIT))) {
					signalError(operationId, "Received instantiate VNF message in wrong status.");
					return;
				}
				InstantiateVnfRequestMessage instantiateMsg = (InstantiateVnfRequestMessage)vnfmMsg;
				//TODO: message to be moved in DB for persistency issues
				this.instantiateMessage = instantiateMsg.getRequest();
				this.currentOperation = operationId;
				instantiateVnf();
				break;
			}
			
			case CONFIGURE_VNF: {
				log.debug("Received configure VNF message with operation ID " + operationId);
				log.trace("START CONFIGURE VNF " + operationId);
				//TODO: j.brenes verify the second condition. Added for the scaling procedure. 
				if (!(internalStatus.equals(VnfInternalStatus.ALLOCATED)||internalStatus.equals(VnfInternalStatus.CONFIGURED))) {
					signalError(operationId, "Received configure VNF message in wrong status.");
					return;
				}
				ConfigureVnfRequestMessage configureMsg = (ConfigureVnfRequestMessage)vnfmMsg;
				this.currentOperation = operationId;
				configureVnf(configureMsg.getRequest());
				break;
			}
			
			case TERMINATE_VNF: {
				log.debug("Received terminate VNF message with operation ID " + operationId);
				if (!((internalStatus.equals(VnfInternalStatus.CONFIGURED)) || (internalStatus.equals(VnfInternalStatus.ALLOCATED)))) {
					signalError(operationId, "Received terminated VNF message in wrong status.");
					return;
				}
				this.currentOperation = operationId;
				terminateVnf();
				break;
			}
			
			case INSTANTIATE_VIM_NETWORK_RESOURCE_ACK: {
				log.debug("Received VIM network resource ACK message");
				if (!(internalStatus.equals(VnfInternalStatus.ALLOCATING_EXTERNAL_CPS))) {
					signalError(operationId, "Received VIM network resource ACK in wrong status.");
					return;
				}
				InstantiateVimNetworkResourceAckMessage networkAck = (InstantiateVimNetworkResourceAckMessage)vnfmMsg;
				processVimNetResourceAck(networkAck.getNotification());
				break;
			}
			
			case INSTANTIATE_VIM_COMPUTING_RESOURCE_ACK: {
				log.debug("Received VIM computing resource ACK message");
				if (!(internalStatus.equals(VnfInternalStatus.ALLOCATING_VNFCS))) {
					signalError(operationId, "Received VIM computing resource ACK in wrong status.");
					return;
				}
				InstantiateVimComputeResourceAckMessage computeAck = (InstantiateVimComputeResourceAckMessage)vnfmMsg;
				VirtualCompute vm = computeAck.getNotification().getComputeData();
				if (vm == null) {
					log.error("Received VIM ACK without VM info in " + internalStatus.toString() + " status. Discarding message.");
					return;
				}
				VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vm.getMetadata());
				processVimComputeResourceAck(vm.getComputeId(), status, vm);
				log.trace("END CREATE VNF " + operationId);
				break;
			}
			
			case CONFIGURE_VNF_ACK: {
				log.debug("Received VNF configuration ACK message");
				if (!(internalStatus.equals(VnfInternalStatus.CONFIGURING_VNF))) {
					signalError(operationId, "Received VNF configuration ACK in wrong status.");
					return;
				}
				ConfigureVnfAckMessage configAck = (ConfigureVnfAckMessage)vnfmMsg;
				processVnfConfigurationAck(configAck.getResult());
				log.trace("END CONFIGURE VNF " + configAck.getOperationId());
				break;
			}
			
			case TERMINATE_VIM_COMPUTING_RESOURCE_ACK: {
				log.debug("Received VIM computing resource termination ACK message");
				if (!(internalStatus.equals(VnfInternalStatus.TERMINATING_VNFCS))) {
					signalError(operationId, "Received VIM computing resource termination ACK in wrong status.");
					return;
				}
				TerminateVimComputeResourceAckMessage terminateAck = (TerminateVimComputeResourceAckMessage)vnfmMsg;
				
				List<String> computeId = terminateAck.getNotification().getComputeId();
				VirtualCompute vm = new VirtualCompute(computeId.get(0), null, null, new ArrayList<>(), null, null, new ArrayList<>(), new ArrayList<>(), null, null, null, OperationalState.DISABLED, new HashMap<>());
				VimResourceStatus status = VimResourceStatus.TERMINATED;
				processVimComputeResourceAck(computeId.get(0), status, vm);
				break;
			}
			
			default:
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
	
	private void terminateVnf() {
		log.debug("Starting procedure to terminate VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.TERMINATING_VNFCS;
		
		try {
			InstantiatedVnfInfo instantiatedInfo = vnfDbWrapper.getInstantiatedVnfInfo(vnfInstanceId);
			List<VnfcResourceInfo> vnfcs = instantiatedInfo.getVnfcResourceInfo();
			if (vnfcs.isEmpty()) {
				log.debug("No VNFCs found in VNF " + vnfInstanceId + ". Starting to remove external connection points");
				removeExternalConnectionsPoints();
			} else {
				removeVnfcs(vnfcs);
			}
		} catch (Exception e) {
			signalError(currentOperation, e.getMessage());
		}
		
	}
	
	private void instantiateVnf() {
		log.debug("Starting procedure to allocate VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.ALLOCATING_EXTERNAL_CPS;
		
		try {
			validateRequest(instantiateMessage);
			log.debug("Valid request");
		} catch (Exception e) {
			signalError(currentOperation, e.getMessage());
		}
		
		//Stores in DB the configuration parameters provided by the user
		Map<String,String> configurationParameters = instantiateMessage.getAdditionalParam();
		if (configurationParameters != null) {
			for (Map.Entry<String, String> param : configurationParameters.entrySet()) {
				try {
					vnfDbWrapper.addGenericConfigParameterToVnfInfo(vnfInstanceId, param.getKey(), param.getValue());
				} catch (Exception e) {
					signalError(currentOperation, e.getMessage());
				}
			}
		}
		
		try {
			//read VDUs
			Map<String, Integer> vduIds = readVdusFromInstantiationRequest(instantiateMessage);
			
			//get GRANT
			String flavourId = instantiateMessage.getFlavourId();
			String instantiationLevelId = instantiateMessage.getInstantiationLevelId();
			GrantVnfLifecycleOperationResponse grant = getInstantiateVnfGrant(flavourId, instantiationLevelId, vduIds, currentOperation);
			log.debug("Got grant from NFVO");
			if (grant.getVim().size() != 1) {
				signalError(currentOperation, "Zero or more than one VIM info returned in grant. Not supported.");
				return;
			}
			instantiateGrant = grant;
			String vimId = grant.getVim().get(0).getVimId();
			log.debug("Read data from grant.");
			vimPlugin = sbDriversManager.getVimPlugin(vimId);
			log.debug("Found VIM plugin.");
			
			//store entry in DB
			vnfDbWrapper.createInstantiatedVnfInfo(vnfInstanceId, 
					flavourId,
					vnfd.getVnfDf(flavourId).getInstantiationLevel(instantiationLevelId).getScaleInfo(),
					vnfd.getVnfDf(flavourId).getMonitoringParameter(), 
					instantiateMessage.getLocalizationLanguage(), 
					grant.getVim(), 
					readExtVirtualLinks(instantiateMessage.getExtVirtualLink()));
			log.debug("Stored instantiated VNF info for VNF " + vnfInstanceId);
			
			//start creation of resources on VIM
			if (vnfd.getVnfExtCpd().size()>0) {
				log.debug("External connection points found in the VNFD. Starting to instantiate them.");
				instantiateExternalConnectionPoints();
			} else {
				log.debug("No external connection points found in the VNFD. Start immediately with VDU creation.");
				instantiateVdus();
			}
			
		} catch (Exception e) {
			signalError(currentOperation, e.getMessage());
		} 
	}
	
	private void configureVnf(ModifyVnfInformationRequest request) {
		log.debug("Starting procedure to configure VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.CONFIGURING_VNF;
		try {
			Map<String, String> configParameters = request.getNewValues();
			Set<KeyValuePair> vnfSpecificData = new HashSet<>();
			for (Map.Entry<String, String> p : configParameters.entrySet()) {
				vnfSpecificData.add(new KeyValuePair(p.getKey(), p.getValue()));
				vnfDbWrapper.addGenericConfigParameterToVnfInfo(vnfInstanceId, p.getKey(), p.getValue());
			}
			VnfConfiguration vnfConfigurationData = new VnfConfiguration(null, null, vnfSpecificData);
			SetConfigurationRequest configRequest = new SetConfigurationRequest(vnfInstanceId, vnfConfigurationData, null);
			log.debug("Configuration request sent to VNF.");
			vnfDriver.setConfiguration(configRequest, this);
		} catch (Exception e) {
			e.printStackTrace();
			signalError(currentOperation, e.getMessage());
		} 
	}
	
	private void processVimNetResourceAck(AllocateNetworkResponse vimResponse) {
		log.debug("Processing VIM net resource ACK");
		VirtualNetworkPort port = vimResponse.getNetworkPortData();
		if (port == null) {
			log.error("Received VIM ACK without vPort info in " + internalStatus.toString() + " status. Discarding message.");
			return;
		}
		String portId = port.getResourceId();
		VimResourceStatus status = Utilities.readResourceStatusFromMetadata(port.getMetadata());
		
		
		try {
			switch (status) {
			case FAILED: {
				vnfDbWrapper.setStatusForVnfExtCp(vnfInstanceId, portId, VimResourceStatus.FAILED);
				signalError(currentOperation, "Port " + portId + " is failed at VIM");
				return;
			}

			case INSTANTIATED: {
				log.debug("Port " + portId + " has been successfully created at VIM");
				vnfDbWrapper.setStatusForVnfExtCp(vnfInstanceId, portId, VimResourceStatus.INSTANTIATED);
				
				VnfExtCpInfo extCp = vnfDbWrapper.getVnfExtCpInfoFromResourceId(vnfInstanceId, portId);
				log.debug("External CP info found");
				String extCpId = extCp.getCpdId();
				log.debug("External CP info - External CP ID = " + extCpId);
				VnfExtCpd cpd = vnfd.getExternalConnectionPointFromId(extCpId);
				log.debug("Found external CPD in VNFD.");
				if ( !(cpd.getAddressData().isEmpty()) && (cpd.getAddressData().get(0).isManagement())) {
					log.debug("The instantiated port is for management access to the VNF");
					String floatingIp = port.getMetadata().get("FLOATING_IP_ADDRESS");
					vnfDbWrapper.setManagementIp(vnfInstanceId, floatingIp);
					log.debug("IP to access the VNF: " + floatingIp);
					this.vnfDriver = new RestVnfDriver(vnfInstanceId, floatingIp, restTemplate, taskExecutor);
					log.debug("Created VNF driver");
				}
				
				if (vnfDbWrapper.isAllExtCpInStatus(vnfInstanceId, VimResourceStatus.INSTANTIATED)) {
					log.debug("All the external connection points for VNF " + vnfInstanceId + " have been created.");
					instantiateVdus();
				} else {
					log.debug("Some external connection points for VNF " + vnfInstanceId + " are still to be created. Waiting for other notifications.");
				}
				break;
			}

			default: {
				log.error("Unexpected resource status.");
				break;
			}
			}
		} catch (Exception e) {
			signalError(currentOperation, e.getMessage());
		}
	}
	
	private void processVnfConfigurationAck(OperationStatus operationStatus) {
		log.debug("Processing VNF configuration ACK");
		try {
			switch (operationStatus) {
			case FAILED: {
				log.error("VNF configuration has failed.");
				signalError(currentOperation, "VNF configuration failed for VNF " + vnfInstanceId);
				break;
			}

			case SUCCESSFULLY_DONE: {
				log.debug("VNF configuration has been correctly performed.");
				internalStatus = VnfInternalStatus.CONFIGURED;
				vnfDbWrapper.updateVnfmInternalOperation(currentOperation, OperationStatus.SUCCESSFULLY_DONE, "VNF configured.");
				log.debug("VNF " + vnfInstanceId + " configured.");
				//TODO: at the moment it is not clear where this should be reflected in the VNF info at the DB.
				break;
			}

			default:
				log.warn("Unexpected status in VNF config ACK. Skipping message.");
				break;
			}
		} catch (Exception e) {

		}
	}
	
	private void processVimComputeResourceAck(String vmId, VimResourceStatus status, VirtualCompute vm) {
		log.debug("Processing VIM compute resource ACK");
//		VirtualCompute vm = vimResponse.getComputeData();
//		if (vm == null) {
//			log.error("Received VIM ACK without VM info in " + internalStatus.toString() + " status. Discarding message.");
//			return;
//		}
//		String vmId = vm.getComputeId();
//		VimResourceStatus status = Utilities.readResourceStatusFromMetadata(vm.getMetadata());
//		
		try {
			switch (status) {
			case FAILED: {
				vnfDbWrapper.setStatusForVnfc(vnfInstanceId, vmId, VimResourceStatus.FAILED);
				signalError(currentOperation, "VM " + vmId + " is failed at VIM");
				return;
			}

			case INSTANTIATED: {
				log.debug("VM " + vmId + " has been successfully created at VIM");
				vnfDbWrapper.setStatusForVnfc(vnfInstanceId, vmId, VimResourceStatus.INSTANTIATED);
				vnfDbWrapper.setHostIdForVnfc(vnfInstanceId, vmId, vm.getHostId());
				
				if (vnfDbWrapper.isAllVnfcInStatus(vnfInstanceId, VimResourceStatus.INSTANTIATED)) {
					log.debug("All the VNFCs for VNF " + vnfInstanceId + " have been created.");
					internalStatus = VnfInternalStatus.ALLOCATED;
					vnfDbWrapper.setVnfInfoInstantiationState(vnfInstanceId, InstantiationState.INSTANTIATED);
					vnfDbWrapper.updateVnfmInternalOperation(currentOperation, OperationStatus.SUCCESSFULLY_DONE, "VNF instantiated.");
					vnfDbWrapper.updateInstantiatedVnfInfoStatus(vnfInstanceId, OperativeState.STARTED);
					log.debug("All DB entries have been updated.");
				} else {
					log.debug("Some VNFCs for VNF " + vnfInstanceId + " are still to be created. Waiting for other notifications.");
				}
				break;
			}
			
			case TERMINATED: {
				log.debug("VM " + vmId + " has been successfully terminated at VIM");
				vnfDbWrapper.setStatusForVnfc(vnfInstanceId, vmId, VimResourceStatus.TERMINATED);
				if (vnfDbWrapper.isAllVnfcInStatus(vnfInstanceId, VimResourceStatus.TERMINATED)) {
					log.debug("All the VNFCs for VNF " + vnfInstanceId + " have been terminated.");
					vnfDbWrapper.updateInstantiatedVnfInfoStatus(vnfInstanceId, OperativeState.STOPPED);
					removeExternalConnectionsPoints();
					log.debug("All DB entries have been updated.");
				} else {
					log.debug("Some VNFCs for VNF " + vnfInstanceId + " are still to be created. Waiting for other notifications.");
				}
				break;
			}

			default: {
				log.error("Unexpected resource status.");
				break;
			}
			}
		} catch (Exception e) {
			signalError(currentOperation, e.getMessage());
		}
	}
	
	/**
	 * Returns a map with the list of VDUs to be instantiated for the given request.
	 * Key of the map: VDU ID
	 * Value of the map: number of VDU
	 * 
	 * @param request
	 * @return
	 * @throws NotExistingEntityException
	 */
	private Map<String, Integer> readVdusFromInstantiationRequest(InstantiateVnfRequest request) throws NotExistingEntityException {
		log.debug("Retrieving VDUs to be instantiated.");
		Map<String, Integer> vdus = new HashMap<>();
		String flavourId = request.getFlavourId();
		String instantiationLevelId = request.getInstantiationLevelId();
		VnfDf df = vnfd.getVnfDf(flavourId);
		InstantiationLevel il = df.getInstantiationLevel(instantiationLevelId);
		List<VduLevel> vduLevels = il.getVduLevel();
		for (VduLevel vl : vduLevels) {
			vdus.put(vl.getVduId(), vl.getNumberOfInstances());
		}
		return vdus;
	}
	
	/**
	 * Verifies is the request complies with the limited capabilities of the current VNFM.
	 * Constraints: single VDU, no virtual links
	 * 
	 * @param request
	 * @throws MethodNotImplementedException
	 */
	private void validateRequest(InstantiateVnfRequest request) throws MethodNotImplementedException, NotExistingEntityException {
		log.debug("Validating VNF instantiate request");
		Map<String, Integer> vdus = readVdusFromInstantiationRequest(request);
		if (vdus.size() > 1) throw new MethodNotImplementedException("Instantiation of VNFs with multiple VDUs not supported.");
		for (Map.Entry<String, Integer> e : vdus.entrySet()) {
			int instances = e.getValue();
			if (instances > 1) throw new MethodNotImplementedException("Instantiation of VNFs with multiple instances of the same VDU type not supported.");
		}
		if (vnfd.getVnfDf(request.getFlavourId()).getVirtualLinkProfile().size() > 0) throw new MethodNotImplementedException("Instantiation of VNFs with internal virtual links not supported");
		List<VnfExtCpd> vnfExtCpd = vnfd.getVnfExtCpd();
		for (VnfExtCpd cp : vnfExtCpd) {
			if (cp.getIntVirtualLinkDesc() != null) 
				throw new MethodNotImplementedException("Instantiation of VNFs with external connection points attached to internal virtual links not supported.");
		}
	}
	
	private GrantVnfLifecycleOperationResponse getInstantiateVnfGrant(String flavourId, String instantiationLevelId, Map<String, Integer> vduIds, String operationId) 
			throws FailedOperationException {
		log.debug("Trying to get grant from NFVO for VNF instantiation");
		List<ResourceDefinition> addResource = new ArrayList<>();
		for (Map.Entry<String, Integer> e : vduIds.entrySet()) {
			String vduId = e.getKey();
			int instances = e.getValue();
			for (int i = 0; i<instances; i++) {
				addResource.add(new ResourceDefinition(operationId+vduId+i, VimResourceType.VM, vduId, null, null));
			}
		}
		GrantVnfLifecycleOperationRequest grantRequest = new GrantVnfLifecycleOperationRequest(vnfInstanceId, 
				vnfd.getVnfdId(), 
				flavourId, 
				VnfLcmOperation.INSTATIATE_VNF,
				true,
				operationId, 
				instantiationLevelId, 
				addResource, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null);
		try {
			return orVnfmNfvoAccess.grantVnfLifecycleOperation(grantRequest);
		} catch (Exception e) {
			log.error("Error while getting GRANT from NFVO: " + e.getMessage());
			throw new FailedOperationException("Error while getting GRANT from NFVO: " + e.getMessage());
		}
	}
	
	private List<ExtVirtualLinkInfo> readExtVirtualLinks(List<ExtVirtualLinkData> extVls) {
		log.debug("Translating external VL data into external VL info");
		List<ExtVirtualLinkInfo> vls = new ArrayList<>();
		for (ExtVirtualLinkData extVl : extVls) {
			ExtVirtualLinkInfo vl = new ExtVirtualLinkInfo(null, extVl.getExtVirtualLinkId(), new ResourceHandle(extVl.getVimId(), extVl.getResourceProviderId(), extVl.getResourceId()));
			vls.add(vl);
		}
		return vls;
	}
	
	private void removeExternalConnectionsPoints() throws Exception {
		log.debug("Removing VNF external connection points for VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.TERMINATING_EXTERNAL_CPS;
		InstantiatedVnfInfo instantiatedInfo = vnfDbWrapper.getInstantiatedVnfInfo(vnfInstanceId);
		List<VnfExtCpInfo> extCpInfo = instantiatedInfo.getExtCpInfo();
		if (extCpInfo.isEmpty()) {
			log.debug("No external connection points found in VNF " + vnfInstanceId + ". Nothing to remove.");
		} else {
			for (VnfExtCpInfo cp : extCpInfo) {
				String cpdId = cp.getCpdId();
				String portId = cp.getCpInstanceId();
				log.debug("Terminating port " + portId + " for VNF external connection point " + cpdId);
				Map<String, NetworkResourceType> networkResourceId = new HashMap<>();
				networkResourceId.put(portId, NetworkResourceType.PORT);
				TerminateNetworkRequest request = new TerminateNetworkRequest(networkResourceId);
				try {
					vimPlugin.terminateVirtualisedNetworkResource(request);
				} catch (FailedOperationException e) {
					log.error("Failure at VIM when terminating port " + portId + ". Continuining procedure");
				}
			}
			log.debug("Finished termination of VNF external connection points for VNF " + vnfInstanceId);
		}
		internalStatus = VnfInternalStatus.TERMINATED;
		vnfDbWrapper.setVnfInfoInstantiationState(vnfInstanceId, InstantiationState.NOT_INSTANTIATED);
		vnfDbWrapper.updateVnfmInternalOperation(currentOperation, OperationStatus.SUCCESSFULLY_DONE, "VNF terminated.");
		vnfDbWrapper.updateInstantiatedVnfInfoStatus(vnfInstanceId, OperativeState.STOPPED);
		log.debug("All DB entries have been updated. VNF termination finished");
		return;
	}
	
	
	
	private void instantiateExternalConnectionPoints() throws Exception {
		log.debug("Instantiating VNF external connection points.");
		List<VnfExtCpd> vnfExtCpd = vnfd.getVnfExtCpd();
		log.debug("VNFD with " + vnfExtCpd.size() + " external connection points.");
		for (VnfExtCpd cp : vnfExtCpd) {
			String extCpId = cp.getCpdId();
			String intCpId = cp.getCpdId();
			log.debug("Processing external connection point " + extCpId + " associated to internal connection point " + intCpId);
			ExtVirtualLinkData vl = instantiateMessage.getExtVirtualLinkDataForExtCp(extCpId);
			String vldId = vl.getExtVirtualLinkId();
			String networkId = vl.getResourceId();
			log.debug("Found external virtual link where the external connection point " + extCpId + " is attached to. Vld ID: " + vldId + " - Network ID: " + networkId);
			//create port resource in VIM
			boolean floatingIp = false;
			List<AddressData> addressData = cp.getAddressData();
			if ((addressData != null) && (!(addressData.isEmpty()))) {
				AddressData ad = addressData.get(0);
				if (ad.isFloatingIpActivated()) floatingIp = true;
			}
			String portName = extCpId + vnfInstanceId;
			VirtualNetworkPortData portData = new VirtualNetworkPortData("access", networkId, null, 0, new HashMap<>());
			Map<String,String> metadata = new HashMap<>();
			if (floatingIp) {
				metadata.put("FLOATING_IP", "TRUE");
			}
			AllocateNetworkRequest request = new AllocateNetworkRequest(portName,  		//networkResourceName, 
					null, 																//reservationId, 
					NetworkResourceType.PORT,											//networkResourceType, 
					null, 																//typeNetworkData, 
					portData,															//typeNetworkPortData, 
					null, 																//typeSubnetData, 
					new ArrayList<>(), 													//affinityConstraint, 
					metadata,															//metadata, 
					vimPlugin.getVim().getTenant(),										//resourceGroupId, 
					null);																//locationConstraints
			AllocateNetworkResponse response = vimPlugin.allocateVirtualisedNetworkResource(request); 
			String portId = response.getNetworkPortData().getResourceId();
			log.debug("Sent request to VIM for creation of external connection point " + extCpId + ": port ID is " + portId);
			
			//add entry in db
			vnfDbWrapper.addVnfLinkPort(vnfInstanceId, vldId, extCpId, new ResourceHandle(vimPlugin.getVim().getVimId(), vimPlugin.getVim().getProviderId(), portId));
			vnfDbWrapper.addVnfExtCpInfo(vnfInstanceId, portId, extCpId);
			log.debug("Updated VNFM DB");
			
			//add entry in polling manager
			vimResourcePollingManager.addResource(VimResourceType.PORT, VimResourceStatus.INSTANTIATED, portId, vimPlugin, this);
			log.debug("Added port resource to polling list.");
		}
		log.debug("Finished requests for external connection points creation");
	}
	
	private void removeVnfcs(List<VnfcResourceInfo> vnfcs) throws Exception {
		log.debug("Starting procedure to terminate VNFCs for VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.TERMINATING_VNFCS;
		
		for (VnfcResourceInfo vnfc : vnfcs) {
			String resourceId = vnfc.getComputeResource().getResourceId();
			String vduId = vnfc.getVduId();
			log.debug("Removing VNFC for VDU " + vduId + " - VM ID: " + resourceId);
			List<String> computeId = new ArrayList<>();
			computeId.add(resourceId);
			TerminateComputeRequest request = new TerminateComputeRequest(computeId);
			vimPlugin.terminateVirtualisedComputeResource(request);
			log.debug("Sent request to VIM for deletion of VM " + resourceId);
			//add entry in polling manager
			vimResourcePollingManager.addResource(VimResourceType.VM, VimResourceStatus.TERMINATED, resourceId, vimPlugin, this);
			log.debug("Added VM resource to polling list.");
		}
		log.debug("Finished requests for VNFC termination");
	}
	
	private void instantiateVdus() throws Exception {
		log.debug("Starting procedure to allocate VDUs for VNF " + vnfInstanceId);
		internalStatus = VnfInternalStatus.ALLOCATING_VNFCS;
		
		Map<String, Integer> vduIds = readVdusFromInstantiationRequest(instantiateMessage);
		for (Map.Entry<String, Integer> e : vduIds.entrySet()) {
			String vduId = e.getKey();
			int instances = e.getValue();
			log.debug("Processing VDU " + vduId + ": found " + instances + " instances.");
			//Note! At the moment a single VNFC instance is supported. Otherwise there should be issues with the external CPs.
			AllocateComputeRequest vimRequest = buildAllocateComputeRequest(vduId);
			AllocateComputeResponse response = vimPlugin.allocateVirtualisedComputeResource(vimRequest);
			String vmId = response.getComputeData().getComputeId();
			log.debug("Sent request to VIM for creation of VDU " + vduId + ": VM ID is " + vmId);
			
			//add entry in db
			//The compute name is also used as hostname.
			vnfDbWrapper.addVnfcInfo(vnfInstanceId, vduId, vmId, vimPlugin.getVim().getVimId(), vimPlugin.getVim().getProviderId(), vimRequest.getComputeName());
			vnfDbWrapper.setHostnameInVnfInfoConfigParameters(vnfInstanceId, vnfd.getVnfdId(), vduId, vimRequest.getComputeName());
			log.debug("Updated VNFM DB");
			
			//add entry in polling manager
			vimResourcePollingManager.addResource(VimResourceType.VM, VimResourceStatus.INSTANTIATED, vmId, vimPlugin, this);
			log.debug("Added VM resource to polling list.");
		}
		log.debug("Finished requests for VDUs creation");
	}
	
	private AllocateComputeRequest buildAllocateComputeRequest(String vduId) throws Exception {
		log.debug("Building VIM request to created VM for VDU " + vduId);
		Vdu vdu = vnfd.getVduFromId(vduId);
		
		//The compute name will be also used as hostname in cloud init. 
		//TODO: To be modified with an additional index when multiple VNFCs per VDU will be supported
		String computeName = vdu.getVduName() + vnfInstanceId;
		
		String virtualComputeDescId = vdu.getVirtualComputeDesc();
		VirtualComputeDesc vcd = vnfd.getVirtualComputeDescriptorFromId(virtualComputeDescId);
		
		String reservationId = null;
		
		log.debug("Setting memory.");
		
		VirtualMemoryData virtualMemory = new VirtualMemoryData(vcd.getVirtualMemory().getVirtualMemSize(), 
				vcd.getVirtualMemory().getVirtualMemOversubscriptionPolicy(),
				vcd.getVirtualMemory().isNumaEnabled());
		
		log.debug("Setting vCPU.");
		
		VirtualCpuData virtualCpu = new VirtualCpuData(vcd.getVirtualCpu().getCpuArchitecture(), 
				vcd.getVirtualCpu().getNumVirtualCpu(), 
				vcd.getVirtualCpu().getVirtualCpuClock(),
				vcd.getVirtualCpu().getVirtualCpuOversubscriptionPolicy());
		
		log.debug("Adding storage.");
		
		List<VirtualStorageData> storageAttributes = new ArrayList<>();
		List<String> virtualStorageDescId = vdu.getVirtualStorageDesc();
		for (String vsdId : virtualStorageDescId) {
			VirtualStorageDesc vsd = vnfd.getVirtualStorageDescriptorFromId(vsdId);
			VirtualStorageData storageData = new VirtualStorageData(vsd.getTypeOfStorage(), vsd.getSizeOfStorage());
			storageAttributes.add(storageData);
		}
		
		log.debug("Adding network interfaces.");
		
		List<VirtualNetworkInterfaceData> virtualNetworkInterface = new ArrayList<>();
		List<VduCpd> intCpd = vdu.getIntCpd();
		Map<String, String> ipAddresses = new HashMap<>();
		Map<String, String> gwAddresses = new HashMap<>();
		Map<String, String> floating = new HashMap<>();
		String gatewayIp = null;
		for (VduCpd cp : intCpd) {
			String intCpdId = cp.getCpdId();
			log.debug("Parsing internal CP " + intCpdId);
			//NOTE! Here we assume that EACH internal CP is associated to an external VNF CP. 
			//This is due to the fact we are not supporting internal virtual links within the VNF
			VnfExtCpd extCp = vnfd.getExternalConnectionPointAssociatedToInternalConnectionPoint(intCpdId);
			String extCpId = extCp.getCpdId();
			log.debug("Associated external CP " + extCpId);
			VnfExtCpInfo extCpInfo = vnfDbWrapper.getVnfExtCpInfoFromCpdId(vnfInstanceId, extCpId);
			String portId = extCpInfo.getCpInstanceId();
			QueryNetworkResponse queryResponse = vimPlugin.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.PORT, portId), null));
			VirtualNetworkPort portDescription = queryResponse.getNetworkPortData().get(0);
			Map<String, String> metadata = portDescription.getMetadata();
			String ipAddress = metadata.get("IP_ADDRESS");
			String floatingIp = metadata.get("FLOATING_IP_ADDRESS");
			ipAddresses.put(intCpdId, ipAddress);
			floating.put(extCpId, floatingIp);
			String cpGwIp = readNetworkGateway(portDescription.getNetworkId());
			gwAddresses.put(extCpId, cpGwIp);
			log.debug("Gateway Address: extCpId:"+extCpId+"cpGwIp:"+cpGwIp);
			if (cp.getAddressData().get(0).isManagement()) {
				log.debug("Management CP.");
				gatewayIp = cpGwIp;
			}
			VirtualNetworkInterfaceData vnic = new VirtualNetworkInterfaceData(portDescription.getNetworkId(), 
					portId,						//networkPortId
					null,						//typeVirtualNic
					new ArrayList<>(), 			//typeConfiguration
					null, 						//macAddress
					0,							//bandwidth
					new ArrayList<>(), 			//accelerationCapability
					new HashMap<>());			//metadata
			virtualNetworkInterface.add(vnic);
			log.debug("Added network interface. Port ID: " + portId + " - network ID: " + portDescription.getNetworkId());
		}
		
		log.debug("Adding virtual compute flavour.");
		
		log.debug("Getting LCM scripts for VNF instantiation from VNFD");
		List<LifeCycleManagementScript> scripts = vnfd.getLcmScriptForEvent(LcmEventType.START_VNF_INSTANTIATION);
		if (scripts.size() > 1) {
			log.error("Found multiple scripts for VNF instantiation. Not supported.");
			throw new Exception("Found multiple scripts for VNF instantiation. Not supported.");
		}
		String elaboratedScript = null;
		if (scripts.size() == 1) {
			log.debug("Found script for VNF instantiation.");
			elaboratedScript = CloudInitGenerator.fillInCloudInitScript(scripts.get(0).getScript(), computeName, domainName, ipAddresses, gatewayIp, vnfDbWrapper.getVnfInfo(vnfInstanceId).getVnfConfigurableProperty(), floating, gwAddresses);
		}
		
		VirtualComputeFlavour computeData = new VirtualComputeFlavour(virtualComputeDescId, 
				new ArrayList<>(), 
				virtualMemory, 
				virtualCpu, 
				storageAttributes, 
				virtualNetworkInterface);
		
		log.debug("Computing virtual compute flavour ID.");
		
		String flavourId = vimPlugin.createComputeFlavour(new CreateComputeFlavourRequest(computeData));
		
		log.debug("Adding software image.");
		
		String vcImageId = vdu.getSwImageDesc().getName();
		
		log.debug("Adding metadata to identify the host.");
		
		Map<String, String> metadata = new HashMap<>();
		metadata.put("ZONE_ID", instantiateGrant.getZone().get(0).getZoneId());
		metadata.put("HOST_ID", instantiateGrant.getAdditionalParam().get("HOST_ID"));
		
		if (elaboratedScript != null) {
			log.debug("Adding metadata for cloud init.");
			metadata.put("CLOUD_INIT_SCRIPT", elaboratedScript);
		}
		
		AllocateComputeRequest request = new AllocateComputeRequest(computeName, 
				reservationId, 			//reservationId
				flavourId,			    //flavour ID 
				new ArrayList<>(), 		//affinityConstraint
				new ArrayList<>(), 		//interfaceData
				vcImageId, 				//vcImageId
				metadata, 				//metadata
				null, 					//resourceGroupId
				null,					//locationConstraints
				null);					//userData
		
		log.debug("VIM request created");
		
		return request;
	}
	
	
	private String readNetworkGateway(String networkId) throws Exception {
		log.debug("Retrieving gateway for network " + networkId);
		String subnetId = vimPlugin.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.NETWORK, networkId), null)).getNetworkData().get(0).getSubnet().get(0);
		log.debug("The subnet associated to network " + networkId + " is " + subnetId + ". Retrieving gateway.");
		String gatewayIp = vimPlugin.queryVirtualisedNetworkResource(new GeneralizedQueryRequest(Utilities.buildVimResourceFilter(VimResourceType.SUBNET, subnetId), null)).getSubnetData().get(0).getGatewayIp();
		log.debug("The gateway IP address is " + gatewayIp);
		return gatewayIp;
	}
	
	//******************* Methods to handle asynchronous notifications related to VIM resources **************

	//Network resources
	public void notify(AllocateNetworkResponse notification) {
		log.debug("Received notification about network resource allocation from VIM");
		InstantiateVimNetworkResourceAckMessage ackMessage = new InstantiateVimNetworkResourceAckMessage(vnfInstanceId, currentOperation, notification);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			String topic = "vnflifecycle.notifyAllocationResult." + vnfInstanceId;
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with ACK for network resource allocation");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VIM ack to internal queue");
		}
	}

	public void notify(TerminateNetworkResponse notification) {
		//This is not expected. Network termination is handled in a synchronous manner.
		log.error("NFVO received a terminate network response. Error - message not expected.");
	}

	//Computing resources
	public void notify(AllocateComputeResponse notification) {
		log.debug("Received notification about computing resource allocation from VIM");
		InstantiateVimComputeResourceAckMessage ackMessage = new InstantiateVimComputeResourceAckMessage(vnfInstanceId, currentOperation, notification);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			String topic = "vnflifecycle.notifyAllocationResult." + vnfInstanceId;
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with ACK for compute resource allocation");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VIM ack to internal queue");
		}
	}

	public void notify(TerminateComputeResponse notification) {
		log.debug("Received notification about computing resource termination from VIM");
		TerminateVimComputeResourceAckMessage ackMessage = new TerminateVimComputeResourceAckMessage(vnfInstanceId, currentOperation, notification);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			String topic = "vnflifecycle.notifyTerminationResult." + vnfInstanceId;
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with ACK for compute resource termination");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VIM ack to internal queue");
		} 
	}

	//****************** End of methods to handle asynchronous notifications
	
	//****************** Methods to handle asynchronous notifications from a VNF
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
		log.debug("Received notification about VNF configuration from VNF");
		OperationStatus operationStatus = OperationStatus.SUCCESSFULLY_DONE;
		if (respondeCode != ResponseCode.OK) operationStatus = OperationStatus.FAILED;
		ConfigureVnfAckMessage ackMessage = new ConfigureVnfAckMessage(vnfInstanceId, currentOperation, responseMessage, operationStatus);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			String topic = "vnflifecycle.notifyVnfConfigResult." + vnfInstanceId;
			rabbitTemplate.convertAndSend(messageExchange.getName(), topic, json);
			log.debug("Sent internal message with ACK for VNF configuration");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VNF config ack to internal queue");
		}
	}

	//************************* End of methods to handle asynchronous notifications from a VNF
	
	private void signalError(String operationId, String errorMsg) {
		try {
			log.error(errorMsg);
			vnfDbWrapper.updateVnfmInternalOperation(operationId, OperationStatus.FAILED, "Error while translating internal instantiation message in Json format.");
		} catch (NotExistingEntityException e) {
			log.error("VNFM operation ID not found in DB: impossible to save error.");
		}
	}
	
}
