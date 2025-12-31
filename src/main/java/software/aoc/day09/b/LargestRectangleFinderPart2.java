package software.aoc.day09.b;

import software.aoc.day09.a.LargestRectangleFinder;
import software.aoc.day09.a.Point;
import software.aoc.day09.a.Rectangle;

import java.util.List;

public final class LargestRectangleFinderPart2
        implements LargestRectangleFinder {

    private final Polygon polygon;

    public LargestRectangleFinderPart2(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public long find(List<Point> points) {
        long max = 0;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {

                Rectangle rect = new Rectangle(points.get(i), points.get(j));

                if (polygon.contains(rect)) {
                    max = Math.max(max, rect.area());
                }
            }
        }
        return max;
    }
}
