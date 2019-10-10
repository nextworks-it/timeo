package it.nextworks.nfvmano.timeo.rc.elements;

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

/**
 * This information element models a PNF selected by the allocation 
 * algorithms for the instantiation of a given NS, including its 
 * configuration parameters, where relevant 
 * 
 * 
 * @author nextworks
 *
 */
@Entity
public class PnfAllocation {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private NsResourceSchedulingSolution nsRss;
	
	@ManyToOne
	@JsonIgnore
	private ScaleNsResourceAllocation sNSRA;
	
	//input
	private String pnfdId;
	private String pnfdVersion;
	private int index;
	
	//output
	private String pnfInstanceId;
	private String pnfProfileId;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> parameters = new HashMap<>();
	
	public PnfAllocation() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsRss NS resource solution this PNF allocation belongs to
	 * @param pnfdId ID of the PNFD defining the PNF
	 * @param pnfdVersion Version of the PNFD defining the PNF
	 * @param index index of the PNF - in case multiple instances of the same PNF type must be included
	 * @param pnfInstanceId ID of the PNF instance - i.e. physical equipment - selected for the given PNF
	 * @param pnfProfileId ID of the PNF profile selected by the algorithm - FFS
	 * @param parameters PNF configuration parameter selected by the algorithm
	 */
	public PnfAllocation(NsResourceSchedulingSolution nsRss,
			String pnfdId, 
			String pnfdVersion,
			int index,
			String pnfInstanceId,
			String pnfProfileId,
			Map<String, String> parameters) {
		this.nsRss = nsRss;
		this.pnfdId = pnfdId;
		this.pnfdVersion = pnfdVersion;
		this.index = index;
		this.pnfInstanceId = pnfInstanceId;
		this.pnfProfileId = pnfProfileId;
		if (parameters != null) this.parameters = parameters;
	}

	/**
	 * @return the nsRss
	 */
	public NsResourceSchedulingSolution getNsRss() {
		return nsRss;
	}

	/**
	 * @return the pnfdId
	 */
	public String getPnfdId() {
		return pnfdId;
	}

	/**
	 * @return the pnfdVersion
	 */
	public String getPnfdVersion() {
		return pnfdVersion;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the pnfInstanceId
	 */
	public String getPnfInstanceId() {
		return pnfInstanceId;
	}

	/**
	 * @return the pnfProfileId
	 */
	public String getPnfProfileId() {
		return pnfProfileId;
	}

	/**
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}
	
	

}
