package it.nextworks.nfvmano.timeo.monitoring.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.AlertApi;
import io.swagger.client.api.DashboardApi;
import io.swagger.client.api.ExporterApi;
import io.swagger.client.model.Dashboard;
import io.swagger.client.model.DashboardDescription;
import io.swagger.client.model.DashboardPanel;
import io.swagger.client.model.Endpoint;
import io.swagger.client.model.Exporter;
import io.swagger.client.model.ExporterDescription;
import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.common.exceptions.MethodNotImplementedException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.common.messages.GeneralizedQueryRequest;
import it.nextworks.nfvmano.libs.common.messages.SubscribeRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.PerformanceManagementConsumerInterface;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.ObjectSelection;
import it.nextworks.nfvmano.libs.monit.interfaces.elements.PmJob;
import it.nextworks.nfvmano.libs.monit.interfaces.enums.MonitoringObjectType;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreatePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.CreateThresholdRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeletePmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsRequest;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.DeleteThresholdsResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryPmJobResponse;
import it.nextworks.nfvmano.libs.monit.interfaces.messages.QueryThresholdResponse;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.AbstractExporterInfo;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.ExporterType;
import it.nextworks.nfvmano.timeo.monitoring.driver.prometheus.PrometheusMapper;
import it.nextworks.nfvmano.timeo.monitoring.elements.MonitoringGui;
import it.nextworks.nfvmano.timeo.tenant.Tenant;
import it.nextworks.nfvmano.timeo.vnfm.repository.VnfDbWrapper;
import org.springframework.beans.factory.annotation.Value;

/**
 * Monitoring driver that interacts with a Prometheus monitoring platform through a configuration manager.
 * 
 * 
 * @author nextworks
 *
 */
public class PrometheusMonitoringDriver extends MonitoringAbstractDriver {

	private static final Logger log = LoggerFactory.getLogger(PrometheusMonitoringDriver.class);
	
	private VnfDbWrapper vnfDbWrapper;
	
	private ExporterApi exporterApi;
	
	private DashboardApi dashboardApi;

	//URL to be appended to the dashboard URL in case it is missing
	@Value("${timeo.grafana.url}")
	private String grafanaUrl;
	
	private AlertApi alertApi;
	
	//key: ID of the VNF instance; Value: ID of the node exporter created for that VNF instance
	private Map<String, String> vnfInstanceToNodeExporterMap = new HashMap<>();
	
	//key: ID of the VNF instance; Value: ID of the Telegraf exporter created for that VNF instance
	private Map<String, String> vnfInstanceToTelegrahExporterMap = new HashMap<>();
	
	//key: ID of the pm job; Value: ID of the exporter associated to that pm job
	private Map<String, String> pmJobIdToExporterId = new HashMap<>();
	
	//key: ID of the exporter; Value: List of pm job IDs mapped on the exporter
	private Map<String, List<String>> exporterIdToPmJob = new HashMap<>();
	
	//key: ID of the exporter; Value: ID of the VNF
	private Map<String, String> exporterIdToVnfId = new HashMap<>();
	
	//key: ID of the PM job
	private Map<String, PmJob> pmJobs = new HashMap<>();
	
	//key: ID of the dashboard; Value: List of pm job IDs shown on the dashboard
	private Map<String, List<String>> dashboardIdToPmJobId = new HashMap<>();
	
	//key: ID of the pm job; Value: ID of the dashboard where the pm job is shown.
	//At the moment a pm job ID is shown on a single dashboard. Chech if we need to evolve this.
	private Map<String, String> pmJobIdToDashboardId = new HashMap<>();
	
	//key: ID of the dashboard; Value: details of the dashboard
	private Map<String, MonitoringGui> monitoringGui = new HashMap<>();
	
	public PrometheusMonitoringDriver(String monitoringPlatformUrl, VnfDbWrapper vnfDbWrapper) {
		super(MonitoringDriverType.PROMETHEUS, monitoringPlatformUrl);
		this.vnfDbWrapper = vnfDbWrapper;
		exporterApi = new ExporterApi();
		dashboardApi = new DashboardApi();
		alertApi = new AlertApi();
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(monitoringPlatformUrl);
		exporterApi.setApiClient(apiClient);
		dashboardApi.setApiClient(apiClient);
		alertApi.setApiClient(apiClient);
	}
	
	@Override
	public MonitoringGui buildMonitoringGui(List<String> pmJobIds, Tenant tenant, Map<String, String> metadata) throws MethodNotImplementedException,
			NotExistingEntityException, FailedOperationException, MalformattedElementException {
		log.debug("Building monitoring dashboard");
		DashboardDescription dd = new DashboardDescription();	
		String nsdId = metadata.get("NSD_ID");
		String nsId = metadata.get("NS_ID");
		String name = "Monitoring for network service " + nsdId + " with instance ID " + nsId;
		dd.setName(name);
		//Plotted time: size of the time window in minutes
		int plottedTime = 60;
		dd.setPlottedTime(plottedTime);
		dd.setRefreshTime(DashboardDescription.RefreshTimeEnum._10S);
		List<String> users = new ArrayList<>();
		users.add(tenant.getUserName());
		dd.setUsers(users);
		for (String pmJobId : pmJobIds) {
			if (!(pmJobs.containsKey(pmJobId))) throw new NotExistingEntityException("Failed to build dashboard: pm job ID " + pmJobId + " not found");
			PmJob pmJob = pmJobs.get(pmJobId);
			if (pmJob == null) throw new NotExistingEntityException("Failed to build dashboard: pm job ID " + pmJobId + " not found");
			
			MonitoringObjectType monitoringObjectType = pmJob.getObjectSelector().getObjectType().get(0);  
			String metricType = pmJob.getPerformanceMetric().get(0);
			
			DashboardPanel dp = new DashboardPanel();
			String exporterId = pmJobIdToExporterId.get(pmJobId);
			
			try {
				String query = PrometheusMapper.readPrometheusQuery(monitoringObjectType, metricType, exporterId);
				dp.setQuery(query);
				String title = "VNF instance " + exporterIdToVnfId.get(exporterId) + ": " + pmJob.getPerformanceMetric().get(0);
				dp.setTitle(title);
				dd.addPanelsItem(dp);
				log.debug("Added query " + query + " with title " + title + " to monitoring dashboard.");
			} catch (Exception e) {
				log.warn("Error while generating query for pm job " + pmJobId);	
			}
		}
		try {
			Dashboard dashboard = dashboardApi.postDashboard(dd);
			String dashboardId = dashboard.getDashboardId();
			String url = dashboard.getUrl();
			if(!url.startsWith("http")){
				log.debug("Appending grafana url to dashboard url");
				url=grafanaUrl+url;
			}
			log.debug("Created dashboard with ID " + dashboardId + " with URL: " + url);
			MonitoringGui mg = new MonitoringGui(dashboardId, url);
			dashboardIdToPmJobId.put(dashboardId, pmJobIds);
			for (String pmJobId : pmJobIds) {
				pmJobIdToDashboardId.put(pmJobId, dashboardId);
			}
			monitoringGui.put(dashboardId, mg);
			log.debug("Stored info about monitoring GUI");
			return mg;
		} catch (ApiException e) {
			log.error("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
			throw new FailedOperationException("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
		}
	}

	@Override
	public void removeMonitoringGui(String guiId) throws MethodNotImplementedException, NotExistingEntityException,
			FailedOperationException, MalformattedElementException {
		log.debug("Removing monitoring GUI with ID " + guiId);
		try {
			dashboardApi.deleteDashboard(guiId);
			log.debug("Dashboard removed from Prometheus");
			monitoringGui.remove(guiId);
			List<String> pmJobIdsInGui = dashboardIdToPmJobId.get(guiId);
			for (String pmJobId : pmJobIdsInGui) {
				pmJobIdToDashboardId.remove(pmJobId);
			}
			dashboardIdToPmJobId.remove(guiId);
			log.debug("Dashboard removed from internal maps.");
		} catch (ApiException e) {
			log.error("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
			throw new FailedOperationException("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
		}
	}

	@Override
	public String createPmJobForAggregationRule(String rule, Map<String, String> inputParameters, int collectionPeriod,
			int reportingPeriod) throws MethodNotImplementedException, FailedOperationException,
			MalformattedElementException, NotExistingEntityException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public void deletePmJobForAggregationRule(List<String> pmJobIds) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public String createPmJob(CreatePmJobRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		log.debug("Creating PM job in Prometheus");
		
		if ((request.getNsSelector() != null) || (request.getResourceSelector() != null)) {
			throw new MethodNotImplementedException("PM jobs for NS and resources not yet supported.");
		}
		
		ObjectSelection os = request.getVnfSelector();
		if (os == null) throw new MalformattedElementException("PM job request without object selection.");
		
		String metricType = request.getPerformanceMetric().get(0);

		MonitoringObjectType mot = request.getVnfSelector().getObjectType().get(0);

		String vnfInstanceId = request.getVnfSelector().getObjectInstanceId().get(0);

		
		String vnfdId = request.getPerformanceMetricGroup().get(0);

		String nsInstanceId = request.getPerformanceMetricGroup().get(1);

		
		log.debug("PM job parameters - Metric type: " + metricType + " - Monitoring object type: " + mot + " - VNF ID: " + vnfInstanceId + " - VNFD ID: " + vnfdId + " - NS Instance ID: " + nsInstanceId);
		
		try {
			AbstractExporterInfo exporterInfo = PrometheusMapper.readPrometheusExporterInfo(mot, metricType);

			if (exporterInfo == null) throw new FailedOperationException("Impossible to determine Prometheus exporter");

			if (exporterInfo.getType() == ExporterType.NODE_EXPORTER) {
				log.debug("The PM job requires a node exporter");
				if (vnfInstanceToNodeExporterMap.containsKey(vnfInstanceId)) {
					String exporterId = vnfInstanceToNodeExporterMap.get(vnfInstanceId);
					log.debug("Node exporter for VNF " + vnfInstanceId + " already existing. No need to create a new one. Exporter ID: " + exporterId);
					PmJob pmJob = buildPmJob(os, metricType, request.getCollectionPeriod(), request.getReportingPeriod());
					storePmJobInfo(pmJob, exporterId, null);
					return pmJob.getPmJobId();
				} else {
					log.debug("A new node exporter is required.");
					String exporterId = instantiateExporter(ExporterType.NODE_EXPORTER, vnfInstanceId, nsInstanceId, vnfdId);
					vnfInstanceToNodeExporterMap.put(vnfInstanceId, exporterId);
					PmJob pmJob = buildPmJob(os, metricType, request.getCollectionPeriod(), request.getReportingPeriod());
					storePmJobInfo(pmJob, exporterId, vnfInstanceId);
					return pmJob.getPmJobId();
				}
			} else if (exporterInfo.getType() == ExporterType.TELEGRAF_EXPORTER) {
				log.debug("The PM job requires a telegraf exporter");
				if (vnfInstanceToTelegrahExporterMap.containsKey(vnfInstanceId)) {
					String exporterId = vnfInstanceToTelegrahExporterMap.get(vnfInstanceId);
					log.debug("Telegraf exporter for VNF " + vnfInstanceId + " already existing. No need to create a new one. Exporter ID: " + exporterId);
					PmJob pmJob = buildPmJob(os, metricType, request.getCollectionPeriod(), request.getReportingPeriod());
					storePmJobInfo(pmJob, exporterId, null);
					return pmJob.getPmJobId();
				} else {
					log.debug("A new telegraf exporter is required.");
					String exporterId = instantiateExporter(ExporterType.TELEGRAF_EXPORTER, vnfInstanceId, nsInstanceId, vnfdId);
					vnfInstanceToTelegrahExporterMap.put(vnfInstanceId, exporterId);

					PmJob pmJob = buildPmJob(os, metricType, request.getCollectionPeriod(), request.getReportingPeriod());
					storePmJobInfo(pmJob, exporterId, vnfInstanceId);
					return pmJob.getPmJobId();
				}
			} else {
				throw new FailedOperationException("Unsupported Prometheus exporter type");
			}
		} catch (Exception e) {
			throw new FailedOperationException("Generic exception while determining Prometheus exporter" + e.getMessage());
		}
	}

	@Override
	public DeletePmJobResponse deletePmJob(DeletePmJobRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		log.debug("Removing pm jobs.");
		List<String> removed = new ArrayList<>();
		List<String> toBeRemoved = request.getPmJobId();
		for (String pmJobId : toBeRemoved) {
			log.debug("Removing pm job " + pmJobId);
			String exporterId = pmJobIdToExporterId.get(pmJobId);
			log.debug("Exporter associated to pm job " + pmJobId + ": " + exporterId);
			List<String> pmJobsInExp = exporterIdToPmJob.get(exporterId);
			pmJobsInExp.remove(pmJobId);
			pmJobIdToExporterId.remove(pmJobId);
			PmJob pmJob = pmJobs.get(pmJobId);
			ExporterType exporterType = ExporterType.UNDEFINED;
			try {
				exporterType = PrometheusMapper.readPrometheusExporterInfo(pmJob.getObjectSelector().getObjectType().get(0), pmJob.getPerformanceMetric().get(0)).getType();
			} catch (Exception e) {
				log.error("Impossible to determine exporter type: " + e.getMessage());
			}
			pmJobs.remove(pmJobId);
			log.debug("PM job removed from internal structures.");
			if (pmJobIdToDashboardId.containsKey(pmJobId)) {
				//TODO: check if we need to update dashboard at this stage.
				log.debug("PM job " + pmJobId + " associated to dashboard.");
				String guiId = pmJobIdToDashboardId.get(pmJobId);
				List<String> pmJobsInGui = dashboardIdToPmJobId.get(guiId);
				pmJobsInGui.remove(pmJobId);
				dashboardIdToPmJobId.replace(guiId, pmJobsInGui);
				pmJobIdToDashboardId.remove(pmJobId);
				log.debug("Removed association PM job - dashboard from internal structure.");
			}
			if (pmJobsInExp.isEmpty()) {
				log.debug("Exporter " + exporterId + " no more in use. It can be removed.");
				try {
					exporterApi.deleteExporter(exporterId);
					log.debug("Exporter " + exporterId + " removed from Prometheus.");
				} catch (ApiException e) {
					log.error("Failed to remove exporter " + exporterId + " from Prometheus. Continuing to remove internally.");
				}
				exporterIdToPmJob.remove(exporterId);
				String vnfId = exporterIdToVnfId.get(exporterId);
				if (exporterType.equals(ExporterType.NODE_EXPORTER)) vnfInstanceToNodeExporterMap.remove(vnfId);
				else if (exporterType.equals(ExporterType.TELEGRAF_EXPORTER)) vnfInstanceToTelegrahExporterMap.remove(vnfId);
				log.debug("Removed exporter from internal maps.");
			} else {
				log.debug("Exporter " + exporterId + " still serving " + pmJobsInExp.size() + " pm jobs. It cannot be removed.");
				exporterIdToPmJob.replace(exporterId, pmJobsInExp);
				log.debug("Exporter map updated.");
			}
			removed.add(pmJobId);
		}
		return new DeletePmJobResponse(removed);
	}

	@Override
	public String subscribe(SubscribeRequest request, PerformanceManagementConsumerInterface consumer)
			throws MethodNotImplementedException, MalformattedElementException, FailedOperationException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public void unsubscribe(String subscriptionId) throws MethodNotImplementedException, MalformattedElementException,
			NotExistingEntityException, FailedOperationException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public QueryPmJobResponse queryPmJob(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			FailedOperationException, MalformattedElementException, NotExistingEntityException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public String createThreshold(CreateThresholdRequest request)
			throws MethodNotImplementedException, FailedOperationException, MalformattedElementException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public DeleteThresholdsResponse deleteThreshold(DeleteThresholdsRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public QueryThresholdResponse queryThreshold(GeneralizedQueryRequest request) throws MethodNotImplementedException,
			NotExistingEntityException, MalformattedElementException, FailedOperationException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	@Override
	public void queryPerformanceMonitoringSubscription(GeneralizedQueryRequest request)
			throws MethodNotImplementedException, NotExistingEntityException, FailedOperationException,
			MalformattedElementException {
		//TODO:
				throw new MethodNotImplementedException("Method not implemented");
	}

	private PmJob buildPmJob(ObjectSelection os, String performanceMetric, int collectionPeriod, int reportingPeriod) {
		String pmJobId = UUID.randomUUID().toString();
		List<String> performanceMetrics  = new ArrayList<>();
		performanceMetrics.add(performanceMetric);
		log.debug("Created new pm job ID: " + pmJobId);
		return new PmJob(pmJobId, os, performanceMetrics, new ArrayList<>(), collectionPeriod, reportingPeriod, null);
	}
	
	private void storePmJobInfo(PmJob pmJob, String exporterId, String vnfInstanceId) {
		String pmJobId = pmJob.getPmJobId();
		pmJobIdToExporterId.put(pmJobId, exporterId);
		List<String> exporterPMJobList =  exporterIdToPmJob.get(exporterId);
		if(!exporterIdToPmJob.containsKey(exporterId)){
			exporterPMJobList = new ArrayList<String>();
		}
		exporterPMJobList.add(pmJobId);
		exporterIdToPmJob.put(exporterId,exporterPMJobList);
		pmJobs.put(pmJobId, pmJob);
		if (vnfInstanceId != null) exporterIdToVnfId.put(exporterId, vnfInstanceId);
		log.debug("Stored info about pm job: " + pmJobId+" exporter: "+exporterId);
	}
	
	private String instantiateExporter(ExporterType type, String vnfInstanceId, String nsId, String vnfdId) 
			throws NotExistingEntityException, FailedOperationException {
		log.debug("Instantiating exporter of type " + type + " for VNF instance " + vnfInstanceId);
		String vnfIpAddress = vnfDbWrapper.getVnfManagementIpAddress(vnfInstanceId);
		int port = PrometheusMapper.getPrometheusExporterPort(type);
		ExporterDescription exporterDescription = new ExporterDescription();
		List<Endpoint> eps = new ArrayList<>();
		Endpoint ep = new Endpoint();
		ep.setAddress(vnfIpAddress);
		ep.setPort(port);
		eps.add(ep);
		exporterDescription.setName(type.toString()+vnfInstanceId+"_"+vnfdId);
		exporterDescription.setEndpoint(eps);
		exporterDescription.setNsId(nsId);
		exporterDescription.setVnfdId(vnfdId);
		exporterDescription.setCollectionPeriod(1);
		try {
			Exporter exporter = exporterApi.postExporter(exporterDescription);
			log.debug("Returned exporter: " + exporter.toString());
			String exporterId = exporter.getExporterId();
			log.debug("Created exporter " + exporterId + " with type " + type + " for VNF instance " + vnfInstanceId);
			return exporterId;
		} catch (ApiException e) {
			log.error("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
			throw new FailedOperationException("API exception while invoking Monitoring Config Manager client: " + e.getMessage());
		}
	}
	
}
