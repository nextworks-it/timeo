package it.nextworks.nfvmano.timeo.vnfm.sdkimpl.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;


public class TerminateVimComputeResourceAckMessage extends VnfmMessage {
	
	@JsonProperty("notification")
	private TerminateComputeResponse notification;

	@JsonCreator
	public TerminateVimComputeResourceAckMessage(@JsonProperty("vnfInstanceId") String vnfInstanceId,
			@JsonProperty("operationId") String operationId,
			@JsonProperty("notification") TerminateComputeResponse notification) {
		this.type = VnfmMessageType.TERMINATE_VIM_COMPUTING_RESOURCE_ACK;
		this.vnfInstanceId = vnfInstanceId;
		this.operationId = operationId;
		this.notification = notification;
	}

	/**
	 * @return the notification
	 */
	public TerminateComputeResponse getNotification() {
		return notification;
	}

	

	
	
}
