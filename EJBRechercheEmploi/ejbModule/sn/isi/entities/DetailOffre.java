package sn.isi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DetailOffre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private LocalDateTime date;
	@ManyToOne(fetch = FetchType.EAGER)
	private Offre offre = new Offre();
	@ManyToOne(fetch = FetchType.EAGER)
	private Personne personne = new Personne();
	public DetailOffre(int id, LocalDateTime date, Offre offre, Personne personne) {
		super();
		this.id = id;
		this.date = date;
		this.offre = offre;
		this.personne = personne;
	}
	public DetailOffre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Offre getOffre() {
		return offre;
	}
	public void setOffre(Offre offre) {
		this.offre = offre;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
