package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ChefServiceRepository;
import pfa.emsi.dao.EtapeRepository;
import pfa.emsi.dao.WorkflowRepository;
import pfa.emsi.model.ChefService;
import pfa.emsi.model.Etape;
import pfa.emsi.model.Workflow;

@Controller
@RequestMapping(value = "/Etape")
public class EtapeContoller {

	@Autowired
	private EtapeRepository etapeRepository;

	@Autowired
	private WorkflowRepository workflowRepository;

	@Autowired
	private ChefServiceRepository chefServiceRepository;

	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<Etape> etapes = etapeRepository.findAll();
		model.addAttribute("etapes", etapes);
		return "/directeur/listerEtape";
	}

	@RequestMapping(value = "/AjouterOuModifierEtape")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			Etape etape = etapeRepository.getOne(id);
			model.addAttribute("etape", etape);
		} else {
			model.addAttribute("etape", new Etape());
		}
		List<Workflow> workflows = workflowRepository.findAll();
		model.addAttribute("workflows", workflows);
		List<ChefService> chefServices = chefServiceRepository.findAll();
		model.addAttribute("chefServices", chefServices);
		return "/directeur/ajouterEtape";
	}

	@RequestMapping(value = "/AjouterEtape")
	private String ajouter(Etape etape) {
		etapeRepository.save(etape);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierEtape")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierEtape(id=" + id + ")";
	}

	@RequestMapping(value = "/SuppEtape")
	private String supp(Long id) {
		final Etape etape = etapeRepository.getOne(id);
		etapeRepository.delete(etape);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
