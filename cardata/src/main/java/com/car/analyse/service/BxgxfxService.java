package com.car.analyse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.dto.BxhcgxAnalyseDTO;
import com.car.analyse.dto.BxhcpcgxAnalyseDTO;
import com.car.analyse.dto.XbywfxAnalyseDTO;
import com.car.analyse.mapper.BxgxfxMapper;
import com.car.analyse.tools.Constants;
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
	
	public  List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseByYear(int year) {
		List<BxhcpcgxAnalyseDTO> bxhcpcgxAnalyseDTOs = new ArrayList<BxhcpcgxAnalyseDTO>();
		List<BxhcpcgxAnalyseDTO> zxbzbclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbCls(year);
		List<BxhcpcgxAnalyseDTO> zxbzbhcclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbHcCls(year);
		List<BxhcpcgxAnalyseDTO> zxbzbjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbJsCls(year);
		List<BxhcpcgxAnalyseDTO> zxbzbjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbJsCz(year);
		List<BxhcpcgxAnalyseDTO> zczs = bxgxfxMapper.bxhcpcgxAnalyseZcz(year);
		Integer zxbzbcls = zxbzbclss.get(0).getCls();
		Integer zxbzbhccls = zxbzbhcclss.get(0).getHccls();
		Double zxbzbhcpcjz = ToolKits.divid(zxbzbhccls, zxbzbcls);
		Integer zxbzbjscls = zxbzbjsclss.get(0).getJscls();
		Double zxbzbjsclszb = ToolKits.divid(zxbzbjscls*100, zxbzbcls);
		Double zxbzbjscsjz = ToolKits.divid(zxbzbjscls*100, zxbzbhccls);
		Double zxbzbjscz = zxbzbjsczs.get(0).getJscz();
		Double zcz = zczs.get(0).getJscz();
		Double zxbzbjsczzb = ToolKits.divid(zxbzbjscz*100, zcz);
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
		Integer zxbzbgpcls = zxbzbgpclss.get(0).getCls();
		Integer zxbzbgphccls = zxbzbgphcclss.get(0).getHccls();
		Double zxbzbgphcpcjz = ToolKits.divid(zxbzbgphccls, zxbzbgpcls);
		Integer zxbzbgpjscls = zxbzbgpjsclss.get(0).getJscls();
		Double zxbzbgpjsclszb = ToolKits.divid(zxbzbgpjscls*100, zxbzbgpcls);
		Double zxbzbgpjscsjz = ToolKits.divid(zxbzbgpjscls*100, zxbzbgphccls);
		Double zxbzbgpjscz = zxbzbgpjsczs.get(0).getJscz();
		Double zxbzbgpjsczzb = ToolKits.divid(zxbzbgpjscz*100, zxbzbjscz);
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
		
		List<BxhcpcgxAnalyseDTO> zxbzbdpclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbDpCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbdphcclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbDpHcCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbdpjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxbzbDpJsCls(year,zxbzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxbzbdpjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxbzbDpJsCz(year,zxbzbhcpcjz);
		Integer zxbzbdpcls = zxbzbdpclss.get(0).getCls();
		Integer zxbzbdphccls = zxbzbdphcclss.get(0).getHccls();
		Double zxbzbdphcpcjz = ToolKits.divid(zxbzbdphccls, zxbzbdpcls);
		Integer zxbzbdpjscls = zxbzbdpjsclss.get(0).getJscls();
		Double zxbzbdpjsclszb = ToolKits.divid(zxbzbdpjscls*100, zxbzbdpcls);
		Double zxbzbdpjscsjz = ToolKits.divid(zxbzbdpjscls*100, zxbzbdphccls);
		Double zxbzbdpjscz = zxbzbdpjsczs.get(0).getJscz();
		Double zxbzbdpjsczzb = ToolKits.divid(zxbzbdpjscz*100, zxbzbjscz);
		BxhcpcgxAnalyseDTO zxbzbDpDTO = new BxhcpcgxAnalyseDTO();
		zxbzbDpDTO.setZxkh("低频");
		zxbzbDpDTO.setCls(zxbzbdpcls);
		zxbzbDpDTO.setHccls(zxbzbdphccls);
		zxbzbDpDTO.setHcpcjz(zxbzbdphcpcjz);
		zxbzbDpDTO.setJscls(zxbzbdpjscls);
		zxbzbDpDTO.setJsclszb(zxbzbdpjsclszb);
		zxbzbDpDTO.setJscsjz(zxbzbdpjscsjz);
		zxbzbDpDTO.setJscz(zxbzbdpjscz);
		zxbzbDpDTO.setJsczzb(zxbzbdpjsczzb);
		
		List<BxhcpcgxAnalyseDTO> zxzbclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbCls(year);
		List<BxhcpcgxAnalyseDTO> zxzbhcclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbHcCls(year);
		List<BxhcpcgxAnalyseDTO> zxzbjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbJsCls(year);
		List<BxhcpcgxAnalyseDTO> zxzbjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxzbJsCz(year);
		Integer zxzbcls = zxzbclss.get(0).getCls();
		Integer zxzbhccls = zxzbhcclss.get(0).getHccls();
		Double zxzbhcpcjz = ToolKits.divid(zxzbhccls, zxbzbcls);
		Integer zxzbjscls = zxzbjsclss.get(0).getJscls();
		Double zxzbjsclszb = ToolKits.divid(zxzbjscls*100, zxzbcls);
		Double zxzbjscsjz = ToolKits.divid(zxzbjscls*100, zxzbhccls);
		Double zxzbjscz = zxzbjsczs.get(0).getJscz();
		Double zxzbjsczzb = ToolKits.divid(zxzbjscz*100, zcz);
		BxhcpcgxAnalyseDTO zxzbDTO = new BxhcpcgxAnalyseDTO();
		zxzbDTO.setZxkh("在修在保");
		zxzbDTO.setCls(zxzbcls);
		zxzbDTO.setHccls(zxzbhccls);
		zxzbDTO.setHcpcjz(zxzbhcpcjz);
		zxzbDTO.setJscls(zxzbjscls);
		zxzbDTO.setJsclszb(zxzbjsclszb);
		zxzbDTO.setJscsjz(zxzbjscsjz);
		zxzbDTO.setJscz(zxzbjscz);
		zxzbDTO.setJsczzb(zxzbjsczzb);
		
		List<BxhcpcgxAnalyseDTO> zxzbgpclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbGpCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbgphcclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbGpHcCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbgpjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbGpJsCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbgpjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxzbGpJsCz(year,zxzbhcpcjz);
		Integer zxzbgpcls = zxzbgpclss.get(0).getCls();
		Integer zxzbgphccls = zxzbgphcclss.get(0).getHccls();
		Double zxzbgphcpcjz = ToolKits.divid(zxzbgphccls, zxzbgpcls);
		Integer zxzbgpjscls = zxzbgpjsclss.get(0).getJscls();
		Double zxzbgpjsclszb = ToolKits.divid(zxzbgpjscls*100, zxzbgpcls);
		Double zxzbgpjscsjz = ToolKits.divid(zxzbgpjscls*100, zxzbgphccls);
		Double zxzbgpjscz = zxzbgpjsczs.get(0).getJscz();
		Double zxzbgpjsczzb = ToolKits.divid(zxzbgpjscz*100, zxzbjscz);
		BxhcpcgxAnalyseDTO zxzbGpDTO = new BxhcpcgxAnalyseDTO();
		zxzbGpDTO.setZxkh("高频");
		zxzbGpDTO.setCls(zxzbgpcls);
		zxzbGpDTO.setHccls(zxzbgphccls);
		zxzbGpDTO.setHcpcjz(zxzbgphcpcjz);
		zxzbGpDTO.setJscls(zxzbgpjscls);
		zxzbGpDTO.setJsclszb(zxzbgpjsclszb);
		zxzbGpDTO.setJscsjz(zxzbgpjscsjz);
		zxzbGpDTO.setJscz(zxzbgpjscz);
		zxzbGpDTO.setJsczzb(zxzbgpjsczzb);
		
		List<BxhcpcgxAnalyseDTO> zxzbdpclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbDpCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbdphcclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbDpHcCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbdpjsclss = bxgxfxMapper.bxhcpcgxAnalyseZxzbDpJsCls(year,zxzbhcpcjz);
		List<BxhcpcgxAnalyseDTO> zxzbdpjsczs = bxgxfxMapper.bxhcpcgxAnalyseZxzbDpJsCz(year,zxzbhcpcjz);
		Integer zxzbdpcls = zxzbdpclss.get(0).getCls();
		Integer zxzbdphccls = zxzbdphcclss.get(0).getHccls();
		Double zxzbdphcpcjz = ToolKits.divid(zxzbdphccls, zxzbdpcls);
		Integer zxzbdpjscls = zxzbdpjsclss.get(0).getJscls();
		Double zxzbdpjsclszb = ToolKits.divid(zxzbdpjscls*100, zxzbdpcls);
		Double zxzbdpjscsjz = ToolKits.divid(zxzbdpjscls*100, zxzbdphccls);
		Double zxzbdpjscz = zxzbdpjsczs.get(0).getJscz();
		Double zxzbdpjsczzb = ToolKits.divid(zxzbdpjscz*100, zxzbjscz);
		BxhcpcgxAnalyseDTO zxzbDpDTO = new BxhcpcgxAnalyseDTO();
		zxzbDpDTO.setZxkh("低频");
		zxzbDpDTO.setCls(zxzbdpcls);
		zxzbDpDTO.setHccls(zxzbdphccls);
		zxzbDpDTO.setHcpcjz(zxzbdphcpcjz);
		zxzbDpDTO.setJscls(zxzbdpjscls);
		zxzbDpDTO.setJsclszb(zxzbdpjsclszb);
		zxzbDpDTO.setJscsjz(zxzbdpjscsjz);
		zxzbDpDTO.setJscz(zxzbdpjscz);
		zxzbDpDTO.setJsczzb(zxzbdpjsczzb);

		
		bxhcpcgxAnalyseDTOs.add(zxbzbDTO);
		bxhcpcgxAnalyseDTOs.add(zxbzbGpDTO);
		bxhcpcgxAnalyseDTOs.add(zxbzbDpDTO);
		bxhcpcgxAnalyseDTOs.add(zxzbDTO);
		bxhcpcgxAnalyseDTOs.add(zxzbGpDTO);
		bxhcpcgxAnalyseDTOs.add(zxzbDpDTO);
		return bxhcpcgxAnalyseDTOs;
	}
	
	public Map<String,List<XbywfxAnalyseDTO>> xbywfxxblxAnalyseByMonthRegin(int year,int monthFrom,int monthTo){
		String dateFrom = year + Constants.buildMonthMap().get(monthFrom).split(",")[0];
		String dateTo = year + Constants.buildMonthMap().get(monthTo).split(",")[1];
		
		Map<String, List<XbywfxAnalyseDTO>> xbywfxxblxAnalyseMap = new HashMap<String, List<XbywfxAnalyseDTO>>();
		List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXblxDTOs = new ArrayList<XbywfxAnalyseDTO>();
		List<XbywfxAnalyseDTO> xbywfxxblxAnalyseXbkhDTOs = new ArrayList<XbywfxAnalyseDTO>();
		
		List<XbywfxAnalyseDTO> snjps = bxgxfxMapper.xbywfxAnalyseSnjp(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> xbzls = bxgxfxMapper.xbywfxAnalyseXbzl(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> zbfs = bxgxfxMapper.xbywfxAnalyseZbf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> xbxbncjs = bxgxfxMapper.xbywfxxblxAnalyseXbxBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> xbxbfs = bxgxfxMapper.xbywfxxblxAnalyseXbxBf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> xzxbncjs = bxgxfxMapper.xbywfxxblxAnalyseXzxBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> xzxbfs = bxgxfxMapper.xbywfxxblxAnalyseXzxBf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> xtxbncjs = bxgxfxMapper.xbywfxxblxAnalyseXtxBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> xtxbfs = bxgxfxMapper.xbywfxxblxAnalyseXtxBf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> zxzbbncjs = bxgxfxMapper.xbywfxxbkhAnalyseZxzbBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> zxzbbfs = bxgxfxMapper.xbywfxxbkhAnalyseZxzbBf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> zxbzbbncjs = bxgxfxMapper.xbywfxxbkhAnalyseZxbzbBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> zxbzbbfs = bxgxfxMapper.xbywfxxbkhAnalyseZxbzbBf(year, dateFrom, dateTo);
		
		List<XbywfxAnalyseDTO> bzxzbbncjs = bxgxfxMapper.xbywfxxbkhAnalyseBzxzbBncj(year, dateFrom, dateTo);
		List<XbywfxAnalyseDTO> bzxzbbfs = bxgxfxMapper.xbywfxxbkhAnalyseBzxzbBf(year, dateFrom, dateTo);
		
		Integer snjp = snjps.get(0).getSnjp();
		Integer xbzl = xbzls.get(0).getXbzl();
		Double zbf = zbfs.get(0).getZbf();
		
		Integer xbxbncj = xbxbncjs.get(0).getBncj();
		Double xbxxzcgl = ToolKits.divid(xbxbncj*100, snjp);
		Double xbxxbzb = ToolKits.divid(xbxbncj*100, xbzl);
		Double xbxbf = xbxbfs.get(0).getBf();
		Double xbxbfzb = ToolKits.divid(xbxbf*100, zbf);
		Double xbxjj = ToolKits.divid(xbxbf, xbxbncj);
		
		
		XbywfxAnalyseDTO xxbDto = new XbywfxAnalyseDTO();
		xxbDto.setXblx("新续保");
		xxbDto.setSnjp(snjp);
		xxbDto.setXbzl(xbzl);
		xxbDto.setZbf(zbf);
		
		xxbDto.setBncj(xbxbncj);
		xxbDto.setXzcgl(xbxxzcgl);
		xxbDto.setXbzb(xbxxbzb);
		xxbDto.setBf(xbxbf);
		xxbDto.setBfzb(xbxbfzb);
		xxbDto.setJj(xbxjj);
		
		
		Integer xzxbncj = xzxbncjs.get(0).getBncj();
		Double xzxxzcgl = ToolKits.divid(xzxbncj*100, snjp);
		Double xzxxbzb = ToolKits.divid(xzxbncj*100, xbzl);
		Double xzxbf = xzxbfs.get(0).getBf();
		Double xzxbfzb = ToolKits.divid(xzxbf*100, zbf);
		Double xzxjj = ToolKits.divid(xzxbf, xzxbncj);
		
		XbywfxAnalyseDTO xzxDto = new XbywfxAnalyseDTO();
		xzxDto.setXblx("续转续");
		xzxDto.setSnjp(snjp);
		xzxDto.setXbzl(xbzl);
		xzxDto.setZbf(zbf);
		
		xzxDto.setBncj(xzxbncj);
		xzxDto.setXzcgl(xzxxzcgl);
		xzxDto.setXbzb(xzxxbzb);
		xzxDto.setBf(xzxbf);
		xzxDto.setBfzb(xzxbfzb);
		xzxDto.setJj(xzxjj);
		
		Integer xtxbncj = xtxbncjs.get(0).getBncj();
		Double xtxxzcgl = ToolKits.divid(xtxbncj*100, snjp);
		Double xtxxbzb = ToolKits.divid(xtxbncj*100, xbzl);
		Double xtxbf = xtxbfs.get(0).getBf();
		Double xtxbfzb = ToolKits.divid(xtxbf*100, zbf);
		Double xtxjj = ToolKits.divid(xtxbf, xtxbncj);
		
		XbywfxAnalyseDTO xtxDto = new XbywfxAnalyseDTO();
		xtxDto.setXblx("新拓续");
		xtxDto.setSnjp(snjp);
		xtxDto.setXbzl(xbzl);
		xtxDto.setZbf(zbf);
		
		xtxDto.setBncj(xtxbncj);
		xtxDto.setXzcgl(xtxxzcgl);
		xtxDto.setXbzb(xtxxbzb);
		xtxDto.setBf(xtxbf);
		xtxDto.setBfzb(xtxbfzb);
		xtxDto.setJj(xtxjj);
		
		
		Integer zxzbbncj = zxzbbncjs.get(0).getBncj();
		Double zxzbxzcgl = ToolKits.divid(zxzbbncj*100, snjp);
		Double zxzbxbzb = ToolKits.divid(zxzbbncj*100, xbzl);
		Double zxzbbf = zxzbbfs.get(0).getBf();
		Double zxzbbfzb = ToolKits.divid(zxzbbf*100, zbf);
		Double zxzbjj = ToolKits.divid(zxzbbf, zxzbbncj);
		
		XbywfxAnalyseDTO zxzbDto = new XbywfxAnalyseDTO();
		zxzbDto.setXblx("在修在保客户");
		zxzbDto.setSnjp(snjp);
		zxzbDto.setXbzl(xbzl);
		zxzbDto.setZbf(zbf);
		
		zxzbDto.setBncj(zxzbbncj);
		zxzbDto.setXzcgl(zxzbxzcgl);
		zxzbDto.setXbzb(zxzbxbzb);
		zxzbDto.setBf(zxzbbf);
		zxzbDto.setBfzb(zxzbbfzb);
		zxzbDto.setJj(zxzbjj);
		
		
		Integer zxbzbbncj = zxbzbbncjs.get(0).getBncj();
		Double zxbzbxzcgl = ToolKits.divid(zxbzbbncj*100, snjp);
		Double zxbzbxbzb = ToolKits.divid(zxbzbbncj*100, xbzl);
		Double zxbzbbf = zxbzbbfs.get(0).getBf();
		Double zxbzbbfzb = ToolKits.divid(zxbzbbf*100, zbf);
		Double zxbzbjj = ToolKits.divid(zxbzbbf, zxbzbbncj);
		
		XbywfxAnalyseDTO zxbzbDto = new XbywfxAnalyseDTO();
		zxbzbDto.setXblx("在修不在保客户");
		zxbzbDto.setSnjp(snjp);
		zxbzbDto.setXbzl(xbzl);
		zxbzbDto.setZbf(zbf);
		
		zxbzbDto.setBncj(zxbzbbncj);
		zxbzbDto.setXzcgl(zxbzbxzcgl);
		zxbzbDto.setXbzb(zxbzbxbzb);
		zxbzbDto.setBf(zxbzbbf);
		zxbzbDto.setBfzb(zxbzbbfzb);
		zxbzbDto.setJj(zxbzbjj);
		
		Integer bzxzbbncj = bzxzbbncjs.get(0).getBncj();
		Double bzxzbxzcgl = ToolKits.divid(bzxzbbncj*100, snjp);
		Double bzxzbxbzb = ToolKits.divid(bzxzbbncj*100, xbzl);
		Double bzxzbbf = bzxzbbfs.get(0).getBf();
		Double bzxzbbfzb = ToolKits.divid(bzxzbbf*100, zbf);
		Double bzxzbjj = ToolKits.divid(bzxzbbf, bzxzbbncj);
		
		XbywfxAnalyseDTO bzxzbDto = new XbywfxAnalyseDTO();
		bzxzbDto.setXblx("不在修在保客户");
		bzxzbDto.setSnjp(snjp);
		bzxzbDto.setXbzl(xbzl);
		bzxzbDto.setZbf(zbf);
		
		bzxzbDto.setBncj(bzxzbbncj);
		bzxzbDto.setXzcgl(bzxzbxzcgl);
		bzxzbDto.setXbzb(bzxzbxbzb);
		bzxzbDto.setBf(bzxzbbf);
		bzxzbDto.setBfzb(bzxzbbfzb);
		bzxzbDto.setJj(bzxzbjj);
		
		xbywfxxblxAnalyseXblxDTOs.add(xxbDto);
		xbywfxxblxAnalyseXblxDTOs.add(xzxDto);
		xbywfxxblxAnalyseXblxDTOs.add(xtxDto);
		
		xbywfxxblxAnalyseXbkhDTOs.add(zxzbDto);
		xbywfxxblxAnalyseXbkhDTOs.add(zxbzbDto);
		xbywfxxblxAnalyseXbkhDTOs.add(bzxzbDto);
		
		xbywfxxblxAnalyseMap.put("xblx", xbywfxxblxAnalyseXblxDTOs);
		xbywfxxblxAnalyseMap.put("xbkh", xbywfxxblxAnalyseXbkhDTOs);
		return xbywfxxblxAnalyseMap;
	}
}
