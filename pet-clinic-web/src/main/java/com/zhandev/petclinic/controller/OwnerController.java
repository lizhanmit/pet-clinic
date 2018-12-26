package com.zhandev.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	@RequestMapping({"", "/", "/index", "/index.html"})  // requesting any of these URLs can direct to the same owners index page
	public String listOwners() {
		return "owners/index";  // "templates" folder -> "owners" folder -> "index.html" file
	}
}
