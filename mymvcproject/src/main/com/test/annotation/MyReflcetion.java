package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ZhangGuozhao on 2017/9/20.
 */
public class MyReflcetion {
    public static void main(String[] args) {

        try {
            MyTest myTest = new MyTest();
            Class c1 = MyTest.class;
            Method m1 = c1.getMethod("output", new Class[]{});
//                    是否存在MyAnnotation 的注解
            if (c1.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("====打印类上的注解====");
                System.out.println("Class has a annotation!");
                MyAnnotation myAnnotation = (MyAnnotation) c1.getAnnotation(MyAnnotation.class);

                System.out.println(myAnnotation.hello() + ", " + myAnnotation.world() + "," +
                        myAnnotation.array().length + ", " + myAnnotation.style().getName());
            }
            if (m1.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("====打印方法上的注解====");
                System.out.println("Method has a annotation!");
//                调用output方法
                m1.invoke(myTest, null);
//                获取方法上的MyAnnotation注解信息
                MyAnnotation myAnnotation = m1.getAnnotation(MyAnnotation.class);
                String hello = myAnnotation.hello();
                String world = myAnnotation.world();
                System.out.println(hello + ", " + world);
                System.out.println(myAnnotation.array().length);//打印属性array数组的长度
                System.out.println(myAnnotation.lannotation().value()); //打印属性lannotation的值
                System.out.println(myAnnotation.style());
//                获取方法上的所有注解信息
                Annotation[] annotations = m1.getAnnotations();
                System.out.println("====获取所有注解并打印====");
                for (Annotation a : annotations ) {
                    System.out.println(a.annotationType().getName());
                }

            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
