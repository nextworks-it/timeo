package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfdElementGroup;



public interface VnfdElementGroupRepository extends JpaRepository<VnfdElementGroup, Long> {
	List<VnfdElementGroup> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	Optional<VnfdElementGroup> findByVnfdElementGroupIdAndVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String egId, String vnfdId, String vnfProvider, String version);
}
