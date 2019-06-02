package com.ztc.latte.api;

import com.ztc.latte.model.SysUserInfo;

public interface SysUserInfoService {

    SysUserInfo findByUserName(String userName);

}
