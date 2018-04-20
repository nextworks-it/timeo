package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.NsdManagementRestConsumer;



/**
 * Internal entity used to store the active subscriptions for
 * NSD management notifications
 * 
 * @author nextworks
 *
 */
@Entity
public class NsdManagementSubscription {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	@Embedded
	private NsdManagementRestConsumer consumer;
	
	//TODO: add filters
	
	public NsdManagementSubscription() {
		// JPA only
	}
	
	/**
	 * Constructor
	 * 
	 * @param consumer consumer that will manage the NSD management notifications
	 */
	public NsdManagementSubscription(NsdManagementRestConsumer consumer) {
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
	public NsdManagementRestConsumer getConsumer() {
		return consumer;
	}
	
	

}
