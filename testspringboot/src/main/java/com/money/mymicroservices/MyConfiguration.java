package com.money.mymicroservices;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZhangGuozhao on 2017/10/9.
 */
@Configuration
@EnableAutoConfiguration(exclude ={DataSourceAutoConfiguration.class})
public class MyConfiguration {
}
