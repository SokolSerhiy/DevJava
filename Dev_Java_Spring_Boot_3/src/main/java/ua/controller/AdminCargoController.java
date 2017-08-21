package ua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CargoRequest;
import ua.service.CargoService;

@Controller
@RequestMapping("/admin/cargo")
@SessionAttributes("cargo")
public class AdminCargoController {

	private final CargoService service;
	
	public AdminCargoController(CargoService service) {
		this.service = service;
	}
	
	@ModelAttribute("cargo")
	public CargoRequest getForm() {
		return new CargoRequest();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cargos", service.findAllView());
		model.addAttribute("cities", service.findAllCity());
		model.addAttribute("goodss", service.findAllGoods());
		return "cargo";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/cargo";
	}
	
	@PostMapping
	public String save(@ModelAttribute("cargo") CargoRequest request, SessionStatus status){
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cargo", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/cargo";
	}
}
