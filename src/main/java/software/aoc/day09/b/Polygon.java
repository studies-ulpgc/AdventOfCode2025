package software.aoc.day09.b;

import software.aoc.day09.a.Point;
import software.aoc.day09.a.Rectangle;

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

    /* ---------- Point in polygon (ray casting) ---------- */

    private boolean containsPoint(Point p) {
        boolean inside = false;

        for (int i = 0, j = vertices.size() - 1; i < vertices.size(); j = i++) {
            Point a = vertices.get(i);
            Point b = vertices.get(j);

            // Versión que permite estar sobre el borde
            boolean intersect =
                    ((a.y() > p.y()) != (b.y() > p.y())) &&
                            (p.x() <= (long)(b.x() - a.x()) * (p.y() - a.y()) / (b.y() - a.y()) + a.x());

            if (intersect) inside = !inside;
        }
        return inside || onBoundary(p);
    }

    // Nuevo método que chequea si p está exactamente sobre algún borde
    private boolean onBoundary(Point p) {
        for (int i = 0; i < vertices.size(); i++) {
            Point a = vertices.get(i);
            Point b = vertices.get((i + 1) % vertices.size());

            long cross = (long)(p.y() - a.y()) * (b.x() - a.x()) - (long)(p.x() - a.x()) * (b.y() - a.y());
            if (cross == 0L) { // colineal
                long minX = Math.min(a.x(), b.x()), maxX = Math.max(a.x(), b.x());
                long minY = Math.min(a.y(), b.y()), maxY = Math.max(a.y(), b.y());
                if (p.x() >= minX && p.x() <= maxX && p.y() >= minY && p.y() <= maxY) {
                    return true;
                }
            }
        }
        return false;
    }


    /* ---------- Rectangle vs polygon edges ---------- */

    private boolean intersectsBoundary(Rectangle r) {
        var corners = r.corners();

        for (int i = 0; i < vertices.size(); i++) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % vertices.size());

            for (int j = 0; j < corners.size(); j++) {
                Point r1 = corners.get(j);
                Point r2 = corners.get((j + 1) % corners.size());

                if (segmentsIntersect(p1, p2, r1, r2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean segmentsIntersect(Point a, Point b, Point c, Point d) {
        return orientation(a, b, c) * orientation(a, b, d) < 0 &&
                orientation(c, d, a) * orientation(c, d, b) < 0;
    }

    private int orientation(Point a, Point b, Point c) {
        long value = (long)(b.y() - a.y()) * (c.x() - b.x())
                - (long)(b.x() - a.x()) * (c.y() - b.y());
        return Long.compare(value, 0);
    }
}
