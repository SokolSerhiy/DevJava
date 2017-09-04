package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.entity.User;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model, User user) {
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
