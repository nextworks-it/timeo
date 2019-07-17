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
import io.swagger.client.model.FecPropertiesPac;
import io.swagger.client.model.OtsiGserverAdaptationPac;
import java.io.IOException;

/**
 * OtsiAssemblyConnectionEndPointSpec
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class OtsiAssemblyConnectionEndPointSpec {
  @SerializedName("fec-parameters")
  private FecPropertiesPac fecParameters = null;

  @SerializedName("otsi-adapter")
  private OtsiGserverAdaptationPac otsiAdapter = null;

  public OtsiAssemblyConnectionEndPointSpec fecParameters(FecPropertiesPac fecParameters) {
    this.fecParameters = fecParameters;
    return this;
  }

   /**
   * Get fecParameters
   * @return fecParameters
  **/
  @ApiModelProperty(value = "")
  public FecPropertiesPac getFecParameters() {
    return fecParameters;
  }

  public void setFecParameters(FecPropertiesPac fecParameters) {
    this.fecParameters = fecParameters;
  }

  public OtsiAssemblyConnectionEndPointSpec otsiAdapter(OtsiGserverAdaptationPac otsiAdapter) {
    this.otsiAdapter = otsiAdapter;
    return this;
  }

   /**
   * Get otsiAdapter
   * @return otsiAdapter
  **/
  @ApiModelProperty(value = "")
  public OtsiGserverAdaptationPac getOtsiAdapter() {
    return otsiAdapter;
  }

  public void setOtsiAdapter(OtsiGserverAdaptationPac otsiAdapter) {
    this.otsiAdapter = otsiAdapter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtsiAssemblyConnectionEndPointSpec otsiAssemblyConnectionEndPointSpec = (OtsiAssemblyConnectionEndPointSpec) o;
    return Objects.equals(this.fecParameters, otsiAssemblyConnectionEndPointSpec.fecParameters) &&
        Objects.equals(this.otsiAdapter, otsiAssemblyConnectionEndPointSpec.otsiAdapter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fecParameters, otsiAdapter);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtsiAssemblyConnectionEndPointSpec {\n");
    
    sb.append("    fecParameters: ").append(toIndentedString(fecParameters)).append("\n");
    sb.append("    otsiAdapter: ").append(toIndentedString(otsiAdapter)).append("\n");
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
