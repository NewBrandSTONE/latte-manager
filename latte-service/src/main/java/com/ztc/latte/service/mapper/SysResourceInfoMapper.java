package com.ztc.latte.service.mapper;

import com.ztc.latte.model.SysResourceInfo;

public interface SysResourceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResourceInfo record);

    int insertSelective(SysResourceInfo record);

    SysResourceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResourceInfo record);

    int updateByPrimaryKey(SysResourceInfo record);
}