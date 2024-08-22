package edu.m2i.projetJEE.entity;

import java.util.ArrayList;
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
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String type;
	
	
	@OneToMany(mappedBy = "categorie", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JsonIgnoreProperties
	private List<Ouvrage> ouvrages;

	public Categorie() {
		super();
	}

	public Categorie(String type) {
		super();
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", type=" + type + "]";
	}
	
	
	public void addOuvrage(Ouvrage ouvrage) {
		if(this.ouvrages == null) {
			this.ouvrages = new ArrayList<Ouvrage>();
		}
		ouvrage.setCategorie(this);
		this.ouvrages.add(ouvrage);
		
	}
	
	
	

	

}
