package com.ps.FoodDelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping()
    public String hello(){
        return "Hello from controller";
    }

    @GetMapping("/2")
    public String hello2(){
        return "Hello from controller2";
    }

}
