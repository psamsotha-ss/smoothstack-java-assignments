package week1assignments;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import core.Argument;
import core.Assignment;
import core.Group;

/**
 * Write the following methods that return a lambda expression performing a specified action:
 * - isOdd()
 * - isPrime()
 * - isPalindrome()
 */
public class Assignment1 implements Assignment {

    public static void main(String... args) {
        System.out.println("-- SEE UNIT TESTS --");
    }

    public static PerformOperation isOdd() {
        return (number) -> Util.isOdd(number) ? "ODD": "EVEN";
    }

    public static PerformOperation isPrime() {
        return (number) -> Util.isPrime(number) ? "PRIME" : "COMPOSITE";
    }

    public static PerformOperation isPalindrome() {
        return (number) -> Util.isPalindrome(number) ? "PALINDROME" : null;
    }

    interface PerformOperation extends Function<Integer, String> {
    }

    static class Util {
        static boolean isOdd(int number) {
            return number % 2 != 0;
        }

        static boolean isPrime(int number) {
            for (int divisor = 2; divisor <= (number/2); divisor++) {
                if (number % divisor == 0) {
                    return false;
                }
            }
            return true;
        }

        static boolean isPalindrome(int number) {
            String str = String.valueOf(number);
            int front = 0;
            int back = str.length() - 1;
            while (back > front) {
                char frontChar = str.charAt(front++);
                char backChar = str.charAt(back--);
                if (frontChar != backChar) {
                    return false;
                }
            }
            return true;
        }
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
        return "Assignment 1";
    }

    @Override
    public String getDetails() {
        return "Write the following methods that return a lambda expression performing a specified action:" + System.lineSeparator() +
                " - isOdd()" + System.lineSeparator() +
                " - isPrime()" + System.lineSeparator() +
                " - isPalindrome()";
    }

    @Override
    public String getUsage() {
        return "-- SEE UNIT TESTS --";
    }

    @Override
    public List<Argument> getArguments() {
        return Collections.emptyList();
    }
}
