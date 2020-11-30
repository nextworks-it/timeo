
# PathServiceEndPoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**direction** | [**DirectionEnum**](#DirectionEnum) | The orientation of defined flow at the EndPoint. |  [optional]
**layerProtocolQualifier** | **String** |  |  [optional]
**capacity** | [**Capacity**](Capacity.md) |  |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]
**serviceInterfacePoint** | [**ServiceInterfacePointRef**](ServiceInterfacePointRef.md) |  |  [optional]


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
SYMMETRIC | &quot;SYMMETRIC&quot;
ROOT | &quot;ROOT&quot;
LEAF | &quot;LEAF&quot;
TRUNK | &quot;TRUNK&quot;
UNKNOWN | &quot;UNKNOWN&quot;



