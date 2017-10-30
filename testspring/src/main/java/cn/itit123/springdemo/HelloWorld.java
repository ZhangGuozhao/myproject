package cn.itit123.springdemo;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class HelloWorld {
    private String hello;

    public void setHello(String hello) {
        this.hello = hello;
    }
    public void helloWorld(){
        System.out.println("Spring say :"+hello);
    }
}
