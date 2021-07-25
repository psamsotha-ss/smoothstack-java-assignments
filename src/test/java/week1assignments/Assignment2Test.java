package week1assignments;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment2Test {

    @Test
    public void testRightMost() {
        List<Integer> input = Arrays.asList(10, 100, 320, 1, 323, 12332, 32, 123, 21);
        List<Integer> expected = Arrays.asList(0, 0, 0, 1, 3, 2, 2, 3, 1);
        assertThat(new Assignment2().rightMost(input)).isEqualTo(expected);
    }
}
