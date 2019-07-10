
# OtsiTerminationConfigPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**modulation** | [**ModulationEnum**](#ModulationEnum) | The modulation techniqu selected at the source. |  [optional]
**spectrum** | [**SpectrumBand**](SpectrumBand.md) |  |  [optional]
**applicationIdentifier** | [**ApplicationIdentifier**](ApplicationIdentifier.md) | This attribute indicates the selected Application Identifier. |  [optional]
**totalPowerWarnThresholdUpper** | **Double** | Allows to configure the Upper power threshold which is expected to be different from Default, but within the Min and Max values specified as OTSi SIP capability. |  [optional]
**transmitPower** | [**PowerPropertiesPac**](PowerPropertiesPac.md) | Transmit power as requested. |  [optional]
**laserControl** | [**LaserControlEnum**](#LaserControlEnum) | Laser control can be FORCED-ON, FORCED-OFF or LASER-SHUTDOWN |  [optional]
**totalPowerWarnThresholdLower** | **Double** | Allows to configure the Lowerpower threshold which is expected to be different from Default, but within the Min and Max values specified as OTSi SIP capability. |  [optional]
**centralFrequency** | [**CentralFrequency**](CentralFrequency.md) | The central frequency of the laser. It is the oscillation frequency of the corresponding electromagnetic wave |  [optional]


<a name="ModulationEnum"></a>
## Enum: ModulationEnum
Name | Value
---- | -----
RZ | &quot;RZ&quot;
NRZ | &quot;NRZ&quot;
BPSK | &quot;BPSK&quot;
DPSK | &quot;DPSK&quot;
QPSK | &quot;QPSK&quot;
_8QAM | &quot;8QAM&quot;
_16QAM | &quot;16QAM&quot;
PAM4 | &quot;PAM4&quot;
PAM8 | &quot;PAM8&quot;
UNDEFINED | &quot;UNDEFINED&quot;


<a name="LaserControlEnum"></a>
## Enum: LaserControlEnum
Name | Value
---- | -----
FORCED_ON | &quot;FORCED-ON&quot;
FORCED_OFF | &quot;FORCED-OFF&quot;
AUTOMATIC_LASER_SHUTDOWN | &quot;AUTOMATIC-LASER-SHUTDOWN&quot;
UNDEFINED | &quot;UNDEFINED&quot;



