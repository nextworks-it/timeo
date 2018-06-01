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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;

/**
 * Static information related to power consumption models and capabilities for servers
 * 
 * @author nextworks
 *
 */
public class HostPowerStaticInfo {

	private String hostId;
	private String zoneId;
	private String macAddress;
	private boolean powerStateConfigEnabled;
	private List<PowerState> supportedPowerState = new ArrayList<>();
	private Map<PowerState, PowerStateParameters> powerStateParameters = new HashMap<>();
	
	
	/**
	 * Constructor
	 * 
	 * @param hostId ID of the physical server in the VIM environment
	 * @param zoneId ID of the zone the given host belongs to
	 * @param macAddress MAC address of the server
	 * @param powerStateConfigEnabled true if the power state can be configured on the server
	 * @param supportedPowerState list of power states that can be configured on the server
	 * @param powerStateParameters power state parameters to compute power consumption in each power state
	 */
	public HostPowerStaticInfo(String hostId,
			String zoneId,
			String macAddress,
			boolean powerStateConfigEnabled,
			List<PowerState> supportedPowerState,
			Map<PowerState, PowerStateParameters> powerStateParameters) {
		this.hostId = hostId;
		this.zoneId = zoneId;
		this.macAddress = macAddress;
		this.powerStateConfigEnabled = powerStateConfigEnabled;
		if (supportedPowerState != null) this.supportedPowerState = supportedPowerState;
		if (powerStateParameters != null) this.powerStateParameters = powerStateParameters;
	}


	/**
	 * @return the hostId
	 */
	public String getHostId() {
		return hostId;
	}


	/**
	 * @return the macAddress
	 */
	public String getMacAddress() {
		return macAddress;
	}


	/**
	 * @return the powerStateConfigEnabled
	 */
	public boolean isPowerStateConfigEnabled() {
		return powerStateConfigEnabled;
	}


	/**
	 * @return the supportedPowerState
	 */
	public List<PowerState> getSupportedPowerState() {
		return supportedPowerState;
	}


	/**
	 * @return the powerStateParameters
	 */
	public Map<PowerState, PowerStateParameters> getPowerStateParameters() {
		return powerStateParameters;
	}


	/**
	 * @return the zoneId
	 */
	public String getZoneId() {
		return zoneId;
	}
	
	

}
