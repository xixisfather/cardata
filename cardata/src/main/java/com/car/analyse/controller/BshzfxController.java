package com.car.analyse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.car.analyse.dto.BfgxjsybAnalyseDTO;
import com.car.analyse.dto.BstsxmzlAnalyseDTO;
import com.car.analyse.dto.BsxyszgxAnalyseDTO;
import com.car.analyse.service.BshzfxService;

@Controller
@RequestMapping("/bshzfx")
public class BshzfxController {

	@Autowired
	private BshzfxService bshzfxService;
	
	@RequestMapping("/tobfgxjsybanalyse")
	public String toBfgxjsybanalyse() {
		return "bfgxjsybanalyse";
	}
	
	@PostMapping(path="/bfgxjsybanalysequery")
	@ResponseBody
	public Object queryBfgxjsybAnalyse(@RequestParam(value = "year")Integer year) {
		if(year == null) {
			return null;
		}
		List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseDTOs = bshzfxService.bfgxjsybAnalyseByYear(year);
		return JSON.toJSON(bfgxjsybAnalyseDTOs);
	}
	
	@RequestMapping("/tobssyxzgxanalyse")
	public String toQueryBssyxzgxAnalyse() {
		return "bssyxzgxanalyse";
	}
	
	@PostMapping(path="/bssyxzgxanalysequery")
	@ResponseBody
	public Object queryBssyxzgxAnalyse(@RequestParam(value = "year")Integer year,@RequestParam(value = "monthFrom")Integer monthFrom,@RequestParam(value = "monthTo")Integer monthTo) {
		if(year == null||monthFrom == null || monthTo == null) {
			return null;
		}
		List<BsxyszgxAnalyseDTO> bsxyszgxAnalyseDTOs = bshzfxService.bsxyszgxAnalyseByMonthRegin(year, monthFrom, monthTo);
		return JSON.toJSON(bsxyszgxAnalyseDTOs);
	}
	
	@RequestMapping("/tobstsxmzlanalyse")
	public String toBstsxmzlanalyse() {
		return "bstsxmzlanalyse";
	}
	
	@PostMapping(path="/bstsxmzlanalysequery")
	@ResponseBody
	public Object queryBstsxmzlAnalyse(@RequestParam(value = "year")Integer year,@RequestParam(value = "monthFrom")Integer monthFrom,@RequestParam(value = "monthTo")Integer monthTo) {
		if(year == null||monthFrom == null || monthTo == null) {
			return null;
		}
		List<BstsxmzlAnalyseDTO> bstsxmzlAnalyseDTOs = bshzfxService.bstsxmzlAnalyseByMonthRegin(year, monthFrom, monthTo);
		return JSON.toJSON(bstsxmzlAnalyseDTOs);
	}
}
