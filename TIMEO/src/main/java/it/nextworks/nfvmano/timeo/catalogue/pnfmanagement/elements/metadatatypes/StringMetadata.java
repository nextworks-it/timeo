package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes;

import java.io.Serializable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;

@Entity
@DiscriminatorValue("String")
public class StringMetadata extends PnfInstanceMetadata {
	
	private String stringValue;
	
		
	/**
	 * @param pnfInstance the information belongs to
	 * @param value The name of the metadata info
	 * @param value The value of the metadata info
	 */
	@JsonCreator
	public StringMetadata(@JsonProperty("pnfInstance")PnfInstance pnfInstance,
			@JsonProperty(value="name", required=true)String name, 
			@JsonProperty("value")String value) {
		super(pnfInstance, name, value);
		
	}

	/**
	 * @return the value
	 */
	@Override
	public String getValue() {
		return stringValue;
	}
	
	
	@Override
	public void setValue(@JsonDeserialize(as = String.class)Serializable value) {
		if(value instanceof String) {
			this.stringValue= (String)value;
		}
	}

	@Override
	public PnfInstanceMetadata setPnfInstance(PnfInstance pnfInstance) {
		
		return new StringMetadata(pnfInstance, getName(), getValue());
	}
	
	

}
