package com.ztc.latte.web.controller;

import com.ztc.latte.base.BaseRequest;
import com.ztc.latte.base.BaseResponse;
import com.ztc.latte.dto.UserLoginDTO;
import com.ztc.latte.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping("/toLogin")
    public String toLogin() {
        log.info("/toLogin-用户没有登录，跳转到登录有二面");
        return "/login";
    }

    /**
     * 登录逻辑处理
     *
     * @return 登录结果
     */
    @ResponseBody
    @PostMapping("/doLogin")
    public BaseResponse doLogin(@RequestBody BaseRequest<UserLoginDTO> request) {
        BaseResponse response = ResponseUtil.createDefaultResponse(request.getReqId());
        try {
            // 1.获取 Subject
            Subject subject = SecurityUtils.getSubject();
            UserLoginDTO requestData = request.getData();
            // 2.封装用户数据
            UsernamePasswordToken userToken = new UsernamePasswordToken(requestData.getUsername()
                    , requestData.getPassword());
            // 3.执行登录方法
            subject.login(userToken);
        } catch (Exception e) {
            log.error("/doLogin-error", e);
            ResponseUtil.handleException(response, e);
        }
        return response;
    }

}
