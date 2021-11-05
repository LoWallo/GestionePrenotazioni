package it.leovallini.controller;

import java.time.LocalDate;
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

import it.leovallini.model.Postazione;
import it.leovallini.model.Prenotazione;
import it.leovallini.model.User;
import it.leovallini.service.PostazioneService;
import it.leovallini.service.PrenotazioneService;
import it.leovallini.service.UserService;

@RestController
@RequestMapping("/prenotationcontroller")
public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotServ;
	
	@GetMapping("/getbyid")
	public Prenotazione GetById(@RequestParam Long Id) {
		return prenotServ.myGetById(Id);
	}

	@GetMapping("/findall")
	public List<Prenotazione> FindAllPrenot() {
		return prenotServ.myFindAllPrenotations();
	}
	
	@GetMapping("/findbyid")
	public Optional<Prenotazione> myFindPrenotationById(@RequestParam Long myId) {
		return prenotServ.myFindPrenotationById(myId);
	}
	
	@GetMapping("/savebookingget")
	public void save(@RequestParam User user, Postazione postazione, LocalDate dataPrenotata) {
		prenotServ.controlSave(user, postazione, dataPrenotata);
	}
	
	@PostMapping("/savebookingpost")
	public void save(@RequestBody Prenotazione p) {
		prenotServ.controlSave(p);
	}
	
	@Autowired
	UserService uServ;
	@Autowired
	PostazioneService pServ;
	
	@GetMapping("/savebookingget2")
	public void save(@RequestParam Long userId, Long postId, int y, int m, int d) {
		prenotServ.controlSave(uServ.getById(userId), pServ.myGetById(postId), LocalDate.of(y, m, d));
	}
	
//	@PostMapping("/savebookingpost2")
//	public void save2(@RequestBody User user, Postazione post, LocalDate dataPrenotata) {
//		prenotServ.controlSave(uServ.getById(user.getId()), pServ.myGetById(post.getId()), dataPrenotata);
//	}
	
	@GetMapping(value = "/mygetallbookingspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prenotazione>> myGetAllUserPageSizeSort(
			@RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "3") Integer size, 
			@RequestParam(defaultValue = "dataPrenotata") String sort) {
		List<Prenotazione> list = prenotServ.myFindAllBookingsPageSizeSort(page, size, sort);
		return new ResponseEntity<List<Prenotazione>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
