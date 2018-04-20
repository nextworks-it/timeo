package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VirtualMachineTypeInfoModel {
	
	@JsonProperty("vmTypes")
	private List<VirtualMachineType> elements;
	
	
	public VirtualMachineTypeInfoModel(){
		
	}
	
	public VirtualMachineTypeInfoModel(List<VirtualMachineType> elements){
		this.elements = elements;
	}

	public List<VirtualMachineType> getElements() {
		return elements;
	}
	
}
