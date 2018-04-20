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
