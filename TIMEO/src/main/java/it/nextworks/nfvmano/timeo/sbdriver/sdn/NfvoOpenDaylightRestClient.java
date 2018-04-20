package it.nextworks.nfvmano.timeo.sbdriver.sdn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.OpendaylightInventory;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SetupPathRequest;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.TopologyWrapper;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.emma.SetNodesStateInput;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.emma.SetNodesStateRequest;

import java.util.Map;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class NfvoOpenDaylightRestClient {

	private static final Logger log = LoggerFactory.getLogger(NfvoOpenDaylightRestClient.class);

	private RestTemplate restTemplate;

	private String setupPathUri;
	private String deletePathUri;

	private String topologyUri;
	private String inventoryUri;

	private String stateManagerUri;
	private String pathComputationUri;
	
	private String encodedString;

	public NfvoOpenDaylightRestClient(String controllerUrl,
									  String setupPathUri,
									  String deletePathUri,
									  String encodedString,
									  RestTemplate restTemplate) {
		this.setupPathUri = setupPathUri;
		this.deletePathUri = deletePathUri;
		this.encodedString = encodedString;

		this.topologyUri = controllerUrl + "/restconf/operational/network-topology:network-topology";
		this.inventoryUri = controllerUrl + "/restconf/operational/opendaylight-inventory:nodes";
		this.stateManagerUri = controllerUrl + "/restconf/operations/statemanager:";
		this.pathComputationUri = controllerUrl + "/restconf/operations/pathcomputation:";
		this.restTemplate = restTemplate;
	}

	private String setNodesStateUri() {
		return pathComputationUri + "set-nodes-state";
	}

	public void sendSetupPathRequest(SetupPathRequest msg) throws RemoteEntityFailureException {
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Basic " + encodedString);
			header.add("Content-Type", "application/json");
			HttpEntity<?> postEntity = new HttpEntity<>(msg, header);
			log.debug("URI: " + setupPathUri + " - "
					+ "ConnectionID: " + msg.getConnection().getConnectionId() + " - "
					+ "Connection status: " + msg.getConnection().getConnectionStatus().toString() + " - "
					+ "Source: " + msg.getConnection().getSource() + " - "
					+ "Destination: " + msg.getConnection().getDestination() + " - "
					+ "ComputedPath: "+ msg.getConnection().getComputedPath());
			//TESTING
			try{
				ObjectMapper objectMapper = new ObjectMapper();
				log.debug("JSON_REQUEST_PATH: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(msg));
			} catch(Exception e){
				log.error("Unable to parse json request");
			}
			//END TESTING
			((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(1000*2);
			((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(1000*2);

			ResponseEntity<Long> httpResponse = 
    				restTemplate.exchange(setupPathUri, HttpMethod.POST, postEntity, Long.class);
			log.debug("Response code: " + httpResponse.getStatusCode().toString());
			HttpStatus code = httpResponse.getStatusCode();
			if (!code.equals(HttpStatus.NO_CONTENT)) {
				throw new RestClientException("SetupPath request not accepted");
			} else {
				log.debug("Response code: {}, Connection ID: {}", code.toString(), msg.getConnection().getConnectionId());
			}
		} catch (RestClientException ex) {
			log.error("Error while sending SetupPath request for Connection " + msg.getConnection().getConnectionId() + "."
					+ ex.getMessage());
			throw new RemoteEntityFailureException("setupPath" + setupPathUri, ex.getMessage());
		}
	}

	public void sendDeletePathRequest(String netPathId) throws RemoteEntityFailureException {
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Basic " + encodedString);
			header.add("Content-Type", "application/json");
			HttpEntity<?> postEntity = new HttpEntity<>(header);
			ResponseEntity<Long> httpResponse =
					restTemplate.exchange(deletePathUri.concat(netPathId), HttpMethod.DELETE, postEntity, Long.class);
			log.debug("Response code: " + httpResponse.getStatusCode().toString());
			HttpStatus code = httpResponse.getStatusCode();
			if (!code.equals(HttpStatus.OK)) {
				throw new RestClientException("DeletePath request not accepted");
			}
		} catch (RestClientException ex) {
			log.error("Error while sending DeletePath request for Connection " + netPathId + "." + ex.getMessage());
			throw new RemoteEntityFailureException("deletePath" + deletePathUri, ex.getMessage());
		}
	}

	public void sendSetStatesRequest(Map<String, PowerState> states) throws RemoteEntityFailureException {
		// TODO rimandare messaggi sensati
		log.debug("Sending set states rpc call to OpenDaylight");

		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Basic " + encodedString);
		header.add("Content-Type", "application/json");

		SetNodesStateRequest setNodesStateRequest = new SetNodesStateRequest(states);
		HttpEntity<SetNodesStateInput> postEntity = new HttpEntity<>(setNodesStateRequest.buildInput(), header);

		try {
			ResponseEntity<?> httpResponse =
					restTemplate.exchange(setNodesStateUri(), HttpMethod.POST, postEntity, Object.class);
			log.debug("Response code: {}.", httpResponse.getStatusCode());
			if (!httpResponse.getStatusCode().equals(HttpStatus.OK)) {
				throw new RestClientException("Set states call failed.");
			}
		} catch (RestClientException e) {
			log.error(
					"Error while sending the call: Set nodes state request failed with error: {}.",
					e.getMessage()
			);
			throw new RemoteEntityFailureException("SdnController", setNodesStateUri());
		}
	}

	public TopologyWrapper sendTopologyRequest() throws RemoteEntityFailureException {
		try {
			log.debug("Sending GET topology call to OpenDaylight");
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Basic " + encodedString);
			header.add("Content-Type", "application/json");
			HttpEntity<?> getEntity = new HttpEntity<>(header);
			ResponseEntity<TopologyWrapper> httpResponse =
					restTemplate.exchange(topologyUri, HttpMethod.GET, getEntity, TopologyWrapper.class);
			log.debug("Response code: {}.", httpResponse.getStatusCode());
			if (!httpResponse.getStatusCode().equals(HttpStatus.OK)) {
				throw new RestClientException(String.format(
						"GET topology request failed with code: %s.",
						httpResponse.getStatusCode()
				));
			}
			return httpResponse.getBody();
		} catch (RestClientException e) {
			log.error("Error while sending the call: {}.", e.getMessage());
			log.debug("Error cause: ", e);
			throw new RemoteEntityFailureException("SdnController", stateManagerUri);
		}
	}

	public OpendaylightInventory sendInventoryRequest() throws RemoteEntityFailureException {
		try {
			log.debug("Sending GET inventory to OpenDaylight");
			HttpHeaders header = new HttpHeaders();
			header.add("Authorization", "Basic " + encodedString);
			header.add("Content-Type", "application/json");
			HttpEntity<?> getEntity = new HttpEntity<>(header);
			ResponseEntity<OpendaylightInventory> httpResponse =
					restTemplate.exchange(inventoryUri, HttpMethod.GET, getEntity, OpendaylightInventory.class);
			log.debug("Response code: {}.", httpResponse.getStatusCode());
			if (!httpResponse.getStatusCode().equals(HttpStatus.OK)) {
				throw new RestClientException(String.format(
						"GET inventory request failed with code: %s.",
						httpResponse.getStatusCode()
				));
			}
			return httpResponse.getBody();
		} catch (RestClientException e) {
			log.error("Error while sending the call: {}.", e.getMessage());
			log.debug("Error cause: ", e);
			throw new RemoteEntityFailureException("SdnController", stateManagerUri);
		}
	}
}
