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
package it.nextworks.nfvmano.timeo.sbdriver.vim.wrapper;

public class VirtualMachineType {

	private String id;
	private String node;
	private String flavor;
	private int full_pc;
	private int traffic_pc;
	private int idle_pc;
	
	public VirtualMachineType(){
		
	}
	
	public VirtualMachineType(String id, String node, String flavor, 
					int full_pc, int traffic_pc, int idle_pc
			){
		this.id = id;
		this.node = node;
		this.flavor = flavor;
		this.full_pc = full_pc;
		this.traffic_pc = traffic_pc;
		this.idle_pc = idle_pc;
	}

	public String getId() {
		return id;
	}

	public String getNode() {
		return node;
	}

	public String getFlavor() {
		return flavor;
	}

	public int getFull_pc() {
		return full_pc;
	}

	public int getTraffic_pc() {
		return traffic_pc;
	}

	public int getIdle_pc() {
		return idle_pc;
	}
	
}
