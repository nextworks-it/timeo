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
import io.swagger.client.model.NodeEdgePointRef;
import java.io.IOException;

/**
 * ConnectionEndPointRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class ConnectionEndPointRef {
  @SerializedName("topology-uuid")
  private String topologyUuid = null;

  @SerializedName("node-uuid")
  private String nodeUuid = null;

  @SerializedName("node-edge-point-uuid")
  private String nodeEdgePointUuid = null;

  @SerializedName("connection-end-point-uuid")
  private String connectionEndPointUuid = null;

  public ConnectionEndPointRef topologyUuid(String topologyUuid) {
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

  public ConnectionEndPointRef nodeUuid(String nodeUuid) {
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

  public ConnectionEndPointRef nodeEdgePointUuid(String nodeEdgePointUuid) {
    this.nodeEdgePointUuid = nodeEdgePointUuid;
    return this;
  }

   /**
   * Get nodeEdgePointUuid
   * @return nodeEdgePointUuid
  **/
  @ApiModelProperty(value = "")
  public String getNodeEdgePointUuid() {
    return nodeEdgePointUuid;
  }

  public void setNodeEdgePointUuid(String nodeEdgePointUuid) {
    this.nodeEdgePointUuid = nodeEdgePointUuid;
  }

  public ConnectionEndPointRef connectionEndPointUuid(String connectionEndPointUuid) {
    this.connectionEndPointUuid = connectionEndPointUuid;
    return this;
  }

   /**
   * Get connectionEndPointUuid
   * @return connectionEndPointUuid
  **/
  @ApiModelProperty(value = "")
  public String getConnectionEndPointUuid() {
    return connectionEndPointUuid;
  }

  public void setConnectionEndPointUuid(String connectionEndPointUuid) {
    this.connectionEndPointUuid = connectionEndPointUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionEndPointRef connectionEndPointRef = (ConnectionEndPointRef) o;
    return Objects.equals(this.topologyUuid, connectionEndPointRef.topologyUuid) &&
        Objects.equals(this.nodeUuid, connectionEndPointRef.nodeUuid) &&
        Objects.equals(this.nodeEdgePointUuid, connectionEndPointRef.nodeEdgePointUuid) &&
        Objects.equals(this.connectionEndPointUuid, connectionEndPointRef.connectionEndPointUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topologyUuid, nodeUuid, nodeEdgePointUuid, connectionEndPointUuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionEndPointRef {\n");
    
    sb.append("    topologyUuid: ").append(toIndentedString(topologyUuid)).append("\n");
    sb.append("    nodeUuid: ").append(toIndentedString(nodeUuid)).append("\n");
    sb.append("    nodeEdgePointUuid: ").append(toIndentedString(nodeEdgePointUuid)).append("\n");
    sb.append("    connectionEndPointUuid: ").append(toIndentedString(connectionEndPointUuid)).append("\n");
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

