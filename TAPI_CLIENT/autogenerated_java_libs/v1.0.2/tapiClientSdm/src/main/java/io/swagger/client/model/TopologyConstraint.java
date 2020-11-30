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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TopologyConstraint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class TopologyConstraint {
  @SerializedName("exclude-node")
  private List<String> excludeNode = null;

  @SerializedName("include-node")
  private List<String> includeNode = null;

  @SerializedName("include-path")
  private List<String> includePath = null;

  @SerializedName("include-link")
  private List<String> includeLink = null;

  @SerializedName("exclude-path")
  private List<String> excludePath = null;

  @SerializedName("exclude-link")
  private List<String> excludeLink = null;

  @SerializedName("preferred-transport-layer")
  private List<String> preferredTransportLayer = null;

  @SerializedName("avoid-topology")
  private List<String> avoidTopology = null;

  @SerializedName("include-topology")
  private List<String> includeTopology = null;

  public TopologyConstraint excludeNode(List<String> excludeNode) {
    this.excludeNode = excludeNode;
    return this;
  }

  public TopologyConstraint addExcludeNodeItem(String excludeNodeItem) {
    if (this.excludeNode == null) {
      this.excludeNode = new ArrayList<String>();
    }
    this.excludeNode.add(excludeNodeItem);
    return this;
  }

   /**
   * Get excludeNode
   * @return excludeNode
  **/
  @ApiModelProperty(value = "")
  public List<String> getExcludeNode() {
    return excludeNode;
  }

  public void setExcludeNode(List<String> excludeNode) {
    this.excludeNode = excludeNode;
  }

  public TopologyConstraint includeNode(List<String> includeNode) {
    this.includeNode = includeNode;
    return this;
  }

  public TopologyConstraint addIncludeNodeItem(String includeNodeItem) {
    if (this.includeNode == null) {
      this.includeNode = new ArrayList<String>();
    }
    this.includeNode.add(includeNodeItem);
    return this;
  }

   /**
   * Get includeNode
   * @return includeNode
  **/
  @ApiModelProperty(value = "")
  public List<String> getIncludeNode() {
    return includeNode;
  }

  public void setIncludeNode(List<String> includeNode) {
    this.includeNode = includeNode;
  }

  public TopologyConstraint includePath(List<String> includePath) {
    this.includePath = includePath;
    return this;
  }

  public TopologyConstraint addIncludePathItem(String includePathItem) {
    if (this.includePath == null) {
      this.includePath = new ArrayList<String>();
    }
    this.includePath.add(includePathItem);
    return this;
  }

   /**
   * Get includePath
   * @return includePath
  **/
  @ApiModelProperty(value = "")
  public List<String> getIncludePath() {
    return includePath;
  }

  public void setIncludePath(List<String> includePath) {
    this.includePath = includePath;
  }

  public TopologyConstraint includeLink(List<String> includeLink) {
    this.includeLink = includeLink;
    return this;
  }

  public TopologyConstraint addIncludeLinkItem(String includeLinkItem) {
    if (this.includeLink == null) {
      this.includeLink = new ArrayList<String>();
    }
    this.includeLink.add(includeLinkItem);
    return this;
  }

   /**
   * Get includeLink
   * @return includeLink
  **/
  @ApiModelProperty(value = "")
  public List<String> getIncludeLink() {
    return includeLink;
  }

  public void setIncludeLink(List<String> includeLink) {
    this.includeLink = includeLink;
  }

  public TopologyConstraint excludePath(List<String> excludePath) {
    this.excludePath = excludePath;
    return this;
  }

  public TopologyConstraint addExcludePathItem(String excludePathItem) {
    if (this.excludePath == null) {
      this.excludePath = new ArrayList<String>();
    }
    this.excludePath.add(excludePathItem);
    return this;
  }

   /**
   * Get excludePath
   * @return excludePath
  **/
  @ApiModelProperty(value = "")
  public List<String> getExcludePath() {
    return excludePath;
  }

  public void setExcludePath(List<String> excludePath) {
    this.excludePath = excludePath;
  }

  public TopologyConstraint excludeLink(List<String> excludeLink) {
    this.excludeLink = excludeLink;
    return this;
  }

  public TopologyConstraint addExcludeLinkItem(String excludeLinkItem) {
    if (this.excludeLink == null) {
      this.excludeLink = new ArrayList<String>();
    }
    this.excludeLink.add(excludeLinkItem);
    return this;
  }

   /**
   * Get excludeLink
   * @return excludeLink
  **/
  @ApiModelProperty(value = "")
  public List<String> getExcludeLink() {
    return excludeLink;
  }

  public void setExcludeLink(List<String> excludeLink) {
    this.excludeLink = excludeLink;
  }

  public TopologyConstraint preferredTransportLayer(List<String> preferredTransportLayer) {
    this.preferredTransportLayer = preferredTransportLayer;
    return this;
  }

  public TopologyConstraint addPreferredTransportLayerItem(String preferredTransportLayerItem) {
    if (this.preferredTransportLayer == null) {
      this.preferredTransportLayer = new ArrayList<String>();
    }
    this.preferredTransportLayer.add(preferredTransportLayerItem);
    return this;
  }

   /**
   * Get preferredTransportLayer
   * @return preferredTransportLayer
  **/
  @ApiModelProperty(value = "")
  public List<String> getPreferredTransportLayer() {
    return preferredTransportLayer;
  }

  public void setPreferredTransportLayer(List<String> preferredTransportLayer) {
    this.preferredTransportLayer = preferredTransportLayer;
  }

  public TopologyConstraint avoidTopology(List<String> avoidTopology) {
    this.avoidTopology = avoidTopology;
    return this;
  }

  public TopologyConstraint addAvoidTopologyItem(String avoidTopologyItem) {
    if (this.avoidTopology == null) {
      this.avoidTopology = new ArrayList<String>();
    }
    this.avoidTopology.add(avoidTopologyItem);
    return this;
  }

   /**
   * Get avoidTopology
   * @return avoidTopology
  **/
  @ApiModelProperty(value = "")
  public List<String> getAvoidTopology() {
    return avoidTopology;
  }

  public void setAvoidTopology(List<String> avoidTopology) {
    this.avoidTopology = avoidTopology;
  }

  public TopologyConstraint includeTopology(List<String> includeTopology) {
    this.includeTopology = includeTopology;
    return this;
  }

  public TopologyConstraint addIncludeTopologyItem(String includeTopologyItem) {
    if (this.includeTopology == null) {
      this.includeTopology = new ArrayList<String>();
    }
    this.includeTopology.add(includeTopologyItem);
    return this;
  }

   /**
   * Get includeTopology
   * @return includeTopology
  **/
  @ApiModelProperty(value = "")
  public List<String> getIncludeTopology() {
    return includeTopology;
  }

  public void setIncludeTopology(List<String> includeTopology) {
    this.includeTopology = includeTopology;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopologyConstraint topologyConstraint = (TopologyConstraint) o;
    return Objects.equals(this.excludeNode, topologyConstraint.excludeNode) &&
        Objects.equals(this.includeNode, topologyConstraint.includeNode) &&
        Objects.equals(this.includePath, topologyConstraint.includePath) &&
        Objects.equals(this.includeLink, topologyConstraint.includeLink) &&
        Objects.equals(this.excludePath, topologyConstraint.excludePath) &&
        Objects.equals(this.excludeLink, topologyConstraint.excludeLink) &&
        Objects.equals(this.preferredTransportLayer, topologyConstraint.preferredTransportLayer) &&
        Objects.equals(this.avoidTopology, topologyConstraint.avoidTopology) &&
        Objects.equals(this.includeTopology, topologyConstraint.includeTopology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(excludeNode, includeNode, includePath, includeLink, excludePath, excludeLink, preferredTransportLayer, avoidTopology, includeTopology);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopologyConstraint {\n");
    
    sb.append("    excludeNode: ").append(toIndentedString(excludeNode)).append("\n");
    sb.append("    includeNode: ").append(toIndentedString(includeNode)).append("\n");
    sb.append("    includePath: ").append(toIndentedString(includePath)).append("\n");
    sb.append("    includeLink: ").append(toIndentedString(includeLink)).append("\n");
    sb.append("    excludePath: ").append(toIndentedString(excludePath)).append("\n");
    sb.append("    excludeLink: ").append(toIndentedString(excludeLink)).append("\n");
    sb.append("    preferredTransportLayer: ").append(toIndentedString(preferredTransportLayer)).append("\n");
    sb.append("    avoidTopology: ").append(toIndentedString(avoidTopology)).append("\n");
    sb.append("    includeTopology: ").append(toIndentedString(includeTopology)).append("\n");
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

