package it.nextworks.nfvmano.timeo.ro;


import it.nextworks.nfvmano.libs.common.enums.VimResourceStatus;
import it.nextworks.nfvmano.libs.common.enums.VimResourceType;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

public class PolledResource {
	
	String resourceId;
	VimResourceType resourceType; 
	VimResourceStatus expectedStatus; 
	
	VimPlugin vimPlugin; 
	AsynchronousVimNotificationInterface listener;

	
	/**
	 * Constructor
	 * 
	 * @param resourceId	ID of the VIM resource to be polled
	 * @param resourceType	type of the VIM resource to be polled
	 * @param expectedStatus expected status of the resource - when the resource reaches this status a notification must be sent to the listener
	 * @param vimPlugin	VIM plugin to be used to poll the resource
	 * @param listener entity which must be advertised when the resource reaches the desired status
	 */
	public PolledResource(String resourceId,
			VimResourceType resourceType, 
			VimResourceStatus expectedStatus,
			VimPlugin vimPlugin,
			AsynchronousVimNotificationInterface listener) {
		this.resourceId = resourceId;
		this.expectedStatus = expectedStatus;
		this.resourceType = resourceType;
		this.vimPlugin = vimPlugin;
		this.listener = listener;
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @return the resourceType
	 */
	public VimResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * @return the expectedStatus
	 */
	public VimResourceStatus getExpectedStatus() {
		return expectedStatus;
	}

	/**
	 * @return the vimPlugin
	 */
	public VimPlugin getVimPlugin() {
		return vimPlugin;
	}

	/**
	 * @return the listener
	 */
	public AsynchronousVimNotificationInterface getListener() {
		return listener;
	}

	
	
}
