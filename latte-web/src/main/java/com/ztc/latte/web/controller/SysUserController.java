package com.ztc.latte.web.controller;

import com.ztc.latte.web.service.SysUserInfoService;
import com.ztc.latte.base.BaseRequest;
import com.ztc.latte.base.BaseResponse;
import com.ztc.latte.model.SysUserInfo;
import com.ztc.latte.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @ResponseBody
    @RequestMapping("/getUserInfoByName")
    public BaseResponse getUserInfoByName(@RequestBody BaseRequest<SysUserInfo> req) {
        log.info("/getUserInfoByName-param:{}", req);
        BaseResponse response = ResponseUtil.createDefaultResponse(req.getReqId());

        try {

            SysUserInfo reqData = req.getData();
            SysUserInfo sysUserInfo = sysUserInfoService.findByUserName(reqData.getSysName());
            ResponseUtil.success(response, sysUserInfo);

        } catch (Exception e) {
            log.error("/getUserInfoByName-error", e);
            ResponseUtil.handleException(response, e);
        }

        return response;
    }

}
