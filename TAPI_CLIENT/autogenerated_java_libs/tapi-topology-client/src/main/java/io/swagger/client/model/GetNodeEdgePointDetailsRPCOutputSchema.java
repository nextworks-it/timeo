/*
 * tapi-topology API
 * tapi-topology API generated from tapi-topology@2018-03-07.yang
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
import io.swagger.client.model.NodeEdgePoint;
import java.io.IOException;

/**
 * GetNodeEdgePointDetailsRPCOutputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:55:18.533+02:00")
public class GetNodeEdgePointDetailsRPCOutputSchema {
  @SerializedName("node-edge-point")
  private NodeEdgePoint nodeEdgePoint = null;

  public GetNodeEdgePointDetailsRPCOutputSchema nodeEdgePoint(NodeEdgePoint nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
    return this;
  }

   /**
   * Get nodeEdgePoint
   * @return nodeEdgePoint
  **/
  @ApiModelProperty(value = "")
  public NodeEdgePoint getNodeEdgePoint() {
    return nodeEdgePoint;
  }

  public void setNodeEdgePoint(NodeEdgePoint nodeEdgePoint) {
    this.nodeEdgePoint = nodeEdgePoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNodeEdgePointDetailsRPCOutputSchema getNodeEdgePointDetailsRPCOutputSchema = (GetNodeEdgePointDetailsRPCOutputSchema) o;
    return Objects.equals(this.nodeEdgePoint, getNodeEdgePointDetailsRPCOutputSchema.nodeEdgePoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeEdgePoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNodeEdgePointDetailsRPCOutputSchema {\n");
    
    sb.append("    nodeEdgePoint: ").append(toIndentedString(nodeEdgePoint)).append("\n");
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

