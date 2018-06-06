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

import it.nextworks.nfvmano.timeo.sbdriver.SbDriver;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriverType;

public abstract class SdnControllerPlugin extends SbDriver implements SdnControllerProviderInterface {

	private SdnControllerType sdnControllerType;
	private SdnController controller;
	
	/**
	 * Constructor
	 * 
	 * @param sdnControllerType
	 * @param controller
	 */
	public SdnControllerPlugin(SdnControllerType sdnControllerType,
			SdnController controller) {
		super(controller.getSdnControllerId(), SbDriverType.SB_SDN_CONTROLLER);
		this.sdnControllerType = controller.getSdnControllerType();
		this.controller = controller;
	}

	/**
	 * @return the sdnControllerType
	 */
	public SdnControllerType getSdnControllerType() {
		return sdnControllerType;
	}

	/**
	 * @return the controller
	 */
	public SdnController getController() {
		return controller;
	}
	
	

}
