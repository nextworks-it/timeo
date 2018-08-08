# DefaultApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextById**](DefaultApi.md#createContextById) | **POST** /config/context/ | Create context by ID
[**createContextNameNameById**](DefaultApi.md#createContextNameNameById) | **POST** /config/context/name/{value_name}/ | Create name by ID
[**createContextServiceInterfacePointNameNameById**](DefaultApi.md#createContextServiceInterfacePointNameNameById) | **POST** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Create name by ID
[**createContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#createContextServiceInterfacePointServiceInterfacePointById) | **POST** /config/context/service-interface-point/{uuid}/ | Create service-interface-point by ID
[**createGetServiceInterfacePointDetailsById**](DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
[**createGetServiceInterfacePointListById**](DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
[**createUpdateServiceInterfacePointById**](DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
[**deleteContextById**](DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
[**deleteContextNameNameById**](DefaultApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
[**deleteContextServiceInterfacePointNameNameById**](DefaultApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
[**deleteContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
[**retrieveContext**](DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
[**retrieveContextNameName**](DefaultApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
[**retrieveContextNameNameById**](DefaultApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
[**retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextServiceInterfacePointNameName**](DefaultApi.md#retrieveContextServiceInterfacePointNameName) | **GET** /config/context/service-interface-point/{uuid}/name/ | Retrieve name
[**retrieveContextServiceInterfacePointNameNameById**](DefaultApi.md#retrieveContextServiceInterfacePointNameNameById) | **GET** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextServiceInterfacePointServiceInterfacePoint**](DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePoint) | **GET** /config/context/service-interface-point/ | Retrieve service-interface-point
[**retrieveContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePointById) | **GET** /config/context/service-interface-point/{uuid}/ | Retrieve service-interface-point by ID
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**updateContextById**](DefaultApi.md#updateContextById) | **PUT** /config/context/ | Update context by ID
[**updateContextNameNameById**](DefaultApi.md#updateContextNameNameById) | **PUT** /config/context/name/{value_name}/ | Update name by ID
[**updateContextServiceInterfacePointNameNameById**](DefaultApi.md#updateContextServiceInterfacePointNameNameById) | **PUT** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Update name by ID
[**updateContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#updateContextServiceInterfacePointServiceInterfacePointById) | **PUT** /config/context/service-interface-point/{uuid}/ | Update service-interface-point by ID


<a name="createContextById"></a>
# **createContextById**
> createContextById(context)

Create context by ID

Create operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
TapiContext context = new TapiContext(); // TapiContext | contextbody object
try {
    apiInstance.createContextById(context);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **context** | [**TapiContext**](TapiContext.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextNameNameById"></a>
# **createContextNameNameById**
> createContextNameNameById(valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextNameNameById(valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextServiceInterfacePointNameNameById"></a>
# **createContextServiceInterfacePointNameNameById**
> createContextServiceInterfacePointNameNameById(uuid, valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextServiceInterfacePointServiceInterfacePointById"></a>
# **createContextServiceInterfacePointServiceInterfacePointById**
> createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint)

Create service-interface-point by ID

Create operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **serviceInterfacePoint** | [**ServiceInterfacePoint**](ServiceInterfacePoint.md)| service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetServiceInterfacePointDetailsById"></a>
# **createGetServiceInterfacePointDetailsById**
> GetServiceInterfacePointDetailsRPCOutputSchema createGetServiceInterfacePointDetailsById(getServiceInterfacePointDetails)

Create get-service-interface-point-details by ID

Create operation of resource: get-service-interface-point-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetServiceInterfacePointDetailsRPCInputSchema getServiceInterfacePointDetails = new GetServiceInterfacePointDetailsRPCInputSchema(); // GetServiceInterfacePointDetailsRPCInputSchema | get-service-interface-point-detailsbody object
try {
    GetServiceInterfacePointDetailsRPCOutputSchema result = apiInstance.createGetServiceInterfacePointDetailsById(getServiceInterfacePointDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetServiceInterfacePointDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getServiceInterfacePointDetails** | [**GetServiceInterfacePointDetailsRPCInputSchema**](GetServiceInterfacePointDetailsRPCInputSchema.md)| get-service-interface-point-detailsbody object |

### Return type

[**GetServiceInterfacePointDetailsRPCOutputSchema**](GetServiceInterfacePointDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetServiceInterfacePointListById"></a>
# **createGetServiceInterfacePointListById**
> GetServiceInterfacePointListRPCOutputSchema createGetServiceInterfacePointListById()

Create get-service-interface-point-list by ID

Create operation of resource: get-service-interface-point-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    GetServiceInterfacePointListRPCOutputSchema result = apiInstance.createGetServiceInterfacePointListById();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetServiceInterfacePointListById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetServiceInterfacePointListRPCOutputSchema**](GetServiceInterfacePointListRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUpdateServiceInterfacePointById"></a>
# **createUpdateServiceInterfacePointById**
> createUpdateServiceInterfacePointById(updateServiceInterfacePoint)

Create update-service-interface-point by ID

Create operation of resource: update-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
UpdateServiceInterfacePointRPCInputSchema updateServiceInterfacePoint = new UpdateServiceInterfacePointRPCInputSchema(); // UpdateServiceInterfacePointRPCInputSchema | update-service-interface-pointbody object
try {
    apiInstance.createUpdateServiceInterfacePointById(updateServiceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createUpdateServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateServiceInterfacePoint** | [**UpdateServiceInterfacePointRPCInputSchema**](UpdateServiceInterfacePointRPCInputSchema.md)| update-service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextById"></a>
# **deleteContextById**
> deleteContextById()

Delete context by ID

Delete operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.deleteContextById();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextNameNameById"></a>
# **deleteContextNameNameById**
> deleteContextNameNameById(valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextNameNameById(valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextServiceInterfacePointNameNameById"></a>
# **deleteContextServiceInterfacePointNameNameById**
> deleteContextServiceInterfacePointNameNameById(uuid, valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextServiceInterfacePointNameNameById(uuid, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextServiceInterfacePointServiceInterfacePointById"></a>
# **deleteContextServiceInterfacePointServiceInterfacePointById**
> deleteContextServiceInterfacePointServiceInterfacePointById(uuid)

Delete service-interface-point by ID

Delete operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    apiInstance.deleteContextServiceInterfacePointServiceInterfacePointById(uuid);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContext"></a>
# **retrieveContext**
> TapiContext retrieveContext()

Retrieve context

Retrieve operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    TapiContext result = apiInstance.retrieveContext();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContext");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TapiContext**](TapiContext.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNameName"></a>
# **retrieveContextNameName**
> List&lt;String&gt; retrieveContextNameName()

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextNameName();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNameName");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNameNameById"></a>
# **retrieveContextNameNameById**
> NameAndValue retrieveContextNameNameById(valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextNameNameById(valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**
> Capacity retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointNameName"></a>
# **retrieveContextServiceInterfacePointNameName**
> List&lt;String&gt; retrieveContextServiceInterfacePointNameName(uuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointNameName(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointNameNameById"></a>
# **retrieveContextServiceInterfacePointNameNameById**
> NameAndValue retrieveContextServiceInterfacePointNameNameById(uuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextServiceInterfacePointNameNameById(uuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointServiceInterfacePoint"></a>
# **retrieveContextServiceInterfacePointServiceInterfacePoint**
> List&lt;String&gt; retrieveContextServiceInterfacePointServiceInterfacePoint()

Retrieve service-interface-point

Retrieve operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePoint();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointServiceInterfacePoint");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointServiceInterfacePointById"></a>
# **retrieveContextServiceInterfacePointServiceInterfacePointById**
> ServiceInterfacePoint retrieveContextServiceInterfacePointServiceInterfacePointById(uuid)

Retrieve service-interface-point by ID

Retrieve operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    ServiceInterfacePoint result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePointById(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**ServiceInterfacePoint**](ServiceInterfacePoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextById"></a>
# **updateContextById**
> updateContextById(context)

Update context by ID

Update operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
TapiContext context = new TapiContext(); // TapiContext | contextbody object
try {
    apiInstance.updateContextById(context);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **context** | [**TapiContext**](TapiContext.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextNameNameById"></a>
# **updateContextNameNameById**
> updateContextNameNameById(valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextNameNameById(valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextServiceInterfacePointNameNameById"></a>
# **updateContextServiceInterfacePointNameNameById**
> updateContextServiceInterfacePointNameNameById(uuid, valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextServiceInterfacePointServiceInterfacePointById"></a>
# **updateContextServiceInterfacePointServiceInterfacePointById**
> updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint)

Update service-interface-point by ID

Update operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **serviceInterfacePoint** | [**ServiceInterfacePoint**](ServiceInterfacePoint.md)| service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

