package it.nextworks.nfvmano.timeo.catalogue.nsdmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.descriptors.nsd.VirtualLinkToLevelMapping;



public interface VirtualLinkToLevelMappingRepository extends JpaRepository<VirtualLinkToLevelMapping, Long> {

}
