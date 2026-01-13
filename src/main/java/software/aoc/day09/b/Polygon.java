package software.aoc.day09.b;

import software.aoc.day09.model.Point;
import software.aoc.day09.model.Rectangle;

import java.util.List;

public final class Polygon {

    private final List<Point> vertices;

    public Polygon(List<Point> vertices) {
        this.vertices = List.copyOf(vertices);
    }

    public boolean containsRectangle(Rectangle rect) {
        return rect.corners().stream().allMatch(this::isPointInsideOrOnBoundary)
                && !intersectsWithRectangleCorners(rect);
    }

    private boolean isPointInsideOrOnBoundary(Point p) {
        boolean inside = false;

        for (int i = 0, j = vertices.size() - 1; i < vertices.size(); j = i++) {
            if (isIntersect(p, getA(i), getA(j))) inside = !inside;
        }
        return inside || isOnBoundary(p);
    }

    private static boolean isIntersect(Point p, Point a, Point b) {
        return ((a.y() > p.y()) != (b.y() > p.y())) &&
                (p.x() <= (long) (b.x() - a.x()) * (p.y() - a.y()) / (b.y() - a.y()) + a.x());
    }

    private boolean isOnBoundary(Point p) {
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

    private boolean intersectsWithRectangleCorners(Rectangle r) {
        if (anyCornerIntersectsPolygonEdge(r.corners())) return true;
        return false;
    }

    private boolean anyCornerIntersectsPolygonEdge(List<Point> corners) {
        for (int i = 0; i < vertices.size(); i++) {
            if (doesAnyCornerIntersectEdge(corners, getA(i),
                    getB(i))) return true;
        }
        return false;
    }

    private boolean doesAnyCornerIntersectEdge(List<Point> corners, Point p1, Point p2) {
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
