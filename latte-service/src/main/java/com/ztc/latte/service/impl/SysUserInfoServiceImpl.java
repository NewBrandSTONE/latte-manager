package com.ztc.latte.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ztc.latte.api.SysUserInfoService;
import com.ztc.latte.enums.SystemMsg;
import com.ztc.latte.exception.BusinessExceptions;
import com.ztc.latte.model.SysUserInfo;
import com.ztc.latte.service.mapper.SysUserInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SysUserInfo findByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            throw new BusinessExceptions(SystemMsg.SYS_USER_NAME_IS_EMPTY);
        }
        return sysUserInfoMapper.findByUserName(userName);
    }

}
