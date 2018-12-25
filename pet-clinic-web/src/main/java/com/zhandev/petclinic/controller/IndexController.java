package com.zhandev.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"", "/", "index", "index.html"})  // requesting any of these URLs can direct to the same index page
	public String index() {
		return "index";
	}
}
