
# RoutingConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**diversityPolicy** | **String** |  |  [optional]
**routeDirection** | **String** |  |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**routeObjectiveFunction** | **String** |  |  [optional]
**isExclusive** | **Boolean** | To distinguish if the resources are to be exclusive to the service |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**riskDiversityCharacteristic** | [**List&lt;RiskCharacteristic&gt;**](RiskCharacteristic.md) |  |  [optional]


