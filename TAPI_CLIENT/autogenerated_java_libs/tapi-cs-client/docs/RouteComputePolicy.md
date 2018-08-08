
# RouteComputePolicy

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**diversityPolicy** | [**DiversityPolicyEnum**](#DiversityPolicyEnum) |  |  [optional]
**routeObjectiveFunction** | [**RouteObjectiveFunctionEnum**](#RouteObjectiveFunctionEnum) |  |  [optional]


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



