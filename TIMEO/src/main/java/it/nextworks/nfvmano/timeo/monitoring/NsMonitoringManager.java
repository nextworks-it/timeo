package it.nextworks.nfvmano.timeo.monitoring;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.nextworks.nfvmano.libs.common.elements.MonitoringParameter;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.descriptors.nsd.MonitoredData;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.VnfIndicatorData;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementProviderInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.ObjectSelection;
import it.nextworks.nfvmano.libs.monit.interfaces.enums.MonitoringObjectType;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreatePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryPmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryThresholdResponse;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.libs.records.vnfinfo.VnfInfo;
import it.nextworks.nfvmano.timeo.common.Utilities;
import it.nextworks.nfvmano.timeo.monitoring.elements.MonitoringGui;
import it.nextworks.nfvmano.timeo.nso.repository.NsDbWrapper;
import it.nextworks.nfvmano.timeo.tenant.Tenant;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;


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
	
	NsDbWrapper nsDbWrapper;
	
	MonitoringDriversManager monitoringDriver;
	
	VnfmHandler vnfmHandler;

	private NsAlertManager alertManager;
	
	//Key: pm job ID; Value: Monitoring Parameter ID - This is for pm jobs associated to the NSD monitoring parameters
	private Map<String, String> pmJobIdToMpIdMap = new HashMap<>();
	
	//Key: Monitoring Parameter ID; Value: pm job ID - This is for pm jobs associated to the NSD monitoring parameters
	private Map<String, String> mpIdToPmJobIdMap = new HashMap<>();
	
	//This list includes the pm jobs associated to NSD monitoring parameters or the ones requested out of the NS instance management
	private List<String> pmJobIds = new ArrayList<>();
	
	private MonitoringGui monitoringGui;
	
	/**
	 * Constructor
	 * 
	 * @param nsInstanceId ID of the NS instance which is monitored
	 * @param nsd NS Descriptor of the NS instance which is monitored
	 * @param nsDbWrapper service used to retrieve information related to the NS instance
	 * @param monitoringDriver service used to access the monitoring platform
	 * @param vnfmHandler service handling all the VNFMs
	 */
	public NsMonitoringManager(
			String nsInstanceId,
			Nsd nsd, 
			NsDbWrapper nsDbWrapper,
			MonitoringDriversManager monitoringDriver,
			VnfmHandler vnfmHandler,
			NsAlertManager alertManager
	) {
		this.nsInstanceId = nsInstanceId;
		this.nsd = nsd;
		this.nsDbWrapper = nsDbWrapper;
		this.monitoringDriver = monitoringDriver;
		this.vnfmHandler = vnfmHandler;
		this.alertManager = alertManager;
	}
	
	/**
	 * This method activates the Performance Monitoring jobs for all the monitoring parameters 
	 * specified in the NS descriptor
	 * 
	 * @param nsInfo current record of the NS instance 
	 * @throws MethodNotImplementedException if the method is not implemented
	 * @throws FailedOperationException if the operation fails
	 */
	public void activateNsMonitoring(NsInfo nsInfo) throws MethodNotImplementedException, FailedOperationException {
		log.debug("Starting monitoring activation for NS instance " + nsInstanceId + ". Reading NSD.");
		if ((nsd.getMonitoredInfo() == null) || (nsd.getMonitoredInfo().isEmpty())) {
			log.debug("No monitored info specified in the NSD " + nsd.getNsdName() + " for NS instance " + nsInstanceId + ". Nothing to do.");
			return;
		}
		List<MonitoredData> monitoredData = nsd.getMonitoredInfo();
		for (MonitoredData md : monitoredData) {
			try {
				if (md.getVnfIndicatorInfo() != null)
					startMonitoringJobForVnfIndicator(md.getVnfIndicatorInfo(), nsInfo);
				if (md.getMonitoringParameter() != null)
					startMonitoringJobForMonitoringParameter(md.getMonitoringParameter(), nsInfo);
			} catch (Exception e) {
				log.error("Error while starting a monitoring job: " + e.getMessage() + ". Skipping it.");
				log.error(e.getMessage());
			}
		}
		log.debug("Finished creation of monitoring jobs for NS instance " + nsInstanceId);
		log.debug("Starting building monitoring dashboard for NS instance " + nsInstanceId);
		buildMonitoringDashboard();
		String url = monitoringGui.getUrl();
		try {
			nsDbWrapper.setNsInfoMonitoringUrl(nsInstanceId, url);
		} catch (NotExistingEntityException e) {
			log.error("Impossible to set URL for NS instance " + nsInstanceId + e.getMessage());
		}
		log.debug("Finished creation of monitoring dashboard for NS instance " + nsInstanceId);
		try {
			alertManager.createThresholds(mpIdToPmJobIdMap);
		} catch (MalformattedElementException exc) {
			log.error("Malformatted element in creation of thresholds");
			log.debug("Details:", exc);
		}
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
		log.debug("Disactivating NS monitoring for NS instance " + nsInstanceId);
		alertManager.deleteThresholds();
		log.debug("Removing monitoring GUI");
		if (monitoringGui != null) {
			try {
				removeMonitoringDashboard();
				monitoringGui = null;
			} catch (FailedOperationException e) {
				log.debug("Monitoring dashboard removal failed. Proceeding with removing pm jobs.");
			}
			try {
				nsDbWrapper.setNsInfoMonitoringUrl(nsInstanceId, null);
				log.debug("Monitoring URL removed from NS info for NS instance " + nsInstanceId);
			} catch (NotExistingEntityException e) {
				log.error("Impossible to remove monitoring URL for NS instance " + nsInstanceId + e.getMessage());
			}
			log.debug("Monitoring GUI removed.");
		} else {
			log.debug("Monitoring GUI not available. Nothing to remove.");
		}
		
		List<String> toBeRemoved = new ArrayList<>();
		for (String pmJobId : pmJobIds) toBeRemoved.add(pmJobId);
		
		for (String pmJobId : toBeRemoved) {
			log.debug("Removing pm job with ID " + pmJobId);
			List<String> pms = new ArrayList<>();
			pms.add(pmJobId);
			DeletePmJobRequest deleteRequest = new DeletePmJobRequest(pms);
			try {
				DeletePmJobResponse response = deletePmJob(deleteRequest);
				if (response.getDeletedPmJobId().get(0).equals(pmJobId)) 
					log.error("Impossible to delete PM job " + pmJobId + ". Skipping it.");
				if (pmJobIdToMpIdMap.containsKey(pmJobId)) {
					log.debug("PM job associated to NS monitoring parameter. Removing from internal maps.");
					String mpId = pmJobIdToMpIdMap.get(pmJobId);
					mpIdToPmJobIdMap.remove(mpId);
					pmJobIdToMpIdMap.remove(pmJobId);
					log.debug("PM job removed from internal maps.");
				}
				log.debug("PM job " + pmJobId + " deleted");
			} catch (Exception e) {
				log.debug("Failed to delete PM job " + pmJobId);
			}
		}
	}

	@Override
	public String createPmJob(CreatePmJobRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		String pmJobId = monitoringDriver.createPmJob(request);
		pmJobIds.add(pmJobId);
		return pmJobId;
	}

	@Override
	public DeletePmJobResponse deletePmJob(DeletePmJobRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		DeletePmJobResponse response = monitoringDriver.deletePmJob(request);
		pmJobIds.remove(request.getPmJobId().get(0));
		return response;
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
	
	/**
	 * This method creates a monitoring job to collect a VNF indicator
	 * 
	 * @param vnfIndicator VNF indicator to be collected
	 * @param nsInfo information about the NS instance for which the VNF indicator must be collected
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	private void startMonitoringJobForVnfIndicator(VnfIndicatorData vnfIndicator, NsInfo nsInfo) 
			throws MethodNotImplementedException {
		log.error("VNF indicators not yet supported.");
		throw new MethodNotImplementedException("Support for monitoring VNF indicators not yet available");
	}
	
	/**
	 * This method creates a monitoring job to collect a monitoring parameter
	 * 
	 * @param mp monitoring parameter to be collected
	 * @param nsInfo information about the NS instance for which the monitoring parameter must be collected
	 * @throws MethodNotImplementedException if the method is not implemented
	 */
	private void startMonitoringJobForMonitoringParameter (MonitoringParameter mp, NsInfo nsInfo) 
			throws MethodNotImplementedException, MalformattedElementException, NotExistingEntityException, FailedOperationException {
		String mpId = mp.getMonitoringParameterId();
		String mpName = mp.getName();
		String mpMetric = mp.getPerformanceMetric();
		log.debug("Starting monitoring job for monitoring parameter " + mpName + " with ID " + mpId + " for metric " + mpMetric);
		
		String [] splits = mpMetric.split("\\.");
		//TODO: This covers just a limited range of cases. To be extended.
		//Supported items:
		//VcpuUsageMean.<vnfdId>
		//VmemoryUsageMean.<vnfdId>
		//VdiskUsageMean.<vnfdId>
		//ByteIncoming.<vnfdId>.<vnfExtCpdId> --> not yet supported
		if (splits.length != 2) throw new MalformattedElementException("Wrong metric format. Performance metric in monitoring parameter should be in format <metricType>.<vnfdId>");
		String metricType = splits[0];
		String vnfdId = splits[1];
		log.debug("Monitoring metric successfully parsed. Metric type: " + metricType + " - VNFD ID: " + vnfdId);
		
		List<String> vnfInfoIds = nsInfo.getVnfInfoIdFromVnfdId(vnfdId);
		if (vnfInfoIds.size() == 0) throw new NotExistingEntityException("VNF info for VNFD " + vnfdId + " not found.");
		if (vnfInfoIds.size() > 1) throw new MethodNotImplementedException("Found multiple VNF infos for the given VNFD in the NS info. Monitoring for multiple VNFs with same type not yet supported.");
		String vnfInfoId = vnfInfoIds.get(0);
		VnfInfo vnfInfo = vnfmHandler.getDefaultVnfm().queryVnf(new GeneralizedQueryRequest(Utilities.buildVnfInfoFilter(vnfInfoId), new ArrayList<>())).getVnfInfo().get(0);
		if (vnfInfo != null) log.debug("VNF info correctly retrieved.");
		else throw new NotExistingEntityException("Unable to find VNF info with ID " + vnfInfoId);
		
		ObjectSelection vnfSelector = new ObjectSelection();
		//TODO: this must be updated
		if ( (metricType.equals("VcpuUsageMean")) || (metricType.equals("VmemoryUsageMean")) || (metricType.equals("VdiskUsageMean"))
				|| (metricType.equals("CurrentClientConnections")) || (metricType.equals("CurrentActiveClientConnections")) || (metricType.equals("UserAgentCurrentConnectionsCount"))
				|| (metricType.equals("CompletedRequests")) || (metricType.equals("TotalHits")) || (metricType.equals("CacheRamUsed"))) {
			List<MonitoringObjectType> objectType = new ArrayList<>();
			List<String> objectInstanceId = new ArrayList<>();
			objectType.add(MonitoringObjectType.VNF);
			objectInstanceId.add(vnfInfoId);
			vnfSelector = new ObjectSelection(objectType, null, objectInstanceId);
		} else if (metricType.equals("ByteIncoming")) {
			throw new MethodNotImplementedException("ByteIncoming metric not yet supported");
		} else throw new MalformattedElementException(metricType + " not supported");
		log.debug("Built target object to be monitored.");
		
		List<String> performanceMetric = new ArrayList<>();
		performanceMetric.add(metricType);
		//workaround to provide NSD name and NS ID
		List<String> performanceMetricGroup = new ArrayList<>();
		performanceMetricGroup.add(vnfInfo.getVnfdId());
		performanceMetricGroup.add(nsInstanceId);
		CreatePmJobRequest pmJobRequest = new CreatePmJobRequest(null,	//NS selector
				null, 													//resource selector
				vnfSelector,											//VNF selector 
				performanceMetric, 										//performance metric
				performanceMetricGroup,					 				//performance metric group
				0, 														//collection period
				0, 														//reporting period
				null);													//reporting boundary
		String pmJobId = createPmJob(pmJobRequest);
		log.debug("Created PM job with ID " + pmJobId + " for monitoring parameter " + mpId);
		
		this.pmJobIdToMpIdMap.put(pmJobId, mpId);
		this.mpIdToPmJobIdMap.put(mpId, pmJobId);
		log.debug("Updated internal maps with PM job and MP IDs");
	}

	private void buildMonitoringDashboard() throws FailedOperationException {
		log.debug("Building monitoring dashboard for NS " + nsInstanceId);
		try {
			String tenantId = nsDbWrapper.getNsInfo(nsInstanceId).getTenantId();
			Map<String, String> metadata = new HashMap<>();
			metadata.put("NSD_ID", nsd.getNsdName());
			metadata.put("NS_ID", nsInstanceId);
			MonitoringGui mg = monitoringDriver.buildMonitoringGui(pmJobIds, new Tenant(tenantId, null), metadata);
			log.debug("Built monitoring GUI");
			monitoringGui = mg;
			log.debug("Stored info about monitoring GUI");
		} catch (Exception e) {
			log.error("Error while building monitoring dashboard: " + e.getMessage());
			throw new FailedOperationException("Error while building monitoring dashboard: " + e.getMessage());
		}
	}
	
	private void removeMonitoringDashboard() throws FailedOperationException {
		log.debug("Removing monitoring dashboard for NS " + nsInstanceId);
		String mgId = monitoringGui.getGuiId();
		log.debug("Removing monitoring dashboard with ID " + mgId);
		try {
			monitoringDriver.removeMonitoringGui(mgId);
		} catch (Exception e) {
			log.debug("Failed monitoring GUI removal on monitoring driver: " + e.getMessage());
			throw new FailedOperationException("Failed monitoring GUI removal on monitoring driver: " + e.getMessage());
		}
	}
	
}
