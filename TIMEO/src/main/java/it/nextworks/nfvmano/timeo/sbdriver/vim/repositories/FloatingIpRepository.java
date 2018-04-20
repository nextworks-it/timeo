package it.nextworks.nfvmano.timeo.sbdriver.vim.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.FloatingIp;


public interface FloatingIpRepository extends JpaRepository<FloatingIp, Long>{

    List<FloatingIp> findByVimId(String vimId);

    Optional<FloatingIp> findById(String id);

    Optional<FloatingIp> findByPortId(String portId);

    Optional<FloatingIp> findByFloatingId(String floatingId);

}
