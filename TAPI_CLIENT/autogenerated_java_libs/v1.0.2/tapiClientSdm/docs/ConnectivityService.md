
# ConnectivityService

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**serviceType** | [**ServiceTypeEnum**](#ServiceTypeEnum) |  |  [optional]
**schedule** | [**TimeRange**](TimeRange.md) |  |  [optional]
**requestedCapacity** | [**Capacity**](Capacity.md) |  |  [optional]
**serviceLayer** | [**ServiceLayerEnum**](#ServiceLayerEnum) |  |  [optional]
**serviceLevel** | **String** | An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability |  [optional]
**diversityExclusion** | [**List&lt;ConnectivityServiceRef&gt;**](ConnectivityServiceRef.md) |  |  [optional]
**connectivityDirection** | [**ConnectivityDirectionEnum**](#ConnectivityDirectionEnum) |  |  [optional]
**corouteInclusion** | [**ConnectivityServiceRef**](ConnectivityServiceRef.md) |  |  [optional]
**diversityPolicy** | **String** |  |  [optional]
**routeDirection** | **String** |  |  [optional]
**costCharacteristic** | [**List&lt;CostCharacteristic&gt;**](CostCharacteristic.md) | The list of costs where each cost relates to some aspect of the TopologicalEntity. |  [optional]
**routeObjectiveFunction** | **String** |  |  [optional]
**isExclusive** | **Boolean** | To distinguish if the resources are to be exclusive to the service |  [optional]
**latencyCharacteristic** | [**List&lt;LatencyCharacteristic&gt;**](LatencyCharacteristic.md) | The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic. |  [optional]
**riskDiversityCharacteristic** | [**List&lt;RiskCharacteristic&gt;**](RiskCharacteristic.md) |  |  [optional]
**excludeNode** | **List&lt;String&gt;** |  |  [optional]
**includeNode** | **List&lt;String&gt;** |  |  [optional]
**includePath** | **List&lt;String&gt;** |  |  [optional]
**includeLink** | **List&lt;String&gt;** |  |  [optional]
**excludePath** | **List&lt;String&gt;** |  |  [optional]
**excludeLink** | **List&lt;String&gt;** |  |  [optional]
**preferredTransportLayer** | **List&lt;String&gt;** |  |  [optional]
**avoidTopology** | **List&lt;String&gt;** |  |  [optional]
**includeTopology** | **List&lt;String&gt;** |  |  [optional]
**maxSwitchTimes** | **String** | Used to limit the maximum swtich times. When work fault disappears , and traffic return to the original work path, switch counter reset. |  [optional]
**waitToRevertTime** | **String** | If the protection system is revertive, this attribute specifies the time, in minutes, to wait after a fault clears on a higher priority (preferred) resource before reverting to the preferred resource. |  [optional]
**restorePriority** | **String** |  |  [optional]
**isLockOut** | **Boolean** | The resource is configured to temporarily not be available for use in the protection scheme(s) it is part of. This overrides all other protection control states including forced. If the item is locked out then it cannot be used under any circumstances. Note: Only relevant when part of a protection scheme. |  [optional]
**isCoordinatedSwitchingBothEnds** | **Boolean** | Is operating such that switching at both ends of each flow acorss the FC is coordinated at both ingress and egress ends. |  [optional]
**isFrozen** | **Boolean** | Temporarily prevents any switch action to be taken and, as such, freezes the current state. Until the freeze is cleared, additional near-end external commands are rejected and fault condition changes and received APS messages are ignored. All administrative controls of any aspect of protection are rejected. |  [optional]
**preferredRestorationLayer** | [**List&lt;PreferredRestorationLayerEnum&gt;**](#List&lt;PreferredRestorationLayerEnum&gt;) |  |  [optional]
**reversionMode** | [**ReversionModeEnum**](#ReversionModeEnum) | Indcates whether the protection scheme is revertive or non-revertive. |  [optional]
**holdOffTime** | **String** | This attribute indicates the time, in milliseconds, between declaration of signal degrade or signal fail, and the initialization of the protection switching algorithm. |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]
**restorationCoordinateType** | [**RestorationCoordinateTypeEnum**](#RestorationCoordinateTypeEnum) |  The coordination mechanism between multi-layers. |  [optional]
**administrativeState** | [**AdministrativeStateEnum**](#AdministrativeStateEnum) |  |  [optional]
**lifecycleState** | [**LifecycleStateEnum**](#LifecycleStateEnum) |  |  [optional]
**operationalState** | [**OperationalStateEnum**](#OperationalStateEnum) |  |  [optional]
**connection** | [**List&lt;ConnectionRef&gt;**](ConnectionRef.md) |  |  [optional]
**endPoint** | [**List&lt;ConnectivityServiceEndPoint&gt;**](ConnectivityServiceEndPoint.md) |  |  [optional]


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


<a name="List<PreferredRestorationLayerEnum>"></a>
## Enum: List&lt;PreferredRestorationLayerEnum&gt;
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


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



