
# OtsiTerminationConfigPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**modulation** | **String** | The modulation techniqu selected at the source. |  [optional]
**spectrum** | [**SpectrumBand**](SpectrumBand.md) |  |  [optional]
**applicationIdentifier** | [**ApplicationIdentifier**](ApplicationIdentifier.md) | This attribute indicates the selected Application Identifier. |  [optional]
**totalPowerWarnThresholdUpper** | **Double** | Allows to configure the Upper power threshold which is expected to be different from Default, but within the Min and Max values specified as OTSi SIP capability. |  [optional]
**transmitPower** | [**PowerPropertiesPac**](PowerPropertiesPac.md) | Transmit power as requested. |  [optional]
**laserControl** | **String** | Laser control can be FORCED-ON, FORCED-OFF or LASER-SHUTDOWN |  [optional]
**totalPowerWarnThresholdLower** | **Double** | Allows to configure the Lowerpower threshold which is expected to be different from Default, but within the Min and Max values specified as OTSi SIP capability. |  [optional]
**centralFrequency** | [**CentralFrequency**](CentralFrequency.md) | The central frequency of the laser. It is the oscillation frequency of the corresponding electromagnetic wave |  [optional]



