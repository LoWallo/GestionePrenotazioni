package it.leovallini;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.leovallini.model.Citta;
import it.leovallini.model.Edificio;
import it.leovallini.model.Postazione;
import it.leovallini.model.Role;
import it.leovallini.model.RoleType;
import it.leovallini.model.TipoPostazione;
import it.leovallini.model.User;
import it.leovallini.service.CittaService;
import it.leovallini.service.EdificioService;
import it.leovallini.service.PostazioneService;
import it.leovallini.service.PrenotazioneService;
import it.leovallini.service.RoleService;
import it.leovallini.service.UserService;

@Component
public class MyCRUD implements CommandLineRunner {

	@Autowired
	UserService myUserService;
	@Autowired
	RoleService myRoleService;
	@Autowired
	PrenotazioneService myPrenotazioneService;
	@Autowired
	PostazioneService myPostazioneService;
	@Autowired
	EdificioService myEdificioService;
	@Autowired
	CittaService myCittaService;

	@Override
	public void run(String... args) throws Exception {

//		User u1 = new User("lapo7", "Lapo", "Farolfi", "Zaza", "lapo@live.it");
//		myUserService.save(u1);
//		User u2 = new User("Pablo", "Kanye", "West", "whowasinparis?", "jeezus@gmail.com");
//		myUserService.save(u2);
//		User u3 = new User("Luka10", "Luka", "Modric", "lm10", "cro@gmail.com");
//		myUserService.save(u3);
//
//		myRoleService.save(new Role(RoleType.ROLE_ADMIN));
//		myRoleService.save(new Role(RoleType.ROLE_USER));
//
//		Citta c = new Citta("Ponsacco");
//		myCittaService.save(c);
//		myCittaService.save("Pontedera");
//
//		Edificio palaRom = new Edificio("PalaRom", "Via delle Poste", c, "12345678");
//		myEdificioService.save(palaRom);
//		myEdificioService.save("Roxy", "Rotonda centrale", c, "15915915");
//
//		Postazione postazione1 = new Postazione("04.38", "Stanza 38, 4o piano", 4, TipoPostazione.PRIVATO, palaRom);
//		myPostazioneService.save(postazione1);
//		myPostazioneService.save("02.16", "Stanza 16, 2o piano", 12, TipoPostazione.SALA_RIUNIONI, palaRom);
//		myPostazioneService.save("03.2A", "Stanza 2A, 3o piano", 6, TipoPostazione.OPENSPACE, palaRom);
//
//		myPrenotazioneService.controlSave(u1, postazione1, LocalDate.of(2022, 11, 10));
//		myPrenotazioneService.controlSave(u1, postazione1, LocalDate.of(2022, 10, 19));
//
////		myPrenotazioneService.myFindAllPrenotations().stream().forEach(a -> System.out.println(a.toString()));
//		
//		myPrenotazioneService.controlSave(u3, postazione1, LocalDate.of(2022, 10, 29));
//		myPrenotazioneService.controlSave(u3, postazione1, LocalDate.of(2022, 10, 30));
//		
	}

}
//@Autowired
//MyUserRepository myUserRepository;
//
////save()
//myUserRepository.save(new MyUser("Susy","Gialli", 33));