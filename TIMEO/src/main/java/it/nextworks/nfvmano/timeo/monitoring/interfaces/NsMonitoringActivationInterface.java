package it.nextworks.nfvmano.timeo.monitoring.interfaces;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;

/**
 * Interface to activate and de-activate the monitoring of a Network Service instance.
 * It must be implemented by the Monitoring Manager and invoked by the core of the NFVO.
 * 
 * @author nextworks
 *
 */
public interface NsMonitoringActivationInterface {

	/**
	 * This method activates all the performance monitoring jobs required to monitor
	 * the monitoring parameters defined in the descriptor of the given NS instance.
	 * 
	 * @param nsInstanceId ID of the network service instance to be monitored
	 * @param nsd NS description related to the given instance
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws AlreadyExistingEntityException if the monitoring jobs for the given NS instance have been already activated
	 * @throws NotExistingEntityException if the network service instance does not exist
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the ID of the NS instance has a wrong format
	 */
	public void activateNsMonitoring(String nsInstanceId, Nsd nsd) throws MethodNotImplementedException, AlreadyExistingEntityException, NotExistingEntityException, FailedOperationException,
	MalformattedElementException;
	
	/**
	 * This method updates the performance monitoring jobs required to monitor a NS instance.
	 * It must be invoked whenever a NS instance is changed, e.g. in case of scaling.
	 * 
	 * @param nsInstanceId ID of the network service instance for which the monitoring must be updated
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if the NS instance does not exist or is not yet monitored
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the request is malformatted
	 */
	public void updateNsMonitoring(String nsInstanceId) throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,	MalformattedElementException; 
	
	/**
	 * This method de-activates all the performance monitoring jobs that have been created 
	 * to monitor the given NS instance.
	 * 
	 * @param nsInstanceId ID of the monitored network service instance
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws NotExistingEntityException if the NS ID is not available in the internal record of the monitoring manager 
	 * @throws FailedOperationException if the operation fails
	 * @throws MalformattedElementException if the ID of the NS instance has a wrong format
	 */
	public void deactivateNsMonitoring(String nsInstanceId) throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
	MalformattedElementException;
	
}
