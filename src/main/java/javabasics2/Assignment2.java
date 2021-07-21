package javabasics2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import core.Argument;
import core.Assignment;
import core.Group;

public class Assignment2 implements Assignment {

    private static final int DEFAULT_ROWS = 10;
    private static final int DEFAULT_COLS = 10;

    /**
     * Construct a 2D array and find the max number and show its position in the array.
     */
    public static void main(String... args) {
        int[][] arr;
        if (args.length == 2) {
            try {
                int rows = Integer.parseInt(args[0]);
                int cols = Integer.parseInt(args[1]);
                arr = create2dArray(rows, cols);
            } catch (NumberFormatException ex) {
                System.out.println("Only integers allowed: " + Arrays.toString(args));
                return;
            }
        } else {
            arr = create2dArray(DEFAULT_ROWS, DEFAULT_COLS);
        }
        int max = arr[0][0];
        int maxRow = 0;
        int maxCol = 0;
        printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("The max is " + max + ", at [" + maxRow + "," + maxCol + "]");
    }

    private static int[][] create2dArray(int rows, int cols) {
        Random random = new Random();
        final int maxNum = 1000;

        int[][] arr = new int[rows][cols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(maxNum);
            }
        }

        return arr;
    }

    private static void printArray(int[][] arr) {
        System.out.println("[");
        for (int[] innerArr: arr) {
            System.out.println("  " + Arrays.toString(innerArr));
        }
        System.out.println("]");
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
        return "Assignment 2";
    }

    @Override
    public String getDetails() {
        return "Construct a 2D array and find the max number and show its position in the array.";
    }

    @Override
    public String getUsage() {
        return "Usage: java -cp target/classes javabasics2.Assignment2 <rows> <cols>";
    }

    @Override
    public List<Argument> getArguments() {
        return Arrays.asList(
                new Argument(1, "rows", "(int) number of rows in matrix"),
                new Argument(2, "columns", "(int) number of columns in matrix"));
    }
}
