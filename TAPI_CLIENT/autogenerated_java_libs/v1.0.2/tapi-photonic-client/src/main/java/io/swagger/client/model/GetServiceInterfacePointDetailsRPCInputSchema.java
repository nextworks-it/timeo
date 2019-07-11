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
import java.io.IOException;

/**
 * GetServiceInterfacePointDetailsRPCInputSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class GetServiceInterfacePointDetailsRPCInputSchema {
  @SerializedName("sip-id-or-name")
  private String sipIdOrName = null;

  public GetServiceInterfacePointDetailsRPCInputSchema sipIdOrName(String sipIdOrName) {
    this.sipIdOrName = sipIdOrName;
    return this;
  }

   /**
   * Get sipIdOrName
   * @return sipIdOrName
  **/
  @ApiModelProperty(value = "")
  public String getSipIdOrName() {
    return sipIdOrName;
  }

  public void setSipIdOrName(String sipIdOrName) {
    this.sipIdOrName = sipIdOrName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceInterfacePointDetailsRPCInputSchema getServiceInterfacePointDetailsRPCInputSchema = (GetServiceInterfacePointDetailsRPCInputSchema) o;
    return Objects.equals(this.sipIdOrName, getServiceInterfacePointDetailsRPCInputSchema.sipIdOrName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sipIdOrName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceInterfacePointDetailsRPCInputSchema {\n");
    
    sb.append("    sipIdOrName: ").append(toIndentedString(sipIdOrName)).append("\n");
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

