package one.trifle.surefire.bigfailtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigFailTest {
    @Test
    public void test() {
        String result = IntStream.range(1, 1_000_000).mapToObj(String::valueOf).collect(Collectors.joining());
        Assert.assertEquals("expected" + result, "actual" + result);
    }
}
