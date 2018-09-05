/*
 * tapi-path-computation API
 * tapi-path-computation API generated from tapi-path-computation@2018-03-07.yang
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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.LocalClass;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.ServiceInterfacePointRef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The association of the FC to LTPs is made via EndPoints. The EndPoint (EP) object class models the access to the FC function. The traffic forwarding between the associated EPs of the FC depends upon the type of FC and may be associated with FcSwitch object instances. In cases where there is resilience the EndPoint may convey the resilience role of the access to the FC. It can represent a protected (resilient/reliable) point or a protecting (unreliable working or protection) point. The EP replaces the Protection Unit of a traditional protection model. The ForwadingConstruct can be considered as a component and the EndPoint as a Port on that component
 */
@ApiModel(description = "The association of the FC to LTPs is made via EndPoints. The EndPoint (EP) object class models the access to the FC function. The traffic forwarding between the associated EPs of the FC depends upon the type of FC and may be associated with FcSwitch object instances. In cases where there is resilience the EndPoint may convey the resilience role of the access to the FC. It can represent a protected (resilient/reliable) point or a protecting (unreliable working or protection) point. The EP replaces the Protection Unit of a traditional protection model. The ForwadingConstruct can be considered as a component and the EndPoint as a Port on that component")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-08-07T13:54:55.433+02:00")
public class PathServiceEndPoint {
  @SerializedName("local-id")
  private String localId = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  /**
   * Gets or Sets serviceLayer
   */
  @JsonAdapter(ServiceLayerEnum.Adapter.class)
  public enum ServiceLayerEnum {
    OTSIA("OTSiA"),
    
    OCH("OCH"),
    
    OTU("OTU"),
    
    ODU("ODU"),
    
    ETH("ETH"),
    
    ETY("ETY"),
    
    SDM("SDM"),
    
    DSR("DSR");

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

  @SerializedName("service-interface-point")
  private ServiceInterfacePointRef serviceInterfacePoint = null;

  /**
   * The orientation of defined flow at the EndPoint.
   */
  @JsonAdapter(DirectionEnum.Adapter.class)
  public enum DirectionEnum {
    BIDIRECTIONAL("BIDIRECTIONAL"),
    
    INPUT("INPUT"),
    
    OUTPUT("OUTPUT"),
    
    UNIDENTIFIED_OR_UNKNOWN("UNIDENTIFIED_OR_UNKNOWN");

    private String value;

    DirectionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DirectionEnum fromValue(String text) {
      for (DirectionEnum b : DirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<DirectionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DirectionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DirectionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return DirectionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("direction")
  private DirectionEnum direction = null;

  /**
   * Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. 
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    SYMMETRIC("SYMMETRIC"),
    
    ROOT("ROOT"),
    
    LEAF("LEAF"),
    
    TRUNK("TRUNK"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RoleEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("role")
  private RoleEnum role = null;

  public PathServiceEndPoint localId(String localId) {
    this.localId = localId;
    return this;
  }

   /**
   * Get localId
   * @return localId
  **/
  @ApiModelProperty(value = "")
  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public PathServiceEndPoint name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public PathServiceEndPoint addNameItem(NameAndValue nameItem) {
    if (this.name == null) {
      this.name = new ArrayList<NameAndValue>();
    }
    this.name.add(nameItem);
    return this;
  }

   /**
   * List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.
   * @return name
  **/
  @ApiModelProperty(value = "List of names. A property of an entity with a value that is unique in some namespace but may change during the life of the entity. A name carries no semantics with respect to the purpose of the entity.")
  public List<NameAndValue> getName() {
    return name;
  }

  public void setName(List<NameAndValue> name) {
    this.name = name;
  }

  public PathServiceEndPoint serviceLayer(ServiceLayerEnum serviceLayer) {
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

  public PathServiceEndPoint serviceInterfacePoint(ServiceInterfacePointRef serviceInterfacePoint) {
    this.serviceInterfacePoint = serviceInterfacePoint;
    return this;
  }

   /**
   * Get serviceInterfacePoint
   * @return serviceInterfacePoint
  **/
  @ApiModelProperty(value = "")
  public ServiceInterfacePointRef getServiceInterfacePoint() {
    return serviceInterfacePoint;
  }

  public void setServiceInterfacePoint(ServiceInterfacePointRef serviceInterfacePoint) {
    this.serviceInterfacePoint = serviceInterfacePoint;
  }

  public PathServiceEndPoint direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * The orientation of defined flow at the EndPoint.
   * @return direction
  **/
  @ApiModelProperty(value = "The orientation of defined flow at the EndPoint.")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public PathServiceEndPoint role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. 
   * @return role
  **/
  @ApiModelProperty(value = "Each EP of the FC has a role (e.g., working, protection, protected, symmetric, hub, spoke, leaf, root)  in the context of the FC with respect to the FC function. ")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PathServiceEndPoint pathServiceEndPoint = (PathServiceEndPoint) o;
    return Objects.equals(this.localId, pathServiceEndPoint.localId) &&
        Objects.equals(this.name, pathServiceEndPoint.name) &&
        Objects.equals(this.serviceLayer, pathServiceEndPoint.serviceLayer) &&
        Objects.equals(this.serviceInterfacePoint, pathServiceEndPoint.serviceInterfacePoint) &&
        Objects.equals(this.direction, pathServiceEndPoint.direction) &&
        Objects.equals(this.role, pathServiceEndPoint.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localId, name, serviceLayer, serviceInterfacePoint, direction, role);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PathServiceEndPoint {\n");
    
    sb.append("    localId: ").append(toIndentedString(localId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    serviceLayer: ").append(toIndentedString(serviceLayer)).append("\n");
    sb.append("    serviceInterfacePoint: ").append(toIndentedString(serviceInterfacePoint)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

