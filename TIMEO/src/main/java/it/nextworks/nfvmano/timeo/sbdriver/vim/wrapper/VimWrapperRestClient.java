package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * This class provides a ReST client for the Openstack Wrapper
 * 
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
public class VimWrapperRestClient {

	private static final Logger log = LoggerFactory.getLogger(VimWrapperRestClient.class);

	private RestTemplate restTemplate;

	private String controllerIpAddress;
	private int port;
	private static String getComputeNodePathUri = "/listComputeNodes";
	private static String setPowerStateComputeNodeUri = "/modifypowerstate";
	private static String authenticateOpenstackPathUri = "/authenticate";
	private static String getComputeDataForAlgorithm = "/listComputeNodeData";

	private AuthenticationResponse token;

	/**
	 * 
	 * @param controllerIpAddress
	 *            Listening IP address of the wrapper
	 * @param port
	 *            Listening port of the wrapper
	 */
	public VimWrapperRestClient(String controllerIpAddress, int port) {
		this.controllerIpAddress = controllerIpAddress;
		this.port = port;
		this.restTemplate = new RestTemplate();
	}

	/**
	 * The method provides Authentication to Openstack through the OS Wrapper
	 * 
	 * @throws RemoteEntityFailureException
	 * @throws FailedOperationException
	 */
	public void getAuthentication() throws RemoteEntityFailureException, FailedOperationException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			AuthenticationRequest request = new AuthenticationRequest();
			HttpEntity<AuthenticationRequest> entity = new HttpEntity<AuthenticationRequest>(request, headers);

			ResponseEntity<AuthenticationResponse> httpResponse = restTemplate.exchange(
					"http://" + controllerIpAddress + ":" + port + authenticateOpenstackPathUri, HttpMethod.POST,
					entity, AuthenticationResponse.class);

			switch (httpResponse.getStatusCode()) {
			case OK:
				token = new AuthenticationResponse(httpResponse.getBody().getStatus(),
						httpResponse.getBody().getToken(), httpResponse.getBody().getExpires_at(),
						httpResponse.getBody().getError());
				break;
			default:
				token = new AuthenticationResponse(httpResponse.getBody().getStatus(),
						httpResponse.getBody().getToken(), httpResponse.getBody().getExpires_at(),
						httpResponse.getBody().getError());
				log.error("An error occurred during authentication to openstack: " + token.getError());
				throw new FailedOperationException(
						"An error occurred during authentication to openstack: " + token.getError());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("An error occurred during authentication to VIM: " + e.getMessage());
			throw new FailedOperationException("An error occurred during authentication to VIM: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @return List of all Compute Nodes related to the Os Wrapper
	 * @throws RemoteEntityFailureException
	 * @throws FailedOperationException
	 */
	public ArrayList<ComputeNode> getComputeNodes() throws RemoteEntityFailureException, FailedOperationException {
		try {
			this.getAuthentication();
		} catch (FailedOperationException e) {
			log.error("Authentication failed: " + e.getMessage());
			throw new FailedOperationException("Authentication failed: " + e.getMessage());
		}
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("X-Auth-Token", token.getToken());

			HttpEntity<ComputeNodeInfoModel> entity = new HttpEntity<ComputeNodeInfoModel>(null, headers);
			ResponseEntity<ComputeNodeInfoModel> httpResponse = restTemplate.exchange(
					"http://" + controllerIpAddress + ":" + port + getComputeNodePathUri, HttpMethod.GET, entity,
					ComputeNodeInfoModel.class);
			switch (httpResponse.getStatusCode()) {
			case OK:
				ArrayList<ComputeNode> response = (ArrayList<ComputeNode>) httpResponse.getBody().getElements();
				return response;

			default:
				return new ArrayList<>();
			}
		} catch (Exception e) {
			log.error("An error occurred retrieving compute node list: " + e.getMessage());
			throw new FailedOperationException("An error occurred retrieving compute node list: " + e.getMessage());
		}
	}

	/**
	 * The method modifies the power state of a Compute Node
	 * 
	 * @param name
	 *            Name of the Compute Node
	 * @param powerState
	 *            Power state to be set
	 * @throws RemoteEntityFailureException
	 * @throws FailedOperationException
	 */
	public void modifyPowerState(String name, PowerState powerState)
			throws RemoteEntityFailureException, FailedOperationException {
		ArrayList<ComputeNode> computeNodes = getComputeNodes();

		if (computeNodes.isEmpty()) {
			log.error("No ComputeNodes are registered to the wrapper. Operation cannot be executed");
			throw new FailedOperationException(
					"No ComputeNodes are registered to the wrapper. Operation cannot be executed");
		}

		for (ComputeNode compute : computeNodes) {
			if (compute.getName().equalsIgnoreCase(name)) {
				compute.setPower_state(powerState);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<ComputeNode> entity = new HttpEntity<ComputeNode>(compute, headers);
				try {
					log.trace("START SET POWERSTATE " + powerState.toString() + " to compute " + name);
					ResponseEntity<ComputeNode> httpResponse = restTemplate.exchange("http://" + controllerIpAddress
							+ ":" + port + setPowerStateComputeNodeUri + "/" + compute.getId(), HttpMethod.PUT, entity,
							ComputeNode.class);
					if (httpResponse.getStatusCodeValue() == 200) {
						log.debug("Compute node " + name + " switched to " + powerState.toString() + " status");
					} else {
						log.error("An error occurred during power state change. Returned code:  "
								+ httpResponse.getStatusCodeValue());
						throw new RemoteEntityFailureException(
								"An error occurred during power state change. Returned code:  "
										+ httpResponse.getStatusCodeValue(),
								name);
					}
					log.trace("END SET POWERSTATE " + powerState.toString() + " to compute " + name);
				} catch (Exception e) {
					log.error("An error occurred during power state change:" + e.getMessage());
					throw new RemoteEntityFailureException("An error occurred during power state change: ",
							e.getMessage());
				}
			}

		}
	}

	public List<VirtualMachineType> getVirtualMachineTypes(String name)
			throws FailedOperationException, RemoteEntityFailureException {
		List<VirtualMachineType> vmTypes = new ArrayList<>();
		try {
			this.getAuthentication();
		} catch (FailedOperationException e1) {
			log.error("Authentication failed: " + e1.getMessage());
			throw new FailedOperationException("Authentication failed: " + e1.getMessage());
		} catch (RemoteEntityFailureException e2) {
			log.error("Authentication failed: " + e2.getMessage());
			throw new RemoteEntityFailureException("Authentication failed: ", e2.getMessage());
		}
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("X-Auth-Token", token.getToken());

			HttpEntity<VirtualMachineTypeInfoModel> entity = new HttpEntity<VirtualMachineTypeInfoModel>(null, headers);
			ResponseEntity<VirtualMachineTypeInfoModel> httpResponse = restTemplate.exchange(
					"http://" + controllerIpAddress + ":" + port + getComputeNodePathUri, HttpMethod.GET, entity,
					VirtualMachineTypeInfoModel.class);
			switch (httpResponse.getStatusCode()) {
			case OK:
				vmTypes = (ArrayList<VirtualMachineType>) httpResponse.getBody().getElements();
				return vmTypes;

			default:
				return new ArrayList<>();
			}
		} catch (Exception e) {
			log.error("An error occurred retrieving compute node list: " + e.getMessage());
			throw new FailedOperationException("An error occurred retrieving compute node list: " + e.getMessage());
		}
	}
	
	
	
	public ArrayList<WrapperComputeNode> getComputeNodesForAnalytics() throws RemoteEntityFailureException, FailedOperationException {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<WrapperComputeNode[]> entity = new HttpEntity<WrapperComputeNode[]>(null, headers);
			ResponseEntity<WrapperComputeNode[]> httpResponse = restTemplate.exchange(
					"http://" + controllerIpAddress + ":" + port + getComputeDataForAlgorithm, HttpMethod.GET, entity,
					WrapperComputeNode[].class);
			switch (httpResponse.getStatusCode()) {
			case OK:
				ArrayList<WrapperComputeNode> response = new ArrayList<>();
				for(int i = 0; i < httpResponse.getBody().length; i++)
					response.add(httpResponse.getBody()[i]);					
				return response;

			default:
				return new ArrayList<>();
			}
		} catch (Exception e) {
			log.error("An error occurred retrieving compute node list: " + e.getMessage());
			throw new FailedOperationException("An error occurred retrieving compute node list: " + e.getMessage());
		}
	}

}
