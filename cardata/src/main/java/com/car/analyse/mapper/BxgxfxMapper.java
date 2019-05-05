package com.car.analyse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.dto.BxhcpcgxAnalyseDTO;
import com.car.analyse.dto.XbywfxAnalyseDTO;

public interface BxgxfxMapper {
	
	List<BxhcgxAnalyseDTO> bxhcgxAnalyseXb(@Param("year") int year);
	
	List<BxhcgxAnalyseDTO> bxhcgxAnalyseRb(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbHcCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbJsCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbJsCz(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpHcCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpJsCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbGpJsCz(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpHcCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpJsCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxbzbDpJsCz(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbHcCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbJsCls(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbJsCz(@Param("year") int year);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbGpCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbGpHcCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbGpJsCls(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbGpJsCz(@Param("year") int year,@Param("gpcs") double gpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbDpCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbDpHcCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbDpJsCls(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZxzbDpJsCz(@Param("year") int year,@Param("dpcs") double dpcs);
	
	List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseZcz(@Param("year") int year);
	
	
	List<XbywfxAnalyseDTO> xbywfxAnalyseSnjp(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxAnalyseXbzl(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxAnalyseZbf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXbxBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXbxBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXzxBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXzxBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXtxBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXtxBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseZxzbBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseZxzbBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);

	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseZxbzbBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseZxbzbBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseBzxzbBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseBzxzbBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);

	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseBzxBzbBncj(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);
	
	List<XbywfxAnalyseDTO> xbywfxxbkhAnalyseBzxBzbBf(@Param("year") int year,@Param("dateFrom") String dateFrom,@Param("dateTo") String dateTo);

}
