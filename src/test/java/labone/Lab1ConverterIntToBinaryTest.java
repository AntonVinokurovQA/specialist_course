package labone;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab1ConverterIntToBinaryTest {
    Lab1ConverterIntToBinary test = new Lab1ConverterIntToBinary();

    @ParameterizedTest
    @CsvSource({
            "0,'00000000 00000000 00000000 00000000'",
            "1,'00000000 00000000 00000000 00000001'",
            "-1,'11111111 11111111 11111111 11111111'",
            "2147483647,'01111111 11111111 11111111 11111111'",
            "-2147483648,'10000000 00000000 00000000 00000000'",
            "255,'00000000 00000000 00000000 11111111'",
            "-255,'11111111 11111111 11111111 00000001'",
            "1024,'00000000 00000000 00000100 00000000'",
            "-1024,'11111111 11111111 11111100 00000000'",
            "123456789,'00000111 01011011 11001101 00010101'",
            "-123456789,'11111000 10100100 00110010 11101011'",
            "536870912,'00100000 00000000 00000000 00000000'",
            "-536870912,'11100000 00000000 00000000 00000000'"
    })
    public void testDayToDate(int input, String result) {
        assertEquals(result, test.getBinary(input));
    }
}
