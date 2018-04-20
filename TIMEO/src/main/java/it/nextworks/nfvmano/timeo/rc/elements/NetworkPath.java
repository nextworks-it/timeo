package it.nextworks.nfvmano.timeo.rc.elements;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This entity models a network path to interconnect two VMs
 * attached to the same virtual link.
 * 
 * @author nextworks
 *
 */
@Entity
public class NetworkPath {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@ManyToOne
	@JsonIgnore
	private NsResourceSchedulingSolution nsRss;
	
	private String networkPathId;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<NetworkPathEndPoint> endPoints = new ArrayList<>();
	
//	@Embedded
//	private NetworkPathEdges endPoints;	
	
	@OneToMany(mappedBy = "np", cascade=CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<NetworkPathHop> hops = new ArrayList<>();

	private String nsVirtualLinkDescriptorId;
	
	private boolean backup;

	public NetworkPath() {
		//JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsRss NS resource scheduling solution this network path belongs to
	 * @param networkPathId unique ID of the network path
	 * @param endPoints source and destination of the path
	 * @param hops list of hops along the path
	 * @param nsVirtualLinkDescriptorId ID of the VL interconnecting source and destination
	 * @param isBackup true if it is a backup path
	 */
	public NetworkPath(NsResourceSchedulingSolution nsRss,
			String networkPathId,
			List<NetworkPathEndPoint> endPoints,
			List<NetworkPathHop> hops,
			String nsVirtualLinkDescriptorId,
			boolean isBackup) {
		this.nsRss = nsRss;
		this.networkPathId = networkPathId;
		if (endPoints != null) this.endPoints = endPoints;
		this.nsVirtualLinkDescriptorId = nsVirtualLinkDescriptorId;
		if (hops != null) this.hops = hops;
		this.backup = isBackup;
	}
	
	/**
	 * Constructor
	 * 
	 * @param nsRss NS resource scheduling solution this network path belongs to
	 * @param networkPathId unique ID of the network path
	 * @param endPoints source and destination of the path
	 * @param nsVirtualLinkDescriptorId ID of the VL interconnecting source and destination
	 * @param isBackup true if it is a backup path
	 */
	public NetworkPath(NsResourceSchedulingSolution nsRss,
			String networkPathId,
			List<NetworkPathEndPoint> endPoints,
			String nsVirtualLinkDescriptorId,
			boolean isBackup) {
		this.nsRss = nsRss;
		this.networkPathId = networkPathId;
		if (endPoints != null) this.endPoints = endPoints;
		this.nsVirtualLinkDescriptorId = nsVirtualLinkDescriptorId;
		this.backup = isBackup;
	}
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nsRss
	 */
	public NsResourceSchedulingSolution getNsRss() {
		return nsRss;
	}

	/**
	 * @return the networkPathId
	 */
	public String getNetworkPathId() {
		return networkPathId;
	}

	/**
	 * @return the endPoints
	 */
	public List<NetworkPathEndPoint> getEndPoints() {
		return endPoints;
	}

	/**
	 * @return the hops
	 */
	public List<NetworkPathHop> getHops() {
		return hops;
	}

	/**
	 * @return the nsVirtualLinkDescriptorId
	 */
	public String getNsVirtualLinkDescriptorId() {
		return nsVirtualLinkDescriptorId;
	}

	/**
	 * @return the isBackup
	 */
	@JsonProperty("backup")
	public boolean isBackup() {
		return backup;
	}
}
