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
        TapiContext context = new TapiContext(); // TapiContext | contextbody object
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
*DefaultApi* | [**createGetServiceInterfacePointDetailsById**](docs/DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
*DefaultApi* | [**createGetServiceInterfacePointListById**](docs/DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
*DefaultApi* | [**createUpdateServiceInterfacePointById**](docs/DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
*DefaultApi* | [**deleteContextById**](docs/DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
*DefaultApi* | [**deleteContextNameNameById**](docs/DefaultApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
*DefaultApi* | [**deleteContextServiceInterfacePointNameNameById**](docs/DefaultApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
*DefaultApi* | [**deleteContextServiceInterfacePointServiceInterfacePointById**](docs/DefaultApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
*DefaultApi* | [**retrieveContext**](docs/DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
*DefaultApi* | [**retrieveContextNameName**](docs/DefaultApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
*DefaultApi* | [**retrieveContextNameNameById**](docs/DefaultApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
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
 - [GetServiceInterfacePointDetailsRPCInputSchema](docs/GetServiceInterfacePointDetailsRPCInputSchema.md)
 - [GetServiceInterfacePointDetailsRPCOutputSchema](docs/GetServiceInterfacePointDetailsRPCOutputSchema.md)
 - [GetServiceInterfacePointListRPCOutputSchema](docs/GetServiceInterfacePointListRPCOutputSchema.md)
 - [GlobalClass](docs/GlobalClass.md)
 - [LifecycleStatePac](docs/LifecycleStatePac.md)
 - [LocalClass](docs/LocalClass.md)
 - [NameAndValue](docs/NameAndValue.md)
 - [OperationalStatePac](docs/OperationalStatePac.md)
 - [ResourceSpec](docs/ResourceSpec.md)
 - [ServiceInterfacePointRef](docs/ServiceInterfacePointRef.md)
 - [ServiceSpec](docs/ServiceSpec.md)
 - [TerminationPac](docs/TerminationPac.md)
 - [TimeRange](docs/TimeRange.md)
 - [UpdateServiceInterfacePointRPCInputSchema](docs/UpdateServiceInterfacePointRPCInputSchema.md)
 - [ServiceInterfacePoint](docs/ServiceInterfacePoint.md)
 - [TapiContext](docs/TapiContext.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



