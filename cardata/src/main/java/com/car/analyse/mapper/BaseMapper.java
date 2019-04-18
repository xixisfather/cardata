package com.car.analyse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper {

	List<String> findAllInsuranceCompany(@Param("year") int year);
}
