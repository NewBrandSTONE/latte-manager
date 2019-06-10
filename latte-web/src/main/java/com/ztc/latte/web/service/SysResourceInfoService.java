package com.ztc.latte.web.service;

import com.ztc.latte.model.SysResourceInfo;

import java.util.List;

public interface SysResourceInfoService {

    List<SysResourceInfo> findByUserUuid(String userUuid);

}
