package com.wang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/21 20:57
 * 微服务之间的通讯问题：HTTP Rest方式
 *                  RPC方式  远程过程调用
 *
 * OSI：物理层、数据链路层、网络层、传输层(RPC)、会话层、表示层、应用层(HTTP)
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/getUsersWithOrders")
    public List getUsers(){
        ArrayList<String> list = new ArrayList<>();
        list.add("用户01");
        list.add("用户02");
        list.add("用户03");

        //用 RestTemplate 进行微服务之间的通讯
        //调用订单服务  获取订单列表  127.0.0.1:9999/orders/getOrders
        RestTemplate restTemplate = new RestTemplate();
        String templateForObject = restTemplate.getForObject("http://127.0.0.1:9999/orders/getOrders", String.class);
//        String templateForObject = restTemplate.getForObject("http://"+randomHost()+"/orders/getOrders", String.class);

        list.add(templateForObject);

        return list;
    }

    //RestTemplate存在的问题：
    //      1.调用服务的路径主机和服务端口直接写死在url中，无法实现服务集群时请求负载均衡
    //      2.调用服务的请求路径写死在代码中，日后提供服务的路径发生变化时，不利于维护
    //解决方案：
    //      1.自定义负载均衡解决策略    问题：无法实现服务健康检查 策略单一
    //      2.使用springcloud提供的组件 Ribbon 解决负载均衡调用

    //      Ribbon仅仅完成负载均衡，发请求的还是 RestTemplate

    /**
     * 自定义一个负载均衡(随机选择端口的方式)：为了负载均衡  调用其他接口时随机获取端口
    * */
    public String randomHost(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("localhost:9999");
        list.add("localhost:9990");
        list.add("localhost:9991");

        int i = new Random().nextInt(list.size());

        return list.get(i);
    }
}

