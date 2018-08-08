
# PathObjectiveFunction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**concurrentPaths** | [**ConcurrentPathsEnum**](#ConcurrentPathsEnum) |  |  [optional]
**linkUtilization** | [**LinkUtilizationEnum**](#LinkUtilizationEnum) |  |  [optional]
**bandwidthOptimization** | [**BandwidthOptimizationEnum**](#BandwidthOptimizationEnum) |  |  [optional]
**costOptimization** | [**CostOptimizationEnum**](#CostOptimizationEnum) |  |  [optional]
**resourceSharing** | [**ResourceSharingEnum**](#ResourceSharingEnum) |  |  [optional]


<a name="ConcurrentPathsEnum"></a>
## Enum: ConcurrentPathsEnum
Name | Value
---- | -----
MINIMIZE | &quot;MINIMIZE&quot;
MAXIMIZE | &quot;MAXIMIZE&quot;
ALLOW | &quot;ALLOW&quot;
DISALLOW | &quot;DISALLOW&quot;
DONT_CARE | &quot;DONT_CARE&quot;


<a name="LinkUtilizationEnum"></a>
## Enum: LinkUtilizationEnum
Name | Value
---- | -----
MINIMIZE | &quot;MINIMIZE&quot;
MAXIMIZE | &quot;MAXIMIZE&quot;
ALLOW | &quot;ALLOW&quot;
DISALLOW | &quot;DISALLOW&quot;
DONT_CARE | &quot;DONT_CARE&quot;


<a name="BandwidthOptimizationEnum"></a>
## Enum: BandwidthOptimizationEnum
Name | Value
---- | -----
MINIMIZE | &quot;MINIMIZE&quot;
MAXIMIZE | &quot;MAXIMIZE&quot;
ALLOW | &quot;ALLOW&quot;
DISALLOW | &quot;DISALLOW&quot;
DONT_CARE | &quot;DONT_CARE&quot;


<a name="CostOptimizationEnum"></a>
## Enum: CostOptimizationEnum
Name | Value
---- | -----
MINIMIZE | &quot;MINIMIZE&quot;
MAXIMIZE | &quot;MAXIMIZE&quot;
ALLOW | &quot;ALLOW&quot;
DISALLOW | &quot;DISALLOW&quot;
DONT_CARE | &quot;DONT_CARE&quot;


<a name="ResourceSharingEnum"></a>
## Enum: ResourceSharingEnum
Name | Value
---- | -----
MINIMIZE | &quot;MINIMIZE&quot;
MAXIMIZE | &quot;MAXIMIZE&quot;
ALLOW | &quot;ALLOW&quot;
DISALLOW | &quot;DISALLOW&quot;
DONT_CARE | &quot;DONT_CARE&quot;



