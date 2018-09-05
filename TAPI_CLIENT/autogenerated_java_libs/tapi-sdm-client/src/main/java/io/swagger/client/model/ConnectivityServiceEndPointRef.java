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
import io.swagger.client.model.ConnectivityServiceRef;
import java.io.IOException;

/**
 * ConnectivityServiceEndPointRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class ConnectivityServiceEndPointRef {
  @SerializedName("connectivity-service-id")
  private String connectivityServiceId = null;

  @SerializedName("connectivity-service-end-point-id")
  private String connectivityServiceEndPointId = null;

  public ConnectivityServiceEndPointRef connectivityServiceId(String connectivityServiceId) {
    this.connectivityServiceId = connectivityServiceId;
    return this;
  }

   /**
   * Get connectivityServiceId
   * @return connectivityServiceId
  **/
  @ApiModelProperty(value = "")
  public String getConnectivityServiceId() {
    return connectivityServiceId;
  }

  public void setConnectivityServiceId(String connectivityServiceId) {
    this.connectivityServiceId = connectivityServiceId;
  }

  public ConnectivityServiceEndPointRef connectivityServiceEndPointId(String connectivityServiceEndPointId) {
    this.connectivityServiceEndPointId = connectivityServiceEndPointId;
    return this;
  }

   /**
   * Get connectivityServiceEndPointId
   * @return connectivityServiceEndPointId
  **/
  @ApiModelProperty(value = "")
  public String getConnectivityServiceEndPointId() {
    return connectivityServiceEndPointId;
  }

  public void setConnectivityServiceEndPointId(String connectivityServiceEndPointId) {
    this.connectivityServiceEndPointId = connectivityServiceEndPointId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectivityServiceEndPointRef connectivityServiceEndPointRef = (ConnectivityServiceEndPointRef) o;
    return Objects.equals(this.connectivityServiceId, connectivityServiceEndPointRef.connectivityServiceId) &&
        Objects.equals(this.connectivityServiceEndPointId, connectivityServiceEndPointRef.connectivityServiceEndPointId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connectivityServiceId, connectivityServiceEndPointId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectivityServiceEndPointRef {\n");
    
    sb.append("    connectivityServiceId: ").append(toIndentedString(connectivityServiceId)).append("\n");
    sb.append("    connectivityServiceEndPointId: ").append(toIndentedString(connectivityServiceEndPointId)).append("\n");
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

