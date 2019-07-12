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
import io.swagger.client.model.ConnectionRef;
import java.io.IOException;

/**
 * RouteRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class RouteRef {
  @SerializedName("connection-uuid")
  private String connectionUuid = null;

  @SerializedName("route-local-id")
  private String routeLocalId = null;

  public RouteRef connectionUuid(String connectionUuid) {
    this.connectionUuid = connectionUuid;
    return this;
  }

   /**
   * Get connectionUuid
   * @return connectionUuid
  **/
  @ApiModelProperty(value = "")
  public String getConnectionUuid() {
    return connectionUuid;
  }

  public void setConnectionUuid(String connectionUuid) {
    this.connectionUuid = connectionUuid;
  }

  public RouteRef routeLocalId(String routeLocalId) {
    this.routeLocalId = routeLocalId;
    return this;
  }

   /**
   * Get routeLocalId
   * @return routeLocalId
  **/
  @ApiModelProperty(value = "")
  public String getRouteLocalId() {
    return routeLocalId;
  }

  public void setRouteLocalId(String routeLocalId) {
    this.routeLocalId = routeLocalId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RouteRef routeRef = (RouteRef) o;
    return Objects.equals(this.connectionUuid, routeRef.connectionUuid) &&
        Objects.equals(this.routeLocalId, routeRef.routeLocalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectionUuid, routeLocalId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RouteRef {\n");
    
    sb.append("    connectionUuid: ").append(toIndentedString(connectionUuid)).append("\n");
    sb.append("    routeLocalId: ").append(toIndentedString(routeLocalId)).append("\n");
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
