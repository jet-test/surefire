package one.trifle

import org.junit.Assert
import org.junit.Test

class PropertyTest {
    @Test
    fun property() {
        Assert.fail("""
            teamcity.build.tempDir = ${System.getProperty("teamcity.build.tempDir")}
            java.io.tmpdir = ${System.getProperty("java.io.tmpdir")}
        """.trimIndent())
    }
}