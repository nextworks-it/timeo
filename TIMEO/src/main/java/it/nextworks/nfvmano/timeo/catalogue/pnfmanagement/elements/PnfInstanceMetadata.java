package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.BooleanMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.IntegerMetadata;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.metadatatypes.StringMetadata;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
@JsonSubTypes({
        @Type(value = StringMetadata.class, name = "String"),
        @Type(value = IntegerMetadata.class, name = "Integer"),
        @Type(value = BooleanMetadata.class, name = "Boolean"),
})
@Entity
public class PnfInstanceMetadata {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
    private PnfInstance pnfInstance;
	
	private String name;

	/**
	 * @param pnfInstance 
	 * @param name
	 */
	public PnfInstanceMetadata(PnfInstance pnfInstance,String name) {
		super();
		this.name = name;
		this.pnfInstance=pnfInstance;
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
	
	

}
