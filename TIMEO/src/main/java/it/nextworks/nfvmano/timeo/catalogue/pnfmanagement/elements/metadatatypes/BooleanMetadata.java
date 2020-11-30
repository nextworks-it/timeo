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
@DiscriminatorValue("Boolean")
public class BooleanMetadata extends PnfInstanceMetadata {

	private Boolean booleanValue;
	
	
	
	/**
	 * @return the value
	 */
	@Override
	public Boolean getValue() {
		return booleanValue;
	}

	

	/**
	 * @param value
	 */
	@JsonCreator
	public BooleanMetadata(@JsonProperty("pnfInstance")PnfInstance pnfInstance,
			@JsonProperty(value="name", required=true)String name, 
			@JsonProperty("value")boolean value) {
		super(pnfInstance, name, new Boolean(value));
		
	}
	
	

	@Override
	public void setValue(@JsonDeserialize(as = Boolean.class)Serializable value) {
		if(value instanceof Boolean) {
			this.booleanValue=(Boolean) value;
		}
	}



	@Override
	public PnfInstanceMetadata setPnfInstance(PnfInstance pnfInstance) {
		
		return new BooleanMetadata(pnfInstance, getName(), getValue());
	}
	
	
}
