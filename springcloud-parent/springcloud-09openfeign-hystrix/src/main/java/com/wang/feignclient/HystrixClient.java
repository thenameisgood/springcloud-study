package com.wang.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 10:14
 */

//fallback：当调用的服务不可用时，进行的处理；是不可用时，而不是被调用方出现熔断时。
@FeignClient(value = "HYSTRIX", fallback = HystrixClientFallBack.class)
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam Integer id);
}
