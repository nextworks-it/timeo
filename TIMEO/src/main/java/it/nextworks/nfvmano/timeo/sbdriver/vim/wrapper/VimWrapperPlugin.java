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
