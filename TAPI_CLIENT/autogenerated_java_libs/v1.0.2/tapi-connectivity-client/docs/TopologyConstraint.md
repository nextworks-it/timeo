
# TopologyConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**excludeNode** | [**List&lt;NodeRef&gt;**](NodeRef.md) |  |  [optional]
**includeNode** | [**List&lt;NodeRef&gt;**](NodeRef.md) | This is a loose constraint - that is it is unordered and could be a partial list |  [optional]
**includePath** | [**List&lt;PathRef&gt;**](PathRef.md) |  |  [optional]
**includeLink** | [**List&lt;LinkRef&gt;**](LinkRef.md) | This is a loose constraint - that is it is unordered and could be a partial list  |  [optional]
**excludePath** | [**List&lt;PathRef&gt;**](PathRef.md) |  |  [optional]
**excludeLink** | [**List&lt;LinkRef&gt;**](LinkRef.md) |  |  [optional]
**preferredTransportLayer** | [**List&lt;PreferredTransportLayerEnum&gt;**](#List&lt;PreferredTransportLayerEnum&gt;) |  |  [optional]
**avoidTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]
**includeTopology** | [**List&lt;TopologyRef&gt;**](TopologyRef.md) |  |  [optional]


<a name="List<PreferredTransportLayerEnum>"></a>
## Enum: List&lt;PreferredTransportLayerEnum&gt;
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;



