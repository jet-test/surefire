package one.trifle.surefire;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void sum() {
        assertEquals(5, Utils.sum(2, 3));
    }
}