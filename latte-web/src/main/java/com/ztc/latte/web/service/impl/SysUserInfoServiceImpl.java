package com.ztc.latte.web.service.impl;

import com.ztc.latte.enums.SystemMsg;
import com.ztc.latte.exception.BusinessExceptions;
import com.ztc.latte.model.SysUserInfo;
import com.ztc.latte.web.mapper.SysUserInfoMapper;
import com.ztc.latte.web.service.SysUserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
