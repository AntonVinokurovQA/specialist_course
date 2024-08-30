package labfour;

import labfourfiles.WordCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {
    @TempDir
    Path tempDir;
    @Test
    public void testCountWordsWithTestString() {
        WordCount wc = new WordCount("nonexistentfile.txt", null);
        wc.countWords();
        Map<String, Integer> words = wc.getWords();

        assertAll("Check word counts with default testString",
                () -> assertEquals(2, words.get("test"), "Count for 'test'"),
                () -> assertEquals(1, words.get("11231314dsjk"), "Count for '11231314dsjk'"),
                () -> assertEquals(1, words.get("dskdj"), "Count for 'dskdj'"),
                () -> assertEquals(1, words.get("dsajd"), "Count for 'dsajd'"),
                () -> assertEquals(1, words.get("psod"), "Count for 'psod'")
        );
    }

    @Test
    public void testFileNotFound() {
        // File does not exist, so testString should be used
        WordCount wc = new WordCount("nonexistentfile.txt", null);
        wc.countWords();
        Map<String, Integer> words = wc.getWords();

        assertAll("Check word counts when file is not found",
                () -> assertEquals(2, words.get("test"), "Count for 'test'"),
                () -> assertEquals(1, words.get("11231314dsjk"), "Count for '11231314dsjk'"),
                () -> assertEquals(1, words.get("dskdj"), "Count for 'dskdj'"),
                () -> assertEquals(1, words.get("dsajd"), "Count for 'dsajd'"),
                () -> assertEquals(1, words.get("psod"), "Count for 'psod'")
        );
    }

    @Test
    public void testCountWordsFromFile() throws IOException {
        // Create a temporary file with some test content
        File inputFile = tempDir.resolve("input.txt").toFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
            writer.println("hello world");
            writer.println("hello java");
        }

        // Count words from the file
        WordCount wc = new WordCount(inputFile.getAbsolutePath(), null);
        wc.countWords();
        Map<String, Integer> words = wc.getWords();

        assertAll("Check word counts from file",
                () -> assertEquals(2, words.get("hello"), "Count for 'hello'"),
                () -> assertEquals(1, words.get("world"), "Count for 'world'"),
                () -> assertEquals(1, words.get("java"), "Count for 'java'")
        );
    }
}
