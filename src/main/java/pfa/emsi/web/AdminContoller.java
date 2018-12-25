package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ServiceRepository;
import pfa.emsi.model.Service;

@Controller
@RequestMapping(value = "/Admin")
public class AdminContoller {

	@Autowired
	private ServiceRepository serviceRepository;

	@RequestMapping(value = "/Index")
	private String index(Model model, Long id) {
		if (id != null) {
			Service service = serviceRepository.getOne(id);
			model.addAttribute("service", service);
		} else {
			model.addAttribute("service", new Service());
		}
		List<Service> services = serviceRepository.findAll();
		model.addAttribute("services", services);
		return "ServiceCrud";
	}

	@RequestMapping(value = "/AjouterService")
	private String ajouterService(Service service) {
		serviceRepository.save(service);
		return "redirect:Index";
	}

	@RequestMapping(value = "/ModifierService")
	private String modifierService(Model model, Long id) {
		return "redirect:Index(id="+id+")";
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
