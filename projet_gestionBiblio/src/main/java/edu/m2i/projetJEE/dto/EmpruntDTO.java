package edu.m2i.projetJEE.dto;

import java.time.LocalDate;
import java.util.Objects;

public class EmpruntDTO {

	private LocalDate dateDebut;
	private Integer duree;
	private String statut;
	private String abonneName;
	private String ouvrageTitre;

	public EmpruntDTO() {
		super();
	}

	public EmpruntDTO(LocalDate dateDebut, Integer duree, String statut, String abonneName, String ouvrageTitre) {
		super();
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.statut = statut;
		this.abonneName = abonneName;
		this.ouvrageTitre = ouvrageTitre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abonneName, dateDebut, duree, ouvrageTitre, statut);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpruntDTO other = (EmpruntDTO) obj;
		return Objects.equals(abonneName, other.abonneName) && Objects.equals(dateDebut, other.dateDebut)
				&& Objects.equals(duree, other.duree) && Objects.equals(ouvrageTitre, other.ouvrageTitre)
				&& Objects.equals(statut, other.statut);
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

	public String getAbonneName() {
		return abonneName;
	}

	public void setAbonneName(String abonneName) {
		this.abonneName = abonneName;
	}

	public String getOuvrageTitre() {
		return ouvrageTitre;
	}

	public void setOuvrageTitre(String ouvrageTitre) {
		this.ouvrageTitre = ouvrageTitre;
	}

	@Override
	public String toString() {
		return "EmpruntDTO [dateDebut=" + dateDebut + ", duree=" + duree + ", statut=" + statut + ", abonneName="
				+ abonneName + ", ouvrageTitre=" + ouvrageTitre + "]";
	}

}
