package cn.itit123.springdemo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class AnnotationTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("itit123/beans.xml");
        AnnoController annoController = (AnnoController) ctx.getBean("annoController");
        annoController.execut();
        ctx.close();
    }
}
