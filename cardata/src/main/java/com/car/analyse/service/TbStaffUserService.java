package com.car.analyse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.analyse.mapper.TbStaffUserMapper;

@Service
public class TbStaffUserService {
	@Autowired
	private TbStaffUserMapper tbStaffUserMapper;
	
}
