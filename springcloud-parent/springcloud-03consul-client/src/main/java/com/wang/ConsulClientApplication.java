package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 20:02
 */
@SpringBootApplication      //代表这一个springboot入口应用
@EnableDiscoveryClient      //代表这是一个client； 可以作为consul、nacos、zookper等的客户端；【通用的】服务注册客户端注解
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }
}

