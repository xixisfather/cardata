package com.car.analyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.service.BxgxfxService;

@Controller
@RequestMapping("/bxgxfx")
public class BxgxfxController {

	@Autowired
	private BxgxfxService bxgxfxService;
	
	@RequestMapping("/tobxhcgxanalyse")
	public String toBfgxjsybanalyse() {
		return "bxhcgxanalyse";
	}
	
	@PostMapping(path="/bxhcgxanalysequery")
	@ResponseBody
	public Object queryBfgxjsybAnalyse(@RequestParam(value = "year")Integer year) {
		if(year == null) {
			return null;
		}
		List<BxhcgxAnalyseDTO> bxhcgxAnalyseDTODTOs = bxgxfxService.bxhcgxAnalyseByYear(year);
		return JSON.toJSON(bxhcgxAnalyseDTODTOs);
	}
}
