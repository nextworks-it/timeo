package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import io.swagger.client.model.*;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;

/**
 * This task is a TAPI consumer that interacts with the SDN controller
 * (i.e. the TAPI provider) to remove one or more paths. When the task 
 * is finished, a notification is sent to the original requester, 
 * provided as input in the consumer field. 
 * 
 * @author nextworks
 *
 */
public class TapiRemovePathTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(TapiRemovePathTask.class);
	
	private String operationId;
	private DefaultApi api;
	private SdnControllerConsumerInterface consumer;
	private List<String> networkPathIds = new ArrayList<>();
	private List<SbNetworkPath> networkPaths = new ArrayList<>();

	//private ObfnCSRecordRepository obfnCSRecordRepository;
	private  SbNetworkPathType sbNpType;
	
	/**
	 * Constructor
	 * 
	 * @param operationId ID of the delete operation
	 * @param api Handler to interact with the TAPI provider
	 * @param consumer Entity to be notified about the result of the operation
	 * @param networkPaths SB of the paths to be removed
	 */
	public TapiRemovePathTask(String operationId,
							  DefaultApi api,
							  SdnControllerConsumerInterface consumer,
							  List<SbNetworkPath> networkPaths
							  //ObfnCSRecordRepository obfnCSRecordRepository,
							  //SbNetworkPathType sbNpType
							  ) {
		this.operationId = operationId;
		this.api = api;
		this.consumer = consumer;

		if (networkPaths != null){
			this.networkPaths = networkPaths;
			this.networkPathIds = networkPaths.stream().map(e -> e.getNetworkPathId()).collect(Collectors.toList());
		}
		//this.obfnCSRecordRepository = obfnCSRecordRepository;
		//this.sbNpType = sbNpType;
	}

	@Override
	public void run() {
		log.debug("Executing thread to remove network paths through TAPI connectivity service");
		for (SbNetworkPath path : networkPaths) {
			log.debug("Removing connection with ID " + path.getNetworkPathId());
			try {
				if(path.getSbNpType().equals(SbNetworkPathType.OBFN)){
					removeObfnPath(path);
				}else{
					api.createDeleteConnectivityServiceById(path.getNetworkPathId());
					log.debug("Removed connection with ID " + path.getNetworkPathId());
				}

			} catch (ApiException e) {
				log.debug("Got API exception while removing connection " + path.getNetworkPathId() + ": " + e.getMessage());
				consumer.notifySdnControllerOperationResult(operationId, ResponseCode.FAILED_GENERIC, "Got API exception while removing connection " + path.getNetworkPathId());
				return;
			}
		}
		consumer.notifySdnControllerOperationResult(operationId, ResponseCode.OK, null);
	}


	private void removeObfnPath(SbNetworkPath networkPath) throws ApiException {
		log.debug("Creating /Updating network path");
		ContextSchema response = null;



		response = api.retrieveContext();

		Map<String, List<String>> activePaths = TapiTopologyUtilities.getObfnActivePaths(response);

		for(NetworkPathHop nph : networkPath.getHops()){

			String source = nph.getIngressServiceInterfacePoint();
			String destination = nph.getEgressServiceInterfacePoint();
			String activeConnectionId = getActiveConnectionId(activePaths, source, destination);
			List<String> activeBeams = TapiTopologyUtilities.getObfnUsedBeams(activeConnectionId, response);
			if(activeBeams.size()==1){
				log.debug("Delete CS:"+activeConnectionId);
				api.createDeleteConnectivityServiceById(activeConnectionId);
			}else{
				log.debug("UPDATE CS:"+activeConnectionId);
				CreateConnectivityServiceRPCInputSchema createConnectivityService = new CreateConnectivityServiceRPCInputSchema();


				//Getting ingress and egress service interface points from the first and last hop
				//For AROF there is a single hop within a single node


				log.debug("Source SIP: " + source + " - Destination SIP: " + destination);
				ConnectivityServiceEndPoint srcEndpoint = new ConnectivityServiceEndPoint();
				srcEndpoint.setLayerProtocolName(ConnectivityServiceEndPoint.LayerProtocolNameEnum.PHOTONIC_MEDIA);
				srcEndpoint.setProtectionRole(ConnectivityServiceEndPoint.ProtectionRoleEnum.WORK);
				srcEndpoint.setLayerProtocolQualifier("tapi-obfn:PHOTONIC_LAYER_QUALIFIER_OBFN");
				srcEndpoint.setRole(ConnectivityServiceEndPoint.RoleEnum.UNKNOWN);
				srcEndpoint.setLocalId(source);
				srcEndpoint.setDirection(ConnectivityServiceEndPoint.DirectionEnum.UNIDIRECTIONAL);
				ServiceInterfacePointRef srcSip = new ServiceInterfacePointRef();
				srcSip.setServiceInterfacePointUuid(source);
				srcEndpoint.setServiceInterfacePoint(srcSip);
				ConnectivityServiceEndPoint dstEndpoint = new ConnectivityServiceEndPoint();
				dstEndpoint.setLayerProtocolName(ConnectivityServiceEndPoint.LayerProtocolNameEnum.PHOTONIC_MEDIA);
				dstEndpoint.setProtectionRole(ConnectivityServiceEndPoint.ProtectionRoleEnum.WORK);
				dstEndpoint.setLayerProtocolQualifier("tapi-obfn:PHOTONIC_LAYER_QUALIFIER_OBFN");
				dstEndpoint.setRole(ConnectivityServiceEndPoint.RoleEnum.UNKNOWN);
				dstEndpoint.setLocalId(destination);
				dstEndpoint.setDirection(ConnectivityServiceEndPoint.DirectionEnum.UNIDIRECTIONAL);
				ServiceInterfacePointRef dstSip = new ServiceInterfacePointRef();
				dstSip.setServiceInterfacePointUuid(destination);
				dstEndpoint.setServiceInterfacePoint(dstSip);
				createConnectivityService.addEndPointItem(srcEndpoint);
				createConnectivityService.addEndPointItem(dstEndpoint);
				ConnectivityConstraint cc = new ConnectivityConstraint();
				Capacity c = new Capacity();
				ObfnConnectivityConstraintSpec obfnConnectivityConstraintSpec  = new ObfnConnectivityConstraintSpec();
				Map<String,String> hopProps = nph.getHopProperties();
				List<Obfn> obfnPool = new ArrayList<>();
				Obfn obfn = new Obfn();
				obfn.setBeamEnable(false);
				obfn.setObfnId(new Integer(hopProps.get("beamId")));
				obfn.setWidth(new Integer(hopProps.get(("beamWidth"))));
				obfn.setXOffsetAngle(new Integer(hopProps.get("beamOffsetX")));
				obfn.setYOffsetAngle(new Integer(hopProps.get("beamOffsetY")));
				log.debug("Retrieved obfn specs:"+hopProps);
				obfnPool.add(obfn);
				obfnConnectivityConstraintSpec.setObfnPool(obfnPool);
				CapacityValue cv = new CapacityValue();
				cv.setUnit(CapacityValue.UnitEnum.GBPS);
				cv.setValue(50);
				c.setTotalSize(cv);
				cc.setConnectivityDirection(ConnectivityConstraint.ConnectivityDirectionEnum.UNIDIRECTIONAL);
				cc.setRequestedCapacity(c);

				createConnectivityService.setConnectivityConstraint(cc);
				log.debug("Setting obfnConnectivityConstraint");
				createConnectivityService.setObfnConnectivityConstraintSpec(obfnConnectivityConstraintSpec);
				List<WavelengthReference> wavelengthResourcePool = new ArrayList<>();
				WavelengthReference wavelengthReference = new WavelengthReference();

				CentralFrequency cf = new CentralFrequency();
				cf.setCentralFrequency(Float.parseFloat(hopProps.get("centralFrequency")));
				FrequencyConstraint fc = new FrequencyConstraint();
				fc.setAdjustmentGranularity(FrequencyConstraint.AdjustmentGranularityEnum.G_6_25GHZ);
				fc.setGridType(FrequencyConstraint.GridTypeEnum.FLEX);
				cf.setFrequencyConstraint(fc);
				//wavelengthReference.setWavelengthId(0);
				wavelengthReference.setCentralFrequency(cf);
				wavelengthResourcePool.add(wavelengthReference);
				obfnConnectivityConstraintSpec.setWavelengthReferencePool(wavelengthResourcePool);
				createConnectivityService.setUuid(activeConnectionId);
				String json = new Gson().toJson(createConnectivityService);
				log.debug(json);
				CreateConnectivityServiceRPCInputSchema responseCreate = api.updateCreateConnectivityServiceById(createConnectivityService);
				String replyUuid = responseCreate.getUuid();
				log.debug("pUT connectivity service " + replyUuid);
			}




		}
	}

	private String getActiveConnectionId(Map<String, List<String>> activeConnections, String ingressSip, String egressSip){
		log.debug("Retrieving current connection between: "+ingressSip+" "+egressSip);
		for(String connectionUuid: activeConnections.keySet()){
			List<String> sips = activeConnections.get(connectionUuid);
			if(sips.get(0).equals(ingressSip)&&sips.get(1).equals(egressSip)) {
				log.debug("FOUND active connection:"+ connectionUuid);
				return connectionUuid;
			}
		}
		log.debug("NO active connection FOUND");
		return null;
	}






}
