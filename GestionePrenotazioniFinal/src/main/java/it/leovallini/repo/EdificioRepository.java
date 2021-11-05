package it.leovallini.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.leovallini.model.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	@Query("SELECT e FROM Edificio e WHERE e.citta.nome=:cityname")
	List<Optional<Edificio>> findByCity(String cityname);

	public Page<Edificio> findAll(Pageable pageable);

	public List<Edificio> findByOrderByCittaAsc();
}
