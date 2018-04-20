package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NsdManagementSubscriptionRepository extends JpaRepository<NsdManagementSubscription, Long> {
	Optional<NsdManagementSubscription> findById(Long id);
}
