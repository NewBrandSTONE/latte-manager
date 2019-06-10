package com.ztc.latte.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ztc.latte.web.mapper")
public class LatteWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LatteWebApplication.class, args);
    }

}
