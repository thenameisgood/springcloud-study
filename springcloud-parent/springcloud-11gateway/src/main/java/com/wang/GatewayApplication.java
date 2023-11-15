package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;

@SpringBootApplication
@EnableDiscoveryClient      //服务客户端注册，该注解可加可不加
public class GatewayApplication {
    public static void main(String[] args) {
//        RoutePredicateFactory routePredicateFactory;
//        GatewayFilter gatewayFilter;
        SpringApplication.run(GatewayApplication.class, args);
    }
}