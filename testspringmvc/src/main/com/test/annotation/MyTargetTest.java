package test.annotation;

import java.lang.reflect.Method;

/**
 * Created by ZhangGuozhao on 2017/9/19.
 */

public class MyTargetTest {
//    CONCAT(CONCAT('机构会员：',a.USER_NAME),'，注册申请审批')

    @MyTarget
    public void doSomething() {
        System.out.println("Hello! World！");
    }

    public static void main(String[] args) {
        try {
            Method method = MyTargetTest.class.getMethod("doSomething", null);
            if (method.isAnnotationPresent(MyTarget.class))//如果doSomething方法上存在注解@MyTarget(且为Rentention.RUNTIME)，则为true
            {
                System.out.println("===");
                System.out.println(method.getAnnotation(MyTarget.class));
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
