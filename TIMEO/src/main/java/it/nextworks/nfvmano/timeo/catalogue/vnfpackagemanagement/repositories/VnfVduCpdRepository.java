package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VduCpd;



public interface VnfVduCpdRepository extends JpaRepository<VduCpd, Long> {

	List<VduCpd> findByVduVduIdAndVduVnfdVnfdIdAndVduVnfdVnfProviderAndVduVnfdVnfdVersion(String vduId, String vnfdId, String vnfProvider, String version);
	Optional<VduCpd> findByCpdIdAndVduVduIdAndVduVnfdVnfdIdAndVduVnfdVnfProviderAndVduVnfdVnfdVersion(String cpdId, String vduId, String vnfdId, String vnfProvider, String version);
	
	
}
