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
import java.io.IOException;

/**
 * AvailabletransceiverSupportedbandwidth
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-08T09:23:18.099+02:00")
public class AvailabletransceiverSupportedbandwidth {
  @SerializedName("max-bw")
  private String maxBw = null;

  @SerializedName("min-bw")
  private String minBw = null;

  public AvailabletransceiverSupportedbandwidth maxBw(String maxBw) {
    this.maxBw = maxBw;
    return this;
  }

   /**
   * Get maxBw
   * @return maxBw
  **/
  @ApiModelProperty(value = "")
  public String getMaxBw() {
    return maxBw;
  }

  public void setMaxBw(String maxBw) {
    this.maxBw = maxBw;
  }

  public AvailabletransceiverSupportedbandwidth minBw(String minBw) {
    this.minBw = minBw;
    return this;
  }

   /**
   * Get minBw
   * @return minBw
  **/
  @ApiModelProperty(value = "")
  public String getMinBw() {
    return minBw;
  }

  public void setMinBw(String minBw) {
    this.minBw = minBw;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailabletransceiverSupportedbandwidth availabletransceiverSupportedbandwidth = (AvailabletransceiverSupportedbandwidth) o;
    return Objects.equals(this.maxBw, availabletransceiverSupportedbandwidth.maxBw) &&
        Objects.equals(this.minBw, availabletransceiverSupportedbandwidth.minBw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxBw, minBw);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailabletransceiverSupportedbandwidth {\n");
    
    sb.append("    maxBw: ").append(toIndentedString(maxBw)).append("\n");
    sb.append("    minBw: ").append(toIndentedString(minBw)).append("\n");
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

