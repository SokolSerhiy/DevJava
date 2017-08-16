package ua.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Component;
import ua.entity.Ingredient;
import ua.entity.Ms;
import ua.repository.IngredientRepository;
import ua.repository.MsRepository;
import ua.service.ComponentService;

@Controller
@RequestMapping("/admin/component")
public class AdminComponentController {

	private final ComponentService service;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private MsRepository msRepository;
	@Autowired
	public AdminComponentController(ComponentService service) {
		this.service = service;
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
	public String save(@RequestParam BigDecimal amount,
			@RequestParam String ingredient,
			@RequestParam String ms) {
		Ms ms2 = msRepository.findByName(ms);
		Ingredient ingredient2 = ingredientRepository.findByName(ingredient);
		Component component = new Component(ingredient2, amount, ms2);
		service.save(component);
		return "redirect:/admin/component";
	}
}
