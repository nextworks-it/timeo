package it.nextworks.nfvmano.timeo.monitoring.driver.prometheus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
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

    public Instant getStartsAt() {
        return startsAt;
    }

    public Instant getEndsAt() {
        return endsAt;
    }

    public String getGeneratorURL() {
        return generatorURL;
    }
}
