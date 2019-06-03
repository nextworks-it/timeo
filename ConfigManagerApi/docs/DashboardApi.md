# DashboardApi

All URIs are relative to *//localhost:8080/prom-manager*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteDashboard**](DashboardApi.md#deleteDashboard) | **DELETE** /dashboard/{dashboardId} | Delete dashboard
[**getAllDashboards**](DashboardApi.md#getAllDashboards) | **GET** /dashboard | Get all dashboards
[**getDashboard**](DashboardApi.md#getDashboard) | **GET** /dashboard/{dashboardId} | Get dashboard details
[**postDashboard**](DashboardApi.md#postDashboard) | **POST** /dashboard | Create new dashboard
[**putDashboard**](DashboardApi.md#putDashboard) | **PUT** /dashboard/{dashboardId} | Update dashboard

<a name="deleteDashboard"></a>
# **deleteDashboard**
> Object deleteDashboard(dashboardId)

Delete dashboard

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DashboardApi;


DashboardApi apiInstance = new DashboardApi();
String dashboardId = "dashboardId_example"; // String | the ID of the dashboard
try {
    Object result = apiInstance.deleteDashboard(dashboardId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DashboardApi#deleteDashboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dashboardId** | **String**| the ID of the dashboard |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="getAllDashboards"></a>
# **getAllDashboards**
> DashboardQueryResult getAllDashboards()

Get all dashboards

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DashboardApi;


DashboardApi apiInstance = new DashboardApi();
try {
    DashboardQueryResult result = apiInstance.getAllDashboards();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DashboardApi#getAllDashboards");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**DashboardQueryResult**](DashboardQueryResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="getDashboard"></a>
# **getDashboard**
> Dashboard getDashboard(dashboardId)

Get dashboard details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DashboardApi;


DashboardApi apiInstance = new DashboardApi();
String dashboardId = "dashboardId_example"; // String | the ID of the dashboard
try {
    Dashboard result = apiInstance.getDashboard(dashboardId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DashboardApi#getDashboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dashboardId** | **String**| the ID of the dashboard |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/x-yaml

<a name="postDashboard"></a>
# **postDashboard**
> Dashboard postDashboard(body)

Create new dashboard

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DashboardApi;


DashboardApi apiInstance = new DashboardApi();
DashboardDescription body = new DashboardDescription(); // DashboardDescription | the dashboard to be created
try {
    Dashboard result = apiInstance.postDashboard(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DashboardApi#postDashboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DashboardDescription**](DashboardDescription.md)| the dashboard to be created |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/x-yaml
 - **Accept**: application/json, application/x-yaml

<a name="putDashboard"></a>
# **putDashboard**
> Dashboard putDashboard(body, dashboardId)

Update dashboard

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DashboardApi;


DashboardApi apiInstance = new DashboardApi();
Dashboard body = new Dashboard(); // Dashboard | the dashboard properties to be updated
String dashboardId = "dashboardId_example"; // String | the ID of the dashboard
try {
    Dashboard result = apiInstance.putDashboard(body, dashboardId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DashboardApi#putDashboard");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Dashboard**](Dashboard.md)| the dashboard properties to be updated |
 **dashboardId** | **String**| the ID of the dashboard |

### Return type

[**Dashboard**](Dashboard.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/x-yaml
 - **Accept**: application/json, application/x-yaml

