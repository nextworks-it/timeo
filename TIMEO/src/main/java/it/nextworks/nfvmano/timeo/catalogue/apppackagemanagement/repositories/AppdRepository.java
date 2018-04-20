package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


import it.nextworks.nfvmano.libs.descriptors.appd.Appd;

public interface AppdRepository extends JpaRepository<Appd, Long>{
	
	@Transactional
	Optional<Appd> findByAppDIdAndAppDVersionAndAppProvider(String appdId, String version, String provider);
	
	@Transactional
	List<Appd> findByAppDId(String appdId);

}
