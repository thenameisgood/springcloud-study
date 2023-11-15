package com.wang.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 13:18
 */

//通过java代码的方式配置gateway
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("category_route", r -> r.path("/category/**")
                        .uri("http://127.0.0.1:8885"))
                .route("product_route", r -> r.path("/product/**")
                        .uri("http://127.0.0.1:8890"))
                .build();
    }
}

