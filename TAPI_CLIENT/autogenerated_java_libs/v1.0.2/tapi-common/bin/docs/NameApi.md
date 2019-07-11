# NameApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextNameNameById**](NameApi.md#createContextNameNameById) | **POST** /config/context/name/{value_name}/ | Create name by ID
[**deleteContextNameNameById**](NameApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
[**retrieveContextNameName**](NameApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
[**retrieveContextNameNameById**](NameApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
[**updateContextNameNameById**](NameApi.md#updateContextNameNameById) | **PUT** /config/context/name/{value_name}/ | Update name by ID




<a name="createContextNameNameById"></a>
# **createContextNameNameById**
> createContextNameNameById(body, valueName)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NameApi;



NameApi apiInstance = new NameApi();

NameAndValue body = new NameAndValue(); // NameAndValue | namebody object

String valueName = Arrays.asList("valueName_example"); // String | ID of value_name

try {
    apiInstance.createContextNameNameById(body, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling NameApi#createContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NameAndValue**](NameAndValue.md)| namebody object |
 **valueName** | [**String**](.md)| ID of value_name |


### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


<a name="deleteContextNameNameById"></a>
# **deleteContextNameNameById**
> deleteContextNameNameById(valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NameApi;



NameApi apiInstance = new NameApi();

String valueName = Arrays.asList("valueName_example"); // String | ID of value_name

try {
    apiInstance.deleteContextNameNameById(valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling NameApi#deleteContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | [**String**](.md)| ID of value_name |


### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


<a name="retrieveContextNameName"></a>
# **retrieveContextNameName**
> List&lt;String&gt; retrieveContextNameName()

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NameApi;



NameApi apiInstance = new NameApi();

try {
    List<String> result = apiInstance.retrieveContextNameName();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NameApi#retrieveContextNameName");
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

 - **Content-Type**: Not defined
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
//import io.swagger.client.api.NameApi;



NameApi apiInstance = new NameApi();

String valueName = Arrays.asList("valueName_example"); // String | ID of value_name

try {
    NameAndValue result = apiInstance.retrieveContextNameNameById(valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NameApi#retrieveContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | [**String**](.md)| ID of value_name |


### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


<a name="updateContextNameNameById"></a>
# **updateContextNameNameById**
> updateContextNameNameById(body, valueName)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NameApi;



NameApi apiInstance = new NameApi();

NameAndValue body = new NameAndValue(); // NameAndValue | namebody object

String valueName = Arrays.asList("valueName_example"); // String | ID of value_name

try {
    apiInstance.updateContextNameNameById(body, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling NameApi#updateContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NameAndValue**](NameAndValue.md)| namebody object |
 **valueName** | [**String**](.md)| ID of value_name |


### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined



