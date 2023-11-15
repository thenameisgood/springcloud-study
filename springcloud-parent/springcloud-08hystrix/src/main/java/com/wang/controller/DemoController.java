package com.wang.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 9:26
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    @HystrixCommand(fallbackMethod = "demoFallBack", defaultFallback = "defaultFallBack")       //熔断之后的处理
    public String demo(@RequestParam Integer id){
        if (id<=0){
            // 抛异常，走自定义熔断进行处理
            throw new RuntimeException("小于0出现错误");
        }
        System.out.println("demo");
        return "demo ok";
    }

    //自己备选熔断处理
    public String demoFallBack (Integer id){
        return "自定义：出现熔断";
    }

    public String defaultFallBack(){
        return "默认：熔断处理";
    }

}

