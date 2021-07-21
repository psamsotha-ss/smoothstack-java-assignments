package javabasics1;

import java.util.Collections;
import java.util.List;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write a Java program that prints out the following patterns using loops:
 * ............
 *   *******
 *    *****
 *     ***
 *      *
 */
public class Assignment1_04 implements Assignment {

    private static final int DEFAULT_ROWS = 5;

    public static void main(String... args) {
        int rows = DEFAULT_ROWS;
        if (args.length == 1) {
            try {
                rows = Integer.parseInt(args[0].trim());
            } catch (NumberFormatException ex) {
                System.out.println("'" + args[0] + "' is not an integer.");
                System.out.println("Usage: java -cp target/classes javabasics1.Assignment1_04 <integer>");
                return;
            }
        }

        printStarts(rows);
    }

    private static void printStarts(int numRows) {
        int firstRowStarCount = numRows * 2 - 1;
        int rowStarCount = firstRowStarCount;
        for (int row = 1; row <= numRows; row++) {
            if (row == 1) {
                for (int stars = 0; stars < rowStarCount; stars++) {
                    System.out.print("*");
                }
            } else {
                rowStarCount -= 2;
                int edgeSpaces = (firstRowStarCount - rowStarCount) / 2;
                for (int leftSpace = 0; leftSpace < edgeSpaces; leftSpace++) {
                    System.out.print(" ");
                }
                for (int stars = 0; stars < rowStarCount; stars++) {
                    System.out.print("*");
                }
                for (int rightSpace = 0; rightSpace < edgeSpaces; rightSpace++) {
                    System.out.print(" ");
                }
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
        return "Assignment 1-4";
    }

    @Override
    public String getDetails() {
        return "Write a Java program that prints out the following patterns using loops:\n" +
                "............\n" +
                "  *******\n" +
                "   *****\n" +
                "    ***\n" +
                "     *";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics1.Assignment1_04 <integer>";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.singletonList(new Argument(1, "rows", "(int) number of rows to print"));
    }
}
