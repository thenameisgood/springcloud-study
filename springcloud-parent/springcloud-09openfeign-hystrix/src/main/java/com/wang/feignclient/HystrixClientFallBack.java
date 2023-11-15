package com.wang.feignclient;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/23 10:27
 */

//自定义HystrixClient调用失败处理  是调用失败 并不是那边熔断了
@Component
public class HystrixClientFallBack implements HystrixClient {
    @Override
    public String demo(Integer id) {
        return "调用的hystrix demo错误，那边宕机了，稍后调用。是失败了，而不是那边出现熔断了，熔断会返回那边的熔断信息";
    }
}
