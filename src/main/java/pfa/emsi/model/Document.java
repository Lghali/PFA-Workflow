package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_document")
	private Long idDocument;

	private String document_etat;

	private String document_libelle;

	private String document_type;

	private int documentType_id;

	private byte signatureDirecture;

	// bi-directional many-to-one association to Directeur
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Dir_idUser")
	private Directeur directeur;

	// bi-directional many-to-many association to ChefService
	@ManyToMany
	@JoinTable(name = "signature", joinColumns = { @JoinColumn(name = "id_document") }, inverseJoinColumns = {
			@JoinColumn(name = "idUser") })
	private List<ChefService> chefServices;

	// bi-directional many-to-many association to Prerequi
	@ManyToMany(mappedBy = "documents")
	private List<Prerequi> prerequis;

	// bi-directional many-to-one association to Demandeur
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Dem_idUser")
	private Demandeur demandeur;

	public Document() {
	}

	public Long getIdDocument() {
		return this.idDocument;
	}

	public Document(String document_etat, String document_libelle, String document_type, int documentType_id,
			byte signatureDirecture) {
		super();
		this.document_etat = document_etat;
		this.document_libelle = document_libelle;
		this.document_type = document_type;
		this.documentType_id = documentType_id;
		this.signatureDirecture = signatureDirecture;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getDocument_etat() {
		return this.document_etat;
	}

	public void setDocument_etat(String document_etat) {
		this.document_etat = document_etat;
	}

	public String getDocument_libelle() {
		return this.document_libelle;
	}

	public void setDocument_libelle(String document_libelle) {
		this.document_libelle = document_libelle;
	}

	public String getDocument_type() {
		return this.document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public int getDocumentType_id() {
		return this.documentType_id;
	}

	public void setDocumentType_id(int documentType_id) {
		this.documentType_id = documentType_id;
	}

	public byte getSignatureDirecture() {
		return this.signatureDirecture;
	}

	public void setSignatureDirecture(byte signatureDirecture) {
		this.signatureDirecture = signatureDirecture;
	}

	public Directeur getDirecteur() {
		return this.directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}

	public List<ChefService> getChefServices() {
		return this.chefServices;
	}

	public void setChefServices(List<ChefService> chefServices) {
		this.chefServices = chefServices;
	}

	public List<Prerequi> getPrerequis() {
		return this.prerequis;
	}

	public void setPrerequis(List<Prerequi> prerequis) {
		this.prerequis = prerequis;
	}

	public Demandeur getDemandeur() {
		return this.demandeur;
	}

	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}

}