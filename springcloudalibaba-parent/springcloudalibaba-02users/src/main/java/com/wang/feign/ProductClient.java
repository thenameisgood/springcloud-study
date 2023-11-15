package com.wang.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PRODUCTS-CLIENT")
public interface ProductClient {

    @GetMapping("/product/{id}")
    String product(@PathVariable Integer id);
}
