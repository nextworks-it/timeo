# common

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
    <groupId>io.swagger.tapi</groupId>
    <artifactId>common</artifactId>
    <version>1.0.2</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger.tapi:common:1.0.2"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/common-1.0.2.jar
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
        
        Object body = null; // Object | contextbody object
        
        try {
            apiInstance.createContextById(body);
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
*DefaultApi* | [**createGetServiceInterfacePointDetailsById**](docs/DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
*DefaultApi* | [**createGetServiceInterfacePointListById**](docs/DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
*DefaultApi* | [**createUpdateServiceInterfacePointById**](docs/DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
*DefaultApi* | [**deleteContextById**](docs/DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
*DefaultApi* | [**retrieveContext**](docs/DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
*DefaultApi* | [**updateContextById**](docs/DefaultApi.md#updateContextById) | **PUT** /config/context/ | Update context by ID
*NameApi* | [**createContextNameNameById**](docs/NameApi.md#createContextNameNameById) | **POST** /config/context/name/{value_name}/ | Create name by ID
*NameApi* | [**deleteContextNameNameById**](docs/NameApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
*NameApi* | [**retrieveContextNameName**](docs/NameApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
*NameApi* | [**retrieveContextNameNameById**](docs/NameApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
*NameApi* | [**updateContextNameNameById**](docs/NameApi.md#updateContextNameNameById) | **PUT** /config/context/name/{value_name}/ | Update name by ID
*ServiceInterfacePointApi* | [**createContextServiceInterfacePointNameNameById**](docs/ServiceInterfacePointApi.md#createContextServiceInterfacePointNameNameById) | **POST** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Create name by ID
*ServiceInterfacePointApi* | [**createContextServiceInterfacePointServiceInterfacePointById**](docs/ServiceInterfacePointApi.md#createContextServiceInterfacePointServiceInterfacePointById) | **POST** /config/context/service-interface-point/{uuid}/ | Create service-interface-point by ID
*ServiceInterfacePointApi* | [**deleteContextServiceInterfacePointNameNameById**](docs/ServiceInterfacePointApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
*ServiceInterfacePointApi* | [**deleteContextServiceInterfacePointServiceInterfacePointById**](docs/ServiceInterfacePointApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/ | Retrieve available-capacity
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/total-size/ | Retrieve total-size
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointNameName**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointNameName) | **GET** /config/context/service-interface-point/{uuid}/name/ | Retrieve name
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointNameNameById**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointNameNameById) | **GET** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Retrieve name by ID
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointServiceInterfacePoint**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointServiceInterfacePoint) | **GET** /config/context/service-interface-point/ | Retrieve service-interface-point
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointServiceInterfacePointById**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointServiceInterfacePointById) | **GET** /config/context/service-interface-point/{uuid}/ | Retrieve service-interface-point by ID
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
*ServiceInterfacePointApi* | [**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**](docs/ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/total-size/ | Retrieve total-size
*ServiceInterfacePointApi* | [**updateContextServiceInterfacePointNameNameById**](docs/ServiceInterfacePointApi.md#updateContextServiceInterfacePointNameNameById) | **PUT** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Update name by ID
*ServiceInterfacePointApi* | [**updateContextServiceInterfacePointServiceInterfacePointById**](docs/ServiceInterfacePointApi.md#updateContextServiceInterfacePointServiceInterfacePointById) | **PUT** /config/context/service-interface-point/{uuid}/ | Update service-interface-point by ID


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
 - [ServiceInterfacePoint](docs/ServiceInterfacePoint.md)
 - [ServiceInterfacePointRef](docs/ServiceInterfacePointRef.md)
 - [ServiceSpec](docs/ServiceSpec.md)
 - [TapiContext](docs/TapiContext.md)
 - [TerminationPac](docs/TerminationPac.md)
 - [TimeInterval](docs/TimeInterval.md)
 - [TimePeriod](docs/TimePeriod.md)
 - [TimeRange](docs/TimeRange.md)
 - [UpdateServiceInterfacePointRPCInputSchema](docs/UpdateServiceInterfacePointRPCInputSchema.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


