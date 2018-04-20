package it.nextworks.nfvmano.timeo.rc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



/**
 * Abstract message sent to the Resource Scheduling Manager
 * 
 * @author nextworks
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "msgType")
@JsonSubTypes({
	@Type(value = ComputationReserveMessage.class, 	name = "RESERVE"),
	@Type(value = ComputationReleaseMessage.class, 	name = "RELEASE"),
})
public abstract class ComputationMessage {

	@JsonProperty("type")
	ComputationMessageType type;
	
	@JsonProperty("operationId")
	String operationId;

	/**
	 * @return the type
	 */
	public ComputationMessageType getType() {
		return type;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
