package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the prerequis database table.
 * 
 */
@Entity
@Table(name = "prerequis")
@NamedQuery(name = "Prerequi.findAll", query = "SELECT p FROM Prerequi p")
public class Prerequi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prerequis_id;

	private String prerequis_etat;

	private String prerequis_libelle;

	private String prerequis_type;

	// bi-directional many-to-many association to Document
	@ManyToMany
	@JoinTable(name = "prerequi_document", joinColumns = { @JoinColumn(name = "Prerequis_id") }, inverseJoinColumns = {
			@JoinColumn(name = "DocumentType_id") })
	private List<Document> documents;

	public Prerequi() {
	}

	public Prerequi(String prerequis_etat, String prerequis_libelle, String prerequis_type) {
		super();
		this.prerequis_etat = prerequis_etat;
		this.prerequis_libelle = prerequis_libelle;
		this.prerequis_type = prerequis_type;
	}

	public Long getPrerequis_id() {
		return this.prerequis_id;
	}

	public void setPrerequis_id(Long prerequis_id) {
		this.prerequis_id = prerequis_id;
	}

	public String getPrerequis_etat() {
		return this.prerequis_etat;
	}

	public void setPrerequis_etat(String prerequis_etat) {
		this.prerequis_etat = prerequis_etat;
	}

	public String getPrerequis_libelle() {
		return this.prerequis_libelle;
	}

	public void setPrerequis_libelle(String prerequis_libelle) {
		this.prerequis_libelle = prerequis_libelle;
	}

	public String getPrerequis_type() {
		return this.prerequis_type;
	}

	public void setPrerequis_type(String prerequis_type) {
		this.prerequis_type = prerequis_type;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}