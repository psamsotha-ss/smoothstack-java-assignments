package javabasics5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment2Test {

    private Assignment2 assignment;

    @Before
    public void setUp() {
        assignment = new Assignment2();
    }

    /**
     * Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
     */
    @Test
    public void testQuestion1() {
        int year = 1981;
        int month = 8;
        int day = 3;
        int hour = 12;
        int minute = 20;
        int second = 10;
        int nanosecond = 100;
        LocalDateTime dateTime = assignment.question_1(year, month, day, hour, minute, second, nanosecond);

        assertThat(dateTime.getYear()).isEqualTo(year);
        assertThat(dateTime.getMonth().getValue()).isEqualTo(month);
        assertThat(dateTime.getDayOfMonth()).isEqualTo(day);
        assertThat(dateTime.getHour()).isEqualTo(hour);
        assertThat(dateTime.getMinute()).isEqualTo(minute);
        assertThat(dateTime.getSecond()).isEqualTo(second);
        assertThat(dateTime.getNano()).isEqualTo(nanosecond);
    }

    /**
     * Given a random date, how would you find the date of the previous Thursday?
     */
    @Test
    public void testQuestion2() {
        LocalDate today = LocalDate.now();
        LocalDate previousThurs = assignment.question_2(today);
        assertDateIsPreviousThursday(today, previousThurs);

        LocalDate thursday = LocalDate.of(2021, 7, 22);
        assertThat(thursday.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
        previousThurs = assignment.question_2(thursday);
        assertDateIsPreviousThursday(thursday, previousThurs);
    }

    private void assertDateIsPreviousThursday(LocalDate date, LocalDate previousThurs) {
        assertThat(previousThurs.getDayOfWeek()).isEqualTo(DayOfWeek.THURSDAY);
        assertThat(previousThurs.isBefore(date)).isTrue();
        assertThat(previousThurs.until(date, ChronoUnit.DAYS)).isLessThanOrEqualTo(7);
    }

    /**
     * What is the difference between a ZoneId and a ZoneOffset?
     */
    @Test
    public void testQuestion3() {
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        ZoneOffset offset = assignment.question_3(zone);
        assertThat(offset.getId()).isEqualTo("-07:00");
    }

    /**
     * How would you convert an Instant to a ZonedDateTime? How would you convert
     * a ZonedDateTime to an Instant?
     */
    @Test
    public void testQuestion4() {
        ZoneId zone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime zdt = assignment.question_4(zone);
        assertThat(zdt.getOffset().getId()).isEqualTo("+09:00");
    }

    /**
     * Write an example that, for a given year, reports the length of each
     * month within that year.
     */
    @Test
    public void testQuestion5() {
        int year = 2021;
        Map<Month, Integer> monthDays = assignment.question_5(year);
        assertThat(monthDays.get(Month.JANUARY)).isEqualTo(31);
        assertThat(monthDays.get(Month.FEBRUARY)).isEqualTo(28);
        assertThat(monthDays.get(Month.MARCH)).isEqualTo(31);
        assertThat(monthDays.get(Month.APRIL)).isEqualTo(30);
        assertThat(monthDays.get(Month.MARCH)).isEqualTo(31);
        assertThat(monthDays.get(Month.JUNE)).isEqualTo(30);
        assertThat(monthDays.get(Month.JULY)).isEqualTo(31);
        assertThat(monthDays.get(Month.AUGUST)).isEqualTo(31);
        assertThat(monthDays.get(Month.SEPTEMBER)).isEqualTo(30);
        assertThat(monthDays.get(Month.OCTOBER)).isEqualTo(31);
        assertThat(monthDays.get(Month.NOVEMBER)).isEqualTo(30);
        assertThat(monthDays.get(Month.DECEMBER)).isEqualTo(31);
    }

    /**
     * Write an example that, for a given month of the current year, lists
     * all of the Mondays in that month.
     */
    @Test
    public void testQuestion6() {
        int month = 7;
        List<LocalDate> mondays = assignment.question_6(month);

        assertThat(mondays).isNotEmpty();
        assertThat(mondays).hasSizeGreaterThanOrEqualTo(4);
        for (LocalDate date: mondays) {
            assertThat(date.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
        }
    }

    /**
     * Write an example that tests whether a given date occurs on Friday the 13th.
     */
    @Test
    public void testQuestion7() {
        LocalDate july242021 = LocalDate.of(2021, 7, 24);
        assertThat(assignment.question_7(july242021)).isFalse();

        LocalDate friday13th = LocalDate.of(2020, 11, 13);
        assertThat(assignment.question_7(friday13th)).isTrue();
    }
}
