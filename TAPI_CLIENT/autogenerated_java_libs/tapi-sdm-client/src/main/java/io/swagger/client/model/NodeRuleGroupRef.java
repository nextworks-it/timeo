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
import io.swagger.client.model.NodeRef;
import java.io.IOException;

/**
 * NodeRuleGroupRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class NodeRuleGroupRef {
  @SerializedName("topology-id")
  private String topologyId = null;

  @SerializedName("node-id")
  private String nodeId = null;

  @SerializedName("node-rule-group-id")
  private String nodeRuleGroupId = null;

  public NodeRuleGroupRef topologyId(String topologyId) {
    this.topologyId = topologyId;
    return this;
  }

   /**
   * Get topologyId
   * @return topologyId
  **/
  @ApiModelProperty(value = "")
  public String getTopologyId() {
    return topologyId;
  }

  public void setTopologyId(String topologyId) {
    this.topologyId = topologyId;
  }

  public NodeRuleGroupRef nodeId(String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

   /**
   * Get nodeId
   * @return nodeId
  **/
  @ApiModelProperty(value = "")
  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public NodeRuleGroupRef nodeRuleGroupId(String nodeRuleGroupId) {
    this.nodeRuleGroupId = nodeRuleGroupId;
    return this;
  }

   /**
   * Get nodeRuleGroupId
   * @return nodeRuleGroupId
  **/
  @ApiModelProperty(value = "")
  public String getNodeRuleGroupId() {
    return nodeRuleGroupId;
  }

  public void setNodeRuleGroupId(String nodeRuleGroupId) {
    this.nodeRuleGroupId = nodeRuleGroupId;
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
    return Objects.equals(this.topologyId, nodeRuleGroupRef.topologyId) &&
        Objects.equals(this.nodeId, nodeRuleGroupRef.nodeId) &&
        Objects.equals(this.nodeRuleGroupId, nodeRuleGroupRef.nodeRuleGroupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyId, nodeId, nodeRuleGroupId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeRuleGroupRef {\n");
    
    sb.append("    topologyId: ").append(toIndentedString(topologyId)).append("\n");
    sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
    sb.append("    nodeRuleGroupId: ").append(toIndentedString(nodeRuleGroupId)).append("\n");
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

