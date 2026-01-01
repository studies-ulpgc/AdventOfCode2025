package software.aoc.day09.a;

import software.aoc.day09.LargestRectangleFinder;
import software.aoc.day09.Point;

import java.util.List;

public final class LargestRectangleFinderPart1
        implements LargestRectangleFinder {

    @Override
    public long find(List<Point> points) {
        return getMax(points, 0);
    }

    private static long getMax(List<Point> points, long max) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                max = Math.max(
                        max,
                        RectangleArea.between(points.get(i), points.get(j))
                );
            }
        }
        return max;
    }
}
