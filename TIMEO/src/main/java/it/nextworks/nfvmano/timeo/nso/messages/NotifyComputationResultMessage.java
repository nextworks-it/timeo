package it.nextworks.nfvmano.timeo.nso.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;

public class NotifyComputationResultMessage extends EngineMessage {

	@JsonProperty("solution")
	NsResourceSchedulingSolution solution;
	
	@JsonCreator
	public NotifyComputationResultMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId, 
			@JsonProperty("solution") NsResourceSchedulingSolution solution) {
		this.type = EngineMessageType.NOTIFY_COMPUTATION_RESULT;
		this.nsInstanceId = nsInstanceId;
		this.solution = solution;
		this.operationId = operationId;
	}

	/**
	 * @return the solution
	 */
	public NsResourceSchedulingSolution getSolution() {
		return solution;
	}
	
	

}
