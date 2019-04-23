package com.car.analyse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.mapper.BxgxfxMapper;
@Service
public class BxgxfxService {
	
	@Autowired
	private BxgxfxMapper bxgxfxMapper;

	public List<BxhcgxAnalyseDTO> bxhcgxAnalyseByYear(int year) {
		List<BxhcgxAnalyseDTO> bxhcgxAnalyseDTOs = new ArrayList<BxhcgxAnalyseDTO>();
		
		List<BxhcgxAnalyseDTO> xbs = bxgxfxMapper.bxhcgxAnalyseXb(year);
		List<BxhcgxAnalyseDTO> rbs = bxgxfxMapper.bxhcgxAnalyseRb(year);
		bxhcgxAnalyseDTOs.addAll(xbs);
		bxhcgxAnalyseDTOs.addAll(rbs);
		
		return bxhcgxAnalyseDTOs;
	}
}
