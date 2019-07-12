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
 * Provides state attributes that are applicable to an entity that reflects operational aspects. Such an entity is expected to also have lifecycle aspects.
 */
@ApiModel(description = "Provides state attributes that are applicable to an entity that reflects operational aspects. Such an entity is expected to also have lifecycle aspects.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:24:55.849+02:00")
public class OperationalStatePac   {
  /**
   * Gets or Sets lifecycleState
   */
  public enum LifecycleStateEnum {
    @SerializedName("PLANNED")
    PLANNED("PLANNED"),
    
    @SerializedName("POTENTIAL_AVAILABLE")
    POTENTIAL_AVAILABLE("POTENTIAL_AVAILABLE"),
    
    @SerializedName("POTENTIAL_BUSY")
    POTENTIAL_BUSY("POTENTIAL_BUSY"),
    
    @SerializedName("INSTALLED")
    INSTALLED("INSTALLED"),
    
    @SerializedName("PENDING_REMOVAL")
    PENDING_REMOVAL("PENDING_REMOVAL");

    private String value;

    LifecycleStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("lifecycle-state")
  private LifecycleStateEnum lifecycleState = null;

  /**
   * Gets or Sets operationalState
   */
  public enum OperationalStateEnum {
    @SerializedName("DISABLED")
    DISABLED("DISABLED"),
    
    @SerializedName("ENABLED")
    ENABLED("ENABLED");

    private String value;

    OperationalStateEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("operational-state")
  private OperationalStateEnum operationalState = null;

  public OperationalStatePac lifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
    return this;
  }

   /**
   * Get lifecycleState
   * @return lifecycleState
  **/
  @ApiModelProperty(example = "null", value = "")
  public LifecycleStateEnum getLifecycleState() {
    return lifecycleState;
  }

  public void setLifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
  }

  public OperationalStatePac operationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
    return this;
  }

   /**
   * Get operationalState
   * @return operationalState
  **/
  @ApiModelProperty(example = "null", value = "")
  public OperationalStateEnum getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationalStatePac operationalStatePac = (OperationalStatePac) o;
    return Objects.equals(this.lifecycleState, operationalStatePac.lifecycleState) &&
        Objects.equals(this.operationalState, operationalStatePac.operationalState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lifecycleState, operationalState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationalStatePac {\n");
    
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
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
