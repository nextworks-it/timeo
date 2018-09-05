/*
 * tapi-path-computation API
 * tapi-path-computation API generated from tapi-path-computation@2018-03-07.yang
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
 * The information for a particular cost characteristic.
 */
@ApiModel(description = "The information for a particular cost characteristic.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:55.433+02:00")
public class CostCharacteristic {
  @SerializedName("cost-name")
  private String costName = null;

  @SerializedName("cost-value")
  private String costValue = null;

  @SerializedName("cost-algorithm")
  private String costAlgorithm = null;

  public CostCharacteristic costName(String costName) {
    this.costName = costName;
    return this;
  }

   /**
   * The cost characteristic will related to some aspect of the TopologicalEntity (e.g. $ cost, routing weight). This aspect will be conveyed by the costName.
   * @return costName
  **/
  @ApiModelProperty(value = "The cost characteristic will related to some aspect of the TopologicalEntity (e.g. $ cost, routing weight). This aspect will be conveyed by the costName.")
  public String getCostName() {
    return costName;
  }

  public void setCostName(String costName) {
    this.costName = costName;
  }

  public CostCharacteristic costValue(String costValue) {
    this.costValue = costValue;
    return this;
  }

   /**
   * The specific cost.
   * @return costValue
  **/
  @ApiModelProperty(value = "The specific cost.")
  public String getCostValue() {
    return costValue;
  }

  public void setCostValue(String costValue) {
    this.costValue = costValue;
  }

  public CostCharacteristic costAlgorithm(String costAlgorithm) {
    this.costAlgorithm = costAlgorithm;
    return this;
  }

   /**
   * The cost may vary based upon some properties of the TopologicalEntity. The rules for the variation are conveyed by the costAlgorithm.
   * @return costAlgorithm
  **/
  @ApiModelProperty(value = "The cost may vary based upon some properties of the TopologicalEntity. The rules for the variation are conveyed by the costAlgorithm.")
  public String getCostAlgorithm() {
    return costAlgorithm;
  }

  public void setCostAlgorithm(String costAlgorithm) {
    this.costAlgorithm = costAlgorithm;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CostCharacteristic costCharacteristic = (CostCharacteristic) o;
    return Objects.equals(this.costName, costCharacteristic.costName) &&
        Objects.equals(this.costValue, costCharacteristic.costValue) &&
        Objects.equals(this.costAlgorithm, costCharacteristic.costAlgorithm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(costName, costValue, costAlgorithm);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CostCharacteristic {\n");
    
    sb.append("    costName: ").append(toIndentedString(costName)).append("\n");
    sb.append("    costValue: ").append(toIndentedString(costValue)).append("\n");
    sb.append("    costAlgorithm: ").append(toIndentedString(costAlgorithm)).append("\n");
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

