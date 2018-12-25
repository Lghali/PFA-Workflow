package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the prerequis_etape database table.
 * 
 */
@Entity
@Table(name = "prerequis_etape")
@NamedQuery(name = "PrerequisEtape.findAll", query = "SELECT p FROM PrerequisEtape p")
public class PrerequisEtape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prerequis_etape_id")
	private Long prerequisEtapeId;

	@Column(name = "prerequis_etape_etat")
	private String prerequisEtapeEtat;

	@Column(name = "prerequis_etape_libelle")
	private String prerequisEtapeLibelle;

	@Column(name = "prerequis_etape_type")
	private String prerequisEtapeType;

	// bi-directional many-to-one association to Etape
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Etape_id")
	private Etape etape;

	public PrerequisEtape() {
	}

	public PrerequisEtape(String prerequisEtapeEtat, String prerequisEtapeLibelle, String prerequisEtapeType) {
		super();
		this.prerequisEtapeEtat = prerequisEtapeEtat;
		this.prerequisEtapeLibelle = prerequisEtapeLibelle;
		this.prerequisEtapeType = prerequisEtapeType;
	}

	public Long getPrerequisEtapeId() {
		return this.prerequisEtapeId;
	}

	public void setPrerequisEtapeId(Long prerequisEtapeId) {
		this.prerequisEtapeId = prerequisEtapeId;
	}

	public String getPrerequisEtapeEtat() {
		return this.prerequisEtapeEtat;
	}

	public void setPrerequisEtapeEtat(String prerequisEtapeEtat) {
		this.prerequisEtapeEtat = prerequisEtapeEtat;
	}

	public String getPrerequisEtapeLibelle() {
		return this.prerequisEtapeLibelle;
	}

	public void setPrerequisEtapeLibelle(String prerequisEtapeLibelle) {
		this.prerequisEtapeLibelle = prerequisEtapeLibelle;
	}

	public String getPrerequisEtapeType() {
		return this.prerequisEtapeType;
	}

	public void setPrerequisEtapeType(String prerequisEtapeType) {
		this.prerequisEtapeType = prerequisEtapeType;
	}

	public Etape getEtape() {
		return this.etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

}