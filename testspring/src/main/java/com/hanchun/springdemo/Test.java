package com.hanchun.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class Test {

    public static void main(String[] args) {
        //�����Ķ���
        ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");

        //ͨ��ApplicationContext�õ���Ӧ��bean

//        SayHello helloBean = (SayHello) context.getBean("chineseHello");
          SayHello helloBean = (SayHello)context.getBean("americanHello");
//        ���ڽӿڵı�̣�û��ͨ��new��SayHello����ʵ���࣬����ͨ������Spring����ȥ�Զ�����Ҫ��ʱ��ע�롣
        System.out.println(helloBean.sayHello());

        Person person =(Person)context.getBean("person");
//        SayHello person =(SayHello)context.getBean("person");
        System.out.println(person.sayHello());
    }

}
