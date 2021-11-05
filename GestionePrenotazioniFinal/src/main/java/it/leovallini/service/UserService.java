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

import it.leovallini.model.User;
import it.leovallini.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<User> myFindAllUsers() {
		return userRepo.findAll();
	}

	public Page<User> myFindAllUsersPageable(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	// Ordinamento
	public List<User> myFindAllUsersSorted() {
		return userRepo.findByOrderByNomeAsc();
	}

	public Optional<User> myFindUserById(Long myId) {
		return userRepo.findById(myId);
	}

	public void save(String username2, String nome, String cognome, String passencoded, String email) {
		userRepo.save(new User(username2, nome, cognome, passencoded, email));
	}

	public void save(User u1) {
		userRepo.save(u1);
	}

	public User getById(Long Id) {
		return userRepo.getById(Id);
	}

	public Optional<User> findByUsername(String un) {
		return userRepo.myFindUserByUsername(un);
	}

	public Page<User> myFindAllUsersPageSize(Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<User> pagedResult = userRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult;
		} else {
			return null;
		}
	}

	// Paginazione e Ordinamento
	public List<User> myFindAllUsersPageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<User> pagedResult = userRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<User>();
		}
	}
}
