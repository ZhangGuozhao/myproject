package arche.JunitExample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class AnimalTest {
    private Animal animal;

    @Before
    public void setUp() throws Exception {
        animal = new Animal();
    }

    @Test
    public void testAnimalName() throws Exception {
        assertEquals("dog", animal.getName());
//        assertEquals("dog7", animal.getName());
    }
}