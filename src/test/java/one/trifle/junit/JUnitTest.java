package one.trifle.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitTest {
    @Test
    @Ignore
    public void first() {
        System.out.println("junit 1.1");
        Assert.fail("1.1");
    }

    @Test
    public void second() {
        System.out.println("junit 1.2");
    }
}