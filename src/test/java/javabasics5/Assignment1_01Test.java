package javabasics5;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment1_01Test {

    private Assignment1_01 assignment;

    @Before
    public void setUp() {
        assignment = new Assignment1_01();
    }

    @Test
    public void testSortByLength() {
        assignment.sortByLength();
        assertThat(assignment.getArray())
                .isEqualTo(new String[] {"One", "Two", "Six", "Ten", "Four", "Five", "Nine", "Three", "Seven", "Eight"});
    }

    @Test
    public void testSortByLengthReversed() {
        assignment.sortByLengthReversed();
        assertThat(assignment.getArray())
                .isEqualTo(new String[] {"Three", "Seven", "Eight", "Four", "Five", "Nine", "One", "Two", "Six", "Ten"});
    }

    @Test
    public void testSortByFirstChar() {
        assignment.sortByFirstChar();
        assertThat(assignment.getArray())
                .isEqualTo(new String[] {"Eight", "Four", "Five", "Nine", "One", "Six", "Seven", "Two", "Three", "Ten"});
    }

    @Test
    public void testSortByContainingE() {
        assignment.sortByContainingE();
        assertThat(assignment.getArray())
                .isEqualTo(new String[] {"One", "Three", "Five", "Seven", "Nine", "Ten", "Eight", "Six", "Four", "Two"});
    }
}
