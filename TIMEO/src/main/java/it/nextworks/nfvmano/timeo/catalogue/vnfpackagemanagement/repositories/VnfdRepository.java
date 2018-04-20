package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.transaction.annotation.Transactional;

import it.nextworks.nfvmano.libs.descriptors.vnfd.Vnfd;

public interface VnfdRepository extends JpaRepository<Vnfd, Long> {

	@Transactional
	Optional<Vnfd> findByVnfdIdAndVnfProviderAndVnfdVersion(String vnfdId, String vnfProvider, String version);

	@Transactional
	List<Vnfd> findByVnfdId(String vnfdId);
}
