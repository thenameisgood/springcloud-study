package com.wang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 16:07
 */
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/getOrders")
    public List<String> getOrders(){
        ArrayList<String> list = new ArrayList<>();
        list.add("订单01");
        list.add("订单02");
        list.add("订单03");
        log.info("当前提供服务的端口为: {}", port);
        return list;
    }
}


