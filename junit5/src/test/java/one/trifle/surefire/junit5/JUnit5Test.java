package one.trifle.surefire.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5Test {
    @DisplayName("First test")
    @ParameterizedTest
    @ValueSource(strings = {"junit5 1.1", "junit5 1.2"})
    void first(String word) {
        System.out.println(word);
    }

    @DisplayName("Second test")
    @Test
    void second() {
        System.out.println("junit5 2");
    }

    @DisplayName("Third test")
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @CsvSource({"junit5 3.1, true", "junit5 3.2, false"})
    void third(String word, boolean b) {
        System.out.println(word);
    }
}
