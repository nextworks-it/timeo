package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityValue;
import io.swagger.client.model.CapacityValue.UnitEnum;
import io.swagger.client.model.ConnectivityConstraint;
import io.swagger.client.model.ConnectivityConstraint.ServiceTypeEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.ConnectivityServiceEndPoint.DirectionEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint.LayerProtocolNameEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint.ProtectionRoleEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint.RoleEnum;
import io.swagger.client.model.CreateConnectivityServiceRPCInputSchema;
import io.swagger.client.model.*;
import io.swagger.client.model.ServiceInterfacePointRef;
import it.nextworks.nfvmano.libs.common.enums.ResponseCode;
import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerConsumerInterface;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPath;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.elements.SbNetworkPathType;

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
			try {
				SbNetworkPathType npt = np.getSbNpType();
				switch (npt) {
				case SDM: {
					log.debug("SDM network path.");
					buildSdmPath(np);
					break;
				}

				case AROF: {
					log.debug("AROF network path.");
					buildArofPath(np);
					break;
				}

				default: {
					log.debug("Unacceptable type of network path: skipping it.");
					break;
				}
				}
			} catch (ApiException e) {
				log.error("Got API exception while creating connectivity service");
				consumer.notifySdnControllerOperationResult(operationId, ResponseCode.FAILED_GENERIC, "Got API exception while creating connection " + np.getNetworkPathId() + ": " + e.getMessage());
				return;
			}
		}
		consumer.notifySdnControllerOperationResult(operationId, ResponseCode.OK, null);

	}

	private void buildSdmPath(SbNetworkPath np) throws ApiException {
		String csUuid = np.getNetworkPathId();
		log.debug("Creating path with ID " + csUuid);

		CreateConnectivityServiceRPCInputSchema connectivityService = new CreateConnectivityServiceRPCInputSchema();
		connectivityService.setUuid(csUuid);

		//Getting ingress and egress service interface points from the first and last hop
		NetworkPathHop nphSrc = np.getHops().get(0);
		NetworkPathHop nphDst = np.getHops().get(np.getHops().size()-1);
		String source = nphSrc.getIngressServiceInterfacePoint();
		String destination = nphDst.getEgressServiceInterfacePoint();
		log.debug("Source SIP: " + source + " - Destination SIP: " + destination);

		ConnectivityServiceEndPoint srcEp = new ConnectivityServiceEndPoint();
		ConnectivityServiceEndPoint dstEp = new ConnectivityServiceEndPoint();

		srcEp.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		srcEp.setProtectionRole(ProtectionRoleEnum.WORK);
		srcEp.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_SDM");	//TODO: check what should go here
		srcEp.setRole(RoleEnum.UNKNOWN);

		srcEp.setLocalId(source);
		srcEp.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef srcSip = new ServiceInterfacePointRef();
		srcSip.setServiceInterfacePointUuid(source);
		srcEp.setServiceInterfacePoint(srcSip);

		dstEp.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		dstEp.setProtectionRole(ProtectionRoleEnum.WORK);
		dstEp.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_SDM");	//TODO: check what should go here
		dstEp.setRole(RoleEnum.UNKNOWN);

		dstEp.setLocalId(destination);
		dstEp.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef dstSip = new ServiceInterfacePointRef();
		dstSip.setServiceInterfacePointUuid(destination);
		dstEp.setServiceInterfacePoint(dstSip);

		connectivityService.addEndPointItem(srcEp);
		connectivityService.addEndPointItem(dstEp);
		log.debug("Connectivity Service EndPoints built");

		//TODO: at the moment the capacity is static. To be read dynamically and encoded in the SbNetworkPath
		ConnectivityConstraint cc = new ConnectivityConstraint();
		Capacity requestedCapacity = new Capacity();
		CapacityValue totalSize = new CapacityValue();
		totalSize.setUnit(CapacityValue.UnitEnum.GHZ);
		totalSize.setValue("50");
		requestedCapacity.setTotalSize(totalSize);
		cc.setRequestedCapacity(requestedCapacity);
		connectivityService.setConnectivityConstraint(cc);
		log.debug("Capacity statically set.");

		cc.setServiceType(ServiceTypeEnum.POINT_TO_POINT_CONNECTIVITY);

		//TODO: check how to encode SDM information

		CreateConnectivityServiceRPCInputSchema response = api.createCreateConnectivityServiceById(connectivityService);
		String createdConnectivityService = response.getUuid();
		if(createdConnectivityService==null || !csUuid.equals(createdConnectivityService)) {
			log.error("Returned TAPI ConnectivityService uuid null or different than specified");
			throw new ApiException();
		}
		log.debug("Created connectivity service " + createdConnectivityService);


	}

	private void buildArofPath(SbNetworkPath np) throws ApiException {
		String csUuid = np.getNetworkPathId();
		log.debug("Creating path with ID " + csUuid);

		CreateConnectivityServiceRPCInputSchema createConnectivityService = new CreateConnectivityServiceRPCInputSchema();
		createConnectivityService.setUuid(csUuid);

		//Getting ingress and egress service interface points from the first and last hop
		//For AROF there is a single hop within a single node
		NetworkPathHop nph = np.getHops().get(0);
		String source = nph.getIngressServiceInterfacePoint();
		String destination = nph.getEgressServiceInterfacePoint();
		log.debug("Source SIP: " + source + " - Destination SIP: " + destination);



		ConnectivityServiceEndPoint srcEndpoint = new ConnectivityServiceEndPoint();
		srcEndpoint.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		srcEndpoint.setProtectionRole(ProtectionRoleEnum.WORK);
		srcEndpoint.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_AROF");
		srcEndpoint.setRole(RoleEnum.UNKNOWN);

		srcEndpoint.setLocalId(source);
		srcEndpoint.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef srcSip = new ServiceInterfacePointRef();

		srcSip.setServiceInterfacePointUuid(source);

		srcEndpoint.setServiceInterfacePoint(srcSip);
		createConnectivityService.addEndPointItem(srcEndpoint);


		ConnectivityServiceEndPoint dstEndpoint = new ConnectivityServiceEndPoint();
		dstEndpoint.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		dstEndpoint.setProtectionRole(ProtectionRoleEnum.WORK);
		dstEndpoint.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_AROF");
		dstEndpoint.setRole(RoleEnum.UNKNOWN);
		dstEndpoint.setLocalId(destination);
		dstEndpoint.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef dstSip = new ServiceInterfacePointRef();
		dstSip.setServiceInterfacePointUuid(destination);
		dstEndpoint.setServiceInterfacePoint(dstSip);
		createConnectivityService.addEndPointItem(dstEndpoint);

		ConnectivityConstraint cc = new ConnectivityConstraint();
		Capacity c = new Capacity();
		CapacityValue cv = new CapacityValue();
		cv.setUnit(UnitEnum.GHZ);
		cv.setValue("50");
		c.setTotalSize(cv);
		cc.setRequestedCapacity(c);
		log.debug("Issuing TAPI request to:" + api.getApiClient().getBasePath());
		createConnectivityService.setConnectivityConstraint(cc);
		//CTTC server replies back with the same request issued 
		CreateConnectivityServiceRPCInputSchema response = api.createCreateConnectivityServiceById(createConnectivityService);

		String replyUuid = response.getUuid();
		log.debug("Created connectivity service " + replyUuid);
	}

	//	/**
	//	 * This method builds a Connectivity Service Endpoint in the format required by the TAPI CS service
	//	 * 
	//	 * @param sipUuid UUID of the Service Interface Point corresponding to the CS endpoint
	//	 * @param localId ID assigned locally to the CS endpoint
	//	 * @return the Connectivity Service Endpoint in the correct format
	//	 */
	//	private ConnectivityServiceEndPoint buildConnectivityServicePoint(String sipUuid, String localId) {
	//		ConnectivityServiceEndPoint csEp = new ConnectivityServiceEndPoint();
	//		csEp.setDirection(DirectionEnum.BIDIRECTIONAL);
	//		csEp.setLayerProtocolName(ConnectivityServiceEndPoint.LayerProtocolNameEnum.ETH);
	//		//csEp.setLocalId(localId);
	//		csEp.setRole(ConnectivityServiceEndPoint.RoleEnum.SYMMETRIC);
	//		String siprString = "/restconf/config/context/service-interface-point/" + sipUuid;
	//		ServiceInterfacePointRef sipr = new ServiceInterfacePointRef();
	//		sipr.setServiceInterfacePointUuid(siprString);
	//		csEp.setServiceInterfacePoint(sipr);
	//		return csEp;
	//	}

}
