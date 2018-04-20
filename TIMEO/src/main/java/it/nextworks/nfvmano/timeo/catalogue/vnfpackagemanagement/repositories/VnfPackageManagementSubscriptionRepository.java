package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VnfPackageManagementSubscriptionRepository extends JpaRepository<VnfPackageManagementSubscription, Long>{
	Optional<VnfPackageManagementSubscription> findById(Long id);
}
