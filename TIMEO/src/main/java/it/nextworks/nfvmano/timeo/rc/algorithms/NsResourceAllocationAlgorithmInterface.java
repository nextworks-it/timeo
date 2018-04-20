package it.nextworks.nfvmano.timeo.rc.algorithms;




import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;


public interface NsResourceAllocationAlgorithmInterface {

	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
			InstantiateNsRequest request,
			Nsd nsd,
			Map<Vnfd,Map<String, String>> vnfds,
			VimPlugin vimPlugin,
			SdnControllerPlugin sdnPlugin
	)
			throws NotExistingEntityException, ResourceAllocationSolutionNotFound;

}
