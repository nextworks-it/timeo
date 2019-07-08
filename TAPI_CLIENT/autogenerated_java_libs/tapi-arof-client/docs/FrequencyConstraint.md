
# FrequencyConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**adjustmentGranularity** | [**AdjustmentGranularityEnum**](#AdjustmentGranularityEnum) | Adjustment granularity in Gigahertz. As per ITU-T G.694.1, it is used to calculate nominal central frequency (in THz) |  [optional]
**gridType** | [**GridTypeEnum**](#GridTypeEnum) | Specifies the frequency grid standard used to determine the nominal central frequency and frequency slot width |  [optional]


<a name="AdjustmentGranularityEnum"></a>
## Enum: AdjustmentGranularityEnum
Name | Value
---- | -----
G_100GHZ | &quot;G_100GHZ&quot;
G_50GHZ | &quot;G_50GHZ&quot;
G_25GHZ | &quot;G_25GHZ&quot;
G_12_5GHZ | &quot;G_12_5GHZ&quot;
G_6_25GHZ | &quot;G_6_25GHZ&quot;
G_3_125GHZ | &quot;G_3_125GHZ&quot;
UNCONSTRAINED | &quot;UNCONSTRAINED&quot;


<a name="GridTypeEnum"></a>
## Enum: GridTypeEnum
Name | Value
---- | -----
DWDM | &quot;DWDM&quot;
CWDM | &quot;CWDM&quot;
FLEX | &quot;FLEX&quot;
GRIDLESS | &quot;GRIDLESS&quot;
UNSPECIFIED | &quot;UNSPECIFIED&quot;



