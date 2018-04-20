package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



/**
 * Abstract message sent to the Resource Allocation Manager
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = AllocateNsVlsMessage.class, 	name = "ALLOCATE_NS_VLS"),
	@Type(value = AllocateVimNetResourceAckMessage.class, 	name = "VIM_ACK_ALLOCATE_VNET_RESOURCE"),
	@Type(value = AllocateVnfMessage.class, 	name = "ALLOCATE_VNF"),
	@Type(value = ConfigureVnfMessage.class, 	name = "CONFIGURE_VNF"),
	@Type(value = VnfmOperationAckMessage.class, 	name = "VNFM_OPERATION_ACK"),
	@Type(value = SetupUnderlyingConnectivityMessage.class, 	name = "SETUP_UNDERLYING_CONNECTIVITY"),
	@Type(value = SdnControllerOperationAckMessage.class, 	name = "SDN_CONTROLLER_OPERATION_ACK"),
	@Type(value = TerminateVnfMessage.class, 	name = "TERMINATE_VNF"),
	@Type(value = TerminateNsVlsMessage.class, 	name = "TERMINATE_NS_VLS"),
	@Type(value = DestroyUnderlyingConnectivityMessage.class, name = "TERMINATE_UNDERLYING_CONNECTIVITY"),
})
public abstract class AllocationMessage {

	@JsonProperty("type")
	AllocationMessageType type;
	
	@JsonProperty("nsInstanceId")
	String nsInstanceId;
	
	public AllocationMessage() { }

	/**
	 * @return the type
	 */
	public AllocationMessageType getType() {
		return type;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	
	
	

}
