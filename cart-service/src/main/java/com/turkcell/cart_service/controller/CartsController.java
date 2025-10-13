package com.turkcell.cart_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartsController {

    @GetMapping
    public String get(){
        return "Welcome Cart-Service";
    }
}
