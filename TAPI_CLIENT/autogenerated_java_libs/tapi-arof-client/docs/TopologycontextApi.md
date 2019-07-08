# TopologycontextApi

All URIs are relative to *http://localhost:8080/restconf*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createContextTopologyContextTopologyContextById**](TopologycontextApi.md#createContextTopologyContextTopologyContextById) | **POST** /config/context/topology-context/ | Create topology-context by ID
[**createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**](TopologycontextApi.md#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById) | **POST** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/ | Create arof-connection-end-point-spec by ID
[**createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**](TopologycontextApi.md#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById) | **POST** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/ | Create connection-end-point by ID
[**createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**](TopologycontextApi.md#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById) | **POST** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/name/{value_name}/ | Create name by ID
[**deleteContextTopologyContextTopologyContextById**](TopologycontextApi.md#deleteContextTopologyContextTopologyContextById) | **DELETE** /config/context/topology-context/ | Delete topology-context by ID
[**deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**](TopologycontextApi.md#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById) | **DELETE** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/ | Delete arof-connection-end-point-spec by ID
[**deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**](TopologycontextApi.md#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById) | **DELETE** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/ | Delete connection-end-point by ID
[**deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**](TopologycontextApi.md#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById) | **DELETE** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/name/{value_name}/ | Delete name by ID
[**retrieveContextTopologyContextNwTopologyServiceNameName**](TopologycontextApi.md#retrieveContextTopologyContextNwTopologyServiceNameName) | **GET** /config/context/topology-context/nw-topology-service/name/ | Retrieve name
[**retrieveContextTopologyContextNwTopologyServiceNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextNwTopologyServiceNameNameById) | **GET** /config/context/topology-context/nw-topology-service/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextNwTopologyServiceNwTopologyService**](TopologycontextApi.md#retrieveContextTopologyContextNwTopologyServiceNwTopologyService) | **GET** /config/context/topology-context/nw-topology-service/ | Retrieve nw-topology-service
[**retrieveContextTopologyContextNwTopologyServiceTopologyTopology**](TopologycontextApi.md#retrieveContextTopologyContextNwTopologyServiceTopologyTopology) | **GET** /config/context/topology-context/nw-topology-service/topology/ | Retrieve topology
[**retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById**](TopologycontextApi.md#retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById) | **GET** /config/context/topology-context/nw-topology-service/topology/{topology_uuid}/ | Retrieve topology by ID
[**retrieveContextTopologyContextTopologyContext**](TopologycontextApi.md#retrieveContextTopologyContextTopologyContext) | **GET** /config/context/topology-context/ | Retrieve topology-context
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyContextTopologyLinkLink**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkLink) | **GET** /config/context/topology-context/topology/{uuid}/link/ | Retrieve link
[**retrieveContextTopologyContextTopologyLinkLinkById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkLinkById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/ | Retrieve link by ID
[**retrieveContextTopologyContextTopologyLinkNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkNameName) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyLinkNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/node-edge-point/ | Retrieve node-edge-point
[**retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/node-edge-point/{topology_uuid_node_uuid_node_edge_point_uuid}/ | Retrieve node-edge-point by ID
[**retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/resilience-type/ | Retrieve resilience-type
[**retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/validation-mechanism/ | Retrieve validation-mechanism
[**retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById) | **GET** /config/context/topology-context/topology/{uuid}/link/{link_uuid}/validation-mechanism/{validation_mechanism}/ | Retrieve validation-mechanism by ID
[**retrieveContextTopologyContextTopologyNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNameName) | **GET** /config/context/topology-context/topology/{uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
[**retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/aggregated-node-edge-point/{topology_uuid_node_uuid_node_edge_point_uuid}/ | Retrieve aggregated-node-edge-point by ID
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/encap-topology/ | Retrieve encap-topology
[**retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeNode**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNode) | **GET** /config/context/topology-context/topology/{uuid}/node/ | Retrieve node
[**retrieveContextTopologyContextTopologyNodeNodeById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/ | Retrieve node by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/ | Retrieve composed-rule-group
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/composed-rule-group/{topology_uuid_node_uuid_node_rule_group_uuid}/ | Retrieve composed-rule-group by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/ | Retrieve associated-node-rule-group
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/associated-node-rule-group/{topology_uuid_node_uuid_node_rule_group_uuid}/ | Retrieve associated-node-rule-group by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/ | Retrieve cost-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/cost-characteristic/{cost_name}/ | Retrieve cost-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/ | Retrieve inter-rule-group
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/ | Retrieve inter-rule-group by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/ | Retrieve rule
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/inter-rule-group/{inter_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/ | Retrieve latency-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/latency-characteristic/{traffic_property_name}/ | Retrieve latency-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/ | Retrieve node-edge-point
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/node-edge-point/{topology_uuid_node_uuid_node_edge_point_uuid}/ | Retrieve node-edge-point by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/ | Retrieve node-rule-group
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/ | Retrieve node-rule-group by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/ | Retrieve risk-characteristic
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/risk-characteristic/{risk_characteristic_name}/ | Retrieve risk-characteristic by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/ | Retrieve rule
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/rule/{local_id}/ | Retrieve rule by ID
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/node-rule-group/{node_rule_group_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/ | Retrieve aggregated-node-edge-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/aggregated-node-edge-point/{topology_uuid_node_uuid_node_edge_point_uuid}/ | Retrieve aggregated-node-edge-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/ | Retrieve available-capacity
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/available-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/ | Retrieve cep-list
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/aggregated-connection-end-point/ | Retrieve aggregated-connection-end-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/aggregated-connection-end-point/{topology_uuid_node_uuid_node_edge_point_uuid_connection_end_point_uuid}/ | Retrieve aggregated-connection-end-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/ | Retrieve arof-connection-end-point-spec
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/media-channel/ | Retrieve media-channel
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/media-channel/occupied-spectrum/frequency-constraint/ | Retrieve frequency-constraint
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/media-channel/occupied-spectrum/ | Retrieve occupied-spectrum
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/client-node-edge-point/ | Retrieve client-node-edge-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/client-node-edge-point/{topology_uuid_node_uuid_node_edge_point_uuid}/ | Retrieve client-node-edge-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/ | Retrieve connection-end-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/ | Retrieve connection-end-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/parent-node-edge-point/ | Retrieve parent-node-edge-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/ | Retrieve mapped-service-interface-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/mapped-service-interface-point/{service_interface_point_uuid}/ | Retrieve mapped-service-interface-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/ | Retrieve name
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/name/{value_name}/ | Retrieve name by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/ | Retrieve owned-node-edge-point
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/ | Retrieve owned-node-edge-point by ID
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/ | Retrieve bandwidth-profile
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-burst-size/ | Retrieve committed-burst-size
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/committed-information-rate/ | Retrieve committed-information-rate
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-burst-size/ | Retrieve peak-burst-size
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/bandwidth-profile/peak-information-rate/ | Retrieve peak-information-rate
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/ | Retrieve total-potential-capacity
[**retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize**](TopologycontextApi.md#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize) | **GET** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/total-potential-capacity/total-size/ | Retrieve total-size
[**retrieveContextTopologyContextTopologyTopology**](TopologycontextApi.md#retrieveContextTopologyContextTopologyTopology) | **GET** /config/context/topology-context/topology/ | Retrieve topology
[**retrieveContextTopologyContextTopologyTopologyById**](TopologycontextApi.md#retrieveContextTopologyContextTopologyTopologyById) | **GET** /config/context/topology-context/topology/{uuid}/ | Retrieve topology by ID
[**updateContextTopologyContextTopologyContextById**](TopologycontextApi.md#updateContextTopologyContextTopologyContextById) | **PUT** /config/context/topology-context/ | Update topology-context by ID
[**updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**](TopologycontextApi.md#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById) | **PUT** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/arof-connection-end-point-spec/ | Update arof-connection-end-point-spec by ID
[**updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**](TopologycontextApi.md#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById) | **PUT** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/ | Update connection-end-point by ID
[**updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**](TopologycontextApi.md#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById) | **PUT** /config/context/topology-context/topology/{uuid}/node/{node_uuid}/owned-node-edge-point/{owned_node_edge_point_uuid}/cep-list/connection-end-point/{connection_end_point_uuid}/name/{value_name}/ | Update name by ID


<a name="createContextTopologyContextTopologyContextById"></a>
# **createContextTopologyContextTopologyContextById**
> createContextTopologyContextTopologyContextById(topologyContext)

Create topology-context by ID

Create operation of resource: topology-context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
TopologyContext topologyContext = new TopologyContext(); // TopologyContext | topology-contextbody object
try {
    apiInstance.createContextTopologyContextTopologyContextById(topologyContext);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#createContextTopologyContextTopologyContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topologyContext** | [**TopologyContext**](TopologyContext.md)| topology-contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById"></a>
# **createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**
> createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, arofConnectionEndPointSpec)

Create arof-connection-end-point-spec by ID

Create operation of resource: arof-connection-end-point-spec

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
ArofConnectionEndPointSpec arofConnectionEndPointSpec = new ArofConnectionEndPointSpec(); // ArofConnectionEndPointSpec | arof-connection-end-point-specbody object
try {
    apiInstance.createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, arofConnectionEndPointSpec);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **arofConnectionEndPointSpec** | [**ArofConnectionEndPointSpec**](ArofConnectionEndPointSpec.md)| arof-connection-end-point-specbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById"></a>
# **createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**
> createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, connectionEndPoint)

Create connection-end-point by ID

Create operation of resource: connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
ConnectionEndPointSchema connectionEndPoint = new ConnectionEndPointSchema(); // ConnectionEndPointSchema | connection-end-pointbody object
try {
    apiInstance.createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, connectionEndPoint);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **connectionEndPoint** | [**ConnectionEndPointSchema**](ConnectionEndPointSchema.md)| connection-end-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById"></a>
# **createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**
> createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName, name)

Create name by ID

Create operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#createContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextTopologyContextTopologyContextById"></a>
# **deleteContextTopologyContextTopologyContextById**
> deleteContextTopologyContextTopologyContextById()

Delete topology-context by ID

Delete operation of resource: topology-context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    apiInstance.deleteContextTopologyContextTopologyContextById();
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#deleteContextTopologyContextTopologyContextById");
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

<a name="deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById"></a>
# **deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**
> deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Delete arof-connection-end-point-spec by ID

Delete operation of resource: arof-connection-end-point-spec

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    apiInstance.deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById"></a>
# **deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**
> deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Delete connection-end-point by ID

Delete operation of resource: connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    apiInstance.deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById"></a>
# **deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**
> deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName)

Delete name by ID

Delete operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    apiInstance.deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#deleteContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextNwTopologyServiceNameName"></a>
# **retrieveContextTopologyContextNwTopologyServiceNameName**
> List&lt;String&gt; retrieveContextTopologyContextNwTopologyServiceNameName()

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    List<String> result = apiInstance.retrieveContextTopologyContextNwTopologyServiceNameName();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextNwTopologyServiceNameName");
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

<a name="retrieveContextTopologyContextNwTopologyServiceNameNameById"></a>
# **retrieveContextTopologyContextNwTopologyServiceNameNameById**
> NameAndValue retrieveContextTopologyContextNwTopologyServiceNameNameById(valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextNwTopologyServiceNameNameById(valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextNwTopologyServiceNameNameById");
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

<a name="retrieveContextTopologyContextNwTopologyServiceNwTopologyService"></a>
# **retrieveContextTopologyContextNwTopologyServiceNwTopologyService**
> NetworkTopologyService retrieveContextTopologyContextNwTopologyServiceNwTopologyService()

Retrieve nw-topology-service

Retrieve operation of resource: nw-topology-service

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    NetworkTopologyService result = apiInstance.retrieveContextTopologyContextNwTopologyServiceNwTopologyService();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextNwTopologyServiceNwTopologyService");
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

<a name="retrieveContextTopologyContextNwTopologyServiceTopologyTopology"></a>
# **retrieveContextTopologyContextNwTopologyServiceTopologyTopology**
> List&lt;String&gt; retrieveContextTopologyContextNwTopologyServiceTopologyTopology()

Retrieve topology

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    List<String> result = apiInstance.retrieveContextTopologyContextNwTopologyServiceTopologyTopology();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextNwTopologyServiceTopologyTopology");
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

<a name="retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById"></a>
# **retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById**
> TopologyRef retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById(topologyUuid)

Retrieve topology by ID

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String topologyUuid = "topologyUuid_example"; // String | ID of topology_uuid
try {
    TopologyRef result = apiInstance.retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById(topologyUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextNwTopologyServiceTopologyTopologyById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topologyUuid** | **String**| ID of topology_uuid |

### Return type

[**TopologyRef**](TopologyRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyContext"></a>
# **retrieveContextTopologyContextTopologyContext**
> TopologyContext retrieveContextTopologyContextTopologyContext()

Retrieve topology-context

Retrieve operation of resource: topology-context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    TopologyContext result = apiInstance.retrieveContextTopologyContextTopologyContext();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyContext");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TopologyContext**](TopologyContext.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity(uuid, linkUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityAvailableCapacity");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize(uuid, linkUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkAvailableCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic(uuid, linkUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById(uuid, linkUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById(uuid, linkUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkCostCharacteristicCostCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic(uuid, linkUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById(uuid, linkUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById(uuid, linkUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkLatencyCharacteristicLatencyCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyLinkLink"></a>
# **retrieveContextTopologyContextTopologyLinkLink**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkLink(uuid)

Retrieve link

Retrieve operation of resource: link

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkLink(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkLink");
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

<a name="retrieveContextTopologyContextTopologyLinkLinkById"></a>
# **retrieveContextTopologyContextTopologyLinkLinkById**
> Link retrieveContextTopologyContextTopologyLinkLinkById(uuid, linkUuid)

Retrieve link by ID

Retrieve operation of resource: link

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Link result = apiInstance.retrieveContextTopologyContextTopologyLinkLinkById(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkLinkById");
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

<a name="retrieveContextTopologyContextTopologyLinkNameName"></a>
# **retrieveContextTopologyContextTopologyLinkNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkNameName(uuid, linkUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkNameName(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkNameName");
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

<a name="retrieveContextTopologyContextTopologyLinkNameNameById"></a>
# **retrieveContextTopologyContextTopologyLinkNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyLinkNameNameById(uuid, linkUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyLinkNameNameById(uuid, linkUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkNameNameById");
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

<a name="retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint(uuid, linkUuid)

Retrieve node-edge-point

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePoint");
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

<a name="retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById**
> NodeEdgePointRef retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById(uuid, linkUuid, topologyUuidNodeUuidNodeEdgePointUuid)

Retrieve node-edge-point by ID

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String topologyUuidNodeUuidNodeEdgePointUuid = "topologyUuidNodeUuidNodeEdgePointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById(uuid, linkUuid, topologyUuidNodeUuidNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkNodeEdgePointNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **linkUuid** | **String**| ID of link_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType"></a>
# **retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType**
> ResilienceType retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType(uuid, linkUuid)

Retrieve resilience-type

Retrieve operation of resource: resilience-type

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    ResilienceType result = apiInstance.retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkResilienceTypeResilienceType");
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

<a name="retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic(uuid, linkUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById(uuid, linkUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById(uuid, linkUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkRiskCharacteristicRiskCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity(uuid, linkUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalPotentialCapacity");
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

<a name="retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize(uuid, linkUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism"></a>
# **retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism**
> List&lt;String&gt; retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism(uuid, linkUuid)

Retrieve validation-mechanism

Retrieve operation of resource: validation-mechanism

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism(uuid, linkUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanism");
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

<a name="retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById"></a>
# **retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById**
> ValidationMechanism retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById(uuid, linkUuid, validationMechanism)

Retrieve validation-mechanism by ID

Retrieve operation of resource: validation-mechanism

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String linkUuid = "linkUuid_example"; // String | ID of link_uuid
String validationMechanism = "validationMechanism_example"; // String | ID of validation_mechanism
try {
    ValidationMechanism result = apiInstance.retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById(uuid, linkUuid, validationMechanism);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyLinkValidationMechanismValidationMechanismById");
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

<a name="retrieveContextTopologyContextTopologyNameName"></a>
# **retrieveContextTopologyContextTopologyNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNameName(uuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNameName(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNameName");
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

<a name="retrieveContextTopologyContextTopologyNameNameById"></a>
# **retrieveContextTopologyContextTopologyNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNameNameById(uuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNameNameById(uuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid)

Retrieve aggregated-node-edge-point

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePoint");
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

<a name="retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById**
> NodeEdgePointRef retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, topologyUuidNodeUuidNodeEdgePointUuid)

Retrieve aggregated-node-edge-point by ID

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String topologyUuidNodeUuidNodeEdgePointUuid = "topologyUuidNodeUuidNodeEdgePointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, topologyUuidNodeUuidNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAggregatedNodeEdgePointAggregatedNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity(uuid, nodeUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityAvailableCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeAvailableCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic(uuid, nodeUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById(uuid, nodeUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById(uuid, nodeUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeCostCharacteristicCostCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology"></a>
# **retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology**
> TopologyRef retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology(uuid, nodeUuid)

Retrieve encap-topology

Retrieve operation of resource: encap-topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    TopologyRef result = apiInstance.retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeEncapTopologyEncapTopology");
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

<a name="retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeLatencyCharacteristicLatencyCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNameName"></a>
# **retrieveContextTopologyContextTopologyNodeNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNameName(uuid, nodeUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNameName(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeNameNameById(uuid, nodeUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNameNameById(uuid, nodeUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeNode"></a>
# **retrieveContextTopologyContextTopologyNodeNode**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNode(uuid)

Retrieve node

Retrieve operation of resource: node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNode(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNode");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeById**
> Node retrieveContextTopologyContextTopologyNodeNodeById(uuid, nodeUuid)

Retrieve node by ID

Retrieve operation of resource: node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Node result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeById(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityAvailableCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupAvailableCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve composed-rule-group

Retrieve operation of resource: composed-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroup");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById**
> NodeRuleGroupRef retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, topologyUuidNodeUuidNodeRuleGroupUuid)

Retrieve composed-rule-group by ID

Retrieve operation of resource: composed-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String topologyUuidNodeUuidNodeRuleGroupUuid = "topologyUuidNodeUuidNodeRuleGroupUuid_example"; // String | ID of topology_uuid_node_uuid_node_rule_group_uuid
try {
    NodeRuleGroupRef result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, topologyUuidNodeUuidNodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupComposedRuleGroupComposedRuleGroupById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **topologyUuidNodeUuidNodeRuleGroupUuid** | **String**| ID of topology_uuid_node_uuid_node_rule_group_uuid |

### Return type

[**NodeRuleGroupRef**](NodeRuleGroupRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupCostCharacteristicCostCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve associated-node-rule-group

Retrieve operation of resource: associated-node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroup");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById**
> NodeRuleGroupRef retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, topologyUuidNodeUuidNodeRuleGroupUuid)

Retrieve associated-node-rule-group by ID

Retrieve operation of resource: associated-node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String topologyUuidNodeUuidNodeRuleGroupUuid = "topologyUuidNodeUuidNodeRuleGroupUuid_example"; // String | ID of topology_uuid_node_uuid_node_rule_group_uuid
try {
    NodeRuleGroupRef result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, topologyUuidNodeUuidNodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAssociatedNodeRuleGroupAssociatedNodeRuleGroupById");
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
 **topologyUuidNodeUuidNodeRuleGroupUuid** | **String**| ID of topology_uuid_node_uuid_node_rule_group_uuid |

### Return type

[**NodeRuleGroupRef**](NodeRuleGroupRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityAvailableCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupAvailableCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve cost-characteristic

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById**
> CostCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, costName)

Retrieve cost-characteristic by ID

Retrieve operation of resource: cost-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String costName = "costName_example"; // String | ID of cost_name
try {
    CostCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, costName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupCostCharacteristicCostCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve inter-rule-group

Retrieve operation of resource: inter-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroup");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById**
> InterRuleGroup retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve inter-rule-group by ID

Retrieve operation of resource: inter-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    InterRuleGroup result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupInterRuleGroupById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupLatencyCharacteristicLatencyCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRiskCharacteristicRiskCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve rule

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRule");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById**
> Rule retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId)

Retrieve rule by ID

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    Rule result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupRuleRuleById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalPotentialCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String interRuleGroupUuid = "interRuleGroupUuid_example"; // String | ID of inter_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid, interRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupInterRuleGroupTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve latency-characteristic

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById**
> LatencyCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, trafficPropertyName)

Retrieve latency-characteristic by ID

Retrieve operation of resource: latency-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String trafficPropertyName = "trafficPropertyName_example"; // String | ID of traffic_property_name
try {
    LatencyCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, trafficPropertyName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupLatencyCharacteristicLatencyCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve node-edge-point

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePoint");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById**
> NodeEdgePointRef retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById(uuid, nodeUuid, nodeRuleGroupUuid, topologyUuidNodeUuidNodeEdgePointUuid)

Retrieve node-edge-point by ID

Retrieve operation of resource: node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String topologyUuidNodeUuidNodeEdgePointUuid = "topologyUuidNodeUuidNodeEdgePointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById(uuid, nodeUuid, nodeRuleGroupUuid, topologyUuidNodeUuidNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeEdgePointNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **nodeRuleGroupUuid** | **String**| ID of node_rule_group_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup(uuid, nodeUuid)

Retrieve node-rule-group

Retrieve operation of resource: node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroup");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById**
> NodeRuleGroup retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve node-rule-group by ID

Retrieve operation of resource: node-rule-group

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    NodeRuleGroup result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupNodeRuleGroupById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve risk-characteristic

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristic");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById**
> RiskCharacteristic retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, riskCharacteristicName)

Retrieve risk-characteristic by ID

Retrieve operation of resource: risk-characteristic

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String riskCharacteristicName = "riskCharacteristicName_example"; // String | ID of risk_characteristic_name
try {
    RiskCharacteristic result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById(uuid, nodeUuid, nodeRuleGroupUuid, riskCharacteristicName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRiskCharacteristicRiskCharacteristicById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, localId)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName(uuid, nodeUuid, nodeRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, localId, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById(uuid, nodeUuid, nodeRuleGroupUuid, localId, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve rule

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRule");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById**
> Rule retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, localId)

Retrieve rule by ID

Retrieve operation of resource: rule

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
String localId = "localId_example"; // String | ID of local_id
try {
    Rule result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById(uuid, nodeUuid, nodeRuleGroupUuid, localId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupRuleRuleById");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalPotentialCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String nodeRuleGroupUuid = "nodeRuleGroupUuid_example"; // String | ID of node_rule_group_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, nodeRuleGroupUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeNodeRuleGroupTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve aggregated-node-edge-point

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePoint");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById**
> NodeEdgePointRef retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, topologyUuidNodeUuidNodeEdgePointUuid)

Retrieve aggregated-node-edge-point by ID

Retrieve operation of resource: aggregated-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String topologyUuidNodeUuidNodeEdgePointUuid = "topologyUuidNodeUuidNodeEdgePointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, topologyUuidNodeUuidNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAggregatedNodeEdgePointAggregatedNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve available-capacity

Retrieve operation of resource: available-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityAvailableCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointAvailableCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList**
> CepList retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve cep-list

Retrieve operation of resource: cep-list

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CepList result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListCepList");
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

[**CepList**](CepList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve aggregated-connection-end-point

Retrieve operation of resource: aggregated-connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById**
> ConnectionEndPointRef retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, topologyUuidNodeUuidNodeEdgePointUuidConnectionEndPointUuid)

Retrieve aggregated-connection-end-point by ID

Retrieve operation of resource: aggregated-connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String topologyUuidNodeUuidNodeEdgePointUuidConnectionEndPointUuid = "topologyUuidNodeUuidNodeEdgePointUuidConnectionEndPointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid_connection_end_point_uuid
try {
    ConnectionEndPointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, topologyUuidNodeUuidNodeEdgePointUuidConnectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointAggregatedConnectionEndPointAggregatedConnectionEndPointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuidConnectionEndPointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid_connection_end_point_uuid |

### Return type

[**ConnectionEndPointRef**](ConnectionEndPointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec**
> ArofConnectionEndPointSpec retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve arof-connection-end-point-spec

Retrieve operation of resource: arof-connection-end-point-spec

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    ArofConnectionEndPointSpec result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpec");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**ArofConnectionEndPointSpec**](ArofConnectionEndPointSpec.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel**
> ArofPropertiesPac retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve media-channel

Retrieve operation of resource: media-channel

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    ArofPropertiesPac result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelMediaChannel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**ArofPropertiesPac**](ArofPropertiesPac.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint**
> FrequencyConstraint retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve frequency-constraint

Retrieve operation of resource: frequency-constraint

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    FrequencyConstraint result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumFrequencyConstraintFrequencyConstraint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**FrequencyConstraint**](FrequencyConstraint.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum**
> SpectrumBand retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve occupied-spectrum

Retrieve operation of resource: occupied-spectrum

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    SpectrumBand result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecMediaChannelOccupiedSpectrumOccupiedSpectrum");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**SpectrumBand**](SpectrumBand.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve client-node-edge-point

Retrieve operation of resource: client-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById**
> NodeEdgePointRef retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, topologyUuidNodeUuidNodeEdgePointUuid)

Retrieve client-node-edge-point by ID

Retrieve operation of resource: client-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String topologyUuidNodeUuidNodeEdgePointUuid = "topologyUuidNodeUuidNodeEdgePointUuid_example"; // String | ID of topology_uuid_node_uuid_node_edge_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, topologyUuidNodeUuidNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointClientNodeEdgePointClientNodeEdgePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **topologyUuidNodeUuidNodeEdgePointUuid** | **String**| ID of topology_uuid_node_uuid_node_edge_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve connection-end-point

Retrieve operation of resource: connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPoint");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**
> ConnectionEndPointSchema retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve connection-end-point by ID

Retrieve operation of resource: connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    ConnectionEndPointSchema result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**ConnectionEndPointSchema**](ConnectionEndPointSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **valueName** | **String**| ID of value_name |

### Return type

[**NameAndValue**](NameAndValue.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint**
> NodeEdgePointRef retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid)

Retrieve parent-node-edge-point

Retrieve operation of resource: parent-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
try {
    NodeEdgePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointParentNodeEdgePointParentNodeEdgePoint");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |

### Return type

[**NodeEdgePointRef**](NodeEdgePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve mapped-service-interface-point

Retrieve operation of resource: mapped-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePoint");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById**
> ServiceInterfacePointRef retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, serviceInterfacePointUuid)

Retrieve mapped-service-interface-point by ID

Retrieve operation of resource: mapped-service-interface-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String serviceInterfacePointUuid = "serviceInterfacePointUuid_example"; // String | ID of service_interface_point_uuid
try {
    ServiceInterfacePointRef result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById(uuid, nodeUuid, ownedNodeEdgePointUuid, serviceInterfacePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointMappedServiceInterfacePointMappedServiceInterfacePointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **serviceInterfacePointUuid** | **String**| ID of service_interface_point_uuid |

### Return type

[**ServiceInterfacePointRef**](ServiceInterfacePointRef.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve name

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameName");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById**
> NameAndValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, valueName)

Retrieve name by ID

Retrieve operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
try {
    NameAndValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, valueName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointNameNameById");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint**
> List&lt;String&gt; retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid, nodeUuid)

Retrieve owned-node-edge-point

Retrieve operation of resource: owned-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePoint");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById**
> OwnedNodeEdgePointSchema retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve owned-node-edge-point by ID

Retrieve operation of resource: owned-node-edge-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    OwnedNodeEdgePointSchema result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointOwnedNodeEdgePointById");
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

[**OwnedNodeEdgePointSchema**](OwnedNodeEdgePointSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalPotentialCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid, ownedNodeEdgePointUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeOwnedNodeEdgePointTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile**
> BandwidthProfile retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid)

Retrieve bandwidth-profile

Retrieve operation of resource: bandwidth-profile

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    BandwidthProfile result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileBandwidthProfile");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid)

Retrieve committed-burst-size

Retrieve operation of resource: committed-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedBurstSizeCommittedBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid)

Retrieve committed-information-rate

Retrieve operation of resource: committed-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfileCommittedInformationRateCommittedInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid)

Retrieve peak-burst-size

Retrieve operation of resource: peak-burst-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakBurstSizePeakBurstSize");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate**
> CapacityValue retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid)

Retrieve peak-information-rate

Retrieve operation of resource: peak-information-rate

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityBandwidthProfilePeakInformationRatePeakInformationRate");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity**
> Capacity retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid)

Retrieve total-potential-capacity

Retrieve operation of resource: total-potential-capacity

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    Capacity result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalPotentialCapacity");
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

<a name="retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize"></a>
# **retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize**
> CapacityValue retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid)

Retrieve total-size

Retrieve operation of resource: total-size

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
try {
    CapacityValue result = apiInstance.retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize(uuid, nodeUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyNodeTotalPotentialCapacityTotalSizeTotalSize");
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

<a name="retrieveContextTopologyContextTopologyTopology"></a>
# **retrieveContextTopologyContextTopologyTopology**
> List&lt;String&gt; retrieveContextTopologyContextTopologyTopology()

Retrieve topology

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
try {
    List<String> result = apiInstance.retrieveContextTopologyContextTopologyTopology();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyTopology");
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

<a name="retrieveContextTopologyContextTopologyTopologyById"></a>
# **retrieveContextTopologyContextTopologyTopologyById**
> Topology retrieveContextTopologyContextTopologyTopologyById(uuid)

Retrieve topology by ID

Retrieve operation of resource: topology

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
try {
    Topology result = apiInstance.retrieveContextTopologyContextTopologyTopologyById(uuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#retrieveContextTopologyContextTopologyTopologyById");
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

<a name="updateContextTopologyContextTopologyContextById"></a>
# **updateContextTopologyContextTopologyContextById**
> updateContextTopologyContextTopologyContextById(topologyContext)

Update topology-context by ID

Update operation of resource: topology-context

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
TopologyContext topologyContext = new TopologyContext(); // TopologyContext | topology-contextbody object
try {
    apiInstance.updateContextTopologyContextTopologyContextById(topologyContext);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#updateContextTopologyContextTopologyContextById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **topologyContext** | [**TopologyContext**](TopologyContext.md)| topology-contextbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById"></a>
# **updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById**
> updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, arofConnectionEndPointSpec)

Update arof-connection-end-point-spec by ID

Update operation of resource: arof-connection-end-point-spec

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
ArofConnectionEndPointSpec arofConnectionEndPointSpec = new ArofConnectionEndPointSpec(); // ArofConnectionEndPointSpec | arof-connection-end-point-specbody object
try {
    apiInstance.updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, arofConnectionEndPointSpec);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointArofConnectionEndPointSpecArofConnectionEndPointSpecById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **arofConnectionEndPointSpec** | [**ArofConnectionEndPointSpec**](ArofConnectionEndPointSpec.md)| arof-connection-end-point-specbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById"></a>
# **updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById**
> updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, connectionEndPoint)

Update connection-end-point by ID

Update operation of resource: connection-end-point

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
ConnectionEndPointSchema connectionEndPoint = new ConnectionEndPointSchema(); // ConnectionEndPointSchema | connection-end-pointbody object
try {
    apiInstance.updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, connectionEndPoint);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointConnectionEndPointById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **connectionEndPoint** | [**ConnectionEndPointSchema**](ConnectionEndPointSchema.md)| connection-end-pointbody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById"></a>
# **updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById**
> updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName, name)

Update name by ID

Update operation of resource: name

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TopologycontextApi;


TopologycontextApi apiInstance = new TopologycontextApi();
String uuid = "uuid_example"; // String | ID of uuid
String nodeUuid = "nodeUuid_example"; // String | ID of node_uuid
String ownedNodeEdgePointUuid = "ownedNodeEdgePointUuid_example"; // String | ID of owned_node_edge_point_uuid
String connectionEndPointUuid = "connectionEndPointUuid_example"; // String | ID of connection_end_point_uuid
String valueName = "valueName_example"; // String | ID of value_name
NameAndValue name = new NameAndValue(); // NameAndValue | namebody object
try {
    apiInstance.updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById(uuid, nodeUuid, ownedNodeEdgePointUuid, connectionEndPointUuid, valueName, name);
} catch (ApiException e) {
    System.err.println("Exception when calling TopologycontextApi#updateContextTopologyContextTopologyNodeOwnedNodeEdgePointCepListConnectionEndPointNameNameById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uuid** | **String**| ID of uuid |
 **nodeUuid** | **String**| ID of node_uuid |
 **ownedNodeEdgePointUuid** | **String**| ID of owned_node_edge_point_uuid |
 **connectionEndPointUuid** | **String**| ID of connection_end_point_uuid |
 **valueName** | **String**| ID of value_name |
 **name** | [**NameAndValue**](NameAndValue.md)| namebody object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

