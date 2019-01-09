package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ServiceRepository;
import pfa.emsi.model.Service;

@Controller
@RequestMapping(value = "/Service")
public class ServiceContoller {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<Service> services = serviceRepository.findAll();
		model.addAttribute("services", services);
		return "/admin/listerService";
	}
	
	@RequestMapping(value = "/AjouterOuModifierService")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			Service service = serviceRepository.getOne(id);
			model.addAttribute("service", service);
		} else {
			model.addAttribute("service", new Service());
		}
		return "/admin/ajouterService";
	}
	
	@RequestMapping(value = "/AjouterService")
	private String ajouter(Service service) {
		serviceRepository.save(service);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierService")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierService(id="+id+")";
	}

	@RequestMapping(value = "/SuppService")
	private String supp(Long id) {
		final Service service = serviceRepository.getOne(id);
		serviceRepository.delete(service);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */
	
}
