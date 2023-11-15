package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 10:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenfeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrixApplication.class, args);
    }
}

