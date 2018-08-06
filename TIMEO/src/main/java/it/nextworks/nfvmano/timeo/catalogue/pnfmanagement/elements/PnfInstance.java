package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.AddressType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This class represents a PNF instance, as available in the NFVI.
 * 
 * @author nextworks
 *
 */
@Entity
public class PnfInstance implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	private String pnfInstanceId;
	private String pnfdId;
	private String pnfdVersion;
	private String description;
	private String location;	//this will need to be updated
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "pnf", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	List<PhysicalEquipmentPort> ports = new ArrayList<>();
	
	public PnfInstance() { }

	/**
	 * Constructor
	 * 
	 * @param pnfInstanceId ID of the PNF instance.
	 * @param pnfdId ID of the PNFD defining the PNF.
	 * @param pnfdVersion version of the PNFD defining the PNF.
	 * @param description Description of the PNF instance.
	 * @param location Geographical location where the PNF is deployed.
	 */
	public PnfInstance(String pnfInstanceId,
			String pnfdId,
			String pnfdVersion,
			String description,
			String location) {
		this.pnfInstanceId = pnfInstanceId;
		this.pnfdId = pnfdId;
		this.pnfdVersion = pnfdVersion;
		this.description = description;
		this.location = location;
	}
	
	/**
	 * @return the pnfInstanceId
	 */
	@JsonProperty("pnfInstanceId")
	public String getPnfInstanceId() {
		return pnfInstanceId;
	}



	/**
	 * @return the pnfdId
	 */
	@JsonProperty("pnfdId")
	public String getPnfdId() {
		return pnfdId;
	}



	/**
	 * @return the pnfdVersion
	 */
	@JsonProperty("pnfdVersion")
	public String getPnfdVersion() {
		return pnfdVersion;
	}

	/**
	 * @return the description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}



	/**
	 * @return the location
	 */
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}



	/**
	 * @return the ports
	 */
	@JsonProperty("ports")
	public List<PhysicalEquipmentPort> getPorts() {
		return ports;
	}

	@JsonIgnore
	public String getManagementIpAddress() {
		for (PhysicalEquipmentPort p : ports) {
			if (p.isManagement()) return p.getAddresses().get(AddressType.IP_ADDRESS);
		}
		return null;
	}


	@Override
	public void isValid() throws MalformattedElementException {
		if (pnfInstanceId == null) throw new MalformattedElementException("PNF instance without ID.");
		if (pnfdId == null) throw new MalformattedElementException("PNF instance without PNFD ID.");
		if (pnfdVersion == null) throw new MalformattedElementException("PNF instance without PNFD version.");
		if ((ports == null) || (ports.isEmpty())) throw new MalformattedElementException("PNF instance without ports. At least one port is needed to access the PNF.");
	}
	
}
