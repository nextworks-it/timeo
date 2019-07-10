
# LaserPropertiesPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**laserStatus** | [**LaserStatusEnum**](#LaserStatusEnum) |  |  [optional]
**laserTemperature** | **Double** | The temperature of the laser |  [optional]
**laserApplicationType** | [**LaserApplicationTypeEnum**](#LaserApplicationTypeEnum) | The type of laser, its operational wavelengths, and its applications. String size 255. |  [optional]
**laserBiasCurrent** | **Double** | The Bias current of the laser that is the medium polarization current of the laser. |  [optional]


<a name="LaserStatusEnum"></a>
## Enum: LaserStatusEnum
Name | Value
---- | -----
ON | &quot;ON&quot;
OFF | &quot;OFF&quot;
PULSING | &quot;PULSING&quot;
UNDEFINED | &quot;UNDEFINED&quot;


<a name="LaserApplicationTypeEnum"></a>
## Enum: LaserApplicationTypeEnum
Name | Value
---- | -----
PUMP | &quot;PUMP&quot;
MODULATED | &quot;MODULATED&quot;
PULSE | &quot;PULSE&quot;



