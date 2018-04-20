package it.nextworks.nfvmano.timeo.vnfm;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VnfmInfoRepository extends JpaRepository<VnfmInfo, Long> {

	Optional<VnfmInfo> findByName(String name);
	List<VnfmInfo> findByType(VnfmType type);
	
}
