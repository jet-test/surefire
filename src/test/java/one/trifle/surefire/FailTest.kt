package one.trifle.surefire

import org.junit.Assert
import org.junit.Test

class FailTest {
    @Test
    fun big() {
        Assert.fail((0..500_000).joinToString(""))
    }
}