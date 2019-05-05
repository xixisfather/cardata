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

	public List<ShsjAnalyseDTO> shsjAnalyse(int yearFrom, int yearTo) {
		List<ShsjAnalyseDTO> shsjAnalyseDTOs = new ArrayList<ShsjAnalyseDTO>();
		for (int year = yearFrom; year <= yearTo; year++) {
			ShsjAnalyseDTO shsjAnalyseDTO = shsjAnalyse(year);
			shsjAnalyseDTOs.add(shsjAnalyseDTO);
		}
		return shsjAnalyseDTOs;
	}

	private ShsjAnalyseDTO shsjAnalyse(int year) {
		ShsjAnalyseDTO shsjAnalyseDTO = shsjMapper.shsjAnalyse(year);
		return shsjAnalyseDTO;
	}
}
