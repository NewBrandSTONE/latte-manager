package com.ztc.latte.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ztc.latte.api.SysResourceInfoService;
import com.ztc.latte.enums.SystemMsg;
import com.ztc.latte.exception.BusinessExceptions;
import com.ztc.latte.model.SysResourceInfo;
import com.ztc.latte.service.mapper.SysResourceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SysResourceInfoServiceImpl implements SysResourceInfoService {

    @Autowired
    private SysResourceInfoMapper sysResourceInfoMapper;

    @Override
    public List<SysResourceInfo> findByUserUuid(String userUuid) {
        if (StringUtils.isEmpty(userUuid)) {
            throw new BusinessExceptions(SystemMsg.SYS_USER_UUID_IS_EMPTY);
        }
        return sysResourceInfoMapper.findByUserUuid(userUuid);
    }
}
