package it.nextworks.nfvmano.timeo.vnfm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VnfmInternalOperationRepository extends JpaRepository<VnfmInternalOperation, Long> {
	Optional<VnfmInternalOperation> findByOperationId(String operationId);
}
