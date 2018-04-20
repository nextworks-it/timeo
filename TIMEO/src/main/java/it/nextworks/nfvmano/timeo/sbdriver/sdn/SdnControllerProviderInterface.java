package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.timeo.common.emma.PowerState;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkTopology;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;

/**
 * This interface models the interaction between the NFVO and an SDN controller. 
 * It must be implemented by an SDN controller plugin and invoked by the resource
 * allocation manager in the NFVO.
 * 
 * 
 * @author nextworks
 *
 */
public interface SdnControllerProviderInterface {

	/**
	 * Method used to read the current topology from the SDN controller
	 * 
	 * @return the network topology
	 * @throws NotExistingEntityException if the topology is not found on the controller
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	public NetworkTopology getNetworkTopology() throws NotExistingEntityException, MethodNotImplementedException;
	
	/**
	 * Method used to set the power state of a given node 
	 * 
	 * @param deviceId ID of the network node to be configured
	 * @param powerState power state to be activated on the network node
	 * @param consumer the consumer that should receive a notification about the result of the requested command
	 * @return the operation ID
	 * @throws NotExistingEntityException if the node is not found
	 * @throws FailedOperationException if the operation fails
	 * @throws MethodNotImplementedException if the SDN controller does not support the feature
	 */
	public String setPowerState(String deviceId, PowerState powerState, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException;
	
	/**
	 * Method used to set the power state of a set of given nodes in an atomic action.
	 * If a single action fails, the method should automatically roll-back the action.
	 * 
	 * @param devicesPowerState power states to be configured for the given set of network nodes
	 * @throws NotExistingEntityException if the node is not found
	 * @throws FailedOperationException if the operation fails
	 * @throws MethodNotImplementedException if the SDN controller does not support the feature
	 */
	public void setPowerState(Map<String,PowerState> devicesPowerState) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException;
	
	
	/**
	 * Method used to establish a list of network paths. 
	 * The method must setup all the paths or none, i.e. if one of them fails, the others should be removed.  
	 * 
	 * @param networkPath list of network paths to be established
	 * @return the operation ID
	 * @throws NotExistingEntityException if one the entity in the network paths is not found
	 * @throws FailedOperationException if the operation fails
	 * @throws MethodNotImplementedException if the SDN controller does not support the feature
	 */
	public String setupPaths(List<SbNetworkPath> networkPath, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException;
	
	/**
	 * Method used to remove a list of network paths.
	 * 
	 * @param networkPathIds list of IDs of the network paths to be removed
	 * @return the operation ID
	 * @throws NotExistingEntityException if one of the network path is not found
	 * @throws FailedOperationException if the operation fails
	 * @throws MethodNotImplementedException if the SDN controller does not support the feature
	 */
	public String removePaths(List<String> networkPathIds, SdnControllerConsumerInterface consumer) throws NotExistingEntityException, FailedOperationException, MethodNotImplementedException;
	
}
