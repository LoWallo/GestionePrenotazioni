package it.leovallini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.leovallini.model.Role;
import it.leovallini.model.RoleType;
import it.leovallini.service.RoleService;

@RestController
@RequestMapping("/rolecontroller")
public class RoleController {
	
	@Autowired
	RoleService roleServ;
	
	@GetMapping("/getbyid")
	public Role GetById(@RequestParam Long Id) {
		return roleServ.myGetById(Id);
	}

	@GetMapping("/findall")
	public List<Role> FindAllRoles() {
        return roleServ.myFindAllRoles();
    }
	
	@GetMapping("/findbyid")
	public Optional<Role> FindRoleById(@RequestParam Long myId) {
		return roleServ.myFindRoleById(myId);
	}
	
	@GetMapping("/saveroleget")
	public void save(@RequestParam RoleType roletype) {
		roleServ.save(roletype);
	}
	
	@PostMapping("/saverolepost")
	public void save(@RequestBody Role r) {
		roleServ.save(r);
	}
}
