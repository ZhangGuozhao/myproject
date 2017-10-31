package cn.itit123.springdemo4;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo4/applicationContext.xml");
        Calculator calculator = (Calculator) ctx.getBean("calculator");

        calculator.add(11, 12);
        calculator.division(21, 3); // 测试时，将被除数换成0，可以测试@AfterReturning ， @After 和 @AfterThrowing

        ctx.close();
    }

}