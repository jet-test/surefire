package one.trifle.surefire;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.fail;

public class CustomTest {
    @Test
    public void test() throws IOException {
        String tmpdir = System.getProperty("java.io.tmpdir");
        final File file = new File(tmpdir, "test.pid");
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            try (final FileWriter writer = new FileWriter(file)) {
                writer.append("1");
            }
        }
        final int count;
        try (final FileReader reader = new FileReader(file)) {
            final char[] buffer = new char[32];
            final int len = reader.read(buffer);
            count = Integer.parseInt(new String(buffer, 0, len));
        }

        if (count == 5) return;

        try (final FileWriter writer = new FileWriter(file)) {
            writer.write((count + 1) + "");
        }
        fail("error " + count);
    }
}
