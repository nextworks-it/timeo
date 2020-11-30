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
import io.swagger.client.model.Connection;
import io.swagger.client.model.ConnectivityService;
import java.util.ArrayList;
import java.util.List;


/**
 * ConnectivityContext
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T12:42:21.668+02:00")
public class ConnectivityContext   {
  @SerializedName("connection")
  private List<Connection> connection = new ArrayList<Connection>();

  @SerializedName("connectivity-service")
  private List<ConnectivityService> connectivityService = new ArrayList<ConnectivityService>();

  public ConnectivityContext connection(List<Connection> connection) {
    this.connection = connection;
    return this;
  }

  public ConnectivityContext addConnectionItem(Connection connectionItem) {
    this.connection.add(connectionItem);
    return this;
  }

   /**
   * Get connection
   * @return connection
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Connection> getConnection() {
    return connection;
  }

  public void setConnection(List<Connection> connection) {
    this.connection = connection;
  }

  public ConnectivityContext connectivityService(List<ConnectivityService> connectivityService) {
    this.connectivityService = connectivityService;
    return this;
  }

  public ConnectivityContext addConnectivityServiceItem(ConnectivityService connectivityServiceItem) {
    this.connectivityService.add(connectivityServiceItem);
    return this;
  }

   /**
   * Get connectivityService
   * @return connectivityService
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConnectivityService> getConnectivityService() {
    return connectivityService;
  }

  public void setConnectivityService(List<ConnectivityService> connectivityService) {
    this.connectivityService = connectivityService;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectivityContext connectivityContext = (ConnectivityContext) o;
    return Objects.equals(this.connection, connectivityContext.connection) &&
        Objects.equals(this.connectivityService, connectivityContext.connectivityService);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connection, connectivityService);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectivityContext {\n");
    
    sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
    sb.append("    connectivityService: ").append(toIndentedString(connectivityService)).append("\n");
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

