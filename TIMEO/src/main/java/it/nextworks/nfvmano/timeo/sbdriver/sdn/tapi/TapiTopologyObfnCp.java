package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;


import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

public class TapiTopologyObfnCp  extends TapiTopologyCp{

    TapiObfnCpSpec tapiObfnCpSpec;
    TapiCpDirection direction;

    public TapiTopologyObfnCp(TopologyNode node,
                              String sipUuid, TapiObfnCpSpec tapiObfnCpSpec, TapiCpDirection direction) {
        super(node, LayerProtocol.OBFN, null, null, sipUuid, sipUuid);
        this.tapiObfnCpSpec = tapiObfnCpSpec;
        this.direction = direction;
    }


    public TapiObfnCpSpec getTapiObfnCpSpec() {
        return tapiObfnCpSpec;
    }

    public TapiCpDirection getDirection() {
        return direction;
    }
}
