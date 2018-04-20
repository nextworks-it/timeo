package it.nextworks.nfvmano.timeo.rc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;



public class ComputationReserveMessage extends ComputationMessage {

	@JsonProperty("request")
	private InstantiateNsRequest request;
	
	
	@JsonCreator
	public ComputationReserveMessage(@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateNsRequest request) {
		this.type = ComputationMessageType.RESERVE;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public InstantiateNsRequest getRequest() {
		return request;
	}
	
	

}
