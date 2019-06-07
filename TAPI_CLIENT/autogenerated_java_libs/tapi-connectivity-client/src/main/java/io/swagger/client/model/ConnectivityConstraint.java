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
import io.swagger.client.model.Capacity;
import io.swagger.client.model.ConnectivityServiceRef;
import io.swagger.client.model.TimeRange;
import java.util.ArrayList;
import java.util.List;


/**
 * ConnectivityConstraint
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-07T14:24:55.849+02:00")
public class ConnectivityConstraint   {
  /**
   * Gets or Sets serviceType
   */
  public enum ServiceTypeEnum {
    @SerializedName("POINT_TO_POINT_CONNECTIVITY")
    POINT_TO_POINT_CONNECTIVITY("POINT_TO_POINT_CONNECTIVITY"),
    
    @SerializedName("POINT_TO_MULTIPOINT_CONNECTIVITY")
    POINT_TO_MULTIPOINT_CONNECTIVITY("POINT_TO_MULTIPOINT_CONNECTIVITY"),
    
    @SerializedName("MULTIPOINT_CONNECTIVITY")
    MULTIPOINT_CONNECTIVITY("MULTIPOINT_CONNECTIVITY"),
    
    @SerializedName("ROOTED_MULTIPOINT_CONNECTIVITY")
    ROOTED_MULTIPOINT_CONNECTIVITY("ROOTED_MULTIPOINT_CONNECTIVITY");

    private String value;

    ServiceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("service-type")
  private ServiceTypeEnum serviceType = null;

  @SerializedName("schedule")
  private TimeRange schedule = null;

  @SerializedName("requested-capacity")
  private Capacity requestedCapacity = null;

  /**
   * Gets or Sets serviceLayer
   */
  public enum ServiceLayerEnum {
    @SerializedName("ODU")
    ODU("ODU"),
    
    @SerializedName("ETH")
    ETH("ETH"),
    
    @SerializedName("DSR")
    DSR("DSR"),
    
    @SerializedName("PHOTONIC_MEDIA")
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    ServiceLayerEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("service-layer")
  private ServiceLayerEnum serviceLayer = null;

  @SerializedName("service-level")
  private String serviceLevel = null;

  @SerializedName("diversity-exclusion")
  private List<ConnectivityServiceRef> diversityExclusion = new ArrayList<ConnectivityServiceRef>();

  /**
   * Gets or Sets connectivityDirection
   */
  public enum ConnectivityDirectionEnum {
    @SerializedName("BIDIRECTIONAL")
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    @SerializedName("UNIDIRECTIONAL")
    UNIDIRECTIONAL("UNIDIRECTIONAL"),
    
    @SerializedName("UNDEFINED_OR_UNKNOWN")
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

    private String value;

    ConnectivityDirectionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("connectivity-direction")
  private ConnectivityDirectionEnum connectivityDirection = null;

  @SerializedName("coroute-inclusion")
  private ConnectivityServiceRef corouteInclusion = null;

  public ConnectivityConstraint serviceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
    return this;
  }

   /**
   * Get serviceType
   * @return serviceType
  **/
  @ApiModelProperty(example = "null", value = "")
  public ServiceTypeEnum getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
  }

  public ConnectivityConstraint schedule(TimeRange schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * Get schedule
   * @return schedule
  **/
  @ApiModelProperty(example = "null", value = "")
  public TimeRange getSchedule() {
    return schedule;
  }

  public void setSchedule(TimeRange schedule) {
    this.schedule = schedule;
  }

  public ConnectivityConstraint requestedCapacity(Capacity requestedCapacity) {
    this.requestedCapacity = requestedCapacity;
    return this;
  }

   /**
   * Get requestedCapacity
   * @return requestedCapacity
  **/
  @ApiModelProperty(example = "null", value = "")
  public Capacity getRequestedCapacity() {
    return requestedCapacity;
  }

  public void setRequestedCapacity(Capacity requestedCapacity) {
    this.requestedCapacity = requestedCapacity;
  }

  public ConnectivityConstraint serviceLayer(ServiceLayerEnum serviceLayer) {
    this.serviceLayer = serviceLayer;
    return this;
  }

   /**
   * Get serviceLayer
   * @return serviceLayer
  **/
  @ApiModelProperty(example = "null", value = "")
  public ServiceLayerEnum getServiceLayer() {
    return serviceLayer;
  }

  public void setServiceLayer(ServiceLayerEnum serviceLayer) {
    this.serviceLayer = serviceLayer;
  }

  public ConnectivityConstraint serviceLevel(String serviceLevel) {
    this.serviceLevel = serviceLevel;
    return this;
  }

   /**
   * An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability
   * @return serviceLevel
  **/
  @ApiModelProperty(example = "null", value = "An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability")
  public String getServiceLevel() {
    return serviceLevel;
  }

  public void setServiceLevel(String serviceLevel) {
    this.serviceLevel = serviceLevel;
  }

  public ConnectivityConstraint diversityExclusion(List<ConnectivityServiceRef> diversityExclusion) {
    this.diversityExclusion = diversityExclusion;
    return this;
  }

  public ConnectivityConstraint addDiversityExclusionItem(ConnectivityServiceRef diversityExclusionItem) {
    this.diversityExclusion.add(diversityExclusionItem);
    return this;
  }

   /**
   * Get diversityExclusion
   * @return diversityExclusion
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<ConnectivityServiceRef> getDiversityExclusion() {
    return diversityExclusion;
  }

  public void setDiversityExclusion(List<ConnectivityServiceRef> diversityExclusion) {
    this.diversityExclusion = diversityExclusion;
  }

  public ConnectivityConstraint connectivityDirection(ConnectivityDirectionEnum connectivityDirection) {
    this.connectivityDirection = connectivityDirection;
    return this;
  }

   /**
   * Get connectivityDirection
   * @return connectivityDirection
  **/
  @ApiModelProperty(example = "null", value = "")
  public ConnectivityDirectionEnum getConnectivityDirection() {
    return connectivityDirection;
  }

  public void setConnectivityDirection(ConnectivityDirectionEnum connectivityDirection) {
    this.connectivityDirection = connectivityDirection;
  }

  public ConnectivityConstraint corouteInclusion(ConnectivityServiceRef corouteInclusion) {
    this.corouteInclusion = corouteInclusion;
    return this;
  }

   /**
   * Get corouteInclusion
   * @return corouteInclusion
  **/
  @ApiModelProperty(example = "null", value = "")
  public ConnectivityServiceRef getCorouteInclusion() {
    return corouteInclusion;
  }

  public void setCorouteInclusion(ConnectivityServiceRef corouteInclusion) {
    this.corouteInclusion = corouteInclusion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectivityConstraint connectivityConstraint = (ConnectivityConstraint) o;
    return Objects.equals(this.serviceType, connectivityConstraint.serviceType) &&
        Objects.equals(this.schedule, connectivityConstraint.schedule) &&
        Objects.equals(this.requestedCapacity, connectivityConstraint.requestedCapacity) &&
        Objects.equals(this.serviceLayer, connectivityConstraint.serviceLayer) &&
        Objects.equals(this.serviceLevel, connectivityConstraint.serviceLevel) &&
        Objects.equals(this.diversityExclusion, connectivityConstraint.diversityExclusion) &&
        Objects.equals(this.connectivityDirection, connectivityConstraint.connectivityDirection) &&
        Objects.equals(this.corouteInclusion, connectivityConstraint.corouteInclusion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceType, schedule, requestedCapacity, serviceLayer, serviceLevel, diversityExclusion, connectivityDirection, corouteInclusion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectivityConstraint {\n");
    
    sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    requestedCapacity: ").append(toIndentedString(requestedCapacity)).append("\n");
    sb.append("    serviceLayer: ").append(toIndentedString(serviceLayer)).append("\n");
    sb.append("    serviceLevel: ").append(toIndentedString(serviceLevel)).append("\n");
    sb.append("    diversityExclusion: ").append(toIndentedString(diversityExclusion)).append("\n");
    sb.append("    connectivityDirection: ").append(toIndentedString(connectivityDirection)).append("\n");
    sb.append("    corouteInclusion: ").append(toIndentedString(corouteInclusion)).append("\n");
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

