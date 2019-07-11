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
 * Indication with severity warning raised when a total power value measured is above the threshold.
 */
@ApiModel(description = "Indication with severity warning raised when a total power value measured is above the threshold.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class PowerPropertiesPac {
  @SerializedName("total-power")
  private Double totalPower = null;

  @SerializedName("power-spectral-density")
  private Double powerSpectralDensity = null;

  public PowerPropertiesPac totalPower(Double totalPower) {
    this.totalPower = totalPower;
    return this;
  }

   /**
   * The total power at any point in a channel specified in dBm.
   * @return totalPower
  **/
  @ApiModelProperty(value = "The total power at any point in a channel specified in dBm.")
  public Double getTotalPower() {
    return totalPower;
  }

  public void setTotalPower(Double totalPower) {
    this.totalPower = totalPower;
  }

  public PowerPropertiesPac powerSpectralDensity(Double powerSpectralDensity) {
    this.powerSpectralDensity = powerSpectralDensity;
    return this;
  }

   /**
   * This describes how power of a signal  is distributed over frequency specified in nW/MHz
   * @return powerSpectralDensity
  **/
  @ApiModelProperty(value = "This describes how power of a signal  is distributed over frequency specified in nW/MHz")
  public Double getPowerSpectralDensity() {
    return powerSpectralDensity;
  }

  public void setPowerSpectralDensity(Double powerSpectralDensity) {
    this.powerSpectralDensity = powerSpectralDensity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PowerPropertiesPac powerPropertiesPac = (PowerPropertiesPac) o;
    return Objects.equals(this.totalPower, powerPropertiesPac.totalPower) &&
        Objects.equals(this.powerSpectralDensity, powerPropertiesPac.powerSpectralDensity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPower, powerSpectralDensity);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PowerPropertiesPac {\n");
    
    sb.append("    totalPower: ").append(toIndentedString(totalPower)).append("\n");
    sb.append("    powerSpectralDensity: ").append(toIndentedString(powerSpectralDensity)).append("\n");
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

