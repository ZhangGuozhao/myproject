package com.hanchun.springdemo;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class Person {
    //SayHello�����ã�����ָ���ĸ�����spring�����ļ�����
    SayHello sayHello;

    public SayHello getSayHello() {
        return sayHello;
    }

    public void setSayHello(SayHello sayHello) {
        this.sayHello = sayHello;
    }

    public String sayHello(){
        //���������ļ���ָ���Ķ����sayHello()����
        return this.sayHello.sayHello();
    }
}
