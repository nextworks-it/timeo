# Exporter

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**exporterId** | **String** | the ID of the exporter. It is also the name assigned to the corresponding scrape job  |  [optional]
**name** | **String** | Human-readable description of the exporter, e.g. \&quot;NSI-XXX_web-server_VM-XXX\&quot;  |  [optional]
**endpoint** | [**List&lt;Endpoint&gt;**](Endpoint.md) | The list of endpoints of the instances of this job |  [optional]
**collectionPeriod** | **Integer** | the interval (in seconds) between scrapes |  [optional]
**nsId** | **String** | The Network Service ID. It will be used as a label in the exporter |  [optional]
**vnfdId** | **String** | The VNFD ID. It will be used as a label in the exporter |  [optional]
