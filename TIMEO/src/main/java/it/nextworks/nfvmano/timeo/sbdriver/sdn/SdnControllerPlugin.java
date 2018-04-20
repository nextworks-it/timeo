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
