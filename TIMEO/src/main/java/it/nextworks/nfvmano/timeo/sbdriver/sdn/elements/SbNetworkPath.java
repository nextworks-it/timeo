package it.nextworks.nfvmano.timeo.sbdriver.sdn.elements;



import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.timeo.rc.elements.NetworkPathHop;

/**
 * Created by Francesca Moscatelli on 19/04/17.
 *
 * @author Nextworks S.r.l. (f.moscatelli AT nextworks.it)
 */
public class SbNetworkPath {

    private String networkPathId;

    private String tenantId;

    private List<NetworkPathHop> hops = new ArrayList<>();

    private Classifier trafficClassifier;

    public SbNetworkPath(String networkPathId,
                         String tenantId,
                         List<NetworkPathHop> hops,
                         Classifier trafficClassifier) {
        this.networkPathId = networkPathId;
        this.tenantId = tenantId;
        if (hops != null) this.hops = hops;
        this.trafficClassifier = trafficClassifier;
    }

    public String getNetworkPathId() {
        return networkPathId;
    }

    public String getTenantId() { return  tenantId; }

    public List<NetworkPathHop> getHops() {
        return hops;
    }

    public Classifier getTrafficClassifier() {
        return trafficClassifier;
    }
}
