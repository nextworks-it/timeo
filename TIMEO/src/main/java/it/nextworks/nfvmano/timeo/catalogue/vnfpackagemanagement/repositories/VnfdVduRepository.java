package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.Vdu;



public interface VnfdVduRepository extends JpaRepository<Vdu, Long> {
	List<Vdu> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	Optional<Vdu> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersionAndVduId(String vnfdId, String vnfProvider, String version, String vduId);
}
