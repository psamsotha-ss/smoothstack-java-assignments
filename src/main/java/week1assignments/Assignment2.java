package week1assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Given a list of non-negative integers, return an integer list of the rightmost digits.
 */
public class Assignment2 implements Assignment {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(10, 100, 320, 1, 323, 12332, 32, 123, 21);
        System.out.println("Original:");
        System.out.println("  " + list);

        List<Integer> rightMostList = new Assignment2().rightMost(list);
        System.out.println("Right most list:");
        System.out.println("  " + rightMostList);
    }

    public List<Integer> rightMost(List<Integer> list) {
        return list.stream()
                .map(num -> {
                    while (num >= 10) {
                        num = num % 10;
                    }
                    return num;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.WEEK_ONE;
    }

    @Override
    public String getName() {
        return "Assignment 2";
    }

    @Override
    public String getDetails() {
        return "Given a list of non-negative integers, return an integer list of the rightmost digits.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes week2assignments.Assignment2";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
