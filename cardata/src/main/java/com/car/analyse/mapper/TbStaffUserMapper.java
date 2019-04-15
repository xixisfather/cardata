package com.car.analyse.mapper;

import java.util.List;

import com.car.analyse.model.TbStaffUser;

public interface TbStaffUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbStaffUser record);

    int insertSelective(TbStaffUser record);

    TbStaffUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbStaffUser record);

    int updateByPrimaryKey(TbStaffUser record);
    
    List<TbStaffUser> selectAllStaffUsers();
}