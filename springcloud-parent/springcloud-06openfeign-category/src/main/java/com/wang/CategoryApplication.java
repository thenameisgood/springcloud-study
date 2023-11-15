package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 16:31
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients     //开启openfeign客户端调用
public class CategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class, args);
    }
}

