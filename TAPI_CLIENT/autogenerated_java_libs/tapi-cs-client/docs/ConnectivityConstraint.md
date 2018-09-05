
# ConnectivityConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**diversityPolicy** | [**DiversityPolicyEnum**](#DiversityPolicyEnum) |  |  [optional]
**routeObjectiveFunction** | [**RouteObjectiveFunctionEnum**](#RouteObjectiveFunctionEnum) |  |  [optional]
**serviceType** | [**ServiceTypeEnum**](#ServiceTypeEnum) |  |  [optional]
**schedule** | [**TimeRange**](TimeRange.md) |  |  [optional]
**requestedCapacity** | [**Capacity**](Capacity.md) |  |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**isExclusive** | **Boolean** | To distinguish if the resources are exclusive to the service  - for example between EPL(isExclusive&#x3D;true) and EVPL (isExclusive&#x3D;false), or between EPLAN (isExclusive&#x3D;true) and EVPLAN (isExclusive&#x3D;false) |  [optional]
**serviceLevel** | **String** | An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability |  [optional]
**diversityExclusion** | [**List&lt;ConnectivityServiceRef&gt;**](ConnectivityServiceRef.md) |  |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**corouteInclusion** | [**ConnectivityServiceRef**](ConnectivityServiceRef.md) |  |  [optional]


<a name="DiversityPolicyEnum"></a>
## Enum: DiversityPolicyEnum
Name | Value
---- | -----
SRLG | &quot;SRLG&quot;
SRNG | &quot;SRNG&quot;
SNG | &quot;SNG&quot;
NODE | &quot;NODE&quot;
LINK | &quot;LINK&quot;


<a name="RouteObjectiveFunctionEnum"></a>
## Enum: RouteObjectiveFunctionEnum
Name | Value
---- | -----
MIN_WORK_ROUTE_HOP | &quot;MIN_WORK_ROUTE_HOP&quot;
MIN_WORK_ROUTE_COST | &quot;MIN_WORK_ROUTE_COST&quot;
MIN_WORK_ROUTE_LATENCY | &quot;MIN_WORK_ROUTE_LATENCY&quot;
MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_HOP | &quot;MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_HOP&quot;
MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_COST | &quot;MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_COST&quot;
MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_LATENCY | &quot;MIN_SUM_OF_WORK_AND_PROTECTION_ROUTE_LATENCY&quot;
LOAD_BALANCE_MAX_UNUSED_CAPACITY | &quot;LOAD_BALANCE_MAX_UNUSED_CAPACITY&quot;


<a name="ServiceTypeEnum"></a>
## Enum: ServiceTypeEnum
Name | Value
---- | -----
POINT_TO_POINT_CONNECTIVITY | &quot;POINT_TO_POINT_CONNECTIVITY&quot;
POINT_TO_MULTIPOINT_CONNECTIVITY | &quot;POINT_TO_MULTIPOINT_CONNECTIVITY&quot;
MULTIPOINT_CONNECTIVITY | &quot;MULTIPOINT_CONNECTIVITY&quot;
ROOTED_MULTIPOINT_CONNECTIVITY | &quot;ROOTED_MULTIPOINT_CONNECTIVITY&quot;



