/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;
import it.nextworks.nfvmano.libs.vnfindicator.interfaces.messages.GetIndicatorValueResponse;
import it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.messages.RrhInfoResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class RrhInfoRestClient {

	private static final Logger log = LoggerFactory.getLogger(RrhInfoRestClient.class);
	private RestTemplate restTemplate;

	private String infoApiUrl;


	public RrhInfoRestClient(RestTemplate restTemplate, String pnfIpAddress) {
		this.restTemplate = restTemplate;
		this.infoApiUrl = "http://" + pnfIpAddress + ":8888/vnfconfig/v1/info";

	}



	public RrhInfoResponseMessage getRrhInfoValue(GeneralizedQueryRequest request)
			throws FailedOperationException {
		String requestString;
		ObjectWriter mapper = new ObjectMapper().writerWithDefaultPrettyPrinter();
		try {
			requestString = mapper.writeValueAsString(request);
		} catch (JsonProcessingException exc) {
			log.error("Could not process get indicator request.");
			log.debug("Details: ", exc);
			throw new FailedOperationException("Could not process get indicator request");
		}
		log.debug("Sending GET VNF indicator request to VNF.");
		log.debug(requestString);
		HttpHeaders headers = new HttpHeaders();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(5000);
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<RrhInfoResponseMessage> httpResponse = restTemplate.exchange(
				infoApiUrl,
				HttpMethod.GET,
				new HttpEntity<>(request, headers),
				RrhInfoResponseMessage.class
		);
		switch (httpResponse.getStatusCode()) {
			case OK:
				log.debug("Received GET RRH information response.");
				String responseString;
				try {
					responseString = mapper.writeValueAsString(httpResponse.getBody());
				} catch (JsonProcessingException exc) {
					log.error("Cannot parse response.");
					throw new FailedOperationException(exc);
				}
				log.debug(responseString);
				return httpResponse.getBody();

			default:
				log.error("Unexpected response code '{}' from RRH.", httpResponse.getStatusCode());
				String errorResponseString;
				try {
					errorResponseString = mapper.writeValueAsString(httpResponse.getBody());
				} catch (JsonProcessingException exc) {
					log.error("Cannot parse error response.");
					throw new FailedOperationException(exc);
				}
				log.debug("Response:");
				log.debug(errorResponseString);
				throw new FailedOperationException("GET RRH info value operation failed at the RRH.");

		}
	}

}
