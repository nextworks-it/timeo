
# Link

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodeEdgePoint** | [**List&lt;NodeEdgePointRef&gt;**](NodeEdgePointRef.md) |  |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) | The directionality of the Link. Is applicable to simple Links where all LinkEnds are BIDIRECTIONAL (the Link will be BIDIRECTIONAL) or UNIDIRECTIONAL (the Link will be UNIDIRECTIONAL). Is not present in more complex cases. |  [optional]
**layerProtocolName** | [**List&lt;LayerProtocolNameEnum&gt;**](#List&lt;LayerProtocolNameEnum&gt;) |  |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]


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
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;



