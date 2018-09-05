/*
 * tapi-common API
 * tapi-common API generated from tapi-common@2018-03-07.yang
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
import java.util.ArrayList;
import java.util.List;

/**
 * GetServiceInterfacePointListRPCOutputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:53:47.797+02:00")
public class GetServiceInterfacePointListRPCOutputSchema {
  @SerializedName("sip")
  private List<ServiceInterfacePoint> sip = null;

  public GetServiceInterfacePointListRPCOutputSchema sip(List<ServiceInterfacePoint> sip) {
    this.sip = sip;
    return this;
  }

  public GetServiceInterfacePointListRPCOutputSchema addSipItem(ServiceInterfacePoint sipItem) {
    if (this.sip == null) {
      this.sip = new ArrayList<ServiceInterfacePoint>();
    }
    this.sip.add(sipItem);
    return this;
  }

   /**
   * Get sip
   * @return sip
  **/
  @ApiModelProperty(value = "")
  public List<ServiceInterfacePoint> getSip() {
    return sip;
  }

  public void setSip(List<ServiceInterfacePoint> sip) {
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
    GetServiceInterfacePointListRPCOutputSchema getServiceInterfacePointListRPCOutputSchema = (GetServiceInterfacePointListRPCOutputSchema) o;
    return Objects.equals(this.sip, getServiceInterfacePointListRPCOutputSchema.sip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sip);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceInterfacePointListRPCOutputSchema {\n");
    
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

