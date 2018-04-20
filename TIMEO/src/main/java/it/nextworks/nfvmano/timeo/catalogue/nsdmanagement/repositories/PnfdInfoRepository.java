package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.catalogues.interfaces.elements.PnfdInfo;

public interface PnfdInfoRepository extends JpaRepository<PnfdInfo, Long>{

	Optional<PnfdInfo> findByPnfdInfoId(String pnfdInfoId);
	Optional<PnfdInfo> findByPnfdIdAndVersion(String pnfdId, String version);
	
}
