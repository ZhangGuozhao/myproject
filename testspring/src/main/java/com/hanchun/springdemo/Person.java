package com.hanchun.springdemo;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class Person {
    //SayHello的引用，具体指向哪个，由spring配置文件决定
    SayHello sayHello;

    public SayHello getSayHello() {
        return sayHello;
    }

    public void setSayHello(SayHello sayHello) {
        this.sayHello = sayHello;
    }

    public String sayHello(){
        //调用配置文件里指定的对象的sayHello()方法
        return this.sayHello.sayHello();
    }
}
