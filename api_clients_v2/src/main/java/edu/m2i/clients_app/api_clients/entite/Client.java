package edu.m2i.clients_app.api_clients.entite;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
     private Integer id;
	
	
     private String nom;
     private String adresse;
     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse, id, nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(id, other.id) && Objects.equals(nom, other.nom);
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
     
     
}
