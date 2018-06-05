package one.trifle.testng;

import org.testng.annotations.Test;

@Test
public class TestNGWithoutParamsTest {
    @Test
    public void first() {
        System.out.println("testng 2.1");
    }

    @Test
    public void second() {
        System.out.println("testng 2.2");
    }
}
