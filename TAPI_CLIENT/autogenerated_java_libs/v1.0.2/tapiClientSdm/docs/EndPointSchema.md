
# EndPointSchema

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**administrativeState** | [**AdministrativeStateEnum**](#AdministrativeStateEnum) |  |  [optional]
**lifecycleState** | [**LifecycleStateEnum**](#LifecycleStateEnum) |  |  [optional]
**operationalState** | [**OperationalStateEnum**](#OperationalStateEnum) |  |  [optional]
**direction** | [**DirectionEnum**](#DirectionEnum) | The orientation of defined flow at the EndPoint. |  [optional]
**layerProtocolQualifier** | **String** |  |  [optional]
**capacity** | [**Capacity**](Capacity.md) |  |  [optional]
**protectionRole** | [**ProtectionRoleEnum**](#ProtectionRoleEnum) | To specify the protection role of this Port when create or update ConnectivityService. |  [optional]
**layerProtocolName** | [**LayerProtocolNameEnum**](#LayerProtocolNameEnum) |  |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]
**serviceInterfacePoint** | [**ServiceInterfacePointRef**](ServiceInterfacePointRef.md) |  |  [optional]
**connectionEndPoint** | [**List&lt;ConnectionEndPointRef&gt;**](ConnectionEndPointRef.md) |  |  [optional]
**mediaChannelServiceInterfacePointSpec** | [**MediaChannelServiceInterfacePointSpec**](MediaChannelServiceInterfacePointSpec.md) |  |  [optional]
**sdmServiceInterfacePointSpec** | [**SdmServiceInterfacePointSpec**](SdmServiceInterfacePointSpec.md) |  |  [optional]
**otsiConnectivityServiceEndPointSpec** | [**OtsiConnectivityServiceEndPointSpec**](OtsiConnectivityServiceEndPointSpec.md) |  |  [optional]


<a name="AdministrativeStateEnum"></a>
## Enum: AdministrativeStateEnum
Name | Value
---- | -----
LOCKED | &quot;LOCKED&quot;
UNLOCKED | &quot;UNLOCKED&quot;


<a name="LifecycleStateEnum"></a>
## Enum: LifecycleStateEnum
Name | Value
---- | -----
PLANNED | &quot;PLANNED&quot;
POTENTIAL_AVAILABLE | &quot;POTENTIAL_AVAILABLE&quot;
POTENTIAL_BUSY | &quot;POTENTIAL_BUSY&quot;
INSTALLED | &quot;INSTALLED&quot;
PENDING_REMOVAL | &quot;PENDING_REMOVAL&quot;


<a name="OperationalStateEnum"></a>
## Enum: OperationalStateEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
ENABLED | &quot;ENABLED&quot;


<a name="DirectionEnum"></a>
## Enum: DirectionEnum
Name | Value
---- | -----
BIDIRECTIONAL | &quot;BIDIRECTIONAL&quot;
INPUT | &quot;INPUT&quot;
OUTPUT | &quot;OUTPUT&quot;
UNIDENTIFIED_OR_UNKNOWN | &quot;UNIDENTIFIED_OR_UNKNOWN&quot;


<a name="ProtectionRoleEnum"></a>
## Enum: ProtectionRoleEnum
Name | Value
---- | -----
WORK | &quot;WORK&quot;
PROTECT | &quot;PROTECT&quot;
PROTECTED | &quot;PROTECTED&quot;
NA | &quot;NA&quot;
WORK_RESTORE | &quot;WORK_RESTORE&quot;
PROTECT_RESTORE | &quot;PROTECT_RESTORE&quot;


<a name="LayerProtocolNameEnum"></a>
## Enum: LayerProtocolNameEnum
Name | Value
---- | -----
ODU | &quot;ODU&quot;
ETH | &quot;ETH&quot;
DSR | &quot;DSR&quot;
PHOTONIC_MEDIA | &quot;PHOTONIC_MEDIA&quot;


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
SYMMETRIC | &quot;SYMMETRIC&quot;
ROOT | &quot;ROOT&quot;
LEAF | &quot;LEAF&quot;
TRUNK | &quot;TRUNK&quot;
UNKNOWN | &quot;UNKNOWN&quot;



