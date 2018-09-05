
# Link

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**administrativeState** | [**AdministrativeStateEnum**](#AdministrativeStateEnum) |  |  [optional]
**lifecycleState** | [**LifecycleStateEnum**](#LifecycleStateEnum) |  |  [optional]
**operationalState** | [**OperationalStateEnum**](#OperationalStateEnum) |  |  [optional]
**availableCapacity** | [**Capacity**](Capacity.md) | Capacity available to be assigned. |  [optional]
**totalPotentialCapacity** | [**Capacity**](Capacity.md) | An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken. |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**errorCharacteristic** | **String** | Describes the degree to which the signal propagated can be errored.  Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded. |  [optional]
**unavailableTimeCharacteristic** | **String** | Describes the duration for which there may be no valid signal propagated. |  [optional]
**lossCharacteristic** | **String** | Describes the acceptable characteristic of lost packets where loss may result from discard due to errors or overflow. Applies to packet systems and not TDM (as for TDM errored signals are propagated unless grossly errored and overflow/underflow turns into timing slips). |  [optional]
**deliveryOrderCharacteristic** | **String** | Describes the degree to which packets will be delivered out of sequence. Does not apply to TDM as the TDM protocols maintain strict order. |  [optional]
**serverIntegrityProcessCharacteristic** | **String** | Describes the effect of any server integrity enhancement process on the characteristics of the TopologicalEntity. |  [optional]
**repeatDeliveryCharacteristic** | **String** | Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example).  It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay. |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**riskCharacteristic** | [**List&lt;RiskCharacteristic&gt;**](RiskCharacteristic.md) | A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration. |  [optional]
**validationMechanism** | [**List&lt;ValidationMechanism&gt;**](ValidationMechanism.md) | Provides details of the specific validation mechanism(s) used to confirm the presence of an intended topologicalEntity. |  [optional]
**transitionedLayerProtocolName** | **List&lt;String&gt;** |  |  [optional]
**nodeEdgePoint** | [**List&lt;OwnedNodeEdgePointRef&gt;**](OwnedNodeEdgePointRef.md) |  |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) | The directionality of the Link.  Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL).  Is not present in more complex cases. |  [optional]
**layerProtocolName** | [**List&lt;LayerProtocolNameEnum&gt;**](#List&lt;LayerProtocolNameEnum&gt;) |  |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]


<a name="AdministrativeStateEnum"></a>
## Enum: AdministrativeStateEnum
Name | Value
---- | -----
LOCKED | &quot;LOCKED&quot;
UNLOCKED | &quot;UNLOCKED&quot;


<a name="LifecycleStateEnum"></a>
## Enum: LifecycleStateEnum
Name | Value
---- | -----
PLANNED | &quot;PLANNED&quot;
POTENTIAL_AVAILABLE | &quot;POTENTIAL_AVAILABLE&quot;
POTENTIAL_BUSY | &quot;POTENTIAL_BUSY&quot;
INSTALLED | &quot;INSTALLED&quot;
PENDING_REMOVAL | &quot;PENDING_REMOVAL&quot;


<a name="OperationalStateEnum"></a>
## Enum: OperationalStateEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
UNIDIRECTIONAL | &quot;UNIDIRECTIONAL&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;


<a name="List<LayerProtocolNameEnum>"></a>
## Enum: List&lt;LayerProtocolNameEnum&gt;
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



