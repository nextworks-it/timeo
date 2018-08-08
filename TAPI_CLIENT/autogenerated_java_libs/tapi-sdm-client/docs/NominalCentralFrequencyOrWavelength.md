
# NominalCentralFrequencyOrWavelength

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**adjustmentGranularity** | [**AdjustmentGranularityEnum**](#AdjustmentGranularityEnum) | Adjustment granularity in Gigahertz. As per ITU-T G.694.1, it is used to calculate nominal central frequency (in THz) |  [optional]
**channelNumber** | **String** | As per ITU-T G.694.1, this attribute is denoted as &#39;n&#39; and is used to calculate the nominal central frequency (in THz) as follows: 193.1 + &lt;channelNumber&gt; × &lt;adjustmentGranularity&gt; where channelNumber is a positive or negative integer including 0 and adjustment_granularity is the nominal central frequency granularity in THz |  [optional]
**gridType** | [**GridTypeEnum**](#GridTypeEnum) | Specifies the frequency grid standard used to determine the nominal central frequency and frequency slot width |  [optional]


<a name="AdjustmentGranularityEnum"></a>
## Enum: AdjustmentGranularityEnum
Name | Value
---- | -----
_100GHZ | &quot;G_100GHZ&quot;
_50GHZ | &quot;G_50GHZ&quot;
_25GHZ | &quot;G_25GHZ&quot;
_12_5GHZ | &quot;G_12_5GHZ&quot;
_6_25GHZ | &quot;G_6_25GHZ&quot;


<a name="GridTypeEnum"></a>
## Enum: GridTypeEnum
Name | Value
---- | -----
DWDM | &quot;DWDM&quot;
CWDM | &quot;CWDM&quot;
FLEX | &quot;FLEX&quot;
UNSPECIFIED | &quot;UNSPECIFIED&quot;



