package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.nsinfo.SapInfo;

public interface SapInfoRepository extends JpaRepository<SapInfo, Long> {

	List<SapInfo> findByNsInfoNsInstanceId(String nsInstanceId);
	Optional<SapInfo> findByNsInfoNsInstanceIdAndSapdId(String nsInstanceId, String sapdId);
	Optional<SapInfo> findBySapInstanceId(String sapInstanceId);
	
}
