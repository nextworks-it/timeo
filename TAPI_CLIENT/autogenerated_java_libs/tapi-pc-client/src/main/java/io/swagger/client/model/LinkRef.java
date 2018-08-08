/*
 * tapi-path-computation API
 * tapi-path-computation API generated from tapi-path-computation@2018-03-07.yang
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
import io.swagger.client.model.TopologyRef;
import java.io.IOException;

/**
 * LinkRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:55.433+02:00")
public class LinkRef {
  @SerializedName("topology-id")
  private String topologyId = null;

  @SerializedName("link-id")
  private String linkId = null;

  public LinkRef topologyId(String topologyId) {
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

  public LinkRef linkId(String linkId) {
    this.linkId = linkId;
    return this;
  }

   /**
   * Get linkId
   * @return linkId
  **/
  @ApiModelProperty(value = "")
  public String getLinkId() {
    return linkId;
  }

  public void setLinkId(String linkId) {
    this.linkId = linkId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkRef linkRef = (LinkRef) o;
    return Objects.equals(this.topologyId, linkRef.topologyId) &&
        Objects.equals(this.linkId, linkRef.linkId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyId, linkId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LinkRef {\n");
    
    sb.append("    topologyId: ").append(toIndentedString(topologyId)).append("\n");
    sb.append("    linkId: ").append(toIndentedString(linkId)).append("\n");
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

