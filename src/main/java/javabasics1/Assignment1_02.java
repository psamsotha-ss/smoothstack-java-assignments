package javabasics1;

import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write a Java program that prints out the following patterns using loops:
 * ........
 * ****
 * ***
 * **
 * *
 */
public class Assignment1_02 implements Assignment {

    private static final int DEFAULT_ROWS = 5;

    public static void main(String... args) {
        int rows = DEFAULT_ROWS;
        if (args.length == 1) {
            try {
                rows = Integer.parseInt(args[0].trim());
            } catch (NumberFormatException ex) {
                System.out.println("'" + args[0] + "' is not an integer.");
                System.out.println("Usage: java -cp target/classes javabasics1.Assignment1_02 <integer>");
                return;
            }
        }

        printStars(rows);
    }

    private static void printStars(int rows) {
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void run(String... args) {
        main(args);
    }

    @Override
    public Group getGroup() {
        return Group.ONE;
    }

    @Override
    public String getName() {
        return "Assignment 1-2";
    }

    @Override
    public String getDetails() {
        return "Write a Java program that prints out the following patterns using loops:" + System.lineSeparator() +
                "........" + System.lineSeparator() +
                "****" + System.lineSeparator() +
                "***" + System.lineSeparator() +
                "**" + System.lineSeparator() +
                "*";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics1.Assignment1_02 <integer>";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.singletonList(new Argument(1, "rows", "(int) number of rows to print"));
    }
}
