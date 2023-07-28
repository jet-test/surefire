package one.trifle.maven.wrapper;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainTest {
    @Test
    public void tempDir() throws IOException {
        final Path temp = Files.createTempFile("", ".tmp");
        System.out.println(temp);
    }
}
