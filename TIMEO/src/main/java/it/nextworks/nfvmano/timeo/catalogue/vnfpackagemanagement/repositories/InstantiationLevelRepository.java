package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiationLevel;



public interface InstantiationLevelRepository extends JpaRepository<InstantiationLevel, Long> {
	List<InstantiationLevel> findByVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String flavourId, String vnfdId, String vnfProvider, String version);
	Optional<InstantiationLevel> findByLevelIdAndVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String levelId, String flavourId, String vnfdId, String vnfProvider, String version);
}
