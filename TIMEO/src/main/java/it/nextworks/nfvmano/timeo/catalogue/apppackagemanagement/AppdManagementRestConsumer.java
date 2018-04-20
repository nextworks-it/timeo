package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageOnBoardingNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.AppPackageStateChangeNotification;
import it.nextworks.nfvmano.timeo.common.ConsumerType;

/**
 * REST-based consumer of MEC AppD management notifications
 * 
 * @author nextworks
 *
 */
@Embeddable
public class AppdManagementRestConsumer extends AppdManagementConsumer {

	private static final Logger log = LoggerFactory.getLogger(AppdManagementRestConsumer.class);
	
	private String callbackUrl;
	private String authentication;	//this is for further definition
	
	@Transient
	private RestTemplate restTemplate;
	
	public AppdManagementRestConsumer() { }

	/**
	 * Constructor
	 * 
	 * @param callbackUrl URL to be invoked to send a notification to the external entity
	 * @param authentication credentials to be used - not yet supported
	 */
	public AppdManagementRestConsumer(String callbackUrl, String authentication) {
		super(ConsumerType.REST);
		this.callbackUrl = callbackUrl;
		this.authentication = authentication;
		this.restTemplate = new RestTemplate();
	}
	
	/**
	 * @return the callbackUrl
	 */
	public String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * @return the authentication
	 */
	public String getAuthentication() {
		return authentication;
	}

	@Override
	public void notify(AppPackageOnBoardingNotification notification) {
		log.debug("Notifying MEC app package on boarding");
		try {
			restTemplate.postForLocation(new URI(this.callbackUrl), notification);
			log.debug("MEC app package on boarding notification sent to " + this.callbackUrl);
		} catch (URISyntaxException exception) {
			log.error("Impossible to send MEC app package on boarding notification: malformed URI - " + this.callbackUrl);
		} catch (RestClientException exception) {
			log.error("Impossible to send MEC app package on boarding notification: rest client error");
		}
	}

	@Override
	public void notify(AppPackageStateChangeNotification notification) { 
		log.debug("Notifying MEC app package state change");
		try {
			restTemplate.postForLocation(new URI(this.callbackUrl), notification);
			log.debug("MEC app package state change notification sent to " + this.callbackUrl);
		} catch (URISyntaxException exception) {
			log.error("Impossible to send MEC app package state change notification: malformed URI - " + this.callbackUrl);
		} catch (RestClientException exception) {
			log.error("Impossible to send MEC app package state change notification: rest client error");
		}
	}

}
