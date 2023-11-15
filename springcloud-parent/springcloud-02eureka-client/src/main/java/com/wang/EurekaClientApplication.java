package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 18:13
 */
@SpringBootApplication
@EnableEurekaClient     //让当前服务作为一个eureka客户端 进行服务注册
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
