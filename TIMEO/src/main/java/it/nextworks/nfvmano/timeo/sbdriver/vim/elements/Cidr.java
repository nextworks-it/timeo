/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
