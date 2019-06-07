# DefaultApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextById**](DefaultApi.md#createContextById) | **POST** /config/context/ | Create context by ID
[**createCreateConnectivityServiceById**](DefaultApi.md#createCreateConnectivityServiceById) | **POST** /operations/create-connectivity-service/ | Create create-connectivity-service by ID
[**createDeleteConnectivityServiceById**](DefaultApi.md#createDeleteConnectivityServiceById) | **POST** /operations/delete-connectivity-service/ | Create delete-connectivity-service by ID
[**createGetConnectionDetailsById**](DefaultApi.md#createGetConnectionDetailsById) | **POST** /operations/get-connection-details/ | Create get-connection-details by ID
[**createGetConnectionEndPointDetailsById**](DefaultApi.md#createGetConnectionEndPointDetailsById) | **POST** /operations/get-connection-end-point-details/ | Create get-connection-end-point-details by ID
[**createGetConnectivityServiceDetailsById**](DefaultApi.md#createGetConnectivityServiceDetailsById) | **POST** /operations/get-connectivity-service-details/ | Create get-connectivity-service-details by ID
[**createGetConnectivityServiceListById**](DefaultApi.md#createGetConnectivityServiceListById) | **POST** /operations/get-connectivity-service-list/ | Create get-connectivity-service-list by ID
[**createGetLinkDetailsById**](DefaultApi.md#createGetLinkDetailsById) | **POST** /operations/get-link-details/ | Create get-link-details by ID
[**createGetNodeDetailsById**](DefaultApi.md#createGetNodeDetailsById) | **POST** /operations/get-node-details/ | Create get-node-details by ID
[**createGetNodeEdgePointDetailsById**](DefaultApi.md#createGetNodeEdgePointDetailsById) | **POST** /operations/get-node-edge-point-details/ | Create get-node-edge-point-details by ID
[**createGetServiceInterfacePointDetailsById**](DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
[**createGetServiceInterfacePointListById**](DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
[**createGetTopologyDetailsById**](DefaultApi.md#createGetTopologyDetailsById) | **POST** /operations/get-topology-details/ | Create get-topology-details by ID
[**createGetTopologyListById**](DefaultApi.md#createGetTopologyListById) | **POST** /operations/get-topology-list/ | Create get-topology-list by ID
[**createUpdateConnectivityServiceById**](DefaultApi.md#createUpdateConnectivityServiceById) | **POST** /operations/update-connectivity-service/ | Create update-connectivity-service by ID
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
ContextSchema context = new ContextSchema(); // ContextSchema | contextbody object
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
 **context** | [**ContextSchema**](ContextSchema.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCreateConnectivityServiceById"></a>
# **createCreateConnectivityServiceById**
> CreateConnectivityServiceRPCOutputSchema createCreateConnectivityServiceById(createConnectivityService)

Create create-connectivity-service by ID

Create operation of resource: create-connectivity-service

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
CreateConnectivityServiceRPCInputSchema createConnectivityService = new CreateConnectivityServiceRPCInputSchema(); // CreateConnectivityServiceRPCInputSchema | create-connectivity-servicebody object
try {
    CreateConnectivityServiceRPCOutputSchema result = apiInstance.createCreateConnectivityServiceById(createConnectivityService);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createCreateConnectivityServiceById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createConnectivityService** | [**CreateConnectivityServiceRPCInputSchema**](CreateConnectivityServiceRPCInputSchema.md)| create-connectivity-servicebody object |

### Return type

[**CreateConnectivityServiceRPCOutputSchema**](CreateConnectivityServiceRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createDeleteConnectivityServiceById"></a>
# **createDeleteConnectivityServiceById**
> createDeleteConnectivityServiceById(deleteConnectivityService)

Create delete-connectivity-service by ID

Create operation of resource: delete-connectivity-service

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
DeleteConnectivityServiceRPCInputSchema deleteConnectivityService = new DeleteConnectivityServiceRPCInputSchema(); // DeleteConnectivityServiceRPCInputSchema | delete-connectivity-servicebody object
try {
    apiInstance.createDeleteConnectivityServiceById(deleteConnectivityService);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createDeleteConnectivityServiceById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deleteConnectivityService** | [**DeleteConnectivityServiceRPCInputSchema**](DeleteConnectivityServiceRPCInputSchema.md)| delete-connectivity-servicebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetConnectionDetailsById"></a>
# **createGetConnectionDetailsById**
> GetConnectionDetailsRPCOutputSchema createGetConnectionDetailsById(getConnectionDetails)

Create get-connection-details by ID

Create operation of resource: get-connection-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetConnectionDetailsRPCInputSchema getConnectionDetails = new GetConnectionDetailsRPCInputSchema(); // GetConnectionDetailsRPCInputSchema | get-connection-detailsbody object
try {
    GetConnectionDetailsRPCOutputSchema result = apiInstance.createGetConnectionDetailsById(getConnectionDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetConnectionDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getConnectionDetails** | [**GetConnectionDetailsRPCInputSchema**](GetConnectionDetailsRPCInputSchema.md)| get-connection-detailsbody object |

### Return type

[**GetConnectionDetailsRPCOutputSchema**](GetConnectionDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetConnectionEndPointDetailsById"></a>
# **createGetConnectionEndPointDetailsById**
> GetConnectionEndPointDetailsRPCOutputSchema createGetConnectionEndPointDetailsById(getConnectionEndPointDetails)

Create get-connection-end-point-details by ID

Create operation of resource: get-connection-end-point-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetConnectionEndPointDetailsRPCInputSchema getConnectionEndPointDetails = new GetConnectionEndPointDetailsRPCInputSchema(); // GetConnectionEndPointDetailsRPCInputSchema | get-connection-end-point-detailsbody object
try {
    GetConnectionEndPointDetailsRPCOutputSchema result = apiInstance.createGetConnectionEndPointDetailsById(getConnectionEndPointDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetConnectionEndPointDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getConnectionEndPointDetails** | [**GetConnectionEndPointDetailsRPCInputSchema**](GetConnectionEndPointDetailsRPCInputSchema.md)| get-connection-end-point-detailsbody object |

### Return type

[**GetConnectionEndPointDetailsRPCOutputSchema**](GetConnectionEndPointDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetConnectivityServiceDetailsById"></a>
# **createGetConnectivityServiceDetailsById**
> GetConnectivityServiceDetailsRPCOutputSchema createGetConnectivityServiceDetailsById(getConnectivityServiceDetails)

Create get-connectivity-service-details by ID

Create operation of resource: get-connectivity-service-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetConnectivityServiceDetailsRPCInputSchema getConnectivityServiceDetails = new GetConnectivityServiceDetailsRPCInputSchema(); // GetConnectivityServiceDetailsRPCInputSchema | get-connectivity-service-detailsbody object
try {
    GetConnectivityServiceDetailsRPCOutputSchema result = apiInstance.createGetConnectivityServiceDetailsById(getConnectivityServiceDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetConnectivityServiceDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getConnectivityServiceDetails** | [**GetConnectivityServiceDetailsRPCInputSchema**](GetConnectivityServiceDetailsRPCInputSchema.md)| get-connectivity-service-detailsbody object |

### Return type

[**GetConnectivityServiceDetailsRPCOutputSchema**](GetConnectivityServiceDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetConnectivityServiceListById"></a>
# **createGetConnectivityServiceListById**
> GetConnectivityServiceListRPCOutputSchema createGetConnectivityServiceListById()

Create get-connectivity-service-list by ID

Create operation of resource: get-connectivity-service-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    GetConnectivityServiceListRPCOutputSchema result = apiInstance.createGetConnectivityServiceListById();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetConnectivityServiceListById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetConnectivityServiceListRPCOutputSchema**](GetConnectivityServiceListRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetLinkDetailsById"></a>
# **createGetLinkDetailsById**
> GetLinkDetailsRPCOutputSchema createGetLinkDetailsById(getLinkDetails)

Create get-link-details by ID

Create operation of resource: get-link-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetLinkDetailsRPCInputSchema getLinkDetails = new GetLinkDetailsRPCInputSchema(); // GetLinkDetailsRPCInputSchema | get-link-detailsbody object
try {
    GetLinkDetailsRPCOutputSchema result = apiInstance.createGetLinkDetailsById(getLinkDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetLinkDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getLinkDetails** | [**GetLinkDetailsRPCInputSchema**](GetLinkDetailsRPCInputSchema.md)| get-link-detailsbody object |

### Return type

[**GetLinkDetailsRPCOutputSchema**](GetLinkDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetNodeDetailsById"></a>
# **createGetNodeDetailsById**
> GetNodeDetailsRPCOutputSchema createGetNodeDetailsById(getNodeDetails)

Create get-node-details by ID

Create operation of resource: get-node-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetNodeDetailsRPCInputSchema getNodeDetails = new GetNodeDetailsRPCInputSchema(); // GetNodeDetailsRPCInputSchema | get-node-detailsbody object
try {
    GetNodeDetailsRPCOutputSchema result = apiInstance.createGetNodeDetailsById(getNodeDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetNodeDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getNodeDetails** | [**GetNodeDetailsRPCInputSchema**](GetNodeDetailsRPCInputSchema.md)| get-node-detailsbody object |

### Return type

[**GetNodeDetailsRPCOutputSchema**](GetNodeDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetNodeEdgePointDetailsById"></a>
# **createGetNodeEdgePointDetailsById**
> GetNodeEdgePointDetailsRPCOutputSchema createGetNodeEdgePointDetailsById(getNodeEdgePointDetails)

Create get-node-edge-point-details by ID

Create operation of resource: get-node-edge-point-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails = new GetNodeEdgePointDetailsRPCInputSchema(); // GetNodeEdgePointDetailsRPCInputSchema | get-node-edge-point-detailsbody object
try {
    GetNodeEdgePointDetailsRPCOutputSchema result = apiInstance.createGetNodeEdgePointDetailsById(getNodeEdgePointDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetNodeEdgePointDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getNodeEdgePointDetails** | [**GetNodeEdgePointDetailsRPCInputSchema**](GetNodeEdgePointDetailsRPCInputSchema.md)| get-node-edge-point-detailsbody object |

### Return type

[**GetNodeEdgePointDetailsRPCOutputSchema**](GetNodeEdgePointDetailsRPCOutputSchema.md)

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

<a name="createGetTopologyDetailsById"></a>
# **createGetTopologyDetailsById**
> GetTopologyDetailsRPCOutputSchema createGetTopologyDetailsById(getTopologyDetails)

Create get-topology-details by ID

Create operation of resource: get-topology-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetTopologyDetailsRPCInputSchema getTopologyDetails = new GetTopologyDetailsRPCInputSchema(); // GetTopologyDetailsRPCInputSchema | get-topology-detailsbody object
try {
    GetTopologyDetailsRPCOutputSchema result = apiInstance.createGetTopologyDetailsById(getTopologyDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetTopologyDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getTopologyDetails** | [**GetTopologyDetailsRPCInputSchema**](GetTopologyDetailsRPCInputSchema.md)| get-topology-detailsbody object |

### Return type

[**GetTopologyDetailsRPCOutputSchema**](GetTopologyDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetTopologyListById"></a>
# **createGetTopologyListById**
> GetTopologyListRPCOutputSchema createGetTopologyListById()

Create get-topology-list by ID

Create operation of resource: get-topology-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    GetTopologyListRPCOutputSchema result = apiInstance.createGetTopologyListById();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetTopologyListById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetTopologyListRPCOutputSchema**](GetTopologyListRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUpdateConnectivityServiceById"></a>
# **createUpdateConnectivityServiceById**
> UpdateConnectivityServiceRPCOutputSchema createUpdateConnectivityServiceById(updateConnectivityService)

Create update-connectivity-service by ID

Create operation of resource: update-connectivity-service

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
UpdateConnectivityServiceRPCInputSchema updateConnectivityService = new UpdateConnectivityServiceRPCInputSchema(); // UpdateConnectivityServiceRPCInputSchema | update-connectivity-servicebody object
try {
    UpdateConnectivityServiceRPCOutputSchema result = apiInstance.createUpdateConnectivityServiceById(updateConnectivityService);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createUpdateConnectivityServiceById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateConnectivityService** | [**UpdateConnectivityServiceRPCInputSchema**](UpdateConnectivityServiceRPCInputSchema.md)| update-connectivity-servicebody object |

### Return type

[**UpdateConnectivityServiceRPCOutputSchema**](UpdateConnectivityServiceRPCOutputSchema.md)

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
> ContextSchema retrieveContext()

Retrieve context

Retrieve operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    ContextSchema result = apiInstance.retrieveContext();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContext");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ContextSchema**](ContextSchema.md)

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
ContextSchema context = new ContextSchema(); // ContextSchema | contextbody object
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
 **context** | [**ContextSchema**](ContextSchema.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

