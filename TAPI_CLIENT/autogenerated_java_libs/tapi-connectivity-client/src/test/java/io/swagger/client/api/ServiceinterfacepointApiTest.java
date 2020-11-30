/**
 * tapi-connectivity API
 * tapi-connectivity API generated from tapi-connectivity@2018-12-10.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.ServiceInterfacePoint;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.BandwidthProfile;
import io.swagger.client.model.CapacityValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServiceinterfacepointApi
 */
public class ServiceinterfacepointApiTest {

    private final ServiceinterfacepointApi api = new ServiceinterfacepointApi();

    
    /**
     * Create name by ID
     *
     * Create operation of resource: name
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createContextServiceInterfacePointNameNameByIdTest() throws ApiException {
        String uuid = null;
        String valueName = null;
        NameAndValue name = null;
        // api.createContextServiceInterfacePointNameNameById(uuid, valueName, name);

        // TODO: test validations
    }
    
    /**
     * Create service-interface-point by ID
     *
     * Create operation of resource: service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createContextServiceInterfacePointServiceInterfacePointByIdTest() throws ApiException {
        String uuid = null;
        ServiceInterfacePoint serviceInterfacePoint = null;
        // api.createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);

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
    public void deleteContextServiceInterfacePointNameNameByIdTest() throws ApiException {
        String uuid = null;
        String valueName = null;
        // api.deleteContextServiceInterfacePointNameNameById(uuid, valueName);

        // TODO: test validations
    }
    
    /**
     * Delete service-interface-point by ID
     *
     * Delete operation of resource: service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteContextServiceInterfacePointServiceInterfacePointByIdTest() throws ApiException {
        String uuid = null;
        // api.deleteContextServiceInterfacePointServiceInterfacePointById(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve available-capacity
     *
     * Retrieve operation of resource: available-capacity
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacityTest() throws ApiException {
        String uuid = null;
        // Capacity response = api.retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve bandwidth-profile
     *
     * Retrieve operation of resource: bandwidth-profile
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfileTest() throws ApiException {
        String uuid = null;
        // BandwidthProfile response = api.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve committed-burst-size
     *
     * Retrieve operation of resource: committed-burst-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve committed-information-rate
     *
     * Retrieve operation of resource: committed-information-rate
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRateTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve peak-burst-size
     *
     * Retrieve operation of resource: peak-burst-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve peak-information-rate
     *
     * Retrieve operation of resource: peak-information-rate
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRateTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve total-size
     *
     * Retrieve operation of resource: total-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid);

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
    public void retrieveContextServiceInterfacePointNameNameTest() throws ApiException {
        String uuid = null;
        // List<String> response = api.retrieveContextServiceInterfacePointNameName(uuid);

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
    public void retrieveContextServiceInterfacePointNameNameByIdTest() throws ApiException {
        String uuid = null;
        String valueName = null;
        // NameAndValue response = api.retrieveContextServiceInterfacePointNameNameById(uuid, valueName);

        // TODO: test validations
    }
    
    /**
     * Retrieve service-interface-point
     *
     * Retrieve operation of resource: service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointServiceInterfacePointTest() throws ApiException {
        // List<String> response = api.retrieveContextServiceInterfacePointServiceInterfacePoint();

        // TODO: test validations
    }
    
    /**
     * Retrieve service-interface-point by ID
     *
     * Retrieve operation of resource: service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointServiceInterfacePointByIdTest() throws ApiException {
        String uuid = null;
        // ServiceInterfacePoint response = api.retrieveContextServiceInterfacePointServiceInterfacePointById(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve bandwidth-profile
     *
     * Retrieve operation of resource: bandwidth-profile
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfileTest() throws ApiException {
        String uuid = null;
        // BandwidthProfile response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve committed-burst-size
     *
     * Retrieve operation of resource: committed-burst-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve committed-information-rate
     *
     * Retrieve operation of resource: committed-information-rate
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRateTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve peak-burst-size
     *
     * Retrieve operation of resource: peak-burst-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve peak-information-rate
     *
     * Retrieve operation of resource: peak-information-rate
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRateTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve total-potential-capacity
     *
     * Retrieve operation of resource: total-potential-capacity
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacityTest() throws ApiException {
        String uuid = null;
        // Capacity response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid);

        // TODO: test validations
    }
    
    /**
     * Retrieve total-size
     *
     * Retrieve operation of resource: total-size
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSizeTest() throws ApiException {
        String uuid = null;
        // CapacityValue response = api.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid);

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
    public void updateContextServiceInterfacePointNameNameByIdTest() throws ApiException {
        String uuid = null;
        String valueName = null;
        NameAndValue name = null;
        // api.updateContextServiceInterfacePointNameNameById(uuid, valueName, name);

        // TODO: test validations
    }
    
    /**
     * Update service-interface-point by ID
     *
     * Update operation of resource: service-interface-point
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateContextServiceInterfacePointServiceInterfacePointByIdTest() throws ApiException {
        String uuid = null;
        ServiceInterfacePoint serviceInterfacePoint = null;
        // api.updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);

        // TODO: test validations
    }
    
}
