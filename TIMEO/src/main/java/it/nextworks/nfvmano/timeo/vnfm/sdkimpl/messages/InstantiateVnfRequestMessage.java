package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.orvnfm.vnflcm.interfaces.messages.InstantiateVnfRequest;

public class InstantiateVnfRequestMessage extends VnfmMessage {
	
	@JsonProperty("request")
	private InstantiateVnfRequest request;

	@JsonCreator
	public InstantiateVnfRequestMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("request") InstantiateVnfRequest request) {
		this.type = VnfmMessageType.ALLOCATE_VNF;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public InstantiateVnfRequest getRequest() {
		return request;
	}

	
	
}
