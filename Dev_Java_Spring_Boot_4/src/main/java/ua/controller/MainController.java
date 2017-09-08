package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.entity.User;
import ua.model.filter.CafeFilter;
import ua.repository.CafeViewRepository;
import ua.repository.MealRepository;

@Controller
public class MainController {
	
	private final CafeViewRepository repository;
	
	private final MealRepository mealRepository;
	
	public MainController(CafeViewRepository repository, MealRepository mealRepository) {
		this.repository = repository;
		this.mealRepository = mealRepository;
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter() {
		return new CafeFilter();
	}

	@GetMapping("/")
	public String index(Model model, User user, @ModelAttribute("cafeFilter") CafeFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealRepository.findAll());
		model.addAttribute("cafes", repository.findAll(filter, pageable));
		if(user!=null) {
			model.addAttribute("message", "Hello "+user.getEmail());
			System.out.println(user.getRole());
			System.out.println(user.getPassword());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
