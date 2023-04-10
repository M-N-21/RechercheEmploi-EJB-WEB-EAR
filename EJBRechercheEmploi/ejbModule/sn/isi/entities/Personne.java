package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xalan.trace.TraceListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "datenaiss")
    private Date datenaiss;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nationalite")
    private String nationalite;

    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role = new Role();
    
    @OneToMany(mappedBy = "personne")
	List<CV> cvs = new ArrayList<>();
    
    @OneToMany(mappedBy = "personne")
	List<Message> messages = new ArrayList<>();
    
    @ManyToMany(mappedBy = "personnes")
    private List<Categorie> categories = new ArrayList<>();
    
    @OneToMany(mappedBy = "personne")
   	List<DetailOffre> detailoffres = new ArrayList<>();
    
    @OneToMany(mappedBy = "personne")
   	List<Offre> offres = new ArrayList<>();

	public Personne(int id, String nom, String prenom, String telephone, Date datenaiss, String adresse,
			String nationalite, String email, String password, Role role, List<CV> cvs, List<Message> messages,
			List<Categorie> categories, List<DetailOffre> detailoffres, List<Offre> offres) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.datenaiss = datenaiss;
		this.adresse = adresse;
		this.nationalite = nationalite;
		this.email = email;
		this.password = password;
		this.role = role;
		this.cvs = cvs;
		this.messages = messages;
		this.categories = categories;
		this.detailoffres = detailoffres;
		this.offres = offres;
	}

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<CV> getCvs() {
		return cvs;
	}

	public void setCvs(List<CV> cvs) {
		this.cvs = cvs;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<DetailOffre> getDetailoffres() {
		return detailoffres;
	}

	public void setDetailoffres(List<DetailOffre> detailoffres) {
		this.detailoffres = detailoffres;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	
    
}
