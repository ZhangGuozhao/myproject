package cn.itit123.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class HelloWorldTest {
    public static void main(String[] args) {

        //1. ����Spring ��IOC����
        ApplicationContext ctx = new ClassPathXmlApplicationContext("itit123/beans.xml");

        //2. �������л�ȡ Bean ��ʵ����new �Ĺ���
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        // Ҳ�����ǣ��������� HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        //3. ִ�к���
        helloWorld.helloWorld();
    }
}