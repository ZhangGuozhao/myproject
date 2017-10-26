package arche.JunitExample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

/**
 * Assert  Example
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class CheckObjectTest {
    private CheckObject checkObject;

    @Before//每个测试的  方法前运行一次
    public void setUp() throws Exception {
        checkObject = new CheckObject();
    }

    @Test
    public void testGetBoolean() throws Exception {
        assertTrue(checkObject.getBoolean());
    }

    @Test
    public void testGetObject() throws Exception {
        assertNull(checkObject.getObject());
    }


    @Test
    public void testGetInstance() throws Exception {
//        两个new出来的不指向同一个地址  getInstance的直向同一地址
//        两个字符串指向同一地址
//        CheckObject checkObject2 = new CheckObject();
//        CheckObject checkObject1 = new CheckObject();
//        CheckObject checkObject1 = CheckObject.getInstance();
//        CheckObject checkObject2 = CheckObject.getInstance();
        String checkObject1 = "ABCDEFG";
        String checkObject2 = "ABCDEFG";
        assertSame(checkObject1, checkObject2);
    }


    @Test
    public void testArrayEquals() throws Exception {
        byte[] a = "trail".getBytes();
        byte[] b = "traia".getBytes();
        assertArrayEquals("Byte Array Are Not Equals", a, b);
    }

    @Test//// JUnit Matchers assertThat
    public void testAssertThathasItemsContainsString() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
    }


    @Test
    public void testAssertThatBothContainsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("n")));
    }


    // Core Hamcrest Matchers with assertThat
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
//        assertThat("good", allOf(equalTo("good"), startsWith("good")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
//        assertThat(7, not(CombinableMatcher<Integer> either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Object())));
    }
//异常测试

    //异常测试第一种写法
    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    //异常测试第二种写法
    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
//            如果测试失败（测试未通过）显示“Expected an IndexOutOfBoundsException to be thrown”字符串
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
//            通过判断Exception里是否有预想字段，得出测试结果
            assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }
//异常测试第三种写法

    //    产生一个
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();
//初始化ExceptedException的预期异常的判断方式
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");

        Assert.assertEquals(2222, list.get(0));
    }

//    限时测试：如果指定时间内可以运行完，测试通过（程序正常）；

    //    限时测试写法1
    @Test(timeout = 20000)
    public void testWithTimeout() throws InterruptedException {
        while (true) {
            System.out.println("123456");
            Thread.sleep(1000);
            System.out.println("=====");
        }
    }

    //限时测试写法二
    public static String log = "";

    @Rule
    public Timeout globalTimeout = new Timeout(10000); // 10 seconds max per method tested

    @Test
    public void testInfiniteLoop1() throws InterruptedException {
        for(int i = 1;;i++) {
            String temp = "";
            for (int j = 1;j<=i ; j++) {
                temp = temp + j + " ";
            }
            System.out.println(temp);
            Thread.sleep(250);
        }

    }


}