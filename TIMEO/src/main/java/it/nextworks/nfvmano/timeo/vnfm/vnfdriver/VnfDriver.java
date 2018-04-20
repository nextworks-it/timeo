package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import it.nextworks.nfvmano.libs.vnfconfig.interfaces.VnfConfigurationProviderInterface;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.VnfIndicatorProviderInterface;

public abstract class VnfDriver implements VnfConfigurationProviderInterface, VnfIndicatorProviderInterface {

	private VnfDriverType vnfDriverType;
	protected String vnfInstanceId;
	
	public VnfDriver(VnfDriverType vnfDriverType, String vnfInstanceId) {
		this.vnfDriverType = vnfDriverType;
		this.vnfInstanceId = vnfInstanceId;
	}

	/**
	 * @return the vnfDriverType
	 */
	public VnfDriverType getVnfDriverType() {
		return vnfDriverType;
	}

	/**
	 * @return the vnfInstanceId
	 */
	public String getVnfInstanceId() {
		return vnfInstanceId;
	}
	
	

}
