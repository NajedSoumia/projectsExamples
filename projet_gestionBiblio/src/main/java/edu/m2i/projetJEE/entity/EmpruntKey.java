package edu.m2i.projetJEE.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpruntKey {

	@Column(name = "id_abonne")
	private Integer idAbonne;
	@Column(name = "id_ouvrage")
	private Integer idOuvrage;

	public Integer getIdAbonne() {
		return idAbonne;
	}

	public void setIdAbonne(Integer idAbonne) {
		this.idAbonne = idAbonne;
	}

	public Integer getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(Integer idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAbonne, idOuvrage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpruntKey other = (EmpruntKey) obj;
		return Objects.equals(idAbonne, other.idAbonne) && Objects.equals(idOuvrage, other.idOuvrage);
	}

	

}
