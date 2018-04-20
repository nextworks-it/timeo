package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.AppdManagementRestConsumer;

/**
 * Internal entity used to store the active subscriptions for
 * MEC app package management notifications
 * 
 * @author nextworks
 *
 */
@Entity
public class AppPackageManagementSubscription {
	
	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@Embedded
	private AppdManagementRestConsumer consumer;
	
	//TODO: add filters

	public AppPackageManagementSubscription() {	}
	
	/**
	 * Constructor
	 * 
	 * @param consumer consumer of the notification
	 */
	public AppPackageManagementSubscription(AppdManagementRestConsumer consumer) {
		this.consumer = consumer;
	}

	/**
	 * @return the consumer
	 */
	public AppdManagementRestConsumer getConsumer() {
		return consumer;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	

}
