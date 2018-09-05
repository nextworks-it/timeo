package it.nextworks.nfvmano.timeo.vnfm.pnfm;

import java.util.ArrayList;
import java.util.List;

import it.nextworks.nfvmano.libs.common.InterfaceMessage;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;

/**
 * Response to a PNF query
 * 
 * @author nextworks
 *
 */
public class QueryPnfResponse implements InterfaceMessage {

	private List<PnfInfo> pnfInfo = new ArrayList<>();
	
	public QueryPnfResponse() {	}
	
	/**
	 * Constructor
	 * 
	 * @param pnfInfo The information items about the selected PNFs to be returned
	 */
	public QueryPnfResponse(List<PnfInfo> pnfInfo) {
		if (pnfInfo != null) this.pnfInfo = pnfInfo;
	}
	
	

	/**
	 * @return the pnfInfo
	 */
	public List<PnfInfo> getPnfInfo() {
		return pnfInfo;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		for (PnfInfo pi : pnfInfo) pi.isValid();
	}

}
