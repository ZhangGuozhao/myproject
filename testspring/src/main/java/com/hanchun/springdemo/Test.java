package com.hanchun.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class Test {

    public static void main(String[] args) {
        //上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");

        //通过ApplicationContext拿到相应的bean

//        SayHello helloBean = (SayHello) context.getBean("chineseHello");
          SayHello helloBean = (SayHello)context.getBean("americanHello");
//        基于接口的编程，没有通过new出SayHello具体实现类，而是通过交给Spring容器去自动在需要的时候注入。
        System.out.println(helloBean.sayHello());

        Person person =(Person)context.getBean("person");
//        SayHello person =(SayHello)context.getBean("person");
        System.out.println(person.sayHello());
    }

}
