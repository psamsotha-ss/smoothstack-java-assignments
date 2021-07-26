package javabasics5;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment2 {

    public static void main(String... args) {
        Assignment2 assignment = new Assignment2();
        // assignment.question_1();
        // assignment.question_2(LocalDate.of(2021, 7, 20));
        // assignment.question_3();
        // assignment.question_4();
        System.out.println(assignment.question_5(2021));
        // assignment.question_6(Month.AUGUST.ordinal());
        // assignment.question_7(LocalDate.now());
        // System.out.println(DayOfWeek.THURSDAY.getValue());
    }

    /**
     * q: Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
     *
     * a: LocalDateTime
     */
    public LocalDateTime question_1(int year, int month, int day, int hour, int minute, int second, int nanosecond) {
        return LocalDateTime.of(year, month, day, hour, minute, second, nanosecond);
    }

    /**
     * q: Given a random date, how would you find the date of the previous Thursday?
     */
    public LocalDate question_2(LocalDate date) {
        int diff = date.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue();
        int days = (diff < 1) ? 7 - Math.abs(diff) : diff;
        return date.minusDays(days);
    }

    /**
     * q: What is the difference between a ZoneId and a ZoneOffset?
     *
     * a: ZoneId is an object representation of a time zone, while ZoneOffset
     *    is the difference between a zone and UTC, e.g. +02:00
     */
    public ZoneOffset question_3(ZoneId zone) {
        return zone.getRules().getOffset(LocalDateTime.now());
    }

    /**
     *  How would you convert an Instant to a ZonedDateTime? How would you convert
     *  a ZonedDateTime to an Instant?
     */
    public ZonedDateTime question_4(ZoneId zone) {
        Instant instant = Instant.now();
        return instant.atZone(zone);
    }

    /**
     * Write an example that, for a given year, reports the length of each
     * month within that year.
     */
    public Map<Month, Integer> question_5(int isoYear) {
        Year year = Year.of(isoYear);
        Map<Month, Integer> monthDays = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            YearMonth month = year.atMonth(i);
            monthDays.put(month.getMonth(), month.getMonth().length(year.isLeap()));
        }
        return monthDays;
    }

    /**
     * Write an example that, for a given month of the current year, lists
     * all of the Mondays in that month.
     */
    public List<LocalDate> question_6(int isoMonth) {
        Year year = Year.now();
        YearMonth month = year.atMonth(isoMonth);
        int daysInMonth = month.lengthOfMonth();
        List<LocalDate> mondays = new ArrayList<>();
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = month.atDay(day);
            if (date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                mondays.add(date);
            }
        }
        return mondays;
    }

    /**
     * Write an example that tests whether a given date occurs on Friday the 13th.
     */
    public boolean question_7(LocalDate date) {
        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)
                && date.getDayOfMonth() == 13) {
            return true;
        } else {
            return false;
        }
    }
}
