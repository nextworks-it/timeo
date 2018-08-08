
# ContextSchema

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uuid** | **String** | UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6 |  [optional]
**name** | [**List&lt;NameAndValue&gt;**](NameAndValue.md) | List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity. |  [optional]
**serviceInterfacePoint** | [**List&lt;ServiceInterfacePoint&gt;**](ServiceInterfacePoint.md) |  |  [optional]
**pathCompService** | [**List&lt;PathComputationService&gt;**](PathComputationService.md) |  |  [optional]
**connection** | [**List&lt;Connection&gt;**](Connection.md) |  |  [optional]
**connectivityService** | [**List&lt;ConnectivityService&gt;**](ConnectivityService.md) |  |  [optional]
**nwTopologyService** | [**NetworkTopologyService**](NetworkTopologyService.md) |  |  [optional]
**path** | [**List&lt;Path&gt;**](Path.md) |  |  [optional]
**topology** | [**List&lt;Topology&gt;**](Topology.md) |  |  [optional]



