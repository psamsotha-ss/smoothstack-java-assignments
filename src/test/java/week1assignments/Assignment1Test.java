package week1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.junit.Test;

import week1assignments.Assignment1.PerformOperation;

import static org.assertj.core.api.Assertions.assertThat;
import static week1assignments.Assignment1.isOdd;
import static week1assignments.Assignment1.isPalindrome;
import static week1assignments.Assignment1.isPrime;

public class Assignment1Test {

    private static final Map<Integer, PerformOperation> FUNCTIONS;

    static {
        Map<Integer, PerformOperation> functions = new HashMap<>();
        functions.put(1, isOdd());
        functions.put(2, isPrime());
        functions.put(3, Assignment1.isPalindrome());
        FUNCTIONS = Collections.unmodifiableMap(functions);
    }

    public static Iterable<Integer[]> getTestCases() {
        return Arrays.asList(
                new Integer[][] {
                        {1, 4},
                        {2, 5},
                        {3, 898},
                        {1, 3},
                        {2, 12}});
    }

    @Test
    public void testAssignment1() {
        List<String> results = new ArrayList<>();
        for (Integer[] testCase: getTestCases()) {
            Function<Integer, String> function = FUNCTIONS.get(testCase[0]);
            String result = function.apply(testCase[1]);
            if (result != null) {
                results.add(result);
            }
        }
        assertThat(results).isEqualTo(Arrays.asList(
                "EVEN", "PRIME", "PALINDROME", "ODD", "COMPOSITE"
        ));
    }

    @Test
    public void testIsOdd() {
        assertThatNumberIs(0, "EVEN", isOdd());
        assertThatNumberIs(2, "EVEN", isOdd());
        assertThatNumberIs(10, "EVEN", isOdd());

        assertThatNumberIs(1, "ODD", isOdd());
        assertThatNumberIs(3, "ODD", isOdd());
        assertThatNumberIs(9, "ODD", isOdd());
        assertThatNumberIs(11, "ODD", isOdd());
    }

    @Test
    public void testIsPrime() {
        assertThatNumberIs(1, "PRIME", isPrime());
        assertThatNumberIs(2, "PRIME", isPrime());
        assertThatNumberIs(5, "PRIME", isPrime());
        assertThatNumberIs(11, "PRIME", isPrime());
        assertThatNumberIs(37, "PRIME", isPrime());

        assertThatNumberIs(6, "COMPOSITE", isPrime());
        assertThatNumberIs(10, "COMPOSITE", isPrime());
        assertThatNumberIs(16, "COMPOSITE", isPrime());
        assertThatNumberIs(50, "COMPOSITE", isPrime());
        assertThatNumberIs(100, "COMPOSITE", isPrime());
    }

    @Test
    public void testIsPalindrome() {
        assertThatNumberIs(1, "PALINDROME", isPalindrome());
        assertThatNumberIs(11, "PALINDROME", isPalindrome());
        assertThatNumberIs(121, "PALINDROME", isPalindrome());
        assertThatNumberIs(12321, "PALINDROME", isPalindrome());

        assertThatNumberIs(12, null, isPalindrome());
        assertThatNumberIs(122, null, isPalindrome());
        assertThatNumberIs(221, null, isPalindrome());
    }

    private void assertThatNumberIs(int number, String expected, PerformOperation op) {
        String result = op.apply(number);
        assertThat(result).isEqualTo(expected);
    }
}
