package com.wang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/{id}")
    public String product(@PathVariable Integer id) {
        System.out.println("id: " + id);
        return "商品服务返回："+id+",提供服务的端口号为："+port;
    }
}
