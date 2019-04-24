package com.car.analyse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.dto.BxhcpcgxAnalyseDTO;

public interface BxgxfxMapper {
	
	List<BxhcgxAnalyseDTO> bxhcgxAnalyseXb(@Param("year") int year);
	
	List<BxhcgxAnalyseDTO> bxhcgxAnalyseRb(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbHcCls(@Param("year") int year);
}
