# DefaultApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextById**](DefaultApi.md#createContextById) | **POST** /config/context/ | Create context by ID
[**createContextNameNameById**](DefaultApi.md#createContextNameNameById) | **POST** /config/context/name/{value_name}/ | Create name by ID
[**createContextServiceInterfacePointNameNameById**](DefaultApi.md#createContextServiceInterfacePointNameNameById) | **POST** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Create name by ID
[**createContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#createContextServiceInterfacePointServiceInterfacePointById) | **POST** /config/context/service-interface-point/{uuid}/ | Create service-interface-point by ID
[**createGetLinkDetailsById**](DefaultApi.md#createGetLinkDetailsById) | **POST** /operations/get-link-details/ | Create get-link-details by ID
[**createGetNodeDetailsById**](DefaultApi.md#createGetNodeDetailsById) | **POST** /operations/get-node-details/ | Create get-node-details by ID
[**createGetNodeEdgePointDetailsById**](DefaultApi.md#createGetNodeEdgePointDetailsById) | **POST** /operations/get-node-edge-point-details/ | Create get-node-edge-point-details by ID
[**createGetServiceInterfacePointDetailsById**](DefaultApi.md#createGetServiceInterfacePointDetailsById) | **POST** /operations/get-service-interface-point-details/ | Create get-service-interface-point-details by ID
[**createGetServiceInterfacePointListById**](DefaultApi.md#createGetServiceInterfacePointListById) | **POST** /operations/get-service-interface-point-list/ | Create get-service-interface-point-list by ID
[**createGetTopologyDetailsById**](DefaultApi.md#createGetTopologyDetailsById) | **POST** /operations/get-topology-details/ | Create get-topology-details by ID
[**createGetTopologyListById**](DefaultApi.md#createGetTopologyListById) | **POST** /operations/get-topology-list/ | Create get-topology-list by ID
[**createUpdateServiceInterfacePointById**](DefaultApi.md#createUpdateServiceInterfacePointById) | **POST** /operations/update-service-interface-point/ | Create update-service-interface-point by ID
[**deleteContextById**](DefaultApi.md#deleteContextById) | **DELETE** /config/context/ | Delete context by ID
[**deleteContextNameNameById**](DefaultApi.md#deleteContextNameNameById) | **DELETE** /config/context/name/{value_name}/ | Delete name by ID
[**deleteContextServiceInterfacePointNameNameById**](DefaultApi.md#deleteContextServiceInterfacePointNameNameById) | **DELETE** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Delete name by ID
[**deleteContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#deleteContextServiceInterfacePointServiceInterfacePointById) | **DELETE** /config/context/service-interface-point/{uuid}/ | Delete service-interface-point by ID
[**retrieveContext**](DefaultApi.md#retrieveContext) | **GET** /config/context/ | Retrieve context
[**retrieveContextNameName**](DefaultApi.md#retrieveContextNameName) | **GET** /config/context/name/ | Retrieve name
[**retrieveContextNameNameById**](DefaultApi.md#retrieveContextNameNameById) | **GET** /config/context/name/{value_name}/ | Retrieve name by ID
[**retrieveContextNwTopologyServiceNameName**](DefaultApi.md#retrieveContextNwTopologyServiceNameName) | **GET** /config/context/nw-topology-service/name/ | Retrieve name
[**retrieveContextNwTopologyServiceNameNameById**](DefaultApi.md#retrieveContextNwTopologyServiceNameNameById) | **GET** /config/context/nw-topology-service/name/{value_name}/ | Retrieve name by ID
[**retrieveContextNwTopologyServiceNwTopologyService**](DefaultApi.md#retrieveContextNwTopologyServiceNwTopologyService) | **GET** /config/context/nw-topology-service/ | Retrieve nw-topology-service
[**retrieveContextNwTopologyServiceTopologyTopology**](DefaultApi.md#retrieveContextNwTopologyServiceTopologyTopology) | **GET** /config/context/nw-topology-service/topology/ | Retrieve topology
[**retrieveContextNwTopologyServiceTopologyTopologyById**](DefaultApi.md#retrieveContextNwTopologyServiceTopologyTopologyById) | **GET** /config/context/nw-topology-service/topology/{topology_id}/ | Retrieve topology by ID
[**retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextServiceInterfacePointNameName**](DefaultApi.md#retrieveContextServiceInterfacePointNameName) | **GET** /config/context/service-interface-point/{uuid}/name/ | Retrieve name
[**retrieveContextServiceInterfacePointNameNameById**](DefaultApi.md#retrieveContextServiceInterfacePointNameNameById) | **GET** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextServiceInterfacePointServiceInterfacePoint**](DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePoint) | **GET** /config/context/service-interface-point/ | Retrieve service-interface-point
[**retrieveContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#retrieveContextServiceInterfacePointServiceInterfacePointById) | **GET** /config/context/service-interface-point/{uuid}/ | Retrieve service-interface-point by ID
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/service-interface-point/{uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyLinkAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyLinkCostCharacteristicCostCharacteristic**](DefaultApi.md#retrieveContextTopologyLinkCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById**](DefaultApi.md#retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic**](DefaultApi.md#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById**](DefaultApi.md#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyLinkLink**](DefaultApi.md#retrieveContextTopologyLinkLink) | **GET** /config/context/topology/{uuid}/link/ | Retrieve link
[**retrieveContextTopologyLinkLinkById**](DefaultApi.md#retrieveContextTopologyLinkLinkById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/ | Retrieve link by ID
[**retrieveContextTopologyLinkNameName**](DefaultApi.md#retrieveContextTopologyLinkNameName) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/name/ | Retrieve name
[**retrieveContextTopologyLinkNameNameById**](DefaultApi.md#retrieveContextTopologyLinkNameNameById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint**](DefaultApi.md#retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/node-edge-point/ | Retrieve node-edge-point
[**retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById**](DefaultApi.md#retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve node-edge-point by ID
[**retrieveContextTopologyLinkResilienceTypeResilienceType**](DefaultApi.md#retrieveContextTopologyLinkResilienceTypeResilienceType) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/resilience-type/ | Retrieve resilience-type
[**retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic**](DefaultApi.md#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById**](DefaultApi.md#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyLinkValidationMechanismValidationMechanism**](DefaultApi.md#retrieveContextTopologyLinkValidationMechanismValidationMechanism) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/validation-mechanism/ | Retrieve validation-mechanism
[**retrieveContextTopologyLinkValidationMechanismValidationMechanismById**](DefaultApi.md#retrieveContextTopologyLinkValidationMechanismValidationMechanismById) | **GET** /config/context/topology/{uuid}/link/{link_uuid}/validation-mechanism/{validation_mechanism}/ | Retrieve validation-mechanism by ID
[**retrieveContextTopologyNameName**](DefaultApi.md#retrieveContextTopologyNameName) | **GET** /config/context/topology/{uuid}/name/ | Retrieve name
[**retrieveContextTopologyNameNameById**](DefaultApi.md#retrieveContextTopologyNameNameById) | **GET** /config/context/topology/{uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint**](DefaultApi.md#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
[**retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById**](DefaultApi.md#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve aggregated-node-edge-point by ID
[**retrieveContextTopologyNodeAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeCostCharacteristicCostCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyNodeEncapTopologyEncapTopology**](DefaultApi.md#retrieveContextTopologyNodeEncapTopologyEncapTopology) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/encap-topology/ | Retrieve encap-topology
[**retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyNodeNameName**](DefaultApi.md#retrieveContextTopologyNodeNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/name/ | Retrieve name
[**retrieveContextTopologyNodeNameNameById**](DefaultApi.md#retrieveContextTopologyNodeNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeNode**](DefaultApi.md#retrieveContextTopologyNodeNode) | **GET** /config/context/topology/{uuid}/node/ | Retrieve node
[**retrieveContextTopologyNodeNodeById**](DefaultApi.md#retrieveContextTopologyNodeNodeById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/ | Retrieve node by ID
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/ | Retrieve composed-rule-group
[**retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/{topology_id node_id node_rule_group_id}/ | Retrieve composed-rule-group by ID
[**retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/ | Retrieve associated-node-rule-group
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/{topology_id node_id node_rule_group_id}/ | Retrieve associated-node-rule-group by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/ | Retrieve inter-rule-group
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/ | Retrieve inter-rule-group by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/ | Retrieve name
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/ | Retrieve rule
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupNameName**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/ | Retrieve name
[**retrieveContextTopologyNodeNodeRuleGroupNameNameById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/ | Retrieve node-edge-point
[**retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve node-edge-point by ID
[**retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/ | Retrieve node-rule-group
[**retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/ | Retrieve node-rule-group by ID
[**retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyNodeNodeRuleGroupRuleNameName**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
[**retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeNodeRuleGroupRuleRule**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleRule) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/ | Retrieve rule
[**retrieveContextTopologyNodeNodeRuleGroupRuleRuleById**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupRuleRuleById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
[**retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/{topology_id node_id owned_node_edge_point_id}/ | Retrieve aggregated-node-edge-point by ID
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/ | Retrieve mapped-service-interface-point
[**retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/{service_interface_point_id}/ | Retrieve mapped-service-interface-point by ID
[**retrieveContextTopologyNodeOwnedNodeEdgePointNameName**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointNameName) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/ | Retrieve name
[**retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/ | Retrieve owned-node-edge-point
[**retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/ | Retrieve owned-node-edge-point by ID
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize**](DefaultApi.md#retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyTopology**](DefaultApi.md#retrieveContextTopologyTopology) | **GET** /config/context/topology/ | Retrieve topology
[**retrieveContextTopologyTopologyById**](DefaultApi.md#retrieveContextTopologyTopologyById) | **GET** /config/context/topology/{uuid}/ | Retrieve topology by ID
[**updateContextById**](DefaultApi.md#updateContextById) | **PUT** /config/context/ | Update context by ID
[**updateContextNameNameById**](DefaultApi.md#updateContextNameNameById) | **PUT** /config/context/name/{value_name}/ | Update name by ID
[**updateContextServiceInterfacePointNameNameById**](DefaultApi.md#updateContextServiceInterfacePointNameNameById) | **PUT** /config/context/service-interface-point/{uuid}/name/{value_name}/ | Update name by ID
[**updateContextServiceInterfacePointServiceInterfacePointById**](DefaultApi.md#updateContextServiceInterfacePointServiceInterfacePointById) | **PUT** /config/context/service-interface-point/{uuid}/ | Update service-interface-point by ID


<a name="createContextById"></a>
# **createContextById**
> createContextById(context)

Create context by ID

Create operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
ContextSchema context = new ContextSchema(); // ContextSchema | contextbody object
try {
    apiInstance.createContextById(context);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **context** | [**ContextSchema**](ContextSchema.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextNameNameById"></a>
# **createContextNameNameById**
> createContextNameNameById(valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextNameNameById(valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextServiceInterfacePointNameNameById"></a>
# **createContextServiceInterfacePointNameNameById**
> createContextServiceInterfacePointNameNameById(uuid, valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextServiceInterfacePointServiceInterfacePointById"></a>
# **createContextServiceInterfacePointServiceInterfacePointById**
> createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint)

Create service-interface-point by ID

Create operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.createContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **serviceInterfacePoint** | [**ServiceInterfacePoint**](ServiceInterfacePoint.md)| service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetLinkDetailsById"></a>
# **createGetLinkDetailsById**
> GetLinkDetailsRPCOutputSchema createGetLinkDetailsById(getLinkDetails)

Create get-link-details by ID

Create operation of resource: get-link-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetLinkDetailsRPCInputSchema getLinkDetails = new GetLinkDetailsRPCInputSchema(); // GetLinkDetailsRPCInputSchema | get-link-detailsbody object
try {
    GetLinkDetailsRPCOutputSchema result = apiInstance.createGetLinkDetailsById(getLinkDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetLinkDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getLinkDetails** | [**GetLinkDetailsRPCInputSchema**](GetLinkDetailsRPCInputSchema.md)| get-link-detailsbody object |

### Return type

[**GetLinkDetailsRPCOutputSchema**](GetLinkDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetNodeDetailsById"></a>
# **createGetNodeDetailsById**
> GetNodeDetailsRPCOutputSchema createGetNodeDetailsById(getNodeDetails)

Create get-node-details by ID

Create operation of resource: get-node-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetNodeDetailsRPCInputSchema getNodeDetails = new GetNodeDetailsRPCInputSchema(); // GetNodeDetailsRPCInputSchema | get-node-detailsbody object
try {
    GetNodeDetailsRPCOutputSchema result = apiInstance.createGetNodeDetailsById(getNodeDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetNodeDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getNodeDetails** | [**GetNodeDetailsRPCInputSchema**](GetNodeDetailsRPCInputSchema.md)| get-node-detailsbody object |

### Return type

[**GetNodeDetailsRPCOutputSchema**](GetNodeDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetNodeEdgePointDetailsById"></a>
# **createGetNodeEdgePointDetailsById**
> GetNodeEdgePointDetailsRPCOutputSchema createGetNodeEdgePointDetailsById(getNodeEdgePointDetails)

Create get-node-edge-point-details by ID

Create operation of resource: get-node-edge-point-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetNodeEdgePointDetailsRPCInputSchema getNodeEdgePointDetails = new GetNodeEdgePointDetailsRPCInputSchema(); // GetNodeEdgePointDetailsRPCInputSchema | get-node-edge-point-detailsbody object
try {
    GetNodeEdgePointDetailsRPCOutputSchema result = apiInstance.createGetNodeEdgePointDetailsById(getNodeEdgePointDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetNodeEdgePointDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getNodeEdgePointDetails** | [**GetNodeEdgePointDetailsRPCInputSchema**](GetNodeEdgePointDetailsRPCInputSchema.md)| get-node-edge-point-detailsbody object |

### Return type

[**GetNodeEdgePointDetailsRPCOutputSchema**](GetNodeEdgePointDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetServiceInterfacePointDetailsById"></a>
# **createGetServiceInterfacePointDetailsById**
> GetServiceInterfacePointDetailsRPCOutputSchema createGetServiceInterfacePointDetailsById(getServiceInterfacePointDetails)

Create get-service-interface-point-details by ID

Create operation of resource: get-service-interface-point-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetServiceInterfacePointDetailsRPCInputSchema getServiceInterfacePointDetails = new GetServiceInterfacePointDetailsRPCInputSchema(); // GetServiceInterfacePointDetailsRPCInputSchema | get-service-interface-point-detailsbody object
try {
    GetServiceInterfacePointDetailsRPCOutputSchema result = apiInstance.createGetServiceInterfacePointDetailsById(getServiceInterfacePointDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetServiceInterfacePointDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getServiceInterfacePointDetails** | [**GetServiceInterfacePointDetailsRPCInputSchema**](GetServiceInterfacePointDetailsRPCInputSchema.md)| get-service-interface-point-detailsbody object |

### Return type

[**GetServiceInterfacePointDetailsRPCOutputSchema**](GetServiceInterfacePointDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetServiceInterfacePointListById"></a>
# **createGetServiceInterfacePointListById**
> GetServiceInterfacePointListRPCOutputSchema createGetServiceInterfacePointListById()

Create get-service-interface-point-list by ID

Create operation of resource: get-service-interface-point-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    GetServiceInterfacePointListRPCOutputSchema result = apiInstance.createGetServiceInterfacePointListById();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetServiceInterfacePointListById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetServiceInterfacePointListRPCOutputSchema**](GetServiceInterfacePointListRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetTopologyDetailsById"></a>
# **createGetTopologyDetailsById**
> GetTopologyDetailsRPCOutputSchema createGetTopologyDetailsById(getTopologyDetails)

Create get-topology-details by ID

Create operation of resource: get-topology-details

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
GetTopologyDetailsRPCInputSchema getTopologyDetails = new GetTopologyDetailsRPCInputSchema(); // GetTopologyDetailsRPCInputSchema | get-topology-detailsbody object
try {
    GetTopologyDetailsRPCOutputSchema result = apiInstance.createGetTopologyDetailsById(getTopologyDetails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetTopologyDetailsById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getTopologyDetails** | [**GetTopologyDetailsRPCInputSchema**](GetTopologyDetailsRPCInputSchema.md)| get-topology-detailsbody object |

### Return type

[**GetTopologyDetailsRPCOutputSchema**](GetTopologyDetailsRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createGetTopologyListById"></a>
# **createGetTopologyListById**
> GetTopologyListRPCOutputSchema createGetTopologyListById()

Create get-topology-list by ID

Create operation of resource: get-topology-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    GetTopologyListRPCOutputSchema result = apiInstance.createGetTopologyListById();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGetTopologyListById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetTopologyListRPCOutputSchema**](GetTopologyListRPCOutputSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUpdateServiceInterfacePointById"></a>
# **createUpdateServiceInterfacePointById**
> createUpdateServiceInterfacePointById(updateServiceInterfacePoint)

Create update-service-interface-point by ID

Create operation of resource: update-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
UpdateServiceInterfacePointRPCInputSchema updateServiceInterfacePoint = new UpdateServiceInterfacePointRPCInputSchema(); // UpdateServiceInterfacePointRPCInputSchema | update-service-interface-pointbody object
try {
    apiInstance.createUpdateServiceInterfacePointById(updateServiceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createUpdateServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updateServiceInterfacePoint** | [**UpdateServiceInterfacePointRPCInputSchema**](UpdateServiceInterfacePointRPCInputSchema.md)| update-service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextById"></a>
# **deleteContextById**
> deleteContextById()

Delete context by ID

Delete operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.deleteContextById();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextById");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextNameNameById"></a>
# **deleteContextNameNameById**
> deleteContextNameNameById(valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextNameNameById(valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextServiceInterfacePointNameNameById"></a>
# **deleteContextServiceInterfacePointNameNameById**
> deleteContextServiceInterfacePointNameNameById(uuid, valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextServiceInterfacePointNameNameById(uuid, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextServiceInterfacePointServiceInterfacePointById"></a>
# **deleteContextServiceInterfacePointServiceInterfacePointById**
> deleteContextServiceInterfacePointServiceInterfacePointById(uuid)

Delete service-interface-point by ID

Delete operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    apiInstance.deleteContextServiceInterfacePointServiceInterfacePointById(uuid);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContext"></a>
# **retrieveContext**
> ContextSchema retrieveContext()

Retrieve context

Retrieve operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    ContextSchema result = apiInstance.retrieveContext();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContext");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ContextSchema**](ContextSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNameName"></a>
# **retrieveContextNameName**
> List&lt;String&gt; retrieveContextNameName()

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextNameName();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNameName");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNameNameById"></a>
# **retrieveContextNameNameById**
> NameAndValue retrieveContextNameNameById(valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextNameNameById(valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNwTopologyServiceNameName"></a>
# **retrieveContextNwTopologyServiceNameName**
> List&lt;String&gt; retrieveContextNwTopologyServiceNameName()

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextNwTopologyServiceNameName();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNwTopologyServiceNameName");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNwTopologyServiceNameNameById"></a>
# **retrieveContextNwTopologyServiceNameNameById**
> NameAndValue retrieveContextNwTopologyServiceNameNameById(valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextNwTopologyServiceNameNameById(valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNwTopologyServiceNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNwTopologyServiceNwTopologyService"></a>
# **retrieveContextNwTopologyServiceNwTopologyService**
> NetworkTopologyService retrieveContextNwTopologyServiceNwTopologyService()

Retrieve nw-topology-service

Retrieve operation of resource: nw-topology-service

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    NetworkTopologyService result = apiInstance.retrieveContextNwTopologyServiceNwTopologyService();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNwTopologyServiceNwTopologyService");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**NetworkTopologyService**](NetworkTopologyService.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNwTopologyServiceTopologyTopology"></a>
# **retrieveContextNwTopologyServiceTopologyTopology**
> List&lt;String&gt; retrieveContextNwTopologyServiceTopologyTopology()

Retrieve topology

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextNwTopologyServiceTopologyTopology();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNwTopologyServiceTopologyTopology");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextNwTopologyServiceTopologyTopologyById"></a>
# **retrieveContextNwTopologyServiceTopologyTopologyById**
> TopologyRef retrieveContextNwTopologyServiceTopologyTopologyById(topologyId)

Retrieve topology by ID

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String topologyId = "topologyId_example"; // String | ID of topology_id
try {
    TopologyRef result = apiInstance.retrieveContextNwTopologyServiceTopologyTopologyById(topologyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextNwTopologyServiceTopologyTopologyById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topologyId** | **String**| ID of topology_id |

### Return type

[**TopologyRef**](TopologyRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity**
> Capacity retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointNameName"></a>
# **retrieveContextServiceInterfacePointNameName**
> List&lt;String&gt; retrieveContextServiceInterfacePointNameName(uuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointNameName(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointNameNameById"></a>
# **retrieveContextServiceInterfacePointNameNameById**
> NameAndValue retrieveContextServiceInterfacePointNameNameById(uuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextServiceInterfacePointNameNameById(uuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointServiceInterfacePoint"></a>
# **retrieveContextServiceInterfacePointServiceInterfacePoint**
> List&lt;String&gt; retrieveContextServiceInterfacePointServiceInterfacePoint()

Retrieve service-interface-point

Retrieve operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePoint();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointServiceInterfacePoint");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointServiceInterfacePointById"></a>
# **retrieveContextServiceInterfacePointServiceInterfacePointById**
> ServiceInterfacePoint retrieveContextServiceInterfacePointServiceInterfacePointById(uuid)

Retrieve service-interface-point by ID

Retrieve operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    ServiceInterfacePoint result = apiInstance.retrieveContextServiceInterfacePointServiceInterfacePointById(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**ServiceInterfacePoint**](ServiceInterfacePoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Capacity result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    CapacityValue result = apiInstance.retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextServiceInterfacePointTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyLinkAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyLinkAvailableCapacityAvailableCapacity(uuid, linkUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyLinkAvailableCapacityAvailableCapacity(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize(uuid, linkUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyLinkCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyLinkCostCharacteristicCostCharacteristic(uuid, linkUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkCostCharacteristicCostCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkCostCharacteristicCostCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById(uuid, linkUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById(uuid, linkUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkCostCharacteristicCostCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **costName** | **String**| ID of cost_name |

### Return type

[**CostCharacteristic**](CostCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic(uuid, linkUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById(uuid, linkUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById(uuid, linkUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **trafficPropertyName** | **String**| ID of traffic_property_name |

### Return type

[**LatencyCharacteristic**](LatencyCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkLink"></a>
# **retrieveContextTopologyLinkLink**
> List&lt;String&gt; retrieveContextTopologyLinkLink(uuid)

Retrieve link

Retrieve operation of resource: link

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkLink(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkLinkById"></a>
# **retrieveContextTopologyLinkLinkById**
> Link retrieveContextTopologyLinkLinkById(uuid, linkUuid)

Retrieve link by ID

Retrieve operation of resource: link

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Link result = apiInstance.retrieveContextTopologyLinkLinkById(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkLinkById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkNameName"></a>
# **retrieveContextTopologyLinkNameName**
> List&lt;String&gt; retrieveContextTopologyLinkNameName(uuid, linkUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkNameName(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkNameNameById"></a>
# **retrieveContextTopologyLinkNameNameById**
> NameAndValue retrieveContextTopologyLinkNameNameById(uuid, linkUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyLinkNameNameById(uuid, linkUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint"></a>
# **retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint(uuid, linkUuid)

Retrieve node-edge-point

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkNodeEdgePointNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById"></a>
# **retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById**
> OwnedNodeEdgePointRef retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById(uuid, linkUuid, topologyIdNodeIdOwnedNodeEdgePointId)

Retrieve node-edge-point by ID

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String topologyIdNodeIdOwnedNodeEdgePointId = "topologyIdNodeIdOwnedNodeEdgePointId_example"; // String | ID of topology_id node_id owned_node_edge_point_id
try {
    OwnedNodeEdgePointRef result = apiInstance.retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById(uuid, linkUuid, topologyIdNodeIdOwnedNodeEdgePointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkNodeEdgePointNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **topologyIdNodeIdOwnedNodeEdgePointId** | **String**| ID of topology_id node_id owned_node_edge_point_id |

### Return type

[**OwnedNodeEdgePointRef**](OwnedNodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkResilienceTypeResilienceType"></a>
# **retrieveContextTopologyLinkResilienceTypeResilienceType**
> ResilienceType retrieveContextTopologyLinkResilienceTypeResilienceType(uuid, linkUuid)

Retrieve resilience-type

Retrieve operation of resource: resilience-type

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    ResilienceType result = apiInstance.retrieveContextTopologyLinkResilienceTypeResilienceType(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkResilienceTypeResilienceType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**ResilienceType**](ResilienceType.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic(uuid, linkUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById(uuid, linkUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById(uuid, linkUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkRiskCharacteristicRiskCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **riskCharacteristicName** | **String**| ID of risk_characteristic_name |

### Return type

[**RiskCharacteristic**](RiskCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity(uuid, linkUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize(uuid, linkUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkValidationMechanismValidationMechanism"></a>
# **retrieveContextTopologyLinkValidationMechanismValidationMechanism**
> List&lt;String&gt; retrieveContextTopologyLinkValidationMechanismValidationMechanism(uuid, linkUuid)

Retrieve validation-mechanism

Retrieve operation of resource: validation-mechanism

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyLinkValidationMechanismValidationMechanism(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkValidationMechanismValidationMechanism");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyLinkValidationMechanismValidationMechanismById"></a>
# **retrieveContextTopologyLinkValidationMechanismValidationMechanismById**
> ValidationMechanism retrieveContextTopologyLinkValidationMechanismValidationMechanismById(uuid, linkUuid, validationMechanism)

Retrieve validation-mechanism by ID

Retrieve operation of resource: validation-mechanism

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String validationMechanism = "validationMechanism_example"; // String | ID of validation_mechanism
try {
    ValidationMechanism result = apiInstance.retrieveContextTopologyLinkValidationMechanismValidationMechanismById(uuid, linkUuid, validationMechanism);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyLinkValidationMechanismValidationMechanismById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **validationMechanism** | **String**| ID of validation_mechanism |

### Return type

[**ValidationMechanism**](ValidationMechanism.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNameName"></a>
# **retrieveContextTopologyNameName**
> List&lt;String&gt; retrieveContextTopologyNameName(uuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNameName(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNameNameById"></a>
# **retrieveContextTopologyNameNameById**
> NameAndValue retrieveContextTopologyNameNameById(uuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNameNameById(uuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint"></a>
# **retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid)

Retrieve aggregated-node-edge-point

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById"></a>
# **retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById**
> OwnedNodeEdgePointRef retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, topologyIdNodeIdOwnedNodeEdgePointId)

Retrieve aggregated-node-edge-point by ID

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String topologyIdNodeIdOwnedNodeEdgePointId = "topologyIdNodeIdOwnedNodeEdgePointId_example"; // String | ID of topology_id node_id owned_node_edge_point_id
try {
    OwnedNodeEdgePointRef result = apiInstance.retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, topologyIdNodeIdOwnedNodeEdgePointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **topologyIdNodeIdOwnedNodeEdgePointId** | **String**| ID of topology_id node_id owned_node_edge_point_id |

### Return type

[**OwnedNodeEdgePointRef**](OwnedNodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyNodeAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyNodeAvailableCapacityAvailableCapacity(uuid, nodeUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeAvailableCapacityAvailableCapacity(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyNodeCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeCostCharacteristicCostCharacteristic(uuid, nodeUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeCostCharacteristicCostCharacteristic(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeCostCharacteristicCostCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById(uuid, nodeUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById(uuid, nodeUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeCostCharacteristicCostCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **costName** | **String**| ID of cost_name |

### Return type

[**CostCharacteristic**](CostCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeEncapTopologyEncapTopology"></a>
# **retrieveContextTopologyNodeEncapTopologyEncapTopology**
> TopologyRef retrieveContextTopologyNodeEncapTopologyEncapTopology(uuid, nodeUuid)

Retrieve encap-topology

Retrieve operation of resource: encap-topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    TopologyRef result = apiInstance.retrieveContextTopologyNodeEncapTopologyEncapTopology(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeEncapTopologyEncapTopology");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**TopologyRef**](TopologyRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **trafficPropertyName** | **String**| ID of traffic_property_name |

### Return type

[**LatencyCharacteristic**](LatencyCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNameName"></a>
# **retrieveContextTopologyNodeNameName**
> List&lt;String&gt; retrieveContextTopologyNodeNameName(uuid, nodeUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNameName(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNameNameById"></a>
# **retrieveContextTopologyNodeNameNameById**
> NameAndValue retrieveContextTopologyNodeNameNameById(uuid, nodeUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeNameNameById(uuid, nodeUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNode"></a>
# **retrieveContextTopologyNodeNode**
> List&lt;String&gt; retrieveContextTopologyNodeNode(uuid)

Retrieve node

Retrieve operation of resource: node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNode(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeById"></a>
# **retrieveContextTopologyNodeNodeById**
> Node retrieveContextTopologyNodeNodeById(uuid, nodeUuid)

Retrieve node by ID

Retrieve operation of resource: node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Node result = apiInstance.retrieveContextTopologyNodeNodeById(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**Node**](Node.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup"></a>
# **retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve composed-rule-group

Retrieve operation of resource: composed-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById**
> NodeRuleGroupRef retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, topologyIdNodeIdNodeRuleGroupId)

Retrieve composed-rule-group by ID

Retrieve operation of resource: composed-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String topologyIdNodeIdNodeRuleGroupId = "topologyIdNodeIdNodeRuleGroupId_example"; // String | ID of topology_id node_id node_rule_group_id
try {
    NodeRuleGroupRef result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, topologyIdNodeIdNodeRuleGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **topologyIdNodeIdNodeRuleGroupId** | **String**| ID of topology_id node_id node_rule_group_id |

### Return type

[**NodeRuleGroupRef**](NodeRuleGroupRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **costName** | **String**| ID of cost_name |

### Return type

[**CostCharacteristic**](CostCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve associated-node-rule-group

Retrieve operation of resource: associated-node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById**
> NodeRuleGroupRef retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, topologyIdNodeIdNodeRuleGroupId)

Retrieve associated-node-rule-group by ID

Retrieve operation of resource: associated-node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String topologyIdNodeIdNodeRuleGroupId = "topologyIdNodeIdNodeRuleGroupId_example"; // String | ID of topology_id node_id node_rule_group_id
try {
    NodeRuleGroupRef result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, topologyIdNodeIdNodeRuleGroupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **topologyIdNodeIdNodeRuleGroupId** | **String**| ID of topology_id node_id node_rule_group_id |

### Return type

[**NodeRuleGroupRef**](NodeRuleGroupRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **costName** | **String**| ID of cost_name |

### Return type

[**CostCharacteristic**](CostCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve inter-rule-group

Retrieve operation of resource: inter-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById**
> InterRuleGroup retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve inter-rule-group by ID

Retrieve operation of resource: inter-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    InterRuleGroup result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**InterRuleGroup**](InterRuleGroup.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **trafficPropertyName** | **String**| ID of traffic_property_name |

### Return type

[**LatencyCharacteristic**](LatencyCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById**
> NameAndValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **riskCharacteristicName** | **String**| ID of risk_characteristic_name |

### Return type

[**RiskCharacteristic**](RiskCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **localId** | **String**| ID of local_id |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById**
> NameAndValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **localId** | **String**| ID of local_id |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve rule

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById**
> Rule retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId)

Retrieve rule by ID

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    Rule result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |
 **localId** | **String**| ID of local_id |

### Return type

[**Rule**](Rule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **interRuleGroupUuid** | **String**| ID of inter_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **trafficPropertyName** | **String**| ID of traffic_property_name |

### Return type

[**LatencyCharacteristic**](LatencyCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNameName"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNameName**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNameNameById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNameNameById**
> NameAndValue retrieveContextTopologyNodeNodeRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve node-edge-point

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById**
> OwnedNodeEdgePointRef retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById(uuid, nodeUuid, nodeRuleGroupUuid, topologyIdNodeIdOwnedNodeEdgePointId)

Retrieve node-edge-point by ID

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String topologyIdNodeIdOwnedNodeEdgePointId = "topologyIdNodeIdOwnedNodeEdgePointId_example"; // String | ID of topology_id node_id owned_node_edge_point_id
try {
    OwnedNodeEdgePointRef result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById(uuid, nodeUuid, nodeRuleGroupUuid, topologyIdNodeIdOwnedNodeEdgePointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **topologyIdNodeIdOwnedNodeEdgePointId** | **String**| ID of topology_id node_id owned_node_edge_point_id |

### Return type

[**OwnedNodeEdgePointRef**](OwnedNodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup(uuid, nodeUuid)

Retrieve node-rule-group

Retrieve operation of resource: node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById**
> NodeRuleGroup retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve node-rule-group by ID

Retrieve operation of resource: node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    NodeRuleGroup result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupNodeRuleGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**NodeRuleGroup**](NodeRuleGroup.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **riskCharacteristicName** | **String**| ID of risk_characteristic_name |

### Return type

[**RiskCharacteristic**](RiskCharacteristic.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRuleNameName"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRuleNameName**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, localId)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRuleNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **localId** | **String**| ID of local_id |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById**
> NameAndValue retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, localId, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, localId, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRuleNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **localId** | **String**| ID of local_id |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRuleRule"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRuleRule**
> List&lt;String&gt; retrieveContextTopologyNodeNodeRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve rule

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRuleRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupRuleRuleById"></a>
# **retrieveContextTopologyNodeNodeRuleGroupRuleRuleById**
> Rule retrieveContextTopologyNodeNodeRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, localId)

Retrieve rule by ID

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    Rule result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupRuleRuleById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **localId** | **String**| ID of local_id |

### Return type

[**Rule**](Rule.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve aggregated-node-edge-point

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById**
> OwnedNodeEdgePointRef retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, topologyIdNodeIdOwnedNodeEdgePointId)

Retrieve aggregated-node-edge-point by ID

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String topologyIdNodeIdOwnedNodeEdgePointId = "topologyIdNodeIdOwnedNodeEdgePointId_example"; // String | ID of topology_id node_id owned_node_edge_point_id
try {
    OwnedNodeEdgePointRef result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, topologyIdNodeIdOwnedNodeEdgePointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **topologyIdNodeIdOwnedNodeEdgePointId** | **String**| ID of topology_id node_id owned_node_edge_point_id |

### Return type

[**OwnedNodeEdgePointRef**](OwnedNodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint**
> List&lt;String&gt; retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve mapped-service-interface-point

Retrieve operation of resource: mapped-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById**
> ServiceInterfacePointRef retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, serviceInterfacePointId)

Retrieve mapped-service-interface-point by ID

Retrieve operation of resource: mapped-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String serviceInterfacePointId = "serviceInterfacePointId_example"; // String | ID of service_interface_point_id
try {
    ServiceInterfacePointRef result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, serviceInterfacePointId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **serviceInterfacePointId** | **String**| ID of service_interface_point_id |

### Return type

[**ServiceInterfacePointRef**](ServiceInterfacePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointNameName"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointNameName**
> List&lt;String&gt; retrieveContextTopologyNodeOwnedNodeEdgePointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById**
> NameAndValue retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid, nodeUuid)

Retrieve owned-node-edge-point

Retrieve operation of resource: owned-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById**
> NodeEdgePoint retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve owned-node-edge-point by ID

Retrieve operation of resource: owned-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    NodeEdgePoint result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**NodeEdgePoint**](NodeEdgePoint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**BandwidthProfile**](BandwidthProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**Capacity**](Capacity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |

### Return type

[**CapacityValue**](CapacityValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyTopology"></a>
# **retrieveContextTopologyTopology**
> List&lt;String&gt; retrieveContextTopologyTopology()

Retrieve topology

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<String> result = apiInstance.retrieveContextTopologyTopology();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyTopology");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyTopologyById"></a>
# **retrieveContextTopologyTopologyById**
> Topology retrieveContextTopologyTopologyById(uuid)

Retrieve topology by ID

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Topology result = apiInstance.retrieveContextTopologyTopologyById(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#retrieveContextTopologyTopologyById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |

### Return type

[**Topology**](Topology.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextById"></a>
# **updateContextById**
> updateContextById(context)

Update context by ID

Update operation of resource: context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
ContextSchema context = new ContextSchema(); // ContextSchema | contextbody object
try {
    apiInstance.updateContextById(context);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **context** | [**ContextSchema**](ContextSchema.md)| contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextNameNameById"></a>
# **updateContextNameNameById**
> updateContextNameNameById(valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextNameNameById(valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextServiceInterfacePointNameNameById"></a>
# **updateContextServiceInterfacePointNameNameById**
> updateContextServiceInterfacePointNameNameById(uuid, valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextServiceInterfacePointNameNameById(uuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextServiceInterfacePointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextServiceInterfacePointServiceInterfacePointById"></a>
# **updateContextServiceInterfacePointServiceInterfacePointById**
> updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint)

Update service-interface-point by ID

Update operation of resource: service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String uuid = "uuid_example"; // String | ID of uuid
ServiceInterfacePoint serviceInterfacePoint = new ServiceInterfacePoint(); // ServiceInterfacePoint | service-interface-pointbody object
try {
    apiInstance.updateContextServiceInterfacePointServiceInterfacePointById(uuid, serviceInterfacePoint);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#updateContextServiceInterfacePointServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **serviceInterfacePoint** | [**ServiceInterfacePoint**](ServiceInterfacePoint.md)| service-interface-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

