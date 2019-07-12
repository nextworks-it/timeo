/*
 * tapi-photonic-media API
 * tapi-photonic-media API generated from tapi-photonic-media@2018-12-10.yang
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
import io.swagger.client.model.Capacity;
import io.swagger.client.model.ConnectionEndPointRef;
import io.swagger.client.model.ConnectivityServiceEndPoint;
import io.swagger.client.model.MediaChannelConnectivityServiceEndPointSpec;
import io.swagger.client.model.NameAndValue;
import io.swagger.client.model.OtsiConnectivityServiceEndPointSpec;
import io.swagger.client.model.ServiceInterfacePointRef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * EndPointSchema
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T14:10:37.064+02:00")
public class EndPointSchema {
  @SerializedName("local-id")
  private String localId = null;

  @SerializedName("name")
  private List<NameAndValue> name = null;

  /**
   * Gets or Sets administrativeState
   */
  @JsonAdapter(AdministrativeStateEnum.Adapter.class)
  public enum AdministrativeStateEnum {
    LOCKED("LOCKED"),
    
    UNLOCKED("UNLOCKED");

    private String value;

    AdministrativeStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AdministrativeStateEnum fromValue(String text) {
      for (AdministrativeStateEnum b : AdministrativeStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<AdministrativeStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AdministrativeStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AdministrativeStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return AdministrativeStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("administrative-state")
  private AdministrativeStateEnum administrativeState = null;

  /**
   * Gets or Sets lifecycleState
   */
  @JsonAdapter(LifecycleStateEnum.Adapter.class)
  public enum LifecycleStateEnum {
    PLANNED("PLANNED"),
    
    POTENTIAL_AVAILABLE("POTENTIAL_AVAILABLE"),
    
    POTENTIAL_BUSY("POTENTIAL_BUSY"),
    
    INSTALLED("INSTALLED"),
    
    PENDING_REMOVAL("PENDING_REMOVAL");

    private String value;

    LifecycleStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LifecycleStateEnum fromValue(String text) {
      for (LifecycleStateEnum b : LifecycleStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LifecycleStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LifecycleStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LifecycleStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LifecycleStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("lifecycle-state")
  private LifecycleStateEnum lifecycleState = null;

  /**
   * Gets or Sets operationalState
   */
  @JsonAdapter(OperationalStateEnum.Adapter.class)
  public enum OperationalStateEnum {
    DISABLED("DISABLED"),
    
    ENABLED("ENABLED");

    private String value;

    OperationalStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OperationalStateEnum fromValue(String text) {
      for (OperationalStateEnum b : OperationalStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OperationalStateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationalStateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OperationalStateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OperationalStateEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("operational-state")
  private OperationalStateEnum operationalState = null;

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

  @SerializedName("layer-protocol-qualifier")
  private String layerProtocolQualifier = null;

  @SerializedName("capacity")
  private Capacity capacity = null;

  /**
   * To specify the protection role of this Port when create or update ConnectivityService.
   */
  @JsonAdapter(ProtectionRoleEnum.Adapter.class)
  public enum ProtectionRoleEnum {
    WORK("WORK"),
    
    PROTECT("PROTECT"),
    
    PROTECTED("PROTECTED"),
    
    NA("NA"),
    
    WORK_RESTORE("WORK_RESTORE"),
    
    PROTECT_RESTORE("PROTECT_RESTORE");

    private String value;

    ProtectionRoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProtectionRoleEnum fromValue(String text) {
      for (ProtectionRoleEnum b : ProtectionRoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ProtectionRoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProtectionRoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProtectionRoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ProtectionRoleEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("protection-role")
  private ProtectionRoleEnum protectionRole = null;

  /**
   * Gets or Sets layerProtocolName
   */
  @JsonAdapter(LayerProtocolNameEnum.Adapter.class)
  public enum LayerProtocolNameEnum {
    ODU("ODU"),
    
    ETH("ETH"),
    
    DSR("DSR"),
    
    PHOTONIC_MEDIA("PHOTONIC_MEDIA");

    private String value;

    LayerProtocolNameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LayerProtocolNameEnum fromValue(String text) {
      for (LayerProtocolNameEnum b : LayerProtocolNameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LayerProtocolNameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LayerProtocolNameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LayerProtocolNameEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LayerProtocolNameEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("layer-protocol-name")
  private LayerProtocolNameEnum layerProtocolName = null;

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

  @SerializedName("service-interface-point")
  private ServiceInterfacePointRef serviceInterfacePoint = null;

  @SerializedName("connection-end-point")
  private List<ConnectionEndPointRef> connectionEndPoint = null;

  @SerializedName("media-channel-connectivity-service-end-point-spec")
  private MediaChannelConnectivityServiceEndPointSpec mediaChannelConnectivityServiceEndPointSpec = null;

  @SerializedName("otsi-connectivity-service-end-point-spec")
  private OtsiConnectivityServiceEndPointSpec otsiConnectivityServiceEndPointSpec = null;

  public EndPointSchema localId(String localId) {
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

  public EndPointSchema name(List<NameAndValue> name) {
    this.name = name;
    return this;
  }

  public EndPointSchema addNameItem(NameAndValue nameItem) {
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

  public EndPointSchema administrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

   /**
   * Get administrativeState
   * @return administrativeState
  **/
  @ApiModelProperty(value = "")
  public AdministrativeStateEnum getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnum administrativeState) {
    this.administrativeState = administrativeState;
  }

  public EndPointSchema lifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
    return this;
  }

   /**
   * Get lifecycleState
   * @return lifecycleState
  **/
  @ApiModelProperty(value = "")
  public LifecycleStateEnum getLifecycleState() {
    return lifecycleState;
  }

  public void setLifecycleState(LifecycleStateEnum lifecycleState) {
    this.lifecycleState = lifecycleState;
  }

  public EndPointSchema operationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
    return this;
  }

   /**
   * Get operationalState
   * @return operationalState
  **/
  @ApiModelProperty(value = "")
  public OperationalStateEnum getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnum operationalState) {
    this.operationalState = operationalState;
  }

  public EndPointSchema direction(DirectionEnum direction) {
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

  public EndPointSchema layerProtocolQualifier(String layerProtocolQualifier) {
    this.layerProtocolQualifier = layerProtocolQualifier;
    return this;
  }

   /**
   * Get layerProtocolQualifier
   * @return layerProtocolQualifier
  **/
  @ApiModelProperty(value = "")
  public String getLayerProtocolQualifier() {
    return layerProtocolQualifier;
  }

  public void setLayerProtocolQualifier(String layerProtocolQualifier) {
    this.layerProtocolQualifier = layerProtocolQualifier;
  }

  public EndPointSchema capacity(Capacity capacity) {
    this.capacity = capacity;
    return this;
  }

   /**
   * Get capacity
   * @return capacity
  **/
  @ApiModelProperty(value = "")
  public Capacity getCapacity() {
    return capacity;
  }

  public void setCapacity(Capacity capacity) {
    this.capacity = capacity;
  }

  public EndPointSchema protectionRole(ProtectionRoleEnum protectionRole) {
    this.protectionRole = protectionRole;
    return this;
  }

   /**
   * To specify the protection role of this Port when create or update ConnectivityService.
   * @return protectionRole
  **/
  @ApiModelProperty(value = "To specify the protection role of this Port when create or update ConnectivityService.")
  public ProtectionRoleEnum getProtectionRole() {
    return protectionRole;
  }

  public void setProtectionRole(ProtectionRoleEnum protectionRole) {
    this.protectionRole = protectionRole;
  }

  public EndPointSchema layerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
    return this;
  }

   /**
   * Get layerProtocolName
   * @return layerProtocolName
  **/
  @ApiModelProperty(value = "")
  public LayerProtocolNameEnum getLayerProtocolName() {
    return layerProtocolName;
  }

  public void setLayerProtocolName(LayerProtocolNameEnum layerProtocolName) {
    this.layerProtocolName = layerProtocolName;
  }

  public EndPointSchema role(RoleEnum role) {
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

  public EndPointSchema serviceInterfacePoint(ServiceInterfacePointRef serviceInterfacePoint) {
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

  public EndPointSchema connectionEndPoint(List<ConnectionEndPointRef> connectionEndPoint) {
    this.connectionEndPoint = connectionEndPoint;
    return this;
  }

  public EndPointSchema addConnectionEndPointItem(ConnectionEndPointRef connectionEndPointItem) {
    if (this.connectionEndPoint == null) {
      this.connectionEndPoint = new ArrayList<ConnectionEndPointRef>();
    }
    this.connectionEndPoint.add(connectionEndPointItem);
    return this;
  }

   /**
   * Get connectionEndPoint
   * @return connectionEndPoint
  **/
  @ApiModelProperty(value = "")
  public List<ConnectionEndPointRef> getConnectionEndPoint() {
    return connectionEndPoint;
  }

  public void setConnectionEndPoint(List<ConnectionEndPointRef> connectionEndPoint) {
    this.connectionEndPoint = connectionEndPoint;
  }

  public EndPointSchema mediaChannelConnectivityServiceEndPointSpec(MediaChannelConnectivityServiceEndPointSpec mediaChannelConnectivityServiceEndPointSpec) {
    this.mediaChannelConnectivityServiceEndPointSpec = mediaChannelConnectivityServiceEndPointSpec;
    return this;
  }

   /**
   * Get mediaChannelConnectivityServiceEndPointSpec
   * @return mediaChannelConnectivityServiceEndPointSpec
  **/
  @ApiModelProperty(value = "")
  public MediaChannelConnectivityServiceEndPointSpec getMediaChannelConnectivityServiceEndPointSpec() {
    return mediaChannelConnectivityServiceEndPointSpec;
  }

  public void setMediaChannelConnectivityServiceEndPointSpec(MediaChannelConnectivityServiceEndPointSpec mediaChannelConnectivityServiceEndPointSpec) {
    this.mediaChannelConnectivityServiceEndPointSpec = mediaChannelConnectivityServiceEndPointSpec;
  }

  public EndPointSchema otsiConnectivityServiceEndPointSpec(OtsiConnectivityServiceEndPointSpec otsiConnectivityServiceEndPointSpec) {
    this.otsiConnectivityServiceEndPointSpec = otsiConnectivityServiceEndPointSpec;
    return this;
  }

   /**
   * Get otsiConnectivityServiceEndPointSpec
   * @return otsiConnectivityServiceEndPointSpec
  **/
  @ApiModelProperty(value = "")
  public OtsiConnectivityServiceEndPointSpec getOtsiConnectivityServiceEndPointSpec() {
    return otsiConnectivityServiceEndPointSpec;
  }

  public void setOtsiConnectivityServiceEndPointSpec(OtsiConnectivityServiceEndPointSpec otsiConnectivityServiceEndPointSpec) {
    this.otsiConnectivityServiceEndPointSpec = otsiConnectivityServiceEndPointSpec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndPointSchema endPointSchema = (EndPointSchema) o;
    return Objects.equals(this.localId, endPointSchema.localId) &&
        Objects.equals(this.name, endPointSchema.name) &&
        Objects.equals(this.administrativeState, endPointSchema.administrativeState) &&
        Objects.equals(this.lifecycleState, endPointSchema.lifecycleState) &&
        Objects.equals(this.operationalState, endPointSchema.operationalState) &&
        Objects.equals(this.direction, endPointSchema.direction) &&
        Objects.equals(this.layerProtocolQualifier, endPointSchema.layerProtocolQualifier) &&
        Objects.equals(this.capacity, endPointSchema.capacity) &&
        Objects.equals(this.protectionRole, endPointSchema.protectionRole) &&
        Objects.equals(this.layerProtocolName, endPointSchema.layerProtocolName) &&
        Objects.equals(this.role, endPointSchema.role) &&
        Objects.equals(this.serviceInterfacePoint, endPointSchema.serviceInterfacePoint) &&
        Objects.equals(this.connectionEndPoint, endPointSchema.connectionEndPoint) &&
        Objects.equals(this.mediaChannelConnectivityServiceEndPointSpec, endPointSchema.mediaChannelConnectivityServiceEndPointSpec) &&
        Objects.equals(this.otsiConnectivityServiceEndPointSpec, endPointSchema.otsiConnectivityServiceEndPointSpec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localId, name, administrativeState, lifecycleState, operationalState, direction, layerProtocolQualifier, capacity, protectionRole, layerProtocolName, role, serviceInterfacePoint, connectionEndPoint, mediaChannelConnectivityServiceEndPointSpec, otsiConnectivityServiceEndPointSpec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndPointSchema {\n");
    
    sb.append("    localId: ").append(toIndentedString(localId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    lifecycleState: ").append(toIndentedString(lifecycleState)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
    sb.append("    layerProtocolQualifier: ").append(toIndentedString(layerProtocolQualifier)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    protectionRole: ").append(toIndentedString(protectionRole)).append("\n");
    sb.append("    layerProtocolName: ").append(toIndentedString(layerProtocolName)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    serviceInterfacePoint: ").append(toIndentedString(serviceInterfacePoint)).append("\n");
    sb.append("    connectionEndPoint: ").append(toIndentedString(connectionEndPoint)).append("\n");
    sb.append("    mediaChannelConnectivityServiceEndPointSpec: ").append(toIndentedString(mediaChannelConnectivityServiceEndPointSpec)).append("\n");
    sb.append("    otsiConnectivityServiceEndPointSpec: ").append(toIndentedString(otsiConnectivityServiceEndPointSpec)).append("\n");
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
