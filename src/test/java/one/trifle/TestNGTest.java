package one.trifle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test
public class TestNGTest {
    @DataProvider(name = "provider1")
    public Object[][] createData1(Method m) {
        return new Object[][]{
                new Object[]{Boolean.TRUE, "testng: 1"},
                new Object[]{Boolean.FALSE, "testng: 2"}
        };
    }

    @Test(dataProvider = "provider1", groups = "test-method-with-params")
    public void test1(boolean p, String data) {
        System.out.println(data);
    }

}
