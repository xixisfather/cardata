package com.car.analyse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.dto.ShsjAnalyseDTO;
import com.car.analyse.mapper.ShsjMapper;

@Service
public class ShsjService {
	@Autowired
	private ShsjMapper shsjMapper;
	
	public List<ShsjAnalyseDTO> shsjAnalyse() {
		ShsjAnalyseDTO shsjAnalyseDTO2017 = shsjMapper.shsjAnalyse(2017);
		ShsjAnalyseDTO shsjAnalyseDTO2018 = shsjMapper.shsjAnalyse(2018);
		ShsjAnalyseDTO shsjAnalyseDTO2019 = shsjMapper.shsjAnalyse(2019);
		List<ShsjAnalyseDTO> shsjAnalyseDTOs = new ArrayList<ShsjAnalyseDTO>();
		shsjAnalyseDTOs.add(shsjAnalyseDTO2017);
		shsjAnalyseDTOs.add(shsjAnalyseDTO2018);
		shsjAnalyseDTOs.add(shsjAnalyseDTO2019);
		return shsjAnalyseDTOs;
	}
}
