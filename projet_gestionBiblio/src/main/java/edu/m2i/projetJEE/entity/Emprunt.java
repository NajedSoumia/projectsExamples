package edu.m2i.projetJEE.entity;

import java.time.LocalDate;
import java.util.Objects;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Emprunt {

	@EmbeddedId
	private EmpruntKey id;
	private LocalDate dateDebut;
	private Integer duree;
	private String statut;
	
	
	@ManyToOne
	@MapsId("idAbonne")
	@JoinColumn(name = "id_abonne")
	private Abonne abonne;
	
	
	@ManyToOne
	@MapsId("idOuvrage")
	@JoinColumn(name = "id_ouvrage")
	private Ouvrage ouvrage;

	

	public Emprunt() {
		super();
	}

	public Emprunt(Abonne abonne, Ouvrage ouvrage, LocalDate dateDebut, Integer duree, String statut) {
		super();
		this.abonne = abonne;
		this.ouvrage = ouvrage;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.statut = statut;
	}

	public EmpruntKey getId() {
		return id;
	}

	public void setId(EmpruntKey id) {
		this.id = id;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abonne, dateDebut, duree, id, ouvrage, statut);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		return Objects.equals(abonne, other.abonne) && Objects.equals(dateDebut, other.dateDebut)
				&& Objects.equals(duree, other.duree) && Objects.equals(id, other.id)
				&& Objects.equals(ouvrage, other.ouvrage) && Objects.equals(statut, other.statut);
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", duree=" + duree + ", statut=" + statut
				+ ", abonne=" + abonne + ", ouvrage=" + ouvrage + "]";
	}

	

	

}
