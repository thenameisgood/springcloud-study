package org.example.controller;

import org.example.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/userss")
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("/invoke")
    public String invokeProduct() {
//        String forObject = restTemplate.getForObject("http://PRODUCTS/products/product", String.class);
        String product = productFeignClient.product();
        return "users ok....端口：" + port + "返回的结果是：" + product;
    }
}
