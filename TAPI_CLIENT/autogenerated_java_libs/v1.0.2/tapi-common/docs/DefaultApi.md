# DefaultApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextById**](DefaultApi.md#createContextById) | **POST** /config/context/ | Create context by ID
[**createGetServiceInterfacePointDetailsById**](DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
[**createGetServiceInterfacePointListById**](DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
[**createUpdateServiceInterfacePointById**](DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
[**deleteContextById**](DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
[**retrieveContext**](DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
[**updateContextById**](DefaultApi.md#updateContextById) | **PUT** /config/context/ | Update context by ID


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

