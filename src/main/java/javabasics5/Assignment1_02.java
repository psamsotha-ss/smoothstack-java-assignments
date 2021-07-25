package javabasics5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Using Java 8 features write a method that returns a comma separated string based
 * on a given list of integers. Each element should be preceded by the letter 'e' if
 * the number is even, and preceded by the letter 'o' if the number is odd
 */
public class Assignment1_02 implements Assignment {

    public static void main(String... args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("List: " + Arrays.toString(nums));
        System.out.println("Result: " + new Assignment1_02().convertToString(nums));
    }

    public String convertToString(int[] nums) {
        if (nums == null) return "";
        return Arrays.stream(nums)
                .mapToObj(num -> (num % 2 == 0) ? "e" + num : "o" + num)
                .collect(Collectors.joining(","));
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
        return "Assignment 1-2";
    }

    @Override
    public String getDetails() {
        return "Using Java 8 features write a method that returns a comma separated string based\n" +
                "on a given list of integers. Each element should be preceded by the letter 'e' if\n" +
                "the number is even, and preceded by the letter 'o' if the number is odd";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics5.Assignment1_02";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
