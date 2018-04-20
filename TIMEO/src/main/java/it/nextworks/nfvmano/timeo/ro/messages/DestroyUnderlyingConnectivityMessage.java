package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DestroyUnderlyingConnectivityMessage extends AllocationMessage {

	@JsonProperty("operationId")
	String operationId;
	
	@JsonCreator
	public DestroyUnderlyingConnectivityMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId) {
		this.type = AllocationMessageType.REMOVE_UNDERLYING_CONNECTIVITY;
		this.operationId = operationId;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
