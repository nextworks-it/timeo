package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfVirtualLinkDesc;



public interface VnfVirtualLinkDescriptorRepository extends JpaRepository<VnfVirtualLinkDesc, Long> {
	List<VnfVirtualLinkDesc> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	Optional<VnfVirtualLinkDesc> findByVirtualLinkDescIdAndVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vldId, String vnfdId, String vnfProvider, String version);
}
