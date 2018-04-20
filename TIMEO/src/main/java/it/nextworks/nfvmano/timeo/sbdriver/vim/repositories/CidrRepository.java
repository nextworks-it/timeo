package it.nextworks.nfvmano.timeo.sbdriver.vim.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import it.nextworks.nfvmano.timeo.sbdriver.vim.elements.Cidr;



/**
 * The interface is used to memorize the CIDR list to be used during the instantiation phases.
 * The used one are marked as used, and will be available when the VNF which uses them will terminate.
 *
 */
public interface CidrRepository extends JpaRepository<Cidr, Long>{

    /**
     * The method returns a list of CIDRs related to a given vim id
     * @param vimId Vim identifier
     * @return Cidrs List of available CIDRs for a given VIM
     */
    List<Cidr> findByVimId(String vimId);

    /**
     * The method returns a CIDR identified by ID
     * @param id ID to be found
     * @return cidr Element to be returned
     */
    Optional<Cidr> findById(String id);

    /**
     * The method returns a Cidr identified by its cidr and vim id
     * @param cidr CIDR to be found (a.b.c.d/ee)
     * @param vimId identifier of the VIM
     * @return CIDR element to be returned
     */
    Optional<Cidr> findByCidrAndVimId(String cidr, String vimId);

    /**
     * The method returns a list of cidrs related to a given vim and are free (or used)
     * @param vimId Identifier of the VIM
     * @param free Boolean to be used in the selection. If true, the returned elements will be available cidr,
     * 				otherwise, the returned elements are used cidrs
     * @return Cidrs List of cidrs to be returned
     */
    List<Cidr> findByvimIdAndFree(String vimId, boolean free);
}
