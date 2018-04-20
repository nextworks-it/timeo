package it.nextworks.nfvmano.timeo.nso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalOperationRepository extends JpaRepository<InternalOperation, Long> {
	Optional<InternalOperation> findByOperationId(String operationId);
}
