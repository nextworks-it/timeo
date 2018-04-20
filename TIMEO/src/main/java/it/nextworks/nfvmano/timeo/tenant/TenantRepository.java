package it.nextworks.nfvmano.timeo.tenant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
	Optional<Tenant> findByTenantId(String tenantId);
}
