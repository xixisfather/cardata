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
		List<BxhcpcgxAnalyseDTO> zxbzbjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbJsCls(year);
		List<BxhcpcgxAnalyseDTO> zxbzbjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbJsCz(year);
		List<BxhcpcgxAnalyseDTO> zxbzbjszczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbJsZcz(year);
		Integer zxbzbcls = zxbzbclss.get(0).getCls();
		Integer zxbzbhccls = zxbzbhcclss.get(0).getHccls();
		Double zxbzbhcpcjz = ToolKits.divid(zxbzbhccls, zxbzbcls);
		Integer zxbzbjscls = zxbzbjsclss.get(0).getJscls();
		Double zxbzbjsclszb = ToolKits.divid(zxbzbjscls*100, zxbzbcls);
		Double zxbzbjscsjz = ToolKits.divid(zxbzbjscls*100, zxbzbhccls);
		Double zxbzbjscz = zxbzbjsczs.get(0).getJscz();
		Double zxbzbjszcz = zxbzbjszczs.get(0).getJscz();
		Double zxbzbjsczzb = ToolKits.divid(zxbzbjscz*100, zxbzbjszcz);
		
		BxhcpcgxAnalyseDTO zxbzbDTO = new BxhcpcgxAnalyseDTO();
		zxbzbDTO.setZxkh("在修不在保");
		zxbzbDTO.setCls(zxbzbcls);
		zxbzbDTO.setHccls(zxbzbhccls);
		zxbzbDTO.setHcpcjz(zxbzbhcpcjz);
		zxbzbDTO.setJscls(zxbzbjscls);
		zxbzbDTO.setJsclszb(zxbzbjsclszb);
		zxbzbDTO.setJscsjz(zxbzbjscsjz);
		zxbzbDTO.setJscz(zxbzbjscz);
		zxbzbDTO.setJsczzb(zxbzbjsczzb);
		
		List<BxhcpcgxAnalyseDTO> zxbzbgpclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbGpCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbgphcclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbGpHcCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbgpjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbGpJsCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbgpjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbGpJsCz(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbgpjszczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbGpJsZcz(year,zxbzbhcpcjz);
		Integer zxbzbgpcls = zxbzbgpclss.get(0).getCls();
		Integer zxbzbgphccls = zxbzbgphcclss.get(0).getHccls();
		Double zxbzbgphcpcjz = ToolKits.divid(zxbzbgphccls, zxbzbgpcls);
		Integer zxbzbgpjscls = zxbzbgpjsclss.get(0).getJscls();
		Double zxbzbgpjsclszb = ToolKits.divid(zxbzbgpjscls*100, zxbzbgpcls);
		Double zxbzbgpjscsjz = ToolKits.divid(zxbzbgpjscls*100, zxbzbgphccls);
		Double zxbzbgpjscz = zxbzbgpjsczs.get(0).getJscz();
		Double zxbzbgpjszcz = zxbzbgpjszczs.get(0).getJscz();
		Double zxbzbgpjsczzb = ToolKits.divid(zxbzbgpjscz*100, zxbzbgpjszcz);
		
		BxhcpcgxAnalyseDTO zxbzbGpDTO = new BxhcpcgxAnalyseDTO();
		zxbzbGpDTO.setZxkh("高频");
		zxbzbGpDTO.setCls(zxbzbgpcls);
		zxbzbGpDTO.setHccls(zxbzbgphccls);
		zxbzbGpDTO.setHcpcjz(zxbzbgphcpcjz);
		zxbzbGpDTO.setJscls(zxbzbgpjscls);
		zxbzbGpDTO.setJsclszb(zxbzbgpjsclszb);
		zxbzbGpDTO.setJscsjz(zxbzbgpjscsjz);
		zxbzbGpDTO.setJscz(zxbzbgpjscz);
		zxbzbGpDTO.setJsczzb(zxbzbgpjsczzb);
		
		
		bxhcpcgxAnalyseDTOs.add(zxbzbDTO);
		bxhcpcgxAnalyseDTOs.add(zxbzbGpDTO);
		return bxhcpcgxAnalyseDTOs;
	}
}
