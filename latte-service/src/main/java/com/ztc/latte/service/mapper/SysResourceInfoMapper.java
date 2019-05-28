package com.ztc.latte.service.mapper;

import com.ztc.latte.model.SysResourceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysResourceInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysResourceInfo record);

    int insertSelective(SysResourceInfo record);

    SysResourceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResourceInfo record);

    int updateByPrimaryKey(SysResourceInfo record);

    List<SysResourceInfo> findByUserUuid(@Param("userUuid") String userUuid);
}