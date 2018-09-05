package it.nextworks.nfvmano.timeo.rc.elements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This entity models a network path to interconnect a PoP
 * Gateway to another PoP Gateway or to an arbitrary node
 * in the transport network, in a domain that is external
 * to the DC. 
 * 
 * Traffic classifiers are still to be discussed.
 * 
 * @author nextworks
 *
 */
@Entity
public class InterDcNetworkPath {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private NsResourceSchedulingSolution nsRss;
	
	private String networkPathId;
	
	@OneToMany(mappedBy = "idnp", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<NetworkPathHop> hops = new ArrayList<>();
	
	//TODO: add SDM constraints

	public InterDcNetworkPath() { }
	
	/**
	 * Constructor
	 * 
	 * @param nsRss NS resource scheduling solution this interDC network path belongs to
	 * @param networkPathId ID of the network path
	 */
	public InterDcNetworkPath(NsResourceSchedulingSolution nsRss,
			String networkPathId) {
		this.nsRss = nsRss;
		this.networkPathId = networkPathId;
	}
	
	/**
	 * Constructor
	 * 
	 * @param networkPathId ID of the network path
	 * @param hops Hops of the network path
	 */
	public InterDcNetworkPath(String networkPathId,
			List<NetworkPathHop> hops) {
		this.networkPathId = networkPathId;
		if (hops != null) this.hops = hops;
	}

	/**
	 * @return the networkPathId
	 */
	public String getNetworkPathId() {
		return networkPathId;
	}

	/**
	 * @param networkPathId the networkPathId to set
	 */
	public void setNetworkPathId(String networkPathId) {
		this.networkPathId = networkPathId;
	}

	/**
	 * @return the hops
	 */
	public List<NetworkPathHop> getHops() {
		return hops;
	}

	
	
}
