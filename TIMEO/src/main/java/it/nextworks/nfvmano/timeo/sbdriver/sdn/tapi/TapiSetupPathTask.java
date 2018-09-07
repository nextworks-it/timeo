package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityValue;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.ConnectivityServiceSchema;
import io.swagger.client.model.FrequencySlot;
import io.swagger.client.model.SdmTerminationPac;
import io.swagger.client.model.ConnectivityServiceEndPoint.DirectionEnum;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;

/**
 * This task is a TAPI consumer that interacts with the SDN controller
 * (i.e. the TAPI provider) to setup one or more paths. When the task 
 * is finished, a notification is sent to the original requester, 
 * provided as input in the consumer field. 
 * 
 * @author nextworks
 *
 */
public class TapiSetupPathTask implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(TapiSetupPathTask.class);
	
	private String operationId;
	private DefaultApi api;
	private SdnControllerConsumerInterface consumer;
	private List<SbNetworkPath> networkPath = new ArrayList<>();
	
	
	/**
	 * Constructor
	 * 
	 * @param operationId ID of the setup operation 
	 * @param api Handler to interact with the TAPI provider
	 * @param consumer Entity to be notified about the result of the operation
	 * @param networkPath Description of the paths to be established
	 */
	public TapiSetupPathTask(String operationId,
			DefaultApi api,
			SdnControllerConsumerInterface consumer,
			List<SbNetworkPath> networkPath) {
		this.operationId = operationId;
		this.api = api;
		this.consumer = consumer;
		if (networkPath != null) this.networkPath = networkPath;
	}
	
	@Override
	public void run() {
		log.debug("Executing thread to create network path through TAPI connectivity service");
		for (SbNetworkPath np : networkPath) {
			String csUuid = np.getNetworkPathId();
			log.debug("Creating path with ID " + csUuid);
			ConnectivityServiceSchema connectivityService = new ConnectivityServiceSchema();
			
			//Getting ingress and egress service interface points from the first and last hop
			NetworkPathHop nphSrc = np.getHops().get(0);
			NetworkPathHop nphDst = np.getHops().get(np.getHops().size()-1);
			String source = nphSrc.getIngressServiceInterfacePoint();
			String destination = nphDst.getEgressServiceInterfacePoint();
			log.debug("Source SIP: " + source + " - Destination SIP: " + destination);
			
			ConnectivityServiceEndPoint srcEp = buildConnectivityServicePoint(source, csUuid+"-SRC");
			ConnectivityServiceEndPoint dstEp = buildConnectivityServicePoint(destination, csUuid+"-DST");
			connectivityService.addEndPointItem(srcEp);
			connectivityService.addEndPointItem(dstEp);
			log.debug("Connectivity Service EndPoints built");
			
			connectivityService.setUuid(csUuid);
			connectivityService.setServiceType(ConnectivityServiceSchema.ServiceTypeEnum.POINT_TO_POINT_CONNECTIVITY);
			
			//TODO: at the moment the capacity is static. To be read dynamically and encoded in the SbNetworkPath
			Capacity requestedCapacity = new Capacity();
			CapacityValue totalSize = new CapacityValue();
			totalSize.setUnit(CapacityValue.UnitEnum.MBPS);
			totalSize.setValue("100");
			requestedCapacity.setTotalSize(totalSize);
			connectivityService.setRequestedCapacity(requestedCapacity);
			log.debug("Capacity statically set.");
			
			//TODO: at the moment the SDM info are static. To be read dynamically and encoded in an extension of the SbNetworkPath
			SdmTerminationPac includeCore = new SdmTerminationPac();
			includeCore.setCoreId("1");
			FrequencySlot fs = new FrequencySlot();
			fs.setSlotId("1");
			includeCore.addSelectedFrequencySlotItem(fs);
			connectivityService.setIncludeCore(includeCore);
			log.debug("SDM info statically set.");
			
			try {
				api.createContextConnectivityServiceConnectivityServiceById(csUuid, connectivityService);
				log.debug("Created connectivity service with ID " + csUuid);
			} catch (ApiException e) {
				log.error("Got API exception while creating connectivity service");
				consumer.notifySdnControllerOperationResult(operationId, ResponseCode.FAILED_GENERIC, "Got API exception while creating connection " + csUuid + ": " + e.getMessage());
				return;
			}
		}
		consumer.notifySdnControllerOperationResult(operationId, ResponseCode.OK, null);

	}
	
	/**
	 * This method builds a Connectivity Service Endpoint in the format required by the TAPI CS service
	 * 
	 * @param sipUuid UUID of the Service Interface Point corresponding to the CS endpoint
	 * @param localId ID assigned locally to the CS endpoint
	 * @return the Connectivity Service Endpoint in the correct format
	 */
	private ConnectivityServiceEndPoint buildConnectivityServicePoint(String sipUuid, String localId) {
		ConnectivityServiceEndPoint csEp = new ConnectivityServiceEndPoint();
		csEp.setDirection(DirectionEnum.BIDIRECTIONAL);
		csEp.setLayerProtocolName(ConnectivityServiceEndPoint.LayerProtocolNameEnum.ETH);
		//csEp.setLocalId(localId);
		csEp.setRole(ConnectivityServiceEndPoint.RoleEnum.SYMMETRIC);
		String siprString = "/restconf/config/context/service-interface-point/" + sipUuid;
		csEp.setServiceInterfacePoint(siprString);
		return csEp;
	}

}
