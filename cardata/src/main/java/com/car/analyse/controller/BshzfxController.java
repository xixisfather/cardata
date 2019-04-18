package com.car.analyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.car.analyse.dto.BfgxjsybAnalyseDTO;
import com.car.analyse.service.BshzfxService;

@Controller
@RequestMapping("/bshzfx")
public class BshzfxController {

	@Autowired
	private BshzfxService bshzfxService;
	
	@RequestMapping("/tobfgxjsybanalyse")
	public String toQueryStaffUser() {
		return "bfgxjsybanalyse";
	}
	
	@PostMapping(path="/bfgxjsybanalysequery")
	@ResponseBody
	public Object queryStaffUser() {
		List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseDTOs = bshzfxService.bfgxjsybAnalyse(2017, 1);
		return JSON.toJSON(bfgxjsybAnalyseDTOs);
	}
}
