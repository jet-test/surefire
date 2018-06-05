package one.trifle.testng;

import org.testng.annotations.Test;

@Test
public class TestNGWithoutParamsTest {
    @Test(enabled=false)
    public void first() {
        System.out.println("testng 2.1");
        assert false;
    }

    @Test
    public void second() {
        System.out.println("testng 2.2");
        assert false;
    }
}
