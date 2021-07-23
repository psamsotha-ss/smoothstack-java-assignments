package javabasics4;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

/**
 * Create unit tests for the Line Class (see video).
 *
 * 1. Create a file called LineTest.java.
 * 2. Create tests for the getSlope, getDistance, and parallelTo methods.
 * 3. Because of rounding errors, it is bad practice to test double values for exact equality.
 *    To get around this, you can pass a small value (such as .0001) to assertEquals to be used as a delta.
 */
public class LineTest {

    @Test
    public void testGetSlope() {
        Line line = new Line(1.0, 1.0, 2.0, 2.0);
        assertThat(line.getSlope()).isCloseTo(1.0, Offset.offset(0.0001));
    }

    @Test
    public void testGetSlopeWithEqualXValues() {
        Line line = new Line(1.0, 1.0, 1.0, 2.0);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(line::getSlope);
    }

    @Test
    public void testGetDistance() {
        Line line = new Line(1.0, 1.0, 2.0, 2.0);
        assertThat(line.getDistance()).isCloseTo(1.4142, Offset.offset(0.0001));
    }

    @Test
    public void testParallelTo() {
        Line line1 = new Line(1.0, 1.0, 2.0, 2.0);
        Line line2 = new Line(2.0, 2.0, 3.0, 3.0);
        assertThat(line1.parallelTo(line2)).isTrue();

        line1 = new Line(1.0, 1.0, 2.0, 2.0);
        line2 = new Line(1.0, 2.0, 2.0, 1.0);
        assertThat(line1.parallelTo(line2)).isFalse();
    }
}
