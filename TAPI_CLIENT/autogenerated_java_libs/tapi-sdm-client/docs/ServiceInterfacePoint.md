
# ServiceInterfacePoint

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
**layerProtocolName** | [**List&lt;LayerProtocolNameEnum&gt;**](#List&lt;LayerProtocolNameEnum&gt;) |  |  [optional]


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



