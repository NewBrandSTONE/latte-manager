package com.ztc.latte.service.mapper;

import com.ztc.latte.model.SysUserInfo;

public interface SysUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);
}