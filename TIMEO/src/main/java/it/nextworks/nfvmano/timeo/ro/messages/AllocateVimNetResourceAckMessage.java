package it.nextworks.nfvmano.timeo.ro.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;

public class AllocateVimNetResourceAckMessage extends AllocationMessage {

	@JsonProperty("vimResponse")
	private AllocateNetworkResponse vimResponse;
	
	@JsonCreator
	public AllocateVimNetResourceAckMessage(@JsonProperty("vimResponse") AllocateNetworkResponse vimResponse) {
		this.type = AllocationMessageType.VIM_ACK_ALLOCATE_VNET_RESOURCE;
		this.vimResponse = vimResponse;
	}

	/**
	 * @return the vimResponse
	 */
	public AllocateNetworkResponse getVimResponse() {
		return vimResponse;
	}
	
	

}
