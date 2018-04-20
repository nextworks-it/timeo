package it.nextworks.nfvmano.timeo.sbdriver.vim;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VimRepository extends JpaRepository<Vim, Long> {
	Optional<Vim> findByVimId(String vimId);
	List<Vim> findByType(VimType vimType);
}
