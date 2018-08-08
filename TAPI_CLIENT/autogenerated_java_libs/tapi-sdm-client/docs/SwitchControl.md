
# SwitchControl

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**maxSwitchTimes** | **String** | Used to limit the maximum swtich times. When work fault disappears , and traffic return to the original work path, switch counter reset. |  [optional]
**waitToRevertTime** | **String** | If the protection system is revertive, this attribute specifies the time, in minutes, to wait after a fault clears on a higher priority (preferred) resource before reverting to the preferred resource. |  [optional]
**layerProtocol** | [**LayerProtocolEnum**](#LayerProtocolEnum) | Indicate which layer this resilience parameters package configured for. |  [optional]
**restorePriority** | **String** |  |  [optional]
**isLockOut** | **Boolean** | The resource is configured to temporarily not be available for use in the protection scheme(s) it is part of. This overrides all other protection control states including forced. If the item is locked out then it cannot be used under any circumstances. Note: Only relevant when part of a protection scheme. |  [optional]
**isCoordinatedSwitchingBothEnds** | **Boolean** | Is operating such that switching at both ends of each flow acorss the FC is coordinated at both ingress and egress ends. |  [optional]
**isFrozen** | **Boolean** | Temporarily prevents any switch action to be taken and, as such, freezes the current state.  Until the freeze is cleared, additional near-end external commands are rejected and fault condition changes and received APS messages are ignored. All administrative controls of any aspect of protection are rejected. |  [optional]
**reversionMode** | [**ReversionModeEnum**](#ReversionModeEnum) | Indcates whether the protection scheme is revertive or non-revertive. |  [optional]
**holdOffTime** | **String** | This attribute indicates the time, in milliseconds, between declaration of signal degrade or signal fail, and the initialization of the protection switching algorithm. |  [optional]
**resilienceType** | [**ResilienceType**](ResilienceType.md) |  |  [optional]
**restorationCoordinateType** | [**RestorationCoordinateTypeEnum**](#RestorationCoordinateTypeEnum) |  The coordination mechanism between multi-layers. |  [optional]
**subSwitchControl** | [**List&lt;SwitchControlRef&gt;**](SwitchControlRef.md) |  |  [optional]
**_switch** | [**List&lt;ModelSwitch&gt;**](ModelSwitch.md) |  |  [optional]


<a name="LayerProtocolEnum"></a>
## Enum: LayerProtocolEnum
Name | Value
---- | -----
OTSIA | &quot;OTSiA&quot;
OCH | &quot;OCH&quot;
OTU | &quot;OTU&quot;
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
ETY | &quot;ETY&quot;
SDM | &quot;SDM&quot;
DSR | &quot;DSR&quot;


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



