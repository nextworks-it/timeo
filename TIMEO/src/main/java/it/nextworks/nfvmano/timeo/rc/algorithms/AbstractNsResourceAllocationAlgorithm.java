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
package it.nextworks.nfvmano.timeo.rc.algorithms;

import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.descriptors.nsd.Nsd;
import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;
import it.nextworks.nfvmano.libs.osmanfvo.nslcm.interfaces.messages.ScaleNsRequest;
import it.nextworks.nfvmano.libs.records.nsinfo.NsInfo;
import it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.VnfPackageManagementService;
import it.nextworks.nfvmano.timeo.common.exception.ResourceAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.common.exception.ScaleAllocationSolutionNotFound;
import it.nextworks.nfvmano.timeo.rc.elements.NsScaleSchedulingSolution;
import it.nextworks.nfvmano.timeo.sbdriver.sdn.SdnControllerPlugin;
import it.nextworks.nfvmano.timeo.sbdriver.vim.VimPlugin;

import java.util.Map;

public abstract class AbstractNsResourceAllocationAlgorithm implements NsResourceAllocationAlgorithmInterface {

	AlgorithmType type;
	
	public AbstractNsResourceAllocationAlgorithm(AlgorithmType type) {
		this.type = type;
	}


	public NsScaleSchedulingSolution computeNsScaleAllocationSolution(
							ScaleNsRequest request,
							NsInfo nsi,
							Nsd nsd,
							Map<Vnfd, Map<String, String>> vnfds,
							VimPlugin vimPlugin,
							SdnControllerPlugin sdnPlugin,
							VnfPackageManagementService vnfService) throws NotExistingEntityException, ScaleAllocationSolutionNotFound

	{
		throw new ScaleAllocationSolutionNotFound("Method not implemented");
	}

}
