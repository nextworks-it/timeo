package it.nextworks.nfvmano.timeo.sbdriver.vim;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.openstack4j.model.network.NetworkType;

@Entity
public class Vim {

	@Id
	@GeneratedValue
	private Long id;
	
	private String vimId;
	private VimType type;
	private String tenant;
	private String url;
	private String domain;
	private String username;
	private String password;
	private String defaultExternalNetworkId;
	private String defaultExternalRouterId;
	private String networkNodeMacAddress;
	private String keyPair;
	private String providerId;
	private String wrapperIp;
	private int wrapperPort;
	private String physnet;
	private NetworkType netType;

	
	public Vim() {
		//JPA only
	}
	

	/**
	 * Constructor
	 * 
	 * @param vimId unique ID of the VIM 
	 * @param type	type of VIM
	 * @param tenant tenant
	 * @param url url where the VIM is reachable
	 * @param domain domain to be used in authentication
	 * @param username username to be used in authentication
	 * @param password password to be used in authentication
	 * @param keyPair keyPair to be injected into VMs
	 * @param defaultExternalNetworkId ID of the external network to be used to interconnect NS SAPDs
	 * @param defaultExternalRouterId ID of the external router to be used to interconnect NS SAPDs
	 * @param providerId Provider ID
	 * @param wrapperIp Ip address of the OS Wrapper
	 * @param wrapperPort Listening port of the OS Wrapper
	 * @param networkNodeMacAddress MAC address of the network node. Used to retrieve the node to forward outgoing external traffic.
	 */
	public Vim(String vimId, 
			VimType type,
			String tenant,
			String url,
			String domain,
			String username,
			String password,
			String keyPair,
			String defaultExternalNetworkId,
			String defaultExternalRouterId,
			String providerId,
			String wrapperIp,
			int wrapperPort,
			String networkNodeMacAddress,
			String physnet) {
		this.vimId = vimId;
		this.type = type;
		this.tenant = tenant;
		this.url = url;
		this.domain = domain;
		this.username = username;
		this.password = password;
		this.keyPair = keyPair;
		this.defaultExternalNetworkId = defaultExternalNetworkId;
		this.defaultExternalRouterId = defaultExternalRouterId;
		this.providerId = providerId;
		this.wrapperIp = wrapperIp;
		this.wrapperPort = wrapperPort;
		this.networkNodeMacAddress = networkNodeMacAddress;
		this.physnet = physnet;
		this.netType = NetworkType.VLAN;
	}
	
	public Vim(String vimId, 
			VimType type,
			String tenant,
			String url,
			String domain,
			String username,
			String password,
			String defaultExternalNetworkId,
			String defaultExternalRouterId,
			String providerId,
			String wrapperIp,
			int wrapperPort,
			String networkNodeMacAddress,
			String physnet) {
		this.vimId = vimId;
		this.type = type;
		this.tenant = tenant;
		this.url = url;
		this.domain = domain;
		this.username = username;
		this.password = password;
		this.defaultExternalNetworkId = defaultExternalNetworkId;
		this.defaultExternalRouterId = defaultExternalRouterId;
		this.providerId = providerId;
		this.wrapperIp = wrapperIp;
		this.wrapperPort = wrapperPort;
		this.networkNodeMacAddress = networkNodeMacAddress;
		this.physnet = physnet;
		this.netType = NetworkType.VLAN;
	}
	

	public String getWrapperIp() {
		return wrapperIp;
	}

	public int getWrapperPort() {
		return wrapperPort;
	}

	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @return the vimId
	 */
	public String getVimId() {
		return vimId;
	}

	/**
	 * @return the type
	 */
	public VimType getType() {
		return type;
	}

	/**
	 * @return the tenant
	 */
	public String getTenant() {
		return tenant;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the defaultExternalNetworkId
	 */
	public String getDefaultExternalNetworkId() {
		return defaultExternalNetworkId;
	}

	/**
	 * @return the defaultExternalRouterId
	 */
	public String getDefaultExternalRouterId() {
		return defaultExternalRouterId;
	}


	/**
	 * @return the networkNodeMacAddress
	 */
	public String getNetworkNodeMacAddress() {
		return networkNodeMacAddress;
	}


	public String getKeyPair() {
		return keyPair;
	}


	public String getPhysnet() {
		return physnet;
	}


	public NetworkType getNetType() {
		return netType;
	}
	
	
	

}
