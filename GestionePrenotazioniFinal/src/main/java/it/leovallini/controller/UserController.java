package it.leovallini.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import it.leovallini.model.User;
import it.leovallini.service.UserService;

@RestController
@RequestMapping("/usercontroller")
public class UserController {

	@Autowired
	UserService userServ;

	@GetMapping("/getbyid")
	public User GetById(@RequestParam Long Id) {
		return userServ.getById(Id);
	}

	@GetMapping("/findall")
	public List<User> FindAll() {
		return userServ.myFindAllUsers();
	}

	@GetMapping("/findbyid")
	public Optional<User> FindUserById(@RequestParam Long myId) {
		return userServ.myFindUserById(myId);
	}

	@GetMapping("/saveuserget")
	public void save(@RequestParam String username2, String nome, String cognome, String passencoded, String email) {
		userServ.save(username2, nome, cognome, passencoded, email);
	}

	@PostMapping("/saveuserpost")
	public void save(@RequestBody User u) {
		userServ.save(u);
	}

	@GetMapping("/findbyusername")
	public Optional<User> findByUsername(String un) {
		return userServ.findByUsername(un);
	}

	// Paginazione
	@GetMapping(value = "/mygetalluserspage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<User>> myGetAllUsersPage(Pageable pageable) {
		Page<User> findAll = userServ.myFindAllUsersPageable(pageable);
		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/mygetalluserssortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> myGetAllusersSortByName() {
		return userServ.myFindAllUsersSorted();
	}

	@GetMapping(value = "/mygetalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "3") int size) {
		Page<User> users = userServ.myFindAllUsersPageSize(page, size);
		Map<String, Object> myResponse = new HashMap<>();
		myResponse.put("users", users);
		return myResponse;
	}

	@GetMapping(value = "/mygetalluserspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, 
			@RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
		List<User> list = userServ.myFindAllUsersPageSizeSort(page, size, sort);
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
