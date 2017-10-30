package cn.itit123.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class HelloWorldTest {
    public static void main(String[] args) {

        //1. 创建Spring 的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("itit123/beans.xml");

        //2. 从容器中获取 Bean 其实就是new 的过程
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        // 也可以是，但不建议 HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        //3. 执行函数
        helloWorld.helloWorld();
    }
}