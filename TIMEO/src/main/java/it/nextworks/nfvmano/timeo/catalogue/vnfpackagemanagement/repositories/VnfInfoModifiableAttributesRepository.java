package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfInfoModifiableAttributes;



public interface VnfInfoModifiableAttributesRepository extends JpaRepository<VnfInfoModifiableAttributes, Long> {
	Optional<VnfInfoModifiableAttributes> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
}
