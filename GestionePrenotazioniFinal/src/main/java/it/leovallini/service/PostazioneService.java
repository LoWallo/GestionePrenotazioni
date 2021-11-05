package it.leovallini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.leovallini.model.Edificio;
import it.leovallini.model.Postazione;
import it.leovallini.model.TipoPostazione;
import it.leovallini.repo.PostazioneRepository;

@Service
public class PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepo;
	
	public List<Postazione> myFindAllPostSortByNumero() {
		return postazioneRepo.findByOrderByNumeroMassimoOccupantiDesc();
	}

	public List<Postazione> myFindAllPostPageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Postazione> pagedResult = postazioneRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<>();
		}
	}

	public List<Optional<Postazione>> findFree(TipoPostazione tipo, String city) {
		return postazioneRepo.findByTipo(tipo, city);
	}

	public List<Postazione> myFindAllPosts() {
		return postazioneRepo.findAll();
	}

	public Optional<Postazione> myFindPostById(Long myId) {
		return postazioneRepo.findById(myId);
	}

	public void save(String codice, String descrizione, Integer numeroMassimoOccupanti, TipoPostazione tipo,
			Edificio edificio) {
		postazioneRepo.save(new Postazione(codice, descrizione, numeroMassimoOccupanti, tipo, edificio));
	}

	public void save(Postazione postazione1) {
		postazioneRepo.save(postazione1);
	}

	public Postazione myGetById(Long Id) {
		return postazioneRepo.getById(Id);
	}
}
