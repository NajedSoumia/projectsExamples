package edu.m2i.projetJEE.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Abonne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String prenom;
	@Column(nullable = false)
	private String adresse;

	@JsonIgnoreProperties
	@OneToMany(mappedBy = "abonne")
	private List<Emprunt> emprunts;

	public Abonne() {
		super();
	}

	public Abonne(String login, String password, String name, String prenom, String adresse) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, id, login, name, password, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonne other = (Abonne) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return "Abonne [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", prenom="
				+ prenom + ", adresse=" + adresse + "]";
	}


	

}
