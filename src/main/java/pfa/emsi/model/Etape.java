package pfa.emsi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * The persistent class for the etape database table.
 * 
 */
@Entity
@NamedQuery(name = "Etape.findAll", query = "SELECT e FROM Etape e")
public class Etape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long etape_id;

	private String nomEtape;

	@OneToOne(fetch = FetchType.LAZY)
	private ChefService chefService;

	@ManyToOne(fetch = FetchType.LAZY)
	private Workflow workflow;

	public Etape() {
	}

	public Etape(String nomEtape) {
		super();
		this.nomEtape = nomEtape;
	}

	public Long getEtape_id() {
		return this.etape_id;
	}

	public void setEtape_id(Long etape_id) {
		this.etape_id = etape_id;
	}

	public String getNomEtape() {
		return this.nomEtape;
	}

	public void setNomEtape(String nomEtape) {
		this.nomEtape = nomEtape;
	}

	public ChefService getChefService() {
		return this.chefService;
	}

	public void setChefService(ChefService chefService) {
		this.chefService = chefService;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

}