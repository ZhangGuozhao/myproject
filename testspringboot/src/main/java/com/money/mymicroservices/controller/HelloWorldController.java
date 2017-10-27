package com.money.mymicroservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangGuozhao on 2017/10/9.
 */
//需要引入spring-boot-starter-web
//    @RestController和@RequestMapping注解是Spring MVC注解
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World！";
    }
}

