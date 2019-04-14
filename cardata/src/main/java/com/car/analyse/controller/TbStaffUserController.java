package com.car.analyse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.analyse.service.TbStaffUserService;

@Controller
@RequestMapping("/staffuser")
public class TbStaffUserController {

	@Autowired
	private TbStaffUserService tbStaffUserService;
	
	@RequestMapping("/querystaffuser")
	public String queryStaffUser() {
		return "querystaffuser";
	}
}
