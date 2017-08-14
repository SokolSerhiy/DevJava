package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Brand;
import ua.service.BrandService;

@Controller
@RequestMapping("/admin/brand")
public class AdminBrandController {

	private final BrandService service;

	@Autowired
	public AdminBrandController(BrandService service) {
		this.service = service;
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
	public String save(@RequestParam String name) {
		service.save(new Brand(name));
		return "redirect:/admin/brand";
	}
}
