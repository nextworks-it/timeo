package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfExtCpd;



public interface VnfExtCpdRepository extends JpaRepository<VnfExtCpd, Long> {
	List<VnfExtCpd> findByVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String vnfdId, String vnfProvider, String version);
	Optional<VnfExtCpd> findByCpdIdAndVnfdVnfdIdAndVnfdVnfProviderAndVnfdVnfdVersion(String cpdId, String vnfdId, String vnfProvider, String version);
}
