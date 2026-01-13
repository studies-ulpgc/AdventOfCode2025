package software.aoc.day09.finder;

import software.aoc.day09.b.Polygon;
import software.aoc.day09.model.Point;
import software.aoc.day09.model.Rectangle;

import java.util.List;

public final class PolygonConstrainedRectangleFinder
        implements LargestRectangleFinder {

    private final Polygon polygon;

    public PolygonConstrainedRectangleFinder(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public long findLargestRectangle(List<Point> points) {
        return computeMaxArea(points, 0);
    }

    private long computeMaxArea(List<Point> points, long max) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (polygon.containsRectangle(createRectangleFromPoints(points, i, j))) {
                    max = Math.max(max, createRectangleFromPoints(points, i, j).area());
                }
            }
        }
        return max;
    }

    private static Rectangle createRectangleFromPoints(List<Point> points, int i, int j) {
        return new Rectangle(points.get(i), points.get(j));
    }
}
