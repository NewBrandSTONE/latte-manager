package com.ztc.latte.web;

import com.ztc.latte.model.SysUserInfo;
import com.ztc.latte.web.service.SysUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatteWebApplicationTests {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testService() {
        SysUserInfo admin = sysUserInfoService.findByUserName("admin");
        System.out.println(admin);
    }

}
