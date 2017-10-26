package com.money.mymicroservices.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangGuozhao on 2017/10/9.
 */
//@RestController和@RequestMapping注解是Spring MVC注解
@RestController
//@EnableAutoConfiguration。这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
// 由于spring-boot-starter-web添加了Tomcat和Spring MVC，所以auto-configuration将假定正在开发一个web应用并相应地对Spring进行设置。
@EnableAutoConfiguration

public class Example {
    @RequestMapping("/")
    public String home(){
        return "Hello World 2 !";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
}
