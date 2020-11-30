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
import io.swagger.client.model.ConnectivityContext;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.PathComputationContext;
import io.swagger.client.model.ServiceInterfacePoint;
import io.swagger.client.model.TapiContext;
import io.swagger.client.model.TopologyContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ContextSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class ContextSchema {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  @SerializedName("service-interface-point")
  private List<ServiceInterfacePoint> serviceInterfacePoint = null;

  @SerializedName("path-computation-context")
  private PathComputationContext pathComputationContext = null;

  @SerializedName("topology-context")
  private TopologyContext topologyContext = null;

  @SerializedName("connectivity-context")
  private ConnectivityContext connectivityContext = null;

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

  public ContextSchema pathComputationContext(PathComputationContext pathComputationContext) {
    this.pathComputationContext = pathComputationContext;
    return this;
  }

   /**
   * Augments the base TAPI Context with PathComputationService information
   * @return pathComputationContext
  **/
  @ApiModelProperty(value = "Augments the base TAPI Context with PathComputationService information")
  public PathComputationContext getPathComputationContext() {
    return pathComputationContext;
  }

  public void setPathComputationContext(PathComputationContext pathComputationContext) {
    this.pathComputationContext = pathComputationContext;
  }

  public ContextSchema topologyContext(TopologyContext topologyContext) {
    this.topologyContext = topologyContext;
    return this;
  }

   /**
   * Augments the base TAPI Context with TopologyService information
   * @return topologyContext
  **/
  @ApiModelProperty(value = "Augments the base TAPI Context with TopologyService information")
  public TopologyContext getTopologyContext() {
    return topologyContext;
  }

  public void setTopologyContext(TopologyContext topologyContext) {
    this.topologyContext = topologyContext;
  }

  public ContextSchema connectivityContext(ConnectivityContext connectivityContext) {
    this.connectivityContext = connectivityContext;
    return this;
  }

   /**
   * Augments the base TAPI Context with ConnectivityService information
   * @return connectivityContext
  **/
  @ApiModelProperty(value = "Augments the base TAPI Context with ConnectivityService information")
  public ConnectivityContext getConnectivityContext() {
    return connectivityContext;
  }

  public void setConnectivityContext(ConnectivityContext connectivityContext) {
    this.connectivityContext = connectivityContext;
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
        Objects.equals(this.pathComputationContext, contextSchema.pathComputationContext) &&
        Objects.equals(this.topologyContext, contextSchema.topologyContext) &&
        Objects.equals(this.connectivityContext, contextSchema.connectivityContext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, serviceInterfacePoint, pathComputationContext, topologyContext, connectivityContext);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextSchema {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceInterfacePoint: ").append(toIndentedString(serviceInterfacePoint)).append("\n");
    sb.append("    pathComputationContext: ").append(toIndentedString(pathComputationContext)).append("\n");
    sb.append("    topologyContext: ").append(toIndentedString(topologyContext)).append("\n");
    sb.append("    connectivityContext: ").append(toIndentedString(connectivityContext)).append("\n");
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

