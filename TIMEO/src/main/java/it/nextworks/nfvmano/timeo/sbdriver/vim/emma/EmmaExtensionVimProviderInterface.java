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

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;

public interface EmmaExtensionVimProviderInterface {

	/**
	 * Set the power state of a given list of hosts in an atomic action.
	 * If some configuration fails the method implicitly rolls-back. 
	 * 
	 * @param powerStates map with key host ID and value desired power state
	 * @throws MethodNotImplementedException if the method is not implemented or not supported
	 * @throws FailedOperationException if the operation fails
 	 */
	public void setPowerState(Map<String, PowerState> powerStates) throws MethodNotImplementedException, FailedOperationException;
	
	/**
	 * Retrieves the current power state for a given list of hosts
	 * 
	 * @param hostIds ID of the hosts
	 * @return a map with key host ID and value power state
	 * @throws MethodNotImplementedException if the method is not implemented or not supported
	 * @throws FailedOperationException 
	 */
	public Map<String, PowerState> getPowerState(List<String> hostIds) throws MethodNotImplementedException;
	
	/**
	 * Retrieves the power related static information for all the hosts managed by the VIM 
	 * 
	 * 
	 * @return the requested power related information
	 * @throws MethodNotImplementedException if the method is not implemented or not supported
	 */
	public List<HostPowerStaticInfo> getPowerStateInfo() throws MethodNotImplementedException;
	
	/**
	 * Retrieves the power related static information for all the given hosts managed by the VIM 
	 * 
	 * @param hostIds IDs of the hosts
	 * @return the requested power related information
	 * @throws MethodNotImplementedException if the method is not implemented or not supported
	 */
	public List<HostPowerStaticInfo> getPowerStateInfo(List<String> hostIds) throws MethodNotImplementedException;
	
}
