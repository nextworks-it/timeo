/*
 * tapi-sdm API
 * tapi-sdm API generated from tapi-sdm.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.CapacityPac;
import io.swagger.client.model.CostCharacteristic;
import io.swagger.client.model.InterRuleGroup;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NodeRuleGroupRef;
import io.swagger.client.model.OwnedNodeEdgePointRef;
import io.swagger.client.model.ResourceSpec;
import io.swagger.client.model.RiskCharacteristic;
import io.swagger.client.model.RiskParameterPac;
import io.swagger.client.model.Rule;
import io.swagger.client.model.TransferCostPac;
import io.swagger.client.model.TransferTimingPac;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * NodeRuleGroup
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class NodeRuleGroup {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  @SerializedName("available-capacity")
  private Capacity availableCapacity = null;

  @SerializedName("total-potential-capacity")
  private Capacity totalPotentialCapacity = null;

  @SerializedName("cost-characteristic")
  private List<CostCharacteristic> costCharacteristic = null;

  @SerializedName("latency-characteristic")
  private List<LatencyCharacteristic> latencyCharacteristic = null;

  @SerializedName("risk-characteristic")
  private List<RiskCharacteristic> riskCharacteristic = null;

  @SerializedName("node-edge-point")
  private List<OwnedNodeEdgePointRef> nodeEdgePoint = null;

  @SerializedName("composed-rule-group")
  private List<NodeRuleGroupRef> composedRuleGroup = null;

  @SerializedName("rule")
  private List<Rule> rule = null;

  @SerializedName("inter-rule-group")
  private List<InterRuleGroup> interRuleGroup = null;

  public NodeRuleGroup uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6
   * @return uuid
  **/
  @ApiModelProperty(value = "UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-' + '[0-9a-fA-F]{4}-[0-9a-fA-F]{12}  Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public NodeRuleGroup name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public NodeRuleGroup addNameItem(NameAndValue nameItem) {
    if (this.name == null) {
      this.name = new ArrayList<NameAndValue>();
    }
    this.name.add(nameItem);
    return this;
  }

   /**
   * List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.
   * @return name
  **/
  @ApiModelProperty(value = "List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.")
  public List<NameAndValue> getName() {
    return name;
  }

  public void setName(List<NameAndValue> name) {
    this.name = name;
  }

  public NodeRuleGroup availableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

   /**
   * Capacity available to be assigned.
   * @return availableCapacity
  **/
  @ApiModelProperty(value = "Capacity available to be assigned.")
  public Capacity getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(Capacity availableCapacity) {
    this.availableCapacity = availableCapacity;
  }

  public NodeRuleGroup totalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
    return this;
  }

   /**
   * An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.
   * @return totalPotentialCapacity
  **/
  @ApiModelProperty(value = "An optimistic view of the capacity of the TopologicalEntity assuming that any shared capacity is available to be taken.")
  public Capacity getTotalPotentialCapacity() {
    return totalPotentialCapacity;
  }

  public void setTotalPotentialCapacity(Capacity totalPotentialCapacity) {
    this.totalPotentialCapacity = totalPotentialCapacity;
  }

  public NodeRuleGroup costCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
    return this;
  }

  public NodeRuleGroup addCostCharacteristicItem(CostCharacteristic costCharacteristicItem) {
    if (this.costCharacteristic == null) {
      this.costCharacteristic = new ArrayList<CostCharacteristic>();
    }
    this.costCharacteristic.add(costCharacteristicItem);
    return this;
  }

   /**
   * The list of costs where each cost relates to some aspect of the TopologicalEntity.
   * @return costCharacteristic
  **/
  @ApiModelProperty(value = "The list of costs where each cost relates to some aspect of the TopologicalEntity.")
  public List<CostCharacteristic> getCostCharacteristic() {
    return costCharacteristic;
  }

  public void setCostCharacteristic(List<CostCharacteristic> costCharacteristic) {
    this.costCharacteristic = costCharacteristic;
  }

  public NodeRuleGroup latencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
    return this;
  }

  public NodeRuleGroup addLatencyCharacteristicItem(LatencyCharacteristic latencyCharacteristicItem) {
    if (this.latencyCharacteristic == null) {
      this.latencyCharacteristic = new ArrayList<LatencyCharacteristic>();
    }
    this.latencyCharacteristic.add(latencyCharacteristicItem);
    return this;
  }

   /**
   * The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.
   * @return latencyCharacteristic
  **/
  @ApiModelProperty(value = "The effect on the latency of a queuing process. This only has significant effect for packet based systems and has a complex characteristic.")
  public List<LatencyCharacteristic> getLatencyCharacteristic() {
    return latencyCharacteristic;
  }

  public void setLatencyCharacteristic(List<LatencyCharacteristic> latencyCharacteristic) {
    this.latencyCharacteristic = latencyCharacteristic;
  }

  public NodeRuleGroup riskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
    return this;
  }

  public NodeRuleGroup addRiskCharacteristicItem(RiskCharacteristic riskCharacteristicItem) {
    if (this.riskCharacteristic == null) {
      this.riskCharacteristic = new ArrayList<RiskCharacteristic>();
    }
    this.riskCharacteristic.add(riskCharacteristicItem);
    return this;
  }

   /**
   * A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.
   * @return riskCharacteristic
  **/
  @ApiModelProperty(value = "A list of risk characteristics for consideration in an analysis of shared risk. Each element of the list represents a specific risk consideration.")
  public List<RiskCharacteristic> getRiskCharacteristic() {
    return riskCharacteristic;
  }

  public void setRiskCharacteristic(List<RiskCharacteristic> riskCharacteristic) {
    this.riskCharacteristic = riskCharacteristic;
  }

  public NodeRuleGroup nodeEdgePoint(List<OwnedNodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

  public NodeRuleGroup addNodeEdgePointItem(OwnedNodeEdgePointRef nodeEdgePointItem) {
    if (this.nodeEdgePoint == null) {
      this.nodeEdgePoint = new ArrayList<OwnedNodeEdgePointRef>();
    }
    this.nodeEdgePoint.add(nodeEdgePointItem);
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public List<OwnedNodeEdgePointRef> getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(List<OwnedNodeEdgePointRef> nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }

  public NodeRuleGroup composedRuleGroup(List<NodeRuleGroupRef> composedRuleGroup) {
    this.composedRuleGroup = composedRuleGroup;
    return this;
  }

  public NodeRuleGroup addComposedRuleGroupItem(NodeRuleGroupRef composedRuleGroupItem) {
    if (this.composedRuleGroup == null) {
      this.composedRuleGroup = new ArrayList<NodeRuleGroupRef>();
    }
    this.composedRuleGroup.add(composedRuleGroupItem);
    return this;
  }

   /**
   * Get composedRuleGroup
   * @return composedRuleGroup
  **/
  @ApiModelProperty(value = "")
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
    if (this.rule == null) {
      this.rule = new ArrayList<Rule>();
    }
    this.rule.add(ruleItem);
    return this;
  }

   /**
   * Get rule
   * @return rule
  **/
  @ApiModelProperty(value = "")
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
    if (this.interRuleGroup == null) {
      this.interRuleGroup = new ArrayList<InterRuleGroup>();
    }
    this.interRuleGroup.add(interRuleGroupItem);
    return this;
  }

   /**
   * Get interRuleGroup
   * @return interRuleGroup
  **/
  @ApiModelProperty(value = "")
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
    return Objects.equals(this.uuid, nodeRuleGroup.uuid) &&
        Objects.equals(this.name, nodeRuleGroup.name) &&
        Objects.equals(this.availableCapacity, nodeRuleGroup.availableCapacity) &&
        Objects.equals(this.totalPotentialCapacity, nodeRuleGroup.totalPotentialCapacity) &&
        Objects.equals(this.costCharacteristic, nodeRuleGroup.costCharacteristic) &&
        Objects.equals(this.latencyCharacteristic, nodeRuleGroup.latencyCharacteristic) &&
        Objects.equals(this.riskCharacteristic, nodeRuleGroup.riskCharacteristic) &&
        Objects.equals(this.nodeEdgePoint, nodeRuleGroup.nodeEdgePoint) &&
        Objects.equals(this.composedRuleGroup, nodeRuleGroup.composedRuleGroup) &&
        Objects.equals(this.rule, nodeRuleGroup.rule) &&
        Objects.equals(this.interRuleGroup, nodeRuleGroup.interRuleGroup);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, availableCapacity, totalPotentialCapacity, costCharacteristic, latencyCharacteristic, riskCharacteristic, nodeEdgePoint, composedRuleGroup, rule, interRuleGroup);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRuleGroup {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
    sb.append("    totalPotentialCapacity: ").append(toIndentedString(totalPotentialCapacity)).append("\n");
    sb.append("    costCharacteristic: ").append(toIndentedString(costCharacteristic)).append("\n");
    sb.append("    latencyCharacteristic: ").append(toIndentedString(latencyCharacteristic)).append("\n");
    sb.append("    riskCharacteristic: ").append(toIndentedString(riskCharacteristic)).append("\n");
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

