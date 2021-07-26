package week1assignments;

import org.junit.Test;

import week1assignments.Assignment6.SampleSingleton;

import static org.assertj.core.api.Assertions.assertThat;

public class Assignment6Test {

    @Test
    public void testSingletonSingleInstance() {
        assertThat(SampleSingleton.getInstance())
                .isSameAs(SampleSingleton.getInstance());
    }
}
