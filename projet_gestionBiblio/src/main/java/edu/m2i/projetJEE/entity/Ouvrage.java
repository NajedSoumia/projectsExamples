package edu.m2i.projetJEE.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ouvrage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String titre;
	@Column(nullable = false)
	private String auteur;
	@Column(nullable = false)
	private String isbn;
	@Column(nullable = false)
	private Integer nbrExemplaire;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_categorie")
	@JsonIgnoreProperties
	private Categorie categorie;

	@JsonIgnoreProperties
	@OneToMany(mappedBy = "ouvrage")
	private List<Emprunt> emprunts;

	public Ouvrage() {
		super();
	}

	public Ouvrage(String titre, String auteur, String isbn, Integer nbrExemplaire) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.isbn = isbn;
		this.nbrExemplaire = nbrExemplaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur, categorie, id, isbn, nbrExemplaire, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(categorie, other.categorie)
				&& Objects.equals(id, other.id) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(nbrExemplaire, other.nbrExemplaire) && Objects.equals(titre, other.titre);
	}

	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + ", nbrExemplaire="
				+ nbrExemplaire + ", Typecategorie=" + categorie.getType() + "]";
	}
	
	
	

}
