package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.ChefServiceRepository;
import pfa.emsi.model.ChefService;

@Controller
@RequestMapping(value="/ChefService")
public class ChefServiceContoller {

	@Autowired
	private ChefServiceRepository chefServiceRepository;

	@RequestMapping(value = "/Index")
	private String Index(Model model) {
		List<ChefService> chservice = chefServiceRepository.findAll();
		model.addAttribute("chfservices", chservice);
		return "chfservices";

	}
}
