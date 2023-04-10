package sn.isi.entities;

import java.io.Serializable;
import java.util.List; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CV implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titre;
	@Column
	private String profil;
	@Column
	private String photo;
	@Column
	private String competence;
	@Column
	private String etude;
	@Column
	private String experience;
	@Column
	private String langue;
	@Column
	private String divers;
	@ManyToOne(fetch = FetchType.EAGER)
	private Personne personne = new Personne();
	public CV(int id, String titre, String profil, String photo, String competence, String etude, String experience,
			String langue, String divers, Personne personne) {
		super();
		this.id = id;
		this.titre = titre;
		this.profil = profil;
		this.photo = photo;
		this.competence = competence;
		this.etude = etude;
		this.experience = experience;
		this.langue = langue;
		this.divers = divers;
		this.personne = personne;
	}
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public String getEtude() {
		return etude;
	}
	public void setEtude(String etude) {
		this.etude = etude;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getDivers() {
		return divers;
	}
	public void setDivers(String divers) {
		this.divers = divers;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
