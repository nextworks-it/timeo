package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;


public class InstantiateVimComputeResourceAckMessage extends VnfmMessage {
	
	@JsonProperty("notification")
	private AllocateComputeResponse notification;

	@JsonCreator
	public InstantiateVimComputeResourceAckMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("notification") AllocateComputeResponse notification) {
		this.type = VnfmMessageType.INSTANTIATE_VIM_COMPUTING_RESOURCE_ACK;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.notification = notification;
	}

	/**
	 * @return the notification
	 */
	public AllocateComputeResponse getNotification() {
		return notification;
	}

	

	
	
}
