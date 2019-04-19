# ExporterApi

All URIs are relative to *//localhost:8080/prom-manager*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteExporter**](ExporterApi.md#deleteExporter) | **DELETE** /exporter/{exporterId} | Delete exporter
[**getExporter**](ExporterApi.md#getExporter) | **GET** /exporter/{exporterId} | Get exporter details
[**getExporters**](ExporterApi.md#getExporters) | **GET** /exporter | Get all exporters
[**postExporter**](ExporterApi.md#postExporter) | **POST** /exporter | Create new exporter
[**putExporter**](ExporterApi.md#putExporter) | **PUT** /exporter/{exporterId} | Update exporter

<a name="deleteExporter"></a>
# **deleteExporter**
> Object deleteExporter(exporterId)

Delete exporter

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExporterApi;


ExporterApi apiInstance = new ExporterApi();
String exporterId = "exporterId_example"; // String | The ID of the exporter to be deleted
try {
    Object result = apiInstance.deleteExporter(exporterId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExporterApi#deleteExporter");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **exporterId** | **String**| The ID of the exporter to be deleted |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="getExporter"></a>
# **getExporter**
> Exporter getExporter(exporterId)

Get exporter details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExporterApi;


ExporterApi apiInstance = new ExporterApi();
String exporterId = "exporterId_example"; // String | The ID of the exporter
try {
    Exporter result = apiInstance.getExporter(exporterId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExporterApi#getExporter");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **exporterId** | **String**| The ID of the exporter |

### Return type

[**Exporter**](Exporter.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="getExporters"></a>
# **getExporters**
> ExporterQueryResult getExporters()

Get all exporters

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExporterApi;


ExporterApi apiInstance = new ExporterApi();
try {
    ExporterQueryResult result = apiInstance.getExporters();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExporterApi#getExporters");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ExporterQueryResult**](ExporterQueryResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="postExporter"></a>
# **postExporter**
> Exporter postExporter(body)

Create new exporter

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExporterApi;


ExporterApi apiInstance = new ExporterApi();
ExporterDescription body = new ExporterDescription(); // ExporterDescription | The exporter to be created
try {
    Exporter result = apiInstance.postExporter(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExporterApi#postExporter");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ExporterDescription**](ExporterDescription.md)| The exporter to be created |

### Return type

[**Exporter**](Exporter.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/x-yaml
 - **Accept**: application/json, application/x-yaml

<a name="putExporter"></a>
# **putExporter**
> Exporter putExporter(body, exporterId)

Update exporter

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExporterApi;


ExporterApi apiInstance = new ExporterApi();
Exporter body = new Exporter(); // Exporter | The exporter data to update
String exporterId = "exporterId_example"; // String | The ID of the exporter to be updated
try {
    Exporter result = apiInstance.putExporter(body, exporterId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExporterApi#putExporter");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Exporter**](Exporter.md)| The exporter data to update |
 **exporterId** | **String**| The ID of the exporter to be updated |

### Return type

[**Exporter**](Exporter.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/x-yaml
 - **Accept**: application/json, application/x-yaml

