package labthree;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ComLineParserBaseTest {
    @Test
    void testParseWithValidArguments() {
        SimpleParser parser = new SimpleParser(new String[]{"?", "r", "w"}, new String[]{"-", "+"});

        parser.parse(new String[]{"-rtest1", "-wtest2"});

        assertAll("Check input and output file",
                () -> assertEquals(parser.getInFile(), "test1"),
                () -> assertEquals(parser.getOutFile(), "test2")
        );
    }

    @Test
    void testParseWithValidArgumentsHelp() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));


        SimpleParser parser = new SimpleParser(new String[]{"?", "r", "w"}, new String[]{"-", "+"});
        parser.parse(new String[]{"-?", "?"});

        System.setOut(originalOut);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("формат ком.строки"));
    }

    @Test
    void testParseWithInValidDelimiter() {
        SimpleParser parser = new SimpleParser(new String[]{"?", "r", "w"}, new String[]{"-", "+"});
        assertFalse(parser.parse(new String[]{"/?"}));
    }

    @Test
    void testParseWithInValidKey() {
        SimpleParser parser = new SimpleParser(new String[]{"?", "r", "w"}, new String[]{"-", "+"});
        assertFalse(parser.parse(new String[]{"-ddd"}));
    }

}
