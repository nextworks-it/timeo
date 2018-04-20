package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;

public class SetupUnderlyingConnectivityMessage extends AllocationMessage {

	@JsonProperty("request")
	private InstantiateNsRequest request;
	
	@JsonProperty("operationId")
	String operationId;
	
	@JsonCreator
	public SetupUnderlyingConnectivityMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateNsRequest request) {
		this.type = AllocationMessageType.SETUP_UNDERLYING_CONNECTIVITY;
		this.nsInstanceId = nsInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public InstantiateNsRequest getRequest() {
		return request;
	}

	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	

}
