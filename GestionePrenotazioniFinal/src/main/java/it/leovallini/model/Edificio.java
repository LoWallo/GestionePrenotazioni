package it.leovallini.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import it.leovallini.security.StringAttributeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "edifici")
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String indirizzo;
	@ManyToOne
	private Citta citta;
	@Convert(converter = StringAttributeConverter.class)
	@Size(min=8, max=8)
	private String pin;

	public Edificio(String nome, String indirizzo, Citta citta, String pin) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.pin = pin;
	}
}
//Edificio
//- Long id;
//- String nome
//- String indirizzo
//@ManyToOne
//- Città città