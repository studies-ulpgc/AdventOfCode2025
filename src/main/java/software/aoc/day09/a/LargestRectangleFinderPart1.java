package software.aoc.day09.a;

import java.util.List;

public final class LargestRectangleFinderPart1
        implements LargestRectangleFinder {

    @Override
    public long find(List<Point> points) {
        long max = 0;

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
