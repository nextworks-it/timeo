/*
 * tapi-topology API
 * tapi-topology API generated from tapi-topology@2018-03-07.yang
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
import java.util.ArrayList;
import java.util.List;

/**
 * The information for a particular risk characteristic where there is a list of risk identifiers related to that characteristic.
 */
@ApiModel(description = "The information for a particular risk characteristic where there is a list of risk identifiers related to that characteristic.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:55:18.533+02:00")
public class RiskCharacteristic {
  @SerializedName("risk-identifier-list")
  private List<String> riskIdentifierList = null;

  @SerializedName("risk-characteristic-name")
  private String riskCharacteristicName = null;

  public RiskCharacteristic riskIdentifierList(List<String> riskIdentifierList) {
    this.riskIdentifierList = riskIdentifierList;
    return this;
  }

  public RiskCharacteristic addRiskIdentifierListItem(String riskIdentifierListItem) {
    if (this.riskIdentifierList == null) {
      this.riskIdentifierList = new ArrayList<String>();
    }
    this.riskIdentifierList.add(riskIdentifierListItem);
    return this;
  }

   /**
   * Get riskIdentifierList
   * @return riskIdentifierList
  **/
  @ApiModelProperty(value = "")
  public List<String> getRiskIdentifierList() {
    return riskIdentifierList;
  }

  public void setRiskIdentifierList(List<String> riskIdentifierList) {
    this.riskIdentifierList = riskIdentifierList;
  }

  public RiskCharacteristic riskCharacteristicName(String riskCharacteristicName) {
    this.riskCharacteristicName = riskCharacteristicName;
    return this;
  }

   /**
   * The name of the risk characteristic. The characteristic may be related to a specific degree of closeness. For example a particular characteristic may apply to failures that are localized (e.g. to one side of a road) where as another characteristic may relate to failures that have a broader impact (e.g. both sides of a road that crosses a bridge). Depending upon the importance of the traffic being routed different risk characteristics will be evaluated.
   * @return riskCharacteristicName
  **/
  @ApiModelProperty(value = "The name of the risk characteristic. The characteristic may be related to a specific degree of closeness. For example a particular characteristic may apply to failures that are localized (e.g. to one side of a road) where as another characteristic may relate to failures that have a broader impact (e.g. both sides of a road that crosses a bridge). Depending upon the importance of the traffic being routed different risk characteristics will be evaluated.")
  public String getRiskCharacteristicName() {
    return riskCharacteristicName;
  }

  public void setRiskCharacteristicName(String riskCharacteristicName) {
    this.riskCharacteristicName = riskCharacteristicName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RiskCharacteristic riskCharacteristic = (RiskCharacteristic) o;
    return Objects.equals(this.riskIdentifierList, riskCharacteristic.riskIdentifierList) &&
        Objects.equals(this.riskCharacteristicName, riskCharacteristic.riskCharacteristicName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskIdentifierList, riskCharacteristicName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskCharacteristic {\n");
    
    sb.append("    riskIdentifierList: ").append(toIndentedString(riskIdentifierList)).append("\n");
    sb.append("    riskCharacteristicName: ").append(toIndentedString(riskCharacteristicName)).append("\n");
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

