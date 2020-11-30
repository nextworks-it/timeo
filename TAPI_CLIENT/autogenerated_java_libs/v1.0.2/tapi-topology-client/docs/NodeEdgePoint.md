
# NodeEdgePoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**mappedServiceInterfacePoint** | [**List&lt;ServiceInterfacePointRef&gt;**](ServiceInterfacePointRef.md) | NodeEdgePoint mapped to more than ServiceInterfacePoint (slicing/virtualizing) or a ServiceInterfacePoint mapped to more than one NodeEdgePoint (load balancing/Resilience) should be considered experimental |  [optional]
**supportedCepLayerProtocolQualifier** | **List&lt;String&gt;** |  |  [optional]
**linkPortDirection** | [**LinkPortDirectionEnum**](#LinkPortDirectionEnum) | The orientation of defined flow at the LinkEnd. |  [optional]
**aggregatedNodeEdgePoint** | [**List&lt;NodeEdgePointRef&gt;**](NodeEdgePointRef.md) |  |  [optional]
**linkPortRole** | [**LinkPortRoleEnum**](#LinkPortRoleEnum) | Each LinkEnd of the Link has a role (e.g., symmetric, hub, spoke, leaf, root)  in the context of the Link with respect to the Link function.  |  [optional]


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


<a name="LinkPortDirectionEnum"></a>
## Enum: LinkPortDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="LinkPortRoleEnum"></a>
## Enum: LinkPortRoleEnum
Name | Value
---- | -----
SYMMETRIC | &quot;SYMMETRIC&quot;
ROOT | &quot;ROOT&quot;
LEAF | &quot;LEAF&quot;
TRUNK | &quot;TRUNK&quot;
UNKNOWN | &quot;UNKNOWN&quot;



