
# TransferIntegrityPac

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**errorCharacteristic** | **String** | Describes the degree to which the signal propagated can be errored. Applies to TDM systems as the errored signal will be propagated and not packet as errored packets will be discarded. |  [optional]
**unavailableTimeCharacteristic** | **String** | Describes the duration for which there may be no valid signal propagated. |  [optional]
**lossCharacteristic** | **String** | Describes the acceptable characteristic of lost packets where loss may result from discard due to errors or overflow. Applies to packet systems and not TDM (as for TDM errored signals are propagated unless grossly errored and overflow/underflow turns into timing slips). |  [optional]
**deliveryOrderCharacteristic** | **String** | Describes the degree to which packets will be delivered out of sequence. Does not apply to TDM as the TDM protocols maintain strict order. |  [optional]
**serverIntegrityProcessCharacteristic** | **String** | Describes the effect of any server integrity enhancement process on the characteristics of the TopologicalEntity. |  [optional]
**repeatDeliveryCharacteristic** | **String** | Primarily applies to packet systems where a packet may be delivered more than once (in fault recovery for example). It can also apply to TDM where several frames may be received twice due to switching in a system with a large differential propagation delay. |  [optional]



