package edu.knoldus;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 * test class.
 */
public class OperationsTest {

    /**
     * Object of Operations Class.
     */
    private static Operations operations;

    /**
     * defining setup method.
     */
    @BeforeClass
    public static void setup() {
        operations = new Operations();
    }

    /**
     * testing  getBirthdayWeekDays().
     */
    @Test
    public final void testGetBirthdayWeekDays() {
        List<String> actualResult = operations
                .getBirthdayWeekDays(LocalDate.of(1994, 02, 17));
        List<String> expectedResult;
        String[] days = {"THURSDAY", "FRIDAY", "SATURDAY", "MONDAY",
                "TUESDAY", "WEDNESDAY", "THURSDAY", "SATURDAY", "SUNDAY",
                "MONDAY", "TUESDAY", "THURSDAY", "FRIDAY", "SATURDAY",
                "SUNDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY",
                "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "FRIDAY",
                "SATURDAY"};
        expectedResult = Arrays.asList(days);
        assertEquals("testGetBirthdayWeekDays test case passed",
                 expectedResult, actualResult);

    }

    /**
     * testing getGandhiLifeSeconds().
     */
    @Test
    public final void testGetGandhiLifeSeconds() {
        Long expectedResult = 2471731200L;
        Long actualResult = operations.getGandhiLifeSeconds(
                LocalDate.of(1869, 10, 2),
                LocalDate.of(1948, 1, 30));
        assertEquals("testGetGandhiLifeSeconds test case passes",
                expectedResult, actualResult);
    }

    /**
     * testing getLeapYearList().
     **/
    @Test
    public final void testGetLeapYearList() {
        Year[] leapYears = {
                Year.of(1904), Year.of(1908), Year.of(1912), Year.of(1916),
                Year.of(1920), Year.of(1924), Year.of(1928), Year.of(1932),
                Year.of(1936), Year.of(1940), Year.of(1944), Year.of(1948),
                Year.of(1952), Year.of(1956), Year.of(1960), Year.of(1964),
                Year.of(1968), Year.of(1972), Year.of(1976), Year.of(1980),
                Year.of(1984), Year.of(1988), Year.of(1992), Year.of(1996),
                Year.of(2000), Year.of(2004), Year.of(2008), Year.of(2012),
                Year.of(2016)};
        List<Year> expectedResult = Arrays.asList(leapYears);
        List<Year> actualResult = operations.getLeapYearList(Year.of(1900));
        assertEquals("testGetLeapYearList passed.",
                expectedResult, actualResult);
    }

    /**
     * testing getTimeFromTimeZone().
     */
    @Test
    public final void testGetTimeFromTimeZone() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-mm-dd'T'hh::mm::ss z");
        ZonedDateTime utc = ZonedDateTime.now(ZoneId.of("UTC+0530"));
        String actualResult = operations.getTimeFromTimeZone("UTC+0530");
        String expectedresult = utc.format(formatter).toString();
        assertEquals("testGetTimeFromTimeZone passed",
                expectedresult, actualResult);
    }

    /**
     * defining afterclass method.
     */
    @AfterClass
    public static void tearDown() {
    }
}
