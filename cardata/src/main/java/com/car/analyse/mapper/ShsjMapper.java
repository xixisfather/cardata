package com.car.analyse.mapper;

import org.apache.ibatis.annotations.Param;

import com.car.analyse.dto.ShsjAnalyseDTO;

public interface ShsjMapper {
	
	public ShsjAnalyseDTO shsjAnalyse(@Param("year") int year);
    
}