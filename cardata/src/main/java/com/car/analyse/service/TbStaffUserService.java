package com.car.analyse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.mapper.TbStaffUserMapper;
import com.car.analyse.model.TbStaffUser;

@Service
public class TbStaffUserService {
	@Autowired
	private TbStaffUserMapper tbStaffUserMapper;
	
	public List<TbStaffUser> selectAllStaffUsers() {
		return tbStaffUserMapper.selectAllStaffUsers();
	}
	
}
