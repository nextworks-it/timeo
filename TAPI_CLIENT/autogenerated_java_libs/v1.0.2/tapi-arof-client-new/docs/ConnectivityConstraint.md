
# ConnectivityConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**serviceType** | [**ServiceTypeEnum**](#ServiceTypeEnum) |  |  [optional]
**schedule** | [**TimeRange**](TimeRange.md) |  |  [optional]
**requestedCapacity** | [**Capacity**](Capacity.md) |  |  [optional]
**serviceLayer** | [**ServiceLayerEnum**](#ServiceLayerEnum) |  |  [optional]
**serviceLevel** | **String** | An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability |  [optional]
**diversityExclusion** | [**List&lt;ConnectivityServiceRef&gt;**](ConnectivityServiceRef.md) |  |  [optional]
**connectivityDirection** | [**ConnectivityDirectionEnum**](#ConnectivityDirectionEnum) |  |  [optional]
**corouteInclusion** | [**ConnectivityServiceRef**](ConnectivityServiceRef.md) |  |  [optional]


<a name="ServiceTypeEnum"></a>
## Enum: ServiceTypeEnum
Name | Value
---- | -----
POINT_TO_POINT_CONNECTIVITY | &quot;POINT_TO_POINT_CONNECTIVITY&quot;
POINT_TO_MULTIPOINT_CONNECTIVITY | &quot;POINT_TO_MULTIPOINT_CONNECTIVITY&quot;
MULTIPOINT_CONNECTIVITY | &quot;MULTIPOINT_CONNECTIVITY&quot;
ROOTED_MULTIPOINT_CONNECTIVITY | &quot;ROOTED_MULTIPOINT_CONNECTIVITY&quot;


<a name="ServiceLayerEnum"></a>
## Enum: ServiceLayerEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


<a name="ConnectivityDirectionEnum"></a>
## Enum: ConnectivityDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
UNIDIRECTIONAL | &quot;UNIDIRECTIONAL&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;



