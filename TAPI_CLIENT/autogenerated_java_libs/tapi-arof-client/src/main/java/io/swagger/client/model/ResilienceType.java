/**
 * tapi-arof API
 * tapi-arof API generated from tapi-arof.yang
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
 * ResilienceType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:21:00.609+02:00")
public class ResilienceType   {
  /**
   * Gets or Sets restorationPolicy
   */
  public enum RestorationPolicyEnum {
    @SerializedName("PER_DOMAIN_RESTORATION")
    PER_DOMAIN_RESTORATION("PER_DOMAIN_RESTORATION"),
    
    @SerializedName("END_TO_END_RESTORATION")
    END_TO_END_RESTORATION("END_TO_END_RESTORATION"),
    
    @SerializedName("NA")
    NA("NA");

    private String value;

    RestorationPolicyEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("restoration-policy")
  private RestorationPolicyEnum restorationPolicy = null;

  /**
   * Gets or Sets protectionType
   */
  public enum ProtectionTypeEnum {
    @SerializedName("NO_PROTECTON")
    NO_PROTECTON("NO_PROTECTON"),
    
    @SerializedName("ONE_PLUS_ONE_PROTECTION")
    ONE_PLUS_ONE_PROTECTION("ONE_PLUS_ONE_PROTECTION"),
    
    @SerializedName("ONE_PLUS_ONE_PROTECTION_WITH_DYNAMIC_RESTORATION")
    ONE_PLUS_ONE_PROTECTION_WITH_DYNAMIC_RESTORATION("ONE_PLUS_ONE_PROTECTION_WITH_DYNAMIC_RESTORATION"),
    
    @SerializedName("PERMANENT_ONE_PLUS_ONE_PROTECTION")
    PERMANENT_ONE_PLUS_ONE_PROTECTION("PERMANENT_ONE_PLUS_ONE_PROTECTION"),
    
    @SerializedName("ONE_FOR_ONE_PROTECTION")
    ONE_FOR_ONE_PROTECTION("ONE_FOR_ONE_PROTECTION"),
    
    @SerializedName("DYNAMIC_RESTORATION")
    DYNAMIC_RESTORATION("DYNAMIC_RESTORATION"),
    
    @SerializedName("PRE_COMPUTED_RESTORATION")
    PRE_COMPUTED_RESTORATION("PRE_COMPUTED_RESTORATION");

    private String value;

    ProtectionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("protection-type")
  private ProtectionTypeEnum protectionType = null;

  public ResilienceType restorationPolicy(RestorationPolicyEnum restorationPolicy) {
    this.restorationPolicy = restorationPolicy;
    return this;
  }

   /**
   * Get restorationPolicy
   * @return restorationPolicy
  **/
  @ApiModelProperty(example = "null", value = "")
  public RestorationPolicyEnum getRestorationPolicy() {
    return restorationPolicy;
  }

  public void setRestorationPolicy(RestorationPolicyEnum restorationPolicy) {
    this.restorationPolicy = restorationPolicy;
  }

  public ResilienceType protectionType(ProtectionTypeEnum protectionType) {
    this.protectionType = protectionType;
    return this;
  }

   /**
   * Get protectionType
   * @return protectionType
  **/
  @ApiModelProperty(example = "null", value = "")
  public ProtectionTypeEnum getProtectionType() {
    return protectionType;
  }

  public void setProtectionType(ProtectionTypeEnum protectionType) {
    this.protectionType = protectionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResilienceType resilienceType = (ResilienceType) o;
    return Objects.equals(this.restorationPolicy, resilienceType.restorationPolicy) &&
        Objects.equals(this.protectionType, resilienceType.protectionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restorationPolicy, protectionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResilienceType {\n");
    
    sb.append("    restorationPolicy: ").append(toIndentedString(restorationPolicy)).append("\n");
    sb.append("    protectionType: ").append(toIndentedString(protectionType)).append("\n");
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

