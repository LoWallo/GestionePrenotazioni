package it.leovallini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.leovallini.model.Role;
import it.leovallini.model.RoleType;
import it.leovallini.repo.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	public List<Role> myFindAllRoles() {
        return roleRepo.findAll();
    }
    
    public Optional<Role> myFindRoleById(Long myId) {
        return roleRepo.findById(myId);
    }
    
    public void save(RoleType roletype) {
    	roleRepo.save(new Role(roletype));
    }

	public void save(Role role) {
		roleRepo.save(role);
	}
	
	public Role myGetById(Long Id) {
		return roleRepo.getById(Id);
	}
}
