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

import io.swagger.client.ApiException;
import io.swagger.client.model.NameAndValue;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NameApi
 */
@Ignore
public class NameApiTest {

    private final NameApi api = new NameApi();

    
    /**
     * Create name by ID
     *
     * Create operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createContextNameNameByIdTest() throws ApiException {
        String valueName = null;
        NameAndValue name = null;
        api.createContextNameNameById(valueName, name);

        // TODO: test validations
    }
    
    /**
     * Delete name by ID
     *
     * Delete operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteContextNameNameByIdTest() throws ApiException {
        String valueName = null;
        api.deleteContextNameNameById(valueName);

        // TODO: test validations
    }
    
    /**
     * Retrieve name
     *
     * Retrieve operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextNameNameTest() throws ApiException {
        List<String> response = api.retrieveContextNameName();

        // TODO: test validations
    }
    
    /**
     * Retrieve name by ID
     *
     * Retrieve operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextNameNameByIdTest() throws ApiException {
        String valueName = null;
        NameAndValue response = api.retrieveContextNameNameById(valueName);

        // TODO: test validations
    }
    
    /**
     * Update name by ID
     *
     * Update operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateContextNameNameByIdTest() throws ApiException {
        String valueName = null;
        NameAndValue name = null;
        api.updateContextNameNameById(valueName, name);

        // TODO: test validations
    }
    
}