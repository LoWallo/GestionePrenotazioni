package it.leovallini.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.leovallini.model.Postazione;
import it.leovallini.model.Prenotazione;
import it.leovallini.model.User;
import it.leovallini.repo.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepo;
	
	public List<Prenotazione> myFindAllBookingsPageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Prenotazione> pagedResult = prenotazioneRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Prenotazione>();
		}
	}

	public List<Prenotazione> myFindAllPrenotations() {
		return prenotazioneRepo.findAll();
	}

	public Optional<Prenotazione> myFindPrenotationById(Long myId) {
		return prenotazioneRepo.findById(myId);
	}
	
	public Prenotazione myGetById(Long Id) {
		return prenotazioneRepo.getById(Id);
	}

//	public void save(User user, Postazione postazione, LocalDate dataPrenotata) {
//		prenotazioneRepo.save(new Prenotazione(user, postazione, dataPrenotata));
//	}
//
//	public void save(Prenotazione p) {
//		prenotazioneRepo.save(p);
//	}

	public boolean checkMaxNumber(Postazione postazione, LocalDate dataPrenotata) {
		List<Optional<Prenotazione>> lista = prenotazioneRepo.findPrenotazionePostazione(dataPrenotata, postazione);
		if (lista.size() < postazione.getNumeroMassimoOccupanti()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUser(User user, LocalDate data) {
		if (prenotazioneRepo.findPrenotazioneUtente(user, data).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDay(LocalDate dataPrenotata) {
		LocalDate today = LocalDate.now();
		if (dataPrenotata.minusDays(2).isAfter(today)) {
			return true;
		} else {
			return false;
		}
	}

	public void controlSave(User user, Postazione postazione, LocalDate dataPrenotata) {
		if (checkMaxNumber(postazione, dataPrenotata)) {
			if (checkDay(dataPrenotata)) {
				if (checkUser(user, dataPrenotata)) {
					prenotazioneRepo.save(new Prenotazione(user, postazione, dataPrenotata));
					System.out.println("Postazione prenotata");
				} else {
					System.out.println("L'utente ha già una prenotazione attiva per la data selezionata");
				}
			} else {
				System.out.println("Prenotazioni disponibili solo oltre i due giorni");
			}
		} else {
			System.out.println("Postazione non disponibile");
		}
	}

	public void controlSave(Prenotazione p) {
		if (checkMaxNumber(p.getPostazione(), p.getDataPrenotata())) {
			if (checkDay(p.getDataPrenotata())) {
				if (checkUser(p.getUser(), p.getDataPrenotata())) {
					prenotazioneRepo.save(p);
					System.out.println("Postazione prenotata");
				} else {
					System.out.println("L'utente ha già una prenotazione attiva per la data selezionata");
				}
			} else {
				System.out.println("Prenotazioni disponibili solo oltre i due giorni");
			}
		} else {
			System.out.println("Postazione non disponibile");
		}
	}
}
