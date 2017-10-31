package cn.itit123.springdemo4;
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class AroundAspect {
    /**
     * 环绕通知，很强大，但用的不多。 用环绕通知测试Order的优先级看的不明显（这里是笔者的失误）
     * 环绕通知需要用ProceedingJoinPoint 类型的参数
     */
    @Around("execution(* cn.itit123.springdemo4.CalculatorImp.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        try {
            System.out.println("@Around 前置通知 : 方法名 【 " + methodName + " 】and args are " + args);
            result = joinPoint.proceed();
            System.out.println("@Around 返回通知 : 方法名 【 " + methodName + " 】and args are " + args + " , result is " + result);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("@Around 异常通知 : 方法名 【 " + methodName + " 】and  exception is " + e);
        }
        System.out.println("@Around 后置通知 : 方法名 【 " + methodName + " 】and args are " + args);

        return result;
    }
}
