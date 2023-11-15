package com.wang.controller;

import com.wang.feignclient.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 10:09
 */
@RestController
public class OpenfeignHystrixController {

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("/openfeignHystrix")
    public String OpenfeignHystrix(){

        String demo = hystrixClient.demo(1);

        System.out.println("调用hystrixClient结果:"+demo);

        return "调用demo的结果===>>"+demo;
    }
}

