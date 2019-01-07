package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ChefServiceRepository;
import pfa.emsi.dao.ServiceRepository;
import pfa.emsi.model.ChefService;
import pfa.emsi.model.Service;

@Controller
@RequestMapping(value = "/ChefService")
public class ChefServiceContoller {

	@Autowired
	private ChefServiceRepository chefServiceRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@RequestMapping(value = "/List")
	private String List(Model model) {
		List<ChefService> chefServices = chefServiceRepository.findAll();
		model.addAttribute("chefServices", chefServices);
		return "/admin/listerChefService";
	}

	@RequestMapping(value = "/AjouterOuModifierChefService")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			ChefService chefService = chefServiceRepository.getOne(id);
			model.addAttribute("chefService", chefService);
		} else {
			model.addAttribute("chefService", new ChefService());
		}
		List<Service> services = serviceRepository.findAll();
		model.addAttribute("services", services);
		return "/admin/ajouterChefService";
	}

	@RequestMapping(value = "/AjouterChefService")
	private String ajouterService(ChefService chefService) {
		chefServiceRepository.save(chefService);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierChefService")
	private String modifierService(Model model, Long id) {
		return "redirect:AjouterOuModifierChefService(id=" + id + ")";
	}

	@RequestMapping(value = "/SuppChefService")
	private String suppService(Long id) {
		final ChefService chefService = chefServiceRepository.getOne(id);
		chefServiceRepository.delete(chefService);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
