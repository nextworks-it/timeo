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
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	private static String stingifyVnic(VirtualNetworkInterfaceData vni) {
		StringBuilder output = new StringBuilder();

		// aCaps: sort, then stringify
		StringBuilder stringACaps =
				vni.getAccelerationCapability().stream()
						.map(String::toLowerCase) // Remove case differences
						.sorted(String.CASE_INSENSITIVE_ORDER) // Sort
						.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		output.append(stringACaps);
		output.append('_');

		output.append(vni.getBandwidth());
		output.append('_');

		output.append(vni.getMacAddress());
		output.append('_');

		// Metadata: sort by key, then stringify
		StringBuilder stringMD = vni.getMetadata().keySet().stream()
				.sorted(String.CASE_INSENSITIVE_ORDER) // Sort keys (case insensitive)
				.map(s -> s.toLowerCase() + '_' + vni.getMetadata().get(s)) // Remove case differences on keys
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		output.append(stringMD);
		output.append('_');

		output.append(vni.getNetworkId());
		output.append('_');

		output.append(vni.getNetworkPortId());
		output.append('_');

		// TypeConfig: sort by key, then stringify
		StringBuilder stringTC = vni.getTypeConfiguration().stream()
				.map(String::toLowerCase) // Remove case differences on keys
				.sorted(String.CASE_INSENSITIVE_ORDER) // Sort (case insensitive)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		output.append(stringTC);
		output.append('_');

		output.append(vni.getTypeVirtualNic());
		output.append('_');

		return output.toString();
	}

	public static boolean compareVcf(VirtualComputeFlavour oldVcf, VirtualComputeFlavour newVcf) {

		// Compare IDs
		if (!oldVcf.getFlavourId().equals(newVcf.getFlavourId())) {
			return false;
		}

		// Compare storages
		// Change into list of strings -> 'type_size' to ease comparison
		// Then collect into maps string -> number of appearances, and compare those
		Map<String, Long> oldSaStringified = oldVcf.getStorageAttributes().stream()
				.map(vsd -> vsd.getTypeOfStorage() + '_' + String.valueOf(vsd.getSizeOfStorage()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<String, Long> newSaStringified = newVcf.getStorageAttributes().stream()
				.map(vsd -> vsd.getTypeOfStorage() + '_' + String.valueOf(vsd.getSizeOfStorage()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		if (!oldSaStringified.equals(newSaStringified)) {
			return false;
		}

		// Compare VNics
		// Stringify, even though its less straightforward than above
		// We can collect them in a set since they contain the MAC, which is unique
		Set<String> oldVnicStringified = oldVcf.getVirtualNetworkInterface().stream().map(
				VimRepoWrapper::stingifyVnic
		).collect(Collectors.toSet());
		Set<String> newVnicStringified = newVcf.getVirtualNetworkInterface().stream().map(
				VimRepoWrapper::stingifyVnic
		).collect(Collectors.toSet());

		if (!oldVnicStringified.equals(newVnicStringified)) {
			return false;
		}

		// Virtual CPU comparison
		if (!oldVcf.getVirtualCpu().getCpuArchitecture().equals(newVcf.getVirtualCpu().getCpuArchitecture())) {
			return false;
		}
		if (!(oldVcf.getVirtualCpu().getNumVirtualCpu() == newVcf.getVirtualCpu().getNumVirtualCpu())) {
			return false;
		}
		if (!(oldVcf.getVirtualCpu().getVirtualCpuClock() == newVcf.getVirtualCpu().getVirtualCpuClock())) {
			return false;
		}
		if (!oldVcf.getVirtualCpu().getVirtualCpuOversubscriptionPolicy()
				.equals(newVcf.getVirtualCpu().getVirtualCpuOversubscriptionPolicy())) {
			return false;
		}

		// Virtual Memory comparison
		if (!oldVcf.getVirtualMemory().getVirtualMemOversubscriptionPolicy()
				.equals(newVcf.getVirtualMemory().getVirtualMemOversubscriptionPolicy())) {
			return false;
		}
		if (!(oldVcf.getVirtualMemory().getVirtualMemSize() == newVcf.getVirtualMemory().getVirtualMemSize())) {
			return false;
		}
		if (!(oldVcf.getVirtualMemory().isNumaEnabled() == newVcf.getVirtualMemory().isNumaEnabled())) {
			return false;
		}

		// all tests passed
		return true;
	}
	
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
		// The VCF contains the network ID, and it must depend on the Instance, so we
		// store it with flavour ID == table ID to avoid (impossible) reusing.
		VirtualComputeFlavour target = new VirtualComputeFlavour(null, vcf.getAccelerationCapability(), vcf.getVirtualMemory(), vcf.getVirtualCpu(), vcf.getStorageAttributes());
		virtualComputeFlavourRepository.saveAndFlush(target);
		// Save to generate the ID, then retrieve the ID and use it as flavour ID
		String flavourId = target.getId().toString();
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
