package one.trifle

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Top M Compilation Tests")
class TopMCompilationTests {

    @DisplayName("core test set compile")
    @ParameterizedTest(name = "test({0})")
    @MethodSource("extendedSet")
    fun runTests(str: String) {
    }

    companion object {
        @JvmStatic
        fun extendedSet(): Array<String> = listOf(
                "@types/async",
                "@types/lodash",
                "@types/prop-types",
                "@types/yargs",
                "axios",
                "chalk",
                "moment/moment.d.ts",
                "tslib/tslib.d.ts"
        ).toTypedArray()
    }
}
