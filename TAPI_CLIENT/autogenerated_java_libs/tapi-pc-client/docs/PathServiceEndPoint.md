
# PathServiceEndPoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**serviceLayer** | [**ServiceLayerEnum**](#ServiceLayerEnum) |  |  [optional]
**serviceInterfacePoint** | [**ServiceInterfacePointRef**](ServiceInterfacePointRef.md) |  |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) | The orientation of defined flow at the EndPoint. |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]


<a name="ServiceLayerEnum"></a>
## Enum: ServiceLayerEnum
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
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
SYMMETRIC | &quot;SYMMETRIC&quot;
ROOT | &quot;ROOT&quot;
LEAF | &quot;LEAF&quot;
TRUNK | &quot;TRUNK&quot;
UNKNOWN | &quot;UNKNOWN&quot;



