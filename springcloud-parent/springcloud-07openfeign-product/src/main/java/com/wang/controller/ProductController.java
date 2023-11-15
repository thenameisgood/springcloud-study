package com.wang.controller;

import com.wang.entity.Product;
import com.wang.vo.CollectionVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/22 16:38
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/product")
    public String product() {
        System.out.println("进入ProductController::product(),提供服务的端口是" + port);
        return "product";
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("进入ProductController::list(),提供服务的端口是" + port);
        return "list";
    }

    //接收零散类型参数接口
    @GetMapping("/queryString")
    public String queryString(String name, Integer age) {
        System.out.println("name:" + name + "------age" + age);
        System.out.println("进入ProductController::queryString(),提供服务的端口是" + port);
        return "接收到的queryString参数，name:" + name + " age:" + age;
    }

    @GetMapping("/pathVariable/{name}/{age}")
    public String pathVariable(@PathVariable String name, @PathVariable Integer age) {
        System.out.println("name:" + name + "------age" + age);
        System.out.println("进入ProductController::pathVariable(),提供服务的端口是" + port);
        return "接收到pathVariable参数，name:" + name + " age:" + age;
    }

    //@RequestBody json形式      不加 @RequestBody ，是表单形式
    @PostMapping("/entity")
    public Product entity(@RequestBody Product product) {
        System.out.println("接收到对象product:" + product);
        System.out.println("进入ProductController::entity(),提供服务的端口是" + port);
        return product;
    }

    @GetMapping("/array")
    public String[] array(String[] names) {
        Arrays.stream(names).forEach(s -> System.out.println(s));
        System.out.println("进入ProductController::array(),提供服务的端口是" + port);
        return names;
    }

    //    @GetMapping("/arrayList")
//    public List<String> arrayList(ArrayList<String> names) {
//        System.out.println(names.toArray());
//        System.out.println("进入ProductController::arrayList(),提供服务的端口是" + port);
//        return names;
//    }
//    springMVC不能直接接收集合类型参数 如果想接收 必须将集合放入对象中，使用对象的方式接收
    @GetMapping("/arrayList")
    public String arrayList(CollectionVo collectionVo) {
        collectionVo.getNames().forEach(s -> System.out.println(s));
        System.out.println("进入ProductController::arrayList(),提供服务的端口是" + port);
        return "CollectionVo#arrayList";
    }


//    ==========================================响应==============================================


    @GetMapping("/productResponse/{name}")
    public Product productResponse(@PathVariable String name) {
        System.out.println("进入ProductController::productResponse(),提供服务的端口是" + port);
        System.out.println(name);
        return new Product("张三", "1", new Date());
    }

    @GetMapping("/productResponseList/{name}")
    public List<Product> productResponseList(@PathVariable String name) {
        System.out.println("进入ProductController::productResponseList(),提供服务的端口是" + port);
        System.out.println(name);
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("张三", "1", new Date()));
        list.add(new Product("小老鼠", "10", new Date()));
        list.add(new Product("打老虎", "100", new Date()));
        return list;
    }

    @GetMapping("/findByCategoryIdAndPage")
    public Map<String, Object> findByCategoryIdAndPage(Integer page, Integer rows, Integer categoryId) {
        System.out.println("进入ProductController::findByCategoryIdAndPage(),提供服务的端口是" + port);
        //分页查询 List<Product>
        //查询总条数
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("zhangsna", "1", new Date()));
        list.add(new Product("小老鼠", "10", new Date()));
        list.add(new Product("打老虎", "100", new Date()));

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows", list);
        hashMap.put("total", 1000);
        return hashMap;
    }


}

