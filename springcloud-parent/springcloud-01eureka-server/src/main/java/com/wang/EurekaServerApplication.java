package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 16:48
 *
 * 注册中心：eureka(Netflix) zookeeper consul(go) nacos(阿里巴巴)
 *
 * eureka: 服务端、客户端
 *
 * springcloud：引依赖、写配置、加注解
 */
@SpringBootApplication
@EnableEurekaServer     //开启当前应用是一个服务注册中心  访问：http://localhost:8761/
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

