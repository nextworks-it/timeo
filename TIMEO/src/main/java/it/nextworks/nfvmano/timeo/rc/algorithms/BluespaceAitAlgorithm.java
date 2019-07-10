package it.nextworks.nfvmano.timeo.rc.algorithms;

import java.util.List;
import java.util.Map;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.nsd.Pnfd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.InstantiateNsRequest;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.PnfManagementService;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstance;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NsResourceSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;
import it.nextworks.nfvmano.timeo.vnfm.VnfmHandler;

public class BluespaceAitAlgorithm extends AbstractNsResourceAllocationAlgorithm {

	private String aitAlgorithmUrl;
	private VnfPackageManagementService vnfPackageManagementService;
	private Map<String, String> properties;
	private PnfManagementService pnfManagementService;
	
	public BluespaceAitAlgorithm(String aitAlgorithmUrl,
			VnfPackageManagementService vnfPackageManagementService,
			Map<String, String> properties,
			PnfManagementService pnfManagementService) {
		super(AlgorithmType.BLUESPACE_AIT);
		this.aitAlgorithmUrl = aitAlgorithmUrl;
		this.vnfPackageManagementService = vnfPackageManagementService;
		this.pnfManagementService = pnfManagementService;
		this.properties = properties;
	}
	
	@Override
	public NsResourceSchedulingSolution computeNsResourceAllocationSolution(
			InstantiateNsRequest request,
			Nsd nsd,
			Map<Vnfd, Map<String, String>> vnfds,
			VimPlugin vimPlugin,
			SdnControllerPlugin sdnPlugin,
			VnfmHandler vnfmHandler,
			Map<String, Pnfd> pnfds,
			Map<String, List<PnfInstance>> pnfInstances
	)
			throws NotExistingEntityException, ResourceAllocationSolutionNotFound {
		//TODO:
		throw new ResourceAllocationSolutionNotFound();
	}

}
