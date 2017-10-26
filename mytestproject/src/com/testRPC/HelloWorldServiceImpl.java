package com.testRPC;

/**
 * Created by dell on 2017/8/18.
 */
public class HelloWorldServiceImpl implements HelloWorldService{
    @Override
    public String sayHello(String msg) {
        String result = "hello world " + msg;
        System.out.println(result);
        return result;
    }
}
