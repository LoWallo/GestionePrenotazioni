package it.leovallini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.leovallini.model.Citta;
import it.leovallini.service.CittaService;

@RestController
@RequestMapping("/citycontroller")
public class CittaController {

	@Autowired
	CittaService cittaServ;
	
	@GetMapping("/getbyid")
	public Citta GetById(@RequestParam Long Id) {
		return cittaServ.myGetById(Id);
	}
	
	@GetMapping("/findall")
	public List<Citta> FindAllCities() {
		return cittaServ.myFindAllCities();
	}
	
	@GetMapping("/findbyid")
	public Optional<Citta> FindCityById(@RequestParam Long myId) {
		return cittaServ.myFindCityById(myId);
	}
	
	@GetMapping("/savecityget")
	public void save(@RequestParam String nome) {
		cittaServ.save(nome);
	}
	
	@PostMapping("/savecitypost")
	public void save(@RequestBody Citta c) {
		cittaServ.save(c);
	}
	
	@GetMapping("/findcitybyname")
	public List<Optional<Citta>> findCityByName (@RequestParam String s) {
		return cittaServ.MyFindCityById(s);
	}
	
	@GetMapping(value = "/mygetallcitiessortbynumero", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Citta> myGetAllCitiesSortByName() {
		return cittaServ.myFindAllCitiesSortByNumero();
	}
}
