package com.wang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 16:18
 */
//用来在不需要重启微服务情况下，将当前scope域中信息刷新为最新配置信息
//必须POST方式 curl -X POST http://localhost:8580/actuator/refresh  bus-refresh  用postman也可以
//必须在微服务配置文件中暴露远端配置刷新端点  endpoint management:
//  endpoints:
//    web:
//      exposure:
//        include: "*"
@RestController
@RefreshScope
public class DemoController {

    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String demo(){
        System.out.println(name);
        System.out.println("demo!!!");
        return "demo====name:"+name;
    }
}

