package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Abstract message sent to the VNF Lifecycle Manager
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = InstantiateVnfRequestMessage.class, 	name = "INSTANTIATE_VNF_REQUEST"),
	@Type(value = ConfigureVnfRequestMessage.class, 	name = "CONFIGURE_VNF_REQUEST"),
	@Type(value = ConfigureVnfAckMessage.class, 		name = "CONFIGURE_VNF_ACK"),	
	@Type(value = TerminateVnfRequestMessage.class, 	name = "TERMINATE_VNF_REQUEST"),
	@Type(value = InstantiateVimNetworkResourceAckMessage.class, 	name = "INSTANTIATE_VIM_NETWORK_ACK"),
	@Type(value = InstantiateVimComputeResourceAckMessage.class, 	name = "INSTANTIATE_VIM_COMPUTE_ACK"),
	@Type(value = TerminateVimComputeResourceAckMessage.class, 	name = "TERMINATE_VIM_COMPUTE_ACK"),
})
public abstract class VnfmMessage {

	@JsonProperty("type")
	VnfmMessageType type;
	
	@JsonProperty("vnfInstanceId")
	String vnfInstanceId;
	
	@JsonProperty("operationId")
	String operationId;

	/**
	 * @return the type
	 */
	public VnfmMessageType getType() {
		return type;
	}

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
