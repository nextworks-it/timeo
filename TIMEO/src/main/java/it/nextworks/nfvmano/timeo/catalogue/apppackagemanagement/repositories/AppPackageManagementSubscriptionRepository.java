package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPackageManagementSubscriptionRepository extends JpaRepository<AppPackageManagementSubscription, Long>{

	Optional<AppPackageManagementSubscription> findById(Long id);
	
}
