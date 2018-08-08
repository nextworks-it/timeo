
# RoutingConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**requestedCapacity** | [**Capacity**](Capacity.md) |  |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**serviceLevel** | **String** | An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability |  [optional]
**avoidTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**pathLayer** | [**List&lt;PathLayerEnum&gt;**](#List&lt;PathLayerEnum&gt;) |  |  [optional]
**includeTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]


<a name="List<PathLayerEnum>"></a>
## Enum: List&lt;PathLayerEnum&gt;
Name | Value
---- | -----
OTSIA | &quot;OTSiA&quot;
OCH | &quot;OCH&quot;
OTU | &quot;OTU&quot;
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
ETY | &quot;ETY&quot;
SDM | &quot;SDM&quot;
DSR | &quot;DSR&quot;



