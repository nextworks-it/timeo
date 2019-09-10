package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.BluespaceBBUOperationModeMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.BooleanMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.IntegerMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.StringMetadata;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY
 )
@JsonSubTypes({
        @Type(value = StringMetadata.class, name = "String"),
        @Type(value = IntegerMetadata.class, name = "Integer"),
        @Type(value = BooleanMetadata.class, name = "Boolean"),
        @Type(value = BluespaceBBUOperationModeMetadata.class, name = "BBUOperationMode"),
})
@Entity
@Inheritance
@DiscriminatorColumn(name="type")
public abstract class PnfInstanceMetadata {
	

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
    private PnfInstance pnfInstance;
	
	
	private String name;
	
	

	
	/**
	 * JPA compatibility
	 */
	public PnfInstanceMetadata() {
		
	}
	
	/**
	 * @param pnfInstance 
	 * @param name
	 * @param value
	 */
	public PnfInstanceMetadata(PnfInstance pnfInstance,String name, Serializable value) {
		super();
		this.name = name;
		this.pnfInstance=pnfInstance;
		this.setValue(value);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pnfInstance
	 */
	public PnfInstance getPnfInstance() {
		return pnfInstance;
	}
	
	/**
	 * @return the value
	 */
	public abstract Serializable getValue();

	/**
	 * @param value the value to set
	 */
	public abstract void setValue(Serializable value) ;

	public abstract PnfInstanceMetadata setPnfInstance(PnfInstance pnfInstance);

}
