package it.nextworks.nfvmano.timeo.sbdriver;

public abstract class SbDriver {

	private String sbDriverId;
	private SbDriverType sbDriverType;
	
	/**
	 * Constructor
	 * 
	 * @param sbDriverId ID of the south bound driver
	 * @param type type of the south bound driver
	 */
	public SbDriver(String sbDriverId,
			SbDriverType type) {
		this.sbDriverId = sbDriverId;
		this.sbDriverType = type;
	}

	/**
	 * @return the sbDriverId
	 */
	public String getSbDriverId() {
		return sbDriverId;
	}

	/**
	 * @return the sbDriverType
	 */
	public SbDriverType getSbDriverType() {
		return sbDriverType;
	}

}
