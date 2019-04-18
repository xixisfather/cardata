package com.car.analyse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.dto.BfgxjsybAnalyseDTO;
import com.car.analyse.mapper.BaseMapper;
import com.car.analyse.mapper.BshzfxMapper;
import com.car.analyse.tools.Constants;
import com.car.analyse.tools.ToolKits;

@Service
public class BshzfxService {
	@Autowired
	private BshzfxMapper bshzfxMapper;
	
	@Autowired
	private BaseMapper baseMapper;
	
	public List<BfgxjsybAnalyseDTO> bfgxjsybAnalyse(int year,int season) {
		List<String> insuranceCompanyList = baseMapper.findAllInsuranceCompany(year);
		String dateFrom = year + Constants.buildSeasonMap().get(season).split(",")[0];
		String dateTo = year + Constants.buildSeasonMap().get(season).split(",")[1];
		List<BfgxjsybAnalyseDTO> xbbfs = bshzfxMapper.bfgxjsybAnalyseXbbf(year, dateFrom, dateTo);
		List<BfgxjsybAnalyseDTO> rbbfs = bshzfxMapper.bfgxjsybAnalyseRbbf(year, dateFrom, dateTo);
		Map<String, Double> xbbfMap = xbbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getXbbf));
		Map<String, Double> rbbfMap = rbbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getRbbf));
		
		List<BfgxjsybAnalyseDTO> xbjqxbfs = bshzfxMapper.bfgxjsybAnalyseXbjqxbf(year, dateFrom, dateTo);
		List<BfgxjsybAnalyseDTO> rbjqxbfs = bshzfxMapper.bfgxjsybAnalyseRbjqxbf(year, dateFrom, dateTo);
		List<BfgxjsybAnalyseDTO> xbsyxbfs = bshzfxMapper.bfgxjsybAnalyseXbsyxbf(year, dateFrom, dateTo);
		List<BfgxjsybAnalyseDTO> rbsyxbfs = bshzfxMapper.bfgxjsybAnalyseRbsyxbf(year, dateFrom, dateTo);
		Map<String, Double> xbjqxbfMap = xbjqxbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getJqxyjjsje));
		Map<String, Double> rbjqxbfMap = rbjqxbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getJqxyjjsje));
		Map<String, Double> xbsyxbfMap = xbsyxbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getSyxyjjsje));
		Map<String, Double> rbsyxbfMap = rbsyxbfs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getSyxyjjsje));
		
		List<BfgxjsybAnalyseDTO> xbsgcczs = bshzfxMapper.bfgxjsybAnalyseXbsgccz(year, dateFrom, dateTo);
		List<BfgxjsybAnalyseDTO> rbsgcczs = bshzfxMapper.bfgxjsybAnalyseRbsgccz(year, dateFrom, dateTo);
		Map<String, Double> xbsgcczMap = xbsgcczs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getXbsgccz));
		Map<String, Double> rbsgcczMap = rbsgcczs.stream().collect(Collectors.toMap(BfgxjsybAnalyseDTO::getBxgs,BfgxjsybAnalyseDTO::getRbsgccz));
		
		List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseDTOs = new ArrayList<BfgxjsybAnalyseDTO>();
		for(String insuranceCompany : insuranceCompanyList) {
			BfgxjsybAnalyseDTO bfgxjsybAnalyseDTO = new BfgxjsybAnalyseDTO();
			Double xbbf = xbbfMap.get(insuranceCompany) == null ? 0 : xbbfMap.get(insuranceCompany);
			Double rbbf = rbbfMap.get(insuranceCompany) == null ? 0 : rbbfMap.get(insuranceCompany);
			Double zbf = ToolKits.add(xbbf, rbbf);
			Double xbzb = ToolKits.divid(xbbf, zbf);
			Double rbzb = ToolKits.divid(rbbf, zbf);
			
			Double xbjqxbf = xbjqxbfMap.get(insuranceCompany) == null ? 0 : xbjqxbfMap.get(insuranceCompany);
			Double rbjqxbf = rbjqxbfMap.get(insuranceCompany) == null ? 0 : rbjqxbfMap.get(insuranceCompany);
			Double xbsyxbf = xbsyxbfMap.get(insuranceCompany) == null ? 0 : xbsyxbfMap.get(insuranceCompany);
			Double rbsyxbf = rbsyxbfMap.get(insuranceCompany) == null ? 0 : rbsyxbfMap.get(insuranceCompany);
			
			Double xbsgccz = xbsgcczMap.get(insuranceCompany) == null ? 0 : xbjqxbfMap.get(insuranceCompany);
			Double rbsgccz = rbsgcczMap.get(insuranceCompany) == null ? 0 : xbjqxbfMap.get(insuranceCompany);
			
			bfgxjsybAnalyseDTO.setYear(year);
			bfgxjsybAnalyseDTO.setSeason(season);
			bfgxjsybAnalyseDTO.setBxgs(insuranceCompany);
			bfgxjsybAnalyseDTO.setXbbf(xbbf);
			bfgxjsybAnalyseDTO.setRbbf(rbbf);
			bfgxjsybAnalyseDTO.setXbzb(xbzb);
			bfgxjsybAnalyseDTO.setRbzb(rbzb);
			bfgxjsybAnalyseDTO.setZbf(zbf);
			
			bfgxjsybAnalyseDTO.setJqxyjjsje(ToolKits.add(xbjqxbf, rbjqxbf));
			bfgxjsybAnalyseDTO.setSyxyjjsje(ToolKits.add(xbsyxbf, rbsyxbf));
			
			bfgxjsybAnalyseDTO.setXbsgccz(xbsgccz);
			bfgxjsybAnalyseDTO.setRbsgccz(rbsgccz);
			bfgxjsybAnalyseDTO.setSgccz(ToolKits.add(xbsgccz, rbsgccz));
			
			bfgxjsybAnalyseDTOs.add(bfgxjsybAnalyseDTO);
		}
		return bfgxjsybAnalyseDTOs;
	}
}
