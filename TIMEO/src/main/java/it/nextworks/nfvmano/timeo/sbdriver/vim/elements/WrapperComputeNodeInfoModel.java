package it.nextworks.nfvmano.timeo.sbdriver.vim.elements;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WrapperComputeNodeInfoModel {

	@JsonProperty("computenodes")
	private List<WrapperComputeNode> nodeList;
	
	public WrapperComputeNodeInfoModel(List<WrapperComputeNode> nodeList){
	
		for(WrapperComputeNode node : nodeList)
			this.nodeList.add(node);
	}
	
	public List<WrapperComputeNode> getElements (){
		return this.nodeList;
	}
	
}
