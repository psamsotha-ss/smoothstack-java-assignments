package javabasics5;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment1_02Test {

    @Test
    public void testConvertToString() {
        int[] nums = {1, 2, 3, 4, 5};
        assertThat(new Assignment1_02().convertToString(nums))
                .isEqualTo("o1,e2,o3,e4,o5");
    }

    @Test
    public void testConvertToStringWithNull() {
        assertThat(new Assignment1_02().convertToString(null))
                .isEqualTo("");
    }

    @Test
    public void testConvertToStringWithEmptyArray() {
        assertThat(new Assignment1_02().convertToString(new int[0]))
                .isEqualTo("");
    }

    @Test
    public void testConvertToStringAllEven() {
        int[] nums = {2, 4, 6, 8, 10};
        assertThat(new Assignment1_02().convertToString(nums))
                .isEqualTo("e2,e4,e6,e8,e10");
    }

    @Test
    public void testConvertToStringAllOdd() {
        int[] nums = {1, 3, 5, 7, 9};
        assertThat(new Assignment1_02().convertToString(nums))
                .isEqualTo("o1,o3,o5,o7,o9");
    }
}
