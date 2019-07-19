package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;

public class BooleanMetadata extends PnfInstanceMetadata {

	
	private boolean value;

	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	public BooleanMetadata(boolean value) {
		super();
		this.value = value;
	}
	
	
}
