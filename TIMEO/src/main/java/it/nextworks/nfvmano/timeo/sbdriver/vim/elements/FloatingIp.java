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
