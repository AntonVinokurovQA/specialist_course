package labtwo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab2ComLineParserTest {
    @Test
    void testParseWithValidArguments() {
        Lab2ComLineParser test = new Lab2ComLineParser(new String[]{"h", "r", "w"}, new String[]{"-", "+"});

        assertTrue(test.parse(new String[]{"-htest", "+rtest", "-wtest"}));
    }

    @ParameterizedTest
    @CsvSource({
            "'-htest','+wtest','-ptest'",
            "'-htest','+ptest','-wtest'",
            "'-btest','+wtest','-wtest'"
    })
    void testParseWithInvalidKey(String firstArg, String secondArg, String thirdArg) {
        Lab2ComLineParser test = new Lab2ComLineParser(new String[]{"h", "r", "w"}, new String[]{"-", "+"});

        assertFalse(test.parse(new String[]{firstArg, secondArg, thirdArg}));
    }

    @ParameterizedTest
    @CsvSource({
            "'+htest','-wtest','/rtest'",
            "'-htest','+wtest','/rtest'",
            "'/htest','-wtest','+rtest'"
    })
    void testParseWithInvalidDelimiter(String firstArg, String secondArg, String thirdArg) {
        Lab2ComLineParser test = new Lab2ComLineParser(new String[]{"h", "r", "w"});

        assertFalse(test.parse(new String[]{firstArg, secondArg, thirdArg}));
    }

    @Test
    void testParseWithNullArguments() {
        Lab2ComLineParser test = new Lab2ComLineParser(new String[]{"h", "r", "w"});

        assertFalse(test.parse(null));
    }

    @Test
    void testParseWithEmptyArguments() {
        Lab2ComLineParser test = new Lab2ComLineParser(new String[]{"h", "r", "w"});

        assertFalse(test.parse(new String[]{"", "", ""}));
    }
}
