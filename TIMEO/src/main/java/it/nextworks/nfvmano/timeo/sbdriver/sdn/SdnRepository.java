package it.nextworks.nfvmano.timeo.sbdriver.sdn;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SdnRepository extends JpaRepository<SdnController, Long>{
	Optional<SdnController> findBySdnControllerId(String sdnControllerId);
	Optional<SdnController> findByVimId(String vimId);
	List<SdnController> findBySdnControllerType(SdnControllerType type);
}
