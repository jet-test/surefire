package one.trifle.trigger;

import one.trifle.trigger.utils.TriggerUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriggerTest {
    @Test
    public void test() {
        final String str = TriggerUtils.join(", ", "a", "b", "c");
        assertEquals("a, b, c", str);
    }
}
