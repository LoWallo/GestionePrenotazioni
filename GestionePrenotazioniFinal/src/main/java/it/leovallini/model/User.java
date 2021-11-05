package it.leovallini.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import it.leovallini.security.StringAttributeConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nome;
	private String cognome;
	@Convert(converter = StringAttributeConverter.class)
	private String email;
	private String password;
	private Boolean active = true;
	@ManyToMany
	@JoinTable
	private Set<Role> roles = new HashSet<>();

//	public User(String username, String nome, String email, String password, Boolean active) {
//		this.username = username;
//		this.nome = nome;
//		this.email = email;
//		this.password = password;
//		this.active = active;
//	}

	public User(String username2, String nome, String cognome, String passencoded, String email) {
		this.username = username2;
		this.nome = nome;
		this.email = email;
		this.password = passencoded;
		this.active = true;
		this.cognome = cognome;
	}

}
//User
//- Long id
//- String username
//- String nome
//- String email
//- String password
//- Boolean active = true
//- @ManyToMany
//@JoinTable(....)
//Set<Role> roles = new HashSet