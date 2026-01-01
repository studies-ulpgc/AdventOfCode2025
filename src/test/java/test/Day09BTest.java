package test;

import org.junit.Test;
import software.aoc.day09.LargestRectangleFinder;
import software.aoc.day09.b.LargestRectangleFinderPart2;
import software.aoc.day09.b.Polygon;
import software.aoc.day09.b.PolygonFactory;
import software.aoc.day09.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09BTest {

    private LargestRectangleFinder finder(List<Point> loop) {
        Polygon polygon = PolygonFactory.fromRedLoop(loop);
        return new LargestRectangleFinderPart2(polygon);
    }

    @Test
    public void given_example_from_statement_should_return_24() {
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

        long area = finder(points).find(points);

        assertThat(area).isEqualTo(24);
    }

    @Test
    public void thin_rectangle_inside_polygon_should_be_valid() {
        List<Point> points = List.of(
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 5),
                new Point(0, 5)
        );

        List<Point> rectangleCorners = List.of(
                new Point(2, 2),
                new Point(2, 3)
        );

        long area = finder(points).find(rectangleCorners);

        assertThat(area).isEqualTo(2);
    }

    @Test
    public void rectangle_crossing_polygon_should_be_rejected() {
        List<Point> loop = List.of(
                new Point(0, 0),
                new Point(6, 0),
                new Point(6, 6),
                new Point(0, 6)
        );

        List<Point> points = List.of(
                new Point(1, 1),
                new Point(7, 7) // outside
        );

        long area = finder(loop).find(points);

        assertThat(area).isZero();
    }
}
