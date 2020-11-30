
# ConnectionEndPoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**layerProtocolQualifier** | **String** |  |  [optional]
**clientNodeEdgePoint** | [**List&lt;NodeEdgePointRef&gt;**](NodeEdgePointRef.md) |  |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**aggregatedConnectionEndPoint** | [**List&lt;ConnectionEndPointRef&gt;**](ConnectionEndPointRef.md) |  |  [optional]
**connectionPortDirection** | [**ConnectionPortDirectionEnum**](#ConnectionPortDirectionEnum) | The orientation of defined flow at the EndPoint. |  [optional]
**parentNodeEdgePoint** | [**NodeEdgePointRef**](NodeEdgePointRef.md) |  |  [optional]
**connectionPortRole** | [**ConnectionPortRoleEnum**](#ConnectionPortRoleEnum) | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


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



