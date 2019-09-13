package it.nextworks.nfvmano.timeo.rc.algorithms.bluespace.messages;

import it.nextworks.nfvmano.libs.bluespace.algorithm.elements.RrhBeam;

import java.util.ArrayList;
import java.util.List;

public class RrhInfoResponseMessage {

    private List<RrhBeam> rrhBeams = new ArrayList<>();

    public RrhInfoResponseMessage(List<RrhBeam> rrhBeams){

        if(rrhBeams !=null)
            this.rrhBeams = rrhBeams;

    }


    public List<RrhBeam> getRrhBeams(){
        return rrhBeams;
    }
}
