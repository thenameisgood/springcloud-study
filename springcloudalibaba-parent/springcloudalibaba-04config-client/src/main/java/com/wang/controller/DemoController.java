package com.wang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {

    @Value("${my.name}")
    private String name;

    @GetMapping("/demo")
    public String demo(){
        return "demo OK   name: "+name;
    }
}
