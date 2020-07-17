package it.nextworks.nfvmano.timeo.sbdriver.sdn.tapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ObfnCSRecordRepository  extends JpaRepository<ObfnCSRecord, Long> {

    @Transactional
    Optional<ObfnCSRecord> findByObfnCsId(String obfnCsId);

}
