package pfa.emsi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

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
	
	private String workflowLibelle;

	private String workflowEtat;

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

	public String getWorkflowLibelle() {
		return workflowLibelle;
	}

	public void setWorkflowLibelle(String workflowLibelle) {
		this.workflowLibelle = workflowLibelle;
	}
	
}