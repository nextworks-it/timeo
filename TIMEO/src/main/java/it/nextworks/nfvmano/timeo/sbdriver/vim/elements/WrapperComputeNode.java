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
package it.nextworks.nfvmano.timeo.sbdriver.vim.elements;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;

/**
 * Created by Marco Capitani on 22/06/17.
 *
 * @author Marco Capitani(m.capitani AT nextworks.it)
 */

public class WrapperComputeNode {

	public WrapperComputeNode() {
	}

	/**
	 * Available RAM in MB
	 */
	@JsonProperty("vRAM")
	public int vRam;

	@JsonProperty("idle_pc")
	public double idlePc;

	@JsonProperty("flavors")
	public List<WrapperFlavors> flavors;

	@JsonProperty("mac")
	public String mac;

	/**
	 * Available hdd size in GB
	 */
	@JsonProperty("vDisk")
	public int vDisk;

	@JsonProperty("zoneId")
	public String zoneId;

	@JsonProperty("hostId")
	public String hostId;

	@JsonProperty("vCPU")
	public int vCpu;

	@JsonProperty("power_state")
	public PowerState powerState;

	public int getvRam() {
		return vRam;
	}

	public double getIdlePc() {
		return idlePc;
	}

	public List<WrapperFlavors> getFlavors() {
		return flavors;
	}

	public String getMac() {
		return mac;
	}

	public int getvDisk() {
		return vDisk;
	}

	public String getZoneId() {
		return zoneId;
	}

	public String getHostId() {
		return hostId;
	}

	public int getvCpu() {
		return vCpu;
	}

	public PowerState getPowerState() {
		return powerState;
	}

	

}