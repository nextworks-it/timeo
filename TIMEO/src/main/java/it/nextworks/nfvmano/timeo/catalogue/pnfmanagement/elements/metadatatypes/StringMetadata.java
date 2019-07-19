package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;

public class StringMetadata extends PnfInstanceMetadata {
	
	private String value;

	
	
	
	/**
	 * @param value The value of the metadata info
	 */
	public StringMetadata(PnfInstance pnfInstance, String name, String value) {
		super(pnfInstance, name);
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
