package pfa.emsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pfa.emsi.dao.DocumentTypeRepository;
import pfa.emsi.dao.WorkflowRepository;
import pfa.emsi.model.DocumentType;
import pfa.emsi.model.Workflow;

@Controller
@RequestMapping(value = "/DocumentType")
public class DocumentTypeContoller {

	@Autowired
	private DocumentTypeRepository documentTypeRepository;

	@Autowired
	private WorkflowRepository workflowRepository;

	@RequestMapping(value = "/List")
	private String list(Model model) {
		List<DocumentType> documentTypes = documentTypeRepository.findAll();
		model.addAttribute("documentTypes", documentTypes);
		return "/admin/listerDocumentType";
	}

	@RequestMapping(value = "/AjouterOuModifierDocumentType")
	private String ajouterOuModifier(Model model, Long id) {
		if (id != null) {
			DocumentType documentType = documentTypeRepository.getOne(id);
			model.addAttribute("documentType", documentType);
		} else {
			model.addAttribute("documentType", new DocumentType());
		}
		List<Workflow> workflows = workflowRepository.findAll();
		model.addAttribute("workflows", workflows);
		return "/admin/ajouterDocumentType";
	}

	@RequestMapping(value = "/AjouterDocumentType")
	private String ajouter(DocumentType documentType) {
		documentTypeRepository.save(documentType);
		return "redirect:List";
	}

	@RequestMapping(value = "/ModifierDocumentType")
	private String modifier(Model model, Long id) {
		return "redirect:AjouterOuModifierDocumentType(id=" + id + ")";
	}

	@RequestMapping(value = "/SuppDocumentType")
	private String supp(Long id) {
		final DocumentType documentType = documentTypeRepository.getOne(id);
		documentTypeRepository.delete(documentType);
		return "redirect:List";
	}

	/*
	 * @RequestMapping("/error") public String handleError() { return "error"; }
	 */

}
