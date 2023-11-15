package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 15:45
 */
@SpringBootApplication
@EnableDiscoveryClient  //可加可不加
@EnableConfigServer     //统一配置中心服务
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}

