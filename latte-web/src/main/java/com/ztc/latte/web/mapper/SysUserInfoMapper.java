package com.ztc.latte.web.mapper;

import com.ztc.latte.model.SysUserInfo;
import org.apache.ibatis.annotations.Param;

public interface SysUserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    SysUserInfo findByUserName(@Param("userName") String userName);
}