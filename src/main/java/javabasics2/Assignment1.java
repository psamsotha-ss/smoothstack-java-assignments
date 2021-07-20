package javabasics2;

import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Take multiple values from the command line and show the result of adding all of them.
 */
public class Assignment1 implements Assignment {

    public static void main(String... args) {
        int sum = 0;
        for (String arg: args) {
            try {
                int num = Integer.parseInt(arg.trim());
                sum += num;
            } catch (NumberFormatException ex) {
                System.out.println(arg.trim() + " is not a number");
            }
        }

        System.out.println("The total is " + sum);
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.TWO;
    }

    @Override
    public String getName() {
        return "Assignment 1";
    }

    @Override
    public String getDetails() {
        return "Take multiple values from the command line and show the result of adding all of them.";
    }

    @Override
    public String getUsage() {
        return "java -cp target/classes javabasics2.Assignment1";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.singletonList(new Argument(1, "numbers", "(list) space delimited list of numbers", true));
    }
}
