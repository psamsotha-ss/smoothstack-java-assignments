package week1assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Given a list of integers, return a list where each integer is multiplied by 2.
 */
public class Assignment3 implements Assignment {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original:");
        System.out.println("  " + list);

        List<Integer> doubledList = new Assignment3().doubling(list);
        System.out.println("Doubled:");
        System.out.println("  " + doubledList);
    }


    public List<Integer> doubling(List<Integer> list) {
        return list.stream()
                .map(num -> num * 2)
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
        return "Assignment 3";
    }

    @Override
    public String getDetails() {
        return "Given a list of integers, return a list where each integer is multiplied by 2.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes week1assignments.Assignment3";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
