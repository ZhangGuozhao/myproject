package com.testRPC;

/**
 * Created by dell on 2017/8/18.
 */
public class Test {
    public static void main(String[] args) {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        helloWorldService.sayHello("test");
    }
}
