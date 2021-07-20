package javabasics1;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * - User is asked to guess a number 1-100. (Program chooses randomly.)
 * - If the guess is within 10 of the correct answer, plus or minus, output the correct answer and exit.
 *      (If the answer is 63, user must guess 53-73.)
 * - If the number is not within 10 of the correct answer, ask the user to keep guessing.
 * - If the user does not succeed within 5 attempts, display, "Sorry," along with the answer and exit.
 */
public class Assignment2 implements Assignment {

    public static void main(String... args) {
        int answer = getRandomNumber();
        System.out.println("Guess a number between 1 and 100");
        System.out.println("--------------------------------");
        Scanner scanner = new Scanner(System.in);

        int attemptsLeft = 5;
        while (attemptsLeft > 0) {
            System.out.println("You have " + attemptsLeft + " guesses.");
            System.out.print("Enter your guess (then hit return)? ");
            String guessInput = scanner.next().trim();
            int guess;
            try {
                guess = Integer.parseInt(guessInput);
            } catch (NumberFormatException ex) {
                System.out.println("'" + guessInput + "' is not a number, silly.");
                continue;
            }
            if (!withinTen(answer, guess)) {
                System.out.println("Nope. Try again.");
            } else {
                if (answer == guess) {
                    System.out.print("You got it.");
                } else {
                    System.out.print("You're close enough.");
                }
                System.out.println(" The answer was " + answer);
                break;
            }
            attemptsLeft--;
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you're out of guesses. The answer was " + answer);
        }
    }

    private static boolean withinTen(int answer, int guess) {
        return Math.abs(answer - guess) <= 10;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
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
        return "Assignment 2";
    }

    @Override
    public String getDetails() {
        return "- User is asked to guess a number 1-100. (Program chooses randomly.)\n" +
                "- If the guess is within 10 of the correct answer, plus or minus, output the correct answer and exit.\n" +
                "     (If the answer is 63, user must guess 53-73.)\n" +
                "- If the number is not within 10 of the correct answer, ask the user to keep guessing.\n" +
                "- If the user does not succeed within 5 attempts, display, \"Sorry,\" along with the answer and exit.";
    }

    @Override
    public String getUsage() {
        return "java -cp target/classes javabasics1.Assignment2";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
