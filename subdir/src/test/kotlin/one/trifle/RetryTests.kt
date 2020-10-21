package one.trifle

import org.junit.jupiter.api.Test
import java.io.File
import org.junit.jupiter.api.Assertions.assertTrue

class RetryTests {
    @Test
    fun test() {
        val file = File("tmp")
        if (file.exists()) {
            file.delete()
        } else {
            file.mkdir()
        }
        assertTrue(!file.exists())
    }
}