
# PathServiceEndPoint

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**localId** | **String** |  |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**direction** | **String** | The orientation of defined flow at the EndPoint. |  [optional]
**layerProtocolQualifier** | **String** |  |  [optional]
**capacity** | [**Capacity**](Capacity.md) |  |  [optional]
**layerProtocolName** | **String** |  |  [optional]
**role** | **String** | Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function.  |  [optional]
**serviceInterfacePoint** | [**ServiceInterfacePointRef**](ServiceInterfacePointRef.md) |  |  [optional]



