package com.car.analyse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/toindex")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("/towestmenu")
	public String toWestMenu() {
		return "westmenu";
	}
}
