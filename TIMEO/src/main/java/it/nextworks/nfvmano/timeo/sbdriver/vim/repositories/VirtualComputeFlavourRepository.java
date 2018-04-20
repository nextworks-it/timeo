package it.nextworks.nfvmano.timeo.sbdriver.vim.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.libs.vrmanagement.interfaces.elements.vcompute.VirtualComputeFlavour;

public interface VirtualComputeFlavourRepository extends JpaRepository<VirtualComputeFlavour, Long> {
	Optional<VirtualComputeFlavour> findById(Long id);
	Optional<VirtualComputeFlavour> findByFlavourId(String flavourId);
}
