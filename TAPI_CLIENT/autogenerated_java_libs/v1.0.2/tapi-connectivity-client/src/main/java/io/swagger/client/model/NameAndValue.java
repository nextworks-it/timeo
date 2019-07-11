/**
 * tapi-connectivity API
 * tapi-connectivity API generated from tapi-connectivity@2018-12-10.yang
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
 * A scoped name-value pair
 */
@ApiModel(description = "A scoped name-value pair")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T12:42:21.668+02:00")
public class NameAndValue   {
  @SerializedName("value")
  private String value = null;

  @SerializedName("value-name")
  private String valueName = null;

  public NameAndValue value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value
   * @return value
  **/
  @ApiModelProperty(example = "null", value = "The value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public NameAndValue valueName(String valueName) {
    this.valueName = valueName;
    return this;
  }

   /**
   * The name of the value. The value need not have a name.
   * @return valueName
  **/
  @ApiModelProperty(example = "null", value = "The name of the value. The value need not have a name.")
  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NameAndValue nameAndValue = (NameAndValue) o;
    return Objects.equals(this.value, nameAndValue.value) &&
        Objects.equals(this.valueName, nameAndValue.valueName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, valueName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NameAndValue {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueName: ").append(toIndentedString(valueName)).append("\n");
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

