package ua.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Goods;
import ua.service.CargoService;
import ua.service.CityService;
import ua.service.GoodsService;

@Controller
@RequestMapping("/admin/cargo")
public class AdminCargoController {

	private final CargoService service;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private GoodsService goodsService;

	public AdminCargoController(CargoService service) {
		this.service = service;
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cargos", service.findAllView());
		model.addAttribute("cities", service.findAllCity());
		model.addAttribute("goodss", service.findAllGoods());
		return "cargo";
	}
	
	@GetMapping("/delete/{id}")
	public String show(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/cargo";
	}
	
	@PostMapping
	public String save(@RequestParam String goods,
			@RequestParam int weight,
			@RequestParam int height,
			@RequestParam int width,
			@RequestParam int length,
			@RequestParam String cityFrom,
			@RequestParam String cityTo,
			@RequestParam BigDecimal price){
		Goods goods1 = goodsService.findByName(goods);
		City from = cityService.findByName(cityFrom);
		City to = cityService.findByName(cityTo);
		Cargo cargo = new Cargo(goods1, weight, height, width, length, from, to, price);
		service.save(cargo);
		return "redirect:/admin/cargo";
	}
}
