/**
 * tapi-topology API
 * tapi-topology API generated from tapi-topology@2018-12-10.yang
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
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityPac;
import io.swagger.client.model.CostCharacteristic;
import io.swagger.client.model.InterRuleGroup;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NodeEdgePointRef;
import io.swagger.client.model.NodeRuleGroupRef;
import io.swagger.client.model.ResourceSpec;
import io.swagger.client.model.RiskCharacteristic;
import io.swagger.client.model.RiskParameterPac;
import io.swagger.client.model.Rule;
import io.swagger.client.model.TransferCostPac;
import io.swagger.client.model.TransferTimingPac;
import java.util.ArrayList;
import java.util.List;


/**
 * NodeRuleGroup
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-08T14:35:49.260+02:00")
public class NodeRuleGroup   {
  @SerializedName("node-edge-point")
  private List<NodeEdgePointRef> nodeEdgePoint = new ArrayList<NodeEdgePointRef>();

  @SerializedName("composed-rule-group")
  private List<NodeRuleGroupRef> composedRuleGroup = new ArrayList<NodeRuleGroupRef>();

  @SerializedName("rule")
  private List<Rule> rule = new ArrayList<Rule>();

  @SerializedName("inter-rule-group")
  private List<InterRuleGroup> interRuleGroup = new ArrayList<InterRuleGroup>();

  public NodeRuleGroup nodeEdgePoint(List<NodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

  public NodeRuleGroup addNodeEdgePointItem(NodeEdgePointRef nodeEdgePointItem) {
    this.nodeEdgePoint.add(nodeEdgePointItem);
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<NodeEdgePointRef> getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(List<NodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }

  public NodeRuleGroup composedRuleGroup(List<NodeRuleGroupRef> composedRuleGroup) {
    this.composedRuleGroup = composedRuleGroup;
    return this;
  }

  public NodeRuleGroup addComposedRuleGroupItem(NodeRuleGroupRef composedRuleGroupItem) {
    this.composedRuleGroup.add(composedRuleGroupItem);
    return this;
  }

   /**
   * Get composedRuleGroup
   * @return composedRuleGroup
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<NodeRuleGroupRef> getComposedRuleGroup() {
    return composedRuleGroup;
  }

  public void setComposedRuleGroup(List<NodeRuleGroupRef> composedRuleGroup) {
    this.composedRuleGroup = composedRuleGroup;
  }

  public NodeRuleGroup rule(List<Rule> rule) {
    this.rule = rule;
    return this;
  }

  public NodeRuleGroup addRuleItem(Rule ruleItem) {
    this.rule.add(ruleItem);
    return this;
  }

   /**
   * Get rule
   * @return rule
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Rule> getRule() {
    return rule;
  }

  public void setRule(List<Rule> rule) {
    this.rule = rule;
  }

  public NodeRuleGroup interRuleGroup(List<InterRuleGroup> interRuleGroup) {
    this.interRuleGroup = interRuleGroup;
    return this;
  }

  public NodeRuleGroup addInterRuleGroupItem(InterRuleGroup interRuleGroupItem) {
    this.interRuleGroup.add(interRuleGroupItem);
    return this;
  }

   /**
   * Get interRuleGroup
   * @return interRuleGroup
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<InterRuleGroup> getInterRuleGroup() {
    return interRuleGroup;
  }

  public void setInterRuleGroup(List<InterRuleGroup> interRuleGroup) {
    this.interRuleGroup = interRuleGroup;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeRuleGroup nodeRuleGroup = (NodeRuleGroup) o;
    return Objects.equals(this.nodeEdgePoint, nodeRuleGroup.nodeEdgePoint) &&
        Objects.equals(this.composedRuleGroup, nodeRuleGroup.composedRuleGroup) &&
        Objects.equals(this.rule, nodeRuleGroup.rule) &&
        Objects.equals(this.interRuleGroup, nodeRuleGroup.interRuleGroup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeEdgePoint, composedRuleGroup, rule, interRuleGroup);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRuleGroup {\n");
    
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
    sb.append("    composedRuleGroup: ").append(toIndentedString(composedRuleGroup)).append("\n");
    sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
    sb.append("    interRuleGroup: ").append(toIndentedString(interRuleGroup)).append("\n");
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

