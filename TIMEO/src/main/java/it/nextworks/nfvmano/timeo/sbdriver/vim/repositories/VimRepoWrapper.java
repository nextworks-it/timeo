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
package it.nextworks.nfvmano.timeo.sbdriver.vim.repositories;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nextworks.nfvmano.libs.common.exceptions.AlreadyExistingEntityException;
import it.nextworks.nfvmano.libs.common.exceptions.NotExistingEntityException;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;
import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualNetworkInterfaceData;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.Cidr;
import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.FloatingIp;

@Service
public class VimRepoWrapper {

	private static final Logger log = LoggerFactory.getLogger(VimRepoWrapper.class);
	
	@Autowired
	private CidrRepository cidrRepository;

	@Autowired
	private FloatingIpRepository floatingRepository;
	
	@Autowired
	private VirtualComputeFlavourRepository virtualComputeFlavourRepository;
	
	@Autowired
	private VirtualNetworkInterfaceDataRepository vnicDataRepository;
	
	public VimRepoWrapper() { }
	
	public List<Cidr> retrieveCidr(String vimId) throws NotExistingEntityException {
		try {
			List<Cidr> cidrList = cidrRepository.findByvimIdAndFree(vimId, true);
			return cidrList;
		} catch (Exception e) {
			log.error("An error occurred when gathering cidr list from database: " + e.getMessage());
			throw new NotExistingEntityException (
					"An error occurred when gathering cidr list from database: " + e.getMessage());
		}
	}
	
	public void setCidrFree(String vimId, String cidr) {
		Optional<Cidr> targetOpt = cidrRepository.findByCidrAndVimId(cidr, vimId);
		if(targetOpt.isPresent()){
			Cidr target = targetOpt.get();
			target.setFree(true);
			cidrRepository.saveAndFlush(target);
		} 
	}
	
	public void storeCidr(Cidr cidr) {
		cidrRepository.saveAndFlush(cidr);
	}
	
	public void storeFloatingIp(String vimId, String portId, String floatingId) {
		FloatingIp floatingElement = new FloatingIp(vimId, portId, floatingId);
		floatingRepository.saveAndFlush(floatingElement);
	}
	
	public FloatingIp retrieveFloatingIpByPortId(String portId) {
		Optional<FloatingIp> floatingIp = floatingRepository.findByPortId(portId);
		if (floatingIp.isPresent()) return floatingIp.get();
		else return null;
	}
	
	public void removeFloatingIp(String portId) {
		FloatingIp floatingIp = retrieveFloatingIpByPortId(portId);
		if (floatingIp != null) floatingRepository.delete(floatingIp);
	}
	
	public String storeVirtualComputeFlavour(VirtualComputeFlavour vcf) throws AlreadyExistingEntityException {
		log.debug("Storing new Virtual Compute Flavour");
		if (vcf.getFlavourId() != null) {
			Optional<VirtualComputeFlavour> vcfOpt = virtualComputeFlavourRepository.findByFlavourId(vcf.getFlavourId());
			if (vcfOpt.isPresent()) {
				log.error("A VCF with the same flavour ID is already present. Impossible to store a new one.");
				throw new AlreadyExistingEntityException("A VCF with the same flavour ID is already present. Impossible to store a new one.");
			}
		}
		
		VirtualComputeFlavour target = new VirtualComputeFlavour(null, vcf.getAccelerationCapability(), vcf.getVirtualMemory(), vcf.getVirtualCpu(), vcf.getStorageAttributes());
		virtualComputeFlavourRepository.saveAndFlush(target);
		Long id = target.getId();
		String flavourId = id.toString();
		target.setFlavourId(flavourId);
		virtualComputeFlavourRepository.saveAndFlush(target);
		log.debug("Virtual Compute Flavour stored. ID: " + flavourId);
		List<VirtualNetworkInterfaceData> vnicData = vcf.getVirtualNetworkInterface();
		for (VirtualNetworkInterfaceData vnicD : vnicData) {
			VirtualNetworkInterfaceData targetVnic = new VirtualNetworkInterfaceData(target, vnicD.getNetworkId(), 
					vnicD.getNetworkPortId(), vnicD.getTypeVirtualNic(), vnicD.getTypeConfiguration(), vnicD.getMacAddress(),
					vnicD.getBandwidth(), vnicD.getAccelerationCapability(), vnicD.getMetadata());
			vnicDataRepository.saveAndFlush(targetVnic);
		}
		log.debug("All virtual network interface data for virtual compute flavour " + flavourId + " have been stored in internal repo.");
		return flavourId;
	}
	
	public VirtualComputeFlavour retrieveVirtualComputeFlavour(String flavourId) throws NotExistingEntityException {
		log.debug("Retrieving virtual compute flavour with flavour ID " + flavourId);
		Optional<VirtualComputeFlavour> vcfOpt = virtualComputeFlavourRepository.findByFlavourId(flavourId);
		if (vcfOpt.isPresent()) {
			return vcfOpt.get();
		} else {
			log.error("Virtual Compute Flavour with ID " + flavourId + " not found in DB");
			throw new NotExistingEntityException("Virtual Compute Flavour with ID " + flavourId + " not found in DB");
		}
	}
	
	public List<VirtualComputeFlavour> retrieveAllVirtualComputeFlavour() {
		log.debug("Retrieving all the virtual compute flavours");
		return virtualComputeFlavourRepository.findAll();
	}
	
	public void removeVirtualComputeFlavour(String flavourId) throws NotExistingEntityException {
		log.debug("Removing virtual compute flavour with ID " + flavourId);
		VirtualComputeFlavour vcf = retrieveVirtualComputeFlavour(flavourId);
		virtualComputeFlavourRepository.delete(vcf);
	}

}
