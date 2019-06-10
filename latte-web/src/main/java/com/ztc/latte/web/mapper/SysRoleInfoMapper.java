package com.ztc.latte.web.mapper;

import com.ztc.latte.model.SysRoleInfo;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);
}