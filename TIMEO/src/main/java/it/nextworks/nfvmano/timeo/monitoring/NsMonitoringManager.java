package it.nextworks.nfvmano.timeo.monitoring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementProviderInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreatePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryPmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryThresholdResponse;


/**
 * This class handles the monitoring actions for a single Network Service instance.
 * A new instance of this class is instantiated when monitoring is activated for a given NS instance.
 * The NS monitoring manager performs the following actions:
 * 1. Translates from the NS monitoring parameters to the corresponding VIM/VNF parameters
 * 2. Activates PM jobs through the Monitoring Drivers Manager for each monitoring parameter in the NSD, 
 * based on the associated translation rules
 *    - Using IFA 005 for atomic parameters
 *    - Using Monitoring Elaboration API for composite parameters
 * 3. Manages subscriptions from clients and their mapping to subscriptions created on drivers.
 * 4. Handles dispatching of notifications through asynchronous threads (in this sense it is both a consumer
 * and a producer of IFA 013 monitoring)
 * 
 * 
 * @author nextworks
 *
 */
public class NsMonitoringManager implements PerformanceManagementProviderInterface {
	
	private static final Logger log = LoggerFactory.getLogger(NsMonitoringManager.class);

	private String nsInstanceId;
	private Nsd nsd;
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId ID of the NS instance which is monitored
	 * @param nsd NS Descriptor of the NS instance which is monitored
	 */
	public NsMonitoringManager(String nsInstanceId, Nsd nsd) {
		this.nsInstanceId = nsInstanceId;
		this.nsd = nsd;
	}
	
	/**
	 * This method activates the Performance Monitoring jobs for all the monitoring parameters 
	 * specified in the NS descriptor
	 * 
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 */
	public void activateNsMonitoring() throws MethodNotImplementedException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException("Method not implemented");
	}
	
	/**
	 * This method activates/deactivates Performance Monitoring jobs based on the changes happened in
	 * the NS instance
	 * 
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 */
	public void updateNsMonitoring() throws MethodNotImplementedException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException("Method not implemented");
	}
	
	/**
	 * This method de-activates all the existing Performance Monitoring jobs
	 * 
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 */
	public void deactivateNsMonitoring() throws MethodNotImplementedException, FailedOperationException {
		//TODO:
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public String createPmJob(CreatePmJobRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public DeletePmJobResponse deletePmJob(DeletePmJobRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public String subscribe(SubscribeRequest request, PerformanceManagementConsumerInterface consumer)
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public void unsubscribe(String subscriptionId) throws MethodNotImplementedException, MalformattedElementException,
			NotExistingEntityException, FailedOperationException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public QueryPmJobResponse queryPmJob(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public String createThreshold(CreateThresholdRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public DeleteThresholdsResponse deleteThreshold(DeleteThresholdsRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public QueryThresholdResponse queryThreshold(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			NotExistingEntityException, MalformattedElementException, FailedOperationException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public void queryPerformanceMonitoringSubscription(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

}
