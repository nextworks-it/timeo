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
package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationProviderInterface;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.VnfIndicatorProviderInterface;

public abstract class VnfDriver implements VnfConfigurationProviderInterface, VnfIndicatorProviderInterface {

	private VnfDriverType vnfDriverType;
	protected String vnfInstanceId;
	
	public VnfDriver(VnfDriverType vnfDriverType, String vnfInstanceId) {
		this.vnfDriverType = vnfDriverType;
		this.vnfInstanceId = vnfInstanceId;
	}

	/**
	 * @return the vnfDriverType
	 */
	public VnfDriverType getVnfDriverType() {
		return vnfDriverType;
	}

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}
	
	

}
