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

import java.util.List;

import it.nextworks.nfvmano.libs.common.exceptions.FailedOperationException;
import it.nextworks.nfvmano.timeo.common.exception.RemoteEntityFailureException;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.WrapperComputeNode;


public class VimWrapperPlugin {

	
	private String wrapperIp;
	private int wrapperPort;
	
	public VimWrapperPlugin(String wrapperIp, int wrapperPort){
		this.wrapperIp = wrapperIp;
		this.wrapperPort = wrapperPort;
	}

//	public void setWrapperIp(String wrapperIp) {
//		this.wrapperIp = wrapperIp;
//	}
//
//	public void setWrapperPort(int wrapperPort) {
//		this.wrapperPort = wrapperPort;
//	}

	public String getWrapperIp() {
		return wrapperIp;
	}

	public int getWrapperPort() {
		return wrapperPort;
	}
	
	public List<WrapperComputeNode> getComputeDataForAlgorithm() throws RemoteEntityFailureException, FailedOperationException{
		VimWrapperRestClient client = new VimWrapperRestClient(this.wrapperIp, this.wrapperPort);
		return client.getComputeNodesForAnalytics();
		
	}
			
}
