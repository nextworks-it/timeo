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