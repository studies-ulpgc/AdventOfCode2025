package software.aoc.day09.b;

import software.aoc.day09.LargestRectangleFinder;
import software.aoc.day09.Point;
import software.aoc.day09.Rectangle;

import java.util.List;

public final class LargestRectangleFinderPart2
        implements LargestRectangleFinder {

    private final Polygon polygon;

    public LargestRectangleFinderPart2(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public long find(List<Point> points) {
        return getMax(points, 0);
    }

    private long getMax(List<Point> points, long max) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if (polygon.contains(getRectangle(points, i, j))) {
                    max = Math.max(max, getRectangle(points, i, j).area());
                }
            }
        }
        return max;
    }

    private static Rectangle getRectangle(List<Point> points, int i, int j) {
        return new Rectangle(points.get(i), points.get(j));
    }
}
