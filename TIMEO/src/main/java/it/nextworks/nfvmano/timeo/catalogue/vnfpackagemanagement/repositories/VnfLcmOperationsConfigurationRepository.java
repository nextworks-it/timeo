package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.vnfd.VnfLcmOperationsConfiguration;



public interface VnfLcmOperationsConfigurationRepository extends JpaRepository<VnfLcmOperationsConfiguration, Long> {

}
