package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.entity.User;
import ua.model.filter.CafeFilter;
import ua.model.request.FileRequest;
import ua.repository.CafeViewRepository;
import ua.repository.MealRepository;
import ua.service.FileWritter;

@Controller
public class MainController {

	private final CafeViewRepository repository;

	private final MealRepository mealRepository;
	
	private final FileWritter writer;

	public MainController(CafeViewRepository repository, MealRepository mealRepository, FileWritter writer) {
		this.repository = repository;
		this.mealRepository = mealRepository;
		this.writer = writer;
	}

	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter() {
		return new CafeFilter();
	}

	@ModelAttribute("fileRequest")
	public FileRequest getForm() {
		return new FileRequest();
	}

	@GetMapping("/")
	public String index(Model model, User user, @ModelAttribute("cafeFilter") CafeFilter filter,
			@PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealRepository.findAll());
		model.addAttribute("cafes", repository.findAll(filter, pageable));
		if (user != null) {
			model.addAttribute("message", "Hello " + user.getEmail());
			System.out.println(user.getRole());
			System.out.println(user.getPassword());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		return "index";
	}

	@PostMapping("/")
	public String saveFile(@ModelAttribute("fileRequest") FileRequest request) {
		System.out.println(writer.writte(request.getFile()));
		return "redirect:/";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
