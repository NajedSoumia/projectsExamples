package edu.m2i.projetJEE.dto;

import java.util.Objects;

public class OuvrageDTO {
	private String titre;
	private String auteur;
	private String isbn;
	private Integer nbrExemplaire;
	private String TypeCategorie;
	
	
	public OuvrageDTO(String titre, String auteur, String isbn, Integer nbrExemplaire, String typeCategorie) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.isbn = isbn;
		this.nbrExemplaire = nbrExemplaire;
		TypeCategorie = typeCategorie;
	}
 
 
	public OuvrageDTO() {
		super();
	}
 
 
	public String getTitre() {
		return titre;
	}
 
 
	public void setTitre(String titre) {
		this.titre = titre;
	}
 
 
	public String getAuteur() {
		return auteur;
	}
 
 
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
 
 
	public String getIsbn() {
		return isbn;
	}
 
 
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
 
 
	public Integer getNbrExemplaire() {
		return nbrExemplaire;
	}
 
 
	public void setNbrExemplaire(Integer nbrExemplaire) {
		this.nbrExemplaire = nbrExemplaire;
	}
 
 
	public String getTypeCategorie() {
		return TypeCategorie;
	}
 
 
	public void setTypeCategorie(String typeCategorie) {
		TypeCategorie = typeCategorie;
	}
 
 
	@Override
	public int hashCode() {
		return Objects.hash(TypeCategorie, auteur, isbn, nbrExemplaire, titre);
	}
 
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OuvrageDTO other = (OuvrageDTO) obj;
		return Objects.equals(TypeCategorie, other.TypeCategorie) && Objects.equals(auteur, other.auteur)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(nbrExemplaire, other.nbrExemplaire)
				&& Objects.equals(titre, other.titre);
	}
 
 
	@Override
	public String toString() {
		return "OuvrageDTO [titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + ", nbrExemplaire="
				+ nbrExemplaire + ", TypeCategorie=" + TypeCategorie + "]";
	}
	
	
	
}
