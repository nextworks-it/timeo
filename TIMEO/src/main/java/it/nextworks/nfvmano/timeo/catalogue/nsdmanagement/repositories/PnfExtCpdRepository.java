package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.PnfExtCpd;



public interface PnfExtCpdRepository extends JpaRepository<PnfExtCpd, Long> {
	Optional<PnfExtCpd> findByCpdId(String cpdId);
}
