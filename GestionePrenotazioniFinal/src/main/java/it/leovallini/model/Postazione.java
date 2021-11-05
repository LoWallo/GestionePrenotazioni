package it.leovallini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codice;
	private String descrizione;
	private Integer numeroMassimoOccupanti;
	private TipoPostazione tipo;
	@ManyToOne
	private Edificio edificio;

	public Postazione(String codice, String descrizione, Integer numeroMassimoOccupanti, TipoPostazione tipo,
			Edificio edificio) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.numeroMassimoOccupanti = numeroMassimoOccupanti;
		this.tipo = tipo;
		this.edificio = edificio;
	}

}
//Postazione
//- Long id
//- String codice
//- String descrizione
//- Integer numeroMassimoOccupati
//- TipoPostazione
//- Edificio edificio