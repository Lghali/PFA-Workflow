package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.WorkflowRepository;
import pfa.emsi.model.Workflow;

@Controller
@RequestMapping(value = "/Workflow")
public class WorkflowContoller {

	@Autowired
	private WorkflowRepository workflowRepository;

	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<Workflow> workflows = workflowRepository.findAll();
		model.addAttribute("workflows", workflows);
		return "/directeur/listerWorkflow";
	}

	@RequestMapping(value = "/AjouterOuModifierWorkflow")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			Workflow workflow = workflowRepository.getOne(id);
			model.addAttribute("workflow", workflow);
		} else {
			model.addAttribute("workflow", new Workflow());
		}
		return "/directeur/ajouterWorkflow";
	}

	@RequestMapping(value = "/AjouterWorkflow")
	private String ajouter(Workflow workflow) {
		workflowRepository.save(workflow);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierWorkflow")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierWorkflow(id=" + id + ")";
	}

	@RequestMapping(value = "/SuppWorkflow")
	private String supp(Long id) {
		final Workflow workflow = workflowRepository.getOne(id);
		workflowRepository.delete(workflow);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
