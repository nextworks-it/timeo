package it.nextworks.nfvmano.timeo.sbdriver.sdn.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class ComputedPath {

    @JsonProperty("computedStep")
    List<ComputedStep> computedStep;

    public ComputedPath(@JsonProperty("computedStep") List<ComputedStep> computedStep) {
        this.computedStep = computedStep;
    }

    @JsonProperty("computedStep")
    public List<ComputedStep> getComputedStep() {
        return computedStep;
    }
}
