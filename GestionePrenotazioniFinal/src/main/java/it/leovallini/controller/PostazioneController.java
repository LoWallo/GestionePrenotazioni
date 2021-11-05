package it.leovallini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.leovallini.model.Citta;
import it.leovallini.model.Edificio;
import it.leovallini.model.Postazione;
import it.leovallini.model.TipoPostazione;
import it.leovallini.service.EdificioService;
import it.leovallini.service.PostazioneService;

@RestController
@RequestMapping("/postcontroller")
public class PostazioneController {
	
	@Autowired
	PostazioneService postazioneServ;
	
	@GetMapping("/getbyid")
	public Postazione GetById(@RequestParam Long Id) {
		return postazioneServ.myGetById(Id);
	}

	@GetMapping("/findall")
	public List<Postazione> FindAllPosts() {
		return postazioneServ.myFindAllPosts();
	}
	
	@GetMapping("/findbyid")
	public Optional<Postazione> myFindPostById(@RequestParam Long myId) {
		return postazioneServ.myFindPostById(myId);
	}
	
	@GetMapping("/savepostget")
	public void save(@RequestParam String codice, String descrizione, Integer numeroMassimoOccupanti, TipoPostazione tipo,
			Edificio edificio) {
		postazioneServ.save(codice, descrizione, numeroMassimoOccupanti, tipo, edificio);
	}
	
	@PostMapping("/savepostpost")
	public void save(@RequestBody Postazione p) {
		postazioneServ.save(p);
	}
	
	@GetMapping("/findfree")
	public List<Optional<Postazione>> findFree(TipoPostazione tipo, Citta city) {
		return postazioneServ.findFree(tipo, city.getNome());
	}
	
	@Autowired
	EdificioService eServ;
	
	@GetMapping("/savepostget2")
	public void save2(@RequestParam String codice, String descrizione, Integer numeroMassimoOccupanti,
			TipoPostazione tipo, Long buildingId) {
		postazioneServ.save(codice, descrizione, numeroMassimoOccupanti, tipo, eServ.myGetById(buildingId));
	}
	
	@GetMapping(value = "/mygetallpostspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Postazione>> myGetAllUserPageSizeSort(
			@RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "2") Integer size, 
			@RequestParam(defaultValue = "numeroMassimoOccupanti") String sort) {
		List<Postazione> list = postazioneServ.myFindAllPostPageSizeSort(page, size, sort);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/mygetallpostssortbynumero", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Postazione> myGetAllusersSortByName() {
		return postazioneServ.myFindAllPostSortByNumero();
	}
}
