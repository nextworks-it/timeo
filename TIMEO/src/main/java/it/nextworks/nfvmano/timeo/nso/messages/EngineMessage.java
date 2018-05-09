package it.nextworks.nfvmano.timeo.nso.messages;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Abstract message sent to the NFVO engine
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = InstantiateNsRequestMessage.class, 	name = "INSTANTIATE_REQUEST"),
	@Type(value = TerminateNsRequestMessage.class, 	name = "TERMINATE_REQUEST"),
	@Type(value = NotifyComputationResultMessage.class, 	name = "NOTIFY_COMPUTATION"),
	@Type(value = NotifyComputationReleaseMessage.class, 	name = "NOTIFY_COMPUTATION_RELEASE"),
	@Type(value = NotifyAllocationResultMessage.class, 	name = "NOTIFY_ALLOCATION"),
})
public abstract class EngineMessage {

	@JsonProperty("type")
	EngineMessageType type;
	
	@JsonProperty("nsInstanceId")
	String nsInstanceId;
	
	@JsonProperty("operationId")
	String operationId;

	/**
	 * @return the type
	 */
	public EngineMessageType getType() {
		return type;
	}

	/**
	 * @return the nsInstanceId
	 */
	public String getNsInstanceId() {
		return nsInstanceId;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
