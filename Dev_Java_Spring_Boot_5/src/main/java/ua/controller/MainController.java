package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.entity.User;
import ua.model.filter.MealFilter;
import ua.model.request.FileRequest;
import ua.repository.MealRepository;
import ua.repository.MealViewRepository;
import ua.service.FileWriter;

@Controller
public class MainController {

	private final MealViewRepository repository;

	private final MealRepository mealRepository;
	
	private final FileWriter writer;

	public MainController(MealViewRepository repository, MealRepository mealRepository, FileWriter writer) {
		this.repository = repository;
		this.mealRepository = mealRepository;
		this.writer = writer;
	}

	@ModelAttribute("mealFilter")
	public MealFilter getFilter() {
		return new MealFilter();
	}

	@ModelAttribute("fileRequest")
	public FileRequest getForm() {
		return new FileRequest();
	}

	@GetMapping("/")
	public String index(Model model, User user, @ModelAttribute("mealFilter") MealFilter filter,
			@PageableDefault Pageable pageable) {
		model.addAttribute("meals", repository.findAll(filter, pageable));
		model.addAttribute("cuisines", mealRepository.findAllCuisines());
		if (user != null) {
			model.addAttribute("message", "Hello " + user.getEmail());
			System.out.println(user.getPassword());
			System.out.println(user.getRole());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		return "index";
	}

	@PostMapping("/")
	public String saveFile(@ModelAttribute("fileRequest") FileRequest request) {
		System.out.println(writer.write(request.getFile()));
		return "redirect:/";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
