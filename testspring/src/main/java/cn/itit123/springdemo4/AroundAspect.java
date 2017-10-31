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
     * ����֪ͨ����ǿ�󣬵��õĲ��ࡣ �û���֪ͨ����Order�����ȼ����Ĳ����ԣ������Ǳ��ߵ�ʧ��
     * ����֪ͨ��Ҫ��ProceedingJoinPoint ���͵Ĳ���
     */
    @Around("execution(* cn.itit123.springdemo4.CalculatorImp.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        try {
            System.out.println("@Around ǰ��֪ͨ : ������ �� " + methodName + " ��and args are " + args);
            result = joinPoint.proceed();
            System.out.println("@Around ����֪ͨ : ������ �� " + methodName + " ��and args are " + args + " , result is " + result);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("@Around �쳣֪ͨ : ������ �� " + methodName + " ��and  exception is " + e);
        }
        System.out.println("@Around ����֪ͨ : ������ �� " + methodName + " ��and args are " + args);

        return result;
    }
}
