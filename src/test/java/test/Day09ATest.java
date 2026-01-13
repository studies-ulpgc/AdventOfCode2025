package test;

import org.junit.Test;
import software.aoc.day09.finder.LargestRectangleFinder;
import software.aoc.day09.finder.BruteForceLargestRectangleFinder;
import software.aoc.day09.model.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09ATest {

    private final LargestRectangleFinder finder =
            new BruteForceLargestRectangleFinder();

    @Test
    public void given_example_from_statement_should_return_50() {
        List<Point> points = List.of(
                new Point(7, 1),
                new Point(11, 1),
                new Point(11, 7),
                new Point(9, 7),
                new Point(9, 5),
                new Point(2, 5),
                new Point(2, 3),
                new Point(7, 3)
        );

        long area = finder.findLargestRectangle(points);

        assertThat(area).isEqualTo(50);
    }
}
