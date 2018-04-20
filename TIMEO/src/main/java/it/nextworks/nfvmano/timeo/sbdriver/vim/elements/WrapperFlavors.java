package it.nextworks.nfvmano.timeo.sbdriver.vim.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Marco Capitani on 22/06/17.
 *
 * @author Marco Capitani(m.capitani AT nextworks.it)
 */

public class WrapperFlavors {
	
	public WrapperFlavors() {
	
	}

	@JsonProperty("idle_pc")
	public double idlePc;

	@JsonProperty("id")
	public String id;

	@JsonProperty("traffic_pc")
	public double trafficPc;

	public double getIdlePc() {
		return idlePc;
	}

	public String getId() {
		return id;
	}

	public double getTrafficPc() {
		return trafficPc;
	}
	
}