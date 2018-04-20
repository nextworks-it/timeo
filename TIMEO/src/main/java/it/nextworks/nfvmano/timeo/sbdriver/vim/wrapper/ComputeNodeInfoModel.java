package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComputeNodeInfoModel {
	
	@JsonProperty("computenodes")
	private List<ComputeNode> elements;
	
	
	public ComputeNodeInfoModel(){
		
	}
	
	public ComputeNodeInfoModel(List<ComputeNode> elements){
		this.elements = elements;
	}

	public List<?> getElements() {
		return elements;
	}
	
	

	
}
