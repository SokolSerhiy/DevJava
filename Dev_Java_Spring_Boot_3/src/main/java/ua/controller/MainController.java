package ua.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.entity.Owner;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		if(principal!=null) {
			model.addAttribute("message", "Hello "+principal.getName());
		}else {
			model.addAttribute("message", "Hello Unauthorize user");
		}
		return "index";
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
