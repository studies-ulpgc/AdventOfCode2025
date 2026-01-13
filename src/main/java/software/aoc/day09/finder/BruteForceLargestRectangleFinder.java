package software.aoc.day09.finder;

import software.aoc.day09.model.Rectangle;
import software.aoc.day09.model.Point;

import java.util.List;

public final class BruteForceLargestRectangleFinder
        implements LargestRectangleFinder {

    @Override
    public long findLargestRectangle(List<Point> points) {
        return computeMaxArea(points, 0);
    }

    private static long computeMaxArea(List<Point> points, long max) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                max = Math.max(max, new Rectangle(points.get(i), points.get(j)).area());
            }
        }
        return max;
    }
}
