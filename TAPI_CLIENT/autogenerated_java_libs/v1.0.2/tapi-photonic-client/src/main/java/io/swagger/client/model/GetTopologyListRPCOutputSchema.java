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
import io.swagger.client.model.Topology;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * GetTopologyListRPCOutputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class GetTopologyListRPCOutputSchema {
  @SerializedName("topology")
  private List<Topology> topology = null;

  public GetTopologyListRPCOutputSchema topology(List<Topology> topology) {
    this.topology = topology;
    return this;
  }

  public GetTopologyListRPCOutputSchema addTopologyItem(Topology topologyItem) {
    if (this.topology == null) {
      this.topology = new ArrayList<Topology>();
    }
    this.topology.add(topologyItem);
    return this;
  }

   /**
   * Get topology
   * @return topology
  **/
  @ApiModelProperty(value = "")
  public List<Topology> getTopology() {
    return topology;
  }

  public void setTopology(List<Topology> topology) {
    this.topology = topology;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTopologyListRPCOutputSchema getTopologyListRPCOutputSchema = (GetTopologyListRPCOutputSchema) o;
    return Objects.equals(this.topology, getTopologyListRPCOutputSchema.topology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topology);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTopologyListRPCOutputSchema {\n");
    
    sb.append("    topology: ").append(toIndentedString(topology)).append("\n");
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

