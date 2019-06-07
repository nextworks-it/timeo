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
import io.swagger.client.model.ConnectivityService;
import java.util.ArrayList;
import java.util.List;


/**
 * GetConnectivityServiceListRPCOutputSchema
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:24:55.849+02:00")
public class GetConnectivityServiceListRPCOutputSchema   {
  @SerializedName("service")
  private List<ConnectivityService> service = new ArrayList<ConnectivityService>();

  public GetConnectivityServiceListRPCOutputSchema service(List<ConnectivityService> service) {
    this.service = service;
    return this;
  }

  public GetConnectivityServiceListRPCOutputSchema addServiceItem(ConnectivityService serviceItem) {
    this.service.add(serviceItem);
    return this;
  }

   /**
   * Get service
   * @return service
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConnectivityService> getService() {
    return service;
  }

  public void setService(List<ConnectivityService> service) {
    this.service = service;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetConnectivityServiceListRPCOutputSchema getConnectivityServiceListRPCOutputSchema = (GetConnectivityServiceListRPCOutputSchema) o;
    return Objects.equals(this.service, getConnectivityServiceListRPCOutputSchema.service);
  }

  @Override
  public int hashCode() {
    return Objects.hash(service);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConnectivityServiceListRPCOutputSchema {\n");
    
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
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

