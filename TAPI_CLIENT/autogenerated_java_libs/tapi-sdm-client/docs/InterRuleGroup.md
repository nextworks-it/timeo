
# InterRuleGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**availableCapacity** | [**Capacity**](Capacity.md) | Capacity available to be assigned. |  [optional]
**totalPotentialCapacity** | [**Capacity**](Capacity.md) | An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken. |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**riskCharacteristic** | [**List&lt;RiskCharacteristic&gt;**](RiskCharacteristic.md) | A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration. |  [optional]
**associatedNodeRuleGroup** | [**List&lt;NodeRuleGroupRef&gt;**](NodeRuleGroupRef.md) |  |  [optional]
**rule** | [**List&lt;Rule&gt;**](Rule.md) |  |  [optional]



