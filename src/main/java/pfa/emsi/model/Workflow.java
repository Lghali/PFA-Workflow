package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the workflow database table.
 * 
 */
@Entity
@NamedQuery(name = "Workflow.findAll", query = "SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_workflow")
	private Long idWorkflow;

	@Column(name = "workflow_etat")
	private String workflowEtat;

	// bi-directional many-to-one association to Documenttype
	@OneToMany(mappedBy = "workflow")
	private List<Documenttype> documenttypes;

	// bi-directional many-to-one association to Etape
	@OneToMany(mappedBy = "workflow")
	private List<Etape> etapes;

	public Workflow() {
	}

	public Workflow(String workflowEtat) {
		super();
		this.workflowEtat = workflowEtat;
	}

	public Long getIdWorkflow() {
		return this.idWorkflow;
	}

	public void setIdWorkflow(Long idWorkflow) {
		this.idWorkflow = idWorkflow;
	}

	public String getWorkflowEtat() {
		return this.workflowEtat;
	}

	public void setWorkflowEtat(String workflowEtat) {
		this.workflowEtat = workflowEtat;
	}

	public List<Documenttype> getDocumenttypes() {
		return this.documenttypes;
	}

	public void setDocumenttypes(List<Documenttype> documenttypes) {
		this.documenttypes = documenttypes;
	}

	public Documenttype addDocumenttype(Documenttype documenttype) {
		getDocumenttypes().add(documenttype);
		documenttype.setWorkflow(this);

		return documenttype;
	}

	public Documenttype removeDocumenttype(Documenttype documenttype) {
		getDocumenttypes().remove(documenttype);
		documenttype.setWorkflow(null);

		return documenttype;
	}

	public List<Etape> getEtapes() {
		return this.etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public Etape addEtape(Etape etape) {
		getEtapes().add(etape);
		etape.setWorkflow(this);

		return etape;
	}

	public Etape removeEtape(Etape etape) {
		getEtapes().remove(etape);
		etape.setWorkflow(null);

		return etape;
	}

}