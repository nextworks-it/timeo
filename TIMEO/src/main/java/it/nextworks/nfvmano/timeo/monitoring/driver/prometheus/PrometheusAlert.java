package it.nextworks.nfvmano.timeo.monitoring.driver.prometheus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco Capitani on 21/06/19.
 *
 * @author Marco Capitani <m.capitani AT nextworks.it>
 */
public class PrometheusAlert {

    @NotNull
    @NotBlank
    private String status;

    @NotNull
    private Map<String, String> labels;

    private Map<String, String> annotations;

    private Instant startsAt;

    private Instant endsAt;

    private String generatorURL;

    public String getStatus() {
        return status;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonSerialize(using = CustomInstantSerializer.class)
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    public Instant getStartsAt() {
        return startsAt;
    }

    @JsonSerialize(using = CustomInstantSerializer.class)
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    public Instant getEndsAt() {
        return endsAt;
    }

    public String getGeneratorURL() {
        return generatorURL;
    }

    public static class CustomInstantDeserializer extends JsonDeserializer<Instant> {

        private List<DateTimeFormatter> formatters = Arrays.asList(
                DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX"),
                DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSXXX"),
                DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSXXX"),
                DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssXXX")
        );

        @Override
        public Instant deserialize(JsonParser jp, DeserializationContext deserializationContext)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            String str = node.asText();
            DateTimeParseException lastExc = null;
            for (DateTimeFormatter f : formatters) {
                try {
                    return f.parse(str, Instant::from);
                } catch (DateTimeParseException exc) {
                    lastExc = exc;
                }
            }
            //noinspection ConstantConditions
            throw lastExc;
        }
    }

//    public static class CustomInstantDeserializer extends InstantDeserializer<Instant> {
//        public CustomInstantDeserializer() {
//            super(
//                    InstantDeserializer.INSTANT,
//                    DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSXXX")
//            );
//        }
//    }

    public static class CustomInstantSerializer extends InstantSerializer {
        public CustomInstantSerializer() {
            super(
                    InstantSerializer.INSTANCE,
                    false,
                    DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.SSSSSSXXX")
                            .withZone(ZoneId.systemDefault())
            );
        }
    }
}
