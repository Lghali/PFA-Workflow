package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.DemandeurRepository;
import pfa.emsi.model.Demandeur;

@Controller
@RequestMapping(value = "/Demandeur")
public class DemandeurContoller {

	@Autowired
	private DemandeurRepository demandeurRepository;
	
	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<Demandeur> demandeurs = demandeurRepository.findAll();
		model.addAttribute("demandeurs", demandeurs);
		return "/admin/listerDemandeur";
	}
	
	@RequestMapping(value = "/AjouterOuModifierDemandeur")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			Demandeur demandeur = demandeurRepository.getOne(id);
			model.addAttribute("demandeur", demandeur);
		} else {
			model.addAttribute("demandeur", new Demandeur());
		}
		return "/admin/ajouterDemandeur";
	}
	
	@RequestMapping(value = "/AjouterDemandeur")
	private String ajouter(Demandeur demandeur) {
		demandeurRepository.save(demandeur);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierDemandeur")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierDemandeur(id="+id+")";
	}

	@RequestMapping(value = "/SuppDemandeur")
	private String supp(Long id) {
		final Demandeur demandeur = demandeurRepository.getOne(id);
		demandeurRepository.delete(demandeur);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
