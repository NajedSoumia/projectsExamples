package edu.m2i.projetJEE.dto;

import java.util.List;
import java.util.Objects;

public class AbonneDTO {

	private String login;
	private String password;
	private String name;
	private String prenom;
	private String adresse;
	private List<EmpruntDTO> emprunts;

	public List<EmpruntDTO> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<EmpruntDTO> emprunts) {
		this.emprunts = emprunts;
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

	public AbonneDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, login, name, password, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbonneDTO other = (AbonneDTO) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return "AbonneDTO [login=" + login + ", password=" + password + ", name=" + name + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", emprunts=" + emprunts + "]";
	}

}
