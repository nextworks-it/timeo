/*
 * Configuration Manager API
 * The API of the 5GT Monitoring Configuration Manager.
 *
 * OpenAPI spec version: 0.6
 * Contact: m.capitani@nextworks.it
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
import io.swagger.client.model.KVP;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Alert
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-04-19T14:05:07.585+02:00[Europe/Rome]")public class Alert {

  @SerializedName("alertId")
  private String alertId = null;

  @SerializedName("alertName")
  private String alertName = null;

  @SerializedName("labels")
  private List<KVP> labels = null;
  /**
   * the severity of the alert
   */
  @JsonAdapter(SeverityEnum.Adapter.class)
  public enum SeverityEnum {
    WARNING("warning"),
    ERROR("error"),
    CRITICAL("critical");

    private String value;

    SeverityEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static SeverityEnum fromValue(String text) {
      for (SeverityEnum b : SeverityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<SeverityEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SeverityEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SeverityEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SeverityEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("severity")
  private SeverityEnum severity = null;

  @SerializedName("for")
  private String _for = null;

  @SerializedName("query")
  private String query = null;

  @SerializedName("value")
  private Double value = null;
  /**
   * the kind of inequality the query should satisfy related to the value
   */
  @JsonAdapter(KindEnum.Adapter.class)
  public enum KindEnum {
    G("G"),
    GEQ("GEQ"),
    L("L"),
    LEQ("LEQ"),
    EQ("EQ"),
    NEQ("NEQ");

    private String value;

    KindEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static KindEnum fromValue(String text) {
      for (KindEnum b : KindEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<KindEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final KindEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public KindEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return KindEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("kind")
  private KindEnum kind = null;

  @SerializedName("target")
  private String target = null;
  public Alert alertId(String alertId) {
    this.alertId = alertId;
    return this;
  }

  

  /**
  * the ID assigned to the alert
  * @return alertId
  **/
  @Schema(description = "the ID assigned to the alert")
  public String getAlertId() {
    return alertId;
  }
  public void setAlertId(String alertId) {
    this.alertId = alertId;
  }
  public Alert alertName(String alertName) {
    this.alertName = alertName;
    return this;
  }

  

  /**
  * the human-readable name for the alert
  * @return alertName
  **/
  @Schema(description = "the human-readable name for the alert")
  public String getAlertName() {
    return alertName;
  }
  public void setAlertName(String alertName) {
    this.alertName = alertName;
  }
  public Alert labels(List<KVP> labels) {
    this.labels = labels;
    return this;
  }

  public Alert addLabelsItem(KVP labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<KVP>();
    }
    this.labels.add(labelsItem);
    return this;
  }

  /**
  * Get labels
  * @return labels
  **/
  @Schema(description = "")
  public List<KVP> getLabels() {
    return labels;
  }
  public void setLabels(List<KVP> labels) {
    this.labels = labels;
  }
  public Alert severity(SeverityEnum severity) {
    this.severity = severity;
    return this;
  }

  

  /**
  * the severity of the alert
  * @return severity
  **/
  @Schema(description = "the severity of the alert")
  public SeverityEnum getSeverity() {
    return severity;
  }
  public void setSeverity(SeverityEnum severity) {
    this.severity = severity;
  }
  public Alert _for(String _for) {
    this._for = _for;
    return this;
  }

  

  /**
  * the time to wait before firing an alert. Pattern [0-9]+{s,m}
  * @return _for
  **/
  @Schema(description = "the time to wait before firing an alert. Pattern [0-9]+{s,m}")
  public String getFor() {
    return _for;
  }
  public void setFor(String _for) {
    this._for = _for;
  }
  public Alert query(String query) {
    this.query = query;
    return this;
  }

  

  /**
  * the query whose value should be monitored. See https://prometheus.io/docs/prometheus/latest/querying/basics/ for details 
  * @return query
  **/
  @Schema(description = "the query whose value should be monitored. See https://prometheus.io/docs/prometheus/latest/querying/basics/ for details ")
  public String getQuery() {
    return query;
  }
  public void setQuery(String query) {
    this.query = query;
  }
  public Alert value(Double value) {
    this.value = value;
    return this;
  }

  

  /**
  * the value associated to the threshold
  * @return value
  **/
  @Schema(description = "the value associated to the threshold")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }
  public Alert kind(KindEnum kind) {
    this.kind = kind;
    return this;
  }

  

  /**
  * the kind of inequality the query should satisfy related to the value
  * @return kind
  **/
  @Schema(description = "the kind of inequality the query should satisfy related to the value")
  public KindEnum getKind() {
    return kind;
  }
  public void setKind(KindEnum kind) {
    this.kind = kind;
  }
  public Alert target(String target) {
    this.target = target;
    return this;
  }

  

  /**
  * the URL to which the notification of the violated threshold should be sent
  * @return target
  **/
  @Schema(description = "the URL to which the notification of the violated threshold should be sent")
  public String getTarget() {
    return target;
  }
  public void setTarget(String target) {
    this.target = target;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alert alert = (Alert) o;
    return Objects.equals(this.alertId, alert.alertId) &&
        Objects.equals(this.alertName, alert.alertName) &&
        Objects.equals(this.labels, alert.labels) &&
        Objects.equals(this.severity, alert.severity) &&
        Objects.equals(this._for, alert._for) &&
        Objects.equals(this.query, alert.query) &&
        Objects.equals(this.value, alert.value) &&
        Objects.equals(this.kind, alert.kind) &&
        Objects.equals(this.target, alert.target);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(alertId, alertName, labels, severity, _for, query, value, kind, target);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Alert {\n");
    
    sb.append("    alertId: ").append(toIndentedString(alertId)).append("\n");
    sb.append("    alertName: ").append(toIndentedString(alertName)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    _for: ").append(toIndentedString(_for)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
