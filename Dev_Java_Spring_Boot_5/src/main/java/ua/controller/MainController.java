package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Hello111");
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
