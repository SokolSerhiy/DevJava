package ua.controller;

import java.security.Principal;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.entity.Owner;
import ua.model.filter.TransporterFilter;
import ua.model.request.FileRequest;
import ua.service.FileWritter;
import ua.service.TransporterService;

@Controller
public class MainController {
	
	private final TransporterService service;
	
	private final FileWritter writter;
	
	public MainController(TransporterService service, FileWritter writter) {
		this.service = service;
		this.writter = writter;
	}
	
	@ModelAttribute("transporterFilter")
	public TransporterFilter getFilter() {
		return new TransporterFilter();
	}
	
	@ModelAttribute("fileRequest")
	public FileRequest getForm() {
		return new FileRequest();
	}

	@GetMapping("/")
	public String index(Model model, 
			Principal principal, 
			@ModelAttribute("transporterFilter") TransporterFilter filter,
			@PageableDefault Pageable pageable) {
		model.addAttribute("brands", service.findAllBrands());
		model.addAttribute("models", service.findAllModels());
		model.addAttribute("cities", service.findAllCities());
		model.addAttribute("transporters", service.findAll(filter, pageable));
		if(principal!=null) {
			model.addAttribute("message", "Hello "+principal.getName());
		}else {
			model.addAttribute("message", "Hello Unauthorize user");
		}
		return "index";
	}
	
	@PostMapping("/")
	public String saveFile(@ModelAttribute("fileRequest") FileRequest request) {
		System.out.println(writter.write(request.getFile()));
		return "redirect:/";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	public static class Asasasss{
		
		private Owner owner;

		public Owner getOwner() {
			return owner;
		}

		public void setOwner(Owner owner) {
			this.owner = owner;
		}
	}
}
