
# Connection

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**lowerConnection** | [**List&lt;ConnectionRef&gt;**](ConnectionRef.md) | An Connection object supports a recursive aggregation relationship such that the internal construction of an Connection can be exposed as multiple lower level Connection objects (partitioning). Aggregation is used as for the Node/Topology  to allow changes in hierarchy. Connection aggregation reflects Node/Topology aggregation. The FC represents a Cross-Connection in an NE. The Cross-Connection in an NE is not necessarily the lowest level of FC partitioning. |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) |  |  [optional]
**route** | [**List&lt;Route&gt;**](Route.md) |  |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**switchControl** | [**List&lt;SwitchControl&gt;**](SwitchControl.md) |  |  [optional]
**supportedClientLink** | [**List&lt;LinkRef&gt;**](LinkRef.md) |  |  [optional]
**connectionEndPoint** | [**List&lt;ConnectionEndPointRef&gt;**](ConnectionEndPointRef.md) |  |  [optional]


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
UNIDIRECTIONAL | &quot;UNIDIRECTIONAL&quot;
UNDEFINED_OR_UNKNOWN | &quot;UNDEFINED_OR_UNKNOWN&quot;


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;



