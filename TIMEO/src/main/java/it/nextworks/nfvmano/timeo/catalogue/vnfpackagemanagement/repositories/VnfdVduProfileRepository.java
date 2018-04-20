package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VduProfile;



public interface VnfdVduProfileRepository extends JpaRepository<VduProfile, Long> {
	List<VduProfile> findByVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String flavourId, String vnfdId, String vnfProvider, String version);
	Optional<VduProfile> findByVduIdAndVnfDfFlavourIdAndVnfDfVnfdVnfdIdAndVnfDfVnfdVnfProviderAndVnfDfVnfdVnfdVersion(String vduId, String flavourId, String vnfdId, String vnfProvider, String version);
}
