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
package it.nextworks.nfvmano.timeo.sbdriver.vim.emma;

/**
 * Static parameters to model power consumption in servers for each power state. 
 * 
 * @author nextworks
 *
 */
public class PowerStateParameters {

	private int idleHost;
	private int idleVm;
	private int activeVm;
	private int trafficVm;
	
	public PowerStateParameters(int idleHost, int idleVm, int trafficVm, int activeVm) {
		this.idleHost = idleHost;
		this.idleVm = idleVm;
		this.trafficVm = trafficVm;
		this.activeVm = activeVm;
	}

	/**
	 * @return the idleHost
	 */
	public int getIdleHost() {
		return idleHost;
	}

	/**
	 * @return the idleVm
	 */
	public int getIdleVm() {
		return idleVm;
	}

	/**
	 * @return the activeVm
	 */
	public int getActiveVm() {
		return activeVm;
	}

	public int getTrafficVm(){
		return trafficVm;
	}
}
