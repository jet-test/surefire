package one.trifle.surefire.junit;

import org.junit.Test;

public class JUnitSecondTest {
    @Test
    public void first() {
        System.out.println("junit 2.1");
//        Assert.fail("123");
    }

    @Test
    public void second() {
        System.out.println("junit 2.2");
    }
}
