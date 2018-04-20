package it.nextworks.nfvmano.timeo.vnfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.records.vnfinfo.VnfLinkPort;


public interface VnfLinkPortRepository extends JpaRepository<VnfLinkPort, Long> {

}
