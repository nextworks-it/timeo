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
@DiscriminatorValue("Integer")
public class IntegerMetadata extends PnfInstanceMetadata {

	
	private Integer integerValue;

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return integerValue;
	}

	
	/**
	 * @param value
	 */
	@JsonCreator
	public IntegerMetadata(@JsonProperty("pnfInstance")PnfInstance pnfInstance,
			@JsonProperty(value="name", required=true)String name, 
			@JsonProperty("value")int value) {
		super(pnfInstance, name, new Integer(value));
		
	}
	
	/**
	 * JPA
	 */
	public IntegerMetadata() {
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public void setValue(@JsonDeserialize(as = Integer.class)Serializable value) {
		if (value instanceof Integer) {
			this.integerValue=(Integer) value;
		}
		
	}
	
	@Override
	public PnfInstanceMetadata setPnfInstance(PnfInstance pnfInstance) {
		
		return new IntegerMetadata(pnfInstance, getName(), getValue());
	}
	
	
	
}
