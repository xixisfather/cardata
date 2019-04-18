package com.car.analyse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.analyse.dto.BfgxjsybAnalyseDTO;
import com.car.analyse.dto.BsxyszgxAnalyseDTO;

public interface BshzfxMapper {
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseXbbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseRbbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseXbjqxbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseRbjqxbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseXbsyxbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseRbsyxbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseXbsgccz(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BfgxjsybAnalyseDTO> bfgxjsybAnalyseRbsgccz(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
		
	List<BsxyszgxAnalyseDTO> bsxyszgxAnalyseXb(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<BsxyszgxAnalyseDTO> bsxyszgxAnalyseRb(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	

}
