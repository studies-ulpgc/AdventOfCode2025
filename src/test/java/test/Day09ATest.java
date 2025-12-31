package test;

import org.junit.Test;
import software.aoc.day09.a.LargestRectangleFinder;
import software.aoc.day09.a.LargestRectangleFinderPart1;
import software.aoc.day09.a.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09ATest {

    private final LargestRectangleFinder finder =
            new LargestRectangleFinderPart1();

    @Test
    public void given_two_points_should_return_their_rectangle_area() {
        List<Point> points = List.of(
                new Point(2, 5),
                new Point(11, 1)
        );

        long area = finder.find(points);

        assertThat(area).isEqualTo(50);
    }

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

        long area = finder.find(points);

        assertThat(area).isEqualTo(50);
    }

    @Test
    public void given_single_point_should_return_zero() {
        List<Point> points = List.of(
                new Point(1, 1)
        );

        long area = finder.find(points);

        assertThat(area).isZero();
    }

    @Test
    public void should_handle_large_coordinates_without_overflow() {
        List<Point> points = List.of(
                new Point(0, 0),
                new Point(1_000_000, 4_749)
        );

        long area = finder.find(points);

        assertThat(area).isEqualTo(1_000_001L * 4_750L);
    }
}
