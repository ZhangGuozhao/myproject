package arche.JunitExample;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**参数运行器！
 * 使用Parameterized 的测试运行器来运行一个测试类
 * 可以对同一个方法进行多次测试
 * Created by ZhangGuozhao on 2017/9/29.
 */
//
// 1. 测试类必须用@RunWith注释，并且将Parameterized.class作为参数
@RunWith(value = Parameterized.class)
public class ParameterizedCalculateTest {

    // 2. 必须声明测试中所使用的所有的实例变量
    private int expected;
    private int value1;
    private int value2;

    //3. 提供一个@parameters注释的方法
    //1）这个方法的签名必须是： Parameters public static java.util.Collection ， 无任何参数。
    //2) Collecting元素必须是相同长度的数组。这个数组的长度必须要和唯一的构造函数的参数个数相同
    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][]{
                        {2, 1, 1},
                        {3, 2, 1},
                        {5, 2, 1}, //错误参数
                }
        );
    }

    //4. 构造函数
    public ParameterizedCalculateTest(int expected, int value1, int value2) {
        this.expected = expected;
        this.value1 = value1;
        this.value2 = value2;
    }
    @Before
    public void before(){
        System.out.println("before");
    }

    //5. 测试(重复调用了5次)
    @Test
    public void add() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(value1, value2), 0);
        System.out.println("==========");
    }

}