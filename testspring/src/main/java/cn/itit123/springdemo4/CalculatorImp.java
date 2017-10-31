package cn.itit123.springdemo4;

import org.springframework.stereotype.Repository;

/**
 * Created by ZhangGuozhao on 2017/10/31.
 */
@Repository("calculator")
public class CalculatorImp implements Calculator {

    public int add(int a, int b) {
        System.out.println("add 方法执行了 ----> " + (a + b));
        return (a + b);
    }



    public int division(int a, int b) {
        System.out.println("division 方法执行了 ----> " + (a / b));
        return (a / b);
    }
}
