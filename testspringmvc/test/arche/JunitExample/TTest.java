package arche.JunitExample;

import org.hibernate.annotations.AccessType;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**测试注解的运行顺序和被调用过程
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class TTest {

    @BeforeClass//的所有方法运行之前运行。
    public static void beforeClass(){
        System.out.println("------beforeClass");
    }

    @AfterClass //在所有方法运行之后运行
    public static void afterClass(){
        System.out.println("------afterClass");
    }

    @Before//每个测试方法运行之前运行
    public void before(){
        System.out.println("--------before");
    }

    @After//每个测试方法运行之后运行
    public void after(){
        System.out.println("--------after");
    }

    @Test
    public void testAdd() {
        int z=new Calculator().add(5,3);
        assertEquals(8,z);
        System.out.println("in Test Add");
    }

    @Test ()
    public void testDivision(){
        System.out.println("in Test Division");

    }

    @Ignore   //表示这个方法是不被运行的
    @Test(expected=java.lang.ArithmeticException.class,timeout=100) //timeout表示要求方法在100毫秒内运行完成，否则报错
    public void testDivide(){
        int z =new Calculator().divide(8,2);
    }
}
