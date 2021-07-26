package week1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment3Test {

    @Test
    public void testDoubling() {
        List<Integer> input = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
        List<Integer> expected = Arrays.asList(-6, -4, -2, 0, 2, 4, 6);
        assertThat(new Assignment3().doubling(input)).isEqualTo(expected);
    }

    @Test
    public void testDoublingWithEmptyList() {
        assertThat(new Assignment3().doubling(new ArrayList<>()))
                .isEqualTo(new ArrayList<>());
    }
}
