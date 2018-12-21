package pfa.emsi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pfa.emsi.dao.AdminRepository;
import pfa.emsi.model.Admin;

@Controller
@RequestMapping(value = "/Login")
public class LoginContoller {

	@Autowired
	private AdminRepository adminRepository;

//	@Autowired
//	private ChefServiceRepository chefServiceRepository;
//	
//	@Autowired
//	private DemandeurRepository demandeurRepository;
//	
//	@Autowired
//	private DirecteurRepository directeurRepository;

	@RequestMapping(value = "/Index")
	public String Index(Model model, @RequestParam(name = "login") String login,
			@RequestParam(name = "mdp") String mdp) {

		Admin admin = adminRepository.findByLogin(login);

		if (admin != null) {
			if (admin.getPassword().equals(mdp)) {
				model.addAttribute("user", admin);
				System.out.println(admin.toString());
				return "resulta";
			} else {
				return "redirect:/";
			}
		}

		return "redirect:/";

	}

}
