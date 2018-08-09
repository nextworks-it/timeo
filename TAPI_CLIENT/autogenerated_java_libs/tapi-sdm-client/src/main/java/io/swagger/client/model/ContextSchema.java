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
import io.swagger.client.model.Connection;
import io.swagger.client.model.ConnectivityService;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NetworkTopologyService;
import io.swagger.client.model.Path;
import io.swagger.client.model.PathComputationService;
import io.swagger.client.model.ServiceInterfacePoint;
import io.swagger.client.model.TapiContext;
import io.swagger.client.model.Topology;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ContextSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class ContextSchema {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  @SerializedName("service-interface-point")
  private List<ServiceInterfacePoint> serviceInterfacePoint = null;

  @SerializedName("path-comp-service")
  private List<PathComputationService> pathCompService = null;

  @SerializedName("connection")
  private List<Connection> connection = null;

  @SerializedName("connectivity-service")
  private List<ConnectivityService> connectivityService = null;

  @SerializedName("nw-topology-service")
  private NetworkTopologyService nwTopologyService = null;

  @SerializedName("path")
  private List<Path> path = null;

  @SerializedName("topology")
  private List<Topology> topology = null;

  public ContextSchema uuid(String uuid) {
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

  public ContextSchema pathCompService(List<PathComputationService> pathCompService) {
    this.pathCompService = pathCompService;
    return this;
  }

  public ContextSchema addPathCompServiceItem(PathComputationService pathCompServiceItem) {
    if (this.pathCompService == null) {
      this.pathCompService = new ArrayList<PathComputationService>();
    }
    this.pathCompService.add(pathCompServiceItem);
    return this;
  }

   /**
   * Get pathCompService
   * @return pathCompService
  **/
  @ApiModelProperty(value = "")
  public List<PathComputationService> getPathCompService() {
    return pathCompService;
  }

  public void setPathCompService(List<PathComputationService> pathCompService) {
    this.pathCompService = pathCompService;
  }

  public ContextSchema connection(List<Connection> connection) {
    this.connection = connection;
    return this;
  }

  public ContextSchema addConnectionItem(Connection connectionItem) {
    if (this.connection == null) {
      this.connection = new ArrayList<Connection>();
    }
    this.connection.add(connectionItem);
    return this;
  }

   /**
   * Get connection
   * @return connection
  **/
  @ApiModelProperty(value = "")
  public List<Connection> getConnection() {
    return connection;
  }

  public void setConnection(List<Connection> connection) {
    this.connection = connection;
  }

  public ContextSchema connectivityService(List<ConnectivityService> connectivityService) {
    this.connectivityService = connectivityService;
    return this;
  }

  public ContextSchema addConnectivityServiceItem(ConnectivityService connectivityServiceItem) {
    if (this.connectivityService == null) {
      this.connectivityService = new ArrayList<ConnectivityService>();
    }
    this.connectivityService.add(connectivityServiceItem);
    return this;
  }

   /**
   * Get connectivityService
   * @return connectivityService
  **/
  @ApiModelProperty(value = "")
  public List<ConnectivityService> getConnectivityService() {
    return connectivityService;
  }

  public void setConnectivityService(List<ConnectivityService> connectivityService) {
    this.connectivityService = connectivityService;
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

  public ContextSchema path(List<Path> path) {
    this.path = path;
    return this;
  }

  public ContextSchema addPathItem(Path pathItem) {
    if (this.path == null) {
      this.path = new ArrayList<Path>();
    }
    this.path.add(pathItem);
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public List<Path> getPath() {
    return path;
  }

  public void setPath(List<Path> path) {
    this.path = path;
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
        Objects.equals(this.pathCompService, contextSchema.pathCompService) &&
        Objects.equals(this.connection, contextSchema.connection) &&
        Objects.equals(this.connectivityService, contextSchema.connectivityService) &&
        Objects.equals(this.nwTopologyService, contextSchema.nwTopologyService) &&
        Objects.equals(this.path, contextSchema.path) &&
        Objects.equals(this.topology, contextSchema.topology);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, serviceInterfacePoint, pathCompService, connection, connectivityService, nwTopologyService, path, topology);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextSchema {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceInterfacePoint: ").append(toIndentedString(serviceInterfacePoint)).append("\n");
    sb.append("    pathCompService: ").append(toIndentedString(pathCompService)).append("\n");
    sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
    sb.append("    connectivityService: ").append(toIndentedString(connectivityService)).append("\n");
    sb.append("    nwTopologyService: ").append(toIndentedString(nwTopologyService)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
