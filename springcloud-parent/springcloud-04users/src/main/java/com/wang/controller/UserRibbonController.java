package com.wang.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 10:42
 */
@RestController
@RequestMapping("/usersRibbon")
@Slf4j
public class UserRibbonController {

    @Autowired      //服务注册与发现客户端对象
    private DiscoveryClient discoveryClient;

    @Autowired      //负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getUsersWithOrders")
    public String getUsers() {
        log.info("当前提供服务的端口为: {}", port);
        ArrayList<String> list = new ArrayList<String>();
        list.add("user01");
        list.add("user02");
        list.add("user03");

        //1 调用订单服务  获取订单列表  127.0.0.1:9999/orders/getOrders
//        RestTemplate restTemplate = new RestTemplate();
//        String templateForObject = restTemplate.getForObject("http://127.0.0.1:8889/orders/getOrders", String.class);
//        String templateForObject = restTemplate.getForObject("http://"+randomHost()+"/orders/getOrders", String.class);

        //2 使用ribbon组件+RestTemplate实现负载均衡调用 1.DiscoveryClient 2.LoadBalanceClient 3.@LoadBalance
//        List<ServiceInstance> ordersServiceInstance = discoveryClient.getInstances("ORDERS");
//        ordersServiceInstance.forEach(serviceInstance -> {
//            System.out.println(serviceInstance.getHost() + "===" + serviceInstance.getPort() + "===" + serviceInstance.getUri());
//        });
//        RestTemplate restTemplate = new RestTemplate();
//        String templateForObject = restTemplate.getForObject(ordersServiceInstance.get(new Random().nextInt(ordersServiceInstance.size())).getUri()+"/orders/getOrders", String.class);

        //3 LoadBalanceClient   这个new RestTemplate()每次都创建 最后放到工厂里
//        ServiceInstance choose = loadBalancerClient.choose("ORDERS");
//        RestTemplate restTemplate = new RestTemplate();
//        String templateForObject = restTemplate.getForObject(choose.getUri()+"/orders/getOrders", String.class);


        //4 @LoadBalance  使用它可以让对象具有ribbon的负载均衡特性

/*        @Configuration
        public class BeansConfig {

            @Bean
            @LoadBalanced
            public RestTemplate restTemplate(){
                return new RestTemplate();
            }
        }
        }*/
        String templateForObject = restTemplate.getForObject("http://ORDERS/orders/getOrders", String.class);

        list.add(templateForObject);

        return list.toString();
    }

}

