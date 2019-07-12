package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationRequest;
import it.nextworks.nfvmano.libs.bluespace.algorithm.messages.BluespaceAlgorithmAllocationResponse;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;

/**
 * REST client to interact with AIT algorithm
 * 
 * @author nextworks
 *
 */
public class AitAlgorithmRestClient {

	private static final Logger log = LoggerFactory.getLogger(AitAlgorithmRestClient.class);
	
	private RestTemplate restTemplate;
	private String algoUrl;
	
	/**
	 * Constructor
	 * 
	 * @param algoUrl root URL to interact with AIT algorithm
	 * @param restTemplate REST template
	 */
	public AitAlgorithmRestClient(String algoUrl,
			RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.algoUrl = algoUrl;
	}
	
	/**
	 * Method to request the computation of the resource allocation in blueSPACE
	 * 
	 * @param request the resource allocation request
	 * @return the resource allocation response
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if some elements of the request do not exist
	 * @throws FailedOperationException if no solution is found or it is not possible to contact the external algorithm
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public BluespaceAlgorithmAllocationResponse computeAllocation(BluespaceAlgorithmAllocationRequest request) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException, MalformattedElementException {
		
		log.debug("Building HTTP request for blueSPACE resource computation.");
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		HttpEntity<?> postEntity = new HttpEntity<>(request, header);
		
		String url = algoUrl + "/computation";
		
		try {
			log.debug("Sending HTTP request for blueSPACE resource computation.");
			ResponseEntity<BluespaceAlgorithmAllocationResponse> httpResponse = 
    				restTemplate.exchange(url, HttpMethod.POST, postEntity, BluespaceAlgorithmAllocationResponse.class);
			
			log.debug("Response code: " + httpResponse.getStatusCode().toString());
			HttpStatus code = httpResponse.getStatusCode();
			
			if (code.equals(HttpStatus.OK)) {
				log.debug("Resource allocation solution successfully returned.");
				return httpResponse.getBody();
			} else if (code.equals(HttpStatus.NOT_FOUND)) {
				throw new NotExistingEntityException("Error during resource computation at external algorithm: " + httpResponse.getBody());
			} else if (code.equals(HttpStatus.BAD_REQUEST)) {
				throw new MalformattedElementException("Error during resource computation at external algorithm: " + httpResponse.getBody());
			} else if (code.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
				throw new FailedOperationException("Error during resource computation at external algorithm: " + httpResponse.getBody());
			}else {
				throw new FailedOperationException("Generic error during resource computation at external algorithm");
			}
				
		} catch (RestClientException ex) {
			log.debug("Error while interacting with external algorithm at url " + url);
			throw new FailedOperationException("Error while interacting with external algorithm at url " + url);
		}
	}

}
