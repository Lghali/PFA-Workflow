package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ServiceRepository;
import pfa.emsi.model.Service;

@Controller
public class ServiceContoller {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@RequestMapping(value = "/Index")
	private String index(Model model) {
		List<Service> services = serviceRepository.findAll();
		model.addAttribute("services", services);
		return "/admin/listerService";
	}
	
	@RequestMapping(value = "/AjouterOuModifier")
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
	private String ajouterService(Service service) {
		serviceRepository.save(service);
		return "redirect:Index";
	}

	@RequestMapping(value = "/ModifierService")
	private String modifierService(Model model, Long id) {
		return "redirect:AjouterOuModifier(id="+id+")";
	}

	@RequestMapping(value = "/SuppService")
	private String suppService(Long id) {
		final Service service = serviceRepository.getOne(id);
		serviceRepository.delete(service);
		return "redirect:Index";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */
	
}
