package one.trifle.surefire.testng;

import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Test
public class TestNGTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
    }

    @BeforeGroups(alwaysRun = true)
    public void beforeGroups() throws Exception {
    }

    @AfterGroups(alwaysRun = true)
    public void afterGroups() throws Exception {
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws Exception {
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() throws Exception {
    }

    @DataProvider(name = "provider1")
    public Object[][] createData1(Method m) {
        return new Object[][]{
                new Object[]{Boolean.TRUE, "one.trifle.surefire.testng: 1.1"},
                new Object[]{Boolean.FALSE, "one.trifle.surefire.testng: 1.2"}
        };
    }

    @Test(dataProvider = "provider1", groups = "test-method-with-params")
    public void first(boolean p, String data) {
        System.out.println("first: " + data);
//        assertTrue(p);
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
