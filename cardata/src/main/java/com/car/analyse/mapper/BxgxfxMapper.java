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
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbJsCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbJsCz(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbJsZcz(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpHcCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpJsCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpJsCz(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpJsZcz(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpHcCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpJsCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpJsCz(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpJsZcz(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbHcCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbJsCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbJsCz(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbJsZcz(@Param("year") int year);
}
