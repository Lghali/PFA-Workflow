package pfa.emsi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the demandeur database table.
 * 
 */
@Entity
@NamedQuery(name = "Demandeur.findAll", query = "SELECT d FROM Demandeur d")
public class Demandeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	private String adresse;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateN;

	private String email;

	private String login;

	private String nom;

	private String numTel;

	private String password;

	private String prenom;

	// bi-directional many-to-one association to Document
	@OneToMany(mappedBy = "demandeur")
	private List<Document> documents;

	public Demandeur() {
	}

	public Demandeur(String adresse, Date dateN, String email, String login, String nom, String numTel, String password,
			String prenom) {
		super();
		this.adresse = adresse;
		this.dateN = dateN;
		this.email = email;
		this.login = login;
		this.nom = nom;
		this.numTel = numTel;
		this.password = password;
		this.prenom = prenom;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateN() {
		return this.dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setDemandeur(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setDemandeur(null);

		return document;
	}

}