package arche.JunitExample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ZhangGuozhao on 2017/9/29.
 * 使用测试套件：在套件的{}里定义添加需要测试的类
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class,
        UserTest.class,
        AnimalTest.class
})
public class AllTest {

}
