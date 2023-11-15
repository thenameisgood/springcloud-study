package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PRODUCTS")
@RequestMapping("/products")
public interface ProductFeignClient {

    @GetMapping("/product")
    String product();
}
