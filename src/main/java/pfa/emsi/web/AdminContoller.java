package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.AdminRepository;
import pfa.emsi.model.Admin;

@Controller
@RequestMapping(value="/Admin")
public class AdminContoller {

	@Autowired
	private AdminRepository adminRepository;
	
	@RequestMapping(value="/Index")
	private String Index(Model model) {
		List<Admin> admin=adminRepository.findAll();
		model.addAttribute("admins", admin);
		return "admins";

	}
	
}
