package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.ComponentRequest;
import ua.service.ComponentService;

@Controller
@RequestMapping("/admin/component")
@SessionAttributes("component")
public class AdminComponentController {

	private final ComponentService service;
	
	@Autowired
	public AdminComponentController(ComponentService service) {
		this.service = service;
	}
	
	@ModelAttribute("component")
	public ComponentRequest getForm() {
		return new ComponentRequest();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("mss", service.findAllMss());
		model.addAttribute("components", service.findAllView());
		return "component";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/component";
	}
	
	@PostMapping
	public String save(@ModelAttribute("component") ComponentRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("component", service.findOneRequest(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/component";
	}
}
