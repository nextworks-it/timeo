package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;

public class AllocateNsVlsMessage extends AllocationMessage {

	@JsonProperty("request")
	private InstantiateNsRequest request;
	
	@JsonProperty("operationId")
	String operationId;
	
	
	@JsonCreator
	public AllocateNsVlsMessage(@JsonProperty("nsInstanceId") String nsInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateNsRequest request) {
		this.type = AllocationMessageType.ALLOCATE_NS_VLS;
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
