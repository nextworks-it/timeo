
# ModelSwitch

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**selectedConnectionEndPoint** | [**List&lt;ConnectionEndPointRef&gt;**](ConnectionEndPointRef.md) |  |  [optional]
**selectionReason** | [**SelectionReasonEnum**](#SelectionReasonEnum) | The reason for the current switch selection. |  [optional]
**switchDirection** | [**SwitchDirectionEnum**](#SwitchDirectionEnum) | Indicates whether the switch selects from ingress to the FC or to egress of the FC, or both. |  [optional]
**selectedRoute** | [**List&lt;RouteRef&gt;**](RouteRef.md) |  |  [optional]
**selectionControl** | [**SelectionControlEnum**](#SelectionControlEnum) | Degree of administrative control applied to the switch selection. |  [optional]


<a name="SelectionReasonEnum"></a>
## Enum: SelectionReasonEnum
Name | Value
---- | -----
LOCKOUT | &quot;LOCKOUT&quot;
NORMAL | &quot;NORMAL&quot;
MANUAL | &quot;MANUAL&quot;
FORCED | &quot;FORCED&quot;
WAIT_TO_REVERT | &quot;WAIT_TO_REVERT&quot;
SIGNAL_DEGRADE | &quot;SIGNAL_DEGRADE&quot;
SIGNAL_FAIL | &quot;SIGNAL_FAIL&quot;


<a name="SwitchDirectionEnum"></a>
## Enum: SwitchDirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="SelectionControlEnum"></a>
## Enum: SelectionControlEnum
Name | Value
---- | -----
LOCK_OUT | &quot;LOCK_OUT&quot;
NORMAL | &quot;NORMAL&quot;
MANUAL | &quot;MANUAL&quot;
FORCED | &quot;FORCED&quot;



