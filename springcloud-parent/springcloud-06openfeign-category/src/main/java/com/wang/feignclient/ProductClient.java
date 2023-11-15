package com.wang.feignclient;

import com.wang.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 16:55
 * <p>
 * RestTemplate存在的问题：
 * 路径写死
 * 不能自动转换响应结果为对应对象
 * 必须额外集成ribbon实现负载均衡
 * <p>
 * OpenFeign：伪HTTP客户端，集成了Ribbon
 */

//调用product服务的接口
@FeignClient("PRODUCT")     //服务的名字  而不是ip地址
public interface ProductClient {

    //所有方法一定要告诉openfeign底层以什么方式传参

    //调用product服务
    @GetMapping("/product/product")
    String product();

    @GetMapping("/product/list")
    String list();

    @GetMapping("/product/queryString")
//    String queryString(String name, Integer age);     //这样是错误的，必须要告诉feign以什么方式传参，nested exception is java.lang.IllegalStateException: Method has too many Body parameters: public abstract java.lang.String com.wang.feignclient.ProductClient.queryString(java.lang.String,java.lang.Integer)
    String queryString(@RequestParam String name, @RequestParam("age") Integer age);

    @GetMapping("/product/pathVariable/{name}/{age}")
    String pathVariable(@PathVariable String name, @PathVariable("age") Integer age);

    @PostMapping("/product/entity")
    Product entity(@RequestBody Product product);       //@RequestBody json形式

    @GetMapping("/product/array")
    String[] array(@RequestParam String[] names);

    @GetMapping("/product/arrayList")
//    String arrayList(@RequestParam List<String> names);
    String arrayList(@RequestParam String[] names);


//==========================================响应========================================================

    @GetMapping("/product/productResponse/{name}")
    Product productResponse(@PathVariable String name);

    @GetMapping("/product/productResponseList/{name}")
    List<Product> productResponseList(@PathVariable String name);

    @GetMapping("/product/findByCategoryIdAndPage")
//    Map<String,Object> findByCategoryIdAndPage(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Integer categoryId);
    String findByCategoryIdAndPage(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Integer categoryId);
}
