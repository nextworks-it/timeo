package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.AddressType;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;


/**
 * This element represents a physical port in a physical equipment
 * 
 * @author nextworks
 *
 */
@Entity
public class PhysicalEquipmentPort implements DescriptorInformationElement {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@JsonIgnore
	@ManyToOne
	private PnfInstance pnf;
	
	private String portId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<AddressType, String> addresses = new HashMap<>();
	
	private boolean management;	//true if this is the port to be used to access the equipment for management purposes
	
	public PhysicalEquipmentPort() { }
	
	/**
	 * Constructor
	 * 
	 * @param pnf PNF instance this port belongs to
	 * @param portId ID of the port
	 * @param addresses addresses of the port, one per layer
	 * @param management
	 */
	public PhysicalEquipmentPort(PnfInstance pnf, 
			String portId,
			Map<AddressType, String> addresses,
			boolean management) {
		this.pnf = pnf;
		this.portId = portId;
		if (addresses != null) this.addresses = addresses;
		this.management = management;
	}

	/**
	 * @return the portId
	 */
	@JsonProperty("portId")
	public String getPortId() {
		return portId;
	}

	/**
	 * @return the addresses
	 */
	@JsonProperty("addresses")
	public Map<AddressType, String> getAddresses() {
		return addresses;
	}
	
	

	/**
	 * @return the management
	 */
	@JsonProperty("management")
	public boolean isManagement() {
		return management;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (portId == null) throw new MalformattedElementException("Physical equipment port without ID.");
	}

}
