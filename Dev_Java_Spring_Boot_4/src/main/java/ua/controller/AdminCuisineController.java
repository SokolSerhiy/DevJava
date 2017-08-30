package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Cuisine;
import ua.service.CuisineService;
import ua.validation.flag.CuisineFlag;

@Controller
@RequestMapping("/admin/cuisine")
@SessionAttributes("cuisine")
public class AdminCuisineController {

	private final CuisineService service;
	
	@Autowired
	public AdminCuisineController(CuisineService service) {
		this.service = service;
	}
	
	@ModelAttribute("cuisine")
	public Cuisine getForm() {
		return new Cuisine();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("cuisines", service.findAll());
		return "cuisine";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/cuisine";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cuisine") @Validated(CuisineFlag.class) Cuisine cuisine, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		service.save(cuisine);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cuisine", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/cuisine";
	}
}
