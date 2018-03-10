package edu.knoldus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Class containing methods to perform operstion.
 */
public class Operations {

    /**
     * Current date.
     */
    private final LocalDate currentDate = java.time.LocalDate.now();
    /**
     * current time.
     */
    private final LocalTime currentTime = java.time.LocalTime.now();

    /**
     * @param birthDate birthdate
     * @return list of weeks
     */
    public final List<String> getBirthdayWeekDays(final LocalDate birthDate) {
        List<String> weekDayList = new ArrayList<>();
        Integer date = birthDate.getDayOfMonth();
        Integer month = birthDate.getMonthValue();
        Integer year = birthDate.getYear();
        for (int iterateYear = year;
             iterateYear <= currentDate.getYear(); iterateYear++) {
            weekDayList.add(LocalDate.of(iterateYear, month, date)
                    .getDayOfWeek().toString());
        }
        return weekDayList;
    }

    /**
     *
     * @param timeZone timezone
     * @return time
     */
    public final String getTimeFromTimeZone(final String timeZone) {

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy-mm-dd'T'hh::mm::ss z");
        ZonedDateTime uct = ZonedDateTime.now(ZoneId.of(timeZone));
        return uct.format(formatter);
    }

    /**
     *
     * @param startYear Start year
     * @return List of leap years
     */
    public final List<Year> getLeapYearList(final Year startYear) {
        List<Year> leapYearList = new ArrayList<>();
        for (int year = startYear.getValue();
             year < currentDate.getYear(); year++) {
            if (Year.isLeap(year)) {
                leapYearList.add(Year.of(year));
            }
        }
        return leapYearList;
    }

    /**
     *
     * @param gandhiBirth Mahatma gandhi birth date
     * @param gandhiDeath Mahatma gandhi death date
     * @return No. of seconds gandhi lived.
     */
    public final Long getGandhiLifeSeconds(
            final LocalDate gandhiBirth, final LocalDate gandhiDeath) {

        final Integer secondsInADays = 86400;
        Long totalDays = ChronoUnit.DAYS.between(gandhiBirth, gandhiDeath);
        Long seconds = totalDays * secondsInADays;
        return seconds;
    }
}

