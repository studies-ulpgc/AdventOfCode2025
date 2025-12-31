package software.aoc.day09.a;

import java.util.List;

public record Rectangle(Point a, Point b) {

    public long width() {
        return Math.abs((long) a.x() - b.x()) + 1;
    }

    public long height() {
        return Math.abs((long) a.y() - b.y()) + 1;
    }

    public long area() {
        return width() * height();
    }

    public List<Point> corners() {
        int minX = Math.min(a.x(), b.x());
        int maxX = Math.max(a.x(), b.x());
        int minY = Math.min(a.y(), b.y());
        int maxY = Math.max(a.y(), b.y());

        return List.of(
                new Point(minX, minY),
                new Point(minX, maxY),
                new Point(maxX, minY),
                new Point(maxX, maxY)
        );
    }
}
