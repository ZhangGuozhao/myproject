package test.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ZhangGuozhao on 2017/9/19.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
//    下面程序中，定义一个注解@MyAnnotation，定义了6个属性，他们的名字为：
//    hello,world,array,lamp,lannotation,style.
//     属性hello，类型为String,默认值为gege
//     属性world，类型为String,没有默认值
//     属性array，类型为数组,默认值为2，4，5，6
//     属性lamp，类型为一个枚举,没有默认值
//     属性lannotation，类型为注解,默认值为@TestAnnotation，注解里的属性是注解
//     属性style类型为Class,默认值为String类型的Class类型
    String hello() default "gege";
    String world();
    int[] array() default { 2, 4, 5, 6 };
    EnumTest.TrafficLamp lamp() ;
    TestAnnotation lannotation() default @TestAnnotation(value = "ddd");
    Class style() default String.class;
}
