package com.ztc.latte.api;

import com.ztc.latte.model.SysResourceInfo;

import java.util.List;

public interface SysResourceInfoService {

    List<SysResourceInfo> findByUserUuid(String userUuid);

}
