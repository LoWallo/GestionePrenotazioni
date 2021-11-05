package it.leovallini.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@NonNull
	private User user;
	@ManyToOne
	@NonNull
	private Postazione postazione;
	@NonNull
	LocalDate dataPrenotata;
	LocalDate dataPrenotazione;

	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = LocalDate.now();
	}
	
	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata, LocalDate dataPrenotazione) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = dataPrenotazione;
	}
	
	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", user=" + user + ", postazione=" + postazione + ", dataPrenotata="
				+ dataPrenotata + ", dataPrenotazione=" + dataPrenotazione + "]";
	}


}
//Prenotazione
//- Long id
//@ManyToOne
//@NotNull
//- User user
//@ManyToOne
//@NotNull
//- Postazione postazione
//@NotNull
//- Localdate dataPrenotata
//- Localdate dataPrenotazione