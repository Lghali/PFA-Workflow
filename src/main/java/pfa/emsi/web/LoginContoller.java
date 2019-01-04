package pfa.emsi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pfa.emsi.dao.AdminRepository;
import pfa.emsi.dao.ChefServiceRepository;
import pfa.emsi.dao.DemandeurRepository;
import pfa.emsi.dao.DirecteurRepository;
import pfa.emsi.model.Admin;
import pfa.emsi.model.ChefService;
import pfa.emsi.model.Demandeur;
import pfa.emsi.model.Directeur;

@Controller
@RequestMapping(value = "/Login")
public class LoginContoller {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ChefServiceRepository chefServiceRepository;

	@Autowired
	private DemandeurRepository demandeurRepository;

	@Autowired
	private DirecteurRepository directeurRepository;

	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(name = "login") String login,
			@RequestParam(name = "mdp") String mdp) {

		Admin admin = adminRepository.findByLogin(login);
		ChefService chefService = chefServiceRepository.findByLogin(login);
		Demandeur demandeur = demandeurRepository.findByLogin(login);
		Directeur directeur = directeurRepository.findByLogin(login);

		if (admin != null) {
			if (admin.getPassword().equals(mdp)) {
				model.addAttribute("user", admin);
				return "/admin/index";
			} else {
				return "redirect:/";
			}
		} else if (chefService != null) {
			if (chefService.getPassword().equals(mdp)) {
				model.addAttribute("user", chefService);
				return "redirect:/chefService/index";
			} else {
				return "redirect:/";
			}
		} else if (demandeur != null) {
			if (demandeur.getPassword().equals(mdp)) {
				model.addAttribute("user", demandeur);
				return "redirect:/demandeur/index";
			} else {
				return "redirect:/";
			}
		} else if (directeur != null) {
			if (directeur.getPassword().equals(mdp)) {
				model.addAttribute("user", directeur);
				return "redirect:/directeur/index";
			} else {
				return "redirect:/";
			}
		}

		return "redirect:/";

	}

}
