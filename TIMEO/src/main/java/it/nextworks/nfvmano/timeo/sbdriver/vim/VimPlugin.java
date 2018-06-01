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
package it.nextworks.nfvmano.timeo.sbdriver.vim;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.NetworkForwardingPathManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualComputeFlavourManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualComputeResourceManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedNetworkResourceManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourceQuotaManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesCapacityManagementProviderInterface;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.VirtualisedResourcesInformationManagementProviderInterface;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriver;
import it.nextworks.nfvmano.timeo.sbdriver.SbDriverType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.emma.EmmaExtensionVimProviderInterface;

public abstract class VimPlugin extends SbDriver 
implements 	VirtualisedNetworkResourceManagementProviderInterface,
			VirtualComputeFlavourManagementProviderInterface,
			VirtualComputeResourceManagementProviderInterface,
			VirtualisedResourcesInformationManagementProviderInterface,
			VirtualisedResourcesCapacityManagementProviderInterface,
			VirtualisedResourceQuotaManagementProviderInterface,
			EmmaExtensionVimProviderInterface,
			NetworkForwardingPathManagementProviderInterface {

	VimType vimType;
	Vim vim;
	
	/**
	 * Constructor
	 * 
	 * @param vimType	VIM type
	 * @param vim 		VIM
	 */
	public VimPlugin(VimType vimType,
			Vim vim) {
		super(vim.getVimId(), SbDriverType.SB_VIM);
		this.vimType = vimType;
		this.vim = vim;
	}

	/**
	 * @return the type
	 */
	public VimType getVimType() {
		return vimType;
	}

	/**
	 * @return the vim
	 */
	public Vim getVim() {
		return vim;
	}

	
}
