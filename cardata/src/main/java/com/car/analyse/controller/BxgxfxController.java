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
import com.car.analyse.dto.BxhcpcgxAnalyseDTO;
import com.car.analyse.dto.XbywfxAnalyseDTO;
import com.car.analyse.service.BxgxfxService;

@Controller
@RequestMapping("/bxgxfx")
public class BxgxfxController {

	@Autowired
	private BxgxfxService bxgxfxService;

	@RequestMapping("/tobxhcgxanalyse")
	public String toBxhcgxAnalyse() {
		return "bxhcgxanalyse";
	}

	@PostMapping(path = "/bxhcgxanalysequery")
	@ResponseBody
	public Object queryBxhcgxAnalyse(@RequestParam(value = "year") Integer year) {
		if (year == null) {
			return null;
		}
		List<BxhcgxAnalyseDTO> bxhcgxAnalyseDTODTOs = bxgxfxService.bxhcgxAnalyseByYear(year);
		return JSON.toJSON(bxhcgxAnalyseDTODTOs);
	}

	@RequestMapping("/tobxhcpcgxanalyse")
	public String toBxhcpcgxAnalyse() {
		return "bxhcpcgxanalyse";
	}

	@PostMapping(path = "/bxhcpcgxanalysequery")
	@ResponseBody
	public Object queryBxhcpcgxAnalyse(@RequestParam(value = "year") Integer year) {
		if (year == null) {
			return null;
		}
		List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseDTOs = bxgxfxService.bxhcpcgxAnalyseByYear(year);
		return JSON.toJSON(bxhcpcgxAnalyseDTOs);
	}

	@RequestMapping("/toxbywfxanalyse")
	public String toXbywfxAnalyse() {
		return "xbywfxanalyse";
	}

	@PostMapping(path = "/xbywfxxblxanalysequery")
	@ResponseBody
	public Object queryXbywfxxblxAnalyse(@RequestParam(value = "year") Integer year,
			@RequestParam(value = "monthFrom") Integer monthFrom, @RequestParam(value = "monthTo") Integer monthTo) {
		if (year == null||null == monthFrom||null == monthTo) {
			return null;
		}
		List<XbywfxAnalyseDTO> xbywfxxblxAnalyseDTOs = bxgxfxService.xbywfxxblxAnalyseByMonthRegin(year, monthFrom, monthTo).get("xblx");
		return JSON.toJSON(xbywfxxblxAnalyseDTOs);
	}
	
	@PostMapping(path = "/xbywfxxbkhanalysequery")
	@ResponseBody
	public Object queryXbywfxxbkhAnalyse(@RequestParam(value = "year") Integer year,
			@RequestParam(value = "monthFrom") Integer monthFrom, @RequestParam(value = "monthTo") Integer monthTo) {
		if (year == null||null == monthFrom||null == monthTo) {
			return null;
		}
		List<XbywfxAnalyseDTO> xbywfxxblxAnalyseDTOs = bxgxfxService.xbywfxxblxAnalyseByMonthRegin(year, monthFrom, monthTo).get("xbkh");
		return JSON.toJSON(xbywfxxblxAnalyseDTOs);
	}
}
