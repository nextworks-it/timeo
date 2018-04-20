package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfDf;



public interface VnfDfRepository extends JpaRepository<VnfDf, Long> {
	List<VnfDf> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	Optional<VnfDf> findByFlavourIdAndVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String dfId, String vnfdId, String vnfProvider, String version);
}
