package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdChangeNotification;
import it.nextworks.nfvmano.libs.catalogues.interfaces.messages.NsdOnBoardingNotification;
import it.nextworks.nfvmano.timeo.common.ConsumerType;


/**
 * REST-based consumer of NSD management notifications
 * 
 * @author nextworks
 *
 */
@Embeddable
public class NsdManagementRestConsumer extends NsdManagementConsumer {

	private static final Logger log = LoggerFactory.getLogger(NsdManagementRestConsumer.class);
	
	private String callbackUrl;
	private String authentication;	//this is for further definition
	
	@Transient
	private RestTemplate restTemplate;
	
	public NsdManagementRestConsumer() { }
	
	/**
	 * Constructor
	 * 
	 * @param callbackUrl URL to be invoked to send a notification to the external entity
	 * @param authentication credentials to be used - not yet supported
	 */
	public NsdManagementRestConsumer(String callbackUrl, String authentication) {
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
	public void notify(NsdOnBoardingNotification notification) {
		log.debug("Notifying NSD on boarding");
		try {
			restTemplate.postForLocation(new URI(this.callbackUrl), notification);
			log.debug("NSD on boarding notification sent to " + this.callbackUrl);
		} catch (URISyntaxException exception) {
			log.error("Impossible to send NSD on boarding notification: malformed URI - " + this.callbackUrl);
		} catch (RestClientException exception) {
			log.error("Impossible to send NSD on boarding notification: rest client error");
		}
	}

	@Override
	public void notify(NsdChangeNotification notification) {
		log.debug("Notifying NSD change");
		try {
			restTemplate.postForLocation(new URI(this.callbackUrl), notification);
			log.debug("NSD change notification sent to " + this.callbackUrl);
		} catch (URISyntaxException exception) {
			log.error("Impossible to send NSD change notification: malformed URI - " + this.callbackUrl);
		} catch (RestClientException exception) {
			log.error("Impossible to send NSD change notification: REST client error");
		}
	}

}
