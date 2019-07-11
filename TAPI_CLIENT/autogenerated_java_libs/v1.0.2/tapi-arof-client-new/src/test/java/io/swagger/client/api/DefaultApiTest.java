/*
 * tapi-arof API
 * tapi-arof API generated from tapi-arof.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityValue;
import io.swagger.client.model.CapacityValue.UnitEnum;
import io.swagger.client.model.ConnectivityConstraint;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.ConnectivityServiceEndPoint.LayerProtocolNameEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint.ProtectionRoleEnum;
import io.swagger.client.model.ConnectivityServiceEndPoint.RoleEnum;
import io.swagger.client.model.ContextSchema;
import io.swagger.client.model.CreateConnectivityServiceRPCInputRequest;
import io.swagger.client.model.CreateConnectivityServiceRPCInputSchema;
import io.swagger.client.model.CreateConnectivityServiceRPCOutputSchema;
import io.swagger.client.model.DeleteConnectivityServiceRPCInputSchema;
import io.swagger.client.model.GetConnectionDetailsRPCInputSchema;
import io.swagger.client.model.GetConnectionDetailsRPCOutputSchema;
import io.swagger.client.model.GetConnectionEndPointDetailsRPCInputSchema;
import io.swagger.client.model.GetConnectionEndPointDetailsRPCOutputSchema;
import io.swagger.client.model.GetConnectivityServiceDetailsRPCInputSchema;
import io.swagger.client.model.GetConnectivityServiceDetailsRPCOutputSchema;
import io.swagger.client.model.GetConnectivityServiceListRPCOutputSchema;
import io.swagger.client.model.GetLinkDetailsRPCInputSchema;
import io.swagger.client.model.GetLinkDetailsRPCOutputSchema;
import io.swagger.client.model.GetNodeDetailsRPCInputSchema;
import io.swagger.client.model.GetNodeDetailsRPCOutputSchema;
import io.swagger.client.model.GetNodeEdgePointDetailsRPCInputSchema;
import io.swagger.client.model.GetNodeEdgePointDetailsRPCOutputSchema;
import io.swagger.client.model.GetServiceInterfacePointDetailsRPCInputSchema;
import io.swagger.client.model.GetServiceInterfacePointDetailsRPCOutputSchema;
import io.swagger.client.model.GetServiceInterfacePointListRPCOutputSchema;
import io.swagger.client.model.GetTopologyDetailsRPCInputSchema;
import io.swagger.client.model.GetTopologyDetailsRPCOutputSchema;
import io.swagger.client.model.GetTopologyListRPCOutputSchema;
import io.swagger.client.model.ServiceInterfacePointRef;
import io.swagger.client.model.UpdateConnectivityServiceRPCInputSchema;
import io.swagger.client.model.UpdateConnectivityServiceRPCOutputSchema;
import io.swagger.client.model.UpdateServiceInterfacePointRPCInputSchema;
import io.swagger.client.model.ConnectivityServiceEndPoint.DirectionEnum;
import com.google.common.collect.Maps;
import com.google.common.collect.MapDifference;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/**
 * API tests for DefaultApi
 */
//@Ignore
public class DefaultApiTest {

	private final DefaultApi api = new DefaultApi();


	/**
	 * Create context by ID
	 *
	 * Create operation of resource: context
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createContextByIdTest() throws ApiException {
		ContextSchema context = null;
		api.createContextById(context);

		// TODO: test validations
	}

	/**
	 * Create create-connectivity-service by ID
	 *
	 * Create operation of resource: create-connectivity-service
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createCreateConnectivityServiceByIdTest() throws ApiException {
		api.setApiClient(new ApiClient()
					.setConnectTimeout(0)
					.setBasePath("http://10.0.50.26:8182/restconf")
					.setDebugging(true));
		CreateConnectivityServiceRPCInputSchema createConnectivityService = new CreateConnectivityServiceRPCInputSchema();
		//UUID uuid = UUID.randomUUID();
		//createConnectivityService.setUuid(uuid.toString());
		createConnectivityService.setUuid("xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxnxw");
		ConnectivityServiceEndPoint srcEndpoint = new ConnectivityServiceEndPoint();
		srcEndpoint.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		srcEndpoint.setProtectionRole(ProtectionRoleEnum.WORK);
		srcEndpoint.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_AROF");
		srcEndpoint.setRole(RoleEnum.UNKNOWN);
		srcEndpoint.setLocalId("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
		srcEndpoint.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef srcSip = new ServiceInterfacePointRef();
		srcSip.setServiceInterfacePointUuid("47620324-de3b-5b86-b3c3-d8657970ed1b");
		srcEndpoint.setServiceInterfacePoint(srcSip);
		createConnectivityService.addEndPointItem(srcEndpoint);
		
		
		ConnectivityServiceEndPoint dstEndpoint = new ConnectivityServiceEndPoint();
		dstEndpoint.setLayerProtocolName(LayerProtocolNameEnum.PHOTONIC_MEDIA);
		dstEndpoint.setProtectionRole(ProtectionRoleEnum.WORK);
		dstEndpoint.setLayerProtocolQualifier("tapi-photonic-media:PHOTONIC_LAYER_QUALIFIER_AROF");
		dstEndpoint.setRole(RoleEnum.UNKNOWN);
		dstEndpoint.setLocalId("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb");
		dstEndpoint.setDirection(DirectionEnum.UNIDIRECTIONAL);
		ServiceInterfacePointRef dstSip = new ServiceInterfacePointRef();
		dstSip.setServiceInterfacePointUuid("e10e8a0f-8d1a-5b70-a755-ee807039f3b4");
		dstEndpoint.setServiceInterfacePoint(dstSip);
		createConnectivityService.addEndPointItem(dstEndpoint);
		
		ConnectivityConstraint cc = new ConnectivityConstraint();
		Capacity c = new Capacity();
		CapacityValue cv = new CapacityValue();
		cv.setUnit(UnitEnum.GHZ);
		cv.setValue("1");
		c.setTotalSize(cv);
		cc.setRequestedCapacity(c);
		
		createConnectivityService.setConnectivityConstraint(cc);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(createConnectivityService);
		System.out.println(jsonStr);
		//CreateConnectivityServiceRPCInputRequest cr = new CreateConnectivityServiceRPCInputRequest();
		//cr.setCreateConnectivityServiceRPCInputSchema(createConnectivityService);
		//createConnectivityService.addEndPointItem();
		CreateConnectivityServiceRPCOutputSchema response = api.createCreateConnectivityServiceById(createConnectivityService);
		System.out.println(gson.toJson(response));
		// TODO: test validations
	}

	/**
	 * Create delete-connectivity-service by ID
	 *
	 * Create operation of resource: delete-connectivity-service
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createDeleteConnectivityServiceByIdTest() throws ApiException {
		api.setApiClient(new ApiClient()
				.setConnectTimeout(0)
				.setBasePath("http://10.0.50.26:8182/restconf")
				.setDebugging(true));
		try {
			api.createDeleteConnectivityServiceById("xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxnxw");
		}catch(Exception e) {
			//TODO: manage error
			System.out.println("error");
		}
		

		// TODO: test validations
	}

	/**
	 * Create get-connection-details by ID
	 *
	 * Create operation of resource: get-connection-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetConnectionDetailsByIdTest() throws ApiException {
		GetConnectionDetailsRPCInputSchema getConnectionDetails = null;
		GetConnectionDetailsRPCOutputSchema response = api.createGetConnectionDetailsById(getConnectionDetails);

		// TODO: test validations
	}

	/**
	 * Create get-connection-end-point-details by ID
	 *
	 * Create operation of resource: get-connection-end-point-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetConnectionEndPointDetailsByIdTest() throws ApiException {
		GetConnectionEndPointDetailsRPCInputSchema getConnectionEndPointDetails = null;
		GetConnectionEndPointDetailsRPCOutputSchema response = api.createGetConnectionEndPointDetailsById(getConnectionEndPointDetails);

		// TODO: test validations
	}

	/**
	 * Create get-connectivity-service-details by ID
	 *
	 * Create operation of resource: get-connectivity-service-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetConnectivityServiceDetailsByIdTest() throws ApiException {
		GetConnectivityServiceDetailsRPCInputSchema getConnectivityServiceDetails = null;
		GetConnectivityServiceDetailsRPCOutputSchema response = api.createGetConnectivityServiceDetailsById(getConnectivityServiceDetails);

		// TODO: test validations
	}

	/**
	 * Create get-connectivity-service-list by ID
	 *
	 * Create operation of resource: get-connectivity-service-list
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetConnectivityServiceListByIdTest() throws ApiException {
		GetConnectivityServiceListRPCOutputSchema response = api.createGetConnectivityServiceListById();

		// TODO: test validations
	}

	/**
	 * Create get-link-details by ID
	 *
	 * Create operation of resource: get-link-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetLinkDetailsByIdTest() throws ApiException {
		GetLinkDetailsRPCInputSchema getLinkDetails = null;
		GetLinkDetailsRPCOutputSchema response = api.createGetLinkDetailsById(getLinkDetails);

		// TODO: test validations
	}

	/**
	 * Create get-node-details by ID
	 *
	 * Create operation of resource: get-node-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetNodeDetailsByIdTest() throws ApiException {
		GetNodeDetailsRPCInputSchema getNodeDetails = null;
		GetNodeDetailsRPCOutputSchema response = api.createGetNodeDetailsById(getNodeDetails);

		// TODO: test validations
	}

	/**
	 * Create get-node-edge-point-details by ID
	 *
	 * Create operation of resource: get-node-edge-point-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetNodeEdgePointDetailsByIdTest() throws ApiException {
		GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails = null;
		GetNodeEdgePointDetailsRPCOutputSchema response = api.createGetNodeEdgePointDetailsById(getNodeEdgePointDetails);

		// TODO: test validations
	}

	/**
	 * Create get-service-interface-point-details by ID
	 *
	 * Create operation of resource: get-service-interface-point-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetServiceInterfacePointDetailsByIdTest() throws ApiException {
		GetServiceInterfacePointDetailsRPCInputSchema getServiceInterfacePointDetails = null;
		GetServiceInterfacePointDetailsRPCOutputSchema response = api.createGetServiceInterfacePointDetailsById(getServiceInterfacePointDetails);

		// TODO: test validations
	}

	/**
	 * Create get-service-interface-point-list by ID
	 *
	 * Create operation of resource: get-service-interface-point-list
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetServiceInterfacePointListByIdTest() throws ApiException {
		GetServiceInterfacePointListRPCOutputSchema response = api.createGetServiceInterfacePointListById();

		// TODO: test validations
	}

	/**
	 * Create get-topology-details by ID
	 *
	 * Create operation of resource: get-topology-details
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetTopologyDetailsByIdTest() throws ApiException {
		GetTopologyDetailsRPCInputSchema getTopologyDetails = null;
		GetTopologyDetailsRPCOutputSchema response = api.createGetTopologyDetailsById(getTopologyDetails);

		// TODO: test validations
	}

	/**
	 * Create get-topology-list by ID
	 *
	 * Create operation of resource: get-topology-list
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createGetTopologyListByIdTest() throws ApiException {
		GetTopologyListRPCOutputSchema response = api.createGetTopologyListById();

		// TODO: test validations
	}

	/**
	 * Create update-connectivity-service by ID
	 *
	 * Create operation of resource: update-connectivity-service
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createUpdateConnectivityServiceByIdTest() throws ApiException {
		UpdateConnectivityServiceRPCInputSchema updateConnectivityService = null;
		UpdateConnectivityServiceRPCOutputSchema response = api.createUpdateConnectivityServiceById(updateConnectivityService);

		// TODO: test validations
	}

	/**
	 * Create update-service-interface-point by ID
	 *
	 * Create operation of resource: update-service-interface-point
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void createUpdateServiceInterfacePointByIdTest() throws ApiException {
		UpdateServiceInterfacePointRPCInputSchema updateServiceInterfacePoint = null;
		api.createUpdateServiceInterfacePointById(updateServiceInterfacePoint);

		// TODO: test validations
	}

	/**
	 * Delete context by ID
	 *
	 * Delete operation of resource: context
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void deleteContextByIdTest() throws ApiException {
		api.deleteContextById();

		// TODO: test validations
	}

	/**
	 * Retrieve context
	 *
	 * Retrieve operation of resource: context
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	   
	public void retrieveContextTest() throws ApiException {
		api.setApiClient(new ApiClient()
				.setBasePath("http://10.0.50.26:8182/restconf")
				.setConnectTimeout(0));
		try {
			ContextSchema response = api.retrieveContext();
			Gson gson = new Gson();

			Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
			String retrievedJson = gson.toJson(response);
			Map<String, Object> retrievedMap = gson.fromJson(retrievedJson, mapType);
			InputStream in = DefaultApiTest.class.getResourceAsStream("/context.json");
			JsonElement original = new JsonParser().parse(new InputStreamReader(in));
			JsonElement retrieved = new JsonParser().parse(retrievedJson);
			compareJson("", retrieved, original);

		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	/**
	 * Update context by ID
	 *
	 * Update operation of resource: context
	 *
	 * @throws ApiException
	 *          if the Api call fails
	 */
	@Test
	public void updateContextByIdTest() throws ApiException {
		ContextSchema context = null;
		api.updateContextById(context);

		// TODO: test validations
	}


	public static void compareJson(String path, JsonElement retrieved, JsonElement original) {
		
		// Check whether both jsonElement are not null
		if(retrieved !=null && retrieved !=null) {

			// Check whether both jsonElement are objects
			if (retrieved.isJsonObject() && original.isJsonObject()) {

				Set<Entry<String, JsonElement>> originalEnS = ((JsonObject) original).entrySet();
				JsonObject retrievedObj = (JsonObject) retrieved;
				JsonObject originalObj = (JsonObject) original;
				if (retrievedObj != null && originalObj != null) {
					// Iterate JSON Elements with Key values
					for (Entry<String, JsonElement> en : originalEnS) {
						String newPath =path+"/"+en.getKey(); 
						if(retrievedObj.get(en.getKey())!=null) {
							compareJson(newPath, retrievedObj.get(en.getKey()), en.getValue());
						}else {
							System.out.println("Key not found:"+newPath);
						}
					}
				}else {
					System.out.println("NUll object");
				}
			} 

			// Check whether both jsonElement are arrays
			else if (retrieved.isJsonArray() && original.isJsonArray()) {
				JsonArray jarr1 = retrieved.getAsJsonArray();
				JsonArray jarr2 = original.getAsJsonArray();
				int i = 0;
				// Iterate JSON Array to JSON Elements
				for (JsonElement je : jarr1) {
					String newPath = path+"/"+i;
					compareJson(newPath, je , jarr2.get(i));
					i++;
				}   

			}    // Check whether both jsonElement are null
			else if (retrieved.isJsonNull() && original.isJsonNull()) {
				System.out.println("Both json null objs");
			} 

			// Check whether both jsonElement are primitives
			else if (retrieved.isJsonPrimitive() && original.isJsonPrimitive()) {
				System.out.println("Both json primitive");
			}

		}else {
			System.out.println("Null objs");
		}
	}
}




