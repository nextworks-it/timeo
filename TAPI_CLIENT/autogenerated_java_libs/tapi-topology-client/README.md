# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DefaultApi;

import java.io.File;
import java.util.*;

public class DefaultApiExample {

    public static void main(String[] args) {
        
        DefaultApi apiInstance = new DefaultApi();
        ContextSchema context = new ContextSchema(); // ContextSchema | contextbody object
        try {
            apiInstance.createContextById(context);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createContextById");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/restconf*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**createContextById**](docs/DefaultApi.md#createContextById) | **POST** /config/context/ | Create context by ID
*DefaultApi* | [**createContextNameNameById**](docs/DefaultApi.md#createContextNameNameById) | **POST** /config/context/name/{value_name}/ | Create name by ID
*DefaultApi* | [**createContextServiceInterfacePointNameNameById**](docs/DefaultApi.md#createContextServiceInterfacePointNameNameById) | **POST** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Create name by ID
*DefaultApi* | [**createContextServiceInterfacePointServiceInterfacePointById**](docs/DefaultApi.md#createContextServiceInterfacePointServiceInterfacePointById) | **POST** /config/context/service-interface-point/{uuid}/ | Create service-interface-point by ID
*DefaultApi* | [**createGetLinkDetailsById**](docs/DefaultApi.md#createGetLinkDetailsById) | **POST** /operations/get-link-details/ | Create get-link-details by ID
*DefaultApi* | [**createGetNodeDetailsById**](docs/DefaultApi.md#createGetNodeDetailsById) | **POST** /operations/get-node-details/ | Create get-node-details by ID
*DefaultApi* | [**createGetNodeEdgePointDetailsById**](docs/DefaultApi.md#createGetNodeEdgePointDetailsById) | **POST** /operations/get-node-edge-point-details/ | Create get-node-edge-point-details by ID
*DefaultApi* | [**createGetServiceInterfacePointDetailsById**](docs/DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
*DefaultApi* | [**createGetServiceInterfacePointListById**](docs/DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
*DefaultApi* | [**createGetTopologyDetailsById**](docs/DefaultApi.md#createGetTopologyDetailsById) | **POST** /operations/get-topology-details/ | Create get-topology-details by ID
*DefaultApi* | [**createGetTopologyListById**](docs/DefaultApi.md#createGetTopologyListById) | **POST** /operations/get-topology-list/ | Create get-topology-list by ID
*DefaultApi* | [**createUpdateServiceInterfacePointById**](docs/DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
*DefaultApi* | [**deleteContextById**](docs/DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
*DefaultApi* | [**deleteContextNameNameById**](docs/DefaultApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
*DefaultApi* | [**deleteContextServiceInterfacePointNameNameById**](docs/DefaultApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
*DefaultApi* | [**deleteContextServiceInterfacePointServiceInterfacePointById**](docs/DefaultApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
*DefaultApi* | [**retrieveContext**](docs/DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
*DefaultApi* | [**retrieveContextNameName**](docs/DefaultApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
*DefaultApi* | [**retrieveContextNameNameById**](docs/DefaultApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextNwTopologyServiceNameName**](docs/DefaultApi.md#retrieveContextNwTopologyServiceNameName) | **GET** /config/context/nw-topology-service/name/ | Retrieve name
*DefaultApi* | [**retrieveContextNwTopologyServiceNameNameById**](docs/DefaultApi.md#retrieveContextNwTopologyServiceNameNameById) | **GET** /config/context/nw-topology-service/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextNwTopologyServiceNwTopologyService**](docs/DefaultApi.md#retrieveContextNwTopologyServiceNwTopologyService) | **GET** /config/context/nw-topology-service/ | Retrieve nw-topology-service
*DefaultApi* | [**retrieveContextNwTopologyServiceTopologyTopology**](docs/DefaultApi.md#retrieveContextNwTopologyServiceTopologyTopology) | **GET** /config/context/nw-topology-service/topology/ | Retrieve topology
*DefaultApi* | [**retrieveContextNwTopologyServiceTopologyTopologyById**](docs/DefaultApi.md#retrieveContextNwTopologyServiceTopologyTopologyById) | **GET** /config/context/nw-topology-service/topology/{topology_id}/ | Retrieve topology by ID
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextServiceInterfacePointNameName**](docs/DefaultApi.md#retrieveContextServiceInterfacePointNameName) | **GET** /config/context/service-interface-point/{uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextServiceInterfacePointNameNameById**](docs/DefaultApi.md#retrieveContextServiceInterfacePointNameNameById) | **GET** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextServiceInterfacePointServiceInterfacePoint**](docs/DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePoint) | **GET** /config/context/service-interface-point/ | Retrieve service-interface-point
*DefaultApi* | [**retrieveContextServiceInterfacePointServiceInterfacePointById**](docs/DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePointById) | **GET** /config/context/service-interface-point/{uuid}/ | Retrieve service-interface-point by ID
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyLinkCostCharacteristicCostCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyLinkCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/cost-characteristic/ | Retrieve cost-characteristic
*DefaultApi* | [**retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/latency-characteristic/ | Retrieve latency-characteristic
*DefaultApi* | [**retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyLinkLink**](docs/DefaultApi.md#retrieveContextTopologyLinkLink) | **GET** /config/context/topology/{uuid}/link/ | Retrieve link
*DefaultApi* | [**retrieveContextTopologyLinkLinkById**](docs/DefaultApi.md#retrieveContextTopologyLinkLinkById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/ | Retrieve link by ID
*DefaultApi* | [**retrieveContextTopologyLinkNameName**](docs/DefaultApi.md#retrieveContextTopologyLinkNameName) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyLinkNameNameById**](docs/DefaultApi.md#retrieveContextTopologyLinkNameNameById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint**](docs/DefaultApi.md#retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/node-edge-point/ | Retrieve node-edge-point
*DefaultApi* | [**retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById**](docs/DefaultApi.md#retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve node-edge-point by ID
*DefaultApi* | [**retrieveContextTopologyLinkResilienceTypeResilienceType**](docs/DefaultApi.md#retrieveContextTopologyLinkResilienceTypeResilienceType) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/resilience-type/ | Retrieve resilience-type
*DefaultApi* | [**retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/risk-characteristic/ | Retrieve risk-characteristic
*DefaultApi* | [**retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyLinkValidationMechanismValidationMechanism**](docs/DefaultApi.md#retrieveContextTopologyLinkValidationMechanismValidationMechanism) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/validation-mechanism/ | Retrieve validation-mechanism
*DefaultApi* | [**retrieveContextTopologyLinkValidationMechanismValidationMechanismById**](docs/DefaultApi.md#retrieveContextTopologyLinkValidationMechanismValidationMechanismById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/validation-mechanism/{validation_mechanism}/ | Retrieve validation-mechanism by ID
*DefaultApi* | [**retrieveContextTopologyNameName**](docs/DefaultApi.md#retrieveContextTopologyNameName) | **GET** /config/context/topology/{uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNameNameById) | **GET** /config/context/topology/{uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint**](docs/DefaultApi.md#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
*DefaultApi* | [**retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById**](docs/DefaultApi.md#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve aggregated-node-edge-point by ID
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeCostCharacteristicCostCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/cost-characteristic/ | Retrieve cost-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeEncapTopologyEncapTopology**](docs/DefaultApi.md#retrieveContextTopologyNodeEncapTopologyEncapTopology) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/encap-topology/ | Retrieve encap-topology
*DefaultApi* | [**retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/latency-characteristic/ | Retrieve latency-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeNode**](docs/DefaultApi.md#retrieveContextTopologyNodeNode) | **GET** /config/context/topology/{uuid}/node/ | Retrieve node
*DefaultApi* | [**retrieveContextTopologyNodeNodeById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/ | Retrieve node by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/ | Retrieve composed-rule-group
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/{topology_id node_id node_rule_group_id}/ | Retrieve composed-rule-group by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/ | Retrieve associated-node-rule-group
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/{topology_id node_id node_rule_group_id}/ | Retrieve associated-node-rule-group by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/ | Retrieve inter-rule-group
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/ | Retrieve inter-rule-group by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/ | Retrieve rule
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/ | Retrieve node-edge-point
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve node-edge-point by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/ | Retrieve node-rule-group
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/ | Retrieve node-rule-group by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRuleNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRuleRule**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleRule) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/ | Retrieve rule
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupRuleRuleById**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleRuleById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve aggregated-node-edge-point by ID
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/ | Retrieve available-capacity
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/ | Retrieve mapped-service-interface-point
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/{service_interface_point_id}/ | Retrieve mapped-service-interface-point by ID
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointNameName**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/ | Retrieve name
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/{value_name}/ | Retrieve name by ID
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/ | Retrieve owned-node-edge-point
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/ | Retrieve owned-node-edge-point by ID
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*DefaultApi* | [**retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize**](docs/DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*DefaultApi* | [**retrieveContextTopologyTopology**](docs/DefaultApi.md#retrieveContextTopologyTopology) | **GET** /config/context/topology/ | Retrieve topology
*DefaultApi* | [**retrieveContextTopologyTopologyById**](docs/DefaultApi.md#retrieveContextTopologyTopologyById) | **GET** /config/context/topology/{uuid}/ | Retrieve topology by ID
*DefaultApi* | [**updateContextById**](docs/DefaultApi.md#updateContextById) | **PUT** /config/context/ | Update context by ID
*DefaultApi* | [**updateContextNameNameById**](docs/DefaultApi.md#updateContextNameNameById) | **PUT** /config/context/name/{value_name}/ | Update name by ID
*DefaultApi* | [**updateContextServiceInterfacePointNameNameById**](docs/DefaultApi.md#updateContextServiceInterfacePointNameNameById) | **PUT** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Update name by ID
*DefaultApi* | [**updateContextServiceInterfacePointServiceInterfacePointById**](docs/DefaultApi.md#updateContextServiceInterfacePointServiceInterfacePointById) | **PUT** /config/context/service-interface-point/{uuid}/ | Update service-interface-point by ID


## Documentation for Models

 - [AdminStatePac](docs/AdminStatePac.md)
 - [BandwidthProfile](docs/BandwidthProfile.md)
 - [Capacity](docs/Capacity.md)
 - [CapacityPac](docs/CapacityPac.md)
 - [CapacityValue](docs/CapacityValue.md)
 - [CostCharacteristic](docs/CostCharacteristic.md)
 - [GetLinkDetailsRPCInputSchema](docs/GetLinkDetailsRPCInputSchema.md)
 - [GetLinkDetailsRPCOutputSchema](docs/GetLinkDetailsRPCOutputSchema.md)
 - [GetNodeDetailsRPCInputSchema](docs/GetNodeDetailsRPCInputSchema.md)
 - [GetNodeDetailsRPCOutputSchema](docs/GetNodeDetailsRPCOutputSchema.md)
 - [GetNodeEdgePointDetailsRPCInputSchema](docs/GetNodeEdgePointDetailsRPCInputSchema.md)
 - [GetNodeEdgePointDetailsRPCOutputSchema](docs/GetNodeEdgePointDetailsRPCOutputSchema.md)
 - [GetTopologyDetailsRPCInputSchema](docs/GetTopologyDetailsRPCInputSchema.md)
 - [GetTopologyDetailsRPCOutputSchema](docs/GetTopologyDetailsRPCOutputSchema.md)
 - [GetTopologyListRPCOutputSchema](docs/GetTopologyListRPCOutputSchema.md)
 - [GlobalClass](docs/GlobalClass.md)
 - [LatencyCharacteristic](docs/LatencyCharacteristic.md)
 - [LayerProtocolTransitionPac](docs/LayerProtocolTransitionPac.md)
 - [LifecycleStatePac](docs/LifecycleStatePac.md)
 - [LocalClass](docs/LocalClass.md)
 - [NameAndValue](docs/NameAndValue.md)
 - [OperationalStatePac](docs/OperationalStatePac.md)
 - [ResilienceType](docs/ResilienceType.md)
 - [ResourceSpec](docs/ResourceSpec.md)
 - [RiskCharacteristic](docs/RiskCharacteristic.md)
 - [RiskParameterPac](docs/RiskParameterPac.md)
 - [ServiceInterfacePointRef](docs/ServiceInterfacePointRef.md)
 - [ServiceSpec](docs/ServiceSpec.md)
 - [TerminationPac](docs/TerminationPac.md)
 - [TimeRange](docs/TimeRange.md)
 - [TopologyContext](docs/TopologyContext.md)
 - [TopologyRef](docs/TopologyRef.md)
 - [TransferCostPac](docs/TransferCostPac.md)
 - [TransferIntegrityPac](docs/TransferIntegrityPac.md)
 - [TransferTimingPac](docs/TransferTimingPac.md)
 - [ValidationMechanism](docs/ValidationMechanism.md)
 - [ValidationPac](docs/ValidationPac.md)
 - [InterRuleGroup](docs/InterRuleGroup.md)
 - [Link](docs/Link.md)
 - [LinkRef](docs/LinkRef.md)
 - [NetworkTopologyService](docs/NetworkTopologyService.md)
 - [Node](docs/Node.md)
 - [NodeEdgePoint](docs/NodeEdgePoint.md)
 - [NodeRef](docs/NodeRef.md)
 - [NodeRuleGroup](docs/NodeRuleGroup.md)
 - [Rule](docs/Rule.md)
 - [ServiceInterfacePoint](docs/ServiceInterfacePoint.md)
 - [TapiContext](docs/TapiContext.md)
 - [Topology](docs/Topology.md)
 - [ContextSchema](docs/ContextSchema.md)
 - [NodeRuleGroupRef](docs/NodeRuleGroupRef.md)
 - [OwnedNodeEdgePointRef](docs/OwnedNodeEdgePointRef.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



