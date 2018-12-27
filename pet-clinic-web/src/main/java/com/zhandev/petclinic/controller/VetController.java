package com.zhandev.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhandev.petclinic.service.VetService;

@RequestMapping("/vets")
@Controller
public class VetController {

	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"", "/", "/index", "/index.html"})  // requesting any of these URLs can direct to the same vets index page
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";  // "templates" folder -> "vets" folder -> "index.html" file
	}
}
