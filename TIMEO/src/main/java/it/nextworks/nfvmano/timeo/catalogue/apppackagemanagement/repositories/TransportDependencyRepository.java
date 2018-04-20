package it.nextworks.nfvmano.timeo.catalogue.apppackagemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.appd.TransportDependency;

public interface TransportDependencyRepository extends JpaRepository<TransportDependency, Long>{

}
