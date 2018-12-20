package pfa.emsi.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_service")
	private int idService;

	private String service_libelle;

	// bi-directional one-to-one association to ChefService
	@OneToOne(mappedBy = "service", fetch = FetchType.LAZY)
	private ChefService chefService;

	public Service() {
	}

	public Service(String service_libelle) {
		super();
		this.service_libelle = service_libelle;
	}

	public int getIdService() {
		return this.idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public String getService_libelle() {
		return this.service_libelle;
	}

	public void setService_libelle(String service_libelle) {
		this.service_libelle = service_libelle;
	}

	public ChefService getChefService() {
		return this.chefService;
	}

	public void setChefService(ChefService chefService) {
		this.chefService = chefService;
	}

}