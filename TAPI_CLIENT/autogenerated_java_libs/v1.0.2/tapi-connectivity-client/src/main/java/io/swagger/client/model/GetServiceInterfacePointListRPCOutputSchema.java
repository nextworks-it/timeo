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
import io.swagger.client.model.ServiceInterfacePoint;
import java.util.ArrayList;
import java.util.List;


/**
 * GetServiceInterfacePointListRPCOutputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T12:42:21.668+02:00")
public class GetServiceInterfacePointListRPCOutputSchema   {
  @SerializedName("sip")
  private List<ServiceInterfacePoint> sip = new ArrayList<ServiceInterfacePoint>();

  public GetServiceInterfacePointListRPCOutputSchema sip(List<ServiceInterfacePoint> sip) {
    this.sip = sip;
    return this;
  }

  public GetServiceInterfacePointListRPCOutputSchema addSipItem(ServiceInterfacePoint sipItem) {
    this.sip.add(sipItem);
    return this;
  }

   /**
   * Get sip
   * @return sip
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ServiceInterfacePoint> getSip() {
    return sip;
  }

  public void setSip(List<ServiceInterfacePoint> sip) {
    this.sip = sip;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetServiceInterfacePointListRPCOutputSchema getServiceInterfacePointListRPCOutputSchema = (GetServiceInterfacePointListRPCOutputSchema) o;
    return Objects.equals(this.sip, getServiceInterfacePointListRPCOutputSchema.sip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sip);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetServiceInterfacePointListRPCOutputSchema {\n");
    
    sb.append("    sip: ").append(toIndentedString(sip)).append("\n");
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
