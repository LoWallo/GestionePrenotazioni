package it.leovallini.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.leovallini.model.Postazione;
import it.leovallini.model.Prenotazione;
import it.leovallini.model.User;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

	@Query("SELECT p FROM Prenotazione p WHERE p.dataPrenotata=:data AND p.postazione=:postazione")
    public List<Optional<Prenotazione>> findPrenotazionePostazione(LocalDate data,Postazione postazione);
	
	@Query("SELECT p FROM Prenotazione p WHERE p.user=:user AND p.dataPrenotata=:data")
	public List<Optional<Prenotazione>> findPrenotazioneUtente(User user, LocalDate data);
	
	public Page<Prenotazione> findAll(Pageable pageable);

	// Formula: findBy + OrderBy + NomeColonna + Ordinamento(Asc/Desc)
	public List<Prenotazione> findByOrderByDataPrenotataAsc();
}
