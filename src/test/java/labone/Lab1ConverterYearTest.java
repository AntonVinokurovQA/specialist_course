package labone;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lab1ConverterYearTest {
    Lab1ConverterYear test1 = new Lab1ConverterYear();

    @ParameterizedTest
    @CsvSource({
            "1999,1,'Jan 1'",
            "1999,91,'Apr 1'",
            "2000,91,'Mar 31'",
            "2000,366,'Dec 31'",
            "1999,386,''",
            "1999,0,''"
    })
    public void testDayToDate(int year, int day, String result) {
        assertEquals(result, test1.getDate(year, day));
    }
}
