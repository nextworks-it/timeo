/*
 * tapi-arof API
 * tapi-arof API generated from tapi-arof.yang
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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ServiceInterfacePointRef
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:13:03.153+02:00")
public class ServiceInterfacePointRef {
  @SerializedName("service-interface-point-uuid")
  private String serviceInterfacePointUuid = null;

  public ServiceInterfacePointRef serviceInterfacePointUuid(String serviceInterfacePointUuid) {
    this.serviceInterfacePointUuid = serviceInterfacePointUuid;
    return this;
  }

   /**
   * Get serviceInterfacePointUuid
   * @return serviceInterfacePointUuid
  **/
  @ApiModelProperty(value = "")
  public String getServiceInterfacePointUuid() {
    return serviceInterfacePointUuid;
  }

  public void setServiceInterfacePointUuid(String serviceInterfacePointUuid) {
    this.serviceInterfacePointUuid = serviceInterfacePointUuid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceInterfacePointRef serviceInterfacePointRef = (ServiceInterfacePointRef) o;
    return Objects.equals(this.serviceInterfacePointUuid, serviceInterfacePointRef.serviceInterfacePointUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceInterfacePointUuid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceInterfacePointRef {\n");
    
    sb.append("    serviceInterfacePointUuid: ").append(toIndentedString(serviceInterfacePointUuid)).append("\n");
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

