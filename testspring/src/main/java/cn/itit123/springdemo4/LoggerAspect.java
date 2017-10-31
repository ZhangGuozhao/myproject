package cn.itit123.springdemo4;

/**
 * Created by ZhangGuozhao on 2017/10/31.
 */
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order(n) : ��������ȼ���nԽС������Խ��
 * @Aspect������������һ������
 * @Component����������� IOC �е� bean
 */
@Order(2)
@Aspect
@Component
public class LoggerAspect {
    /**
     * ǰ��֪ͨ��ע�⣬��Ŀ�귽��ִ��ǰ����
     * execution������ı��ʽ�﷨��
     * ע��㣺
     * 1. �������治�����βΣ���add(int a, int b) ���ǻᱨ��ġ�
     * 2. int�������ķ���ֵ����add���������� ������ * ���󻯡��������Խ���������ָ���ð��µ��ࡣ
     * 3. (int, int) ������(..)���棬��ʾƥ�����������Ĳ���
     * 4. ��֪ͨ�Ķ���Target����������ϰ���·��
     */
    @Before("execution(int cn.itit123.springdemo4.CalculatorImp.add(int , int))")
    public void beforeAdvice(JoinPoint joinPoint) {
        /**
         * ���ӵ� joinPoint��add�����������ӵ�
         * getName��ȡ���Ƿ���������Ӣ�ĵģ�����ͨ�����ʻ�ת����Ӧ�����ıȽϺá�
         */
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@Before ǰ��֪ͨ : ������ �� " + methodName + " ��and args are " + args);
    }

    /**
     * ����֪ͨ��ע��, ��Ŀ�귽��ִ�к���ã���ʹ�ǳ�����������
     * ���ｫ �����ķ���ֵ �� CalculatorImp�������еķ������Լ��������β� ��������
     */
    @After("execution(* cn.itit123.springdemo4.CalculatorImp.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@After ����֪ͨ : ������ �� " + methodName + " ��and args are " + args);
    }

    /**
     * ��������㶨�壺�����������ʽ���÷������治���������������
     */
    @Pointcut("execution(* cn.itit123.springdemo4.CalculatorImp.*(..))")
    public void declareExecutionExpression(){}

    /**
     * ����֪ͨ��ע��, ��Ŀ�귽���ɹ�ִ�к���ã������������򲻻����
     * returning="result" �� �β� result ����һ��
     */
    @AfterReturning(value="declareExecutionExpression()", returning="result")
    public void afterRunningAdvice(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("@AfterReturning ����֪ͨ : ������ �� " + methodName + " ��and args are " + args + " , result is " + result);
    }

    /**
     * �쳣֪ͨ��ע��, ��Ŀ�귽������ָ���쳣ʱ����
     * throwing="exception" �� �β� exception ����һ�� �� ��Ŀ�귽������Exception�������������쳣���쳣�Ż���á�
     */
    @AfterThrowing(value="declareExecutionExpression()", throwing="exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("@AfterThrowing �쳣֪ͨ : ������ �� " + methodName + " ��and  exception is " + exception);
    }

}
