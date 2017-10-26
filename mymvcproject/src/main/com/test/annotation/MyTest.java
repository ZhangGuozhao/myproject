package test.annotation;

import test.annotation.EnumTest.TrafficLamp;

/**
 * Created by ZhangGuozhao on 2017/9/20.
 */
@MyAnnotation(hello = "beijing", world = "shanghai", array = {}, lamp = TrafficLamp.yellow,style = int.class)
public class MyTest {
    @MyAnnotation(world = "shanghai", array = {1, 2, 3}, lamp = TrafficLamp.red, lannotation = @TestAnnotation(value = "baby"))
    @Deprecated
    @SuppressWarnings("")
    public void output(){
        System.out.println("output somthing");
    }

}
