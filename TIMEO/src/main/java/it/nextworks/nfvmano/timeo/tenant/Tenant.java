package it.nextworks.nfvmano.timeo.tenant;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

/**
 * This class represents an EMMA tenant.
 * 
 * @author nextworks
 *
 */
@Entity
public class Tenant {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	private String tenantId;
	private String userName;
	private String password;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@ElementCollection(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Set<String> nsId = new HashSet<>();
	
	public Tenant() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param userName username and tenant ID
	 * @param password password
	 */
	public Tenant(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.tenantId = userName;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void addNs(String nsInstanceId) {
		this.nsId.add(nsInstanceId);
	}
	
	public void removeNs(String nsInstanceId) {
		this.nsId.remove(nsInstanceId);
	}
	
	/**
	 * @return the nsId
	 */
	public Set<String> getNsId() {
		return nsId;
	}

	public void isValid() throws MalformattedElementException {
		if (userName == null) throw new MalformattedElementException("Tenant without username");
		if (password == null) throw new MalformattedElementException("Tenant without password");
	}

}
