package it.nextworks.nfvmano.timeo.ro;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.AllocateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vcompute.TerminateComputeResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.AllocateNetworkResponse;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.messages.vnet.TerminateNetworkResponse;

public interface AsynchronousVimNotificationInterface {
	
	//Network resources
	public void notify(AllocateNetworkResponse notification);
	public void notify(TerminateNetworkResponse notification);
	
	//Computing resources
	public void notify(AllocateComputeResponse notification);
	public void notify(TerminateComputeResponse notification);
	
}
