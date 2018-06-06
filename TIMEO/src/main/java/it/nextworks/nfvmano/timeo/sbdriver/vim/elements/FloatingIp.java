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
 * The class defines a Floating IP element, related to a specific VIM
 *
 * @author Elian Kraja: e.kraja@nextworks.it
 *
 */
@Entity
public class FloatingIp {

	@Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
	
	private String vimId;
	private String portId;
	private String floatingId;
	
	
	public FloatingIp(){
		
	}
	
	/**
	 * 
	 * @param vimId Id of the VIM
	 * @param portId Id of the port attached to the Floating IP
	 * @param floatingId Id of the floating IP
	 */
	public FloatingIp(String vimId, String portId, String floatingId){
		this.vimId = vimId;
		this.portId = portId;
		this.floatingId = floatingId;
	}
	
	
	@JsonProperty("vim_id")
	public String getVimId(){
		return this.vimId;
	}
	
	@JsonProperty("port_id")
	public String getPortId(){
		return this.portId;
	}

	@JsonProperty("floating_id")
	public String getFloatingId(){
		return this.floatingId;
	}
	
	
	@JsonIgnore
    public void isValid() throws Exception {
        if(vimId == null){
            throw new Exception("Vim ID cannot be null");
        }
        if(portId == null){
            throw new Exception("Port ID cannot be null");
        }
        if(floatingId == null){
            throw new Exception("Floating ID cannot be null");
        }
    }
}
