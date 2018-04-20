package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotifyComputationReleaseMessage extends EngineMessage {

	@JsonCreator
	public NotifyComputationReleaseMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId) {
		this.type = EngineMessageType.NOTIFY_COMPUTATION_RELEASE;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
	}
	
	

}
