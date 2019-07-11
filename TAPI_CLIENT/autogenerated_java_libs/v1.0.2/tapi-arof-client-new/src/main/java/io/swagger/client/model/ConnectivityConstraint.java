/*
 * tapi-arof API
 * tapi-arof API generated from tapi-arof.yang
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
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Capacity;
import io.swagger.client.model.ConnectivityServiceRef;
import io.swagger.client.model.TimeRange;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConnectivityConstraint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:13:03.153+02:00")
public class ConnectivityConstraint {
  /**
   * Gets or Sets serviceType
   */
  @JsonAdapter(ServiceTypeEnum.Adapter.class)
  public enum ServiceTypeEnum {
    POINT_TO_POINT_CONNECTIVITY("POINT_TO_POINT_CONNECTIVITY"),
    
    POINT_TO_MULTIPOINT_CONNECTIVITY("POINT_TO_MULTIPOINT_CONNECTIVITY"),
    
    MULTIPOINT_CONNECTIVITY("MULTIPOINT_CONNECTIVITY"),
    
    ROOTED_MULTIPOINT_CONNECTIVITY("ROOTED_MULTIPOINT_CONNECTIVITY");

    private String value;

    ServiceTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ServiceTypeEnum fromValue(String text) {
      for (ServiceTypeEnum b : ServiceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ServiceTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ServiceTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ServiceTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ServiceTypeEnum.fromValue(String.valueOf(value));
      }
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
  @JsonAdapter(ServiceLayerEnum.Adapter.class)
  public enum ServiceLayerEnum {
    ODU("ODU"),
    
    ETH("ETH"),
    
    DSR("DSR"),
    
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    ServiceLayerEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ServiceLayerEnum fromValue(String text) {
      for (ServiceLayerEnum b : ServiceLayerEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ServiceLayerEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ServiceLayerEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ServiceLayerEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ServiceLayerEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("service-layer")
  private ServiceLayerEnum serviceLayer = null;

  @SerializedName("service-level")
  private String serviceLevel = null;

  @SerializedName("diversity-exclusion")
  private List<ConnectivityServiceRef> diversityExclusion = null;

  /**
   * Gets or Sets connectivityDirection
   */
  @JsonAdapter(ConnectivityDirectionEnum.Adapter.class)
  public enum ConnectivityDirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    UNIDIRECTIONAL("UNIDIRECTIONAL"),
    
    UNDEFINED_OR_UNKNOWN("UNDEFINED_OR_UNKNOWN");

    private String value;

    ConnectivityDirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ConnectivityDirectionEnum fromValue(String text) {
      for (ConnectivityDirectionEnum b : ConnectivityDirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ConnectivityDirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ConnectivityDirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ConnectivityDirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ConnectivityDirectionEnum.fromValue(String.valueOf(value));
      }
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "An abstract value the meaning of which is mutually agreed – typically represents metrics such as - Class of service, priority, resiliency, availability")
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
    if (this.diversityExclusion == null) {
      this.diversityExclusion = new ArrayList<ConnectivityServiceRef>();
    }
    this.diversityExclusion.add(diversityExclusionItem);
    return this;
  }

   /**
   * Get diversityExclusion
   * @return diversityExclusion
  **/
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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

