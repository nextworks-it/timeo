package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.InstantiateVnfOpConfig;



public interface InstantiateVnfOpConfigRepository extends JpaRepository<InstantiateVnfOpConfig, Long> {

}
