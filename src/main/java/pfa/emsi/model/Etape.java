package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

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

	// bi-directional one-to-one association to ChefService
	@OneToOne(mappedBy = "etape", fetch = FetchType.LAZY)
	private ChefService chefService;

	// bi-directional many-to-one association to Workflow
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_workflow")
	private Workflow workflow;

	// bi-directional many-to-one association to PrerequisEtape
	@OneToMany(mappedBy = "etape")
	private List<PrerequisEtape> prerequisEtapes;

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

	public List<PrerequisEtape> getPrerequisEtapes() {
		return this.prerequisEtapes;
	}

	public void setPrerequisEtapes(List<PrerequisEtape> prerequisEtapes) {
		this.prerequisEtapes = prerequisEtapes;
	}

	public PrerequisEtape addPrerequisEtape(PrerequisEtape prerequisEtape) {
		getPrerequisEtapes().add(prerequisEtape);
		prerequisEtape.setEtape(this);

		return prerequisEtape;
	}

	public PrerequisEtape removePrerequisEtape(PrerequisEtape prerequisEtape) {
		getPrerequisEtapes().remove(prerequisEtape);
		prerequisEtape.setEtape(null);

		return prerequisEtape;
	}

}