/**
 * tapi-connectivity API
 * tapi-connectivity API generated from tapi-connectivity@2018-12-10.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.AdminStatePac;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityPac;
import io.swagger.client.model.CostCharacteristic;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NodeEdgePoint;
import io.swagger.client.model.NodeEdgePointRef;
import io.swagger.client.model.NodeRuleGroup;
import io.swagger.client.model.ResourceSpec;
import io.swagger.client.model.TopologyRef;
import io.swagger.client.model.TransferCostPac;
import io.swagger.client.model.TransferIntegrityPac;
import io.swagger.client.model.TransferTimingPac;
import java.util.ArrayList;
import java.util.List;


/**
 * The ForwardingDomain (FD) object class models the ForwardingDomain topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding. At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). 
 */
@ApiModel(description = "The ForwardingDomain (FD) object class models the ForwardingDomain topological component which is used to effect forwarding of transport characteristic information and offers the potential to enable forwarding. At the lowest level of recursion, an FD (within a network element (NE)) represents a switch matrix (i.e., a fabric). Note that an NE can encompass multiple switch matrices (FDs). ")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:24:55.849+02:00")
public class Node   {
  @SerializedName("node-rule-group")
  private List<NodeRuleGroup> nodeRuleGroup = new ArrayList<NodeRuleGroup>();

  /**
   * Gets or Sets layerProtocolName
   */
  public enum LayerProtocolNameEnum {
    @SerializedName("ODU")
    ODU("ODU"),
    
    @SerializedName("ETH")
    ETH("ETH"),
    
    @SerializedName("DSR")
    DSR("DSR"),
    
    @SerializedName("PHOTONIC_MEDIA")
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("layer-protocol-name")
  private List<LayerProtocolNameEnum> layerProtocolName = new ArrayList<LayerProtocolNameEnum>();

  @SerializedName("aggregated-node-edge-point")
  private List<NodeEdgePointRef> aggregatedNodeEdgePoint = new ArrayList<NodeEdgePointRef>();

  @SerializedName("owned-node-edge-point")
  private List<NodeEdgePoint> ownedNodeEdgePoint = new ArrayList<NodeEdgePoint>();

  @SerializedName("encap-topology")
  private TopologyRef encapTopology = null;

  public Node nodeRuleGroup(List<NodeRuleGroup> nodeRuleGroup) {
    this.nodeRuleGroup = nodeRuleGroup;
    return this;
  }

  public Node addNodeRuleGroupItem(NodeRuleGroup nodeRuleGroupItem) {
    this.nodeRuleGroup.add(nodeRuleGroupItem);
    return this;
  }

   /**
   * Get nodeRuleGroup
   * @return nodeRuleGroup
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<NodeRuleGroup> getNodeRuleGroup() {
    return nodeRuleGroup;
  }

  public void setNodeRuleGroup(List<NodeRuleGroup> nodeRuleGroup) {
    this.nodeRuleGroup = nodeRuleGroup;
  }

  public Node layerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

  public Node addLayerProtocolNameItem(LayerProtocolNameEnum layerProtocolNameItem) {
    this.layerProtocolName.add(layerProtocolNameItem);
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<LayerProtocolNameEnum> getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(List<LayerProtocolNameEnum> layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public Node aggregatedNodeEdgePoint(List<NodeEdgePointRef> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
    return this;
  }

  public Node addAggregatedNodeEdgePointItem(NodeEdgePointRef aggregatedNodeEdgePointItem) {
    this.aggregatedNodeEdgePoint.add(aggregatedNodeEdgePointItem);
    return this;
  }

   /**
   * Get aggregatedNodeEdgePoint
   * @return aggregatedNodeEdgePoint
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<NodeEdgePointRef> getAggregatedNodeEdgePoint() {
    return aggregatedNodeEdgePoint;
  }

  public void setAggregatedNodeEdgePoint(List<NodeEdgePointRef> aggregatedNodeEdgePoint) {
    this.aggregatedNodeEdgePoint = aggregatedNodeEdgePoint;
  }

  public Node ownedNodeEdgePoint(List<NodeEdgePoint> ownedNodeEdgePoint) {
    this.ownedNodeEdgePoint = ownedNodeEdgePoint;
    return this;
  }

  public Node addOwnedNodeEdgePointItem(NodeEdgePoint ownedNodeEdgePointItem) {
    this.ownedNodeEdgePoint.add(ownedNodeEdgePointItem);
    return this;
  }

   /**
   * Get ownedNodeEdgePoint
   * @return ownedNodeEdgePoint
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<NodeEdgePoint> getOwnedNodeEdgePoint() {
    return ownedNodeEdgePoint;
  }

  public void setOwnedNodeEdgePoint(List<NodeEdgePoint> ownedNodeEdgePoint) {
    this.ownedNodeEdgePoint = ownedNodeEdgePoint;
  }

  public Node encapTopology(TopologyRef encapTopology) {
    this.encapTopology = encapTopology;
    return this;
  }

   /**
   * Get encapTopology
   * @return encapTopology
  **/
  @ApiModelProperty(example = "null", value = "")
  public TopologyRef getEncapTopology() {
    return encapTopology;
  }

  public void setEncapTopology(TopologyRef encapTopology) {
    this.encapTopology = encapTopology;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(this.nodeRuleGroup, node.nodeRuleGroup) &&
        Objects.equals(this.layerProtocolName, node.layerProtocolName) &&
        Objects.equals(this.aggregatedNodeEdgePoint, node.aggregatedNodeEdgePoint) &&
        Objects.equals(this.ownedNodeEdgePoint, node.ownedNodeEdgePoint) &&
        Objects.equals(this.encapTopology, node.encapTopology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeRuleGroup, layerProtocolName, aggregatedNodeEdgePoint, ownedNodeEdgePoint, encapTopology);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Node {\n");
    
    sb.append("    nodeRuleGroup: ").append(toIndentedString(nodeRuleGroup)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    aggregatedNodeEdgePoint: ").append(toIndentedString(aggregatedNodeEdgePoint)).append("\n");
    sb.append("    ownedNodeEdgePoint: ").append(toIndentedString(ownedNodeEdgePoint)).append("\n");
    sb.append("    encapTopology: ").append(toIndentedString(encapTopology)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
