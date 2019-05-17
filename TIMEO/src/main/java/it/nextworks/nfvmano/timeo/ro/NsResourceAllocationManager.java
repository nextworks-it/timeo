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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.elements.ExtVirtualLinkData;
import it.nextworks.nfvmano.libs.common.elements.ResourceHandle;
import it.nextworks.nfvmano.libs.common.elements.VnfExtCpData;
import it.nextworks.nfvmano.libs.common.enums.InstantiationState;
import it.nextworks.nfvmano.libs.common.enums.IpVersion;
import it.nextworks.nfvmano.libs.common.enums.NetworkResourceType;
import it.nextworks.nfvmano.libs.common.enums.NetworkSegmentType;
import it.nextworks.nfvmano.libs.common.enums.OperationStatus;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.libs.common.enums.StopType;
import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.libs.common.enums.VnfLcmOperation;
import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VimConnectionInfo;
import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualLinkProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsDf;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsLevel;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkConnectivity;
import it.nextworks.nfvmano.libs.descriptors.nsd.NsVirtualLinkDesc;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Sapd;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfProfile;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfToLevelMapping;
import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.OnboardedVnfPkgInfo;
import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfConfigurableProperties;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements.GrantInfo;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements.ResourceDefinition;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.elements.ZoneInfo;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.messages.GrantVnfLifecycleOperationRequest;
import it.nextworks.nfvmano.libs.orvnfm.grant.interfaces.messages.GrantVnfLifecycleOperationResponse;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.CreateVnfIdentifierRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.InstantiateVnfRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.ModifyVnfInformationRequest;
import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.TerminateVnfRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.elements.SapData;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.NsLinkPort;
import it.nextworks.nfvmano.libs.records.nsinfo.NsVirtualLinkInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;
import it.nextworks.nfvmano.libs.records.nsinfo.UserAccessInfo;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesCapacityManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesInformationManagementConsumerInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnet;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.NetworkSubnetData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetwork;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPort;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vnet.VirtualNetworkPortData;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkRequest;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.UpdateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.CapacityChangeNotification;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vresources.InformationChangeNotification;
import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.NsdManagementService;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPath;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathEndPoint;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.NsScaleSchedulingSolution;
import it.nextworks.nfvmano.timeo.rc.elements.PnfAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.ScaleVnfResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.elements.VnfResourceAllocation;
import it.nextworks.nfvmano.timeo.rc.repositories.ResourceComputationDbWrapper;
import it.nextworks.nfvmano.timeo.ro.messages.AllocateNsVlsMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocateVimNetResourceAckMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocateVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessage;
import it.nextworks.nfvmano.timeo.ro.messages.AllocationMessageType;
import it.nextworks.nfvmano.timeo.ro.messages.ConfigureVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.DestroyUnderlyingConnectivityMessage;
import it.nextworks.nfvmano.timeo.ro.messages.ScaleVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.SdnControllerOperationAckMessage;
import it.nextworks.nfvmano.timeo.ro.messages.SetupUnderlyingConnectivityMessage;
import it.nextworks.nfvmano.timeo.ro.messages.TerminateNsVlsMessage;
import it.nextworks.nfvmano.timeo.ro.messages.TerminateVnfMessage;
import it.nextworks.nfvmano.timeo.ro.messages.VnfmOperationAckMessage;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.Classifier;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.VlanClassifier;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.OrVnfmNfvoAccess;
import it.nextworks.nfvmano.timeo.vnfm.Vnfm;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;
import it.nextworks.nfvmano.timeo.vnfm.pnfm.CreatePnfIdentifierRequest;

public class NsResourceAllocationManager extends OrVnfmNfvoAccess 
implements AsynchronousVimNotificationInterface, 
	AsynchronousVnfmNotificationInterface, 
	SdnControllerConsumerInterface, 
	VirtualisedResourcesInformationManagementConsumerInterface,
	VirtualisedResourcesCapacityManagementConsumerInterface {

	private static final Logger log = LoggerFactory.getLogger(NsResourceAllocationManager.class);
	
	private String nsInstanceId;
	
	private RabbitTemplate rabbitTemplate;
	
	private NsDbWrapper nsDbWrapper;
	
	private Queue queue;
	
	private NsManagementEngine nsManagementEngine;
	
	private ResourceComputationDbWrapper resourceComputationDbWrapper;
	
	private String currentOperationId;
	
	private VimPlugin defaultVimPlugin;
	
	private SdnControllerPlugin defaultSdnControllerPlugin;
	
	private ResourceAllocationStatus internalStatus;
	
	private TopicExchange allocationMessageExchange;
	
	private VimResourcePollingManager vimResourcePollingManager;
	
	private VnfmOperationPollingManager vnfmOperationPollingManager;
	
	private InstantiateNsRequest originalRequest;
	
	private ScaleNsRequest lastScaleRequest;
	
	private VnfPackageManagementService vnfPackageManagement;
	
	private NsdManagementService nsdManagement;
	
	private VnfmHandler vnfmHandler;
	
	//Key: VNF Instance ID; Value: VNFM
	private Map<String, Vnfm> vnfmMap = new HashMap<>();
	
	//Key: VNF Instance ID; Value: VNFD
	private Map<String, Vnfd> vnfdMap = new HashMap<>();
	
	//Key: PNF ID; Value: VNFM
	private Map<String, Vnfm> pnfmMap = new HashMap<>();
		
	//Key: PNF ID; Value: PNFD
	private Map<String, Pnfd> pnfdMap = new HashMap<>();
	
	//List of VNFM operation still in pending state
	private List<String> pendingVnfmOperation = new ArrayList<>();
	
	//List of VNF still under configuration at the VNFM
	//private List<String> vnfUnderConfiguration = new ArrayList<>();
	
	//Key: operation ID; value VNF instance ID or PNF Info ID
	private Map<String, String> vnfOperationMap = new HashMap<>();
	
	//List of SDN operations still in pending state
	private List<String> pendingSdnControllerOperations = new ArrayList<>();
	
	//Key: operation ID; value path ID
	private Map<String, String> sdnControllerOperationMap = new HashMap<>();
	
	private List<UserAccessInfo> userAccessInfos = new ArrayList<>();
	
	public NsResourceAllocationManager(String nsInstanceId,
			NsDbWrapper nsDbWrapper,
			VnfPackageManagementService vnfPackageManagement,
			RabbitTemplate rabbitTemplate,
			ResourceComputationDbWrapper resourceComputationDbWrapper,
			NsManagementEngine nsManagementEngine,
			NsdManagementService nsdManagement,
			VimPlugin defaultVimPlugin,
			TopicExchange allocationMessageExchange,
			VimResourcePollingManager vimResourcePollingManager,
			VnfmHandler vnfmHandler,
			VnfmOperationPollingManager vnfmOperationPollingManager,
			SdnControllerPlugin defaultSdnControllerPlugin) {
		this.nsInstanceId = nsInstanceId;
		this.rabbitTemplate = rabbitTemplate;
		this.nsDbWrapper = nsDbWrapper;
		this.resourceComputationDbWrapper = resourceComputationDbWrapper;
		this.nsManagementEngine = nsManagementEngine;
		this.nsdManagement = nsdManagement;
		this.defaultVimPlugin = defaultVimPlugin;
		this.internalStatus = ResourceAllocationStatus.INIT;
		this.allocationMessageExchange = allocationMessageExchange;
		this.vimResourcePollingManager = vimResourcePollingManager;
		this.vnfmHandler = vnfmHandler;
		this.vnfmOperationPollingManager = vnfmOperationPollingManager;
		this.defaultSdnControllerPlugin = defaultSdnControllerPlugin;
		this.vnfPackageManagement = vnfPackageManagement;
	}
	
	public void setQueue(Queue queue) {
		this.queue=queue;
	}

	public void receiveMessage(String message) {
		log.debug("Received message from queue \n" + message);
		try {
			ObjectMapper mapper = new ObjectMapper();
			AllocationMessage allocateMessage = (AllocationMessage) mapper.readValue(message, AllocationMessage.class);
			AllocationMessageType type = allocateMessage.getType();
			
			switch (type) {
			case ALLOCATE_NS_VLS: {
				log.trace("START CREATE VIRTUAL_LINKS ");
				log.debug("Received request for NS virtual link allocation");
				if (internalStatus != ResourceAllocationStatus.INIT) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				AllocateNsVlsMessage allocateVlsMsg = (AllocateNsVlsMessage)allocateMessage;
				String operationId = allocateVlsMsg.getOperationId();
				this.currentOperationId = operationId;
				this.originalRequest = allocateVlsMsg.getRequest();
				allocateNsVlsInternal(operationId, allocateVlsMsg);
				break;
			}
			
			case VIM_ACK_ALLOCATE_VNET_RESOURCE: {
				log.debug("Received VIM ACK for vNET resource allocation");
				if (!((internalStatus == ResourceAllocationStatus.CREATING_VLS_NETS) 
						|| (internalStatus == ResourceAllocationStatus.CREATING_VLS_SAPS)
						|| (internalStatus == ResourceAllocationStatus.CREATING_VLS_SUBNETS))){
					log.error("Wrong status. Discarding message.");
					return;
				}
				AllocateVimNetResourceAckMessage ackMsg = (AllocateVimNetResourceAckMessage)allocateMessage;
				processVimNetResourceAck(ackMsg.getVimResponse());
				break;
			}
			
			case ALLOCATE_VNF: {
				log.debug("Received request for VNF instantiation");
				log.trace("START CREATE VNFS");
				if (!((internalStatus == ResourceAllocationStatus.CREATED_VLS) 
						|| (internalStatus == ResourceAllocationStatus.CREATED_VNF))){
					log.error("Wrong status. Discarding message.");
					return;
				}
				AllocateVnfMessage allocateVnfMsg = (AllocateVnfMessage)allocateMessage;
				this.currentOperationId = allocateVnfMsg.getOperationId();
				this.originalRequest = allocateVnfMsg.getRequest();
				allocateVnfsInternal(allocateVnfMsg);
				allocatePnfInfosInternal(allocateVnfMsg);
				break;
			}
			case SCALE_VNF: {
				log.debug("Received request for VNF scaling");
				log.trace("START SCALE VNFS");
				//TODO: j.brenes verify this
				if (internalStatus != ResourceAllocationStatus.CONFIGURED_VNF){
					log.error("Wrong status. Discarding message.");
					return;
				}
				ScaleVnfMessage scaleVnfMsg = (ScaleVnfMessage)allocateMessage;
				this.currentOperationId = scaleVnfMsg.getOperationId();
				this.lastScaleRequest = scaleVnfMsg.getRequest();
				scaleVnfsInternal(scaleVnfMsg);
				//TODO: implement pnfinfo scaling
				//scalePnfInfosInternal(allocateVnfMsg);
				break;
			}
			
			case CONFIGURE_VNF: {
				log.debug("Received request for VNF configuration");
				if (!(internalStatus == ResourceAllocationStatus.CREATED_NETWORK_CONNECTIONS)) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				ConfigureVnfMessage configureVnfMsg = (ConfigureVnfMessage)allocateMessage;
				this.currentOperationId = configureVnfMsg.getOperationId();
				configureVnfsInternal(configureVnfMsg);
				break;
			}
			
			case VNFM_OPERATION_ACK: {
				log.debug("Received notification about VNF operation");
				if (!((internalStatus == ResourceAllocationStatus.CREATING_VNF) || (internalStatus == ResourceAllocationStatus.TERMINATING_VNF) || 
						(internalStatus == ResourceAllocationStatus.CONFIGURING_VNF))) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				VnfmOperationAckMessage operationAckMsg = (VnfmOperationAckMessage)allocateMessage;
				processVnfmAck(operationAckMsg.getOperationId(), operationAckMsg.getVnfId(), operationAckMsg.getOperationStatus());
				break;
			}
			
			case SETUP_UNDERLYING_CONNECTIVITY: {
				log.debug("Received request to establish underlying connectivity");
				if (internalStatus != ResourceAllocationStatus.CREATED_VNF) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				SetupUnderlyingConnectivityMessage setupNetworkMessage = (SetupUnderlyingConnectivityMessage)allocateMessage;
				this.currentOperationId = setupNetworkMessage.getOperationId();
				this.originalRequest = setupNetworkMessage.getRequest();
				setupUnderlyingNetworkConnectivityInternal(setupNetworkMessage);
				break;
			}
			
			case SDN_CONTROLLER_ACK: {
				log.debug("Received notification about SDN controller operation");
				if (!((internalStatus == ResourceAllocationStatus.CREATING_NETWORK_CONNECTIONS) || (internalStatus == ResourceAllocationStatus.TERMINATING_NETWORK_CONNECTIONS))) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				SdnControllerOperationAckMessage operationAckMsg = (SdnControllerOperationAckMessage)allocateMessage;
				processSdnControllerAck(operationAckMsg.getOperationId(), operationAckMsg.getOperationStatus());
				break;
			}
			
			case REMOVE_NS_VLS: {
				log.debug("Received request to remove the NS virtual links");
				if (internalStatus != ResourceAllocationStatus.TERMINATED_NETWORK_CONNECTIONS) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				TerminateNsVlsMessage terminateNsVlsMessage = (TerminateNsVlsMessage)allocateMessage;
				this.currentOperationId = terminateNsVlsMessage.getOperationId();
				terminateNsVlsInternal();
				break;
			}
			
			case REMOVE_VNF: {
				log.debug("Received request to remove the VNFs");
				if (!((internalStatus == ResourceAllocationStatus.CONFIGURED_VNF) || (internalStatus == ResourceAllocationStatus.FAILED))) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				TerminateVnfMessage terminateVnfMessage = (TerminateVnfMessage)allocateMessage;
				this.currentOperationId = terminateVnfMessage.getOperationId();
				terminateVnfsInternal();
				terminatePnfsInternal();
				break;
			}
			
			case REMOVE_UNDERLYING_CONNECTIVITY: {
				log.debug("Received request to destroy underlying connectivity.");
				if (internalStatus != ResourceAllocationStatus.TERMINATED_VNF) {
					log.error("Wrong status. Discarding message.");
					return;
				}
				DestroyUnderlyingConnectivityMessage destroyMessage = (DestroyUnderlyingConnectivityMessage)allocateMessage;
				this.currentOperationId = destroyMessage.getOperationId();
				destroyUnderlyingNetworkConnectivityInternal();
				break;
			}
			
			default: {
				manageError("Received message with not supported type", type);
				break;
			}
			}
		} catch(JsonParseException e) {
			log.error("Error while parsing message: " + e.getMessage());
		} catch(JsonMappingException e) {
			log.error("Error in Json mapping: " + e.getMessage());
		} catch(IOException e) {
			log.error("IO error when receiving json message: " + e.getMessage());
		} 
	}
	
	//*********************************** Notification methods **************************

	public void notify(AllocateNetworkResponse response) {
		log.debug("Received notification about network resource allocation from VIM");
		AllocateVimNetResourceAckMessage ackMessage = new AllocateVimNetResourceAckMessage(response);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
			log.debug("Sent internal message with ACK for network resource allocation");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VIM ack to internal queue");
		}
	}
	
	public void notify(TerminateNetworkResponse response) {
		log.error("NFVO received a terminate network response. Error - message not expected.");
	}
	
	public void notify(UpdateNetworkResponse response) {
		log.error("NFVO received an update network response. Error - message not expected.");
	}
	
	public void notify(AllocateComputeResponse notification) {
		log.error("NFVO received an allocate compute response. Error - VMs are managed through the VNFM");
	}
	
	public void notify(TerminateComputeResponse notification) {
		log.error("NFVO received a terminate compute response. Error - VMs are managed through the VNFM");
	}
	
	@Override
	public void notifyVnfmOperationResult(String operationId, String vnfId, OperationStatus operationStatus) {
		log.debug("Received notification about VNF operation");
		VnfmOperationAckMessage ackMessage = new VnfmOperationAckMessage(operationId, vnfId, operationStatus);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
			log.debug("Sent internal message with ACK for VNFM operation");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post VNFM operation ACK to internal queue");
		}
	}
	
	@Override
	public void notifySdnControllerOperationResult(String operationId, ResponseCode responseCode, String errorMessage) {
		log.debug("Received notification about SDN operation");
		OperationStatus operationStatus;
		if (responseCode == ResponseCode.OK) {
			operationStatus = OperationStatus.SUCCESSFULLY_DONE;
		} else {
			operationStatus = OperationStatus.FAILED;
			log.error("SDN controller operation failed with error message " + errorMessage);
		}
		SdnControllerOperationAckMessage ackMessage = new SdnControllerOperationAckMessage(operationId, operationStatus);
		ObjectMapper mapper = Utilities.buildObjectMapper();
		try {
			String json = mapper.writeValueAsString(ackMessage);
			rabbitTemplate.convertAndSend(allocationMessageExchange.getName(), "resourceAllocate." + nsInstanceId, json);
			log.debug("Sent internal message with ACK for SDN controller operation");
		} catch (JsonProcessingException e) {
			log.error("Impossible to post SDN controller operation ACK to internal queue");
		}
	}
	
	
	//******************************************* FSM methods ******************************************************************
	
	private void terminateSubnetsInternal() {
		log.debug("Starting termination of subnets for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.TERMINATING_VLS_SUBNETS;
		try {
			List<NsVirtualLinkInfo> virtualLinks = nsDbWrapper.getNsVirtualLinkInfos(nsInstanceId);
			if (virtualLinks.isEmpty()) {
				log.debug("No NS virtual links have been found. Sending notification to the management engine.");
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.REMOVE_NS_VLS, true);
			}
			VimPlugin vimPlugin = getVimForNsVirtualLinks();
			for (NsVirtualLinkInfo virtualLink : virtualLinks) {
				String nsVldId = virtualLink.getNsVirtualLinkDescId();
				String networkId = virtualLink.getResourceId();
				String subnetId = virtualLink.getSubnetId();
				log.debug("Removing resources for NS Virtual Link " + nsVldId + ". \n Subnet ID: " + subnetId + " \n Network ID: " + networkId);
				Map<String, NetworkResourceType> subnetResourceId = new HashMap<>();
				subnetResourceId.put(subnetId, NetworkResourceType.SUBNET);
				TerminateNetworkRequest subnetRequest = new TerminateNetworkRequest(subnetResourceId);
				vimPlugin.terminateVirtualisedNetworkResource(subnetRequest);
				log.debug("Subnet " + subnetId + " terminated on VIM");
				Map<String, NetworkResourceType> networkResourceId = new HashMap<>();
				networkResourceId.put(networkId, NetworkResourceType.NETWORK);
				TerminateNetworkRequest networkRequest = new TerminateNetworkRequest(networkResourceId);
				vimPlugin.terminateVirtualisedNetworkResource(networkRequest);
				log.debug("Network " + networkId + " terminated on VIM");
				nsDbWrapper.deleteNsVirtualLinkInfo(nsInstanceId, nsVldId);
				log.debug("NS virtual link " + nsVldId + " removed from DB");
			}
			log.debug("All NS virtual links have been removed from VIM. Sending notification to the management engine.");
			internalStatus = ResourceAllocationStatus.TERMINATED_NETS;
			nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.REMOVE_NS_VLS, true);
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.REMOVE_NS_VLS);
		} catch (FailedOperationException | MethodNotImplementedException | MalformattedElementException e) {
			manageError("Unable to remove ports for SAPs on the VIM: " + e.getMessage(), AllocationMessageType.REMOVE_NS_VLS);
		}
	}
	
	private void terminateNsVlsInternal() {
		log.debug("Starting termination of NS Virtual links for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.TERMINATING_VLS_SAPS;
		try {
			List<NsLinkPort> saps = nsDbWrapper.getNsLinkPort(nsInstanceId);
			if (saps.isEmpty()) {
				log.debug("No SAPs have been found. Removing subnets.");
				terminateSubnetsInternal();
				return;
			}
			VimPlugin vimPlugin = getVimForNsVirtualLinks();
			for (NsLinkPort sap : saps) {
				String portId = sap.getResourceId();
				String sapdId = sap.getCpId();
				log.debug("Removing port " + portId + " for SAP " + sapdId);
				Map<String, NetworkResourceType> networkResourceId = new HashMap<>();
				networkResourceId.put(portId, NetworkResourceType.PORT);
				TerminateNetworkRequest request = new TerminateNetworkRequest(networkResourceId);
				vimPlugin.terminateVirtualisedNetworkResource(request);
				log.debug("Port " + portId + " terminated on VIM");
				nsDbWrapper.removeNsLinkPort(nsInstanceId, portId);
				log.debug("Port " + portId + " removed from DB");
			}
			log.debug("All NS link ports have been removed from VIM");
			terminateSubnetsInternal();
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.REMOVE_NS_VLS);
		} catch (FailedOperationException | MethodNotImplementedException | MalformattedElementException e) {
			manageError("Unable to remove ports for SAPs on the VIM: " + e.getMessage(), AllocationMessageType.REMOVE_NS_VLS);
		}
	}
	
	private void allocateNsVlsInternal(String operationId, AllocateNsVlsMessage allocateVlsMsg) {
		log.debug("Starting allocation of NS Virtual Links for NS instance " + nsInstanceId);
		//TODO: check status
		try {
			Nsd nsd = nsManagementEngine.retrieveNsd(nsInstanceId);
			this.userAccessInfos = nsd.getUserAccessInfo(allocateVlsMsg.getRequest().getFlavourId(), allocateVlsMsg.getRequest().getNsInstantiationLevelId());
			//TODO: at the moment it ignores bandwidth requirements and affinity constraints
			List<NsVirtualLinkDesc> virtualLinkDesc = nsd.getVirtualLinkDesc();
			for (NsVirtualLinkDesc nsVld : virtualLinkDesc) {
				String vldId = nsVld.getVirtualLinkDescId();
				log.debug("Creating NS virtual link " + vldId);
				VimPlugin vimPlugin = getVimForNsVirtualLinks();
				String vNetName = vldId + nsInstanceId;
				VirtualNetworkData vNetData = new VirtualNetworkData(0,				//bandwidth 
						NetworkSegmentType.NONE,											//networkType 
						null,														//segmentType
						new ArrayList<>(),											//networkQoS 
						false,														//isShared
						new ArrayList<>(), 											//sharingCriteria 
						null,														//layer3Attributes 
						new HashMap<>());											//metadata
				AllocateNetworkRequest request = new AllocateNetworkRequest(vNetName,		//networkResourceName 
						null,																//reservationId 
						NetworkResourceType.NETWORK,										//networkResourceType 
						vNetData, 															//typeNetworkData 
						null, 																//typeNetworkPortData 
						null,																//typeSubnetData
						new ArrayList<>(), 													//affinityConstraint, 
						new HashMap<>(),													//metadata, 
						vimPlugin.getVim().getTenant(),										//resourceGroupId, 
						null);																//locationConstraints
				
				try {
					AllocateNetworkResponse response = vimPlugin.allocateVirtualisedNetworkResource(request); 
					String vNetId = response.getNetworkData().getNetworkResourceId();
					String segmentId = response.getNetworkData().getSegmentType();
					log.debug("Created virtual network " + vNetId + " for VLD " + vldId);
					nsDbWrapper.createNsVirtualLinkInfo(nsInstanceId, vldId, 
							new ResourceHandle(vimPlugin.getVim().getVimId(), vimPlugin.getVim().getProviderId(), vNetId), Integer.parseInt(segmentId));
					log.debug("Updated internal DB");
					vimResourcePollingManager.addResource(VimResourceType.NETWORK, VimResourceStatus.INSTANTIATED, vNetId, vimPlugin, this);
					log.debug("Added VIM resource to polling list.");
				} catch (FailedOperationException e) {
					manageError("Unable to create NS VL " + vldId + ": " + e, AllocationMessageType.ALLOCATE_NS_VLS);
					rollback();
					return;
				} catch (MethodNotImplementedException e) {
					manageError("Unable to create NS VL " + vldId + ": method not implemented.", AllocationMessageType.ALLOCATE_NS_VLS);
					rollback();
					return;
				}
			}
			log.debug("All requests for creating NS VLs have been sent to the VIM.");
			this.internalStatus = ResourceAllocationStatus.CREATING_VLS_NETS;
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		} catch (AlreadyExistingEntityException e) {
			manageError("Error when updating DB: " + e.getMessage(), AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		} catch (Exception e) {
			manageError("General exception: " + e.getMessage(), AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		}
	}
	
	private void createSubnetsInternal() {
		log.debug("Starting allocation of subnets for NS Virtual Links of NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.CREATING_VLS_SUBNETS;
		
		try {
			List<NsVirtualLinkInfo> vls = nsDbWrapper.getNsVirtualLinkInfos(nsInstanceId);
			for (NsVirtualLinkInfo vl : vls) {
				String networkResourceId = vl.getResourceId();
				String vldId = vl.getNsVirtualLinkDescId();
				log.debug("Creating subnet for network " + networkResourceId + " associated to VL " + vldId);
				VimPlugin vimPlugin = getVimForNsVirtualLinks();
				String subnetName = "subnet-" + vldId + nsInstanceId;
				//TODO: check in case of SAP Data with explicit IP addresses
				NetworkSubnetData typeSubnetData = new NetworkSubnetData(networkResourceId, IpVersion.IPv4, null, null, true, new ArrayList<String>(), new HashMap<>());
				AllocateNetworkRequest request = new AllocateNetworkRequest(subnetName,  	//networkResourceName, 
						null, 																//reservationId, 
						NetworkResourceType.SUBNET,											//networkResourceType, 
						null, 																//typeNetworkData, 
						null, 																//typeNetworkPortData, 
						typeSubnetData, 													//typeSubnetData, 
						new ArrayList<>(), 													//affinityConstraint,
						new HashMap<>(),													//metadata, 
						vimPlugin.getVim().getTenant(),										//resourceGroupId, 
						null);																//locationConstraints
				
				try {
					AllocateNetworkResponse response = vimPlugin.allocateVirtualisedNetworkResource(request); 
					String subnetId = response.getSubnetData().getResourceId();
					log.debug("Created subnet " + subnetId + " for VLD " + vldId);
					nsDbWrapper.setNsVirtualLinkSubnet(networkResourceId, subnetId);
					log.debug("Updated internal DB");
					vimResourcePollingManager.addResource(VimResourceType.SUBNET, VimResourceStatus.INSTANTIATED, subnetId, vimPlugin, this);
					log.debug("Added VIM resource to polling list.");
				} catch (FailedOperationException e) {
					manageError("Unable to create subnet associated to network resource ID " + networkResourceId + ": " + e, AllocationMessageType.ALLOCATE_NS_VLS);
					rollback();
					return;
				} catch (MethodNotImplementedException e) {
					manageError("Unable to create subnet associated to network resource ID " + networkResourceId + ": method not implemented.", AllocationMessageType.ALLOCATE_NS_VLS);
					rollback();
					return;
				}
			}
		} catch (NotExistingEntityException e) {
			log.error("Error while searching VLs in internal DB: " + e.getMessage());
		} catch (MalformattedElementException e) {
			log.error("Error while allocating a subnet resource: " + e.getMessage());
		}
	}
	
	private void createSapsInternal() {
		//SAPs are created as ports connected to a router when they are associated to a NS virtual link. 
		//If associated to a VNF external connection point, they need to be created in the context of the VNF.
		
		log.debug("Starting allocation of SAPs for NS instance " + nsInstanceId);
		boolean sapFound = false;
		internalStatus = ResourceAllocationStatus.CREATING_VLS_SAPS;
		VimPlugin vimPlugin = getVimForNsVirtualLinks();
		try {
			Nsd nsd = nsManagementEngine.retrieveNsd(nsInstanceId);
			List<SapData> sapData = originalRequest.getSapData();
			for (SapData sap : sapData) {
				String sapdId = sap.getSapdId();
				Sapd sapd = nsd.getSapFromSapId(sapdId);
				String vldId = sapd.getNsVirtualLinkDescId();
				if (vldId != null) {
					log.debug("Found SAP " + sapdId + " associated to NS virtual link " + vldId + ". Creating port.");
					String sapName = sap.getSapName();
					String address = sap.getAddress();
					if (address != null) {
						log.error("Explicit SAP addresses not yet managed. Ignoring.");
					}
					if (sapd.isSapAddressAssignment()) {
						log.error("SAP address assignment from NFVO not yet managed. Ignoring.");
					}
					NsVirtualLinkInfo vLinkInfo = nsDbWrapper.getNsVirtualLinkInfo(nsInstanceId, vldId);
					String networkId = vLinkInfo.getResourceId();
					String portName = sapName + nsInstanceId;
					VirtualNetworkPortData portData = new VirtualNetworkPortData("access", networkId, null, 0, new HashMap<>());
					Map<String,String> metadata = new HashMap<>();
					metadata.put("ROUTER_ID", vimPlugin.getVim().getDefaultExternalRouterId());
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
					
					try {
						AllocateNetworkResponse response = vimPlugin.allocateVirtualisedNetworkResource(request); 
						String portId = response.getNetworkPortData().getResourceId();
						log.debug("Created port " + portId + " for SAP " + sapName);
						nsDbWrapper.createNsLinkPort(nsInstanceId, vldId, sapdId, 
								new ResourceHandle(vimPlugin.getVim().getVimId(), vimPlugin.getVim().getProviderId(), portId), true, portName);
						log.debug("Updated internal DB");
						vimResourcePollingManager.addResource(VimResourceType.PORT, VimResourceStatus.INSTANTIATED, portId, vimPlugin, this);
						log.debug("Added VIM resource to polling list.");
						sapFound = true;
					} catch (FailedOperationException e) {
						manageError("Unable to create port associated to network resource ID " + networkId + ": " + e, AllocationMessageType.ALLOCATE_NS_VLS);
						rollback();
						return;
					} catch (MethodNotImplementedException e) {
						manageError("Unable to create port associated to network resource ID " + networkId + ": method not implemented.", AllocationMessageType.ALLOCATE_NS_VLS);
						rollback();
						return;
					} catch (AlreadyExistingEntityException e) {
						log.error("Error while adding resource in DB");
					} catch (MalformattedElementException e) {
						log.error("Malformatter request");
						rollback();
						return;
					}
					
				} else {
					log.debug("Found SAP " + sapdId + " associated to connection point. The port will be created when the associated VNF is created.");
				}
			}
			if (!sapFound) {
				log.debug("No SAPs associated to NS VLs found in the instantiate request. Nothing else to do for NS VLs allocation. Notifying lifecycle manager.");
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.ALLOCATE_NS_VLS, true);
			}
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		}
	}
	
	private void destroyUnderlyingNetworkConnectivityInternal() {
		log.debug("Starting tear down of underlying network connectivity");
		internalStatus = ResourceAllocationStatus.TERMINATING_NETWORK_CONNECTIONS;
		try {
			NsResourceSchedulingSolution schedulingSolution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsInstanceId);
			if (!(schedulingSolution.isSolutionFound())) manageError("Solution not found for the given NS instance ID. No paths are removed.", AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY);
			
			List<NetworkPath> networkPaths = schedulingSolution.getNetworkPaths();
			log.debug("Found " + networkPaths.size() + " network paths to be removed.");
			for (NetworkPath np : networkPaths) {
				String npId = np.getNetworkPathId();
				log.debug("Processing network path " + npId);
				List<String> networkPathIds = new ArrayList<>();
				networkPathIds.add(npId);
				String sdnOperationId = defaultSdnControllerPlugin.removePaths(networkPathIds, this);
				log.debug("Request sent to SDN controller: operationID = " + sdnOperationId);
				pendingSdnControllerOperations.add(sdnOperationId);
				sdnControllerOperationMap.put(sdnOperationId, npId);
				log.debug("Added SDN controller operation " + sdnOperationId + " in internal list." );
			}
			if (networkPaths.size() == 0) {
				log.debug("No network paths to tear down.");
				internalStatus = ResourceAllocationStatus.TERMINATED_NETWORK_CONNECTIONS;
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY, true);
			}
			log.debug("All requests to the SDN controller have been sent.");
			
		} catch (Exception e) {
			manageError(e.getMessage(), AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY);
			rollback();
			return;
		}
	}
	
	private void setupUnderlyingNetworkConnectivityInternal(SetupUnderlyingConnectivityMessage setupNetworkMessage) {
		log.debug("Starting setup of underlying network connectivity");
		internalStatus = ResourceAllocationStatus.CREATING_NETWORK_CONNECTIONS;
		try {

			NsResourceSchedulingSolution schedulingSolution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsInstanceId);
			if (!(schedulingSolution.isSolutionFound())) manageError("Solution not found for the given NS instance ID", AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY);
			
			List<NetworkPath> networkPaths = schedulingSolution.getNetworkPaths();
			log.debug("Found " + networkPaths.size() + " network paths to be allocated");
			for (NetworkPath np : networkPaths) {
				String npId = np.getNetworkPathId();
				log.debug("Processing network path " + npId);

				String nsVldId = np.getNsVirtualLinkDescriptorId();
				log.debug("Associated NS virtual link: " + nsVldId);
				NsVirtualLinkInfo nsVlInfo = nsDbWrapper.getNsVirtualLinkInfo(nsInstanceId, nsVldId);
				int vlanId = nsVlInfo.getSegmentId();
				log.debug("VLAN ID: " + vlanId);
				
				log.debug("Retrieving data related to VNF instances.");
				NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
				
				String tenantId = nsInfo.getTenantId();
				log.debug("Tenant ID: " + tenantId);

				log.debug("Reading info about path edges.");
				
				List<NetworkPathEndPoint> endPoints = np.getEndPoints();
				if (endPoints.size() != 2) {
					manageError("Not acceptable size for network end points. Only P2P connections supported at the moment", AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY);
					rollback();
					return;
				}
				
				//Note: since the connections are bi-directional it does not really matter which is the source or the destination one.
				ResourceAllocationUtilities resourceAllocationUtilities = new ResourceAllocationUtilities(vnfmMap, vnfdMap, defaultVimPlugin, null);
				NetworkPathEndPoint sourceEndPoint = endPoints.get(0);
				String srcMac = resourceAllocationUtilities.getMacAddressFromNetworkPathEndPoint(sourceEndPoint, nsInfo);
				NetworkPathEndPoint destinationEndPoint = endPoints.get(1);
				String dstMac = resourceAllocationUtilities.getMacAddressFromNetworkPathEndPoint(destinationEndPoint, nsInfo);
								
				List<NetworkPathHop> hops = np.getHops();
				log.debug("Found " + hops.size() + " hops.");

				List<SbNetworkPath> targetNetworkPath = new ArrayList<>();
				Classifier trafficClassifier = new VlanClassifier(srcMac, dstMac, vlanId);
				log.debug("Built classifier.");
				SbNetworkPath sbNp = new SbNetworkPath(npId, tenantId, hops, trafficClassifier);
				targetNetworkPath.add(sbNp);
				log.debug("Built network path.");
				String sdnOperationId = defaultSdnControllerPlugin.setupPaths(targetNetworkPath, this);
				log.debug("Request sent to SDN controller: operationID = " + sdnOperationId);
				pendingSdnControllerOperations.add(sdnOperationId);
				sdnControllerOperationMap.put(sdnOperationId, npId);
				log.debug("Added SDN controller operation " + sdnOperationId + " in internal list." );
			}
			if (networkPaths.size() == 0) {
				log.debug("No network path have to be instantiated.");
				internalStatus = ResourceAllocationStatus.CREATED_NETWORK_CONNECTIONS;
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY, true);
			} else {
				log.debug("All requests to the SDN controller have been sent.");
			}
		} catch (Exception e) {
			manageError(e.getMessage(), AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY);
			rollback();
			return;
		}
	}
	
	private void terminatePnfsInternal() {
		log.debug("Removing PNF infos.");
		try {
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			List<PnfInfo> pnfInfo = nsInfo.getPnfInfo();
			for (PnfInfo pi : pnfInfo) {
				String pnfId = pi.getId().toString();
				log.debug("Removing PNF info " + pnfId);
				Vnfm vnfm = pnfmMap.get(pnfId);
				vnfm.deletePnfIdentifier(pnfId);
				pnfmMap.remove(pnfId);
				pnfdMap.remove(pnfId);
				log.debug("PNF info " + pnfId + " removed.");
			}
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.REMOVE_VNF);
			rollback();
			return;
		} catch (FailedOperationException | MethodNotImplementedException | MalformattedElementException e) {
			manageError("Unable to remove PNF info: " + e.getMessage(), AllocationMessageType.REMOVE_VNF);
			rollback();
			return;
		}
	}
		
	private void terminateVnfsInternal() {
		log.debug("Starting termination of VNFs for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.TERMINATING_VNF;
		try {
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			List<String> vnfInstancesId = nsInfo.getVnfInfoId();
			for (String vnfId : vnfInstancesId) {
				log.debug("Processing termination for VNF instance " + vnfId);
				String vnfdId = nsInfo.getVnfInfoVnfdIdMap().get(vnfId);
				log.debug("VNFD ID: " + vnfdId);
				Vnfm vnfm = retrieveVnfm(vnfdId);
				
				TerminateVnfRequest request = new TerminateVnfRequest(vnfId, StopType.FORCEFUL, 0, new HashMap<String, String>());
				String operationId = vnfm.terminateVnf(request);
				log.debug("Termination request for VNF " + vnfId + " sent to the VNFM. Operation ID: " + operationId);
				pendingVnfmOperation.add(operationId);
				vnfOperationMap.put(operationId, vnfId);
				vnfmOperationPollingManager.addOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, vnfId, vnfm, this);
				log.debug("Operation " + operationId + " added to the list of VNFM pending operations");
			}
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.REMOVE_VNF);
			rollback();
			return;
		} catch (FailedOperationException | MethodNotImplementedException | MalformattedElementException e) {
			manageError("Unable to terminate VNF: " + e.getMessage(), AllocationMessageType.REMOVE_VNF);
			rollback();
			return;
		}
	}
	
	private void allocatePnfInfosInternal(AllocateVnfMessage allocateVnfMessage) {
		log.debug("Checking required PNFs");
		try {
		NsResourceSchedulingSolution schedulingSolution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsInstanceId);
		if (!(schedulingSolution.isSolutionFound())) throw new FailedOperationException("Solution not found for the given NS instance ID");
		log.debug("Retrieved NS resource scheduling solution");
		List<PnfAllocation> pnfs = schedulingSolution.getPnfAllocation();
		if (pnfs.isEmpty()) {
			log.debug("No PNFs in NS");
			return;
		}
		Vnfm vnfm = vnfmHandler.getDefaultVnfm();
		for (PnfAllocation pa : pnfs) {
			Pnfd pnfd = nsdManagement.queryPnfd(new GeneralizedQueryRequest(Utilities.buildPnfdFilter(pa.getPnfdId(), pa.getPnfdVersion()), null)).getQueryResult().get(0).getPnfd();
			String pnfId = vnfm.createPnfIdentifier(new CreatePnfIdentifierRequest(pa.getPnfdId(), 
					pa.getPnfdVersion(),
					pa.getPnfdId() + "-" + pa.getPnfdVersion() + "-" + pa.getIndex(),		//name
					pa.getPnfdId() + "-" + pa.getPnfdVersion() + "-" + pa.getIndex(),		//description
					pa.getPnfInstanceId(), 
					nsInstanceId, 
					pa.getPnfProfileId()));
			log.debug("PNF info " + pnfId + " created for PNF with index " + pa.getIndex() + " and PNFD " + pa.getPnfdId() + " associated to PNF instance " + pa.getPnfInstanceId());
			pnfdMap.put(pnfId, pnfd);
			pnfmMap.put(pnfId, vnfm);
			log.debug("Added PNF info in internal structure");
		}
		log.debug("PNF info creation terminated.");
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.ALLOCATE_VNF);
			rollback();
			return;
		} catch (FailedOperationException e) {
			manageError("Unable to allocate PNF info: " + e.getMessage(), AllocationMessageType.ALLOCATE_VNF);
			rollback();
			return;
		} catch (Exception e) {
			manageError("General error while allocating PNF info: " + e.getMessage(), AllocationMessageType.ALLOCATE_VNF);
			rollback();
			return;
		}
	}
	
	private void allocateVnfsInternal(AllocateVnfMessage allocateVnfMessage) {
		log.debug("Starting instantiation of VNFs for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.CREATING_VNF;
		try {			
			Nsd nsd = nsManagementEngine.retrieveNsd(nsInstanceId);
			NsDf nsDeploymentFlavour = nsd.getNsDeploymentFlavour(allocateVnfMessage.getRequest().getFlavourId());
			String nsInstantiationLevel = allocateVnfMessage.getRequest().getNsInstantiationLevelId();
			log.debug("Ns Instantiation Level ID: " + nsInstantiationLevel);
			NsLevel nsLevel;
			if (nsInstantiationLevel != null) {
				nsLevel = nsDeploymentFlavour.getNsLevel(nsInstantiationLevel);
				log.debug("Got NS level from request: " + nsLevel.getNsLevelId());
			}
			else {
				nsLevel = nsDeploymentFlavour.getDefaultInstantiationLevel();
				log.debug("Got defaul NS level: " + nsLevel.getNsLevelId());
			}
			List<VnfToLevelMapping> origVnfLevels = nsLevel.getVnfToLevelMapping();
			log.debug("The orig NS Level includes " + origVnfLevels.size() + " VNFs.");
			List<VnfToLevelMapping> vnfLevels = Utilities.orderVnfsBasedOnDependencies(origVnfLevels, nsDeploymentFlavour.getDependencies());
			log.debug("The ordered NS Level includes " + vnfLevels.size() + " VNFs.");
			for (VnfToLevelMapping vnf : vnfLevels) {
				//TODO j.brenes check this
				if(vnf != null){
					VnfProfile vnfProfile = nsDeploymentFlavour.getVnfProfile(vnf.getVnfProfileId());
					log.debug("Analyzing VNF profile " + vnf.getVnfProfileId());
					int numInstances = vnf.getNumberOfInstances();
					String vnfdId = vnfProfile.getVnfdId();
					String vnfFlavourId = vnfProfile.getFlavourId();
					String vnfInstantiationLevel = vnfProfile.getInstantiationLevel();
					log.debug("VNFD: " + vnfdId + " - FlavourID: " + vnfFlavourId + " - Number of instances: " + numInstances);
					for (int i = 0; i<numInstances; i++) {
						String vnfInstanceId = allocateVnf(vnfdId, vnfFlavourId, i, vnfInstantiationLevel, vnfProfile, nsDeploymentFlavour);
						setVnfIdInUserInfo(vnfdId, vnfInstanceId, i);
						log.debug("VNF index: " + i + " - VNF instance ID: " + vnfInstanceId);
					}
				}

			}
			log.debug("All VNF instantiation requests have been sent for NS " + nsInstanceId);
			
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.ALLOCATE_VNF);
			rollback();
			return;
		} catch (FailedOperationException e) {
			manageError("Unable to instantiate VNF: " + e.getMessage(), AllocationMessageType.ALLOCATE_VNF);
			rollback();
			return;
		}
	}
	
	private void scaleVnfsInternal(ScaleVnfMessage scaleVnfMessage) {
		log.debug("Starting scaling of VNFs for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.SCALING_VNF;
		try {			
			Nsd nsd = nsManagementEngine.retrieveNsd(nsInstanceId);
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			
			NsDf nsDeploymentFlavour = nsd.getNsDeploymentFlavour(nsInfo.getFlavourId());
			String nsInstantiationLevel = scaleVnfMessage.getRequest().getScaleNsData().getScaleNsToLevelData().getNsInstantiationLevel();
			log.debug("Ns Instantiation Level ID: " + nsInstantiationLevel);
			NsLevel nsLevel = nsDeploymentFlavour.getNsLevel(nsInstantiationLevel);
			
			NsScaleSchedulingSolution scaleSolution = resourceComputationDbWrapper.getNsScaleSchedulingSolution(nsInstanceId);
			List<ScaleVnfResourceAllocation> vnfsToScale = scaleSolution.getScaleNsResourceAllocation().getVnfResourceAllocation(); 
			List<VnfToLevelMapping> origVnfLevels = nsLevel.getVnfToLevelMapping();
			log.debug("The requested NS Level includes " + origVnfLevels.size() + " VNFs.");
			List<VnfToLevelMapping> vnfLevels = Utilities.orderVnfsBasedOnDependencies(origVnfLevels, nsDeploymentFlavour.getDependencies());
			log.debug("The ordered NS Level includes " + vnfLevels.size() + " VNFs.");
			for (VnfToLevelMapping vnf : vnfLevels) {
				//TODO j.brenes check this
				if(vnf != null){
					VnfProfile vnfProfile = nsDeploymentFlavour.getVnfProfile(vnf.getVnfProfileId());
					log.debug("Analyzing VNF profile " + vnf.getVnfProfileId());
					int numInstances = vnf.getNumberOfInstances();
					
					String vnfdId = vnfProfile.getVnfdId();
					ScaleVnfResourceAllocation vnfdScale = vnfsToScale.stream()
							.filter(rA->vnfdId.equals(rA.getVnfdId()))
							.findAny()
							.orElse(null);
					if(vnfdScale!=null) {
						log.debug("Found vnfd to be instantiated during scale procedure");
						String vnfFlavourId = vnfProfile.getFlavourId();
						String vnfInstantiationLevel = vnfProfile.getInstantiationLevel();
						log.debug("VNFD: " + vnfdId + " - FlavourID: " + vnfFlavourId + " - Number of instances: " + numInstances);
						for (int i = 0; i<numInstances; i++) {
							String vnfInstanceId = allocateVnf(vnfdId, vnfFlavourId, i, vnfInstantiationLevel, vnfProfile, nsDeploymentFlavour);
							setVnfIdInUserInfo(vnfdId, vnfInstanceId, i);
							log.debug("VNF index: " + i + " - VNF instance ID: " + vnfInstanceId);
						}
					}
					
				}

			}
			log.debug("All VNF instantiation requests have been sent for NS " + nsInstanceId);
			
		} catch (NotExistingEntityException e) {
			manageError("Unable to find entity: " + e.getMessage(), AllocationMessageType.SCALE_VNF);
			rollback();
			return;
		} catch (FailedOperationException e) {
			manageError("Unable to scale VNF: " + e.getMessage(), AllocationMessageType.SCALE_VNF);
			rollback();
			return;
		}
	}
	
	private String allocateVnf(String vnfdId, String flavourId, int instanceNumber, String vnfInstantiationLevel, VnfProfile vnfProfile, NsDf nsDeploymentFlavour) 
			throws FailedOperationException, NotExistingEntityException {
		log.debug("Instantiating VNF for VNFD ID " + vnfdId);
		OnboardedVnfPkgInfo pkg = vnfPackageManagement.getOnboardedVnfPkgInfoFromVnfd(vnfdId);
		log.debug("Found VNF package.");
		if (!(pkg.canBeInstantiated())) {
			log.debug("The VNF cannot be instantiated due to the status of the VNF package");
			throw new FailedOperationException("The VNF with VNFD " + vnfdId + " cannot be instantiated due to the status of the VNF package");
		}
		Vnfd vnfd = pkg.getVnfd();
		
		Vnfm vnfm;
		if (vnfd.getVnfmInfo() != null) vnfm = vnfmHandler.getVnfm(vnfd.getVnfmInfo().get(0));
		else vnfm = vnfmHandler.getDefaultVnfm();
		log.debug("VNFM retrieved");

		String vnfInstanceName = nsInstanceId + "-" + vnfd.getVnfProductName() + "-" + instanceNumber;
		String vnfInstanceDescription = "VNF " + vnfd.getVnfProductName() + " instance " + instanceNumber + " for NS " + nsInstanceId;
		
		try {
			String vnfInstanceId = vnfm.createVnfIdentifier(new CreateVnfIdentifierRequest(vnfdId, vnfInstanceName, vnfInstanceDescription));
			log.debug("Created VNF identifier: " + vnfInstanceId);
			vnfPackageManagement.notifyVnfInstanceCreation(pkg.getOnboardedVnfPkgInfoId(), vnfInstanceId);
			nsDbWrapper.addVnfInfoInNsInfo(nsInstanceId, vnfInstanceId, instanceNumber, vnfdId);
			vnfm.registerNfvo(vnfInstanceId, this);
			vnfmMap.put(vnfInstanceId, vnfm);
			vnfdMap.put(vnfInstanceId, vnfd);
			
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			Map<String, String> configurationParameters = new HashMap<>();
			List<String> vnfConfigurableParameters = vnfd.getConfigurableProperties().getAdditionalConfigurableProperty();
			for (String configParam : vnfConfigurableParameters) {
				if (nsInfo.getConfigurationParameters().containsKey(configParam)) {
					configurationParameters.put(configParam, nsInfo.getConfigurationParameters().get(configParam));
				}
			}
			
			InstantiateVnfRequest request = buildInstantiateVnfRequest(vnfInstanceId, flavourId, vnfInstantiationLevel, vnfProfile, nsDeploymentFlavour, configurationParameters);
			String operationId = vnfm.instantiateVnf(request);
			log.debug("Instantiation request sent to the VNFM. Operation ID: " + operationId);
			pendingVnfmOperation.add(operationId);
			vnfOperationMap.put(operationId, vnfInstanceId);
			vnfmOperationPollingManager.addOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, vnfInstanceId, vnfm, this);
			log.debug("Operation " + operationId + " added to the list of VNFM pending operations");
			
			return vnfInstanceId;
		} catch (MethodNotImplementedException | MalformattedElementException e) {
			log.error("Failure in VNF identifier creation");
			throw new FailedOperationException(e.getMessage());
		}
	}
	
	private void configureVnfsInternal(ConfigureVnfMessage configureVnfMessage) {
		log.debug("Starting configuration of VNFs for NS instance " + nsInstanceId);
		internalStatus = ResourceAllocationStatus.CONFIGURING_VNF;
		try {
			
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			List<String> vnfInstancesId = nsInfo.getVnfInfoId();
			List<PnfInfo> pnfInfo = nsInfo.getPnfInfo();
			boolean foundVnfToBeConfigured = false;
			
			for (String vnfId : vnfInstancesId) {
				log.debug("Processing configuration for VNF instance " + vnfId);
				String vnfdId = nsInfo.getVnfInfoVnfdIdMap().get(vnfId);
				log.debug("VNFD ID: " + vnfdId);
				Vnfm vnfm = retrieveVnfm(vnfdId);
				ResourceAllocationUtilities rau = new ResourceAllocationUtilities(vnfmMap, vnfdMap, defaultVimPlugin, vnfm);
				Vnfd vnfd = vnfdMap.get(vnfId);
				VnfConfigurableProperties configParam = vnfd.getConfigurableProperties();
				if ((configParam != null) && (!(configParam.getAdditionalConfigurableProperty().isEmpty()))) {
					foundVnfToBeConfigured = true;
					Map<String, String> configValues = rau.buildConfigurationData(configParam.getAdditionalConfigurableProperty(), nsInfo.getConfigurationParameters());
					ModifyVnfInformationRequest configRequest = new ModifyVnfInformationRequest(vnfId, configValues);
					String operationId = vnfm.modifyVnfInformation(configRequest);
					log.debug("Configuration request for VNF " + vnfId + " sent to the VNFM.");
					pendingVnfmOperation.add(operationId);
					vnfOperationMap.put(operationId, vnfId);
					vnfmOperationPollingManager.addOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, vnfId, vnfm, this);
					log.debug("Operation " + operationId + " added to the list of VNFM pending operations");
				}
			}
			
			for (PnfInfo pi : pnfInfo) {
				String pnfId = pi.getId().toString();
				log.debug("Processing configuration for PNF info " + pnfId);
				Pnfd pnfd = pnfdMap.get(pnfId);
				log.debug("PNFD ID " + pnfd.getPnfdId());
				List<String> configParams = pnfd.getConfigurableProperty();
				if ((configParams != null) && (!(configParams.isEmpty()))) {
					foundVnfToBeConfigured = true;
					Vnfm pnfm = pnfmMap.get(pnfId);
					ResourceAllocationUtilities rau = new ResourceAllocationUtilities(vnfmMap, vnfdMap, defaultVimPlugin, pnfm);
					Map<String, String> configValues = rau.buildConfigurationData(configParams, nsInfo.getConfigurationParameters());
					ModifyVnfInformationRequest configRequest = new ModifyVnfInformationRequest(pnfId, configValues);
					String operationId = pnfm.modifyPnfInformation(configRequest);
					log.debug("Configuration request for PNF " + pnfId + " sent to the VNFM.");
					pendingVnfmOperation.add(operationId);
					vnfOperationMap.put(operationId, pnfId);
					vnfmOperationPollingManager.addOperation(operationId, OperationStatus.SUCCESSFULLY_DONE, pnfId, pnfm, this);
					log.debug("Operation " + operationId + " added to the list of VNFM pending operations");
				}
			}
			
			if (!foundVnfToBeConfigured) {
				log.debug("No VNF or PNF needs to be configured. Sending ACK to lifecycle manager");
				internalStatus = ResourceAllocationStatus.CONFIGURED_VNF;
				nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.CONFIGURE_VNF, true);
			}
			
		} catch (FailedOperationException e) {
			manageError("Failed VNF configuration: " + e.getMessage(), AllocationMessageType.CONFIGURE_VNF);
			rollback();
			return;
		} catch (NotExistingEntityException e) {
			manageError("Failed VNF configuration: " + e.getMessage(), AllocationMessageType.CONFIGURE_VNF);
			rollback();
			return;
		} catch (Exception e) {
			manageError("General exception: " + e.getMessage(), AllocationMessageType.CONFIGURE_VNF);
			rollback();
			return;
		}
	}
	
	private InstantiateVnfRequest buildInstantiateVnfRequest(String vnfInstanceId, String flavourId, String instantiationLevelId, VnfProfile vnfProfile, NsDf nsDeploymentFlavour, 
			Map<String, String> configurationParameters) 
	throws NotExistingEntityException {
		log.debug("Building instantiate VNF request for VNF instance " + vnfInstanceId);
		List<ExtVirtualLinkData> extVirtualLink = new ArrayList<>();
		List<NsVirtualLinkConnectivity> nsVirtualLinkConnectivity = vnfProfile.getNsVirtualLinkConnectivity();
		log.debug("Found " + nsVirtualLinkConnectivity.size() + " external virtual links.");
		for (NsVirtualLinkConnectivity vlc : nsVirtualLinkConnectivity) {
			String nsVlProfileId = vlc.getVirtualLinkProfileId();
			VirtualLinkProfile vlProfile = nsDeploymentFlavour.getVirtualLinkProfile(nsVlProfileId);
			String vldId = vlProfile.getVirtualLinkDescId();
			log.debug("Processing data for external virtual link " + vldId);
			NsVirtualLinkInfo vlInfo = nsDbWrapper.getNsVirtualLinkInfo(nsInstanceId, vldId);
			ResourceHandle rh = vlInfo.getResourceHandle().get(0);
			
			//Set the external connection point descriptors
			List<String> cpdId = vlc.getCpdId();
			List<VnfExtCpData> extCp = new ArrayList<>();
			log.debug("Found " + cpdId.size() + " external connection points attached to VL " + vldId);
			for (String cpd : cpdId) {
				log.debug("Adding external connection point " + cpd);
				extCp.add(new VnfExtCpData(cpd, new ArrayList<>(), new HashMap<String, String>()));
			}
			ExtVirtualLinkData evld = new ExtVirtualLinkData(vldId, rh.getVimId(), rh.getResourceProviderId(), rh.getResourceId(), extCp);
			extVirtualLink.add(evld);
			log.debug("Added external virtual link " + vldId + " with VIM resource ID " + rh.getResourceId());
		}
		
		InstantiateVnfRequest request = new InstantiateVnfRequest(vnfInstanceId,
				flavourId,
				instantiationLevelId,
				extVirtualLink,
				null,
				null,
				"EN",
				configurationParameters);
		return request;
	}
	
	private void processSdnControllerAck(String operationId, OperationStatus operationStatus) {
		log.debug("Processing SDN controller ACK for operation " + operationId + " - operation result: " + operationStatus.toString());
		switch (internalStatus) {
		case CREATING_NETWORK_CONNECTIONS: {
			if (operationStatus == OperationStatus.FAILED) {
				log.error("Operation " + operationId + " is failed at SDN controller");
				manageError("Creation of underlying network connection is failed at the SDN controller", AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY);
				rollback();
				return;
			} else if (operationStatus == OperationStatus.SUCCESSFULLY_DONE) {
				String pathId = sdnControllerOperationMap.get(operationId);
				log.debug("Network path " + pathId + " has been successfully established at the SDN controller");
				pendingSdnControllerOperations.remove(operationId);
				sdnControllerOperationMap.remove(operationId);
				if (pendingSdnControllerOperations.isEmpty()) {
					log.debug("All the network paths associated to the NS " + nsInstanceId + " have been created. Notifying lifecycle manager.");
					internalStatus = ResourceAllocationStatus.CREATED_NETWORK_CONNECTIONS;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY, true);
				} else {
					log.debug("Some network paths associated to the NS " + nsInstanceId + " are still to be created. Waiting for other notifications.");
				}
			} else {
				log.error("Unexpected operation status. Discarding message.");
				return;
			}
			break;
		}
		
		case TERMINATING_NETWORK_CONNECTIONS: {
			if (operationStatus == OperationStatus.FAILED) {
				log.error("Operation " + operationId + " is failed at SDN controller");
				manageError("Termination of underlying network connection is failed at the SDN controller", AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY);
				return;
			} else if (operationStatus == OperationStatus.SUCCESSFULLY_DONE) {
				String pathId = sdnControllerOperationMap.get(operationId);
				log.debug("Network path " + pathId + " has been successfully terminated at the SDN controller");
				pendingSdnControllerOperations.remove(operationId);
				sdnControllerOperationMap.remove(operationId);
				if (pendingSdnControllerOperations.isEmpty()) {
					log.debug("All the network paths associated to the NS " + nsInstanceId + " have been terminated. Notifying lifecycle manager.");
					internalStatus = ResourceAllocationStatus.TERMINATED_NETWORK_CONNECTIONS;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY, true);
				} else {
					log.debug("Some network paths associated to the NS " + nsInstanceId + " are still to be terminated. Waiting for other notifications.");
				}
			} else {
				log.error("Unexpected operation status. Discarding message.");
				return;
			}
			break;
		}

		default: {
			log.error("Received SDN controller ACK in wrong status");
			break;
		}
		}
	}
	
	private void processVnfmAck(String operationId, String vnfId, OperationStatus operationStatus) {
		log.debug("Processing VNFM ACK for operation " + operationId + " and VNF " + vnfId + " - operation result: " + operationStatus.toString());
		
		switch (internalStatus) {
		case CREATING_VNF: {
			
			if (operationStatus == OperationStatus.FAILED) {
				log.error("Operation " + operationId + " is failed at VNFM");
				manageError("Instantiation of VNF " + vnfId + " is failed at VNFM", AllocationMessageType.ALLOCATE_VNF);
				rollback();
				return;
			} else if (operationStatus == OperationStatus.SUCCESSFULLY_DONE) {
				log.debug("VNF " + vnfId + " has been successfully created at VNFM");
				addVnfUserAccessInfoInDb(vnfId);
				vnfOperationMap.remove(operationId);
				pendingVnfmOperation.remove(operationId);
				if (pendingVnfmOperation.isEmpty()) {
					log.debug("All the VNFs associated to the NS " + nsInstanceId + " have been created. Notifying lifecycle manager.");
					internalStatus = ResourceAllocationStatus.CREATED_VNF;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.ALLOCATE_VNF, true);
				} else {
					log.debug("Some VNFs associated to the NS " + nsInstanceId + " are still to be created. Waiting for other notifications.");
				}
			} else {
				log.error("Unexpected operation status. Discarding message.");
				return;
			}
			break;
		}
		
		case CONFIGURING_VNF: {
			if (operationStatus == OperationStatus.FAILED) {
				log.error("Operation " + operationId + " is failed at VNFM");
				manageError("Configuration of VNF " + vnfId + " is failed at VNFM", AllocationMessageType.CONFIGURE_VNF);
				rollback();
				return;
			} else if (operationStatus == OperationStatus.SUCCESSFULLY_DONE) {
				log.debug("Received ACK from VNFM while in configuring VNF status: VNF " + vnfId + " has been successfully configured at VNFM.");
				vnfOperationMap.remove(operationId);
				pendingVnfmOperation.remove(operationId);
				if (pendingVnfmOperation.isEmpty()) {
					log.debug("All the VNFs and PNFs associated to the NS " + nsInstanceId + " have been configured. Notifying lifecycle manager.");
					internalStatus = ResourceAllocationStatus.CONFIGURED_VNF;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.CONFIGURE_VNF, true);
				} else {
					log.debug("Some VNFs or PNFs associated to the NS " + nsInstanceId + " are still to be configured. Waiting for other notifications.");
				}
			} else {
				log.error("Unexpected operation status. Discarding message.");
				return;
			}
			break;
		}
		
		case TERMINATING_VNF: {
			
			if (operationStatus == OperationStatus.FAILED) {
				log.error("Operation " + operationId + " is failed at VNFM");
				manageError("Termination of VNF " + vnfId + " is failed at VNFM", AllocationMessageType.REMOVE_VNF);
				rollback();
				return;
			} else if (operationStatus == OperationStatus.SUCCESSFULLY_DONE) {
				log.debug("VNF " + vnfId + " has been successfully terminated at VNFM. Deleting VNF identifier at VNFM.");
				Vnfm vnfm = vnfmMap.get(vnfId);
				try {
					vnfm.deleteVnfIdentifier(vnfId);
					log.debug("VNF ID removed from VNFM.");
				} catch (Exception e) {
					log.error("Unable to remove VNF ID from VNFM: " + e.getMessage());
				}
				vnfOperationMap.remove(operationId);
				pendingVnfmOperation.remove(operationId);
				log.debug("Operation removed from internal data structures");
				try {
					nsDbWrapper.removeVnfInfoInNsInfo(nsInstanceId, vnfId);
				} catch (NotExistingEntityException e) {
					log.error("Unable to remove VNF info from NS info");
				}
				try {
					String vnfPackageId = vnfPackageManagement.getOnboardedVnfPkgInfoFromVnfd(vnfdMap.get(vnfId).getVnfdId()).getOnboardedVnfPkgInfoId();
					vnfPackageManagement.notifyVnfInstanceDeletion(vnfPackageId, vnfId);
				} catch (NotExistingEntityException e) {
					log.error("Unable to notify VNF instance deletion to VNF package manager");
				}
				if (pendingVnfmOperation.isEmpty()) {
					log.debug("All the VNFs associated to the NS " + nsInstanceId + " have been terminated. Notifying lifecycle manager.");
					internalStatus = ResourceAllocationStatus.TERMINATED_VNF;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.REMOVE_VNF, true);
				} else {
					log.debug("Some VNFs associated to the NS " + nsInstanceId + " are still to be terminated. Waiting for other notifications.");
				}
			} else {
				log.error("Unexpected operation status. Discarding message.");
				return;
			}
			break;
			
		}
		
		default:{
			log.error("VNFM ACK in unexpected status. Discarding message.");
			break;
		}
		}
	}
	
	private void processVimNetResourceAck(AllocateNetworkResponse vimResponse) {
		log.debug("Processing VIM net resource ACK");
		switch (internalStatus) {
		case CREATING_VLS_NETS: {
			
			VirtualNetwork vNet = vimResponse.getNetworkData();
			if (vNet == null) {
				log.error("Received VIM ACK without vNet info in creating virtual network status. Discarding message.");
				return;
			}
			processVirtualNetworkCreationAck(vNet);
			break;
		}
		case CREATING_VLS_SAPS: {
			
			VirtualNetworkPort vPort = vimResponse.getNetworkPortData();
			if (vPort == null) {
				log.error("Received VIM ACK without vPort info in creating SAPs status. Discarding message.");
				return;
			}
			processVirtualNetworkPortCreationAck(vPort);
			break;
		}
		case CREATING_VLS_SUBNETS: {

			NetworkSubnet subnet = vimResponse.getSubnetData();
			if (subnet == null) {
				log.error("Received VIM ACK without subnet info in creating VLS subnet status. Discarding message.");
				return;
			}
			processSubnetCreationAck(subnet);
			break;
		}

		default:{
			log.error("VIM net resource ACK in unexpected status. Discarding message.");
			break;
		}
		}
	}
	
	private void processVirtualNetworkCreationAck(VirtualNetwork network) {
		log.debug("Processing VIM ACK about virtual network resource creation");
		String resourceId = network.getNetworkResourceId();
		VimResourceStatus status = Utilities.readResourceStatusFromMetadata(network.getMetadata());
		try {
		switch (status) {
		case FAILED: {
			log.error("Virtual network resource " + resourceId + " is failed at VIM");
			nsDbWrapper.setNsVirtualLinkInfoResourceStatus(resourceId, VimResourceStatus.FAILED);
			manageError("Virtual network resource " + resourceId + " is failed at VIM", AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		}
		
		case INSTANTIATED: {
			log.debug("Virtual network resource " + resourceId + " has been successfully created at VIM");
			nsDbWrapper.setNsVirtualLinkInfoResourceStatus(resourceId, VimResourceStatus.INSTANTIATED);
			if (nsDbWrapper.isAllNsVirtualLinkInStatus(nsInstanceId, VimResourceStatus.INSTANTIATED)) {
				log.debug("All the virtual networks associate to the NS virtual links for the NS " + nsInstanceId + " have been created.");
				createSubnetsInternal();
			} else {
				log.debug("Some virtual networks associated to the NS virtual links for the NS " + nsInstanceId + " are still to be created. Waiting for other notifications.");
			}
			break;
		}

		default: {
			log.error("Unexpected status.");
			break;
		}
		}
		} catch (NotExistingEntityException e) {
			log.error("Error while updating internal DB: " + e.getMessage());
		}
	}
	
	private void processVirtualNetworkPortCreationAck(VirtualNetworkPort port) {
		log.debug("Processing VIM ACK about virtual network port resource creation");
		String portId = port.getResourceId();
		VimResourceStatus status = Utilities.readResourceStatusFromMetadata(port.getMetadata());
		try {
			switch (status) {
			case FAILED: {
				log.error("Port " + portId + " is failed at VIM");
				nsDbWrapper.setNsLinkPortStatus(nsInstanceId, portId, VimResourceStatus.FAILED);
				manageError("Port " + portId + " is failed at VIM", AllocationMessageType.ALLOCATE_NS_VLS);
				rollback();
				return;
			}

			case INSTANTIATED: {
				log.debug("Port " + portId + " has been successfully created at VIM");
				nsDbWrapper.setNsLinkPortStatus(nsInstanceId, portId, VimResourceStatus.INSTANTIATED);
				if (nsDbWrapper.isAllNsLinkPortsInStatus(nsInstanceId, VimResourceStatus.INSTANTIATED)) {
					log.debug("All the ports associated to SAPs of the NS " + nsInstanceId + " have been created. Notifying lifecycle manager");
					internalStatus = ResourceAllocationStatus.CREATED_VLS;
					nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, AllocationMessageType.ALLOCATE_NS_VLS, true);
				} else {
					log.debug("Some ports associated to SAPs for the NS " + nsInstanceId + " are still to be created. Waiting for other notifications.");
				}
				break;
			}

			default: {
				log.error("Unexpected resource status.");
				break;
			}
			}
		} catch (NotExistingEntityException e) {
			log.error("Error while updating internal DB: " + e.getMessage());
		}
	}
	
	private void processSubnetCreationAck(NetworkSubnet subnet) {
		log.debug("Processing VIM ACK about subnet resource creation");
		String subnetId = subnet.getResourceId();
		String networkId = subnet.getNetworkId();
		VimResourceStatus status = Utilities.readResourceStatusFromMetadata(subnet.getMetadata());
		try {
		switch (status) {
		case FAILED: {
			log.error("Subnet " + subnetId + " is failed at VIM");
			nsDbWrapper.setNsVirtualLinkSubnetStatus(networkId, subnetId, VimResourceStatus.FAILED);
			manageError("Subnet " + subnetId + " is failed at VIM", AllocationMessageType.ALLOCATE_NS_VLS);
			rollback();
			return;
		}
		
		case INSTANTIATED: {
			log.debug("Subnet " + subnetId + " has been successfully created at VIM");
			nsDbWrapper.setNsVirtualLinkSubnetStatus(networkId, subnetId, VimResourceStatus.INSTANTIATED);
			if (nsDbWrapper.isAllNsVirtualLinkSubnetInStatus(nsInstanceId, VimResourceStatus.INSTANTIATED)) {
				log.debug("All the subnets associate to the NS virtual links for the NS " + nsInstanceId + " have been created.");
				createSapsInternal();
			} else {
				log.debug("Some subnets associated to the NS virtual links for the NS " + nsInstanceId + " are still to be created. Waiting for other notifications.");
			}
			break;
		}

		default: {
			log.error("Unexpected status.");
			break;
		}
		}
		} catch (NotExistingEntityException e) {
			log.error("Error while updating internal DB: " + e.getMessage());
		}
		
	}
	
	
	
	
	
	//********************************* Utilities methods ***********************************
	
	private void rollback() {
		log.debug("Invoked rollback. Still to be implemented!");
		//TODO: 
	}
		
	private VimPlugin getVimForNsVirtualLinks() {
		return defaultVimPlugin;
	}
	
	private Vnfm retrieveVnfm(String vnfdId) throws NotExistingEntityException {
		log.debug("Retrieving VNFM");
		OnboardedVnfPkgInfo pkg = vnfPackageManagement.getOnboardedVnfPkgInfoFromVnfd(vnfdId);
		log.debug("Found VNF package.");
		Vnfd vnfd = pkg.getVnfd();
		
		Vnfm vnfm;
		if (vnfd.getVnfmInfo() != null) vnfm = vnfmHandler.getVnfm(vnfd.getVnfmInfo().get(0));
		else vnfm = vnfmHandler.getDefaultVnfm();
		log.debug("VNFM retrieved");
		return vnfm;
	}
	
	private void manageError(String errorMessage, AllocationMessageType actionType) {
		log.error(errorMessage);
		try {
			nsDbWrapper.updateInternalOperation(currentOperationId, OperationStatus.FAILED, errorMessage);
			nsDbWrapper.setNsInfoInstantiationState(nsInstanceId, InstantiationState.INSTANTIATED);
			internalStatus = ResourceAllocationStatus.FAILED;
		} catch (Exception e) {
			log.error("Impossible to update internal DB about NS instantiation");
		}
		nsManagementEngine.notifyResourceAllocationResult(nsInstanceId, currentOperationId, actionType, false);
	}
	
	private void setVnfIdInUserInfo(String vnfdId, String vnfId, int index) {
		for (UserAccessInfo uai : this.userAccessInfos) {
			if (vnfdId.equals(uai.getVnfdId())) {
				if (index == 0) {
					uai.setVnfId(vnfId);
				} else {
					this.userAccessInfos.add(new UserAccessInfo(uai.getSapdId(), uai.getVnfdId(), vnfId, uai.getVnfExtCpdId(), null));
				}
				return;
			}
		}
	}
	
	private void addVnfUserAccessInfoInDb(String vnfId) {
		ResourceAllocationUtilities resourceAllocationUtilities = new ResourceAllocationUtilities(vnfmMap, vnfdMap, defaultVimPlugin, null);
		for (UserAccessInfo uai : this.userAccessInfos) {
			//There could be more than one SAP for VNF, in case of several external CPs
			if (vnfId.equals(uai.getVnfId())) {
				String vnfExtCpdId = uai.getVnfExtCpdId();
				try {
					String address = resourceAllocationUtilities.getFloatingForExternalCp(vnfId, vnfExtCpdId);
					uai.setAddress(address);
					nsDbWrapper.addUserAccessInfo(nsInstanceId, uai.getSapdId(), uai.getVnfdId(), vnfId, vnfExtCpdId, address);
				} catch (Exception e) {
					log.debug(e.getMessage());
				}
			}
		}
	}
	
	//********************************* End of utilities methods ***********************************
	
	@Override
	public GrantVnfLifecycleOperationResponse grantVnfLifecycleOperation(GrantVnfLifecycleOperationRequest request)
			throws MethodNotImplementedException, FailedOperationException, NotExistingEntityException, MalformattedElementException {
		log.debug("Grant VNF lifecycle operation");
		VnfLcmOperation lifecycleOperation = request.getLifecycleOperation();
		switch (lifecycleOperation) {
		case INSTATIATE_VNF: {
			log.debug("Received GRANT request for instantiate operation");
			NsResourceSchedulingSolution schedulingSolution = resourceComputationDbWrapper.getNsResourceSchedulingSolution(nsInstanceId);
			if (!(schedulingSolution.isSolutionFound())) throw new FailedOperationException("Solution not found for the given NS instance ID");
			log.debug("Retrieved NS resource scheduling solution");
			String vnfInstanceId = request.getVnfInstanceId();
			String vnfdId = request.getVnfdId();
			NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
			int index = nsInfo.getVnfInfoMap().get(vnfInstanceId);
			log.debug("VNF instance ID: " + vnfInstanceId + " - VNFD ID: " + vnfdId + " - VNF index: " + index);
			List<VnfResourceAllocation> vras = resourceComputationDbWrapper.getVnfResourceAllocation(nsInstanceId, vnfdId, index);
			//At the moment a single VDU is considered, so only the first element is processed
			VnfResourceAllocation vra = vras.get(0);
			String vimId = vra.getVimId();
			String zoneId = vra.getZoneId();
			String hostId = vra.getHostId();
			
			List<VimConnectionInfo> vim = new ArrayList<>();
			vim.add(new VimConnectionInfo(null, vimId, null, null, null));
			List<ZoneInfo> zone = new ArrayList<>();
			zone.add(new ZoneInfo(zoneId, zoneId, vimId, null));
			Map<String, String> additionalParam = new HashMap<>();
			additionalParam.put("HOST_ID", hostId);
			
			List<ResourceDefinition> addResourceReq = request.getAddResource();
			List<GrantInfo> addResource = new ArrayList<>();
			for (ResourceDefinition rd : addResourceReq) {
				//TODO: tenant to be fixed
				addResource.add(new GrantInfo(rd.getResourceDefinitionId(), null, vimId, getVimForNsVirtualLinks().getVim().getTenant(), zoneId, null));
			}
			return new GrantVnfLifecycleOperationResponse(vim, zone, null, null, null, null, addResource, null, null, null, null, 
					null, null, additionalParam);
		}
		
		case TERMINATE_VNF: {
			log.error("Received GRANT request for terminate operation");
			List<ResourceDefinition> removeResourceReq = request.getRemoveResource();
			List<GrantInfo> removeResource = new ArrayList<>();
			for (ResourceDefinition rd : removeResourceReq) {
				removeResource.add(new GrantInfo(rd.getResourceDefinitionId(), null, getVimForNsVirtualLinks().getVim().getVimId(), 
						getVimForNsVirtualLinks().getVim().getTenant(), null, null));
			}
			return new GrantVnfLifecycleOperationResponse(null, null, null, null, null, null, 
					null, null, removeResource, null, null, null, null, null);
		}

		default:
			log.error("Received GRANT request for not supported operation");
			throw new FailedOperationException("Not supported operation");
		}
	}
	
	
	
	@Override
	public void notify(InformationChangeNotification notification) {
		log.debug("Received VIM notification about information change. Message not processed at the moment.");
	}
	
	@Override
	public void notify(CapacityChangeNotification notification) {
		log.debug("Received VIM notification about capacity change. Message not processed at the moment.");
	}
	
	public Vnfm getVnfmForVnfInstance(String vnfInstanceId) throws NotExistingEntityException {
		log.debug("Retrieving VNFM for VNF instance " + vnfInstanceId);
		if (vnfmMap.containsKey(vnfInstanceId)) return vnfmMap.get(vnfInstanceId);
		else throw new NotExistingEntityException("VNFM not defined for VNF instance " + vnfInstanceId);
	}
	
	
	
}


