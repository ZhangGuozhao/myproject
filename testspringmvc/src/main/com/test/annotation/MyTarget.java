package test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ZhangGuozhao on 2017/9/19.
 */
//RetentionPolicy是一个枚举类里面有三个值；
//    分别是Source  Class 和Runtime
//    Source  编译后消失  : 如  Override
//    Class   编程到Class文件中,单运行时消失; 默认
//    Runtime  通过编译保留到Class文件中,也会在运行时起作用;可以用来进行反射
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTarget {
}
