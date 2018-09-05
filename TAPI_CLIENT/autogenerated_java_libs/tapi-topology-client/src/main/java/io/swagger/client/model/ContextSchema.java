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
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NetworkTopologyService;
import io.swagger.client.model.ServiceInterfacePoint;
import io.swagger.client.model.TapiContext;
import io.swagger.client.model.Topology;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ContextSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:55:18.533+02:00")
public class ContextSchema {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  @SerializedName("service-interface-point")
  private List<ServiceInterfacePoint> serviceInterfacePoint = null;

  @SerializedName("nw-topology-service")
  private NetworkTopologyService nwTopologyService = null;

  @SerializedName("topology")
  private List<Topology> topology = null;

  public ContextSchema uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-&#39; + &#39;[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6
   * @return uuid
  **/
  @ApiModelProperty(value = "UUID: An identifier that is universally unique within an identifier space, where the identifier space is itself globally unique, and immutable. An UUID carries no semantics with respect to the purpose or state of the entity. UUID here uses string representation as defined in RFC 4122.  The canonical representation uses lowercase characters. Pattern: [0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-' + '[0-9a-fA-F]{4}-[0-9a-fA-F]{12} Example of a UUID in string representation: f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public ContextSchema name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public ContextSchema addNameItem(NameAndValue nameItem) {
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

  public ContextSchema serviceInterfacePoint(List<ServiceInterfacePoint> serviceInterfacePoint) {
    this.serviceInterfacePoint = serviceInterfacePoint;
    return this;
  }

  public ContextSchema addServiceInterfacePointItem(ServiceInterfacePoint serviceInterfacePointItem) {
    if (this.serviceInterfacePoint == null) {
      this.serviceInterfacePoint = new ArrayList<ServiceInterfacePoint>();
    }
    this.serviceInterfacePoint.add(serviceInterfacePointItem);
    return this;
  }

   /**
   * Get serviceInterfacePoint
   * @return serviceInterfacePoint
  **/
  @ApiModelProperty(value = "")
  public List<ServiceInterfacePoint> getServiceInterfacePoint() {
    return serviceInterfacePoint;
  }

  public void setServiceInterfacePoint(List<ServiceInterfacePoint> serviceInterfacePoint) {
    this.serviceInterfacePoint = serviceInterfacePoint;
  }

  public ContextSchema nwTopologyService(NetworkTopologyService nwTopologyService) {
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

  public ContextSchema topology(List<Topology> topology) {
    this.topology = topology;
    return this;
  }

  public ContextSchema addTopologyItem(Topology topologyItem) {
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
    ContextSchema contextSchema = (ContextSchema) o;
    return Objects.equals(this.uuid, contextSchema.uuid) &&
        Objects.equals(this.name, contextSchema.name) &&
        Objects.equals(this.serviceInterfacePoint, contextSchema.serviceInterfacePoint) &&
        Objects.equals(this.nwTopologyService, contextSchema.nwTopologyService) &&
        Objects.equals(this.topology, contextSchema.topology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, serviceInterfacePoint, nwTopologyService, topology);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextSchema {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceInterfacePoint: ").append(toIndentedString(serviceInterfacePoint)).append("\n");
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

