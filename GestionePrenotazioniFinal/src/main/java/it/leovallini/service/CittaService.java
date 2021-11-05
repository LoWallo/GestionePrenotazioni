package it.leovallini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.leovallini.model.Citta;
import it.leovallini.repo.CittaRepository;

@Service
public class CittaService {
	
	@Autowired
	CittaRepository cittaRepo;
	
	public List<Citta> myFindAllCitiesSortByNumero() {
		return cittaRepo.findByOrderByNomeAsc();
	}

	public List<Citta> myFindAllCities() {
        return cittaRepo.findAll();
    }
    
    public Optional<Citta> myFindCityById(Long myId) {
        return cittaRepo.findById(myId);
    }
    
    public void save(String nome) {
    	cittaRepo.save(new Citta(nome));
    }

	public void save(Citta city) {
		cittaRepo.save(city);
	}
	
	public Citta myGetById(Long Id) {
		return cittaRepo.getById(Id);
	}
	
	public List<Optional<Citta>> MyFindCityById (String nome) {
		return cittaRepo.myFindCityByName(nome);
	}
}
