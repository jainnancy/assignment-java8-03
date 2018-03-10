package edu.knoldus;

import java.time.LocalDate;
import java.time.Year;

/**
 * main driver class.
 */
public class Driver {

    /**
     * driver class constructor.
     */
    protected Driver() {

    }

    /**
     * @param args stringargs
     */
    public static void main(final String[] args) {

        /**
         * assignment-1.
         */
        final LocalDate birthDate = LocalDate.of(1994, 02, 17);
        System.out.println("Birth date = " + birthDate);
        System.out.println(new Operations().getBirthdayWeekDays(birthDate));

        /**
         * assignment - 2.
         */
        final String timeZone1 = "UTC";
        final String timeZone2 = "UTC+0530";
        System.out.println("\nTime as per timezone UTC = "
                + new Operations().getTimeFromTimeZone(timeZone1));
        System.out.println("\nTime as per timezone UTC+5:30 = "
                + new Operations().getTimeFromTimeZone(timeZone2));

        /**
         * assignment-3.
         */
        final LocalDate gandhiBirth = LocalDate.of(1869, 10, 2);
        final LocalDate gandhiDeath = LocalDate.of(1948, 1, 30);
        System.out.println("\nTotal no. of seconds Mahatma Gandhi lived is "
                + new Operations()
                .getGandhiLifeSeconds(gandhiBirth, gandhiDeath));

        /**
         * assignment - 4.
         */
        final Year startYear = Year.of(1900);
        System.out.println("\nList of leap years from 1990 "
                + new Operations().getLeapYearList(startYear));

    }
}
