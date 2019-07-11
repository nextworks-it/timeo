
# OtsiTerminationPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**laserProperties** | [**LaserPropertiesPac**](LaserPropertiesPac.md) | Laser properties. |  [optional]
**selectedSpectrum** | [**SpectrumBand**](SpectrumBand.md) |  |  [optional]
**selectedApplicationIdentifier** | [**ApplicationIdentifier**](ApplicationIdentifier.md) | This attribute indicates the selected Application Identifier that is used by the OCh trail termination function. The syntax of ApplicationIdentifier is a pair {ApplicationIdentifierType, PrintableString}. The value of ApplicationIdentifierType is either STANDARD or PROPRIETARY. The value of PrintableString represents the standard application code as defined in the ITU-T Recommendations or a vendor-specific proprietary code. If the ApplicationIdentifierType is STANDARD the value of PrintableString represents a standard application code as defined in the ITU-T Recommendations. If the ApplicationIdentifierType is PROPRIETARY, the first six characters of the PrintableString must contain the Hexadecimal representation of an OUI assigned to the vendor whose implementation generated the Application Identifier; the remaining octets of the PrintableString are unspecified. The value of this attribute of an object instance has to be one of the values identified in the attribute SupportableApplicationIdentifierList of the same object instance. The values and value ranges of the optical interface parameters of a standard application code must be consistent with those values specified in the ITU-T Recommendation for that application code. |  [optional]
**receivedPower** | [**PowerPropertiesPac**](PowerPropertiesPac.md) |  |  [optional]
**selectedCentralFrequency** | [**CentralFrequency**](CentralFrequency.md) |  |  [optional]
**selectedModulation** | [**SelectedModulationEnum**](#SelectedModulationEnum) | This parameter defines the modulation used at the source |  [optional]
**transmitedPower** | [**PowerPropertiesPac**](PowerPropertiesPac.md) | Measured power at the Transmitter. |  [optional]


<a name="SelectedModulationEnum"></a>
## Enum: SelectedModulationEnum
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



