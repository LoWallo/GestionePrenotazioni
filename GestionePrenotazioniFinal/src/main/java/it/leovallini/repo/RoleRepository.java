package it.leovallini.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.leovallini.model.Role;
import it.leovallini.model.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByRoleType(RoleType roletype);
}
