package com.car.analyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.car.analyse.model.TbStaffUser;
import com.car.analyse.service.TbStaffUserService;

@Controller
@RequestMapping("/staffuser")
public class TbStaffUserController {

	@Autowired
	private TbStaffUserService tbStaffUserService;
	
	@RequestMapping("/toquerystaffuser")
	public String toQueryStaffUser() {
		return "staffuser";
	}
	
	@PostMapping(path="/querystaffuser")
	@ResponseBody
	public Object queryStaffUser() {
		List<TbStaffUser> staffUsers = tbStaffUserService.selectAllStaffUsers();
		return JSON.toJSON(staffUsers);
	}

}
