package com.zhandev.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	@RequestMapping({"/", "vets/index", "vets/index.html"})  // requesting any of these URLs can direct to the same vets index page
	public String listVets() {
		return "vets/index";  // "templates" folder -> "vets" folder -> "index.html" file
	}
}
