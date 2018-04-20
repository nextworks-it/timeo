package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminateNsVlsMessage extends AllocationMessage {

	
	@JsonProperty("operationId")
	String operationId;
	
	
	@JsonCreator
	public TerminateNsVlsMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId) {
		this.type = AllocationMessageType.REMOVE_NS_VLS;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}

	
	
}
