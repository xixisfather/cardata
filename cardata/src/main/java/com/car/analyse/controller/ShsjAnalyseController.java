package com.car.analyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.car.analyse.dto.ShsjAnalyseDTO;
import com.car.analyse.service.ShsjService;

@Controller
@RequestMapping("/shsjanalyse")
public class ShsjAnalyseController {

	@Autowired
	private ShsjService shsjService;
	
	@RequestMapping("/toshsjanalyse")
	public String toQueryStaffUser() {
		return "shsjanalyse";
	}
	
	@PostMapping(path="/shsjanalysequery")
	@ResponseBody
	public Object queryStaffUser() {
		List<ShsjAnalyseDTO> shsjAnalyses = shsjService.shsjAnalyse();
		return JSON.toJSON(shsjAnalyses);
	}

}
