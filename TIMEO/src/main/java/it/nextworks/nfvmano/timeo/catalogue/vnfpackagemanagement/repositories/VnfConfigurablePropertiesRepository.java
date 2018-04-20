package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfConfigurableProperties;




public interface VnfConfigurablePropertiesRepository extends JpaRepository<VnfConfigurableProperties, Long> {
	Optional<VnfConfigurableProperties> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
}
