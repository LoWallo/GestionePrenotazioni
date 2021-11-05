package it.leovallini.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.leovallini.model.Postazione;
import it.leovallini.model.TipoPostazione;

public interface PostazioneRepository extends JpaRepository<Postazione, Long>{

	@Query("SELECT p FROM Postazione p, Edificio e WHERE p.tipo =:tipo AND e.citta.nome =:city")
	public List<Optional<Postazione>> findByTipo(TipoPostazione tipo,String city);
	
	public Page<Postazione> findAll(Pageable pageable);
	
	public List<Postazione> findByOrderByNumeroMassimoOccupantiDesc();
}
