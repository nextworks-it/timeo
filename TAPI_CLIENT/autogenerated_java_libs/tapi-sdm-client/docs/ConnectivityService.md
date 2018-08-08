
# ConnectivityService

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
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
**excludeNode** | [**List&lt;NodeRef&gt;**](NodeRef.md) |  |  [optional]
**includeNode** | [**List&lt;NodeRef&gt;**](NodeRef.md) | This is a loose constraint - that is it is unordered and could be a partial list |  [optional]
**includePath** | [**List&lt;PathRef&gt;**](PathRef.md) |  |  [optional]
**includeLink** | [**List&lt;LinkRef&gt;**](LinkRef.md) | This is a loose constraint - that is it is unordered and could be a partial list  |  [optional]
**excludePath** | [**List&lt;PathRef&gt;**](PathRef.md) |  |  [optional]
**excludeLink** | [**List&lt;LinkRef&gt;**](LinkRef.md) |  |  [optional]
**preferredTransportLayer** | [**List&lt;PreferredTransportLayerEnum&gt;**](#List&lt;PreferredTransportLayerEnum&gt;) |  |  [optional]
**avoidTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]
**includeTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]
**administrativeState** | [**AdministrativeStateEnum**](#AdministrativeStateEnum) |  |  [optional]
**lifecycleState** | [**LifecycleStateEnum**](#LifecycleStateEnum) |  |  [optional]
**operationalState** | [**OperationalStateEnum**](#OperationalStateEnum) |  |  [optional]
**maxSwitchTimes** | **String** | Used to limit the maximum swtich times. When work fault disappears , and traffic return to the original work path, switch counter reset. |  [optional]
**waitToRevertTime** | **String** | If the protection system is revertive, this attribute specifies the time, in minutes, to wait after a fault clears on a higher priority (preferred) resource before reverting to the preferred resource. |  [optional]
**layerProtocol** | [**LayerProtocolEnum**](#LayerProtocolEnum) | Indicate which layer this resilience parameters package configured for. |  [optional]
**restorePriority** | **String** |  |  [optional]
**isLockOut** | **Boolean** | The resource is configured to temporarily not be available for use in the protection scheme(s) it is part of. This overrides all other protection control states including forced. If the item is locked out then it cannot be used under any circumstances. Note: Only relevant when part of a protection scheme. |  [optional]
**isCoordinatedSwitchingBothEnds** | **Boolean** | Is operating such that switching at both ends of each flow acorss the FC is coordinated at both ingress and egress ends. |  [optional]
**isFrozen** | **Boolean** | Temporarily prevents any switch action to be taken and, as such, freezes the current state.  Until the freeze is cleared, additional near-end external commands are rejected and fault condition changes and received APS messages are ignored. All administrative controls of any aspect of protection are rejected. |  [optional]
**reversionMode** | [**ReversionModeEnum**](#ReversionModeEnum) | Indcates whether the protection scheme is revertive or non-revertive. |  [optional]
**holdOffTime** | **String** | This attribute indicates the time, in milliseconds, between declaration of signal degrade or signal fail, and the initialization of the protection switching algorithm. |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]
**restorationCoordinateType** | [**RestorationCoordinateTypeEnum**](#RestorationCoordinateTypeEnum) |  The coordination mechanism between multi-layers. |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**connection** | [**List&lt;ConnectionRef&gt;**](ConnectionRef.md) |  |  [optional]
**endPoint** | [**List&lt;ConnectivityServiceEndPoint&gt;**](ConnectivityServiceEndPoint.md) |  |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) |  |  [optional]


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


<a name="List<PreferredTransportLayerEnum>"></a>
## Enum: List&lt;PreferredTransportLayerEnum&gt;
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


<a name="LayerProtocolEnum"></a>
## Enum: LayerProtocolEnum
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


<a name="ReversionModeEnum"></a>
## Enum: ReversionModeEnum
Name | Value
---- | -----
REVERTIVE | &quot;REVERTIVE&quot;
NON_REVERTIVE | &quot;NON-REVERTIVE&quot;


<a name="RestorationCoordinateTypeEnum"></a>
## Enum: RestorationCoordinateTypeEnum
Name | Value
---- | -----
NO_COORDINATE | &quot;NO_COORDINATE&quot;
HOLD_OFF_TIME | &quot;HOLD_OFF_TIME&quot;
WAIT_FOR_NOTIFICATION | &quot;WAIT_FOR_NOTIFICATION&quot;


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
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


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
UNIDIRECTIONAL | &quot;UNIDIRECTIONAL&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;



