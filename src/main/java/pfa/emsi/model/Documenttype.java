package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the documenttype database table.
 * 
 */
@Entity
@NamedQuery(name = "Documenttype.findAll", query = "SELECT d FROM Documenttype d")
public class Documenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentType_id;

	private String documentType_libelle;

	// bi-directional many-to-one association to Workflow
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_workflow")
	private Workflow workflow;

	public Documenttype() {
	}

	public Documenttype(String documentType_libelle) {
		super();
		this.documentType_libelle = documentType_libelle;
	}

	public Long getDocumentType_id() {
		return this.documentType_id;
	}

	public void setDocumentType_id(Long documentType_id) {
		this.documentType_id = documentType_id;
	}

	public String getDocumentType_libelle() {
		return this.documentType_libelle;
	}

	public void setDocumentType_libelle(String documentType_libelle) {
		this.documentType_libelle = documentType_libelle;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}