package week1assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment4Test {

    @Test
    public void testNoX() {
        Assignment4 assignment = new Assignment4();

        List<String> input = Arrays.asList("ax", "bb", "cx");
        List<String> expected = Arrays.asList("a", "bb", "c");
        assertThat(assignment.noX(input)).isEqualTo(expected);

        input = Arrays.asList("xxax", "xbxbx", "xxcx");
        expected = Arrays.asList("a", "bb", "c");
        assertThat(assignment.noX(input)).isEqualTo(expected);

        input = Collections.singletonList("x");
        expected = Collections.singletonList("");
        assertThat(assignment.noX(input)).isEqualTo(expected);
    }
}
