package javabasics5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment1_03Test {

    @Test
    public void testGetFilteredStrings() {
        List<String> list = Arrays.asList(
                "apple", "Apple", "ape", "apes", "app", "App",
                "Bape", "grape", "snake", "ack");
        assertThat(new Assignment1_03().getFilteredStrings(list))
                .isEqualTo(Arrays.asList("ape", "app", "ack"));
    }

    @Test
    public void testGetFilteredStringsWithNull() {
        assertThat(new Assignment1_03().getFilteredStrings(null))
                .isEqualTo(Collections.emptyList());
    }

    @Test
    public void testGetFilteredStringWithEmptyList() {
        assertThat(new Assignment1_03().getFilteredStrings(new ArrayList<>()))
                .isEqualTo(Collections.emptyList());
    }
}
