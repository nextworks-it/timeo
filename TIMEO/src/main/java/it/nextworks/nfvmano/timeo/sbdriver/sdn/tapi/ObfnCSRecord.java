package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class ObfnCSRecord {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;


    private String obfnCsId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch= FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)

    private Map<String, String>  interDcIdToObfnBeam;

    public ObfnCSRecord(String obfnCsId, Map<String, String> interDcIdToObfnBeam) {
        this.obfnCsId = obfnCsId;
        if(interDcIdToObfnBeam!=null)
            this.interDcIdToObfnBeam = interDcIdToObfnBeam;
    }

    public String getObfnCsId() {
        return obfnCsId;
    }

    public Map<String, String> getInterDcIdToObfnBeam() {
        return interDcIdToObfnBeam;
    }

    public ObfnCSRecord() {
    }

    public void addInterDcPath(String interDcId, String obfnId){
        interDcIdToObfnBeam.put(interDcId, obfnId);
    }


}
