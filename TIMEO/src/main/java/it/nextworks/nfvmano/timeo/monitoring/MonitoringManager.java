package it.nextworks.nfvmano.timeo.monitoring;

import java.util.HashMap;
import java.util.Map;

import it.nextworks.nfvmano.timeo.nso.NsManagementEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
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
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.monitoring.interfaces.NsMonitoringActivationInterface;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;

/**
 * Service which handles the creation of the monitoring jobs and subscriptions for the monitoring
 * of Network Service instances handled by the NFVO.
 * The methods exposed by the NsMonitoringActivationInterface are invoked by the core of the NFVO.
 * The methods of the monitoring interface of the IFA 013 may be invoked by a REST controller which
 * exposes REST APIs towards external entities interested in requesting specific monitoring information 
 * (e.g. through subscriptions).
 * 
 * @author nextworks
 *
 */
@Service
@EnableAsync(proxyTargetClass=true)
public class MonitoringManager implements NsMonitoringActivationInterface, PerformanceManagementProviderInterface {
	
	private static final Logger log = LoggerFactory.getLogger(MonitoringManager.class);
	
	@Autowired
	NsDbWrapper nsDbWrapper;
	
	@Autowired
	MonitoringDriversManager monitoringDriver;
	
	@Autowired
	VnfmHandler vnfmHandler;

	@Autowired
	NsManagementEngine engine;

	@Autowired
	MonitoringAlertDispatcher dispatcher;

	private Map<String, NsMonitoringManager> nsMonitoringManagers = new HashMap<>(); //Key: NS_instance_ID
	
	public MonitoringManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createPmJob(CreatePmJobRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public DeletePmJobResponse deletePmJob(DeletePmJobRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		// TODO Auto-generated method stub
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

	@Override
	@Async
	public void activateNsMonitoring(String nsInstanceId, Nsd nsd) 
			throws MethodNotImplementedException, AlreadyExistingEntityException, NotExistingEntityException, FailedOperationException,
		MalformattedElementException {
		log.debug("Activating NS monitoring for NS instance " + nsInstanceId);
		if ((nsInstanceId == null) || (nsd==null)) throw new MalformattedElementException("Received activate NS request with null parameters");
		if (this.nsMonitoringManagers.containsKey(nsInstanceId)) 
			throw new AlreadyExistingEntityException("Monitoring already active for NS instance " + nsInstanceId + ". ");
		NsInfo nsInfo = nsDbWrapper.getNsInfo(nsInstanceId);
		NsMonitoringManager nsMonitoringManager = new NsMonitoringManager(
				nsInstanceId,
				nsd,
				this.nsDbWrapper,
				this.monitoringDriver,
				this.vnfmHandler,
				new NsAlertManager(
						engine,
						nsInstanceId,
						nsd.getMonitoredInfo(),
						nsd.getAutoScalingRule(),
						monitoringDriver,
						dispatcher
				)
		);
		log.debug("Instantiated new NS Monitoring Manager for NS instance " + nsInstanceId);
		nsMonitoringManager.activateNsMonitoring(nsInfo);
		this.nsMonitoringManagers.put(nsInstanceId,nsMonitoringManager);
	    log.debug("Activated monitoring for NS instance " + nsInstanceId);
	}
	
	@Override
	public void updateNsMonitoring(String nsInstanceId) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,	MalformattedElementException {
		// TODO Auto-generated method stub
		throw new MethodNotImplementedException("Method not implemented");
	}

	//This cannot be asynch since monitoring must be de-activated before starting to terminate the service.
	@Override
	public void deactivateNsMonitoring(String nsInstanceId) 
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
		MalformattedElementException {
		if (nsMonitoringManagers.containsKey(nsInstanceId)) {
			log.debug("Disactivating NS monitoring for NS instance " + nsInstanceId);
			nsMonitoringManagers.get(nsInstanceId).deactivateNsMonitoring();
			log.debug("NS monitoring disactivated for NS instance " + nsInstanceId);
		} else {
			log.debug("NS monitoring not active for NS instance " + nsInstanceId + ". Nothing to do");
			return;
		}
		nsMonitoringManagers.remove(nsInstanceId);
		log.debug("Monitoring manager for NS instance " + nsInstanceId + " removed.");
	}

}
