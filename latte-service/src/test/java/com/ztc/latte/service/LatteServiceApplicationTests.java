package com.ztc.latte.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatteServiceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void forEachTest() {
        List<String> aa = Arrays.asList("aaa", "bbb", "ccc");
        List<String> bb = new ArrayList<>();
        aa.forEach(x -> bb.add(x));

        bb.forEach(x -> System.out.println(x));
    }

}
