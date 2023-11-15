package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/product")
    public String product() {
        return "product ok....端口：" + port;
    }
}
