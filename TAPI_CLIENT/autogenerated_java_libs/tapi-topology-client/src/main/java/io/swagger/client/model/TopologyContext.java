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
import io.swagger.client.model.NetworkTopologyService;
import io.swagger.client.model.Topology;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TopologyContext
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:55:18.533+02:00")
public class TopologyContext {
  @SerializedName("nw-topology-service")
  private NetworkTopologyService nwTopologyService = null;

  @SerializedName("topology")
  private List<Topology> topology = null;

  public TopologyContext nwTopologyService(NetworkTopologyService nwTopologyService) {
    this.nwTopologyService = nwTopologyService;
    return this;
  }

   /**
   * Get nwTopologyService
   * @return nwTopologyService
  **/
  @ApiModelProperty(value = "")
  public NetworkTopologyService getNwTopologyService() {
    return nwTopologyService;
  }

  public void setNwTopologyService(NetworkTopologyService nwTopologyService) {
    this.nwTopologyService = nwTopologyService;
  }

  public TopologyContext topology(List<Topology> topology) {
    this.topology = topology;
    return this;
  }

  public TopologyContext addTopologyItem(Topology topologyItem) {
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
    TopologyContext topologyContext = (TopologyContext) o;
    return Objects.equals(this.nwTopologyService, topologyContext.nwTopologyService) &&
        Objects.equals(this.topology, topologyContext.topology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nwTopologyService, topology);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopologyContext {\n");
    
    sb.append("    nwTopologyService: ").append(toIndentedString(nwTopologyService)).append("\n");
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

