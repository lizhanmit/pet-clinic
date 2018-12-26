package com.zhandev.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

	@RequestMapping({"", "/", "/index", "/index.html"})  // requesting any of these URLs can direct to the same vets index page
	public String listVets() {
		return "vets/index";  // "templates" folder -> "vets" folder -> "index.html" file
	}
}
