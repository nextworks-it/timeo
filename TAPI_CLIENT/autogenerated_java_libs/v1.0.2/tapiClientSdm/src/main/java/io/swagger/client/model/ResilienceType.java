/*
 * tapi-sdm API
 * tapi-sdm API generated from tapi-sdm.yang
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
import java.io.IOException;

/**
 * ResilienceType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-07-09T13:10:07.918+02:00")
public class ResilienceType {
  /**
   * Gets or Sets restorationPolicy
   */
  @JsonAdapter(RestorationPolicyEnum.Adapter.class)
  public enum RestorationPolicyEnum {
    PER_DOMAIN_RESTORATION("PER_DOMAIN_RESTORATION"),
    
    END_TO_END_RESTORATION("END_TO_END_RESTORATION"),
    
    NA("NA");

    private String value;

    RestorationPolicyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RestorationPolicyEnum fromValue(String text) {
      for (RestorationPolicyEnum b : RestorationPolicyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RestorationPolicyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RestorationPolicyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RestorationPolicyEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RestorationPolicyEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("restoration-policy")
  private RestorationPolicyEnum restorationPolicy = null;

  /**
   * Gets or Sets protectionType
   */
  @JsonAdapter(ProtectionTypeEnum.Adapter.class)
  public enum ProtectionTypeEnum {
    NO_PROTECTON("NO_PROTECTON"),
    
    ONE_PLUS_ONE_PROTECTION("ONE_PLUS_ONE_PROTECTION"),
    
    ONE_PLUS_ONE_PROTECTION_WITH_DYNAMIC_RESTORATION("ONE_PLUS_ONE_PROTECTION_WITH_DYNAMIC_RESTORATION"),
    
    PERMANENT_ONE_PLUS_ONE_PROTECTION("PERMANENT_ONE_PLUS_ONE_PROTECTION"),
    
    ONE_FOR_ONE_PROTECTION("ONE_FOR_ONE_PROTECTION"),
    
    DYNAMIC_RESTORATION("DYNAMIC_RESTORATION"),
    
    PRE_COMPUTED_RESTORATION("PRE_COMPUTED_RESTORATION");

    private String value;

    ProtectionTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProtectionTypeEnum fromValue(String text) {
      for (ProtectionTypeEnum b : ProtectionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ProtectionTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProtectionTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProtectionTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ProtectionTypeEnum.fromValue(String.valueOf(value));
      }
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
  @ApiModelProperty(value = "")
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
  @ApiModelProperty(value = "")
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

