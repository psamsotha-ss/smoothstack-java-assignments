package javabasics5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Basic lambdas. Make an array containing a few Strings. Sort it by
 * - length
 * - reverse length
 * - alphabetically by the first character only
 * - Strings that contain “e” first
 */
public class Assignment1_01 implements Assignment {

    private static final String[] ORIGINAL = {
            "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten" };
    private String[] array = Arrays.copyOf(ORIGINAL, ORIGINAL.length);

    public static void main(String... args) {
        Assignment1_01 assignment = new Assignment1_01();

        System.out.println("Original:");
        System.out.println("  " + Arrays.toString(assignment.getArray()));
        runSortOperation(assignment::sortByLength, "length", assignment);
        runSortOperation(assignment::sortByLengthReversed, "length reversed", assignment);
        runSortOperation(assignment::sortByFirstChar, "first char", assignment);
        runSortOperation(assignment::sortByContainingE, "containing e", assignment);
    }

    private static void runSortOperation(Operation op, String operation, Assignment1_01 assignment) {
        op.run();
        System.out.println("Sorted by " + operation);
        System.out.println("  " + Arrays.toString(assignment.getArray()));
        assignment.resetArray();
    }

    interface Operation {
        void run();
    }

    public void sortByLength() {
        Arrays.sort(getArray(), Utils::compareByLength);
    }

    public void sortByLengthReversed() {
        Arrays.sort(getArray(), Utils::compareByLengthReversed);
    }

    public void sortByFirstChar() {
        Arrays.sort(getArray(), Utils::compareByFirstChar);
    }

    public void sortByContainingE() {
        Arrays.sort(getArray(), Utils::compareByContainingE);
    }

    public String[] getArray() {
        return array;
    }

    public void resetArray() {
        array = Arrays.copyOf(ORIGINAL, ORIGINAL.length);
    }

    static class Utils {

        private Utils() {}

        static int compareByLength(String s1, String s2) {
            return s1.length() - s2.length();
        }

        static int compareByLengthReversed(String s1, String s2) {
            return s2.length() - s1.length();
        }

        static int compareByFirstChar(String s1, String s2) {
            return s1.charAt(0) - s2.charAt(0);
        }

        static int compareByContainingE(String s1, String s2) {
            return s2.contains("e") ? 1 : -1;
        }
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.FIVE;
    }

    @Override
    public String getName() {
        return "Assignment 1-1";
    }

    @Override
    public String getDetails() {
        return "Basic lambdas. Make an array containing a few Strings. Sort it by" + System.lineSeparator() +
                " - length" + System.lineSeparator() +
                " - reverse length" + System.lineSeparator() +
                " - alphabetically by the first character only" + System.lineSeparator() +
                " - strings that contain \"e\" first";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics5.Assignment1_01";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
