
# ResilienceConstraint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**maxSwitchTimes** | **String** | Used to limit the maximum swtich times. When work fault disappears , and traffic return to the original work path, switch counter reset. |  [optional]
**waitToRevertTime** | **String** | If the protection system is revertive, this attribute specifies the time, in minutes, to wait after a fault clears on a higher priority (preferred) resource before reverting to the preferred resource. |  [optional]
**restorePriority** | **String** |  |  [optional]
**isLockOut** | **Boolean** | The resource is configured to temporarily not be available for use in the protection scheme(s) it is part of. This overrides all other protection control states including forced. If the item is locked out then it cannot be used under any circumstances. Note: Only relevant when part of a protection scheme. |  [optional]
**isCoordinatedSwitchingBothEnds** | **Boolean** | Is operating such that switching at both ends of each flow acorss the FC is coordinated at both ingress and egress ends. |  [optional]
**isFrozen** | **Boolean** | Temporarily prevents any switch action to be taken and, as such, freezes the current state. Until the freeze is cleared, additional near-end external commands are rejected and fault condition changes and received APS messages are ignored. All administrative controls of any aspect of protection are rejected. |  [optional]
**preferredRestorationLayer** | [**List&lt;PreferredRestorationLayerEnum&gt;**](#List&lt;PreferredRestorationLayerEnum&gt;) |  |  [optional]
**reversionMode** | [**ReversionModeEnum**](#ReversionModeEnum) | Indcates whether the protection scheme is revertive or non-revertive. |  [optional]
**holdOffTime** | **String** | This attribute indicates the time, in milliseconds, between declaration of signal degrade or signal fail, and the initialization of the protection switching algorithm. |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]
**restorationCoordinateType** | [**RestorationCoordinateTypeEnum**](#RestorationCoordinateTypeEnum) |  The coordination mechanism between multi-layers. |  [optional]


<a name="List<PreferredRestorationLayerEnum>"></a>
## Enum: List&lt;PreferredRestorationLayerEnum&gt;
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


<a name="ReversionModeEnum"></a>
## Enum: ReversionModeEnum
Name | Value
---- | -----
REVERTIVE | &quot;REVERTIVE&quot;
NON_REVERTIVE | &quot;NON-REVERTIVE&quot;


<a name="RestorationCoordinateTypeEnum"></a>
## Enum: RestorationCoordinateTypeEnum
Name | Value
---- | -----
NO_COORDINATE | &quot;NO_COORDINATE&quot;
HOLD_OFF_TIME | &quot;HOLD_OFF_TIME&quot;
WAIT_FOR_NOTIFICATION | &quot;WAIT_FOR_NOTIFICATION&quot;



