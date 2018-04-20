package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementRestConsumer;



/**
 * Internal entity used to store the active subscriptions for
 * VNF package management notifications
 * 
 * @author nextworks
 *
 */
@Entity
public class VnfPackageManagementSubscription {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@Embedded
	private VnfPackageManagementRestConsumer consumer;
	
	//TODO: add filters
	
	public VnfPackageManagementSubscription() {}
	
	public VnfPackageManagementSubscription(VnfPackageManagementRestConsumer consumer) {
		this.consumer = consumer;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the consumer
	 */
	public VnfPackageManagementRestConsumer getConsumer() {
		return consumer;
	}
	
	

}
