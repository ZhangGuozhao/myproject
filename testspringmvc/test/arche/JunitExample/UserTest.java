package arche.JunitExample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("张乐", (user.getName()));
    }
}