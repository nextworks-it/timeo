/**
 * tapi-topology API
 * tapi-topology API generated from tapi-topology@2018-12-10.yang
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * TimePeriod
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-08T14:35:49.260+02:00")
public class TimePeriod   {
  /**
   * Gets or Sets unit
   */
  public enum UnitEnum {
    @SerializedName("YEARS")
    YEARS("YEARS"),
    
    @SerializedName("MONTHS")
    MONTHS("MONTHS"),
    
    @SerializedName("DAYS")
    DAYS("DAYS"),
    
    @SerializedName("HOURS")
    HOURS("HOURS"),
    
    @SerializedName("MINUTES")
    MINUTES("MINUTES"),
    
    @SerializedName("SECONDS")
    SECONDS("SECONDS"),
    
    @SerializedName("MILLISECONDS")
    MILLISECONDS("MILLISECONDS"),
    
    @SerializedName("MICROSECONDS")
    MICROSECONDS("MICROSECONDS"),
    
    @SerializedName("NANOSECONDS")
    NANOSECONDS("NANOSECONDS"),
    
    @SerializedName("PICOSECONDS")
    PICOSECONDS("PICOSECONDS");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("unit")
  private UnitEnum unit = null;

  @SerializedName("value")
  private String value = null;

  public TimePeriod unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @ApiModelProperty(example = "null", value = "")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  public TimePeriod value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimePeriod timePeriod = (TimePeriod) o;
    return Objects.equals(this.unit, timePeriod.unit) &&
        Objects.equals(this.value, timePeriod.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimePeriod {\n");
    
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

