/*
 * tapi-photonic-media API
 * tapi-photonic-media API generated from tapi-photonic-media@2018-12-10.yang
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
import io.swagger.client.model.NodeRef;
import java.io.IOException;

/**
 * NodeRuleGroupRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class NodeRuleGroupRef {
  @SerializedName("topology-uuid")
  private String topologyUuid = null;

  @SerializedName("node-uuid")
  private String nodeUuid = null;

  @SerializedName("node-rule-group-uuid")
  private String nodeRuleGroupUuid = null;

  public NodeRuleGroupRef topologyUuid(String topologyUuid) {
    this.topologyUuid = topologyUuid;
    return this;
  }

   /**
   * Get topologyUuid
   * @return topologyUuid
  **/
  @ApiModelProperty(value = "")
  public String getTopologyUuid() {
    return topologyUuid;
  }

  public void setTopologyUuid(String topologyUuid) {
    this.topologyUuid = topologyUuid;
  }

  public NodeRuleGroupRef nodeUuid(String nodeUuid) {
    this.nodeUuid = nodeUuid;
    return this;
  }

   /**
   * Get nodeUuid
   * @return nodeUuid
  **/
  @ApiModelProperty(value = "")
  public String getNodeUuid() {
    return nodeUuid;
  }

  public void setNodeUuid(String nodeUuid) {
    this.nodeUuid = nodeUuid;
  }

  public NodeRuleGroupRef nodeRuleGroupUuid(String nodeRuleGroupUuid) {
    this.nodeRuleGroupUuid = nodeRuleGroupUuid;
    return this;
  }

   /**
   * Get nodeRuleGroupUuid
   * @return nodeRuleGroupUuid
  **/
  @ApiModelProperty(value = "")
  public String getNodeRuleGroupUuid() {
    return nodeRuleGroupUuid;
  }

  public void setNodeRuleGroupUuid(String nodeRuleGroupUuid) {
    this.nodeRuleGroupUuid = nodeRuleGroupUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeRuleGroupRef nodeRuleGroupRef = (NodeRuleGroupRef) o;
    return Objects.equals(this.topologyUuid, nodeRuleGroupRef.topologyUuid) &&
        Objects.equals(this.nodeUuid, nodeRuleGroupRef.nodeUuid) &&
        Objects.equals(this.nodeRuleGroupUuid, nodeRuleGroupRef.nodeRuleGroupUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyUuid, nodeUuid, nodeRuleGroupUuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRuleGroupRef {\n");
    
    sb.append("    topologyUuid: ").append(toIndentedString(topologyUuid)).append("\n");
    sb.append("    nodeUuid: ").append(toIndentedString(nodeUuid)).append("\n");
    sb.append("    nodeRuleGroupUuid: ").append(toIndentedString(nodeRuleGroupUuid)).append("\n");
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
