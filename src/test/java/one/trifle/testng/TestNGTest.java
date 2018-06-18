package one.trifle.testng;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test
public class TestNGTest {
    @DataProvider(name = "provider1")
    public Object[][] createData1(Method m) {
        return new Object[][]{
                new Object[]{Boolean.TRUE, "testng: 1.1"},
                new Object[]{Boolean.FALSE, "testng: 1.2"}
        };
    }

    @Test(dataProvider = "provider1", groups = "test-method-with-params")
    public void first(boolean p, String data) {
        System.out.println("first: " + data);
        if(!p) {
            skip();
        }
    }

    @Test(dataProvider = "provider1", groups = "test-method-with-params")
    public void second(boolean p, String data) {
        skip();
        System.out.println("second:" + data);
    }

    private static void skip() {
        throw new SkipException("Skipping this exception");
    }
}
