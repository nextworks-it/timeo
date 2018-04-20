package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;

public class DummySdnControllerPlugin extends SdnControllerPlugin {

	public DummySdnControllerPlugin(SdnController controller) {
		super(SdnControllerType.SDN_CONTROLLER_DUMMY, controller);
	}

	@Override
	public NetworkTopology getNetworkTopology() throws NotExistingEntityException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}

	@Override
	public String setPowerState(String deviceId, PowerState powerState, SdnControllerConsumerInterface consumer) 
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public void setPowerState(Map<String,PowerState> devicesPowerState) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public String setupPaths(List<SbNetworkPath> networkPath, SdnControllerConsumerInterface consumer)
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}
	
	@Override
	public String removePaths(List<String> networkPathIds, SdnControllerConsumerInterface consumer) 
			throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException {
		//TODO:
		throw new MethodNotImplementedException();
	}
	
}
