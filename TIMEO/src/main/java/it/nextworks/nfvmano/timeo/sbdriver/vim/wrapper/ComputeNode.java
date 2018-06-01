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
package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;

public class ComputeNode {

	private String id;
	private String name;
	private float idle_pc;
	private String mac_address;
	private String ip_address;
	private String mgmt_ip_address;
	private PowerState power_state;
	
	
	public ComputeNode(){
		
	}
	
	public ComputeNode(
				String id,
				String name,
				float idle_pc,
				String mac_address,
				String ip_address,
				String mgmt_ip_address,
				PowerState power_state
			){
		this.id = id;
		this.name = name;
		this.idle_pc = idle_pc;
		this.mac_address = mac_address;
		this.ip_address = ip_address;
		this.mgmt_ip_address = mgmt_ip_address;
		this.power_state = power_state;
	}


	public PowerState getPower_state() {
		return power_state;
	}


	public void setPower_state(PowerState power_state) {
		this.power_state = power_state;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public float getIdle_pc() {
		return idle_pc;
	}


	public String getMac_address() {
		return mac_address;
	}


	public String getIp_address() {
		return ip_address;
	}


	public String getMgmt_ip_address() {
		return mgmt_ip_address;
	}
	
	
}
