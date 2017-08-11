package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.IngredientService;

@Controller
@RequestMapping("/admin/ingredient")
public class AdminIngredientController {

	private final IngredientService service;
	
	@Autowired
	public AdminIngredientController(IngredientService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("ingredients", service.findAll());
		return "ingredient";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/ingredient";
	}
}
