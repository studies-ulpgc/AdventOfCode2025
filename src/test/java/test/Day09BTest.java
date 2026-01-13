package test;

import org.junit.Test;
import software.aoc.day09.finder.LargestRectangleFinder;
import software.aoc.day09.finder.PolygonConstrainedRectangleFinder;
import software.aoc.day09.b.Polygon;
import software.aoc.day09.b.PolygonFactory;
import software.aoc.day09.model.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09BTest {

    private LargestRectangleFinder finder(List<Point> loop) {
        Polygon polygon = PolygonFactory.fromRedLoop(loop);
        return new PolygonConstrainedRectangleFinder(polygon);
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

        long area = finder(points).findLargestRectangle(points);

        assertThat(area).isEqualTo(24);
    }
}
