package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;


import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;

import it.nextworks.nfvmano.timeo.rc.elements.TopologyNode;

import java.util.List;

public class TapiTopologyObfnCp  extends TapiTopologyCp{

    private TapiObfnCpSpec tapiObfnCpSpec;
    private TapiCpDirection direction;
    private List<Integer> usedBeams;

    public TapiTopologyObfnCp(TopologyNode node,
                              String sipUuid, TapiObfnCpSpec tapiObfnCpSpec, TapiCpDirection direction, List<Integer> usedBeams) {
        super(node, LayerProtocol.OBFN, null, null, sipUuid, sipUuid);
        this.tapiObfnCpSpec = tapiObfnCpSpec;
        this.direction = direction;
        this.usedBeams=usedBeams;
    }


    public TapiObfnCpSpec getTapiObfnCpSpec() {
        return tapiObfnCpSpec;
    }

    public TapiCpDirection getDirection() {
        return direction;
    }


    public List<Integer> getUsedBeams() {
        return usedBeams;
    }


}
