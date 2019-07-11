/*
 * tapi-common API
 * tapi-common API generated from tapi-common@2018-12-10.yang
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
import io.swagger.client.model.ServiceInterfacePoint;
import java.io.IOException;

/**
 * GetServiceInterfacePointDetailsRPCOutputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2019-07-09T13:04:10.039+02:00[Europe/Rome]")
public class GetServiceInterfacePointDetailsRPCOutputSchema {

  @SerializedName("sip")
  private ServiceInterfacePoint sip = null;
  
  public GetServiceInterfacePointDetailsRPCOutputSchema sip(ServiceInterfacePoint sip) {
    this.sip = sip;
    return this;
  }

  
  /**
  * Get sip
  * @return sip
  **/
  @ApiModelProperty(value = "")
  public ServiceInterfacePoint getSip() {
    return sip;
  }
  public void setSip(ServiceInterfacePoint sip) {
    this.sip = sip;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceInterfacePointDetailsRPCOutputSchema getServiceInterfacePointDetailsRPCOutputSchema = (GetServiceInterfacePointDetailsRPCOutputSchema) o;
    return Objects.equals(this.sip, getServiceInterfacePointDetailsRPCOutputSchema.sip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sip);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceInterfacePointDetailsRPCOutputSchema {\n");
    
    sb.append("    sip: ").append(toIndentedString(sip)).append("\n");
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



