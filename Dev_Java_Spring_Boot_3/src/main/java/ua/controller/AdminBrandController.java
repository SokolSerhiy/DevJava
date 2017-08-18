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

import ua.entity.Brand;
import ua.service.BrandService;

@Controller
@RequestMapping("/admin/brand")
@SessionAttributes("brand")
public class AdminBrandController {

	private final BrandService service;

	@Autowired
	public AdminBrandController(BrandService service) {
		this.service = service;
	}
	
	@ModelAttribute("brand")
	public Brand getForm(){
		return new Brand();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("brands", service.findAll());
		return "brand";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/brand";
	}
	
	@PostMapping
	public String save(@ModelAttribute("brand") Brand brand, SessionStatus status) {
		service.save(brand);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("brand", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/brand";
	}
}
