package javabasics5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Given a list of Strings, write a method that returns a list of all strings
 * that start with the letter 'a' (lower case) and have exactly 3 letters.
 */
public class Assignment1_03 implements Assignment {

    public static void main(String... args) {
        List<String> list = Arrays.asList(
                "apple", "Apple", "ape", "apes", "app", "App",
                "Bape", "grape", "snake", "ack");
        System.out.println("Original:");
        System.out.println("  " + list);

        List<String> filtered = new Assignment1_03().getFilteredStrings(list);
        System.out.println("Filtered:");
        System.out.println("  " + filtered);
    }

    public List<String> getFilteredStrings(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(str -> str.startsWith("a") && str.length() == 3)
                .collect(Collectors.toList());
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
        return "Assignment 1-3";
    }

    @Override
    public String getDetails() {
        return "Given a list of Strings, write a method that returns a list of all strings\n" +
                "that start with the letter 'a' (lower case) and have exactly 3 letters.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics5.Assignment1_03";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
