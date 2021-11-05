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
import it.leovallini.model.Edificio;
import it.leovallini.service.CittaService;
import it.leovallini.service.EdificioService;

@RestController
@RequestMapping("/buildingcontroller")
public class EdificioController {
	
	@Autowired
	EdificioService edificioServ;
	
	@Autowired
	CittaService cServ;
	
	@GetMapping("/getbyid")
	public Edificio GetById(@RequestParam Long Id) {
		return edificioServ.myGetById(Id);
	}

	@GetMapping("/findall")
	public List<Edificio> myFindAllBuildings() {
		return edificioServ.myFindAllBuildings();
	}
	
	@GetMapping("/findbyid")
	public Optional<Edificio> myFindBuildingById(@RequestParam Long myId) {
		return edificioServ.myFindBuildingById(myId);
	}
	
	@GetMapping("/savebuildingget")
	public void save(String nome, String indirizzo, Citta citta, String pin) {
		edificioServ.save(nome, indirizzo, citta, pin);
	}
	
	@PostMapping("/savebuildingpost")
	public void save(@RequestBody Edificio e) {
		edificioServ.save(e);
	}
	
	@PostMapping("/savebuildingpost2")
	public void save2(@RequestBody String nome, String indirizzo, Long cityId, String pin) {
		Citta c = cServ.myGetById(cityId);
		Edificio e = new Edificio(nome, indirizzo, c, pin);
		edificioServ.save(e);
	}
	
	@GetMapping("/savebuildingget2")
	public void save(String nome, String indirizzo, Long cityId, String pin) {
		edificioServ.save(nome, indirizzo, cServ.myGetById(cityId), pin);
	}
	
	@GetMapping("/findbuildingbycity")
	public List<Optional<Edificio>> findByCity (@RequestParam String cityname) {
		return edificioServ.myFindBuildingByCity(cityname); 
	}
	
	@GetMapping(value = "/mygetallbuildingssortbycity", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Edificio> myGetAllusersSortByName() {
		return edificioServ.myFindAllBuildingsSortByCity();
	}
}
