package arche.JunitExample;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class CalculatorTest {
    private Calculator calculator;

//    @Test方法之前，为测试类创建一个新的实例。这有助于提供测试方法之间的独立性，并且避免在测试代码中产生意外的副作用。
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(calculator.add(3, 5), 8);
//        int a = 8/0;
    }


    @Test
    public void testSub() throws Exception {
        assertEquals(calculator.sub(9, 6), 3);
    }


}