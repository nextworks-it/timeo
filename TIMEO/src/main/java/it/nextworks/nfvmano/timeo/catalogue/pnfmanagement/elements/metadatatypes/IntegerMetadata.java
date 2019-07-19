package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;

public class IntegerMetadata extends PnfInstanceMetadata {

	private int value;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param value
	 */
	public IntegerMetadata(PnfInstance pnfInstance, String name, int value) {
		super(pnfInstance, name);
		this.value = value;
	}
	
	
	
}
