/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
