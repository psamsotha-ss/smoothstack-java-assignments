package week1assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Given a list of strings, return a list where each string has all its "x" removed.
 */
public class Assignment4 implements Assignment {

    public static void main(String... args) {
        runOperation(Arrays.asList("ax", "bb", "cx"));
        runOperation(Arrays.asList("xxax", "xbxbx", "xxcx"));
    }

    private static void runOperation(List<String> input) {
        System.out.println("Input:");
        System.out.println("  " + input);
        List<String> output = new Assignment4().noX(input);
        System.out.println("Output:");
        System.out.println("  " + output);
    }

    public List<String> noX(List<String> list) {
        return list.stream()
                .map(str -> str.replace("x", ""))
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
        return "Assignment 4";
    }

    @Override
    public String getDetails() {
        return "Given a list of strings, return a list where each string has all its \"x\" removed.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes week1assignments.Assignment4";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
