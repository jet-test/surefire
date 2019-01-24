package one.trifle.surefire.bigfailtest;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigFailTest {
    @Test
    public void big() {
        String result = IntStream.range(1, 1_000_000).mapToObj(String::valueOf).collect(Collectors.joining());
        Assert.assertEquals("expected" + result, "actual" + new StringBuilder(result).reverse().toString()
        );
    }

    @Test
    public void small() {
        String result = IntStream.range(1, 10).mapToObj(String::valueOf).collect(Collectors.joining());
        Assert.assertEquals("expected" + result, "actual" + new StringBuilder(result).reverse().toString()
        );
    }
}
