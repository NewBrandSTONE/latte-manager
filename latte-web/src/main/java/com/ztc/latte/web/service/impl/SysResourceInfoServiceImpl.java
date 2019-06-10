package com.ztc.latte.web.service.impl;

import com.ztc.latte.web.mapper.SysResourceInfoMapper;
import com.ztc.latte.web.service.SysResourceInfoService;
import com.ztc.latte.enums.SystemMsg;
import com.ztc.latte.exception.BusinessExceptions;
import com.ztc.latte.model.SysResourceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
