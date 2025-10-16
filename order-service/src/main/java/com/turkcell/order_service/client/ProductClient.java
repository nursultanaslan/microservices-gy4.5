package com.turkcell.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//İstegi atacagımız ServiceClient'ı olusturduk
@FeignClient(name = "product-service", path = "/api/v1/products")
public interface ProductClient {

    @GetMapping
    String get();
}
