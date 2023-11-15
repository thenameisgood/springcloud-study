package com.wang.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.entity.Product;
import com.wang.feignclient.ProductClient;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 16:38
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ProductClient productClient;

    @Value("${server.port}")
    private String port;

    //主要测试传参的控制器
    @GetMapping("/categoryParam")
    public String categoryParam() {
        System.out.println("进入CategoryController，提供服务的端口是" + port);
        String product = productClient.product();
        String list = productClient.list();
        String queryString = productClient.queryString("传递的queryString参数", 20);
        String pathVariable = productClient.pathVariable("传递pathVariable参数", 10);
        Product entity = productClient.entity(new Product("大蒜", "20", new Date()));
        String[] array = productClient.array(new String[]{"zs", "ls", "王王"});
//        return Arrays.toString(array);
        String arrayList = productClient.arrayList(new String[]{"ArrayList小老虎", "ArrayList老虎", "ArrayList虎"});
        return "category" + "调用结果：product:" + product + "-----list:" + list + "-----queryString:" + queryString + "-----pathVariable:" + pathVariable +
                "-----entity" + entity.toString() + "-----array:" + array + "-----arrayList:" + arrayList;
    }

//==========================================响应============================================================

    //主要测试响应  是productClient.productResponse的响应
    @GetMapping("/categoryResponse")
    public Product categoryResponse() {
        System.out.println("进入CategoryController，提供服务的端口是" + port);
        Product product = productClient.productResponse("bilibili");
        return product;
    }

    @GetMapping("/categoryResponseList")
    public List<Product> categoryResponseList() {
        System.out.println("进入CategoryController，提供服务的端口是" + port);
        List<Product> responseList = productClient.productResponseList("哔哩哔哩");
        responseList.forEach(s -> System.out.println(s));
        return responseList;
    }

    @GetMapping("/findByCategoryIdAndPage")
    public String findByCategoryIdAndPage() {
        System.out.println("进入CategoryController，提供服务的端口是" + port);
        String page = productClient.findByCategoryIdAndPage(1, 2, 3);

        //自定义json反序列化  对象转为json序列化 json字符串转换为对象

        JSONObject jsonObject = JSONObject.parseObject(page);

        System.out.println(jsonObject.get("total"));
        Object rows = jsonObject.get("rows");
        System.out.println(rows);

        //二次json反序列化
        List<Product> products = JSONObject.parseArray(rows.toString(), Product.class);
        products.forEach(product -> System.out.println(product));

        return page;
    }
}

