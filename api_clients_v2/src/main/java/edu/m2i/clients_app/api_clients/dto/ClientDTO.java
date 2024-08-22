package edu.m2i.clients_app.api_clients.dto;

import jakarta.validation.constraints.NotNull;

public class ClientDTO {
	
	@NotNull
	private String nom;
	private String adresse;
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
	public ClientDTO(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	
	public ClientDTO() {
		
	}
}
