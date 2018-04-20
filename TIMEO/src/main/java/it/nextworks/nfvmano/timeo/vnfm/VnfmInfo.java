package it.nextworks.nfvmano.timeo.vnfm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VnfmInfo {

	@Id
	@GeneratedValue
	private Long id;
	
	private VnfmType type;
	private String name;
	
	public VnfmInfo() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param type	type of VNFM
	 * @param name	name of the VNFM
	 */
	public VnfmInfo(VnfmType type,
			String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * @return the type
	 */
	public VnfmType getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
