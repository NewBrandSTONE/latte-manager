package com.ztc.latte.service;

import com.ztc.latte.api.SysResourceInfoService;
import com.ztc.latte.model.SysResourceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatteServiceApplicationTests {

    @Autowired
    private SysResourceInfoService sysResourceInfoService;

    @Test
    public void contextLoads() {
        List<SysResourceInfo> byUserUuid = sysResourceInfoService.findByUserUuid("1");
        System.out.println(byUserUuid);
    }

}
