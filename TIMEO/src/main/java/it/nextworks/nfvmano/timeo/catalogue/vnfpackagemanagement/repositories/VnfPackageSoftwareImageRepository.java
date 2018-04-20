package it.nextworks.nfvmano.timeo.catalogue.vnfpackagemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.onboardedvnfpackage.VnfPackageSoftwareImageInformation;



public interface VnfPackageSoftwareImageRepository extends JpaRepository<VnfPackageSoftwareImageInformation, Long> {

}
