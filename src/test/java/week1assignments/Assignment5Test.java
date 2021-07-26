package week1assignments;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment5Test {

    @Test
    public void testGroupSumClump() {
        Assignment5 assignment = new Assignment5();

        int[] arr = { 2, 4, 8 };
        assertThat(assignment.groupSumClump(0, arr, 10)).isTrue();

        arr = new int[] { 1, 2, 4, 8, 1 };
        assertThat(assignment.groupSumClump(0, arr, 14)).isTrue();

        arr = new int[] { 2, 4, 4, 8 };
        assertThat(assignment.groupSumClump(0, arr, 14)).isFalse();
    }
}
