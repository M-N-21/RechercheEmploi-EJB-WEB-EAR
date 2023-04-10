package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String libCategorie;
	@OneToMany(mappedBy = "categorie")
	private List<Offre> offres = new ArrayList<>();
	@ManyToMany
	private List<Personne> personnes = new ArrayList<>();
	public Categorie(int id, String libCategorie, List<Offre> offres, List<Personne> personnes) {
		super();
		this.id = id;
		this.libCategorie = libCategorie;
		this.offres = offres;
		this.personnes = personnes;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibCategorie() {
		return libCategorie;
	}
	public void setLibCategorie(String libCategorie) {
		this.libCategorie = libCategorie;
	}
	public List<Offre> getOffres() {
		return offres;
	}
	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	
	
}
