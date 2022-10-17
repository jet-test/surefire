package one.trifle.surefire.junit;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTest {
    @Test
    public void first() {
        System.out.println("junit 1.1");
    }

    @Test
    public void second() {
        System.out.println("junit 1.2");
    }

    @Test
    public void property() {
        System.out.println(System.getProperty("java.io.tmpdir"));
        Assert.fail("fail");
    }
    
    @Test
    public void newTest() {
    }
}
