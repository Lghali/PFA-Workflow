package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.DirecteurRepository;
import pfa.emsi.model.Directeur;

@Controller
@RequestMapping(value = "/Directeur")
public class DirecteurContoller {

	@Autowired
	private DirecteurRepository directeurRepository;
	
	@RequestMapping(value = "/Index")
	public String index() {
		return "/directeur/indexDirecteur";
	}

	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<Directeur> directeurs = directeurRepository.findAll();
		model.addAttribute("directeurs", directeurs);
		return "/admin/listerDirecteur";
	}

	@RequestMapping(value = "/AjouterOuModifierDirecteur")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			Directeur directeur = directeurRepository.getOne(id);
			model.addAttribute("directeur", directeur);
		} else {
			model.addAttribute("directeur", new Directeur());
		}
		return "/admin/ajouterDirecteur";
	}

	@RequestMapping(value = "/AjouterDirecteur")
	private String ajouter(Directeur directeur) {
		directeurRepository.save(directeur);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierDirecteur")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierDirecteur(id=" + id + ")";
	}

	@RequestMapping(value = "/SuppDirecteur")
	private String supp(Long id) {
		final Directeur directeur= directeurRepository.getOne(id);
		directeurRepository.delete(directeur);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
