package com.car.analyse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.dto.BxhcpcgxAnalyseDTO;
import com.car.analyse.mapper.BxgxfxMapper;
import com.car.analyse.tools.ToolKits;

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
		BxhcgxAnalyseDTO xbDto = xbs.get(0);
		BxhcgxAnalyseDTO rbDto = rbs.get(0);
		BxhcgxAnalyseDTO bxhcgxAnalyseDTO = new BxhcgxAnalyseDTO();
		bxhcgxAnalyseDTO.setCbfs(year + "在保");
		Integer cls = xbDto.getCls() + rbDto.getCls();
		Integer zxcls = xbDto.getZxcls() + rbDto.getZxcls();
		Integer hccls = xbDto.getHccls() + rbDto.getHccls();
		Integer bzxcls = xbDto.getBzxcls() + rbDto.getBzxcls();
		Integer whccls = xbDto.getWhccls() + rbDto.getWhccls();
		bxhcgxAnalyseDTO.setCls(cls);
		bxhcgxAnalyseDTO.setZxcls(zxcls);
		bxhcgxAnalyseDTO.setHccls(hccls);
		bxhcgxAnalyseDTO.setBzxcls(bzxcls);
		bxhcgxAnalyseDTO.setWhccls(whccls);
		bxhcgxAnalyseDTO.setZxzb(ToolKits.divid(zxcls*100, cls));
		bxhcgxAnalyseDTO.setHczb(ToolKits.divid(hccls*100, cls));
		bxhcgxAnalyseDTO.setBzxzb(ToolKits.divid(bzxcls*100, cls));
		bxhcgxAnalyseDTO.setWhczb(ToolKits.divid(whccls*100, cls));
		bxhcgxAnalyseDTOs.add(bxhcgxAnalyseDTO);
		return bxhcgxAnalyseDTOs;
	}
	
	public List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseByYear(int year) {
		List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseDTOs = new ArrayList<BxhcpcgxAnalyseDTO>();
		List<BxhcpcgxAnalyseDTO> zxbzbclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbCls(year);
		List<BxhcpcgxAnalyseDTO> zxbzbhcclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbHcCls(year);
		Integer zxbzbcls = zxbzbclss.get(0).getCls();
		Integer zxbzbhccls = zxbzbhcclss.get(0).getHccls();
		Double zxbzbhcpcjz = ToolKits.divid(zxbzbhccls, zxbzbcls);
		
		BxhcpcgxAnalyseDTO bxhcpcgxAnalyseDTO = new BxhcpcgxAnalyseDTO();
		bxhcpcgxAnalyseDTO.setZxkh("在修不在保");
		bxhcpcgxAnalyseDTO.setCls(zxbzbcls);
		bxhcpcgxAnalyseDTO.setHccls(zxbzbhccls);
		bxhcpcgxAnalyseDTO.setHcpcjz(zxbzbhcpcjz);
		
		return bxhcpcgxAnalyseDTOs;
	}
}
