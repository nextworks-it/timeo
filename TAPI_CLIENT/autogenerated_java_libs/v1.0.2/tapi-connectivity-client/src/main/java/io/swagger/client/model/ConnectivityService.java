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
import io.swagger.client.model.AdminStatePac;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.ConnectionRef;
import io.swagger.client.model.ConnectivityConstraint;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.ConnectivityServiceRef;
import io.swagger.client.model.CostCharacteristic;
import io.swagger.client.model.LatencyCharacteristic;
import io.swagger.client.model.LinkRef;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.NodeRef;
import io.swagger.client.model.PathRef;
import io.swagger.client.model.ResilienceConstraint;
import io.swagger.client.model.ResilienceType;
import io.swagger.client.model.RiskCharacteristic;
import io.swagger.client.model.RoutingConstraint;
import io.swagger.client.model.ServiceSpec;
import io.swagger.client.model.TimeRange;
import io.swagger.client.model.TopologyConstraint;
import io.swagger.client.model.TopologyRef;
import java.util.ArrayList;
import java.util.List;


/**
 * The ForwardingConstruct (FC) object class models enabled potential for forwarding between two or more LTPs and like the LTP supports any transport protocol including all circuit and packet forms. At the lowest level of recursion, a FC represents a cross-connection within an NE.
 */
@ApiModel(description = "The ForwardingConstruct (FC) object class models enabled potential for forwarding between two or more LTPs and like the LTP supports any transport protocol including all circuit and packet forms. At the lowest level of recursion, a FC represents a cross-connection within an NE.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T12:42:21.668+02:00")
public class ConnectivityService   {
  @SerializedName("connection")
  private List<ConnectionRef> connection = new ArrayList<ConnectionRef>();

  @SerializedName("end-point")
  private List<ConnectivityServiceEndPoint> endPoint = new ArrayList<ConnectivityServiceEndPoint>();

  public ConnectivityService connection(List<ConnectionRef> connection) {
    this.connection = connection;
    return this;
  }

  public ConnectivityService addConnectionItem(ConnectionRef connectionItem) {
    this.connection.add(connectionItem);
    return this;
  }

   /**
   * Get connection
   * @return connection
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConnectionRef> getConnection() {
    return connection;
  }

  public void setConnection(List<ConnectionRef> connection) {
    this.connection = connection;
  }

  public ConnectivityService endPoint(List<ConnectivityServiceEndPoint> endPoint) {
    this.endPoint = endPoint;
    return this;
  }

  public ConnectivityService addEndPointItem(ConnectivityServiceEndPoint endPointItem) {
    this.endPoint.add(endPointItem);
    return this;
  }

   /**
   * Get endPoint
   * @return endPoint
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConnectivityServiceEndPoint> getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(List<ConnectivityServiceEndPoint> endPoint) {
    this.endPoint = endPoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectivityService connectivityService = (ConnectivityService) o;
    return Objects.equals(this.connection, connectivityService.connection) &&
        Objects.equals(this.endPoint, connectivityService.endPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(connection, endPoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectivityService {\n");
    
    sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
    sb.append("    endPoint: ").append(toIndentedString(endPoint)).append("\n");
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
