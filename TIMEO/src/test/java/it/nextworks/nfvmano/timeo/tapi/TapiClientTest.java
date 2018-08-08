package it.nextworks.nfvmano.timeo.tapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityValue;
import io.swagger.client.model.Connection.LayerProtocolNameEnum;
import io.swagger.client.model.ConnectivityService;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.ConnectivityServiceEndPoint.DirectionEnum;
import io.swagger.client.model.ConnectivityServiceSchema;
import io.swagger.client.model.ContextSchema;
import io.swagger.client.model.CoreSlot;
import io.swagger.client.model.FrequencySlot;
import io.swagger.client.model.GetTopologyListRPCOutputSchema;
import io.swagger.client.model.Link;
import io.swagger.client.model.Node;
import io.swagger.client.model.NodeEdgePoint;
import io.swagger.client.model.NominalCentralFrequencyOrWavelength;
import io.swagger.client.model.OwnedNodeEdgePointSchema;
import io.swagger.client.model.SdmPoolPac;
import io.swagger.client.model.SdmTerminationPac;
import io.swagger.client.model.ServiceInterfacePoint;
import io.swagger.client.model.ServiceInterfacePointRef;
import io.swagger.client.model.Topology;

public class TapiClientTest {

	public TapiClientTest() { }
	
	/*
	@Test
	public void testServiceInterfacePoint() {
		DefaultApi api = new DefaultApi();
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8182/restconf");
		api.setApiClient(apiClient);
		
		try {
			ContextSchema response = api.retrieveContext();
			System.out.println("Context retrieved.");
			
			List<ServiceInterfacePoint> sips = response.getServiceInterfacePoint();
			System.out.println("Retrieved " + sips.size() + " Service Interface Points");
			for (ServiceInterfacePoint sip : sips) {
				System.out.println(sip.toString());
			}
			
		} catch (ApiException e) {
			System.out.println("Exception while getting service interface points");
		}
	}
	*/
	
	/*
	@Test
	public void testGetTopology() {
		DefaultApi api = new DefaultApi();
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8182/restconf");
		api.setApiClient(apiClient);
		
		try {
			
			
			ContextSchema response = api.retrieveContext();
			//System.out.println(response.toString());
			
			List<String> topologyIds = api.retrieveContextTopologyTopology();
			System.out.println("Found " + topologyIds.size() + " topologies");
			
			for (String t : topologyIds) {
				
				System.out.println("Topology URL: " + t);
				String[] parts = t.split("/");
				String uuid = parts[parts.length - 1];
				System.out.println("Topology ID: " + uuid);
				
				Topology topology = api.retrieveContextTopologyTopologyById(uuid);
				System.out.println("Retrieved topology with ID: " + uuid);
				//System.out.println(topology.toString());
				
				List<Link> links = topology.getLink();
				List<Node> nodes = topology.getNode();
				
				System.out.println("The topology " + uuid + " has " + nodes.size() + " nodes and " + links.size() + " links.");
				
				List<Node> ethNodes = new ArrayList<Node>();
				List<Node> sdmNodes = new ArrayList<Node>();
				
				for (Node n : nodes) {
					Node.LayerProtocolNameEnum proto = n.getLayerProtocolName().get(0);
					if (proto.equals(Node.LayerProtocolNameEnum.ETH)) ethNodes.add(n);
					else if (proto.equals(Node.LayerProtocolNameEnum.SDM)) sdmNodes.add(n);
				}
				System.out.println("The topology " + uuid + " has " + ethNodes.size() + " ETH nodes and " + sdmNodes.size() + " SDM nodes.");
				
				for (Node n : ethNodes) {
					List<NodeEdgePoint> ports = n.getOwnedNodeEdgePoint();
					List<NodeEdgePoint> sdmPorts = new ArrayList<NodeEdgePoint>();
					List<NodeEdgePoint> ethPorts = new ArrayList<NodeEdgePoint>();
					for (NodeEdgePoint p : ports) {
						NodeEdgePoint.LayerProtocolNameEnum proto = p.getLayerProtocolName();
						if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.ETH)) ethPorts.add(p);
						else if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.SDM)) sdmPorts.add(p);
					}
					System.out.println("The ETH node " + n.getUuid() + " has " + ethPorts.size() + " ETH ports and " + sdmPorts.size() + " SDM ports.");
				}
				
				for (Node n : sdmNodes) {
					List<NodeEdgePoint> ports = n.getOwnedNodeEdgePoint();
					List<NodeEdgePoint> sdmPorts = new ArrayList<NodeEdgePoint>();
					List<NodeEdgePoint> ethPorts = new ArrayList<NodeEdgePoint>();
					for (NodeEdgePoint p : ports) {
						NodeEdgePoint.LayerProtocolNameEnum proto = p.getLayerProtocolName();
						if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.ETH)) ethPorts.add(p);
						else if (proto.equals(NodeEdgePoint.LayerProtocolNameEnum.SDM)) {
							//TODO: how to get info about the SDM pool???
							sdmPorts.add(p);
							OwnedNodeEdgePointSchema nodeSchema = api.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid, n.getUuid(), p.getUuid());
							SdmPoolPac sdmPool = nodeSchema.getSdmPool();
							List<CoreSlot> coreSlots = sdmPool.getAvailableCore();
							System.out.println("Port " + p.getUuid() + " has " + coreSlots.size() + " core slots.");
							for (CoreSlot cs : coreSlots) {
								String coreID = cs.getCoreId();
								List<FrequencySlot> afss = cs.getAvailableFrequencySlot();
								List<FrequencySlot> ofss = cs.getOccupiedFrequencySlot();
								if (afss != null) {
									System.out.println("Core slot " + coreID + " has " + afss.size() + " available frequency slots.");
									for (FrequencySlot fs : afss) {
										NominalCentralFrequencyOrWavelength freq = fs.getNominalCentralFrequency();
										String slotId = fs.getSlotId();
										String slotWN = fs.getSlotWidthNumber();
									}
								}
							}
						}
					}
					System.out.println("The SDM node " + n.getUuid() + " has " + ethPorts.size() + " ETH ports and " + sdmPorts.size() + " SDM ports.");
					if (ethPorts.size() > 0) System.out.println("Warning: an SDM node should not have ETH ports");
				}
			}
			
		} catch (ApiException e) {
			System.out.println("Exception while getting topology");
		}
	}
	*/
	
	/*
	@Test
	public void testConnectivityService() {
		DefaultApi api = new DefaultApi();
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath("http://localhost:8182/restconf");
		api.setApiClient(apiClient);
		
		try {
			ContextSchema response = api.retrieveContext();
			System.out.println("Context retrieved.");
			
			List<ServiceInterfacePoint> sips = response.getServiceInterfacePoint();
			System.out.println("Retrieved " + sips.size() + " Service Interface Points");
			for (ServiceInterfacePoint sip : sips) {
				System.out.println(sip.toString());
			}
			if (sips.size() > 1) {
				System.out.println("Starting procedure to create connectivity service between the first two sips");
				//Here we should also check they map to node-edge-points belonging to different nodes
				ServiceInterfacePoint source = sips.get(0);
				ServiceInterfacePoint destination = sips.get(1);
				
				ConnectivityServiceSchema connectivityService = new ConnectivityServiceSchema();
				
				ConnectivityServiceEndPoint srcEp = buildConnectivityServicePoint(source, "TEST-CS-1-SRC");
				ConnectivityServiceEndPoint dstEp = buildConnectivityServicePoint(destination, "TEST-CS-1-DST");
				connectivityService.addEndPointItem(srcEp);
				connectivityService.addEndPointItem(dstEp);
				
				String csUuid = "TEST-CS-1";
				connectivityService.setUuid(csUuid);
				
				connectivityService.setServiceType(ConnectivityServiceSchema.ServiceTypeEnum.POINT_TO_POINT_CONNECTIVITY);
				
				Capacity requestedCapacity = new Capacity();
				CapacityValue totalSize = new CapacityValue();
				totalSize.setUnit(CapacityValue.UnitEnum.GBPS);
				totalSize.setValue("1");
				requestedCapacity.setTotalSize(totalSize);
				connectivityService.setRequestedCapacity(requestedCapacity);
				
				SdmTerminationPac includeCore = new SdmTerminationPac();
				includeCore.setCoreId("1");
				FrequencySlot fs = new FrequencySlot();
				fs.setSlotId("155");
				includeCore.addSelectedFrequencySlotItem(fs);
				connectivityService.setIncludeCore(includeCore);
				
				api.createContextConnectivityServiceConnectivityServiceById(csUuid, connectivityService);
				System.out.println("Sent request to create connectivity service with ID " + csUuid);
				
				api.deleteContextConnectivityServiceConnectivityServiceById(csUuid);
				System.out.println("Sent request to delete connectivity service with ID " + csUuid);
			}
			
		} catch (ApiException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	private ConnectivityServiceEndPoint buildConnectivityServicePoint(ServiceInterfacePoint sip, String localId) {
		ConnectivityServiceEndPoint csEp = new ConnectivityServiceEndPoint();
		csEp.setDirection(DirectionEnum.BIDIRECTIONAL);
		csEp.setLayerProtocolName(ConnectivityServiceEndPoint.LayerProtocolNameEnum.ETH);
		csEp.setLocalId(localId);
		csEp.setRole(ConnectivityServiceEndPoint.RoleEnum.SYMMETRIC);
		//ServiceInterfacePointRef sipr = new ServiceInterfacePointRef();
		//sipr.setServiceInterfacePointId(sip.getUuid());
		String siprString = "/restconf/config/context/service-interface-point/" + sip.getUuid();
		//csEp.setServiceInterfacePoint(sipr);
		csEp.setServiceInterfacePoint(siprString);
		return csEp;
	}
	*/

}
