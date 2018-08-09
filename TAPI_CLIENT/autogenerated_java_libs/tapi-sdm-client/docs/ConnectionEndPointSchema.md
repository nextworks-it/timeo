
# ConnectionEndPointSchema

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**lifecycleState** | [**LifecycleStateEnum**](#LifecycleStateEnum) |  |  [optional]
**operationalState** | [**OperationalStateEnum**](#OperationalStateEnum) |  |  [optional]
**terminationState** | [**TerminationStateEnum**](#TerminationStateEnum) | Indicates whether the layer is terminated and if so how. |  [optional]
**terminationDirection** | [**TerminationDirectionEnum**](#TerminationDirectionEnum) | The overall directionality of the LP.  - A BIDIRECTIONAL LP will have some SINK and/or SOURCE flowss. - A SINK LP can only contain elements with SINK flows or CONTRA_DIRECTION_SOURCE flows - A SOURCE LP can only contain SOURCE flows or CONTRA_DIRECTION_SINK flows |  [optional]
**clientNodeEdgePoint** | [**List&lt;OwnedNodeEdgePointRef&gt;**](OwnedNodeEdgePointRef.md) |  |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**connectivityServiceEndPoint** | [**ConnectivityServiceEndPointRef**](ConnectivityServiceEndPointRef.md) |  |  [optional]
**connectionPortDirection** | [**ConnectionPortDirectionEnum**](#ConnectionPortDirectionEnum) | The orientation of defined flow at the EndPoint. |  [optional]
**parentNodeEdgePoint** | [**List&lt;OwnedNodeEdgePointRef&gt;**](OwnedNodeEdgePointRef.md) |  |  [optional]
**connectionPortRole** | [**ConnectionPortRoleEnum**](#ConnectionPortRoleEnum) | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]
**connectionEndPointUuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**sdmTermination** | [**SdmTerminationPac**](SdmTerminationPac.md) |  |  [optional]


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


<a name="TerminationStateEnum"></a>
## Enum: TerminationStateEnum
Name | Value
---- | -----
LP_CAN_NEVER_TERMINATE | &quot;LP_CAN_NEVER_TERMINATE&quot;
LT_NOT_TERMINATED | &quot;LT_NOT_TERMINATED&quot;
TERMINATED_SERVER_TO_CLIENT_FLOW | &quot;TERMINATED_SERVER_TO_CLIENT_FLOW&quot;
TERMINATED_CLIENT_TO_SERVER_FLOW | &quot;TERMINATED_CLIENT_TO_SERVER_FLOW&quot;
TERMINATED_BIDIRECTIONAL | &quot;TERMINATED_BIDIRECTIONAL&quot;
LT_PERMENANTLY_TERMINATED | &quot;LT_PERMENANTLY_TERMINATED&quot;
TERMINATION_STATE_UNKNOWN | &quot;TERMINATION_STATE_UNKNOWN&quot;


<a name="TerminationDirectionEnum"></a>
## Enum: TerminationDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
SINK | &quot;SINK&quot;
SOURCE | &quot;SOURCE&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;


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


<a name="ConnectionPortDirectionEnum"></a>
## Enum: ConnectionPortDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="ConnectionPortRoleEnum"></a>
## Enum: ConnectionPortRoleEnum
Name | Value
---- | -----
SYMMETRIC | &quot;SYMMETRIC&quot;
ROOT | &quot;ROOT&quot;
LEAF | &quot;LEAF&quot;
TRUNK | &quot;TRUNK&quot;
UNKNOWN | &quot;UNKNOWN&quot;


