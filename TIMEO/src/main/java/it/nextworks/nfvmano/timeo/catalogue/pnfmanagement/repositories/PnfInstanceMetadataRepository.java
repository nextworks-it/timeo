package it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PhysicalEquipmentPort;
import it.nextworks.nfvmano.timeo.catalogue.pnfmanagement.elements.PnfInstanceMetadata;

public interface PnfInstanceMetadataRepository extends JpaRepository<PnfInstanceMetadata, Long> {

}
