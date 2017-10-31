package cn.itit123.springdemo4;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("demo4/applicationContext.xml");
        Calculator calculator = (Calculator) ctx.getBean("calculator");

        calculator.add(11, 12);
        calculator.division(21, 3); // ����ʱ��������������0�����Բ���@AfterReturning �� @After �� @AfterThrowing

        ctx.close();
    }

}