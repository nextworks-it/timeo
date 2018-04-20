package it.nextworks.nfvmano.timeo.nso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.nsinfo.PnfInfo;

public interface PnfInfoRepository extends JpaRepository<PnfInfo, Long> {

}
