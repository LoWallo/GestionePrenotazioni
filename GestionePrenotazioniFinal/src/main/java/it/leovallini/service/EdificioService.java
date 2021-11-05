package it.leovallini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.leovallini.model.Citta;
import it.leovallini.model.Edificio;
import it.leovallini.repo.EdificioRepository;

@Service
public class EdificioService {
	
	@Autowired
	EdificioRepository edificioRepo;
	
	public List<Edificio> myFindAllBuildingsSortByCity() {
		return edificioRepo.findByOrderByCittaAsc();
	}
	
	public List<Edificio> myFindAllBuildings() {
        return edificioRepo.findAll();
    }
    
    public Optional<Edificio> myFindBuildingById(Long myId) {
        return edificioRepo.findById(myId);
    }
    
    public void save(String nome, String indirizzo, Citta citta, String pin) {
    	edificioRepo.save(new Edificio(nome, indirizzo, citta, pin));
    }

	public void save(Edificio building) {
		edificioRepo.save(building);
	}
	
	public Edificio myGetById(Long Id) {
		return edificioRepo.getById(Id);
	}
	
	public List<Optional<Edificio>> myFindBuildingByCity(String cityname) {
		return edificioRepo.findByCity(cityname);
	}
}
