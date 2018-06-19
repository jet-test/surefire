package one.trifle.surefire.testng;

import org.testng.annotations.Test;

@Test
public class TestNGWithoutParamsTest {
    @Test
    public void first() {
        System.err.println("one.trifle.surefire.testng 2.1");
    }

    @Test
    public void second() {
        System.err.println("one.trifle.surefire.testng 2.2");
    }
}
