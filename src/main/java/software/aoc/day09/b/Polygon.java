package software.aoc.day09.b;

import software.aoc.day09.Point;
import software.aoc.day09.Rectangle;

import java.util.List;

public final class Polygon {

    private final List<Point> vertices;

    public Polygon(List<Point> vertices) {
        this.vertices = List.copyOf(vertices);
    }

    public boolean contains(Rectangle rect) {
        return rect.corners().stream().allMatch(this::containsPoint)
                && !intersectsBoundary(rect);
    }

    private boolean containsPoint(Point p) {
        boolean inside = false;

        for (int i = 0, j = vertices.size() - 1; i < vertices.size(); j = i++) {
            if (isIntersect(p, getA(i), getA(j))) inside = !inside;
        }
        return inside || onBoundary(p);
    }

    private static boolean isIntersect(Point p, Point a, Point b) {
        return ((a.y() > p.y()) != (b.y() > p.y())) &&
                (p.x() <= (long) (b.x() - a.x()) * (p.y() - a.y()) / (b.y() - a.y()) + a.x());
    }

    private boolean onBoundary(Point p) {
        for (int i = 0; i < vertices.size(); i++) {
            if (check_cross(p, getValue(getA(i), p, getB(i)), getA(i), getB(i))) return true;
        }
        return false;
    }

    private Point getB(int i) {
        return getA((i + 1) % vertices.size());
    }

    private Point getA(int i) {
        return vertices.get(i);
    }

    private static boolean check_cross(Point p, long cross, Point a, Point b) {
        if (cross == 0L) {
            long minX = Math.min(a.x(), b.x()), maxX = Math.max(a.x(), b.x());
            long minY = Math.min(a.y(), b.y()), maxY = Math.max(a.y(), b.y());
            if (p.x() >= minX && p.x() <= maxX && p.y() >= minY && p.y() <= maxY) {
                return true;
            }
        }
        return false;
    }

    private boolean intersectsBoundary(Rectangle r) {
        if (check_corners(r.corners())) return true;
        return false;
    }

    private boolean check_corners(List<Point> corners) {
        for (int i = 0; i < vertices.size(); i++) {
            if (check_points(corners, getA(i),
                    getB(i))) return true;
        }
        return false;
    }

    private boolean check_points(List<Point> corners, Point p1, Point p2) {
        for (int j = 0; j < corners.size(); j++) {
            if (segmentsIntersect(p1, p2, corners.get(j), corners.get((j + 1) % corners.size()))) {
                return true;
            }
        }
        return false;
    }

    private boolean segmentsIntersect(Point a, Point b, Point c, Point d) {
        return orientation(a, b, c) * orientation(a, b, d) < 0 &&
                orientation(c, d, a) * orientation(c, d, b) < 0;
    }

    private int orientation(Point a, Point b, Point c) {
        long value = getValue(a, b, c);
        return Long.compare(value, 0);
    }

    private static long getValue(Point a, Point b, Point c) {
        return (long) (b.y() - a.y()) * (c.x() - b.x())
                - (long) (b.x() - a.x()) * (c.y() - b.y());
    }
}
