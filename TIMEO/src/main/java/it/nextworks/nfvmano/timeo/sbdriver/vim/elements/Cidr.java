package it.nextworks.nfvmano.timeo.sbdriver.vim.elements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class defines a list of cidrs available on a specific vim
 * @author elian
 *
 */
@Entity
public class Cidr{

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String cidr;

    private String vimId;

    private boolean free;

    public Cidr(){

        //JPA only
    }

    /**
     * 
     * @param cidr CIDR
     * @param vimId Id of the VIM
     * @param free boolean that indicates if the cidr is in use or not.
     */
    public Cidr(String cidr, String vimId, boolean free){
        this.cidr = cidr;
        this.vimId = vimId;
        this.free = free;
    }


    @JsonProperty("cidr")
    public String getCidr(){
        return this.cidr;
    }


    @JsonProperty("vimId")
    public String vimId(){
        return this.vimId;
    }


    @JsonProperty("free")
    public boolean isFree(){
        return this.free;
    }


    @JsonIgnore
    public void setFree(boolean free){
        this.free = free;
    }


    @JsonIgnore
    public void isValid() throws Exception {
        if(cidr == null){
            throw new Exception("CIDR cannot be null");
        }
        if(vimId == null){
            throw new Exception("vimID cannot be null");
        }
    }
}
