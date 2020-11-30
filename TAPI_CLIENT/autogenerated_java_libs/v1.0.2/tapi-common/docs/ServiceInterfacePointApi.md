# ServiceInterfacePointApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextServiceInterfacePointNameNameById**](ServiceInterfacePointApi.md#createContextServiceInterfacePointNameNameById) | **POST** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Create name by ID
[**createContextServiceInterfacePointServiceInterfacePointById**](ServiceInterfacePointApi.md#createContextServiceInterfacePointServiceInterfacePointById) | **POST** /config/context/service-interface-point/{uuid}/ | Create service-interface-point by ID
[**deleteContextServiceInterfacePointNameNameById**](ServiceInterfacePointApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
[**deleteContextServiceInterfacePointServiceInterfacePointById**](ServiceInterfacePointApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
[**retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextServiceInterfacePointNameName**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointNameName) | **GET** /config/context/service-interface-point/{uuid}/name/ | Retrieve name
[**retrieveContextServiceInterfacePointNameNameById**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointNameNameById) | **GET** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextServiceInterfacePointServiceInterfacePoint**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointServiceInterfacePoint) | **GET** /config/context/service-interface-point/ | Retrieve service-interface-point
[**retrieveContextServiceInterfacePointServiceInterfacePointById**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointServiceInterfacePointById) | **GET** /config/context/service-interface-point/{uuid}/ | Retrieve service-interface-point by ID
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**](ServiceInterfacePointApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**updateContextServiceInterfacePointNameNameById**](ServiceInterfacePointApi.md#updateContextServiceInterfacePointNameNameById) | **PUT** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Update name by ID
[**updateContextServiceInterfacePointServiceInterfacePointById**](ServiceInterfacePointApi.md#updateContextServiceInterfacePointServiceInterfacePointById) | **PUT** /config/context/service-interface-point/{uuid}/ | Update service-interface-point by ID


<a name="createContextServiceInterfacePointNameNameById"></a>
# **createContextServiceInterfacePointNameNameById**
> createContextServiceInterfacePointNameNameById(uuid, valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#createContextServiceInterfacePointNameNameById");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#createContextServiceInterfacePointServiceInterfacePointById");
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

<a name="deleteContextServiceInterfacePointNameNameById"></a>
# **deleteContextServiceInterfacePointNameNameById**
> deleteContextServiceInterfacePointNameNameById(uuid, valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextServiceInterfacePointNameNameById(uuid, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#deleteContextServiceInterfacePointNameNameById");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    apiInstance.deleteContextServiceInterfacePointServiceInterfacePointById(uuid);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#deleteContextServiceInterfacePointServiceInterfacePointById");
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

<a name="retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**
> Capacity retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointNameName(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointNameName");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextServiceInterfacePointNameNameById(uuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointNameNameById");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePoint();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointServiceInterfacePoint");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    ServiceInterfacePoint result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePointById(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointServiceInterfacePointById");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="updateContextServiceInterfacePointNameNameById"></a>
# **updateContextServiceInterfacePointNameNameById**
> updateContextServiceInterfacePointNameNameById(uuid, valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#updateContextServiceInterfacePointNameNameById");
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
//import io.swagger.client.api.ServiceInterfacePointApi;


ServiceInterfacePointApi apiInstance = new ServiceInterfacePointApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling ServiceInterfacePointApi#updateContextServiceInterfacePointServiceInterfacePointById");
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

