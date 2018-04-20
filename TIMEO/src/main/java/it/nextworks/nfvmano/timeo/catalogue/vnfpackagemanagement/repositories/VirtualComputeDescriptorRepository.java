package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.common.elements.VirtualComputeDesc;

public interface VirtualComputeDescriptorRepository extends JpaRepository<VirtualComputeDesc, Long> {
	List<VirtualComputeDesc> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	List<VirtualComputeDesc> findByAppdAppDIdAndAppdAppDVersion(String appdId, String version);
	Optional<VirtualComputeDesc> findByVirtualComputeDescIdAndVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vcdId, String vnfdId, String vnfProvider, String version);
	Optional<VirtualComputeDesc> findByVirtualComputeDescIdAndAppdAppDIdAndAppdAppDVersion(String vcdId, String appdId, String version);
}
