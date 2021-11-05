package it.leovallini.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.leovallini.model.Citta;

public interface CittaRepository extends JpaRepository<Citta, Long> {

	@Query("SELECT c FROM Citta c WHERE c.nome=:nome")
	public List<Optional<Citta>> myFindCityByName(String nome);

	public Page<Citta> findAll(Pageable pageable);

	public List<Citta> findByOrderByNomeAsc();
}
