package com.wang.controller;

import com.wang.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/invokeProduct")
    public String invokeProduct() {
        //第一种   没有负载均衡
//        String product = new RestTemplate().getForObject("http://127.0.0.1:9999/product/666", String.class);

        //第二种   只能自定义负载均衡
//        List<ServiceInstance> list = discoveryClient.getInstances("PRODUCTS-CLIENT");
//        list.stream().forEach(serviceInstance -> System.out.println("host:"+serviceInstance.getHost()+"   port:"+serviceInstance.getPort()));
//        String product = new RestTemplate().getForObject(list.get(new Random().nextInt(list.size())).getUri() + "/product/888", String.class);

        //第三种  负载均衡
//        ServiceInstance choose = loadBalancerClient.choose("PRODUCTS-CLIENT");
//        String product = new RestTemplate().getForObject(choose.getUri() + "/product/999", String.class);

        //第四种 创建Bean，@LoadBalanced                         写服务id
//        String product = restTemplate.getForObject("http://PRODUCTS-CLIENT/product/111", String.class);

        //使用 OpenFeign
        String product = productClient.product(123456);

        return product;
    }
}
