package sn.isi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Offre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titre;
	@Column
	private String details;
	@Column
	private LocalDateTime datePublication;
	@Column
	private Date dateExpiration;
	@ManyToOne(fetch = FetchType.EAGER)
	private Contrat contrat = new Contrat();
	@ManyToOne(fetch = FetchType.EAGER)
	private Categorie categorie = new Categorie();
	@ManyToOne(fetch = FetchType.EAGER)
	private Personne personne = new Personne();
	@OneToMany(mappedBy = "offre")
	private List<DetailOffre> detailoffres = new ArrayList<>();
	public Offre(int id, String titre, String details, LocalDateTime datePublication, Date dateExpiration,
			Contrat contrat, Categorie categorie, Personne personne, List<DetailOffre> detailoffres) {
		super();
		this.id = id;
		this.titre = titre;
		this.details = details;
		this.datePublication = datePublication;
		this.dateExpiration = dateExpiration;
		this.contrat = contrat;
		this.categorie = categorie;
		this.personne = personne;
		this.detailoffres = detailoffres;
	}
	public Offre() {
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDateTime getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public List<DetailOffre> getDetailoffres() {
		return detailoffres;
	}
	public void setDetailoffres(List<DetailOffre> detailoffres) {
		this.detailoffres = detailoffres;
	}
	
	
}
