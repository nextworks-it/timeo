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
package it.nextworks.nfvmano.timeo.vnfm.vnfdriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationRequest;
import it.nextworks.nfvmano.libs.vnfconfig.interfaces.messages.SetConfigurationResponse;

public class VnfRestClient {

	private static final Logger log = LoggerFactory.getLogger(VnfRestClient.class);
	private RestTemplate restTemplate;

	private String configurationApiUrl;
	private String indicatorApiUrl;

	public VnfRestClient(RestTemplate restTemplate, String vnfIpAddress) {
		this.restTemplate = restTemplate;
		this.configurationApiUrl = "http://" + vnfIpAddress + ":8888/vnfconfig/v1/configuration";
		this.indicatorApiUrl = "http://" + vnfIpAddress + ":8888/vnfind/v1";
	}

	public SetConfigurationResponse setConfiguration(SetConfigurationRequest request)
			throws FailedOperationException {
		log.debug("Sending VNF configuration request to VNF.");
		int count = 0;
		HttpHeaders headers = new HttpHeaders();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(5000);
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		try {
			log.debug("Request to VNF: " + mapper.writeValueAsString(request));
		} catch(Exception exc) {
			exc.printStackTrace();
		}
		while (count < 60 ) {
			log.debug("Cicling for VNF Configuration: " + count);
			try {
				ResponseEntity<?> httpResponse = restTemplate.exchange(configurationApiUrl, HttpMethod.PATCH,
						new HttpEntity<SetConfigurationRequest>(request, headers),
						SetConfigurationResponse.class);
				switch (httpResponse.getStatusCode()) {
				case OK: {
					log.debug("Received VNF configuration response: " + httpResponse.getBody().toString());
					return (SetConfigurationResponse) (httpResponse.getBody());
				}
				default: {
					log.error("HTTP response code with failed VNF configuration.");
					throw new FailedOperationException("HTTP response code with failed VNF configuration.");
				}
				}
			} catch (RestClientException e) {
				log.warn("Error while invoking REST API for VNF configuration: " + e.getMessage());
				count++;
				try {
					Thread.sleep(10000);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
		log.error("Error while invoking REST API for VNF configuration");
		throw new FailedOperationException("Error while invoking REST API for VNF configuration: ");
	}

}
