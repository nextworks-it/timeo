# AlertDescription

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**alertName** | **String** | the human-readable name for the alert |  [optional]
**labels** | [**List&lt;KVP&gt;**](KVP.md) |  |  [optional]
**severity** | [**SeverityEnum**](#SeverityEnum) | the severity of the alert |  [optional]
**_for** | **String** | the time to wait before firing an alert. Pattern [0-9]+{s,m} |  [optional]
**query** | **String** | the query whose value should be monitored. See https://prometheus.io/docs/prometheus/latest/querying/basics/ for details  |  [optional]
**value** | **Double** | the value associated to the threshold |  [optional]
**kind** | [**KindEnum**](#KindEnum) | the kind of inequality the query should satisfy related to the value |  [optional]
**target** | **String** | the URL to which the notification of the violated threshold should be sent |  [optional]

<a name="SeverityEnum"></a>
## Enum: SeverityEnum
Name | Value
---- | -----
WARNING | &quot;warning&quot;
ERROR | &quot;error&quot;
CRITICAL | &quot;critical&quot;

<a name="KindEnum"></a>
## Enum: KindEnum
Name | Value
---- | -----
G | &quot;G&quot;
GEQ | &quot;GEQ&quot;
L | &quot;L&quot;
LEQ | &quot;LEQ&quot;
EQ | &quot;EQ&quot;
NEQ | &quot;NEQ&quot;
