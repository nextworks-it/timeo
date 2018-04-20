package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public abstract class Classifier {

    private TrafficClassifierType type;

    public Classifier(TrafficClassifierType type) {
        this.type = type;
    }

    public TrafficClassifierType getType() {
        return type;
    }
}
