package com.ztc.latte.web.service;

import com.ztc.latte.model.SysUserInfo;

public interface SysUserInfoService {

    SysUserInfo findByUserName(String userName);

}
