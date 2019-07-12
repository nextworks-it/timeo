/*
 * tapi-common API
 * tapi-common API generated from tapi-common@2018-12-10.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.GetServiceInterfacePointDetailsRPCInputSchema;
import io.swagger.client.model.GetServiceInterfacePointDetailsRPCOutputSchema;
import io.swagger.client.model.GetServiceInterfacePointListRPCOutputSchema;
import io.swagger.client.model.TapiContext;
import io.swagger.client.model.UpdateServiceInterfacePointRPCInputSchema;

import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for DefaultApi
 */
@Ignore
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
        
        Object body = null;
        
        api.createContextById(body);

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
        
        GetServiceInterfacePointDetailsRPCInputSchema body = null;
        
        GetServiceInterfacePointDetailsRPCOutputSchema response = api.createGetServiceInterfacePointDetailsById(body);

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
     * Create update-service-interface-point by ID
     *
     * Create operation of resource: update-service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createUpdateServiceInterfacePointByIdTest() throws ApiException {
        
        UpdateServiceInterfacePointRPCInputSchema body = null;
        
        api.createUpdateServiceInterfacePointById(body);

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
        
        TapiContext response = api.retrieveContext();

        // TODO: test validations
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
        
        Object body = null;
        
        api.updateContextById(body);

        // TODO: test validations
    }
    
}